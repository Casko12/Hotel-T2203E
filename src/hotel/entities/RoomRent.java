package hotel.entities;

import java.util.Date;

public class RoomRent {
    public String roomnane;
    public String customername;
    public String status;
    public Date datein;
    public Date dateout;

    public RoomRent(String roomnane, String customername, String status, Date datein, Date dateout) {
        this.roomnane = roomnane;
        this.customername = customername;
        this.status = status;
        this.datein = datein;
        this.dateout = dateout;
    }

    public Date getDatein() {
        return datein;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public Date getDateout() {
        return dateout;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

    public String getRoomnane() {
        return roomnane;
    }

    public void setRoomnane(String roomnane) {
        this.roomnane = roomnane;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

