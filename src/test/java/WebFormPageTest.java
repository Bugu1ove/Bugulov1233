import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.WebFormPage;

import static browser.Browser.driver;
import static browser.Config.START_URL;

public class WebFormPageTest{

    private WebDriver driver;
    private WebFormPage webFormPage;
    private WebFormPageTest webFormPageTest;

    private String TboxName = "Bugulov Aleksandr Sergeevich";
    private String Tboxaria = "Bugulov Aleksandr Sergeevich";
    private String PboxPassword = "1234567";
    private String Droptest = "Seattle";


    @BeforeClass
    public void beforeClass() {
        driver = Browser.createDriver();
        webFormPage = new WebFormPage(driver);
        webFormPage.openURL(START_URL);

    }

    @Test
    public void step_1() {
        webFormPage.setAllFieldAndSubmit(TboxName, Tboxaria, PboxPassword);
        webFormPage.getOutputName();
        webFormPage.getOutputAria();
        webFormPage.getOutputPassword();
        Assert.assertEquals(webFormPage.getOutputName(), TboxName);
        Assert.assertEquals(webFormPage.getOutputAria(), Tboxaria);
        Assert.assertEquals(webFormPage.getOutputPassword(), PboxPassword);


    }

    @Test
    public void step_2() {
        boolean initialState1 = webFormPage.getCheckBoxState1();
        boolean initialState2 = webFormPage.getCheckBoxState2();
        webFormPage.setCheckBox1(!initialState1);
        webFormPage.setCheckBox2(initialState2);

    }

    @Test
    public void step_3() {

        webFormPage.setRadioButtonClick("Default radio");
        Assert.assertTrue(webFormPage.getRadioButtonClick("Default radio"));
    }

    @Test
    public void step_4() {
        webFormPage.openDropdown();
        webFormPage.setRoleDrop();
        webFormPage.setDropBoxText(Droptest);
    }

    @Test
    public void step_5() {
        webFormPage.ClickBtn();
        Assert.assertTrue(webFormPage.isPageOpen());

    }

    @Test
    public void step_6() {
        webFormPage.openURL(START_URL);
        Assert.assertTrue(webFormPage.isPageOpenMain());
    }

    @AfterClass
    public void afterClass() {
            driver.quit();
    }
}
