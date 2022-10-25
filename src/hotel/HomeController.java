package hotel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    public void onToListRoom(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("room/room.fxml"));
        Main.rootStage.setTitle("Room");
        Main.rootStage.setScene(new Scene(listRoom,800,600));

    }

    public void onToListCustomer(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("customer/customer.fxml"));
        Main.rootStage.setTitle("Customer");
        Main.rootStage.setScene(new Scene(listRoom,800,600));
    }
}
