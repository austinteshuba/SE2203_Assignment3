package iClinic;// Austin Teshuba

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * WorkerAdaptor
 * @author austinteshuba
 * This will be the bridge between the Worker Entity class and the database.
 */
public class WorkerAdaptor {

    // Connection object to database
    Connection connection;

    /**
     * Constructor.
     * @param conn
     * @param reset If true, clear database and make a new table for Workers. Otherwise, just init the connection field.
     * @throws SQLException
     */
    public WorkerAdaptor(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                stmt.execute("DROP TABLE Workers");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Workers ("
                        + "WorkerType CHAR(15) NOT NULL, "
                        + "Password CHAR(50) NOT NULL, "
                        + "UserID CHAR(50) NOT NULL PRIMARY KEY"
                        + ")");

            }
        }
    }


    /**
     * addWorker adds a new worker
     * @param userID unique username of the user
     * @param password password for user
     * @param workerType type of Worker (either doctor or nurse)
     * @throws SQLException
     */
    public void addWorker(String userID, String password, String workerType) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Workers (WorkerType, Password, UserID)" + " VALUES ('" + workerType + "' , '" + password + "', '" + userID+ "')");
    }

    /**
     *
     * @return a list of all worker userIDs
     * @throws SQLException
     */
    public ObservableList<String> getWorkerList() throws SQLException {
        ObservableList<String> workersList = FXCollections.observableArrayList();

        Statement stmt = connection.createStatement();
        String stmtText = "SELECT * FROM Workers";
        ResultSet results = stmt.executeQuery(stmtText);

        while (results.next()) {
            workersList.add(results.getString("UserID"));
        }

        return workersList;
    }

    /**
     * get the values from a specific worker
     * @param userID a worker's unique ID
     * @return Worker object that matches the given ID
     * @throws SQLException
     */
    public Worker getWorker(String userID) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM Workers WHERE UserID = '" + userID + "'");

        if (results.next()) {
            return new Worker(results.getString("UserID"), results.getString("Password"), results.getString("WorkerType"));
        } else {
            return null;
        }
    }

    /**
     * delete the worker of the unique ID
     * @param userID unique ID of the worker
     * @throws SQLException
     */
    public void deleteWorker(String userID) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM Workers WHERE UserID = '" + userID + "'");
    }

    /**
     * Update the worker with new values
     * @param userID Unique ID of Worker
     * @param password password of the Worker
     * @param workerType type of the worker (either Nurse or Doctor)
     * @throws SQLException
     */
    public void updateWorker(String userID, String password, String workerType) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Workers SET Password = '" + password + "' WHERE UserID = '" + userID + "'");
        stmt.executeUpdate("UPDATE Workers SET WorkerType = '" + workerType + "' WHERE UserID = '" + userID + "'");

    }
}
