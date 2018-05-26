package com.example.orionstark.barberros.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.orionstark.barberros.config.TagList;
import com.example.orionstark.barberros.config.UrlList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by evan on 24/05/18.
 */

public class BarberrosService {
    public static void register(String username,
                                String password,
                                String sec_password,
                                String email,
                                Context context,
                                final RegisterCallback callback) throws JSONException {
        JSONObject params = new JSONObject();
        params.put("username", username);
        params.put("password", password);
        params.put("sec_password", sec_password);
        params.put("email", email);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, UrlList.register_url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if ( response.getBoolean("status") ) {
                        Log.d("RES STRING", response.toString());
                        callback.onSucceed("Anda telah berhasil mendaftar");
                    } else {
                        Log.d("RES STRING", response.toString());
                        callback.onError("Register gagal, periksa kembali inputan anda");
                    }
                } catch (JSONException e) {
                    callback.onError("Terjadi error");
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

    public interface RegisterCallback {
        void onSucceed(String message);
        void onError(String message);
    }
}
