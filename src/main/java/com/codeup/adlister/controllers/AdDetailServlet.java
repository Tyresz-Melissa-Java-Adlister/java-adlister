package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdDetailServlet", urlPatterns = "/ad/details")
public class AdDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adIdParam = request.getParameter("id");
        if (adIdParam == null) {
            // Redirect to the ads index page if the ad ID is not provided
            response.sendRedirect("/ads");
            return;
        }

        try {
            long adId = Long.parseLong(adIdParam);
            Ad ad = DaoFactory.getAdsDao().findById(adId);
            if (ad == null) {
                // Redirect to the ads index page if the ad ID does not exist
                response.sendRedirect("/ads");
                return;
            }
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/ads/details.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Redirect to the ads index page if the ad ID is not a valid long value
            response.sendRedirect("/ads");
        }
    }
}
