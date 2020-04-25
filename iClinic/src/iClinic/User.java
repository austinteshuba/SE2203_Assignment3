package iClinic;// Austin Teshuba

/**
 * User
 * @author austinteshuba
 * This class describes a general user with a unique ID (in this case just a username) and password
 */
public class User {
    // fields
    private String userID;
    private String password;

    /**
     * Constructor
     * @param userID username (must be unique)
     * @param password password for account
     */
    public User (String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    /**
     *
     * @return username of user
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID username
     */
    public void setUserID (String userID) {
        this.userID = userID;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     *
     * @param password password
     */
    public void setPassword (String password) {
        this.password = password;
    }

}
