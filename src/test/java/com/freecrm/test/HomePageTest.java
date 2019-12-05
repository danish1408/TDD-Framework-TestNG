package com.freecrm.test;

import com.freecrm.base.BaseClass;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.Homepage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class HomePageTest extends BaseClass {

    LoginPage loginPage;
    Homepage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public ExtentReports  extent;
    public ExtentTest  extentTest;

    public HomePageTest(){

        super();
    }

    @BeforeMethod

    public void Setup(){

        initialization();

        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test

    public void verifyUserID(){

      boolean b=  homePage.VerifyUserName();

        Assert.assertTrue(b);
    }
   @Test
    public void verifyDeal(){

        boolean b=  homePage.VerifyDealsSection();

        Assert.assertTrue(b);
    }

    @Test

    public void verifyUserName() throws Exception{

        extentTest = extent.startTest("verifyUserName");

      String s=  homePage.userName();

      Assert.assertEquals(s, "test");



    }

    @BeforeTest
    public void setExtent(){
        extent = new ExtentReports("C:\\Users\\DANISH\\IdeaProjects\\POMFreeCRM\\test-output\\Extent.html", true);


    }

    @AfterTest
    public void endReport(){
        extent.flush();
        extent.close();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

            String screenshotPath =  TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
            extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
       else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

        }


        extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
        driver.quit();
    }

    }


