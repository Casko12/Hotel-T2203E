package hotel.entities;

import hotel.Main;
import hotel.roomrent.EditRoomRentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Date;

public class RoomRent {
    public Integer roomId;
    public Integer customerId;
    public Integer status;
    public Date datein;
    public Date dateout;
    public Button edit;

    public RoomRent() {
    }

    public RoomRent(Integer roomId, Integer customerId, Integer status, Date datein, Date dateout) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.status = status;
        this.datein = datein;
        this.dateout = dateout;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) ->{
            try {
                EditRoomRentController.editedRoomRent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/editroomrent.fxml"));
                Main.rootStage.setTitle("EditRoomRent");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );
    }

    public Button getEdit() {
        return edit;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomnane) {
        this.roomId = roomId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

