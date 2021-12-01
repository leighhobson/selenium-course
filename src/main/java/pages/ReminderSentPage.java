package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReminderSentPage {
    private WebDriver driver;
    private By statusAlert = By.id("content");


    public ReminderSentPage(WebDriver driver){
        this.driver = driver;
    }

}