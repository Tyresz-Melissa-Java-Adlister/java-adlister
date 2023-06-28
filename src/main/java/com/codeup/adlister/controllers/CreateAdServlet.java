package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            // add a return statement to exit out of the entire method.
            return;
        }

        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (title.isEmpty() || description.isEmpty()) {
            // Handle the case when either title or description is empty
            // For example, you can redirect back to the create ad page and display an error message
            response.sendRedirect("/ads/create?error=Please fill in all the fields");
            return;
        }

        User loggedInUser = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                loggedInUser.getId(),
                title,
                description
        );

        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }

}
