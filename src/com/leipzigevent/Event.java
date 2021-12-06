package com.leipzigevent;

public class Event {

    private String date;
    private String time;
    private int duration;
    private String type;

    public Event(String date, String time, int duration, String type) {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'';
    }
}
