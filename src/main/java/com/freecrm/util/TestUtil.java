package com.freecrm.util;

import com.freecrm.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;


public class TestUtil extends BaseClass {

    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static String takeScreenshotAtEndOfTest(WebDriver driver, String screenshotName) throws IOException{



       LocalDateTime localDateTime = LocalDateTime.now();

        String destination = "C:\\Users\\DANISH\\IdeaProjects\\POMFreeCRM\\test-output\\Error" + screenshotName +
                 ".png";

       String currDate = localDateTime.toString();

       System.out.println("Take ScreenShots");
        System.out.println(currDate + "hi");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
                File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;

    }
}
