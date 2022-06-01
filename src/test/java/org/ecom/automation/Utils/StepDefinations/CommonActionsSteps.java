package org.ecom.automation.Utils.StepDefinations;

import org.ecom.automation.Utils.FileUtils.TestBase;
import org.ecom.automation.Utils.PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CommonActionsSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonActionsSteps.class);
    private static String url;
    private WebDriver driver;


    public CommonActionsSteps(WebDriver driver){
        this.driver = driver;
    }

    public void initializeTheBrowserWithChrome() throws IOException {
        driver = initializeDriver();
    }

    public String navigatesToSite(String url) throws IOException {
        CommonActionsSteps.url = url;
        url = readUrlFromDataProperties();
        driver.get(url);
        driver.manage().window().maximize();
        return url;
    }

    public void verifyTheTitleOfTheHomepage() {
        HomePage homePage = new HomePage(driver);
        String title1 = homePage.verifyHomePageTitle();
        LOGGER.info(title1);
    }
}
