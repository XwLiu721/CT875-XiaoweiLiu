package servlet.student;

import dao.Imp.studentDAOImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class studentRegisterLecture extends HttpServlet {
   private studentDAOImp studentDAOImp = new studentDAOImp();
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentID = Integer.parseInt(req.getParameter("studentID"));
        int lectureID = Integer.parseInt(req.getParameter("lectureID"));
        studentDAOImp.registerLecture(studentID,lectureID);
        req.getRequestDispatcher("/studentMainPage").forward(req,resp);

    }
}
