package iClinic;// Austin Teshuba

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * PatientRecord
 * This file represents a Patient and contains a bunch of information, like
 * date of birth, name, address, height, weight, blood type, Bed ID, treatment area, as well
 * as a set of documents and treatment records.
 */
public class PatientRecord {
    // fields
    private int patientID;
    private Date dateOfBirth;
    private String name;
    private String address;
    private float height;
    private float weight;
    private String bloodGroup;
    private int bedID;
    private String treatmentArea;
    private ArrayList<Document> documents;
    private ArrayList<Document> treatmentRecords;

    /**
     * COnstructor
     * @param patientID Patient ID (Unique for database)
     * @param dateOfBirth Date of birth of patient
     * @param name Natural english name of the patient
     * @param address Address of patient
     * @param height Patient height in (cm)
     * @param weight Patient weight in (kg)
     * @param bloodGroup Patient blood type (leave as null if not known)
     * @param bedID Patient's BED ID (leave as null if not known)
     * @param treatmentArea Patient's treatment area (leave as null if not known)
     */
    public PatientRecord(int patientID, Date dateOfBirth, String name, String address, float height, float weight, String bloodGroup, int bedID, String treatmentArea) {
        this.patientID = patientID;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.address = address;
        this.height = height;
        this.weight = weight;
        // Initialize the below fields to empty defaults since they might not exist yet
        this.bloodGroup = bloodGroup;
        this.bedID = bedID;
        this.treatmentArea = treatmentArea;
        this.documents = new ArrayList<Document>();
        this.treatmentRecords = new ArrayList<Document>();
    }

    /**
     *
     * @param patientID Patient ID (Unique for database)
     * @param day day of patient's birthday
     * @param month month of patient's birthday (01 = jan, 02 = feb, etc.)
     * @param year year of patient's birthday (XXXX)
     * @param name english name of patient
     * @param address address of patient
     * @param height height in cm
     * @param weight weight in kg
     * @param bloodGroup blood type of patient (leave null if not known)
     * @param bedID patient's bed id (leave null if not known)
     * @param treatmentArea patient's treatment area (leave null if not known)
     */
    public PatientRecord(int patientID, int day, int month, int year, String name, String address, float height, float weight, String bloodGroup, int bedID, String treatmentArea) {
        this(patientID, new GregorianCalendar(year, month, day).getTime(), name, address, height, weight, bloodGroup, bedID, treatmentArea);
    }

    /**
     *
     * @return patient's ID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     *
     * @param patientID value of patient's unique ID
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     *
     * @return date of birth in Date format
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param dateOfBirth date of birth in Date format
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @param day day of birthday
     * @param month month of birthday (01 for jan, 02 for feb, etc.)
     * @param year year of birthday
     */
    public void setDateOfBirth(int day, int month, int year) {
        this.dateOfBirth = new GregorianCalendar(year, month, day).getTime();
    }

    /**
     *
     * @return name of patient
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @param name name of patient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return address of patient
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address address of patient
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return weight in kg
     */
    public float getWeight() {
        return weight;
    }

    /**
     *
     * @param weight weight in kg
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     *
     * @return height in cm
     */
    public float getHeight() {
        return height;
    }

    /**
     *
     * @param height height in cm
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     *
     * @return blood type
     */
    public String getBloodGroup(){
        return bloodGroup;
    }

    /**
     *
     * @param bloodGroup blood type
     */
    public void setBloodGroup (String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     *
     * @return Unique ID of bed in facility
     */
    public int getBedID() {
        return bedID;
    }

    /**
     *
     * @param bedID unique ID of bed in facility
     */
    public void setBedID(int bedID) {
        this.bedID = bedID;
    }

    /**
     *
     * @return treatment area
     */
    public String getTreatmentArea() {
        return treatmentArea;
    }

    /**
     *
     * @param treatmentArea treatment area in facility
     */
    public void setTreatmentArea (String treatmentArea) {
        this.treatmentArea = treatmentArea;
    }

    /**
     *
     * @return list of documents related to patient
     */
    public ArrayList<Document> getDocuments() {
        return documents;
    }

    /**
     *
     * @return list of treatment records related to patient
     */
    public ArrayList<Document> getTreatmentRecords() {
        return treatmentRecords;
    }

    /**
     *
     * @param documents list of documents related to patient
     */
    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    /**
     *
     * @param treatmentRecords list of patient records related to patient
     */
    public void setTreatmentRecords(ArrayList<Document> treatmentRecords) {
        this.treatmentRecords = treatmentRecords;
    }

    /**
     *
     * @param document new document that is related to patient
     */
    public void addDocument(Document document) {
        documents.add(document);
    }

    /**
     *
     * @param treatmentRecord new treatment record that is related to the patient
     */
    public void addTreatmentRecord(Document treatmentRecord) {
        treatmentRecords.add(treatmentRecord);
    }


}
