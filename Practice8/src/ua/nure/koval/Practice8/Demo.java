package ua.nure.koval.Practice8;

import ua.nure.koval.Practice8.db.DBManager;
import ua.nure.koval.Practice8.db.entity.Group;
import ua.nure.koval.Practice8.db.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Demo {
    //todo close all connections and scanners

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) throws Exception {
        // users  ==> [ivanov]; groups ==> [teamA]

        DBManager dbManager = DBManager.getInstance();

        // Part 1
        dbManager.insertUser(User.createUser("petrov"));
        dbManager.insertUser(User.createUser("obama"));
        printList(dbManager.findAllUsers());
        // users  ==> [ivanov, petrov, obama]

        System.out.println("===========================");

        // Part 2
        dbManager.insertGroup(Group.createGroup("teamB"));
        dbManager.insertGroup(Group.createGroup("teamC"));
        printList(dbManager.findAllGroups());
        // groups ==> [teamA, teamB, teamC]

        System.out.println("===========================");

        // Part 3
        User userPetrov = dbManager.getUser("petrov");
        User userIvanov = dbManager.getUser("ivanov");
        User userObama = dbManager.getUser("obama");

        Group teamA = dbManager.getGroup("teamA");
        Group teamB = dbManager.getGroup("teamB");
        Group teamC = dbManager.getGroup("teamC");

        // method setGroupsForUser must implement transaction!
        dbManager.setGroupsForUser(userIvanov, teamA);
        dbManager.setGroupsForUser(userPetrov, teamA, teamB);
        dbManager.setGroupsForUser(userObama, teamA, teamB, teamC);

        for (User user : dbManager.findAllUsers()) {
            printList(dbManager.getUserGroups(user));
            System.out.println("~~~~~");
        }
        // teamA
        // teamA teamB
        // teamA teamB teamC

        System.out.println("===========================");

        // Part 4

        // on delete cascade!
        dbManager.deleteGroup(teamA);

        // Part 5
        teamC.setName("teamX");
        dbManager.updateGroup(teamC);

        // Part 6
        printList(dbManager.findAllGroups());
        // groups ==> [teamB, teamX]

        try {
            DBManager.getConnection().close();
        } catch (SQLException e) {
            System.out.println("Exception while closing connection");
            e.printStackTrace();
        }
    }

}