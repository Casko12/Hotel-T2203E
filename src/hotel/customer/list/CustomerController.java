package hotel.customer.list;

import hotel.Main;
import hotel.dao.impls.CustomerRepository;
import hotel.dao.impls.RoomRentRepository;
import hotel.entities.Customer;
import hotel.entities.RoomRent;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class CustomerController implements Initializable {
    public TableView<Customer> tbCustomers;

    public TableColumn <Customer, String> tdName;
    public TableColumn <Customer, String> tdCMT;
    public TableColumn <Customer, Button> tdEdit;
    public static ObservableList<Customer> list = FXCollections.observableArrayList();
    public TableColumn <RoomRent, Date> tdDatein;
    public TableColumn <RoomRent, Date> tdDateout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    tdName.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
    tdCMT.setCellValueFactory(new PropertyValueFactory<Customer, String>("cmt"));


    tdEdit.setCellValueFactory(new PropertyValueFactory<Customer, Button>("edit"));
        ObservableList <Customer> ls = FXCollections.observableArrayList();
        CustomerRepository rp = (CustomerRepository)RepositoryFactory.creHotelRepository(RepoType.CUSTOMER);
        ls.addAll(rp.all());
        tbCustomers.setItems(ls);
    }


    public void backHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/hotel/home.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }

    public void onToAdd(ActionEvent actionEvent) throws Exception {

        Parent listPage = FXMLLoader.load(getClass().getResource("../add/AddCustomer.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("Add Customer");
        Main.rootStage.setScene(listScene);
    }

    public void gotoRoomRent(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../roomrent/roomrent.fxml"));
        Scene listScene = new Scene(listPage, 600, 400);
        Main.rootStage.setTitle("Room Rent");
        Main.rootStage.setScene(listScene);
    }
}
