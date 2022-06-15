package org.ecom.automation.utils.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.ecom.automation.utils.pageObjects.AddToCartPage;
import org.ecom.automation.utils.pageObjects.HomePage;
import org.ecom.automation.utils.pageObjects.SearchedProduct;
import org.openqa.selenium.WebDriver;

public class SearchProductStepDef extends TestBase {
    public WebDriver driver;

    public SearchProductStepDef() {
    }

    @When("I clicks on search text box")
    public void iClicksOnSearchTextBox() {
        HomePage homePage = new HomePage(TestBase.driver);
        homePage.clickOnSearchBox();
    }

    @And("search for {string} product")
    public void searchForProduct(String productName) {
        HomePage homePage = new HomePage(TestBase.driver);
        homePage.searchProduct(productName);
    }

    @Then("similar product list should be displayed")
    public void similarProductListShouldBeDisplayed() {
        SearchedProduct product = new SearchedProduct(TestBase.driver);
        product.getProductList();
        product.setProductSort();
    }

    @And("I sort the product using category")
    public void iSortTheProductUsingCategory() {
        SearchedProduct product = new SearchedProduct(TestBase.driver);
        product.setProductSort();
    }

    @And("I navigate to the particular product")
    public void iNavigateToTheParticularProduct() {
        SearchedProduct product = new SearchedProduct(TestBase.driver);
        product.navigateToProduct();
    }

    @Then("I click on Add to cart button")
    public void iClickOnAddToCartButton() {
        AddToCartPage cartPage = new AddToCartPage(TestBase.driver);
        cartPage.clickOnAddToCart();
        tearDown();
    }
}
