package hotel.customer.list;

import hotel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import hotel.entities.Customer;


public class CustomerController {
    public TableView<Customer> tbCustomers;

    public TableColumn <Customer, String> tdName;
    public TableColumn <Customer, String> tdCMT;
    public TableColumn tdRoom;
//    public TableColumn <Customer, Button> tdEdit;

    public void backHome(ActionEvent actionEvent) throws Exception {
        Parent listRoom = FXMLLoader.load(getClass().getResource("hotel/home.fxml"));
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(new Scene(listPage,800,600));
    }
}
