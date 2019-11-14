package com.cd.stmty.util;

public interface Const {

    /**
     * LOG
     */
    String LOG_INFO = "--- Info: ";
    String LOG_RESPONSE = "--- Response: ";
    String LOG_BEGIN_API = "--- Begin API: ";
    String LOG_END_API = "--- End API: ";
    String LOG_BEGIN_SERVICE = "--- Begin Service: ";
    String LOG_END_SERVICE = "--- End Service: ";
    String LOG_ERROR = "--- ERROR: ";


    public static class AuthorizationRoles {
        public static final String ROLE_CC = "ROLE_CC";
        public static final String ROLE_CS = "ROLE_CS";
        public static final String ROLE_SALES = "ROLE_SALES";
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
    }

}
