package servlet.teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.Imp.teacherDAOImp;

public class student_update_lecture_grade extends HttpServlet {
    private teacherDAOImp teacherDAOImp = new teacherDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieving parameters from request
        Integer studentID = Integer.parseInt(req.getParameter("studentID"));
        Integer lectureID = Integer.parseInt(req.getParameter("lectureID"));
        Double quiz = Double.parseDouble(req.getParameter("quiz"));
        Double assignment = Double.parseDouble(req.getParameter("assignment"));
        Double studentFinal = Double.parseDouble(req.getParameter("final"));

        // Updating student grade
        teacherDAOImp.updateStudentGrade(studentID, lectureID, quiz, assignment, studentFinal);

        // Forwarding to StudentOfLecture servlet with lectureID parameter
        req.getRequestDispatcher("/StudentOfLecture?lectureID=" + lectureID.intValue()).forward(req, resp);
    }
}
