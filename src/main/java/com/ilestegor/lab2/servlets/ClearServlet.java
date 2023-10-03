package com.ilestegor.lab2.servlets;

import com.ilestegor.lab2.model.HitDataCollectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ClearServlet", value = "/clear")
public class ClearServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HitDataCollectionManager collectionManager = (HitDataCollectionManager) req.getServletContext().getAttribute("collection");
        if (collectionManager != null) {
            req.getServletContext().removeAttribute("collection");
        }
    }
}
