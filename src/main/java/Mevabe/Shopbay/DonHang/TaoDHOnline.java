/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.DonHang;

import static java.awt.SystemColor.text;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author Dell
 */
public class TaoDHOnline {
    
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\driver_selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        driver.get("https://mevabe1.shopbay.vn/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Danh sach san pham Moi
        //List<WebElement> spnew = driver.findElements(By.cssSelector("#product-series-1 > div"));
        List<WebElement> spnew = driver.findElements(By.cssSelector("#product-series-1 > div > div"));
        System.out.println("Co: " + spnew.size() + " san pham moi");
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#product-series-1 > div > div:nth-child(1) > div > div.single-product__image > a")).click();
        driver.findElement(By.cssSelector("body > div.shop-page-wrapper.mt-70.mb-70 > div > div > div > div > div.row.pb-70.pb-md-0.pb-sm-0.pb-xs-0.pb-xxs-0 > div.col-xl-5.col-lg-5.mb-md-70.mb-sm-70 > div > a")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#cart-overlay > div.cart-overlay-content > div > div > div.cart-buttons > a:nth-child(2)")).click();

        //input thong tin thanh toan
        Thread.sleep(3000);
        driver.findElement(By.id("name")).sendKeys("Luong Thi May");
        driver.findElement(By.id("phone")).sendKeys("0912231123");
        driver.findElement(By.id("email")).sendKeys("mayluong171291@gmail.com");
        
        Select tinh = new Select(driver.findElement(By.cssSelector("#province")));
        tinh.selectByValue("number:1");
        Thread.sleep(3000);
        Select huyen = new Select(driver.findElement(By.cssSelector("#district")));
        huyen.selectByValue("number:271");
        
        driver.findElement(By.cssSelector("#commune")).sendKeys("Cuong Chinh");
        driver.findElement(By.id("address")).sendKeys("236 Dai Tu");
        driver.findElement(By.id("note")).sendKeys("Giao hang gio hanh chinh");

        //click Dat hang
        driver.findElement(By.cssSelector("#tt-pageContent > div > div > div:nth-child(2) > div.col-md-4.col-12 > div.mt-3.pl-0.pr-0.mb-2 > button")).click();
        //Verify Dat hang thanh cong
        Thread.sleep(3000);
        if (driver.getPageSource().contains("Đặt hàng thành công")) {
            System.out.println("Dat hang thanh cong");
        } else {
            System.out.println("Dat hang that bai");
        }
        driver.quit();
    }
}
