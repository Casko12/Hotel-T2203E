package hotel.room;

import hotel.Main;
import hotel.customer.edit.EditCustomerController;
import hotel.entities.CheckIn;
import hotel.entities.Customer;
import hotel.entities.Room;
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

public class CheckInController implements Initializable {

    public TextField room;
    public DatePicker date;
    public TextField name;
    public TextField cmt;

    public static Room checkInRoom;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(checkInRoom !=null){
            room.setText(checkInRoom.getName());
            room.setEditable(false);
        }


    }

    public void back(ActionEvent actionEvent)throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/hotel/home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }

    public void checkin(ActionEvent actionEvent) {

    }
}
