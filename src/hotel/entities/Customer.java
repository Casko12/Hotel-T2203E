package hotel.entities;


import javafx.scene.control.Button;

public class Customer{
    public Integer id;
    public String name;
    public String cmt;
    public Button edit;

    public Customer() {
    }

    public Customer(Integer id, String name, String cmt) {
        this.id = id;
        this.name = name;
        this.cmt = cmt;
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
}
