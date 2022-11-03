package hotel.room.datphong;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.entities.CheckIn;
import hotel.entities.Customer;
import hotel.entities.Room;
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

public class CheckInController implements Initializable {
    public TextField txtRoom;
    public ComboBox<Customer> cbCMT;
    public DatePicker dateIn;
    public TextField txtStatus;

    public static Room checkIn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ObservableList<Customer> ls = FXCollections.observableArrayList();
        CustomerRepository cp = (CustomerRepository) RepositoryFactory.creHotelRepository(RepoType.ROOMRENT);
        ls.addAll(cp.all());
        cbCMT.setItems(ls);
    }

    public void OnToBackRoom(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("../room.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listRoom,800,600));
    }

    public void OnToCheckIn(ActionEvent actionEvent) {
    }
}
