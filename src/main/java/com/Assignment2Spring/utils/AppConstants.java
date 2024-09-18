package com.Assignment2Spring.utils;

public class AppConstants {

    //this are the public url access without jwt token
    public static final String[] PUBLIC_URLS = {
            "/auth/generateToken",
            "/auth/register",
            "/h2-console/**",
            "/signin",
            "/login",
            "/register"

    };

    //this is expiry time for jwt token.
    //30 * 60 * 1000
    public static final long JWT_TOKEN_VALIDITY = 30 * 60 * 1000L; // 30 min

    public static final String USER_ROLE = "ROLE_USER";

    public static final String ADMIN_ROLE = "ROLE_ADMIN";

}
