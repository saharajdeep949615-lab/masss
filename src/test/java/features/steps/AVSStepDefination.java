package features.steps;

import Pages.ApplyNowButton;
import Pages.CashBackTextValidation;
import Pages.FAQTextCheck;
import Pages.FooterLinkPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static Pages.FAQTextCheck.driver;



public class AVSStepDefination {

    public FooterLinkPage FA;
    public ApplyNowButton AB;
    public CashBackTextValidation CV;
    public FAQTextCheck FQ;

    public AVSStepDefination(){
        FA = new FooterLinkPage();
        AB = new ApplyNowButton();
        CV = new CashBackTextValidation();
        FQ = new FAQTextCheck(driver);
    }

    @Given("Validation footer link present in the Validation")
    public void Validation_footer_link_present_in_the_Validation(DataTable dataTable){
        FA.VerifyFooterLink(dataTable);
    }
    @Given("DFSEDKEY is not present in the Validation")
    public void DFSEDKEY_is_not_present_in_the_Validation(DataTable dataTable){
        AB.VerifyApplyNow(dataTable);
    }
    @Given("^Verify each section in the respective \"(.*)\" page in \"(.*)\" view \"(.*)\" region$")
    public void Verfiy_redesigned_section(String product, String view, String region){
        CV.VerifyTextValidation(product,view,region);
    }
    @Given("^FAQ items are displayed \"(.*)\" in the respective \"(.*)\" page in \"(.*)\" view \"(.*)\" region$")
    public void Verify_FAQ_items_are_displayed(String faqDisplayed,String product,String view,String region){
            FQ.verifyFAQValidation(product,region,faqDisplayed);
            if(faqDisplayed.equalsIgnoreCase("YES")) {
                if (FAQTextCheck.getSeeMoreFAQButton().isDisplayed()) {
                    FAQTextCheck.getSeeMoreFAQButton().click();
                } else {
                    System.out.println("No FAQ there");
                }
            }
      }
}