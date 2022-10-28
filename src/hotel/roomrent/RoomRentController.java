package hotel.roomrent;

import hotel.Main;
import hotel.dao.impls.RoomRentRepository;
import hotel.entities.RoomRent;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class RoomRentController implements Initializable {

    public TableView<RoomRent> tbRoomRent;
    public TableColumn<RoomRent, Integer> roomName;
    public TableColumn<RoomRent, Integer> customerName;
    public TableColumn<RoomRent, Date> dateIn;
    public TableColumn<RoomRent, Date> dateOut;
    public TableColumn<RoomRent, Integer> status;
    public TableColumn<RoomRent, Button> edit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomName.setCellValueFactory(new PropertyValueFactory<RoomRent, Integer>("roomId"));
        customerName.setCellValueFactory(new PropertyValueFactory<RoomRent, Integer>("customerId"));
        dateIn.setCellValueFactory(new PropertyValueFactory<RoomRent, Date>("datein"));
        dateOut.setCellValueFactory(new PropertyValueFactory<RoomRent, Date>("dateout"));
        status.setCellValueFactory(new PropertyValueFactory<RoomRent, Integer>("status"));
        edit.setCellValueFactory(new PropertyValueFactory<RoomRent, Button>("edit"));

        ObservableList<RoomRent> rr = FXCollections.observableArrayList();
        RoomRentRepository rrr = (RoomRentRepository) RepositoryFactory.creHotelRepository(RepoType.ROOMRENT);
        rr.addAll(rrr.all());
        tbRoomRent.setItems(rr);


    }

    public void onToBackHome() throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/hotel/home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }

}
