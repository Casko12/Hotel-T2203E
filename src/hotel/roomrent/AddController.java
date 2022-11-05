package hotel.roomrent;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.dao.impls.RoomRentRepository;
import hotel.dao.impls.RoomRepository;
import hotel.entities.Customer;
import hotel.entities.Room;
import hotel.entities.RoomRent;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class  AddController implements Initializable {
    public ComboBox<Room> room;
    public ComboBox<Customer> customer;
    public ComboBox<Customer> id;
    public DatePicker txtDate;


    public static RoomRent addRoomRent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Room> rooms = FXCollections.observableArrayList();
        RoomRepository rr = (RoomRepository) RepositoryFactory.creHotelRepository(RepoType.ROOM);
        rooms.addAll(rr.emptyRoom());
        room.setItems(rooms);
        ObservableList<Customer> cname = FXCollections.observableArrayList();
        CustomerRepository ccrname = (CustomerRepository) RepositoryFactory.creHotelRepository(RepoType.CUSTOMER);
        cname.addAll(ccrname.all());
        customer.setItems(cname);
        ObservableList<Customer> ccmt = FXCollections.observableArrayList();
        CustomerRepository ccrcmt = (CustomerRepository) RepositoryFactory.creHotelRepository(RepoType.CUSTOMER);
        ccmt.addAll(ccrcmt.cmt());
        id.setItems(ccmt);
    }



    public void CheckIn(ActionEvent actionEvent) {
        try {
            Room selectedRoom = room.getSelectionModel().getSelectedItem();
            Customer selectCName = customer.getSelectionModel().getSelectedItem();
            Customer selectCCmt = id.getSelectionModel().getSelectedItem();
            LocalDate dp = txtDate.getValue();
            RoomRentRepository rr =new RoomRentRepository();
            ArrayList<RoomRent> ls = new ArrayList<>();
            ls.addAll(rr.all());
            RoomRent r = new RoomRent(selectedRoom.getId(),selectCName.getId());
            if(rr.create(r)){
                rr.update(r);
                Back();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){}



    }



    public void Back() throws Exception{
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("./roomrent.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("RoomRent List");
        Main.rootStage.setScene(listScene);
    }
}
