import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OnlineShoppingStepDef {
    WebDriver driver;

    @Given("browser is open")
    public void browserIsOpen() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "E:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("user navigates to url \\{string}")
    public void userNavigatesToUrlString() {
        String URL = "http://automationpractice.com/index.php";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @And("verifying that the home page is visible successfully")
    public void verifyingThatTheHomePageIsVisibleSuccessfully() {
        String Actual = driver.getTitle();
        String Expected = "My Store";
        if (Actual.equals(Expected)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    }

    @And("user clicks on Sign-in link")
    public void user_clicks_on_sign_in_link() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @And("user enters email id in create an account section")
    public void userEntersEmailIdInCreateAnAccountSection() {
        driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("surabhi.s.oza@gmail.com");
    }

    @And("clicks create an account button")
    public void clicks_create_an_account_button() {
        driver.findElement(By.xpath("//div[@class='submit']")).click();
    }

    @And("user enters his personal information")
    public void user_enters_his_personal_information() {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//input[@name='id_gender']")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("Test User");
        driver.findElement(By.name("customer_lastname")).sendKeys("Vsoft");
        driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
        driver.findElement(By.id("firstname")).sendKeys("Test User");
        driver.findElement(By.id("lastname")).sendKeys("Vsoft");
        driver.findElement(By.id("company")).sendKeys("Vsoft");
        driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
        driver.findElement(By.id("city")).sendKeys("XYZ");

        WebElement statedropdown = driver.findElement(By.name("id_state"));
        Select state = new Select(statedropdown);
        state.selectByValue("4");

        driver.findElement(By.name("postcode")).sendKeys("51838");

        WebElement countrydropDown = driver.findElement(By.name("id_country"));
        Select country = new Select(countrydropDown);
        country.selectByVisibleText("United States");

        driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
        driver.findElement(By.name("submitAccount")).click();
        String userText = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
    }

    @And("clicks on Registration button")
    public void clicks_on_registration_button() {
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span0")).click();
    }

    @Then("user created successfully")
    public void user_created_successfully() {
        String userText = null;
        if (userText.contains("Vsoft")) {
            System.out.println("User Verified,Test case Passed");
        } else {
            System.out.println("User Verification Failed,Test case Failed");
        }
        driver.close();
    }
}




