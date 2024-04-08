package servlet.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.Imp.*;
import pojo.Student;

public class adminAddNewStudent extends HttpServlet {
    private studentDAOImp studentDAOImp = new studentDAOImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer age = Integer.parseInt(req.getParameter("age"));
        //New Student
        Student student = new Student(-1,username,password,name,phone,address,age);
        //Update database
        studentDAOImp.addNewStudent(student);
        //forward request
        req.getRequestDispatcher("/adminMainPage").forward(req,resp);
    }
}
