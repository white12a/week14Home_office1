package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    public void ClickOnContinueButton(){
        clickOnElement(continueButton);
    }

    @FindBy(xpath = "//div[@class='govuk-radios']/div")
    List<WebElement> reasonForVisit;
    public void selectReasonForVisit(String reason){
        for(WebElement reasonList:reasonForVisit){
            if(reasonList.getText().equalsIgnoreCase(reason)){
              clickOnElement(reasonList);
            }
        }
    }
}
