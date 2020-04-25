/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iClinic;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class MainController implements Initializable {

    @FXML
    private MenuBar mainMenu;

    private Connection conn;

    private WorkerAdaptor workerAdaptor;

    private boolean workerTableCreated = false;

    @FXML
    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iClinic/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void exit() {

        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:TeamDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void resetDatabase() {
        try {
            // create Teams model
            workerAdaptor = new WorkerAdaptor(conn, true);
            System.out.println("Successful reset");

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @FXML
    public void addWorker() throws Exception {
        // create Teams model
        workerAdaptor = new WorkerAdaptor(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddWorker.fxml"));

        Parent addWorker = (Parent) fxmlLoader.load();

        AddWorkerController addWorkerController = (AddWorkerController) fxmlLoader.getController();
        addWorkerController.setModel(workerAdaptor);

        Scene scene = new Scene(addWorker);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iClinic/WesternLogo.png"));
        stage.setTitle("Add New Worker");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML
    public void manageWorker() throws Exception {
        // create Teams model
        workerAdaptor = new WorkerAdaptor(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewEditWorker.fxml"));

        Parent manageWorker = (Parent) fxmlLoader.load();

        ViewEditWorkerController viewEditWorkerController = (ViewEditWorkerController) fxmlLoader.getController();
        viewEditWorkerController.setModel(workerAdaptor);

        Scene scene = new Scene(manageWorker);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iClinic/WesternLogo.png"));
        stage.setTitle("View/Edit New Worker");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

}

