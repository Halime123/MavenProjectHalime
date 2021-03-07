package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
//order of the steps is not matter only sceneria is matter

public class LoginStepDefinition extends CommonMethods {
    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();

    }

    @When("enter valid credentials")
    public void enter_valid_credentials() throws InterruptedException {
       loginPage.login("Admin","Hum@nhrm123");
       Thread.sleep(2000);
    }

    @When("click on login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() throws InterruptedException {
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
        Thread.sleep(2000);
    }
    @Then("quit the browser")
    public void quit_the_browser() {
        tearDown();
    }
    @When("enter invalid credentials")
    public void enter_invalid_credentials() throws InterruptedException {
        loginPage.login("Admin343","Hum@nhrm123dgf");
        Thread.sleep(2000);
    }
   @Then("verify error message")
    public void verify_error_message() {
       Assert.assertEquals("Invalid credentials","Invalid credentials",loginPage.getErrorMessageText());
    }
    @When("only enter password")
    public void only_enter_password() throws InterruptedException {
    loginPage.passwordBox.sendKeys("Syntax123!");
        Thread.sleep(2000);

    }
    @Then("verify empty message")
    public void verify_empty_message() {
        Assert.assertEquals("Username cannot be empty","Username cannot be empty",loginPage.getEmptyUsernameMessage());
    }
    @When("only enter username")
    public void only_enter_username() {
        loginPage.usernameBox.sendKeys("Admin");
    }
    @Then("verify password empty message")
    public void verify_password_empty_message() {
       Assert.assertEquals("Password cannot be empty","Password cannot be empty",loginPage.getEmptyPasswordMessage());
    }





}
