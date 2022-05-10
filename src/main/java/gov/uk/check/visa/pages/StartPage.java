package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class StartPage extends Utility {
    public StartPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//a[normalize-space()='Start now'])[1]")
    WebElement startNowButton;
    public void clickOnStartButton(){
        clickOnElement(startNowButton);
        Reporter.log("Click on start button"+ startNowButton.toString()+"<br>");
    }
}
