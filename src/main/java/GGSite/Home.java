/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GGSite;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class Home {

//    private static void clickGetDeal(WebDriver driver, int index) {
//
//    }
//
//    private static void clickShowCode() {
//
//    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://sites.google.com/site/foryacoupon/home");
        driver.manage().window().maximize();

        // Get list deal
        List<WebElement> btn = new ArrayList<>();
        btn = driver.findElements(By.tagName("iframe"));
        System.out.println("Có: " + btn.size() +  "coupons");
        for (int i = 0; i < btn.size(); i++) {
            driver.switchTo().frame(i);
            // Get text from button
            String btnText = driver.findElement(By.cssSelector(".btn-coupon")).getText();
            
            if (btnText.equals("Get Deal")) {
                driver.findElement(By.cssSelector(".btn-coupon")).click();
                
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                driver.close();
                
                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));
                
                try {
                    String tet = driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.middle > a")).getText();
                    System.out.println(tet);
                } catch (Exception e) {
                    driver.quit();
                }
                
                driver.get("https://sites.google.com/site/foryacoupon/home");
            } else {
                driver.findElement(By.cssSelector(".btn-coupon")).click();
            
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                
                try {
                    String tet = driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.middle > div > div > span")).getText();
                    System.out.println(tet);
                } catch (Exception e) {
                    driver.quit();
                }
                
                driver.close();
                
                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));
                
                driver.get("https://sites.google.com/site/foryacoupon/home");
            }
        }

        driver.quit();
    }

}
