package hotel.roomrent.after;

import hotel.Main;
import hotel.dao.impls.RoomRentRepository;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AddAfter implements Initializable {
    public TextField fullname;
    public TextField cmt;

    public static RoomRent addafter;
    public TableView<RoomRent> tbAfter;
    public TableColumn< RoomRent,String > name;
    public TableColumn< RoomRent,String > id;
    public TableColumn<RoomRent, Date> in;
    public TableColumn<RoomRent, Date> out;
    public static ObservableList<RoomRent> list = FXCollections.observableArrayList();


    @Override
        public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<RoomRent, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<RoomRent, String>("cmt"));
        in.setCellValueFactory(new PropertyValueFactory<RoomRent, Date>("datein"));
        out.setCellValueFactory(new PropertyValueFactory<RoomRent, Date>("dateout"));
        ObservableList <RoomRent> ls = FXCollections.observableArrayList();
        RoomRentRepository rr = (RoomRentRepository) RepositoryFactory.creHotelRepository(RepoType.ROOMRENT);
        ls.addAll(rr.all());
        tbAfter.setItems(ls);
    }
    public void add(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("../roomrent.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("Add After Checkin");
        Main.rootStage.setScene(listScene);
    }

}
