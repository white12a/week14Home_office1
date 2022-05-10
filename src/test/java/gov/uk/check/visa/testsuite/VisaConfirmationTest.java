package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        durationOfStayPage=new DurationOfStayPage();
        familyImmigrationStatusPage=new FamilyImmigrationStatusPage();
        reasonForTravelPage=new ReasonForTravelPage();
        resultPage=new ResultPage();
        selectNationalityPage=new SelectNationalityPage();
        startPage=new StartPage();
        workTypePage=new WorkTypePage();
    }
    @Parameters({"nationality1","reason1","expectedMessage1"})
    @Test(priority = 2,groups = {"sanity","regression"})
    public void anAustralianComingToUKForTourism(@Optional("Australia") String nationality,@Optional("Tourism or visiting family and friends") String reason,@Optional("You will not need a visa to come to the UK") String expectedMessage){
        //Click on start button
        startPage.clickOnStartButton();
        //Select a Nationality 'Australia'
        selectNationalityPage.selectNationalityFromDropdown(nationality);
        //Click on Continue button
        reasonForTravelPage.ClickOnContinueButton();
        //Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit(reason);
        //Click on Continue button
        reasonForTravelPage.ClickOnContinueButton();
        //verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMessage(expectedMessage);


    }
    @Parameters({"nationality2","reason2","expectedMessage2","durationOfStay","planning"})
    @Test(priority = 1,groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(@Optional("Chile") String nationality,@Optional("Work, academic visit or business") String reason,@Optional("You need a visa to work in health and care") String expectedMessage,@Optional("longer than 6 months") String time,@Optional("Health and care professional")String work1){
        //Click on start button
        startPage.clickOnStartButton();
        //Select a Nationality 'Chile'
        selectNationalityPage.selectNationalityFromDropdown(nationality);
        //Click on Continue button
        reasonForTravelPage.ClickOnContinueButton();
        //Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit(reason);
        //Click on Continue button
        reasonForTravelPage.ClickOnContinueButton();
        //Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay(time);
        //Click on Continue button
        durationOfStayPage.ClickOnContinueButton();
        //Select have planning to work for 'Health and care professional'
        workTypePage.selectPlanningToWorkTypes(work1);
        //Click on Continue button
        workTypePage.clickOnContinueButton();
        //verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMessage(expectedMessage);

    }
    @Parameters({"nationality3","reason3","immigration","expectedMessage3"})
    @Test(groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card
            (@Optional("Colombia") String nationality,@Optional("Join partner or family for a long stay") String reason,@Optional("yes") String status,@Optional("You’ll need a visa to join your family or partner in the UK") String expectedMessage){
       // Click on start button
        startPage.clickOnStartButton();
        // Select a Nationality 'Colombia'
        selectNationalityPage.selectNationalityFromDropdown(nationality);
        // Click on Continue button
        reasonForTravelPage.ClickOnContinueButton();
        // Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit(reason);
        // Click on Continue button
        reasonForTravelPage.ClickOnContinueButton();
        // Select state My partner of family member have uk immigration status 'yes' Click on Continue button
        familyImmigrationStatusPage.selectImmigrationStatusPage(status);
        //Click on Continue button
        familyImmigrationStatusPage.clickOnContinueButton();
       // verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMessage(expectedMessage);
    }

}
