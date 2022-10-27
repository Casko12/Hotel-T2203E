package hotel.customer.list;

import hotel.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import hotel.entities.Customer;

import java.net.URL;
import java.util.ResourceBundle;


public class CustomerController implements Initializable {
    public TableView<Customer> tbCustomers;

    public TableColumn <Customer, String> tdName;
    public TableColumn <Customer, String> tdCMT;
    public TableColumn tdRoom;
//    public TableColumn <Customer, Button> tdEdit;
    public static ObservableList<Customer> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void backHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/hotel/home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }
}
