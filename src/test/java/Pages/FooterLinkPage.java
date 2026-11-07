package Pages;

import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class FooterLinkPage {

    public SoftAssert softAssert = new SoftAssert();
    public String PageInfo = "";

    public void VerifyFooterLink(DataTable dataTable){
        WebDriver driver = null;
        try{
            List<Map<String,String>> dataTableValue = dataTable.asMaps(String.class, String.class);
        driver = new ChromeDriver();
        for(int i = 0; i < dataTableValue.size(); i++){
            String product = dataTableValue.get(i).get("product");
            String region  = dataTableValue.get(i).get("region");
            String key = product + "." + region + "_URL";
            PageInfo = ConfigReader.getProperty(key);
            if (PageInfo == null) {
                throw new RuntimeException("URL not found for key: " + key);
            }
            PageInfo = PageInfo.replace("\"", "").trim();
            System.out.println("Clean URL = " + PageInfo);
            driver.manage().window().maximize();
            driver.get(PageInfo);
        }
        String[] ExpectedProdLinks = {
                "https://www.discover.com/credit-cards/?ICMPGN=PUB_FTR_QL_ALL_CREDIT_CARDS",
                "https://www.discovercard.com/application/preapproval/initial?ICMPGN=PUB_FTR_QL_PRE_QUALIFIED",
                "https://www.discovercard.com/application/website/invite?ICMPGN=ALL_CC_DM_INVITE_ICON",
                "https://www.discover.com/credit-cards/cardmember-agreement/?ICMPGN=PUB_FTR_QL_CARD_AGREEMENT",
                "https://www.discover.com/credit-cards/member-benefits/?ICMPGN=PUB_FTR_QL_MEMBER_BENEFITS",
                "https://www.discover.com/online-banking/banking-features/atm-locator/?ICMPGN=PUB_FTR_QL_ATM_LOCATOR",
                "https://www.discover.com/credit-cards/cash-back/?ICMPGN=PUB_FTR_CCC_CB_CARD",
                "https://www.discover.com/credit-cards/student-credit-card/?ICMPGN=PUB_FTR_CCC_STUDENT_CARD",
                "https://www.discover.com/credit-cards/secured-credit-card/?ICMPGN=PUB_FTR_CCC_SECURED_CARD",
                "https://www.discover.com/credit-cards/travel/?ICMPGN=PUB_FTR_CCC_TRAVEL_CARD",
                "https://www.discover.com/credit-cards/compare/?ICMPGN=PUB_FTR_CCC_COMPARE_CARDS",
                "https://www.discover.com/credit-cards/gas-credit-cards/?ICMPGN=PUB_FTR_CCC_GAS_CREDIT_CARDS",
                "https://www.discover.com/credit-cards/balance-transfer-credit-cards/?ICMPGN=PUB_FTR_CCF_BALANCE_TRANSFER",
                "https://www.discover.com/credit-cards/secured-credit-card/credit-cards-to-build-credit/?ICMPGN=PUB_FTR_CCF_CARDS_TO_BUILD_CREDIT",
                "https://www.discover.com/credit-cards/no-annual-fee-credit-cards/?ICMPGN=PUB_FTR_CCF_NAF",
                "https://www.discover.com/credit-cards/low-intro-apr-credit-cards/?ICMPGN=PUB_FTR_CCF_LOW_INTRO_APR",
                "https://www.discover.com/credit-cards/credit-cards-for-no-credit/?ICMPGN=PUB_FTR_CCF_CARDS_FOR_NO_CREDIT",
                "https://www.discover.com/credit-cards/instant-use-credit-cards/?ICMPGN=PUB_FTR_CCF_INSTANT_USE_CREDIT",
                "https://www.discover.com/credit-cards/card-smarts/?ICMPGN=PUB_FTR_CRC_CREDIT_RESOURCE_CENTER",
                "https://www.discover.com/credit-cards/card-smarts/getting-a-credit-card/?ICMPGN=PUB_FTR_CRC_GETTING_CREDIT_CARD",
                "https://www.discover.com/credit-cards/card-smarts/using-your-credit-card/?ICMPGN=PUB_FTR_CRC_USING_CREDIT_CARD",
                "https://www.discover.com/credit-cards/card-smarts/credit-card-rewards/?ICMPGN=PUB_FTR_CRC_CREDIT_CARD_REWARDS",
                "https://www.discover.com/credit-cards/credit-card-calculator/credit-card-interest-calculator/?ICMPGN=PUB_FTR_CRC_INTEREST_CALCULATOR",
                "https://www.discover.com/credit-cards/credit-card-calculator/balance-transfer-calculator/?ICMPGN=PUB_FTR_CRC_BT_CALCULATOR",
                "https://www.discover.com/credit-cards/rewards-credit-cards/?ICMPGN=PUB_FTR_CBR_REWARDS_CREDIT_CARDS",
                "https://www.discover.com/credit-cards/cash-back/cashback-bonus.html?ICMPGN=PUB_FTR_CBR_CASH_REWARDS",
                "https://www.discover.com/credit-cards/cash-back/cashback-calendar.html?ICMPGN=PUB_FTR_CBR_CASHBACK_CALENDAR",
                "https://www.discover.com/credit-cards/exclusives/sharediscover/?ICMPGN=PUB_FTR_CBR_REFER_FRIEND",
                "https://www.discover.com/online-banking/?ICMPGN=PUB_FTR_PRODUCTS_BANKING",
                "https://www.discover.com/personal-loans/?ICMPGN=PUB_FTR_PRODUCTS_PERSONAL_LOANS",
                "https://www.discover.com/personal-loans/debt-consolidation/?ICMPGN=PUB_FTR_PRODUCTS_DEBT_CONSOLIDATION",
                "https://www.discover.com/site-map/?ICMPGN=PUB_FTR_QUICK_LINKS_SITEMAP",
                "https://www.discover.com/discover-terms-of-use/?ICMPGN=PUB_FTR_QUICK_LINKS_TERMS_OF_USE",
                "https://www.discover.com/accessibility/?ICMPGN=PUB_FTR_QUICK_LINKS_ACCESSIBILITY",
                "https://www.discover.com/credit-cards/browser-support/?ICMPGN=PUB_FTR_QUICK_LINKS_BROWSER_SUPPORT",
                "https://www.discover.com/privacy-statement/?ICMPGN=PUB_FTR_QUICK_LINKS_PRIVACY",
                "https://www.discover.com/cpra/form",
                "https://info.evidon.com/pub_info/1142?v=1",
                "https://discover.promo.eprize.com/discoversweeps25/?cmpgnid=site-sch-pro-dis-foote",
                "https://www.discover.com/credit-cards/contact-us/?ICMPGN=PUB_FTR_ABOUT_US_CONTACT_US",
                "https://www.discover.com/company/",
               //"https://investor.capitalone.com/corporate-governance/governance-overview?campaignid=ggl_search_apac",
                "https://www.discover.com/company/impact/home/",
                //"https://investor.capitalone.com/",
                "https://investorrelations.discover.com/investor-relations/overview/default.asp",
                //"https://www.capitalone.com/about/newsroom/",
                "https://www.discover.com/company/newsroom/",
                "https://www.capitalonecareers.com/discover?utm_source=WWW_Footer&utm_medium=Footer_DFS_Landing_Page",
                "https://www.discoverglobalnetwork.com/our-network/how-we-partner/",
                //"https://www.discover.com/company/inclusion-and-belonging/home/?SCMPGN=HELP_ACCTMANAGE_USERS_ACCOUNTCENTER_TXT"
                "https://www.discover.com/company/dei/home/"
        };
        List<WebElement> all_footer_link_check =
                driver.findElements(By.xpath("//div[@class='footer__nav']//div//ul//li//a"));
        for(int i=0;i<all_footer_link_check.size();i++){
            String actualLink = all_footer_link_check.get(i).getAttribute("href");
            String ExpectedLink = ExpectedProdLinks[i];
            assert actualLink != null;
            softAssert.assertTrue(actualLink.contains(ExpectedLink),
                    "\n Footer Link Not Matching at index: " + i +
                            "\nExpected should contain: " + ExpectedLink +
                            "\nActual: " + actualLink);
        }
        softAssert.assertAll();
    }finally {
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
