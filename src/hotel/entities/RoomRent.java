package hotel.entities;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.dao.impls.RoomRepository;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import hotel.roomrent.checkout.CheckOutController;
import hotel.roomrent.edit.EditRoomRentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Date;

public class RoomRent {
    public Integer Id;
    public Integer roomId;
    public Integer customerId;
    public Date datein;
    public Date dateout;
    public Button edit;
    public Button addat;
    public Button checkout;

    private String roomName;
    private String customerName;
    public static RoomRent roomRent;

    public RoomRent(Integer Id,Integer roomId, Integer customerId, Date datein, Date dateout) {
        this.Id = Id;
        this.roomId = roomId;
        this.customerId = customerId;
        this.datein = datein;
        this.dateout = dateout;
        this.edit = new Button("Edit");
        this.checkout = new Button("checkout");

        this.edit.setOnAction((event) ->{
            try {
                EditRoomRentController.editedRoomRent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/edit/editroomrent.fxml"));
                Main.rootStage.setTitle("EditRoomRent");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );

        this.checkout.setOnAction((event) ->{
            try {
                if(RoomRent.roomRent != null){
                    RoomRent.roomRent = this;
                }
                CheckOutController.checkout = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/checkout/checkout.fxml"));
                Main.rootStage.setTitle("Checkout");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );


    }

    public RoomRent(Integer roomId, Integer customerId, Date date) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.datein = date;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Button getCheckout() {
        return checkout;
    }

    public void setCheckout(Button checkout) {
        this.checkout = checkout;
    }

    public Customer customer() {
        return ((CustomerRepository) RepositoryFactory.creHotelRepository(RepoType.CUSTOMER)).findOne(this.getCustomerId());
    }
}
//
