package pages;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.DriverUtils;

public class BasePage {

    WebDriver webDriver = DriverUtils.getDriver();

    public BasePage(){
        PageFactory.initElements(webDriver,this);
    }

    @BeforeEach
    public void setUp() {
        ConfigReader.initializeProperties();
        DriverUtils.createDriver();
    }

    @AfterEach
    public void cleanUp(){
        DriverUtils.getDriver().quit();
    }
}
