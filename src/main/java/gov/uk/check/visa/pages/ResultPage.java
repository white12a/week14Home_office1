package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='result-info']/div[2]/h2")
    WebElement resultMessage;

    public String getResultMessage(){
        String actualMessage=getTextFromElement(resultMessage);
        return actualMessage;
    }
    public void confirmResultMessage(String expectedMessage){
        if(getResultMessage().equalsIgnoreCase(expectedMessage)){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }



}