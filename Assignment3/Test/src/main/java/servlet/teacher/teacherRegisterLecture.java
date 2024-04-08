package servlet.teacher;

import dao.Imp.teacherDAOImp;
import pojo.Lecture;
import pojo.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class teacherRegisterLecture extends HttpServlet {
   private teacherDAOImp teacherDAOImp = new teacherDAOImp();
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int teacherID = Integer.parseInt(req.getParameter("teacherID"));
        int lectureID = Integer.parseInt(req.getParameter("lectureID"));
        teacherDAOImp.registerLecture(teacherID,lectureID);

        req.getRequestDispatcher("/teacherMainPage").forward(req,resp);

    }
}
