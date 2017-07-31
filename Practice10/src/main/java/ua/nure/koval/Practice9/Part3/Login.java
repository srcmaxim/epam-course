package ua.nure.koval.Practice9.Part3;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/testdb");
            Connection connection = ds.getConnection();

            PreparedStatement statement = connection.prepareStatement("select role.name, user.password" +
                    "from epam_project.roles role" +
                    "join epam_project.users user " +
                    "on user.role_id = role.id" +
                    "where user.login = ?");
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String roleDB = rs.getString("role.name");
                String passwordDB = rs.getString("user.password");
                if (passwordDB.equals(password)) {
                    //todo: role
                    switch (roleDB) {
                        case "admin":
                            doAdmin(req, login, roleDB);
                            resp.sendRedirect("/inputName");
                            return;
                        case "user":
                            doUser(req, login, roleDB);
                            resp.sendRedirect("/inputName");
                            return;
                        default:
                            exception(req);
                            resp.sendRedirect("/login");return;
                    }

                }
            }

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void doAdmin(HttpServletRequest req, String login, String role) {
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("role", role);
    }

    private void doUser(HttpServletRequest req, String login, String role) {
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("role", role);
    }

    private void exception(HttpServletRequest req) {

    }
}