package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@id='response-0'])[1]")
    WebElement sixMonthOrLess;

    @FindBy(xpath = "(//input[@id='response-1'])[1]")
    WebElement sixMonthOrMore;

    public void selectLengthOfStay(String moreOrLess){
       switch (moreOrLess){
           case "6 months or less":
               clickOnElement(sixMonthOrLess);
               break;
           case "longer than 6 months":
               clickOnElement(sixMonthOrMore);
               break;
           default:
               System.out.println("please enter valid input");
       }
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueBtn;
    public void ClickOnContinueButton(){
        clickOnElement(continueBtn);
    }


}
