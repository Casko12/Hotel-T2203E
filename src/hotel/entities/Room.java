package hotel.entities;

import hotel.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;



public class Room {
    public Integer id;
    public String name;
    public String type;
    public Integer status;


    public String statusLable;

    public Room() {
    }

    public Room(Integer id, String name, String type,Integer status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return getName();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    public String getStatusLable() {
        return status==0?"Phòng Trống":"Đang Thuê";
    }

    public void setStatusLable(String statusLable) {
        this.statusLable = statusLable;
    }

}
