package servlet.admin;

import dao.Imp.adminDAOImp;
import pojo.Admin;
import pojo.Lecture;
import pojo.Student;
import pojo.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class adminMainPage extends HttpServlet {
    private adminDAOImp adminDAOImp = new adminDAOImp();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieving current admin from session
        Admin admin = (Admin) req.getSession().getAttribute("currentAdmin");

        // If admin is not in session, trying to authenticate
        if(admin == null){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String role = req.getParameter("role");

            // Getting admin object and storing it in currentAdmin
            admin = adminDAOImp.getStudentByUsernamePassword(username,password);
            if(admin == null){
                // If admin is not found, forwarding to a page indicating no matching member found
                req.getRequestDispatcher("/WEB-INF/noMemberFound.jsp").forward(req, resp);
            }
        }

        // Retrieving student, teacher, and lecture lists
        List<Student> studentList = adminDAOImp.getStudentList();
        List<Teacher> teacherList = adminDAOImp.getTeacherList();
        List<Lecture> lectureList = adminDAOImp.getLectureList();

        // Setting attributes in session
        req.getSession().setAttribute("currentAdmin", admin);
        req.getSession().setAttribute("admin_studentList", studentList);
        req.getSession().setAttribute("admin_teacherList", teacherList);
        req.getSession().setAttribute("admin_lectureList", lectureList);

        // Forwarding to JSP page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminMainPage.jsp");
        dispatcher.forward(req, resp);
    }
}
