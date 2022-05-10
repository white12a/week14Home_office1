package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkTypePage extends Utility {
    public WorkTypePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='govuk-radios']/div/label")
    List<WebElement> planningToWorkTypes;
    public void selectPlanningToWorkTypes(String workType){
        for(WebElement work:planningToWorkTypes){
            if(work.getText().equalsIgnoreCase(workType)){
                clickOnElement(work);
            }
        }
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueBtn;
    public void clickOnContinueButton(){
        clickOnElement(continueBtn);
    }


}
