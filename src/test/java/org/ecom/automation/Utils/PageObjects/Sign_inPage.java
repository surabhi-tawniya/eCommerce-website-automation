package org.ecom.automation.Utils.PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.Utils.FileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sign_inPage extends TestBase {
    public WebDriver driver;

    public Sign_inPage(WebDriver driver) {
        this.driver = driver;
    }

    By email_id = By.id("email_create");
    By create_an_account_button = By.xpath("//*[@id=\"SubmitCreate\"]/span");

    public void clickOnCreateAccountButton() {
        String randomEmail = RandomStringUtils.random(20, true, true);
        String email = randomEmail + "@gmail.com";
        driver.findElement(email_id).sendKeys(email);
        driver.findElement(create_an_account_button).click();
    }
}
