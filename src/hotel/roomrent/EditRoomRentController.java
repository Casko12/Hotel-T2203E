package hotel.roomrent;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
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
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditRoomRentController implements Initializable {
    public ComboBox<Room> room;
    public ComboBox<Customer> customer;
    public ComboBox<Customer> id;
    public DatePicker txtDate;

    public static RoomRent editedRoomRent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Add(ActionEvent actionEvent) {
    }

    public void CheckIn(ActionEvent actionEvent) {
    }

    public void CheckOut(ActionEvent actionEvent) {
    }

    public void Back(ActionEvent actionEvent) throws Exception{
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("./roomrent.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("RoomRent List");
        Main.rootStage.setScene(listScene);
    }
}
