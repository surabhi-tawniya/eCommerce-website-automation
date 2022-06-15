package org.ecom.automation.utils.pageObjects;

import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;

public class Sign_inPage extends TestBase {
    public WebDriver driver;

    public Sign_inPage(WebDriver driver) {
        this.driver = driver;
    }

    final By email_id = By.id("email_create");
    final By create_an_account_button = By.xpath("//*[@id=\"SubmitCreate\"]/span");

    public String clickOnCreateAccountButton(String email) {
        String randomEmail = RandomStringUtils.random(20, true, true);
        String e_id = randomEmail + "@gmail.com";
        getDriver().findElement(email_id).sendKeys(e_id);
        getDriver().findElement(create_an_account_button).click();
        return email;
    }
}
