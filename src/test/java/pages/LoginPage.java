package pages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends DriverUtils {

    WebDriver webDriver = DriverUtils.getDriver();
    WebElement emailInput = webDriver.findElement(By.id("email-input"));
    WebElement passwordInput = webDriver.findElement(By.id("password-input"));
    WebElement loginButton = webDriver.findElement(By.id("login-button"));
    WebElement successMessage = webDriver.findElement(By.className("message success"));
    WebElement errorMessage = webDriver.findElement(By.className("message error"));
    WebElement emailValidationError = webDriver.findElement(By.xpath("//div[text()='Enter a valid email']"));
    WebElement emptyCredentialsError = webDriver.findElement(By.xpath("//div[text()='Email is required']"));
    /*
    TC1: verify that the email and password fields are on the main screen of the application:
     */
    @Test
    public void verifyLoginFormPresent(){
        assertTrue(emailInput.isDisplayed(), "Email input field is not displayed!");
        assertEquals("email-input", emailInput.getAttribute("id"));

        assertTrue(passwordInput.isDisplayed(), "Password input field is not displayed!");
        assertEquals("password-input", passwordInput.getAttribute("id"));
    }

    /*
    TC2: verify that the given valid credentials work:
     */
    @Test
    public void verifyValidCredentials(){
        emailInput.sendKeys("login@codility.com");
        emailInput.sendKeys("password");
        loginButton.click();
        assertTrue(successMessage.isDisplayed(), "Welcome message is not displayed!");
        assertEquals("Welcome to Codility", successMessage.getText());
    }

    /*
    TC3: verify that the given wrong credentials work:
     */
    @Test
    public void verifyInvalidCredentials(){
        emailInput.sendKeys("unknown@codility.com");
        emailInput.sendKeys("password");
        loginButton.click();
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed!");
        assertEquals("You shall not pass! Arr!", errorMessage.getText());
    }

    /*
    TC4: verify that the email validation is working:
     */
    @Test
    public void verifyEmailValidation(){
        emailInput.sendKeys("unknown");
        emailInput.sendKeys("password");
        loginButton.click();
        assertTrue(emailValidationError.isDisplayed(), "Email validation message is not displayed!");
        assertEquals("Enter a valid email", emailValidationError.getText());
    }

    /*
    TC5: verify empty credentials:
     */
    @Test
    public void verifyEmptyCredentials(){
        emailInput.sendKeys("");
        emailInput.sendKeys("password");
        loginButton.click();
        assertTrue(emptyCredentialsError.isDisplayed(), "Email is required message is not displayed!");
        assertEquals("Email is required", emptyCredentialsError.getText());
    }
}
