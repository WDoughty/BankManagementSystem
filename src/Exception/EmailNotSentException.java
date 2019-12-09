package Exception;

public class EmailNotSentException extends Exception{

    /**
     * Email not sent exception
     * @param message
     */
    public EmailNotSentException(String message){
        super(message);
    }

}
