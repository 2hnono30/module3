package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImplMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
@MultipartConfig()
@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet implements Serializable {
    StudentServiceImplMysql studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentServiceImplMysql();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "view":
                    showViewForm(request,response);
                    break;
                case "create":
                    createStudent(request, response);
                    break;
                case "edit":
                    updateStudent(request, response);
                    break;
                case "search":
                    searchName(request, response);
                    break;
                default:
                    listStudentPaging(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "view":
                    showViewForm(request,response);
                    break;
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "search":
                    searchName(request, response);
                    break;
                default:
                    listStudentPaging(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student",student);
            dispatcher = request.getRequestDispatcher("/WEB-INF/student1/view.jsp");
        }try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        List<Student> students = this.studentService.findAll();
//        request.setAttribute("students", students);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/list.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private void listStudentPaging(HttpServletRequest request,HttpServletResponse response){
        try {
            int count = studentService.getTotalStudent();
            int endPage = count/10;
            if (count % 10 != 0){
                endPage ++;
            }
            request.setAttribute("endPage", endPage) ;

            String indexPage = request.getParameter("index");
            if (indexPage == null){
                indexPage ="1";
            }
            int index = Integer.parseInt(indexPage);
            List<Student> studentList = studentService.pageStudent(index);
            request.setAttribute("studentList",studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("txtSearch");
        int count = this.studentService.searchCount(name);
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage++;
        }
        request.setAttribute("endPage", endPage);
        request.setAttribute("search", name);

        if (name.isEmpty()) {
            listStudentPaging(request, response);
        } else {
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            List<Student> studentList = studentService.pageStudentSearch(index, name);
            request.setAttribute("studentList", studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/search.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int) (Math.random() * 10000);
        Part part =request.getPart("image");
        String realPath = request.getServletContext().getRealPath("/image");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write("G:\\module3\\module3\\case1\\demo\\src\\main\\webapp\\assets\\images\\studentImage\\" + filename);
        String image = "/assets/images/studentImage/" + filename;
        Student student = new Student(id, name, dob, phone, email, address,image);
        this.studentService.save(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student1/create.jsp");
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
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("/WEB-INF/student1/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Part part =request.getPart("image");
        String realPath = request.getServletContext().getRealPath("/image");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if(!Files.exists(Paths.get(realPath))){
            Files.createDirectory(Paths.get(realPath));
        }
        part.write("G:\\module3\\module3\\case1\\demo\\src\\main\\webapp\\assets\\images\\studentImage\\" + filename);
        String image = "/assets/images/studentImage/" + filename;

        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            student.setName(name);
            student.setDob(dob);
            student.setPhone(phone);
            student.setEmail(email);
            student.setAddress(address);
            student.setImage(image);

            this.studentService.update(id, student);
            request.setAttribute("student", student);
            request.setAttribute("message", "Student information was updated");
            dispatcher = request.getRequestDispatcher("/WEB-INF/student1/edit.jsp");
        }

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
        studentService.remove(id);
        listStudentPaging(request,response);
    }
}
