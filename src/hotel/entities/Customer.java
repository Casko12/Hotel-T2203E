package hotel.entities;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Customer{
    public Integer id;
    public String name;
    public String cmt;
    public Button edit;

    public Customer() {
    }

    public Customer(int id, String name, String cmt) {
        this.id = id;
        this.name = name;
        this.cmt = cmt;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try{

            }catch (Exception e){

            }
        });
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }
}
