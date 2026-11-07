package Pages;

import Utils.ConfigReader;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FAQTextCheck {

    private static final Logger log = LoggerFactory.getLogger(FAQTextCheck.class);
    public ArrayList<String> FAQValidtion(){
        List<WebElement> FAQValidation = driver.findElements(By.xpath("//div[@class='faq-list__items']//div[@class='faq']"));
        ArrayList<String> FAQHeader = new ArrayList<>();
        for(int i=0;i<FAQValidation.size();i++){
            FAQHeader.add(FAQValidation.get(i).getText());
        }
        return FAQHeader;
    }


    public static WebDriver driver=null;
    public FAQTextCheck(WebDriver driver){
        FAQTextCheck.driver =driver;
    }
    public static WebElement getSeeMoreFAQButton(){
        return driver.findElement(By.xpath("//*[text()='See More FAQs']"));
    }

    public void verifyFAQValidation(String product,String region,String faqDisplayed){

    }
}
