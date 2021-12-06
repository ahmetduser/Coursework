package com.leipzigevent;

public class VirtualEvent extends Event {

    private String platform;
    private String link;

    public VirtualEvent(String date, String time, int duration, String type, String platform, String link) {
        super(date, time, duration, type);
        this.platform = platform;
        this.link = link;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", VirtualEvent" +
                "platform='" + platform + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
