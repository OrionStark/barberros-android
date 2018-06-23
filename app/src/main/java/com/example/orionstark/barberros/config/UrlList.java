package com.example.orionstark.barberros.config;

public class UrlList {
    /* Untuk presentasi nanti, kalau mau local network, tinggal ganti base urlnya aja. */
    private static final String baseUrl = "http://192.168.43.34:8080";

    public static final String register_url = UrlList.baseUrl + "/user/register";
    public static final String login = UrlList.baseUrl + "/user/login";
    public static String getFavoriteUrl(String username) {
        return UrlList.baseUrl + "/user/" + username + "/favorites";
    }
    public static final String getBarbers_url = UrlList.baseUrl + "/barber/getbarbers";
}
