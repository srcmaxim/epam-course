package ua.nure.koval.Practice8.db;

import ua.nure.koval.Practice8.db.entity.Group;
import ua.nure.koval.Practice8.db.entity.User;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBManager {
    private static DBManager instance;
    private static Connection connection;
    private static final Lock CONNECTION_LOCK = new ReentrantLock();

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String pass = "root";

    private static final String SQL_INSERT_USER = "INSERT INTO users VALUES (DEFAULT ,?)";
    private static final String SQL_INSERT_GROUP = "INSERT INTO groups VALUES (DEFAULT ,?)";
    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_FIND_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String SQL_FIND_GROUP_BY_NAME = "SELECT * FROM groups WHERE name=?";
    private static final String SQL_INSERT_USER_TO_GROUP = "INSERT INTO users_groups VALUES (?, ?)";
    private static final String SQL_FIND_GROUPS_BY_USER_ID = "SELECT g.id, g.name FROM users_groups ug\n" +
            "JOIN users u ON ug.user_id = u.id\n" +
            "JOIN groups g ON ug.group_id = g.id\n" +
            "WHERE u.id = ?";
    private static final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE name=?";
    private static final String SQL_UPDATE_GROUP = "UPDATE groups SET name=? WHERE id=?";


    public static Connection getConnection() {
        return connection;
    }

    private DBManager(String url, String user, String pass) throws Exception {
        connection = DriverManager.getConnection(url, user, pass);

        executeScript(connection, new FileInputStream("sql/db-create.sql"));
    }

    public static synchronized DBManager getInstance() throws Exception {
        if (instance == null) {
            instance = new DBManager(url, user, pass);
        }
        return instance;
    }

    public boolean insertUser(User user) {
        PreparedStatement ps = null;
        ResultSet id = null;
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            id = ps.getGeneratedKeys();
            if (id.next()) {
                int idField = id.getInt(1);
                user.setId(idField);
            }
        } catch (Exception e) {
            System.out.println("Can't insert user:" + e.getMessage());
            return false;
        } finally {
            close(id);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return true;
    }

    public boolean insertGroup(Group group) {
        PreparedStatement ps = null;
        ResultSet id = null;
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_INSERT_GROUP, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, group.getName());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            id = ps.getGeneratedKeys();
            if (id.next()) {
                int idField = id.getInt(1);
                group.setId(idField);
            }
        } catch (Exception e) {
            System.out.println("Can't insert group:" + e.getMessage());
            return false;
        } finally {
            close(id);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return true;
    }

    public List<User> findAllUsers() {
        Statement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            CONNECTION_LOCK.lock();
            ps = connection.createStatement();
            rs = ps.executeQuery(SQL_FIND_ALL_USERS);
            while (rs.next()) {
                User user = new User();
                users.add(user);
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Can't find all users:" + e.getMessage());
            return Collections.emptyList();
        } finally {
            close(rs);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return users;
    }

    public List<Group> findAllGroups() {
        Statement ps = null;
        ResultSet rs = null;
        List<Group> groups = new ArrayList<>();
        try {
            CONNECTION_LOCK.lock();
            ps = connection.createStatement();
            rs = ps.executeQuery(SQL_FIND_ALL_GROUPS);
            while (rs.next()) {
                Group group = new Group();
                groups.add(group);
                group.setId(rs.getInt(1));
                group.setName(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Can't find all groups:" + e.getMessage());
            return Collections.emptyList();
        } finally {
            close(rs);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return groups;
    }

    public User getUser(String login) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
            }
        } catch (SQLException ex) {
            System.out.println("Can't get User");
        } finally {
            close(rs);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return user;
    }

    public Group getGroup(String name) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Group group = null;
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_FIND_GROUP_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                group = new Group();
                group.setId(rs.getInt("id"));
                group.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("Can't get group");
        } finally {
            close(rs);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return group;
    }

    public boolean setGroupsForUser(User user, Group... groups) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            CONNECTION_LOCK.lock();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SQL_INSERT_USER_TO_GROUP);
            for (Group g : groups) {
                ps.setInt(1, user.getId());
                ps.setInt(2, g.getId());
                ps.addBatch();
            }
            int[] usersGroups = ps.executeBatch();
            for (int i : usersGroups) {
                if (i != 1) {
                    return false;
                }
            }
            connection.commit();
            return true;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Can't set groups");
        } finally {
            close(rs);
            close(ps);
            setAutocommit();
            CONNECTION_LOCK.unlock();
        }
        return false;
    }

    public List<Group> getUserGroups(User user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Group> groups = new ArrayList<>();
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_FIND_GROUPS_BY_USER_ID);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                groups.add(group);
                group.setId(rs.getInt(1));
                group.setName(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Can't get groups:" + e.getMessage());
            return Collections.emptyList();
        } finally {
            close(rs);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return groups;
    }

    public boolean deleteGroup(Group group) {
        PreparedStatement ps = null;
        ResultSet id = null;
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_DELETE_GROUP);
            ps.setString(1, group.getName());
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Can't delete user:" + e.getMessage());
            return false;
        } finally {
            close(id);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return true;
    }

    public boolean updateGroup(Group group) {
        PreparedStatement ps = null;
        ResultSet id = null;
        try {
            CONNECTION_LOCK.lock();
            ps = connection.prepareStatement(SQL_UPDATE_GROUP);
            ps.setString(1, group.getName());
            ps.setInt(2, group.getId());
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Can't update group:" + e.getMessage());
            return false;
        } finally {
            close(id);
            close(ps);
            CONNECTION_LOCK.unlock();
        }
        return true;
    }

    private static void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setAutocommit() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void executeScript(Connection conn, InputStream in) throws SQLException {
        Scanner s = new Scanner(in, "UTF-8");
        s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");
        Statement st = null;
        try {
            st = conn.createStatement();
            while (s.hasNext()) {
                String line = s.next().trim();
                if (!line.isEmpty()) {
                    st.execute(line);
                }
            }
        } finally {
            close(st);
        }
    }
}