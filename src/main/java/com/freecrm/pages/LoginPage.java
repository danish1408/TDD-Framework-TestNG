package com.freecrm.pages;

import com.freecrm.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(xpath="//input[@name='email']")
    WebElement name;

    @FindBy(xpath= "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//div [@class='ui fluid large blue submit button']")

    WebElement submit;

    @FindBy(linkText = "Forgot your password?")

    WebElement link;

    public LoginPage(){
        PageFactory.initElements(driver, this);
}


    public boolean validatelink() {

        return link.isDisplayed();
    }

    public Homepage login( String un, String pwd){

        name.sendKeys(un);
        password.sendKeys(pwd);
        submit.click();

        return new Homepage();
    }

}

