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
    public TableColumn<Room,Integer> tStatus;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tId.setCellValueFactory(new PropertyValueFactory<Room,Integer>("id"));
        tNameRoom.setCellValueFactory(new PropertyValueFactory<Room,String>("name"));
        tTypeRoom.setCellValueFactory(new PropertyValueFactory<Room,Integer>("type"));
        tStatus.setCellValueFactory(new PropertyValueFactory<Room,Integer>("statusLable"));
//        tDatPhong.setCellValueFactory(new PropertyValueFactory<Room,Button>("datphong"));
//        tChinhSua.setCellValueFactory(new PropertyValueFactory<Room,Button>("chinhsua"));
        ObservableList<Room> ls = FXCollections.observableArrayList();
        RoomRepository r = (RoomRepository) RepositoryFactory.creHotelRepository(RepoType.ROOM);
        ls.addAll(r.all());
        tbRoom.setItems(ls);
    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listRoom, 600, 400));
    }

    public void gotoRoomRent(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("../roomrent/roomrent.fxml"));
        Main.rootStage.setTitle("RoomRent");
        Main.rootStage.setScene(new Scene(listRoom,800,600));
    }
}
//