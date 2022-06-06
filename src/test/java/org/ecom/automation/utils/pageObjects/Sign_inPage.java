package org.ecom.automation.utils.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sign_inPage extends TestBase {
    public WebDriver driver;

    public Sign_inPage(WebDriver driver) {
        this.driver = driver;
    }

    final By email_id = By.id("email_create");
    final By create_an_account_button = By.xpath("//*[@id=\"SubmitCreate\"]/span");

    public void clickOnCreateAccountButton() {
        String randomEmail = RandomStringUtils.random(20, true, true);
        String email = randomEmail + "@gmail.com";
        TestBase.driver.findElement(email_id).sendKeys(email);
        TestBase.driver.findElement(create_an_account_button).click();
    }
}
