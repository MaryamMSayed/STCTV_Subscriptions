package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages_helper.ElementsActions;

import java.util.Arrays;
import java.util.List;

public class SubscriptionsPage {
    private final WebDriver driver;
    private final By countrySelectionBtn= By.id("country-btn");
    private final By selectKSA= By.partialLinkText("KSA");
    private final By selectKuwait= By.id("kw");
    private final By selectBahrain= By.id("bh");
    private final By closePopUp= By.id("country-poppup-close");
    private final By planTitle=By.className("plan-title");
    private final By price=By.className("price");
   private final List<String> expectedNames = Arrays.asList("LITE", "CLASSIC", "PREMIUM");

    public List <WebElement> packagesNamesList;
    public List <WebElement> packagesPrices;


    public SubscriptionsPage(WebDriver driver) {
        this.driver = driver;
    }

@Step ("Open country Selection Pop up")
public SubscriptionsPage openCountrySelectionPopUp()
{
    ElementsActions.click(driver,countrySelectionBtn);
return this;
}
@Step ("Select Country ")
public SubscriptionsPage selectedCountry(String countryName)
{

    System.out.println("name selected " + countryName);
    if (countryName.equals("KSA"))
    {
        List<String> expectedPrices= Arrays.asList("15 SAR/month" , "25 SAR/month", "60 SAR/month", "FREE");
        ElementsActions.click(driver, selectKSA);
        System.out.println("selected country is " + countryName);
        packagesNamesList= ElementsActions.findElements(driver, planTitle);
        // Compare and validate packages names
        compareListsValues(expectedNames, packagesNamesList);
        packagesPrices=ElementsActions.findElements(driver, price);
        compareListsValues(expectedPrices , packagesPrices);
    }
    else if (countryName .equals("Bahrain"))
    {
        List<String> expectedPrices= Arrays.asList("2 BHD/month" , "3 BHD/month", "6 BHD/month", "FREE");
        ElementsActions.click(driver, selectBahrain);
        System.out.println("Selected Country is : " + countryName);
        packagesNamesList= ElementsActions.findElements(driver, planTitle);
        // Compare and validate packages names
        compareListsValues(expectedNames, packagesNamesList);
        packagesPrices=ElementsActions.findElements(driver, price);
        compareListsValues(expectedPrices , packagesPrices);
    }
    else
    {
        List<String> expectedPrices= Arrays.asList("1.2 KWD/month" , "2.5 KWD/month", "4.8 KWD/month", "FREE");
        ElementsActions.click(driver, selectKuwait);
        System.out.println("Selected Country is : " + countryName);
        packagesNamesList= ElementsActions.findElements(driver, planTitle);
        // Compare and validate packages names
        compareListsValues(expectedNames, packagesNamesList);
        packagesPrices=ElementsActions.findElements(driver, price);
        compareListsValues(expectedPrices , packagesPrices);
    }
    return this;
}
@Step ("Close the country selection POP UP ")
    public SubscriptionsPage closeCountryPopUp()
{
    ElementsActions.click(driver, closePopUp);
    return this;
}

protected void compareListsValues(List<String> exp, List<WebElement> actual)
{
    for(int i=0; i<actual.size(); i++)
    {
        Assert.assertEquals(actual.get(i).getText(), exp.get(i));
        System.out.println("Matched");
    }
}

}
