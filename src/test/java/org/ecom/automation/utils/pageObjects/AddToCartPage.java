package org.ecom.automation.utils.pageObjects;

import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCartPage {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    public WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartBtn = By.xpath("//*[@id=\"add_to_cart\"]/button/span");

    public void clickOnAddToCart(){
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn)).click();
        driver.findElement(addToCartBtn).click();
        LOGGER.info("Product added to the cart successfully");
    }
}
