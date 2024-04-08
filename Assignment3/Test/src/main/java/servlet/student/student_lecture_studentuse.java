package servlet.student;

import dao.Imp.lectureDAOImp;
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

public class student_lecture_studentuse extends HttpServlet {
    private studentDAOImp studentDAOImp = new studentDAOImp();
    private lectureDAOImp lectureDAOImp = new lectureDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieving lectureID and studentID parameters from request
        int lectureID = Integer.parseInt(req.getParameter("lectureID"));
        int studentID = Integer.parseInt(req.getParameter("studentID"));

        // Retrieving lecture and student objects based on IDs
        Lecture lecture = lectureDAOImp.getLectureByID(lectureID);
        Student student = studentDAOImp.getStudentByStudentID_LectureID(studentID,lectureID);

        // Setting lecture and student attributes in session
        req.getSession().setAttribute("currentLecture", lecture);
        req.getSession().setAttribute("lecture_student", student);

        // Forwarding to student_lecture_studentuse.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/page/student_lecture_studentuse.jsp");
        dispatcher.forward(req, resp);
    }
}
