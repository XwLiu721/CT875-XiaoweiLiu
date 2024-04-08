package servlet.admin;

import dao.Imp.*;
import pojo.Student;
import pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class adminAddNewTeacher extends HttpServlet {
    private teacherDAOImp teacherDAOImp = new teacherDAOImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Integer age = Integer.parseInt(req.getParameter("age"));
        // new teacher
        Teacher teacher = new Teacher(-1, name, phone, address, age, username, password);

        // update database
        teacherDAOImp.addNewTeacher(teacher);

        // forward request
        req.getRequestDispatcher("/adminMainPage").forward(req, resp);
    }
}
