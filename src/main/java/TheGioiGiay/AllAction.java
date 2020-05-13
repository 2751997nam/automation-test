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

/**
 *
 * @author Dell
 */
public class AllAction {

    public static void test() {
        System.setProperty("webdriver.chrome.driver", Config.getDriver());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.navigate().to(Config.site);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"navbar-nav\"]/li[1]")).click();
        driver.findElement(By.cssSelector("body > div > div.page-main > section.bg-style-1.pb-4 > div > div > div > div.swiper-wrapper > div.swiper-slide.d-flex.h-auto.swiper-slide-active > a")).click();

        driver.findElement(By.xpath("/html/body/div/div[1]/section[3]/div/div[2]/div[1]/div[1]/div")).click();
        WebElement tensp = driver.findElement(By.xpath("//*[@id=\"js-title\"]"));
        System.out.println("Ten San Pham: " + tensp.getText());
        WebElement ttsp = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div[2]/h2"));
        System.out.println(ttsp.getText());

        driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div[1]/div/div[2]/div/div[3]/form/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"container-cart\"]/div/div/a[2]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Luong Thi May");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("0367103927");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mayvimaru@gmail.com");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("so 6 le van thiem");

        driver.findElement(By.xpath("//*[@id=\"province\"]")).click();
        driver.findElement(By.cssSelector("#province > option:nth-child(2)")).click();
        driver.findElement(By.xpath("//*[@id=\"district\"]")).click();
        driver.findElement(By.cssSelector("#district > option:nth-child(2)")).click();
        driver.findElement(By.xpath("//*[@id=\"commune\"]")).click();
        driver.findElement(By.cssSelector("#commune > option:nth-child(2)")).click();

        driver.findElement(By.id("note")).sendKeys("Giao hang gio hanh chinh");

        driver.findElement(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/div[1]/div/div/button")).click();

        WebElement dhtc = driver.findElement(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/h1"));
        System.out.println(dhtc.getText());

        driver.quit();
    }
}
