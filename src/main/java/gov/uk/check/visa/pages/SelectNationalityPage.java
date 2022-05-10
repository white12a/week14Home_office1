package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    public SelectNationalityPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@class='govuk-select']")
    WebElement nationalityDropDownList;
    public void selectNationalityFromDropdown(String nationality){
        selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
        Reporter.log("select nationality"+nationalityDropDownList.toString()+"<br>");
    }

}
