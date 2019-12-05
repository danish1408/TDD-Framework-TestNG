package WebManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebManager {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://ui.freecrm.com/");

    }


    @Test

    public void verifyTitle(){

        System.out.println(driver.getTitle());


    }

    @AfterTest

    public void tearDown(){

        driver.close();
    }
}
