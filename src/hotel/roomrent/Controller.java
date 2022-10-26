package hotel.roomrent;

import hotel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {
    public void onToBackHome(ActionEvent actionEvent) throws Exception{
        Parent listRoom = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listRoom,800,600));
    }
}
