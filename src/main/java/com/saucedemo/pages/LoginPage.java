package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class LoginPage extends Utility {

    @CacheLookup
            @FindBy(xpath="//input[@id='user-name']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath="//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath="//input[@id='login-button']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'Products')]")
    WebElement productTitleText;

//    @CacheLookup
//    @FindBy(xpath ="//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']" )
//    WebElement numberOfProducts;


    public void enterUserName(String userName) {
        Reporter.log("Enter Username " + userName + " to email field " + usernameField.toString());
        CustomListeners.test.log(Status.PASS,"Enter Username " + userName);
        sendTextToElement(usernameField, userName); }

   public void enterPassword(String password) {
       Reporter.log("Enter Password " + password + " to password field " + passwordField.toString());
       CustomListeners.test.log(Status.PASS,"Enter Password " + password);
       sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button ");
        CustomListeners.test.log(Status.PASS,"CLick on Login Button ");
        clickOnElement(loginButton);
    }

    public void loginToApplication(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getTextFromProductTitle() {
        Reporter.log("Get Text From Product Title" );
        CustomListeners.test.log(Status.PASS,"Get Text From Product Title");
        return getTextFromElement(productTitleText);
    }


    public int countProductOnList() {
        Reporter.log("Count Total no of products");
        CustomListeners.test.log(Status.PASS, "Count Total no of products");
        List<WebElement> productsList = driver.findElements(By.className("inventory_item_label"));
        return productsList.size();
    }

  }




