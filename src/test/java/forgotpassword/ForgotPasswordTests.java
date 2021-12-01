package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import static org.testng.Assert.*;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("test123@tezt.com");
        ForgotPasswordPage reminderSentPage = forgotPasswordPage.clickRetrieveButton();
        assertTrue(reminderSentPage.getAlertText()
                        .contains("Your e-mail's been sent!"),
                "Alert text is incorrect.");
    }
}
