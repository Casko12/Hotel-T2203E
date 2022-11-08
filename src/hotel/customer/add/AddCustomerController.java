package hotel.customer.add;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.entities.Customer;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class AddCustomerController {
    public TextField txtCustomerName;
    public TextField txtCMT;

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listAdd = FXMLLoader.load(getClass().getResource("../list/Customer.fxml"));
        Scene listScene = new Scene(listAdd, 600, 400);
        Main.rootStage.setTitle("Customer List");
        Main.rootStage.setScene(listScene);
    }

    public void submit(ActionEvent actionEvent) {
        try{
            String name = txtCustomerName.getText();
            String cmt = txtCMT.getText();
            Customer customer = new Customer(null, name, cmt);
            CustomerRepository rp = (CustomerRepository)RepositoryFactory.creHotelRepository(RepoType.CUSTOMER);
            if(rp.create(customer)){
                backToList(null);
            } else {
                System.out.println("Error!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
