package hotel.customer.add;

import hotel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCustomerController {
    public void BackToList(ActionEvent actionEvent) throws Exception{
        Parent listAdd = FXMLLoader.load(getClass().getResource("../list/customer.fxml"));
        Scene listScene = new Scene(listAdd, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }
}
