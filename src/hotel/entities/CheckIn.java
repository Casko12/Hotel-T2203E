package hotel.entities;

import java.util.Date;

public class CheckIn {
    public String room;
    public String name;
    public String cmt;
    public Date date;

    public CheckIn() {
    }

    public CheckIn(String room, String name, String cmt, Date date) {
        this.room = room;
        this.name = name;
        this.cmt = cmt;
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
//
