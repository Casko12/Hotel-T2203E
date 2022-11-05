package hotel.entities;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.dao.impls.RoomRepository;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import hotel.roomrent.AddAfterCheckin;
import hotel.roomrent.EditRoomRentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Date;

public class RoomRent {
    public Integer roomId;
    public Integer customerId;
    public Date datein;
    public Date dateout;
    public Button edit;
    public Button addat;

    private String roomName;
    private String customerName;

    public RoomRent(Integer roomId, Integer customerId, Date datein, Date dateout) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.datein = datein;
        this.dateout = dateout;
        this.edit = new Button("Edit");
        this.addat = new Button("Addafter");

        this.edit.setOnAction((event) ->{
            try {
                EditRoomRentController.editedRoomRent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/editroomrent.fxml"));
                Main.rootStage.setTitle("EditRoomRent");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );

        this.addat.setOnAction((event) ->{
            try {
                AddAfterCheckin.addafter = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/addaftercheckin.fxml"));
                Main.rootStage.setTitle("AddAfterChekin");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );
    }
    public RoomRent() {
    }

    public Button getAddat() {return addat;}

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


    public String getRoomName() {
        return this.room().getName();
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public Room room(){
        return ((RoomRepository) RepositoryFactory.creHotelRepository(RepoType.ROOM)).findOne(this.getRoomId());
    }

    public String getCustomerName() {
        return this.customer().getName();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Customer customer(){
        return ((CustomerRepository)RepositoryFactory.creHotelRepository(RepoType.CUSTOMER)).findOne(this.getCustomerId());
    }
}

