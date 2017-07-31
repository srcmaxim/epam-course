package ua.nure.koval.Practice9.Part1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/calc")
public class Calculator extends HttpServlet {

    private Logger log = LogManager.getLogger(Calculator.class);

    @Override
    public void init() throws ServletException {
        super.init();

        Properties props = new Properties();
        String level = "DEBUG";
        props.put("log4j.rootLogger", level+", stdlog");
        props.put("log4j.appender.stdlog", "org.apache.log4j.ConsoleAppender");
        props.put("log4j.appender.stdlog.target", "System.out");
        props.put("log4j.appender.stdlog.layout", "org.apache.log4j.PatternLayout");
        props.put("log4j.appender.stdlog.layout.ConversionPattern",
                "%d{HH:mm:ss} %-5p %-25c{1} :: %m%n");
        // Execution logging
        props.put("log4j.logger.com.hp.hpl.jena.arq.info", level);
        props.put("log4j.logger.com.hp.hpl.jena.arq.exec", level);
        // TDB loader
        props.put("log4j.logger.org.apache.jena.tdb.loader", level);
        // Everything else in Jena
        props.put("log4j.logger.com.hp.hpl.jena", level);
        props.put("log4j.logger.org.apache.jena.riot", level);
        // TDB
        // TDB syslog.
        props.put("log4j.logger.TDB", level);
        props.put("log4j.logger.com.hp.hpl.jena.tdb", level);
        props.put("log4j.logger.com.hp.hpl.jena.tdb.transaction", level);
        props.put("log4j.logger.com.hp.hpl.jena.tdb.transaction.NodeTableTrans",
                level);
        props.put("log4j.logger.com.hp.hpl.jena.tdb.transaction.TransactionManager",level);
        props.put("log4j.logger.com.hp.hpl.jena.tdb.transaction.TestTransSystem",level);
        // Joseki server
        props.put("log4j.logger.org.joseki", level);
        LogManager.resetConfiguration();
        PropertyConfigurator.configure(props);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String op = req.getParameter("op");

        req.getSession().setAttribute("url", req.getRequestURL());

        resp.setContentType("text/html");
        if (op != null && op.length() > 0) {
            req.getSession().setAttribute("x", Integer.valueOf(x));
            req.getSession().setAttribute("y", Integer.valueOf(y));
            try {
                resp.getWriter().print("Result: ");
                switch (op) {
                    case "+": {
                        int r = Integer.valueOf(x) + Integer.valueOf(y);
                        req.getSession().setAttribute("r", r);
                        log.debug("/calc doGet: x=" + x + ", y=" + y + ", op=" + op + ", res=" + r);
                        break;
                    }
                    case "-": {
                        int r = Integer.valueOf(x) - Integer.valueOf(y);
                        req.getSession().setAttribute("r", r);
                        log.debug("/calc doGet: x=" + x + ", y=" + y + ", op=" + op + ", res=" + r);
                        break;
                    }
                }
            } catch (Exception e) {
                req.getSession().setAttribute("e", e.getMessage());
                log.debug("/calc doGet: x=" + x + ", y=" + y + ", op=" + op + ", exception=" + e);
            }
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("res.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("calc.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
