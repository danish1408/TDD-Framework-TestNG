package com.freecrm.test;

import com.freecrm.base.BaseClass;
import com.freecrm.pages.Homepage;
import com.freecrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static com.freecrm.base.BaseClass.*;

public class LoginPageTest extends BaseClass {


    LoginPage loginPage;
    Homepage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        Boolean b = loginPage.validatelink();
        Assert.assertTrue(b);
    }


    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        Assert.assertNotNull(homePage);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}