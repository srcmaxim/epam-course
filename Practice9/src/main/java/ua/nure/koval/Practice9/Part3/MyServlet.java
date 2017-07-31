package ua.nure.koval.Practice9.Part3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote")
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("url", req.getRequestURL());
        ServletContext servletContext = getServletContext();
        Object names = servletContext.getAttribute("names");

        req.setAttribute("names", names);
        req.getRequestDispatcher("vote.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sport = req.getParameter("sport");
        String name = req.getParameter("name");
        req.getSession().setAttribute("url", req.getRequestURL());

        if (!Vote.vote(sport, name)) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("name", name);
        req.setAttribute("sports", Vote.SPORTS);
        req.getRequestDispatcher("vote-result.jsp").forward(req, resp);
    }
}