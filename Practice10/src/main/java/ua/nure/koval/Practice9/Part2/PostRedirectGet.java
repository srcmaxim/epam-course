package ua.nure.koval.Practice9.Part2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/inputName")
public class PostRedirectGet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            req.getSession().setAttribute("names", new ArrayList<String>());
        }
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("inputName.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List names = (List) req.getSession().getAttribute("names");
        names.add(name);
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("inputResult.jsp");
        requestDispatcher.forward(req, resp);
    }
}
