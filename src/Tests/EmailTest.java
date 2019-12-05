package Tests;

import Communication.Email;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {

    @Test
    public void testEmail(){
        new Email("bankmanagementtest@gmail.com");

    }

}