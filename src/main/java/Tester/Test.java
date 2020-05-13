package Tester;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cvcoupons.com/categories");

        // Get list deal
        List<WebElement> lstCate = driver.findElements(By.className("storeLink"));        
        for (WebElement cate : lstCate) {
        	String linkCate = cate.getAttribute("href");
        	String txtCate = cate.getText();
        	((JavascriptExecutor)driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            driver.get(linkCate);
            List<WebElement> lstBtn = driver.findElements(By.cssSelector(".active-coupon .deal-button:not(.has-code) .label"));  //lst Button Get Deal   
            System.out.println(txtCate + "có " + lstBtn.size() + " button");
            for (WebElement lstBtn1 : lstBtn) {
                lstBtn = driver.findElements(By.cssSelector(".active-coupon .deal-button:not(.has-code) .label"));
                lstBtn1.click();
                ArrayList<String> tabBtn2 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabBtn2.get(2));
                driver.close();
                ArrayList<String> tabBtn1 = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabBtn1.get(1));
                String text = driver.findElement(By.cssSelector(".modal-header.deal-copy")).getText();
                ((JavascriptExecutor)driver).executeScript("$('.updated-modal').toggle()");
                System.out.println(text);
            }
            ArrayList<String> tabBtn1 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabBtn1.get(1)).close();
            
            ArrayList<String> tab0 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab0.get(0));
        }
        driver.quit();
    }
}