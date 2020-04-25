package iClinic;// Austin Teshuba

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * ViewEditWorkerController
 * @author austinteshuba
 * This controls the form that views, edits, and removes Worker accounts.
 */
public class ViewEditWorkerController implements Initializable {
    // fields
    @FXML
    ComboBox<String> userIDComboBox;

    @FXML
    TextField passwordTextField;

    @FXML
    ComboBox<String> workerTypeComboBox;

    @FXML
    Button cancelButton;

    private WorkerAdaptor workerAdaptor;

    final ObservableList<String> workerTypes = FXCollections.observableArrayList("nurse", "doctor");

    final ObservableList<String> userIDObservableList = FXCollections.observableArrayList();


    /**
     * This will set the values in the combo boxes.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        workerTypeComboBox.setItems(workerTypes);
        userIDComboBox.setItems(userIDObservableList);
    }

    /**
     * build the data, and set the workerAdaptor
     * @param workerAdaptor workerAdaptor object
     */
    public void setModel(WorkerAdaptor workerAdaptor) {
        this.workerAdaptor = workerAdaptor;
        buildData();
    }

    /**
     * This will get the UserIDs of the workers.
     */
    public void buildData() {
        try {
            userIDObservableList.addAll(workerAdaptor.getWorkerList());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * will close window without doing anything
     */
    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * This will change the values of all the boxes in the form. Happens when new user is selected.
     */
    @FXML
    public void updateFields() {
        try {
            Worker currentWorker = workerAdaptor.getWorker(userIDComboBox.getValue());
            passwordTextField.setText(currentWorker.getPassword().strip());
            workerTypeComboBox.getSelectionModel().select(currentWorker.getWorkerType());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * deletes the UserAccount described in the field
     */
    @FXML
    public void delete() {
        try {
            workerAdaptor.deleteWorker(userIDComboBox.getValue());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Edits the userID in the database based on what was entered in the form
     */
    @FXML
    public void edit() {
        try {
            workerAdaptor.updateWorker(userIDComboBox.getValue(), passwordTextField.getText(), workerTypeComboBox.getValue());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



}
