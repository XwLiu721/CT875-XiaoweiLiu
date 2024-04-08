package servlet.admin;

import dao.Imp.lectureDAOImp;
import dao.Imp.studentDAOImp;
import pojo.Lecture;
import pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class adminAddNewLecture extends HttpServlet {
    private lectureDAOImp lectureDAOImp = new lectureDAOImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String semester = req.getParameter("semester");
        //new lecture
        Lecture lecture = new Lecture(-1,name,semester);
        //update database
        lectureDAOImp.addNewLecture(lecture);
//        forward request
        req.getRequestDispatcher("/adminMainPage").forward(req,resp);
    }
}
