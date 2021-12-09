package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

public class JavaScriptTests extends BaseTests {

    //When element exists in DOM
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    //When element loads on scroll
    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

}
