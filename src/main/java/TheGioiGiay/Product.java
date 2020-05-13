/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGioiGiay;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Dell
 */
public class Product {

    public static void test() {
        System.setProperty("webdriver.chrome.driver", Config.getDriver());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.navigate().to(Config.site);
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("body > div.page.page-home > div.page-main > section:nth-child(4) > div > h2")).click();
        List<WebElement> productlist = driver.findElements(By.cssSelector("body > div > div.page-main > section.section.py-4.mb-3 > div > div.mb-5 > div.row.gutter-1 > div"));
        System.out.println("Co " + productlist.size() + " san pham");
        for (int i = 0; i < productlist.size(); i++) {
            if (i == 1) {
                productlist.get(1).click();
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement tensp = driver.findElement(By.cssSelector("#js-title"));
        System.out.println("Ten sp: " + tensp.getText());
        WebElement ttsp = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div[2]/h2"));
        System.out.println(ttsp.getText());

        driver.quit();

    }
}
