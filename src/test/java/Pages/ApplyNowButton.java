package Pages;

import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class ApplyNowButton {

    public SoftAssert softAssert= new SoftAssert();
    String PageInfo = "";
    public WebDriver driver;

    public void VerifyApplyNow(DataTable dataTable){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        try{
            List<Map<String,String>> dataTableValue = dataTable.asMaps(String.class, String.class);
        for(int i=0;i<dataTableValue.size();i++){
            String product = dataTableValue.get(i).get("product");
            String region = dataTableValue.get(i).get("region");
            String url = product + "." + region + "_URL";
            PageInfo = ConfigReader.getProperty(url);
            if (PageInfo == null) {
                throw new RuntimeException("URL not found for key: " + url);
            }
            PageInfo = PageInfo.replace("\"", "").trim();
            System.out.println("Clean URL = " + PageInfo);
            driver.get(PageInfo);
            driver.manage().window().setSize(new Dimension(1920,1080));


            if(product.equalsIgnoreCase("ITCHROME")){

                String headerApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJVR&ICMPGN=ACQ_CHROME_APPLY_NOW_TOP_BTN";
                String SeeIfYouPreApproved = "https://www.discovercard.com/application/preapproval/initial?ICMPGN=ACQ_DOUBLEPAIDSEARCH_SECURED_TOP_PREQUAL";
                String RTBApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJVR&ICMPGN=ACQ_CHROME_APPLY_NOW_RATES_BTN";
                String ContainerApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJVR&ICMPGN=ACQ_CHROME_GET_REWARDS_APPLY_NOW_BTN";
                String lowIntroApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJVR&ICMPGN=ACQ_CHROME_GET_REWARDS_APPLY_NOW_BTN";
                String ViewRelatedArticles = "https://www.discover.com/credit-cards/card-smarts/credit-card-rewards/";

                SoftAssert softAssert = new SoftAssert();

                String actaulheaader = driver.findElement(By.xpath("//*[@data-analytics-label='APPLY NOW:SECTION:TOP']")).getAttribute("href");
                String marqueActualHeader = actaulheaader.split("&adobe")[0];
                softAssert.assertEquals(marqueActualHeader, headerApplyNow,"ITCHROME marquee Apply now button is not match"+PageInfo);

                String ActualSeeIfYouPreApproved = driver.findElement(By.xpath("//*[@data-analytics-label='PREQUAL:SECTION:TOP']")).getAttribute("href");
                String marqueSeeIfYouPreApproved = ActualSeeIfYouPreApproved.split("&SCMPGN")[0];
                softAssert.assertEquals(marqueSeeIfYouPreApproved,SeeIfYouPreApproved,"IRCHROME marquee see if you pre-approve not match"+PageInfo);

                String RTBApplyNowCheck = driver.findElement(By.xpath("//*[@data-analytics-label='APPLY_NOW_REWARDS_BTN']")).getAttribute("href");
                String RTBSctionApplynow = RTBApplyNowCheck.split("&adobe_mc=TS")[0];
                softAssert.assertEquals(RTBSctionApplynow,RTBApplyNow,"IRCHROME RTB Apply now not match"+PageInfo);

                String ContainerApplyButton = driver.findElement(By.xpath("//*[@data-analytics-label='APPLY_NOW:SECTION:MIDDLE']")).getAttribute("href");
                String ContainerApplyNowButton = ContainerApplyButton.split("&adob" +
                        "e_mc")[0];
                softAssert.assertEquals(ContainerApplyNowButton,ContainerApplyNow,"IRCHROME Container Apply now not match"+PageInfo);

                String lowIntrobutton = driver.findElement(By.xpath("//*[@data-analytics-label='LOW_INTRO_APR :APPLYNOW']")).getAttribute("href");
                String lowIntroApply = lowIntrobutton.split("&adobe_mc=")[0];
                softAssert.assertEquals(lowIntroApply,lowIntroApplyNow,"ITCHROME low intro apply now not match"+PageInfo);

                String ViewAtrical = driver.findElement(By.xpath("//*[@data-analytics-label='REARDS ARTICLES: CHROME']")).getAttribute("href");
                softAssert.assertEquals(ViewAtrical,ViewRelatedArticles,"IRCHROME low rates and date button not match"+PageInfo);

                softAssert.assertAll();
                //driver.quit();
            }
            else if(product.equalsIgnoreCase("MILES")){

                String HeaderApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJX4&ICMPGN=redefine_travel_apply_top";
                String RTBSectionApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJX4&ICMPGN=rewards_travel_apply_mid";
                String LowIntroAPRApplyNow = "https://www.discovercard.com/application/website/apply?srcCde=GJVP&ICMPGN=CC_TRAVEL_APPLY_NOW_BTN";
                String TreavelCridetcardButton = "https://www.discover.com/credit-cards/card-smarts/credit-card-rewards/?cat=travel";

                String MarqueApplyNow = driver.findElement(By.xpath("//*[@data-analytics-label='REDEFINE_TRAVEL_APPLY_TOP']")).getAttribute("href");
                String MarqueApplyNowButton = MarqueApplyNow.split("&adobe")[0];
                softAssert.assertEquals(HeaderApplyNow,MarqueApplyNowButton,"MILSE marquee Apply now button is not match"+PageInfo);

                String RTBApplyNow = driver.findElement(By.xpath("//*[@data-analytics-label='STARTER:PREQUAL']")).getAttribute("href");
                String RTBApplyNowButton = RTBApplyNow.split("&adobe")[0];
                softAssert.assertEquals(RTBSectionApplyNow,RTBApplyNowButton,"MILSE RTB Apply now not match" + PageInfo);

                String LowIntroAPRButton = driver.findElement(By.xpath("//*[@data-analytics-label='LOW_INTRO_APR :APPLYNOW']")).getAttribute("href");
                String LowIntroAPRButtonSection = LowIntroAPRButton.split("&adobe")[0];
                softAssert.assertEquals(LowIntroAPRApplyNow,LowIntroAPRButtonSection,"MILSE Low intro apply now button not match" +PageInfo);

                String TravelCCridetcardButton = driver.findElement(By.xpath("//*[@data-analytics-label='CS_VIEWTRAVELARTICLES']")).getAttribute("href");
                softAssert.assertEquals(TravelCCridetcardButton,TreavelCridetcardButton,"MILSE Travel Apply now button not match"+PageInfo);

                softAssert.assertAll();
                //driver.quit();
            }
        }
    }finally {
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
