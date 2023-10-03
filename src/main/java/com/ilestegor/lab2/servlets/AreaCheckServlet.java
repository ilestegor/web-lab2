package com.ilestegor.lab2.servlets;

import com.ilestegor.lab2.model.Coordinates;
import com.ilestegor.lab2.model.HitData;
import com.ilestegor.lab2.model.HitDataCollectionManager;
import com.ilestegor.lab2.model.HitType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "AreaCheckServlet", value = "/check")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long startExec = System.nanoTime();
        Coordinates coordinates = null;
        HitData hitData = null;
        HitDataCollectionManager hitDataCollectionManager;
        DecimalFormat df = new DecimalFormat("#.###");
        SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-yyyy");

        if (req.getServletContext().getAttribute("collection") == null){
            hitDataCollectionManager = new HitDataCollectionManager();
        } else {
            hitDataCollectionManager = (HitDataCollectionManager) req.getServletContext().getAttribute("collection");
        }
        double x = 0;
        double y = 0;
        double r = 0;
        String result = HitType.WRONG_DATA.getHitArea();
        try {
             x = Double.parseDouble(df.format(Double.parseDouble(req.getParameter("x"))).trim().replace(",", "."));
             y = Double.parseDouble(df.format(Double.parseDouble(req.getParameter("y"))).trim().replace(",", "."));
             r = Double.parseDouble(df.format(Double.parseDouble(req.getParameter("r"))).trim().replace(",", "."));
            if (validate(x, y, r)){
                 result = checkArea(x, y ,r);
            } else {
                result = HitType.WRONG_DATA.getHitArea();
            }
            coordinates = new Coordinates(x, y, r);
            hitData = new HitData(coordinates, dtf.format(new Date()), (double) (System.nanoTime() - startExec) / 1000000, result);
            hitDataCollectionManager.add(hitData);
            getServletContext().setAttribute("collection", hitDataCollectionManager);
            resp.setStatus(307);
        } catch (NumberFormatException ex){
            log("Number Exception");
            resp.setStatus(400);
        }
    }
    private String checkArea(final double x, final double y, final double r){
        if (firstArea(x, y, r)){
            return HitType.FIRST_AREA.getHitArea();
        } else if (secondArea(x, y, r)){
            return HitType.SECOND_AREA.getHitArea();
        } else if (thirdArea(x, y, r)){
            return HitType.THIRD_AREA.getHitArea();
        } else {
            return HitType.MISS.getHitArea();
        }
    }
    private boolean firstArea(final double x, final double y, final double r){
        return y <= r && (x >= 0 && x <= r/2) && y >= 0;
    }
    private boolean secondArea(final double x, final double y, final double r){
        return (x*x + y*y <= r*r) && x <= 0 && y >= 0;
    }
    private boolean thirdArea(final double x, final double y, final double r){
        return (y >= -r - x * 2) && x <= 0 && y <= 0;
    }
    private boolean validate(final double x, final double y, final double r){
        boolean isXValid = x >= -5 && x <= 3;
        boolean isYValid = y >= -5 && y <= 5;
        boolean isRValid = r >= 2 && r <= 5;
        return isXValid && isYValid && isRValid;
    }
}
