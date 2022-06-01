package org.ecom.automation.Utils.PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationPage {
    public WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    By gender = By.xpath("//input[@id='id_gender1']");
    By firstName = By.id("customer_firstname");
    By lastName = By.id("customer_lastname");
    By email = By.id("email");
    By passwd = By.id("passwd");
    By getFirstName = By.id("firstname");
    By getLastName = By.id("lastname");
    By address = By.id("address1");
    By city = By.id("city");
    By statedropdown = By.name("id_state");
    By postcode = By.name("postcode");
    By countrydropDown = By.name("id_country");
    By phone_no = By.id("phone_mobile");
    By referenceadd = By.xpath("//input[@name=\"alias\"]");
    By submitBtn = By.id("submitAccount");

    public void enterPersonalInformation() {
        driver.findElement(gender).click();

        String randomName = RandomStringUtils.random(10, true, true);
        driver.findElement(firstName).sendKeys(randomName);

        String randomName1 = RandomStringUtils.random(10, true, true);
        driver.findElement(lastName).sendKeys(randomName1);

        String randomEmail = RandomStringUtils.random(20, true, true);
        String email_id = randomEmail + "@gmail.com";
        driver.findElement(email).sendKeys(email_id);

        String randompass = RandomStringUtils.random(10, true, true);
        driver.findElement(passwd).sendKeys(randompass);

        String randomName2 = RandomStringUtils.random(10, true, true);
        driver.findElement(getFirstName).sendKeys(randomName2);

        String randomName3 = RandomStringUtils.random(10, true, true);
        driver.findElement(getLastName).sendKeys(randomName3);

        String address1 = RandomStringUtils.random(10, true, true);
        driver.findElement(address).sendKeys(address1);

        String cityName = RandomStringUtils.random(10, true, true);
        driver.findElement(city).sendKeys(cityName);

        Select state = new Select((WebElement) statedropdown);
        state.selectByValue("4");

        String postcd = RandomStringUtils.random(10, true, true);
        driver.findElement(postcode).sendKeys(postcd);

        Select country = new Select((WebElement) countrydropDown);
        country.selectByVisibleText("United States");

        String phnno = RandomStringUtils.random(10, true, true);
        driver.findElement(phone_no).sendKeys(phnno);

        String ref_address = RandomStringUtils.random(10, true, true);
        driver.findElement(referenceadd).sendKeys(ref_address);
    }

    public void clickOnSubmitButton() {
        driver.findElement(submitBtn).click();
    }
}
