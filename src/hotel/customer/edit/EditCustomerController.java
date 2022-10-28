package hotel.customer.edit;

import hotel.Main;
import hotel.entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class EditCustomerController implements Initializable {
    public TextField txtName;
    public TextField txtCMT;
    public static Customer editedCustomer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedCustomer !=null){
            txtName.setText(editedCustomer.getName());
            txtCMT.setText(editedCustomer.getCmt());
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listAdd = FXMLLoader.load(getClass().getResource("../list/Customer.fxml"));
        Scene listScene = new Scene(listAdd, 800, 600);
        Main.rootStage.setTitle("Customer List");
        Main.rootStage.setScene(listScene);
    }

    public void submit(ActionEvent actionEvent) throws Exception {

    }

    public void delete(ActionEvent actionEvent) throws Exception {
    }
}
