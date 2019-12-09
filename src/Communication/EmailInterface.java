package Communication;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public interface EmailInterface {

    /**
     * Sends an Email using SMTP
     * @param to String email address
     * @param update String message
     * @return boolean
     */
    boolean SendEmail(String to, String update);
}
