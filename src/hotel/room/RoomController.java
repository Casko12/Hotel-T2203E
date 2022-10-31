package hotel.room;

import hotel.Main;
import hotel.dao.impls.RoomRepository;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomController implements Initializable {
    public TableView<Room> tbRoom;
    public TableColumn<Room,Integer> tId;
    public TableColumn<Room,String> tNameRoom;
    public TableColumn<Room,Integer> tTypeRoom;
    public TableColumn<Room,String> tStatus;
    public TableColumn<Room, Button> tEdit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tNameRoom.setCellValueFactory(new PropertyValueFactory<>("name"));
        tTypeRoom.setCellValueFactory(new PropertyValueFactory<>("type"));
        tStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));
        ObservableList<Room> ls = FXCollections.observableArrayList();
        RoomRepository r = (RoomRepository) RepositoryFactory.creHotelRepository(RepoType.ROOM);
        ls.addAll(r.all());
        tbRoom.setItems(ls);
    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listRoom,800,600));
    }
}
