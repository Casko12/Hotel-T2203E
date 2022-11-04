package hotel.roomrent;

import hotel.Main;
import hotel.dao.impls.RoomRentRepository;
import hotel.entities.RoomRent;
import hotel.enums.RepoType;
import hotel.factory.RepositoryFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class AddAfterCheckin {
    public TextField fullname;
    public TextField cmt;

    public AddAfterCheckin(TextField fullname, String cmtText) {

    }


    public void back(ActionEvent actionEvent) throws Exception {
        Parent listToRoomRent = FXMLLoader.load(getClass().getResource("./addaftercheckin.fxml"));
        Scene listScene = new Scene(listToRoomRent, 800, 600);
        Main.rootStage.setTitle("Add After Checkin");
        Main.rootStage.setScene(listScene);
    }

    public void add(ActionEvent actionEvent){
        try{
            String fullnameText = fullname.getText();
            String cmtText = cmt.getText();
            AddAfterCheckin afc = new AddAfterCheckin( fullname, cmtText);
            RoomRentRepository rp = (RoomRentRepository) RepositoryFactory.creHotelRepository(RepoType.ROOMRENT);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    }

