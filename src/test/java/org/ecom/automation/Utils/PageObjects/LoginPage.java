package org.ecom.automation.Utils.PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By enterEmail = By.id("email");
    By password = By.id("passwd");
    By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");

    public void userEnterValidCredentials() {
        String randomEmail = RandomStringUtils.random(20, true, true);
        String email_id = randomEmail + "@gmail.com";
        driver.findElement(enterEmail).sendKeys(email_id);

        String randompass = RandomStringUtils.random(10, true, true);
        driver.findElement(password).sendKeys(randompass);
    }

    public void userClicksSignInButton() {
        driver.findElement(signInButton).click();
    }
}
