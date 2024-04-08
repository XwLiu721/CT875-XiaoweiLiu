package servlet.teacher;

import pojo.Lecture;
import pojo.Teacher;
import dao.Imp.teacherDAOImp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class teacherMainPage extends HttpServlet {
   private teacherDAOImp teacherDAOImp = new teacherDAOImp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = (Teacher) req.getSession().getAttribute("currentTeacher");
        if(req.getSession().getAttribute("currentTeacher")==null){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            //获取老师对象 存到当前登录老师中
            teacher = teacherDAOImp.getTeacherByUsernamePassword(username,password);
            if(teacher==null){
                req.getRequestDispatcher("/WEB-INF/noMemberFound.jsp").forward(req, resp);
            }
        }

        List<Lecture> lectureList = teacherDAOImp.getLectureListByTeacher(teacher);
        List<Lecture> lectureList_None = teacherDAOImp.getLectureListByTeacher_None(teacher);

        req.getSession().setAttribute("currentTeacher",teacher);
        req.getSession().setAttribute("teacher_lectureList",lectureList);
        req.getSession().setAttribute("teacher_lectureList_None",lectureList_None);
        // 转发到 JSP 页面
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/teacherMainPage.jsp");
        dispatcher.forward(req, resp);
    }

}
