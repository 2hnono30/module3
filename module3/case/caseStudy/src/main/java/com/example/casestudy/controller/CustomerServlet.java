package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.service.CustomerService;
import com.example.casestudy.service.CustomerServiceImplMysql;

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

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet implements Serializable {
    CustomerService customerService;
    @Override
    public void init() throws ServletException {
        customerService = new CustomerServiceImplMysql();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    createCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
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
                    deleteCustomer(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "userCountry":
                break;
            default:
                try {
                    listCustomers(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer1/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer1/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.random() * 10000);
        int idCountry;
        String choice = request.getParameter("idCountry");
        switch (choice){
            case "VN":
                idCountry = 1;
                break;
            case "TQ":
                idCountry = 2;
                break;
            case "HQ":
                idCountry = 3;
                break;
            case "Campuchia":
                idCountry = 4;
                break;
            case "Thai":
                idCountry = 5;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        Customer customer = new Customer(id, name, email, address,idCountry);
        this.customerService.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer1/create.jsp");
        request.setAttribute("message", "New customer was created");
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
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/WEB-INF/customer1/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String choice = request.getParameter("country");
        int country = 0;
        switch (choice){
            case "VN":
                country = 1;
                break;
            case "TQ":
                country = 2;
                break;
            case "HQ":
                country = 3;
                break;
            case "Campuchia":
                country = 4;
                break;
            case "Thai":
                country = 5;
                break;
        }
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setIdCountry(country);
            this.customerService.update(id, customer);
            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("/WEB-INF/customer1/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        List<Customer> listCustomer = customerService.findAll();
        request.setAttribute("customers", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer1/list.jsp");
        dispatcher.forward(request, response);
    }
}
