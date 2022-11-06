package hotel.entities;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.dao.impls.RoomRepository;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import hotel.roomrent.after.AddAfterCheckin;
import hotel.roomrent.checkout.CheckOutController;
import hotel.roomrent.edit.EditRoomRentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.ArrayList;

public class RoomRent {
    public Integer roomId;
    public Integer customerId;
    public LocalDate datein;
    public LocalDate dateout;
    public Button edit;
    public Button addat;

    public Button checkout;

    private String roomName;
    private String customerName;
    public static ArrayList<RoomRent> roomRents;
    public RoomRent(Integer roomId, Integer customerId, LocalDate datein, LocalDate dateout) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.datein = datein;
        this.dateout = dateout;
        this.edit = new Button("Edit");
        this.addat = new Button("Addafter");
        this.checkout = new Button("checkout");

        this.edit.setOnAction((event) ->{
            try {
                EditRoomRentController.editedRoomRent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/edit/editroomrent.fxml"));
                Main.rootStage.setTitle("EditRoomRent");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );

        this.addat.setOnAction((event) ->{
            try {
                AddAfterCheckin.addafter = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../roomrent/after/addaftercheckin.fxml"));
                Main.rootStage.setTitle("AddAfterChekin");
                Main.rootStage.setScene(new Scene(edit,800,600));

            }catch (Exception e){}
        } );

        this.checkout.setOnAction(event -> {
            try {
                CheckOutController.checkout = this;
                Parent listToRoomRent = FXMLLoader.load(getClass().getResource("../roomrent/checkout/checkout.fxml"));
                Scene listScene = new Scene(listToRoomRent, 800, 600);
                Main.rootStage.setTitle("RoomRent List");
                Main.rootStage.setScene(listScene);

            }catch (Exception e){}
        });
    }
    public RoomRent() {
    }

    public RoomRent(Integer roomId, Integer customerId ) {
        this.roomId = roomId;
        this.customerId = customerId;

    }

    public Button getAddat() {return addat;}

    public Button getEdit() {
        return edit;
    }

    public LocalDate getDatein() {
        return datein;
    }

    public void setDatein(LocalDate datein) {
        this.datein = datein;
    }

    public LocalDate getDateout() {
        return dateout;
    }

    public Button getCheckout() {
        return checkout;
    }

    public void setCheckout(Button checkout) {
        this.checkout = checkout;
    }

    public void setDateout(LocalDate dateout) {
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

