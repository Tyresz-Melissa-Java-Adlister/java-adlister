package com.codeup.adlister.dao;

import javax.servlet.jsp.jstl.core.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) usersDao = new MySQLUsersDao(config);
        return usersDao;
    }

    public static void setConfig(Config config) {
        DaoFactory.config = config;
    }
}

