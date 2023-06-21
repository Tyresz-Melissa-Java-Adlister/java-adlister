package dao;

import dao.Ads;
import dao.MySQLAdsDao;

public class DaoFactory {
    private static Config config = new Config();

    public static Ads getAdsDao() {
        return new MySQLAdsDao(config);
    }
}
