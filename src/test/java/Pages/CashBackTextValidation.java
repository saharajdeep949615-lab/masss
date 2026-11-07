package Pages;

import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CashBackTextValidation {

    private ArrayList<String> getFirstSection(){
        List<WebElement> firstSection = driver.findElements(By.xpath("(//div[@class='stylesystemclass']//div[contains(@class,'two-column__content-half')])[1]"));
        ArrayList<String> firstText = new ArrayList<>();
        for(int i=0;i<firstSection.size();i++){
            firstText.add(firstSection.get(i).getText());
        }
        return firstText;
    }

    private ArrayList<String> getSeconedSection(){
        List<WebElement> SeconedSection = driver.findElements(By.xpath("//section[@id='RTB-chrome-it']"));
        ArrayList<String> SeconedText = new ArrayList<>();
        for(int i=0;i<SeconedSection.size();i++){
            SeconedText.add(SeconedSection.get(i).getText());
        }
        return SeconedText;
    }

    private ArrayList<String> getThirdText(){
        List<WebElement> ThirdSection = driver.findElements(By.xpath("//section[@id='review__container']"));
        ArrayList<String> ThirdText = new ArrayList<>();
        for(int i=0;i<ThirdSection.size();i++){
            ThirdText.add(ThirdSection.get(i).getText());
        }
        return ThirdText;
    }

    private ArrayList<String> getFourthText(){
        List<WebElement> FourthSection = driver.findElements(By.xpath("//*[@id='rtb-new']"));
        ArrayList<String> FourthText = new ArrayList<>();
        for(int i=0;i<FourthSection.size();i++){
            FourthText.add(FourthSection.get(i).getText());
        }
        return FourthText;
    }

    private ArrayList<String> getFifthText(){
        List<WebElement> fifthSection = driver.findElements(By.xpath("//*[@id='cardsmarts-articles']"));
        ArrayList<String> fifthText = new ArrayList<>();
        for(int i=0;i< fifthSection.size();i++){
            fifthText.add(fifthSection.get(i).getText());
        }
        return fifthText;
    }

    private ArrayList<String> getSeeLowIntroAPR() {
        List<WebElement> lowIntroAPRSection = driver.findElements(By.xpath("//*[@id='it-lir']"));
        ArrayList<String> lowIntroAPRText = new ArrayList<>();
        for(int i=0;i<lowIntroAPRSection.size();i++){
            lowIntroAPRText.add(lowIntroAPRSection.get(i).getText());
        }
        return lowIntroAPRText;
    }

    public WebDriver driver=null;

    public void VerifyTextValidation(String product, String view, String region) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        try{
            String urlKey = product + "."  + region + "_URL";
            String PageInfo = ConfigReader.getProperty(urlKey);
            if (PageInfo == null) {
                throw new RuntimeException("URL not found for key: " + urlKey);
            }
            PageInfo = PageInfo.replace("\"", "").trim();

            driver.get(PageInfo);
            driver.manage().window().setSize(new Dimension(1920,1080));

            if(product.equalsIgnoreCase("ITCHROME")){
                SoftAssert softAssert = new SoftAssert();
                List<String> firstSectionCheck = getFirstSection();
                String HeaderText = firstSectionCheck.get(0).split("\n")[0];
                softAssert.assertEquals(HeaderText,"Discover it® Chrome","ITCHROME Header is not matched"+product);
                String MarqueHeader = firstSectionCheck.get(0).split("\n")[1].trim();
                softAssert.assertEquals(MarqueHeader,"Earn cash back at restaurants and gas stations on road trips","ITCHROME Marquee header is not matched"+product);
                String MaarqueHeaderText = firstSectionCheck.get(0).split("\n")[2].trim();
                softAssert.assertEquals(MaarqueHeaderText,"Earn 2% Cashback Bonus® at Gas Stations and Restaurants on up to $1,000 in combined purchases each quarter, automatically.1","MarqueeHeaderText is not matched"+product);
                String NoAnualFee = firstSectionCheck.get(0).split("\n")[6].trim();
                softAssert.assertEquals(NoAnualFee,"No annual fee","ITCHROME No ANuall fee not match"+product);

                List<String> SeconedSectionCheck = getSeconedSection();
                String RTBFirstHeader = SeconedSectionCheck.get(0).split("\n")[0].trim();
                softAssert.assertEquals(RTBFirstHeader,"Earn 2% Cash Back",""+product);
                String RTBFirstSectionText = SeconedSectionCheck.get(0).split("\n")[1].trim();
                softAssert.assertEquals(RTBFirstSectionText,"Earn 2% cash back at Gas Stations and Restaurants on up to $1,000 in combined purchases each quarter, automatically.†† Plus, earn unlimited 1% cash back on all other purchases.1",""+product);
                String RTBText = SeconedSectionCheck.get(0).split("\n")[3].trim();
                softAssert.assertEquals(RTBText,"Plus, your cash back won’t expire for the life of the account 2",""+product);
                String RTBSeconedHeader = SeconedSectionCheck.get(0).split("\n")[4].trim();
                softAssert.assertEquals(RTBSeconedHeader,"Unlimited Cashback Match",""+product);
                String RTBSeconedsectionText = SeconedSectionCheck.get(0).split("\n")[5].trim();
                softAssert.assertEquals(RTBSeconedsectionText,"Get an unlimited dollar-for-dollar match of all the cash back you earn at the end of your first year, automatically. There is no limit to how much we’ll match.2",""+product);
                String RTBThirdHeader = SeconedSectionCheck.get(0).split("\n")[6].trim();
                softAssert.assertEquals(RTBThirdHeader,"$0 Fraud Liability",""+product);
                String RTBThirdSectionText = SeconedSectionCheck.get(0).split("\n")[7].trim();
                softAssert.assertEquals(RTBThirdSectionText,"You're never responsible for unauthorized purchases on your Discover Card.8",""+product);
                String nationwideacceptance = SeconedSectionCheck.get(0).split("\n")[9].trim();
                softAssert.assertEquals(nationwideacceptance,"99% nationwide acceptance — Discover is accepted nationwide by 99% of places that take credit cards.3",""+product);

                List<String> ThirdSectionCheck = getThirdText();
                String ThirdBannerHeader = ThirdSectionCheck.get(0).split("\n")[0].trim();
                softAssert.assertEquals(ThirdBannerHeader,"Hit the road with our restaurant and gas cash back rewards credit card",""+product);
                String ThirdBannerText = ThirdSectionCheck.get(0).split("\n")[1].trim();
                softAssert.assertEquals(ThirdBannerText,"Redeem your rewards for cash in any amount.4 Redeem rewards for gift cards at popular brands. You can also redeem your rewards with PayPal.5",""+product);

                List<String> FourtSectionCheck = getFourthText();
                String FourthBannerHeader = FourtSectionCheck.get(0).split("\n")[0].trim();
                softAssert.assertEquals(FourthBannerHeader,"Get cash back rewards on gas: apply for the Discover it® Chrome gas credit card",""+product);
                String FourthBannerText = FourtSectionCheck.get(0).split("\n")[1].trim();
                softAssert.assertEquals(FourthBannerText,"Discover is accepted nationwide by 99% of places that take credit cards.3  So you’ll earn cash back on gas station purchases, restaurant purchases and everyday purchases, nearly everywhere you shop. Simply apply now for the Discover gas cash back rewards card that rewards you beyond the pump.",""+product);

                List<String> lowIntroSection = getSeeLowIntroAPR();
                String lowIntroHeader = lowIntroSection.get(0).split("\n")[0].trim();
                softAssert.assertEquals(lowIntroHeader,"Start out right with our low intro APR",""+product);
                String NOAnnualFee = lowIntroSection.get(0).split("\n")[2].trim();
                softAssert.assertEquals(NOAnnualFee,"No annual fee",""+product);

                String GasCreditCardlink = driver.findElement(By.xpath("(//*[@class='disclosurelink no-disclosure'])[1]")).getAttribute("href");
                softAssert.assertEquals(GasCreditCardlink,"https://www.discover.com/credit-cards/card-smarts/gas-credit-card/",""+product);
                String RestaurantCreditCard = driver.findElement(By.xpath("(//*[@class='disclosurelink no-disclosure'])[2]")).getAttribute("href");
                softAssert.assertEquals(RestaurantCreditCard,"https://www.discover.com/credit-cards/card-smarts/maximizing-your-restaurant-credit-card/",""+product);
                String FirstCreditCard = driver.findElement(By.xpath("(//*[@class='disclosurelink no-disclosure'])[3]")).getAttribute("href");
                softAssert.assertEquals(FirstCreditCard,"https://www.discover.com/credit-cards/card-smarts/7-tips-for-applying-for-your-first-credit-card/",""+product);


                List<String> fifthSectionCheck = getFifthText();
                String fifthBannerHeader = fifthSectionCheck.get(0).split("\n")[0].trim();
                softAssert.assertEquals(fifthBannerHeader,"Are you getting the most you can from your gas rewards and restaurant credit card?",""+product);
                String fifthBannerText = fifthSectionCheck.get(0).split("\n")[1].trim();
                softAssert.assertEquals(fifthBannerText,"Read helpful articles on the rewards and perks of gas and restaurant credit cards below",""+product);
                String GasCreditCardHeader =  fifthSectionCheck.get(0).split("\n")[2].trim();
                softAssert.assertEquals(GasCreditCardHeader,"Finding the Right Gas Credit Card",""+product);
                String GasCreditCardHeaderText = fifthSectionCheck.get(0).split("\n")[3].trim();
                softAssert.assertEquals(GasCreditCardHeaderText,"Do you spend a lot of time driving? Learn about the options you should consider when looking for the best gas credit card.",""+product);
                String RestaurantCreditCardHeader = fifthSectionCheck.get(0).split("\n")[4].trim();
                softAssert.assertEquals(RestaurantCreditCardHeader,"Maximizing the Benefits of Your Restaurant Credit Card",""+product);
                String RestaurantCreditCardHeaderText = fifthSectionCheck.get(0).split("\n")[5].trim();
                softAssert.assertEquals(RestaurantCreditCardHeaderText,"Do you find yourself heading out to dinner rather than spending time cooking? Maximize the use of your restaurant credit card and other reward programs.",""+product);
                String FirstCreditCardHeader = fifthSectionCheck.get(0).split("\n")[6].trim();
                softAssert.assertEquals(FirstCreditCardHeader,"How to Get Your First Credit Card",""+product);
                String FirstCreditCardText = fifthSectionCheck.get(0).split("\n")[7].trim();
                softAssert.assertEquals(FirstCreditCardText,"From payments to rewards, ensure you start your credit history off right with these 7 tips for applying for your first credit card.",""+product);


                softAssert.assertAll();
            }

        }finally {
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
