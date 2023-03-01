package Steps;

import Pages.CompendiumContactPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Compendium_steps {
    WebDriver driver;
    CompendiumContactPage compendiumContactPage;
    @Before
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://compendiumdev.co.uk/");
        driver.manage().window().maximize();
        compendiumContactPage=new CompendiumContactPage(driver);
    }
    @After
    public void killSession()
    {
        driver.quit();
    }
    @Given("open the application")
    public void open_the_application() {
        System.out.println("User open the application");
    }

    @Then("Click on contact")
    public void click_on_contact() {
        compendiumContactPage.clickONContact();
        System.out.println("User click on contact");

    }
    @Then("Enter the required field")
    public void enter_the_required_field() throws InterruptedException {
        compendiumContactPage.entertheField();
        System.out.println("User enter the field");

    }
    @Then("Submit the form")
    public void submit_the_form() throws InterruptedException {
        compendiumContactPage.submitButton();
Assert.assertTrue(compendiumContactPage.verifyPage());
        System.out.println("User submit the application");

    }
    @Then("close the browser")
    public void close_the_browser() {
        System.out.println("User close the browser");

    }

}
