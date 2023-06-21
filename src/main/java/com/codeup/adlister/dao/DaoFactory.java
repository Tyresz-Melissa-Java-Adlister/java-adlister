package com.codeup.adlister.dao;

import javax.servlet.jsp.jstl.core.Config;

package dao;

public class DaoFactory {
    public static Ads getAdsDao(Config config) {
        return new MySQLAdsDao(config);
    }

    public static Users getUsersDao(Config config) {
        return new MySQLUsersDao(config);
    }
}

