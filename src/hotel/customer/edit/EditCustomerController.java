package hotel.customer.edit;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.entities.Customer;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
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
        Scene listScene = new Scene(listAdd, 600, 400);
        Main.rootStage.setTitle("Customer List");
        Main.rootStage.setScene(listScene);
    }

    public void submit(ActionEvent actionEvent) throws Exception {
        try{
            String name = txtName.getText();
            String cmt = txtCMT.getText();
            editedCustomer.setName(name);
            editedCustomer.setCmt(cmt);
            CustomerRepository rp = (CustomerRepository) RepositoryFactory.creHotelRepository(RepoType.CUSTOMER);
            if(rp.update(editedCustomer)){
                backToList(null);
            }else {
                System.out.println("Error!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(ActionEvent actionEvent) throws Exception {
        try{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Customer?");
            alert.setHeaderText("Confirm to delete customer: "+editedCustomer.getName()+"?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get() == ButtonType.OK){
                CustomerRepository rp = (CustomerRepository) RepositoryFactory.creHotelRepository(RepoType.CUSTOMER);
                if(rp.delete(editedCustomer)){
                    backToList(null);
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
