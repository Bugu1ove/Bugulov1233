package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static browser.Config.START_URL;

public class WebFormPage extends BasePage{
    public WebFormPage(WebDriver driver) {super(driver);}
    public By Check1 = By.id("my-check-1");
    public By Check2 = By.id("my-check-2");

    public static final String radiobut = ("//input[@id = 'my-radio-2']");

    public By drop1 = By.xpath("//input[@placeholder='Type to search...']");
    public By droppunkt1 = By.xpath("//option[@value= '2']");

    public By BtnSubmit = By.xpath("//button[@type = 'submit']");

    public By TextExit1 = By.xpath("//h1[text()='Form submitted']");
    public By TextExit2 = By.xpath("//p[text() = 'Received!']");

    public By drop2 = By.id("my-select");
    public By dropBox = By.xpath("//input[@name = \"my-datalist\"]");
    public By droppunkt2 = By.xpath("//option[@value= 'Seattle']");


    public By tboxMy = By.xpath("//input[@id = 'my-text-id']");
    public By passwordBoxName = By.xpath("//input[@name= 'my-password']");
    public By textaria = By.xpath("//textarea[@class = 'form-control']");

    public By outputId = By.xpath("//p[@id]");
    public static final String OUTPUT_XPATH = "//div[@id='output']//p[@id='%s']";

    public void setName(String fullName){
        driver.findElement(tboxMy).sendKeys(fullName);
    }

    public void setAria(String aria) {driver.findElement(textaria).sendKeys(aria);}

    public void setPassword(String password) {
        driver.findElement(passwordBoxName).sendKeys(password);
    }

    public void setAllFieldAndSubmit(String fullName, String aria, String password){
        setName(fullName);
        setAria(aria);
        setPassword(password);
    }
    public String getOutputName() {
        return driver.findElement(tboxMy).getAttribute("value");
    }
    public String getOutputAria() {
        return driver.findElement(textaria).getAttribute("value");
    }
    public String getOutputPassword() {
        return driver.findElement(passwordBoxName).getAttribute("value");


    }
    public boolean getCheckBoxState1() {
        return driver.findElement(Check1).isSelected();
    }
    public boolean getCheckBoxState2() {
        return driver.findElement(Check2).isSelected();
    }
    public void setCheckBox2(boolean state) {
        // Проверяем, находится ли чекбокс в нужном состоянии
        if (getCheckBoxState2() == state) {
            driver.findElement(Check2).click();
        }
    }
    public void setCheckBox1(boolean state) {
        // Проверяем, находится ли чекбокс в нужном состоянии
        if (getCheckBoxState1() == state) {
            driver.findElement(Check1).click();
        }
    }
    public void setRadioButtonClick(String radioButtonName){
        By locator = By.xpath(String.format(radiobut,radioButtonName));
        driver.findElement(locator).click();
    }

    public boolean getRadioButtonClick(String radioButtonName){
        By locator = By.xpath(String.format(radiobut,radioButtonName));
        return driver.findElement(locator).isSelected();
    }


    public void openDropdown() {
        driver.findElement(drop1).click();
        System.out.println("Список открыт");
    }

    public void setRoleDrop(){
        driver.findElement(droppunkt1).click();
        System.out.println("Элемент списка выбран");
    }

    public void ClickDropBox(String drobBoxText){
        driver.findElement(dropBox).sendKeys(drobBoxText);
    }
    public void setDropBoxText(String drobBoxText){
        ClickDropBox(drobBoxText);
    }
    public boolean isPageOpen(){
        boolean a = driver.findElement(TextExit1).isDisplayed();
        boolean b = driver.findElement(TextExit2).isDisplayed();
        return a && b;
    }
    public void ClickBtn(){
        driver.findElement(BtnSubmit).click();
    }

}

