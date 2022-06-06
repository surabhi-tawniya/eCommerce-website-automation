package org.ecom.automation.utils.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestBase {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    final By enterEmail = By.id("email");
    final By password = By.id("passwd");
    final By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");

    public void userEnterValidCredentials() {
        String randomEmail = RandomStringUtils.random(20, true, true);
        String email_id = randomEmail + "@gmail.com";
        TestBase.driver.findElement(enterEmail).sendKeys(email_id);

        String randoms = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(password).sendKeys(randoms);
    }

    public void userClicksSignInButton() {

        TestBase.driver.findElement(signInButton).click();
    }
}
