package org.ecom.automation.utils.pageObjects;

import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchedProduct {

    private final static Logger LOGGER = LoggerFactory.getLogger(SearchedProduct.class);
    public WebDriver driver;

    public SearchedProduct(WebDriver driver) {

        this.driver = driver;
    }

    final By productResult = By.xpath("//ul[@class='product_list grid row']");
    final By productSort = By.id("selectProductSort");
    final By cartLink = By.xpath("//b[text()='Cart']");
    final By navigatetoProduct = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img");


    public void getProductList() {
        String result = TestBase.driver.findElement(productResult).getText();
        System.out.print("Searched Product Result :: " + result);

    }

    public void setProductSort() {
        WebElement dropdown = TestBase.driver.findElement(productSort);
        Select selectCategory = new Select(dropdown);
        selectCategory.selectByVisibleText("In stock");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        LOGGER.info(String.valueOf(selectCategory));

    }

    public void navigateToProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        TestBase.driver.findElement(navigatetoProduct).click();
    }
}
