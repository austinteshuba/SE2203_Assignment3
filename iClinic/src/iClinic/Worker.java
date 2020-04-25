package iClinic;// Austin Teshuba

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Worker
 * @author austinteshuba
 * This class represents a worker, a type of user, which contains a username, password, a list of assigned patients,
 * and a worker type (nurse or doctor)
 */
public class Worker extends User {
    // fields
    private String workerType;
    private ArrayList<PatientRecord> assignedPatients;

    /**
     * Constructor
     * @param userID The UniqueID of the user (username)
     * @param password Password of the user
     * @param workerType Type of the worker (either nurse or doctor)
     */
    public Worker(String userID, String password, String workerType) {
        super(userID, password);
        this.workerType = workerType;
        this.assignedPatients = new ArrayList<PatientRecord>();
    }

    /**
     *
     * @return the type of worker
     */
    public String getWorkerType() {
        return workerType;
    }

    /**
     *
     * @param workerType the type of worker
     */
    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    /**
     *
     * @return list of all assigned patients
     */
    public ArrayList<PatientRecord> getAssignedPatients() {
        return assignedPatients;
    }

    /**
     *
     * @param assignedPatients list of all assigned patients
     */
    public void setAssignedPatients(ArrayList<PatientRecord> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    /**
     *
     * @param patient a new assigned patient
     */
    public void addPatientRecord(PatientRecord patient) {
        this.assignedPatients.add(patient);
    }
}

