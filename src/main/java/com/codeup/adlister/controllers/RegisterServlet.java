package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate the submitted information (you can add more validation logic as needed)
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            // Handle validation error, e.g., display an error message
            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        // Create a new user based on the submitted information
        User user = new User();
        Long userId = DaoFactory.getUsersDao().insert(user);

        if (userId != null) {
            // User successfully created, redirect to the login page
            response.sendRedirect("/login");
        } else {
            // Handle user creation error, e.g., display an error message
            request.setAttribute("error", "Failed to create a new user");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
