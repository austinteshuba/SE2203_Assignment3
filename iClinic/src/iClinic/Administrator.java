package iClinic;// Austin Teshuba

/**
 * Administrator
 * Austin Teshuba
 * An Administrator is a type of User account that only deals with adding/editing/removing worker accounts.
 */
public class Administrator extends User {
    public Administrator(String userID, String password) {
        super(userID, password);
    }
}
