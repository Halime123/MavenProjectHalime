package com.hrms.pages;

import com.hrms.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hrms.utils.CommonMethods.click;
import static com.hrms.utils.CommonMethods.sendText;

public class LoginPage extends CommonMethods {
    @FindBy(id="txtUsername")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordBox;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "spanMessage")
    public WebElement invalidMsg;

    @FindBy(id = "spanMessage")
    public WebElement emptyUsername;

    @FindBy(id = "spanMessage")
    public WebElement emptyPasswordName;

    public LoginPage(){
        PageFactory.initElements(driver,this);

    }
    public void login(String username, String password){
        sendText(usernameBox,username);
        sendText(passwordBox,password);

    }
    public void clickOnLoginButton(){
        click(loginBtn);
    }
   public String getErrorMessageText(){
        return invalidMsg.getText();
    }

    public String getEmptyUsernameMessage(){
        return emptyUsername.getText();
    }
    public String getEmptyPasswordMessage(){
        return emptyPasswordName.getText();
    }


}
