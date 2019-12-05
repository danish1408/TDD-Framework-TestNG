package com.freecrm.pages;

import com.freecrm.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.freecrm.base.BaseClass.driver;

public class Homepage extends BaseClass {
    @FindBy(xpath= "//span[contains(text(), 'Dan')]")
    WebElement userId;

    @FindBy(xpath= "//div[contains(text(), 'Deals')]")

    WebElement DealsPage;

    public Homepage(){

        PageFactory.initElements(driver, this);
    }

    public boolean VerifyUserName(){

        return userId.isDisplayed();
    }

    public boolean VerifyDealsSection(){

        return DealsPage.isDisplayed();
    }
public String userName(){

  return userId.getText();
}

}
