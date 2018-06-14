package com.example.orionstark.barberros.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.orionstark.barberros.models.User;

public class UserPreference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @SuppressLint("StaticFieldLeak")
    private static UserPreference session;
    private Context context;

    private final String IS_LOGGEDIN_KEY = "user.id.logged.in";
    private final String USERNAME_KEY = "user.username";
    private final String USER_FULLNAME_KEY = "user.full.name";
    private final String USER_EMAIL_KEY = "user.email";
    private final String USER_TOKEN = "user.token";
    private final String USER_NO_TELP = "user.phone.number";

    @SuppressLint("CommitPrefEdits")
    private UserPreference(Context context) {
        this.context = context;
        String PREFERENCE_NAME = "user.preference";
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, 0);
        this.editor = this.sharedPreferences.edit();
    }

    public static UserPreference getInstance(Context context) {
        if ( session == null ) {
            session = new UserPreference(context);
        }
        return session;
    }

    public void createSession(User user) {
        this.editor.putBoolean(IS_LOGGEDIN_KEY, true);
        this.editor.putString(USERNAME_KEY, user.getUsername());
        this.editor.putString(USER_FULLNAME_KEY, user.getFull_name());
        this.editor.putString(USER_EMAIL_KEY, user.getEmail());
        this.editor.putString(USER_TOKEN, user.getToken());
        this.editor.putString(USER_NO_TELP, user.getNo_telp());
        this.editor.commit();
    }

    public void clearPreference() {
        editor.clear();
        editor.commit();
    }

    public User getUser() {

        return new User(
            this.sharedPreferences.getString(USERNAME_KEY, ""),
            this.sharedPreferences.getString(USER_FULLNAME_KEY, ""),
            this.sharedPreferences.getString(USER_NO_TELP, ""),
            this.sharedPreferences.getString(USER_EMAIL_KEY, ""),
            this.sharedPreferences.getString(USER_TOKEN, "")
        );
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGEDIN_KEY, false);
    }
}
