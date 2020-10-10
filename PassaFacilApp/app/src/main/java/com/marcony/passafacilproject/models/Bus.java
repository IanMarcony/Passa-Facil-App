package com.marcony.passafacilproject.models;

public class Bus {
    private String date;
    private String hour;
    private String line;



    public Bus(String date, String hour,String line ) {
        this.line = line;
        this.hour = hour;
        this.date = date;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
