package hotel.roomrent.checkout;

import hotel.Main;
import hotel.dao.impls.RoomRentRepository;
import hotel.dao.impls.RoomRepository;
import hotel.entities.Room;
import hotel.entities.RoomRent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable {

    public TextField txtRoomName;
    public DatePicker txtDateOut;

    public static RoomRent checkout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            if (checkout !=null){
                txtRoomName.setText(checkout.getRoomName());
            }
    }

    public void bttBack(ActionEvent actionEvent) throws Exception {
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("../roomrent.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("RoomRent List");
        Main.rootStage.setScene(listScene);
    }

    public void checkOut(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Check Out ");
            alert.setHeaderText("You want to Checkout? "+checkout.getRoomName());
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get()==ButtonType.OK){
                RoomRentRepository rr = new RoomRentRepository();
                ArrayList ls = new ArrayList<>();
                ls.addAll(rr.all());
                if (rr.checkin(checkout)){
                    bttBack(null);
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
