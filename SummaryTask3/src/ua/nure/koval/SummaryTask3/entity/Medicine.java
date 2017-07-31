package ua.nure.koval.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

public class Medicine {

    protected String name;
    protected String pharm;
    protected Group group;
    protected List<String> analogs;
    protected List<Version> versions;

    public Medicine(String name, String pharm, Group group, List<String> analogs, List<Version> versions) {
        this.name = name;
        this.pharm = pharm;
        this.group = group;
        this.analogs = analogs;
        this.versions = versions;
    }

    public Medicine() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<String> getAnalogs() {
        if (analogs == null) {
            analogs = new ArrayList<>();
        }
        return this.analogs;
    }

    public List<Version> getVersions() {
        if (versions == null) {
            versions = new ArrayList<>();
        }
        return this.versions;
    }

    @Override
    public String toString() {
        return "\nMedicine{" +
                "\n\tname='" + name + '\'' +
                ", \n\tpharm='" + pharm + '\'' +
                ", \n\tgroup=" + group +
                ", \n\tanalogs=" + analogs +
                ", \n\tversions=" + versions +
                '}';
    }
}
