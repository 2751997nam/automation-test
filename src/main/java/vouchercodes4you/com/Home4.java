/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vouchercodes4you.com;

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
public class Home4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://vouchercodes4you.com/");
        driver.manage().window().maximize();
       // driver.findElement(By.cssSelector("#header-submenu > div > ul > li:nth-child(2) > a > span")).click();
        
        // Click get more deal
        //driver.findElement(By.cssSelector(".more-coupon")).click();
                
        List<WebElement> btn = new ArrayList<>();
        btn = driver.findElements(By.cssSelector(".link-holder"));
        System.out.println("Có: " + btn.size() + " coupons");
        
        for (int i = 0; i < btn.size(); i++) {
            btn = driver.findElements(By.cssSelector(".link-holder"));
            //driver.findElement(By.cssSelector(".more-coupon")).click();
            if (btn.get(i).getText().equals("Get Deal")) {
                btn.get(i).click();
                ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab1.get(1));
                String URL = driver.getCurrentUrl();
                System.out.println(URL);
                driver.close();
                
                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));
                String text = driver.findElement(By.cssSelector("body > div.vodal.coupon-modal > div.vodal-dialog > div.coupon-content > div > h4")).getText();
                System.out.println(text);
                driver.get("https://vouchercodes4you.com/");
                
            }else{
                btn.get(i).click();
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                String text2 = driver.findElement(By.cssSelector("body > div.vodal.coupon-modal > div.vodal-dialog > div.coupon-content > div > div > div > a")).getText();
                System.out.println(text2);
                driver.close();
                
                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));
                String URL = driver.getCurrentUrl();
                System.out.println(URL);
                driver.get("https://vouchercodes4you.com/");
            }
        }
        
        driver.quit();
        
    }
}
