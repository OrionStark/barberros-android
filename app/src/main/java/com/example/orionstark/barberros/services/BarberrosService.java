package com.example.orionstark.barberros.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.orionstark.barberros.config.TagList;
import com.example.orionstark.barberros.config.UrlList;
import com.example.orionstark.barberros.models.Barber;
import com.example.orionstark.barberros.models.User;
import com.example.orionstark.barberros.utils.UserPreference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class BarberrosService {
    public static void register(String username,
                                String password,
                                String sec_password,
                                String email,
                                String fullName,
                                String noTelp,
                                Context context,
                                final RegisterCallback callback) throws JSONException {
        /* Ini parameter bodynya untuk request */
        JSONObject params = new JSONObject();
        params.put("username", username);
        params.put("password", password);
        params.put("sec_password", sec_password);
        params.put("email", email);
        params.put("full_name", fullName);
        params.put("no_telp", noTelp);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST, UrlList.register_url, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    if ( response.getBoolean("status") ) {
                        callback.onSucceed("Anda telah berhasil mendaftar");
                    } else {
                        callback.onError(response.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onError("Error on parsing data. Please contact us if it's happend again.");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               callback.onError(error.getMessage());
            }
        });
        ServiceSingleton.getInstance(context).addRequestToQueue(request, TagList.REGISTER_TAG);
    }

    public static void login(String username, String password, final Context context, final LoginCallback callback) throws JSONException {

        JSONObject params = new JSONObject();
        params.put("password", password);
        params.put("username", username);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST, UrlList.login, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if ( response.getBoolean("status") ) {
                        JSONObject userData = response.getJSONObject("data");
                        UserPreference.getInstance(context).createSession(
                            new User(
                                userData.getString("username"),
                                userData.getString("full_name"),
                                userData.getString("no_telp"),
                                userData.getString("email"),
                                response.getString("token")
                            )
                        );
                        callback.onSucceed(response.getString("message"));
                    } else {
                        callback.onError(response.getString("message"));
                    }
                } catch (JSONException e) {
                    callback.onError("Error while parsing the data.");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if ( error.networkResponse.data != null ) {
                    try {
                        String string = new String( error.networkResponse.data, HttpHeaderParser.parseCharset( error.networkResponse.headers));
                        JSONObject json = new JSONObject(string);
                        if ( json.getString("message") != null ) {
                            callback.onError(json.getString("message"));
                        } else {
                            callback.onError("Something went wrong");
                        }
                    } catch (Exception e) {
                        callback.onError("Something went wrong");
                    }
                } else {
                    if ( error.getMessage() != null ) {
                        callback.onError(error.getMessage());
                    } else {
                        if ( error.getLocalizedMessage() != null ) {
                            callback.onError(error.getLocalizedMessage());
                        } else {
                            callback.onError("Something went wrong");
                        }
                    }
                }
            }
        });

        ServiceSingleton.getInstance(context).addRequestToQueue(request, TagList.LOGIN_TAG);
    }

    public static void getBarbers(final String token, Context context, final ServiceCallback callback) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, UrlList.getBarbers_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if ( response.getBoolean("status") ) {
                        JSONArray data = response.getJSONArray("data");
                        ArrayList<String> services_tmp = new ArrayList<>();
                        ArrayList<String> times_tmp = new ArrayList<>();
                        for ( int i =0; i < data.length(); i++ ) {
                            byte[] decodedString = Base64.decode(data.getJSONObject(i).getString("image"), Base64.DEFAULT);
                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                            for ( int j = 0; j < data.getJSONObject(i).getJSONArray("services").length(); j++ ) {
                                services_tmp.add(data.getJSONObject(j).getJSONArray("services").getString(i));
                            }
                            for ( int k = 0; k < data.getJSONObject(i).getJSONArray("times").length(); k++ ) {
                                times_tmp.add(data.getJSONObject(k).getJSONArray("times").getString(i));
                            }
                            Barber.barbers.add(
                                new Barber(
                                    data.getJSONObject(i).getString("_id"),
                                    data.getJSONObject(i).getString("barber_name"),
                                    times_tmp,
                                    services_tmp,
                                    data.getJSONObject(i).getString("latitude"),
                                    data.getJSONObject(i).getString("longitude"),
                                    data.getJSONObject(i).getString("description"),
                                    data.getJSONObject(i).getString("no_telp"),
                                    decodedByte
                                )
                            );
                            services_tmp.clear();
                            times_tmp.clear();
                        }
                        callback.onSucceed("Data has loaded");
                    } else {
                        callback.onError(response.getString("message"));
                    }
                } catch (JSONException e) {
                    if ( e.getMessage() != null ) {
                        callback.onError(e.getMessage());
                    } else {
                        callback.onError("Data parsing error");
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if ( error.getMessage() != null ) {
                    callback.onError(error.getMessage());
                } else {
                    callback.onError("Unknown error");
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", token);
                return headers;
            }
        };

        ServiceSingleton.getInstance(context).addRequestToQueue(request, TagList.GET_BARBERS_TAG);
    }

    public static void getFavorites(String username, final String token) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, UrlList.getFavoriteUrl(username), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", token);
                return headers;
            }
        };
    }

    /**
     * Interface list untuk callback requestnya
     */
    public interface RegisterCallback {
        void onSucceed(String message);
        void onError(String message);
    }

    public interface LoginCallback {
        void onSucceed(String message);
        void onError(String message);
    }

    public interface ServiceCallback {
        void onSucceed(String message);
        void onError(String message);
    }
}
