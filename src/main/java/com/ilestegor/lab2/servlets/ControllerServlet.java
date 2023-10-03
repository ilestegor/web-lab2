package com.ilestegor.lab2.servlets;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Objects;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.nonNull(req.getParameter("function"))){
            log("Received request: " + req.getParameter("function"));
            if (req.getParameter("function").equals("clear")){
                req.getRequestDispatcher("/clear").forward(req, resp);
            }
            else {
                req.getRequestDispatcher("/check").forward(req, resp);
            }
        }
    }
}
