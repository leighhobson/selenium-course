package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrieveButton = By.cssSelector("#form_submit");
    private By statusAlert = By.cssSelector("content");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public ForgotPasswordPage clickRetrieveButton() {
        driver.findElement(retrieveButton).click();
        return new ForgotPasswordPage(driver);
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}