package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageDiffApproach extends BasePage {

    @Test
    public void testEmailAndPasswordFieldsPresence() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        assertNotNull(emailInput);
        assertNotNull(passwordInput);
        assertNotNull(loginButton);
    }

    @Test
    public void testValidCredentials() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        emailInput.sendKeys("login@codility.com");
        passwordInput.sendKeys("password");
        loginButton.click();

        WebElement successMessage = webDriver.findElement(By.className("message success"));
        assertTrue(successMessage.isDisplayed());
        assertEquals("Welcome to Codility", successMessage.getText());
    }

    @Test
    public void testInvalidCredentials() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        emailInput.sendKeys("unknown@codility.com");
        passwordInput.sendKeys("password");
        loginButton.click();

        WebElement errorMessage = webDriver.findElement(By.className("message error"));
        assertTrue(errorMessage.isDisplayed());
        assertEquals("You shall not pass! Arr!", errorMessage.getText());
    }

    @Test
    public void testInvalidEmail() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        emailInput.sendKeys("invalid-email");
        passwordInput.sendKeys("password");
        loginButton.click();

        WebElement emailValidationError = webDriver.findElement(By.xpath("//div[text()='Enter a valid email']"));
        assertTrue(emailValidationError.isDisplayed());
    }

    @Test
    public void testEmptyCredentials() {
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement emptyEmailError = webDriver.findElement(By.xpath("//div[text()='Email is required']"));
        WebElement emptyPasswordError = webDriver.findElement(By.xpath("//div[text()='Password is required']"));

        assertTrue(emptyEmailError.isDisplayed());
        assertTrue(emptyPasswordError.isDisplayed());
    }
}
