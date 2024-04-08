package servlet.student;

import dao.Imp.studentDAOImp;
import pojo.Lecture;
import pojo.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class studentMainPage extends HttpServlet {
    private studentDAOImp studentDAOImp = new studentDAOImp();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieving current student from session
        Student student = (Student) req.getSession().getAttribute("currentStudent");

        // If student is not in session, trying to authenticate
        if(student == null){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String role = req.getParameter("role");

            // Getting student object and storing it in currentStudent
            student = studentDAOImp.getStudentByUsernamePassword(username,password);
            if(student == null){
                // If student is not found, forwarding to a page indicating no matching member found
                req.getRequestDispatcher("/WEB-INF/noMemberFound.jsp").forward(req, resp);
            }
        }

        // Retrieving lecture lists for the student
        List<Lecture> lectureList = studentDAOImp.getLectureListByStudent(student);
        List<Lecture> lectureList_None = studentDAOImp.getLectureListByStudent_None(student);

        // Setting attributes in session
        req.getSession().setAttribute("currentStudent", student);
        req.getSession().setAttribute("student_lectureList", lectureList);
        req.getSession().setAttribute("student_lectureList_None", lectureList_None);

        // Forwarding to JSP page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/studentMainPage.jsp");
        dispatcher.forward(req, resp);
    }

}
