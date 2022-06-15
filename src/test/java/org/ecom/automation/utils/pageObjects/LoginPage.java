package org.ecom.automation.utils.pageObjects;

import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestBase {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    final By enterEmail = By.id("email");
    final By passwrd = By.id("passwd");
    final By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");

    public LoginPage userEnterValidCredentials(String email_id, String password) {
        getDriver().findElement(enterEmail).sendKeys(email_id);
        getDriver().findElement(passwrd).sendKeys(password);
        return this;
    }

    public LoginPage userClicksSignInButton() {
        getDriver().findElement(signInButton).click();
        return this;
    }
}
