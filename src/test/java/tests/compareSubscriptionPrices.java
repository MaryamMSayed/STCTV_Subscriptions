package tests;

import data.LoadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.SubscriptionsPage;
import tests_helper.Helper;


import java.util.concurrent.TimeUnit;

public class compareSubscriptionPrices {
    public static WebDriver driver;
    String ksa = LoadProperties.country.getProperty("country1");

    String bahrain = LoadProperties.country.getProperty("country2");
    String kuwait = LoadProperties.country.getProperty("country3");

    @Parameters("browser")
    @BeforeClass
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://subscribe.stctv.com/sa-en");
    }

    @Test(description = "Given user at home " +
            "When i click on Country selection button" +
            "And i select country named []"
            + "Then Packages names will be displayed accordingly"
            + "And Packages currencies will be changed to the selected country's currency", priority = 1)
    @Description("User will select a country names [KSA] and validate displayed packages and currency ")
    @Severity(SeverityLevel.CRITICAL)
    public void selectKSA() {
        new SubscriptionsPage(driver).openCountrySelectionPopUp().selectedCountry(ksa).closeCountryPopUp();
    }

    @Test(description = "Given user at home " +
            "When i click on Country selection button" +
            "And i select country named []"
            + "Then Packages names will be displayed accordingly"
            + "And Packages currencies will be changed to the selected country's currency", priority = 2)
    @Description("User will select a country names [bahrain] and validate displayed packages and currency ")
    @Severity(SeverityLevel.CRITICAL)
    public void selectBahrain() {
        new SubscriptionsPage(driver).openCountrySelectionPopUp().selectedCountry(bahrain).closeCountryPopUp();
    }

    @Test(description = "Given user at home " +
            "When i click on Country selection button" +
            "And i select country named []"
            + "Then Packages names will be displayed accordingly"
            + "And Packages currencies will be changed to the selected country's currency", priority = 3)
    @Description("User will select a country names [Kuwait] and validate displayed packages and currency ")
    @Severity(SeverityLevel.CRITICAL)
    public void selectKuwait() {
        new SubscriptionsPage(driver).openCountrySelectionPopUp().selectedCountry(kuwait).closeCountryPopUp();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());

        }
    }

    @AfterClass
    public void stopDriver() {

        driver.quit();
    }
}
