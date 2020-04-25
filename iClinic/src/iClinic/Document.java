package iClinic;// Austin Teshuba

/**
 * Document
 * @author austinteshuba
 * A document is a collection of text that is stored in the system. Could be a regular document, drug order,
 * prescription, or a treatment record.
 */
public class Document {
    // Fields
    private String text;
    private String type; // the type shoudl be either default, drugOrder, prescription, or treatmentRecord.
    private Metadata metadata;

    /**
     * COnstructor
     * @param text text in document
     * @param type type of document. type should be either default, drugOrder, prescription, or treatmentRecord.
     * @param creatorID the user ID of the creator
     * @param description the description of the document
     */
    public Document(String text, String type, String creatorID, String description) {
        this.metadata = new Metadata(creatorID, description);
        this.text = text;
        this.type = type;
    }

    /**
     * getMetadata
     * @return the metadata of the document (includes info like creatorID and description)
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * getText
     * @return the text of the document
     */
    public String getText() {
        return text;
    }

    /**
     * getType
     * @return the type of the document (either drug order, prescription, default, or treatment record)
     */
    public String getType() {
        return type;
    }

    /**
     * setText
     * @param text the new text value
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * setType
     * @param type The new document type (either drug order, prescription, default, or treatment record)
     */
    public void setType(String type) {
        this.type = type;
    }
}
