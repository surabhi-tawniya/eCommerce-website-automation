package org.ecom.automation.utils.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class UserRegistrationSuccessful extends TestBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserRegistrationSuccessful.class);
    public WebDriver driver;

    public UserRegistrationSuccessful(WebDriver driver) {
        this.driver = driver;
    }

    final By verifyMyAccount = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    public void verifyMyAccountPageTitle() {
        String actualTitle = TestBase.driver.getTitle();
        String expectedTitle = "My account - My Store";
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 20);
        wait.until(ExpectedConditions.titleIs("My account - My Store"));
        Assert.assertEquals(actualTitle, expectedTitle, "Title verified");
    }

    public void verifyMyAccountName() {
        String userText = TestBase.driver.findElement(verifyMyAccount).getText();
        String myName = RandomStringUtils.random(10, true, true);
        if (userText.contains(myName)) {
            LOGGER.info("User Verified,Test case Passed");
        } else {
            LOGGER.info("User Verification Failed,Test case Failed");
        }
        TestBase.driver.close();
    }
}
