package org.ecom.automation.utils.pageObjects;

import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    final By signInLink = By.xpath("//a[@class='login']");
    final By searchTextbox = By.id("search_query_top");
    final By searchButton = By.name("submit_search");

    public void clickOnSigninLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink));
        TestBase.driver.findElement(signInLink).click();

    }

    public String verifyHomePageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Store";
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("My Store"));
        Assert.assertEquals(actualTitle, expectedTitle, "Title verified");

        if (actualTitle.equals(expectedTitle)) {
            LOGGER.info("Test Passed !");
        } else {
            LOGGER.info("Test Failed !");
        }
        return actualTitle;
    }

    public void clickOnSearchBox() {
        TestBase.driver.findElement(searchTextbox).click();
    }

    public void searchProduct(String productName) {
        TestBase.driver.findElement(searchTextbox).sendKeys(productName);

        WebElement textbox = driver.findElement(searchButton);
        textbox.sendKeys(Keys.ENTER);

    }
}
