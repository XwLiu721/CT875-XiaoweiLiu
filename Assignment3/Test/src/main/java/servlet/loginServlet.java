package servlet;

import dao.studentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    // Initialization method - service function handles all requests - Destruction function

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieving parameters from the request
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        // Redirect based on the role
        if(role.equals("student")){
            // Forwarding to student main page
            req.getRequestDispatcher("/studentMainPage").forward(req,resp);
        }else if(role.equals("teacher")){
            // Forwarding to teacher main page
            req.getRequestDispatcher("/teacherMainPage").forward(req,resp);
        }else if(role.equals("admin")){
            // Forwarding to admin main page
            req.getRequestDispatcher("/adminMainPage").forward(req,resp);
        }else{
            // Forwarding to a page indicating no matching role found
            req.getRequestDispatcher("/WEB-INF/noMemberFound.jsp").forward(req,resp);
        }
    }

}
