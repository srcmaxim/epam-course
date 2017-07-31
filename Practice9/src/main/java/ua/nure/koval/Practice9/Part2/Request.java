package ua.nure.koval.Practice9.Part2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class Request  extends HttpServlet {
    private Logger log = LogManager.getLogger(ua.nure.koval.Practice9.Part1.Calculator.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        req.getSession().setAttribute("url", req.getRequestURL());

        log.debug("/request doGet: text=" + text);
        req.getSession().setAttribute("url", req.getRequestURL());
        resp.setContentType("text/html");
        if (text != null && text.length() > 0) {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("request-res.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("request.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.getSession().setAttribute("r", null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
