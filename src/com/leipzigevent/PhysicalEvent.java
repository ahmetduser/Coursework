package com.leipzigevent;

public class PhysicalEvent extends Event {

    private String location;
    private int capacity;

    public PhysicalEvent(String date, String time, int duration, String type, String location, int capacity) {
        super(date, time, duration, type);
        this.location = location;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", PhysicalEvent" +
                "location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
