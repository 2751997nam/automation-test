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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

/**
 *
 * @author Dell
 */
public class Order {

    public static void test() {
        System.setProperty("webdriver.chrome.driver", Config.getDriver());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.navigate().to(Config.site);

        driver.manage().window().maximize();
        //Truy cap vao danh muc Nam
        driver.findElement(By.xpath("//*[@id=\"navbar-nav\"]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[1]/div[1]")).click();

        driver.findElement(By.cssSelector("body > div > div.page-main > section.section.py-4.mb-3 > div > div.mb-5 > div.row.gutter-1 > div:nth-child(1) > div > div.thumbnail.thumbnail-hover > a:nth-child(1)")).click();

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div[1]/div/div[2]/div/div[3]/form/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"container-cart\"]/div/div/a[2]")).click();
        //Dien thong tin nhan hang
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#name")).click();
        driver.findElement(By.id("name")).sendKeys("Luong Thi May");
        driver.findElement(By.id("phone")).sendKeys("0367103927");
        driver.findElement(By.id("email")).sendKeys("mayvimaru@gmail.com");
        driver.findElement(By.id("address")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"province\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"province\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"district\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"district\"]/option[2]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"commune\"]")).click();
        driver.findElement(By.cssSelector("#commune > option:nth-child(2)")).click();

        driver.findElement(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/div[1]/div/div/button")).click();

        WebElement ele = driver.findElement(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/h1"));
        System.out.println(ele.getText());
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/a"));
        System.out.println(btn.getText());

        driver.quit();
    }

}
