package org.ecom.automation.utils.fileUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    private static Properties properties;

    public TestBase() {
    }


    public static WebDriver initializeDriver() throws IOException {
        properties = new Properties();
        FileReader File = new FileReader("src/test/resources/data/data.properties");
        properties.load(File);
        String browserName = properties.getProperty("browser");
        LOGGER.info(browserName);

        switch (browserName) {
            case "chrome":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "E:\\Drivers\\chromedriver102.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "E:\\Drivers\\chromedriver102.exe");
                driver = new FirefoxDriver();
                break;
            case "internet explorer":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "E:\\Drivers\\chromedriver102.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }


    public static String  navigatesToSite(String urlName) throws IOException {
        properties = new Properties();
        FileReader File = new FileReader("src/test/resources/data/data.properties");
        properties.load(File);
        String url = properties.getProperty("url");
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        LOGGER.info(url);
        return urlName;
    }


    public static void tearDown(){
        driver.close();
    }
}
