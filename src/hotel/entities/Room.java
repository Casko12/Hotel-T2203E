package hotel.entities;

import javafx.scene.control.Button;

public class Room {
    public Integer id;
    public String name;
    public String type;
    public String status;

    public Button edit;

    public Room() {
    }

    public Room(Integer id, String name, String type,String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.edit = new Button("Đặt Phòng");
        this.edit.setOnAction(event -> {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }
}
