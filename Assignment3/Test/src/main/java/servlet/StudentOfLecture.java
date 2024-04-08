package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.Imp.studentDAOImp;
import dao.Imp.lectureDAOImp;
import pojo.Lecture;
import pojo.Student;

public class StudentOfLecture extends HttpServlet {
    private studentDAOImp studentDAOImp = new studentDAOImp();
    private lectureDAOImp lectureDAOImp = new lectureDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieving lectureID parameter from request
        int lectureID = Integer.parseInt(req.getParameter("lectureID"));

        // Getting lecture and student list based on lectureID
        Lecture lecture = lectureDAOImp.getLectureByID(lectureID);
        List<Student> studentList = studentDAOImp.getStudentListBylectureID(lectureID);

        // Setting lecture and student list in session attributes
        req.getSession().setAttribute("currentLecture", lecture);
        req.getSession().setAttribute("lecture_studentList", studentList);

        // Forwarding request to student_lecture_teacheruse.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/page/student_lecture_teacheruse.jsp");
        dispatcher.forward(req, resp);
    }
}
