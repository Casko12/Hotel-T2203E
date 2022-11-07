package hotel.roomrent.after;

import hotel.Main;
import hotel.entities.RoomRent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAfter implements Initializable {
    public TextField fullname;
    public TextField cmt;
    public static RoomRent addafter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(addafter != null){
        }
    }

    public void add(ActionEvent actionEvent) {

    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("addaftercheckin.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("Add After Checkin");
        Main.rootStage.setScene(listScene);
    }

}
