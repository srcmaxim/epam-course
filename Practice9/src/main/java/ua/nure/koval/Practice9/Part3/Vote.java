package ua.nure.koval.Practice9.Part3;


import java.util.*;

public class Vote {

    private static final Map<String, List<String>> SPORTS;

    static {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Football", new ArrayList<String>());
        map.put("Biathlon", new ArrayList<String>());
        map.put("Basketball", new ArrayList<String>());
        SPORTS = Collections.unmodifiableMap(map);
    }

    public static synchronized boolean vote(String sport, String name) {
        List<String> respondents = SPORTS.get(sport);
        if (respondents.contains(name)) {
            return false;
        } else {
            respondents.add(name);
            return true;
        }
    }

}