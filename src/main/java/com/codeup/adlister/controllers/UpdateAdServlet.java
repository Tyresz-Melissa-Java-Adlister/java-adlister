package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/ad/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ad ID from the request parameters
        long adId = Long.parseLong(request.getParameter("adId"));

        // Fetch the ad object from the database using the ad ID
        Ad ad = DaoFactory.getAdsDao().findById(adId);

        // Retrieve the error message from the request attribute
        String errorMessage = (String) request.getAttribute("error");

        // Pass the ad object and error message to the profile JSP page
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve the updated ad details from the form
        long adId = Long.parseLong(request.getParameter("adId"));
        String newTitle = request.getParameter("updateTitle");
        String newDescription = request.getParameter("updateDescription");

        // Fetch the ad object from the database using the ad ID
        Ad ad = DaoFactory.getAdsDao().findById(adId);

        // Validate the input fields
        if (newTitle.isEmpty() || newDescription.isEmpty()) {
            // Handle the case when either the title or description is empty
            // For example, you can redirect back to the update ad page with an error message
            response.sendRedirect("/profile");
            return;
        }

        // Update the ad details
        ad.setTitle(newTitle);
        ad.setDescription(newDescription);

        // Save the updated ad to the database
        DaoFactory.getAdsDao().update(ad);

        // Redirect back to the profile page
        response.sendRedirect("/profile");
    }

}
