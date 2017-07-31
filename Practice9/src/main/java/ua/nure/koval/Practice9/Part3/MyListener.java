package ua.nure.koval.Practice9.Part3;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;
import java.util.List;

@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        List<String> names = Arrays.asList(sc.getInitParameter("list").split(" "));
        sc.setAttribute("names", names);
    }

    public void contextDestroyed(ServletContextEvent sce) {/* no op */}
}