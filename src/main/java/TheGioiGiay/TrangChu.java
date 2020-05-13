/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGioiGiay;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Dell
 */
public class TrangChu {

    public static void test() {
        System.setProperty("webdriver.chrome.driver", Config.getDriver());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.navigate().to(Config.site);
        driver.manage().window().maximize();
        //Kiem tra thanh search
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.findElement(By.id("js-search-input")).sendKeys("Giày");
        if (driver.findElements(By.id("js-search-input")).size() != 0) {
            System.out.println("Truy cap website thanh cong!");
        } else {
            System.out.println("Truy cap website that bai!");
        }

        driver.quit();
    }

}
