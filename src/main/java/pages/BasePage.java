package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openURL(String url){
        driver.get(url);
    }
    public void failure() {
        throw new AssertionError();
    }
}
