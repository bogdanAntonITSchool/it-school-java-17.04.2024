package ro.itschool.testcontroller.exceptions;

public class UserNotFoundException extends RuntimeException {

    private String userName;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String userName, String message, Throwable cause) {
        super(message, cause);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
