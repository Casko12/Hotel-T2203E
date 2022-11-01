package hotel.entities;

import hotel.Main;
import hotel.room.datphong.CheckInController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Room {
    public Integer id;
    public String name;
    public String type;
    public Integer status;

    public Button datphong;
    public Button chinhsua;

    public String statusLable;

    public Room() {
    }

    public Room(Integer id, String name, String type,Integer status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.datphong = new Button("Đặt Phòng");
        this.datphong.setOnAction((event) -> {
            try {

                CheckInController.checkIn = this;
                Parent datphong = FXMLLoader.load(getClass().getResource("/datphong/datphong.fxml"));
                Main.rootStage.setScene(new Scene(datphong,800,600));

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        this.chinhsua = new Button("Chỉnh sửa");
        this.chinhsua.setOnAction(event -> {
            try {

            }catch (Exception e){}
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

    public Button getDatphong() {
        return datphong;
    }

    public void setDatphong(Button datphong) {
        this.datphong = datphong;
    }

    public Button getChinhsua() {
        return chinhsua;
    }

    public void setChinhsua(Button chinhsua) {
        this.chinhsua = chinhsua;
    }

    public String getStatusLable() {
        return status==0?"Phòng Trống":"Đang Thuê";
    }

    public void setStatusLable(String statusLable) {
        this.statusLable = statusLable;
    }

}
