package Pages;

import CommonMetho.SeleniumActions;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CompendiumContactPage {
    WebDriver driver;
    SeleniumActions seleniumActions;

    public CompendiumContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//div[@id='cssmenu']/ul/li[2]/a[text()='Contact']")
    WebElement contact;

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement message;

    @FindBy(xpath = "//div[@class='g-FormField2-InputPanel']/div[@class='CheckBoxContainer']/div[@role='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//div[@class='ImLeButtonMainContent']/span[text()='Send']")
    WebElement submit;
    @FindBy(xpath = "//div[@class='Success']")
    WebElement verify;

    public void clickONContact() {
        seleniumActions.clickOnElement(contact);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
    }

    public void entertheField() throws InterruptedException {
        seleniumActions.EnterValueOnTextfield(name, "Aditi");
        seleniumActions.EnterValueOnTextfield(email, "adanfur@gmail.com");
        seleniumActions.EnterValueOnTextfield(message, "Hi hello how are you");
        seleniumActions.clickOnElement(checkbox);
    }

    public void submitButton() throws InterruptedException {
        Thread.sleep(2000);

        seleniumActions.javascriptExcecutorClick(submit);
        //submit.click();
    }

    public boolean verifyPage() throws InterruptedException {
        Thread.sleep(1000);
      return verify.isDisplayed();
    }
}



