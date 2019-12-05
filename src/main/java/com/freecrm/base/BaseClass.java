package com.freecrm.base;

import com.freecrm.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

  public  BaseClass() {

        try {

            prop = new Properties();

            FileInputStream fls = new FileInputStream("C:\\Users\\DANISH\\IdeaProjects\\POMFreeCRM\\src\\main\\java\\com\\freecrm\\Config\\config.properties");
            prop.load(fls);

            System.out.println(prop);

            System.out.println(prop.getProperty("username"));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));


    }

}