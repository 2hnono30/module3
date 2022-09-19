package com.example.casestudy.controller;

import com.example.casestudy.model.Country;
import com.example.casestudy.service.CountryService;
import com.example.casestudy.service.CountryServicelmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CountryServlet", urlPatterns = "/countrys")
public class CountryServlet extends HttpServlet implements Serializable {
    CountryService countryServlet;
    CountryService countryService;
    List<Country> countries;

    @Override
    public void init() throws ServletException {
        countryServlet = new CountryServicelmpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    createCountry(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateCountry(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteCountry(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "userCountry":
                break;
            default:
                try {
                    listCountry(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    private void listCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Country> countrys = this.countryServlet.findAllCountry();
        request.setAttribute("countrys", countrys);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/country/countryList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/country/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id = (int)(Math.random() * 10000);
        String country = request.getParameter("country");
        Country country1 = new Country(id,country);
        this.countryServlet.save(country1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/country/create.jsp");
        request.setAttribute("message", "New country was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Country country = this.countryServlet.findByIdCountry(id);
        RequestDispatcher dispatcher;
        if(country == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("country", country);
            dispatcher = request.getRequestDispatcher("/WEB-INF/country/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String country = request.getParameter("country");
        Country country1 = this.countryServlet.findByIdCountry(id);
        RequestDispatcher dispatcher;
        if(country1 == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            country1.setCountry(country);
            this.countryServlet.updateCountry(id, country1);
            request.setAttribute("customer", country1);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("/WEB-INF/country/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        countryServlet.removeCountry(id);
        List<Country> listCountry = countryServlet.findAllCountry();
        request.setAttribute("countrys", listCountry);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/country/country.jsp");
        dispatcher.forward(request, response);
    }
}