package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> getAdsByUserId(long userId);

    void delete(long adId);

    void update(Ad ad);

    Ad findById(long adId);


    List<Ad> searchForAds(String searchedAd);
}
