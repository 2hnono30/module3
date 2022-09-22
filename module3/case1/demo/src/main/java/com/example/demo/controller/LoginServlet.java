package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.security.UserRoleRequestWrapper;
import com.example.demo.service.StudentServiceImplMysql;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    StudentServiceImplMysql studentServiceImplMysql;

    @Override
    public void init() throws ServletException {
        studentServiceImplMysql = new StudentServiceImplMysql();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "search":
//                    searchName(req, resp);
//                    break;
//                default:
//                    listProducts(req,resp);
//                    break;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userService.checkUsernamePassword(username, password)) {
            // Lưu vô session
//            HttpSession httpSession = req.getSession();
//            httpSession.setAttribute("username", username);
            List<String> roles = new ArrayList<>();
            UserRoleRequestWrapper userRoleRequestWrapper = new UserRoleRequestWrapper(username, roles, req);
            if (username.equals("admin")) {
                roles.add("admin");
                roles.add("editor");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/students");
                requestDispatcher.forward(userRoleRequestWrapper, resp);
            }
            if (username.equals("user")) {
                roles.add("user");
//                listProducts(req,resp);
//                String action = req.getParameter("action");
//                if (action == null) {
//                    action = "";
//                }
//                try {
//                    switch (action) {
//                        case "search":
//                            searchName(req, resp);
//                            break;
//                    }
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/student1/userList.jsp");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users");
                requestDispatcher.forward(userRoleRequestWrapper, resp);
            }
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/student1/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
//private void listProducts(HttpServletRequest request, HttpServletResponse response){
//    try {
//        int count = studentServiceImplMysql.getTotalStudent();
//        int endPage = count/10;
//        if (count % 10 != 0){
//            endPage ++;
//        }
//        request.setAttribute("endPage", endPage) ;
//
//        String indexPage = request.getParameter("index");
//        if (indexPage == null){
//            indexPage ="1";
//        }
//        int index = Integer.parseInt(indexPage);
//        List<Student> studentList = studentServiceImplMysql.pageStudent(index);
//        request.setAttribute("studentList",studentList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/userList.jsp");
//        dispatcher.forward(request,response);
//    } catch (ServletException e) {
//        throw new RuntimeException(e);
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//}
//    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        String name = request.getParameter("txtSearch");
//        int count = this.studentServiceImplMysql.searchCount(name);
//        int endPage = count / 10;
//        if (count % 10 != 0) {
//            endPage++;
//        }
//        request.setAttribute("endPage", endPage);
//        request.setAttribute("search", name);
//
//        if (name.isEmpty()) {
//            try {
//                count = studentServiceImplMysql.getTotalStudent();
//                endPage = count / 10;
//                if (count % 10 != 0) {
//                    endPage++;
//                }
//                request.setAttribute("endPage", endPage);
//
//                String indexPage = request.getParameter("index");
//                if (indexPage == null) {
//                    indexPage = "1";
//                }
//                int index = Integer.parseInt(indexPage);
//                List<Student> studentList = studentServiceImplMysql.pageStudent(index);
//                request.setAttribute("studentList", studentList);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/userList.jsp");
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        } else {
//            String indexPage = request.getParameter("index");
//            if (indexPage == null) {
//                indexPage = "1";
//            }
//            int index = Integer.parseInt(indexPage);
//            List<Student> studentList = studentServiceImplMysql.pageStudentSearch(index, name);
//            request.setAttribute("studentList", studentList);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/userList.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
}

