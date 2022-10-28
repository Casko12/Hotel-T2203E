package hotel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void onToListRoom(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("room/room.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Room");
        Main.rootStage.setScene(listScene);

    }

    public void onToListCustomer(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("customer/list/Customer.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Customer");
        Main.rootStage.setScene(listScene);
    }

    public void onToRoomRent(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("roomrent/roomrent.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Room Rent");
        Main.rootStage.setScene(listScene);
    }
}
