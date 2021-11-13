package com.nightowl;

import java.util.Objects;

public class RiTwo {

    private String rname;
    private String iname;

    public RiTwo(String rname, String iname) {
        this.rname = rname;
        this.iname = iname;
    }



    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    @Override
    public String toString() {
        return "RiTwo{" +
                "rname='" + rname + '\'' +
                ", iname='" + iname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiTwo riTwo = (RiTwo) o;
        return Objects.equals(rname, riTwo.rname) && Objects.equals(iname, riTwo.iname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rname, iname);
    }
}
