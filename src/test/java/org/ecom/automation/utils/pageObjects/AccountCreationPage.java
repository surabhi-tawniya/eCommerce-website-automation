package org.ecom.automation.utils.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends TestBase {
    public WebDriver driver;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    final By gender = By.xpath("//div[@class='radio-inline']");
    final By firstName = By.id("customer_firstname");
    final By lastName = By.id("customer_lastname");
    final By email = By.id("email");
    final By passwd = By.id("passwd");
    final By getFirstName = By.id("firstname");
    final By getLastName = By.id("lastname");
    final By address = By.id("address1");
    final By city = By.id("city");
    final By statedropdown = By.name("id_state");
    final By postcode = By.name("postcode");
    final By countrydropDown = By.name("id_country");
    final By phone_no = By.id("phone_mobile");
    final By reference = By.xpath("//input[@name=\"alias\"]");
    final By submitBtn = By.xpath("//button[@id='submitAccount']");

    public void enterPersonalInformation() {
        TestBase.driver.findElement(gender).click();

        String randomName = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(firstName).sendKeys(randomName);

        String randomName1 = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(lastName).sendKeys(randomName1);

        String randomEmail = RandomStringUtils.random(20, true, true);
        String email_id = randomEmail + "@gmail.com";
        TestBase.driver.findElement(email).sendKeys(email_id);

        String randompass = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(passwd).sendKeys(randompass);

        String randomName2 = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(getFirstName).sendKeys(randomName2);

        String randomName3 = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(getLastName).sendKeys(randomName3);

        String address1 = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(address).sendKeys(address1);

        String cityName = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(city).sendKeys(cityName);

        Select state = new Select((WebElement) statedropdown);
        state.selectByValue("4");

        String postcd = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(postcode).sendKeys(postcd);

        Select country = new Select((WebElement) countrydropDown);
        country.selectByVisibleText("United States");

        String phnno = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(phone_no).sendKeys(phnno);

        String ref_address = RandomStringUtils.random(10, true, true);
        TestBase.driver.findElement(reference).sendKeys(ref_address);
    }

    public void clickOnSubmitButton() {
        TestBase.driver.findElement(submitBtn).click();
    }
}
