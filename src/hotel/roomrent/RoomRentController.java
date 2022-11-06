package hotel.roomrent;

import hotel.Main;
import hotel.dao.impls.RoomRentRepository;
import hotel.entities.RoomRent;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
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
    public TableColumn<RoomRent, String> roomName;
    public TableColumn<RoomRent, String> customerName;
    public TableColumn<RoomRent, Date> dateIn;
    public TableColumn<RoomRent, Date> dateOut;
    public TableColumn<RoomRent, Button> edit;

    public TableColumn<RoomRent,Button> checkout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomName.setCellValueFactory(new PropertyValueFactory<RoomRent, String>("roomName"));
        customerName.setCellValueFactory(new PropertyValueFactory<RoomRent, String>("customerName"));
        dateIn.setCellValueFactory(new PropertyValueFactory<RoomRent, Date>("datein"));
        dateOut.setCellValueFactory(new PropertyValueFactory<RoomRent, Date>("dateout"));
        edit.setCellValueFactory(new PropertyValueFactory<RoomRent, Button>("edit"));
        checkout.setCellValueFactory(new PropertyValueFactory<>("checkout"));

        RoomRentRepository rr = (RoomRentRepository)RepositoryFactory.creHotelRepository(RepoType.ROOMRENT);
        tbRoomRent.getItems().addAll(rr.all());


    }

    public void onToBackHome() throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/hotel/home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }

    public void add(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/hotel/roomrent/add/add.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }
}
