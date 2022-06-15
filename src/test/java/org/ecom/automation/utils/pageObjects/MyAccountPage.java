package org.ecom.automation.utils.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends TestBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyAccountPage.class);
    public WebDriver driver;

    public MyAccountPage(WebDriver driver) {

        this.driver = driver;
    }

    final By verifyMyAccount = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    public void verifyMyAccountPageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs("My account - My Store"));
        Assert.assertEquals(actualTitle, expectedTitle, "Title verified");
    }

    public void verifyMyAccountName() {
        String userText = driver.findElement(verifyMyAccount).getText();
        String myName = RandomStringUtils.random(10, true, true);
        if (userText.contains(myName)) {
            LOGGER.info("User Verified,Test case Passed");
        } else {
            LOGGER.info("User Verification Failed,Test case Failed");
        }
    }

}

