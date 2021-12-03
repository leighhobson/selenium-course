package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextAlert(){
        var contextPage = homePage.clickContextMenu();
        contextPage.contextClickDottedBox();
        String text = contextPage.alert_getText();
        assertEquals(text, "You selected a context menu", "Popup text incorrect.");
        contextPage.alert_clickToAccept();
    }
}
