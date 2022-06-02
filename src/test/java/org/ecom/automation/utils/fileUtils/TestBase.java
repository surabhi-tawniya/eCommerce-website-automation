package org.ecom.automation.utils.fileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

public class TestBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    private static WebDriver driver;
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
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "E:\\Drivers\\chromedriver.exe");
                driver = new FirefoxDriver();
                break;
            case "internet explorer":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "E:\\Drivers\\chromedriver.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }

    public static String readUrlFromDataProperties() throws IOException {
        properties = new Properties();
        FileReader File = new FileReader("src/test/resources/data/data.properties");
        properties.load(File);
        String data = properties.getProperty("url");
        driver.get(data);
        LOGGER.info(data);
        return data;
    }
}
