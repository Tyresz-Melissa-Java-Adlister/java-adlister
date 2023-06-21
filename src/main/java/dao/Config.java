package dao;

import java.sql.Connection;


class Config{

    private Connection connection;
    public String getUrl() {
        return "jdbc:mysql:// studentdb.fulgentcorp.com:3306/cerberus_tyresz?allowPublicKeyRetrieval=true&useSSL=false";
    }
    public String getUser() {
        return "cerberus_tyresz";
    }
    public String getPassword() {
        return "Zlm!$U]pvCd4dkk";
    }

}

