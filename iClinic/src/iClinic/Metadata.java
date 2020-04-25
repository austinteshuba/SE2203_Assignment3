package iClinic;// Austin Teshuba

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Metadata
 * @author austinteshuba
 * Manages the Metadata, which includes crucial information about documents.
 */
public class Metadata {
    // fields
    private int patientID;
    private Date dateOfCreation;
    private String creatorUserID;
    private Date dateOfModification;
    private String modifierUserID;
    private String description;

    /**
     * Constructor
     * @param creatorUserID
     * @param description Description of the document
     */
    public Metadata (String creatorUserID, String description) {
        this.dateOfCreation = new Date(System.currentTimeMillis()); // init the date created to the current date.
        this.creatorUserID = creatorUserID;
        this.description = description;
    }

    /**
     *
     * @return the date the document was created
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * No setter exists as this must be created and finalized on initialization
     * @return the user ID of the creator
     */
    public String getCreatorUserID() {
        return  creatorUserID;
    }

    /**
     *
     * @return the description of the document
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description the new description of the document
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return the patientID of the associated patient
     */
    public int getPatientID(){
        return patientID;
    }

    /**
     *
     * @param patientID the ID of the associated patient
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     *
     * @return date the document was last modified
     */
    public Date getDateOfModification() {
        return dateOfModification;
    }

    /**
     *
     * @param dateOfModification the date the document was last modified (should be the current time)
     */
    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    /**
     *
     * @return the user ID of the Worker who last modified the document
     */
    public String getModifierUserID() {
        return modifierUserID;
    }

    /**
     *
     * @param modifierUserID the user ID of the Worker who last modified the document
     */
    public void setModifierUserID(String modifierUserID) {
        this.modifierUserID = modifierUserID;
    }

}
