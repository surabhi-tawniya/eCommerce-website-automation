package org.ecom.automation.utils.pageObjects;

import org.ecom.automation.utils.fileUtils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationPage extends TestBase {
  private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationPage.class);
  public WebDriver driver;

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }

  By submitBtn = By.id("submitAccount");


  public String verifyHomePageTitle() {
    String actualTitle = getDriver().getTitle();
    String expectedTitle = "Login - My Store";
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);
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
    getDriver().findElement(submitBtn).click();
  }
}
