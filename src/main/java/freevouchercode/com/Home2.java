/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freevouchercode.com;

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
public class Home2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://freevouchercode.com");
        driver.manage().window().maximize();
       // driver.findElement(By.cssSelector("#header-submenu > div > ul > li:nth-child(2) > a > span")).click();

        List<WebElement> btn = new ArrayList<>();
        btn = driver.findElements(By.cssSelector(".btn-getdeal"));
        System.out.println("Có: " + btn.size() + " coupons");

        for (int i = 0; i < btn.size(); i++) {
            btn = driver.findElements(By.cssSelector(".btn-getdeal"));
            
            if (btn.get(i).getText().equals("Get Deal")) {
                btn.get(i).click();
                ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab1.get(1));
                String URL = driver.getCurrentUrl();
                System.out.println(URL);
                driver.close();

                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));
                String text = driver.findElement(By.cssSelector("#perCouponDialog > div > div > h2")).getText();
                System.out.println(text);
                driver.get("https://freevouchercode.com");

            } else {
                btn.get(i).click();
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                String text2 = driver.findElement(By.cssSelector("#perCouponDialog > div > div > div.mobileShopNow > div.couponDialogCodeBorder > div.mobileCouponCode")).getText();
                System.out.println(text2);
                driver.close();

                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));
                String URL = driver.getCurrentUrl();
                System.out.println(URL);
                driver.get("https://freevouchercode.com");
            }
        }

        driver.quit();

    }
}
