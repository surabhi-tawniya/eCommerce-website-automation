package org.ecom.automation.Utils.PageObjects;

import org.ecom.automation.Utils.FileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class HomePage extends TestBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By signInLink = By.xpath("sign In");

    public void clickOnSigninLink() {
        driver = new ChromeDriver();
        driver.findElement(signInLink).click();
    }

    public String verifyHomePageTitle() {
        driver = new ChromeDriver();
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Store";
        WebDriverWait wait = new WebDriverWait(driver, 20);
        ;
        wait.until(ExpectedConditions.titleIs("My Store"));
        Assert.assertEquals(actualTitle, expectedTitle, "Title verified");

        if (actualTitle.equals(expectedTitle)) {
            LOGGER.info("Test Passed !");
        } else {
            LOGGER.info("Test Failed !");
        }
        return actualTitle;
    }
}
