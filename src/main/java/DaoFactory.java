public class DaoFactory {
    private static Config config = new Config();

    public static Ads getAdsDao() {
        return new MySQLAdsDao(config);
    }
}
