package com.example.orionstark.barberros.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.orionstark.barberros.config.TagList;
import com.example.orionstark.barberros.config.UrlList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evan on 24/05/18.
 */

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

    public static void getFavorites(String username, final String token) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, UrlList.getFavoriteUrl(username), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Disini olah nanti datanya
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Kalau ada error tangani disini
            }
        }){
            /**
             * Disini kalian masukkan authorization token headernya (Robby :D)
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", token);
                return headers;
            }
        };
    }

    public interface RegisterCallback {
        void onSucceed(String message);
        void onError(String message);
    }
}
