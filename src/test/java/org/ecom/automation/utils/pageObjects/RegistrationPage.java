package org.ecom.automation.utils.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class RegistrationPage extends TestBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationPage.class);
    public WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By submitBtn = By.id("submitAccount");


    public String verifyHomePageTitle() {
        String actualTitle = TestBase.driver.getTitle();
        String expectedTitle = "Login - My Store";
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 30);
        wait.until(ExpectedConditions.titleIs("Login - My Store"));
        Assert.assertEquals(actualTitle, expectedTitle, "Title verified");

        LOGGER.info(actualTitle);
        return actualTitle;

    }

      /*  if (actualTitle.equals(expectedTitle)) {
            LOGGER.info("Test Passed !");
        } else {
            LOGGER.info("Test Failed !");
        }
        return actualTitle;*/


    public void clickOnSubmitButton() {
        TestBase.driver.findElement(submitBtn).click();
    }
}
