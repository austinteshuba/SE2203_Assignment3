package iClinic;// Austin Teshuba

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * AddWorkerController.java
 * @author austinteshuba
 * SE 2203B
 * This file controls the AddWorker form.
 */
public class AddWorkerController implements Initializable {

    // Some stored properties from the FXML
    @FXML
    ComboBox<String> workerTypeComboBox;

    @FXML
    TextField userIDField;

    @FXML
    TextField passwordField;

    @FXML
    Button cancelButton;

    private WorkerAdaptor workerAdaptor;

    // A list of worker types. Only doctors and nurses have been identified
    final ObservableList<String> workerTypes = FXCollections.observableArrayList("nurse", "doctor");


    /**
     * addWorker
     *
     * This function adds a worker to the database via the adaptor
     */
    @FXML
    public void addWorker() {
        try {
            workerAdaptor.addWorker(userIDField.getText(), passwordField.getText(), workerTypeComboBox.getValue());
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        // Close the window
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * cancel will close the screen without doing anything
     */
    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * initialize will set the items in the worker type box.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        workerTypeComboBox.setItems(workerTypes);
    }

    /**
     * setModel will set up the adaptor
     * @param workerAdaptor the adaptor object
     */
    public void setModel(WorkerAdaptor workerAdaptor) {
        this.workerAdaptor = workerAdaptor;
    }


}
