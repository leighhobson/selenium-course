package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SliderPage {

    private WebDriver driver;
    private By slider = By.cssSelector("input");
    private By resultText = By.id("range");

    public SliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSlider(){
        driver.findElement(slider).click();
    }

    public void moveSlider(){
        for (int i = 0; i < 3; i++){
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }
}
