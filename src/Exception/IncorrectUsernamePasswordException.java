package Exception;

public class IncorrectUsernamePasswordException extends Exception {

    /**
     * Incorrect Username or Password Exception
     * @param message
     */
    public IncorrectUsernamePasswordException(String message){
        super(message);
    }
}
