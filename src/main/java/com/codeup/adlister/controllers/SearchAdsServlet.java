package com.codeup.adlister.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;



@WebServlet(name = "controllers.SearchAdsServlet", urlPatterns = "/search")
public class SearchAdsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/search_ads.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searched_ad = request.getParameter("search");

        // Perform the search operation using the searched_ad parameter
        // and retrieve the search results from your data source
        List<Ad> searchResults = DaoFactory.getAdsDao().searchForAds(searched_ad);
        request.setAttribute("searched_ads", searchResults);
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request, response);
    }

}

