package hotel.roomrent.edit;

import hotel.Main;
import hotel.entities.RoomRent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditRoomRentController implements Initializable {
    public TextField txtRoom;
    public TextField txtName;
    public TextField txtId;
    public DatePicker txtDate;

    public static RoomRent editedRoomRent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedRoomRent != null){

        }
    }

    public void Add(ActionEvent actionEvent) {
    }

    public void CheckIn(ActionEvent actionEvent) {
    }

    public void CheckOut(ActionEvent actionEvent) {

    }

    public void Back(ActionEvent actionEvent) throws Exception{
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("../roomrent.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("RoomRent List");
        Main.rootStage.setScene(listScene);
    }
}
