package practiceExamJava2.student;

import hotel.dao.impls.RoomRepository;
import hotel.entities.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import practiceExamJava2.dao.impls.StudentRepository;
import practiceExamJava2.entities.Student;
import practiceExamJava2.enums.RepoType;
import practiceExamJava2.factory.RepositoryFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public TableView<Student> studentview;
    public TableColumn<Student,String> studentid;
    public TableColumn<Student,String> studentname;
    public TableColumn<Student,String> address;
    public TableColumn<Student,String> phone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    studentid.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    studentname.setCellValueFactory(new PropertyValueFactory<>("studentName"));
    address.setCellValueFactory(new PropertyValueFactory<>("address"));
    phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ObservableList<Student> ls = FXCollections.observableArrayList();
        StudentRepository r = (StudentRepository)RepositoryFactory.creStudentRepository(RepoType.STUDENT);
        ls.add(r.all())
    studentview.setItems(ls);
    }

    public void add(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
    }

    public void save(ActionEvent actionEvent) {
    }
}
