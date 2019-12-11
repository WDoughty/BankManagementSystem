package Tests;

import Communication.Email;
import org.junit.Test;
import Exception.*;

import static org.junit.Assert.*;

public class EmailTest {

    @Test
    public void testEmail(){
        Email email = new Email();
        try {
            email.SendEmail("bankmanagementtest@gmail.com","Shitfuckass");
        } catch (EmailNotSentException e) {
            e.printStackTrace();
        }

    }

}