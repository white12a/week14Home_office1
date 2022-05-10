package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyImmigrationStatusPage extends Utility {
    public FamilyImmigrationStatusPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement yes;

    @FindBy(xpath ="//label[normalize-space()='No']" )
    WebElement no;

    public void selectImmigrationStatusPage(String status){
    switch (status){
        case "yes":
            clickOnElement(yes);
            break;
        case "No":
            clickOnElement(no);
            break;
        default:
            System.out.println("please select one of the option");
    }
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
