/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.DonHang;

import java.awt.BorderLayout;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 *
 * @author Dell
 */
public class Donhang {

    //Chon 3 san pham bat ky
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Add javascript when not click or somethinng else
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.get("https://shopbay.vn/login");
        driver.manage().window().maximize();
        //Login
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input")).sendKeys("mayvimaru@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("1234560");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/div/button")).click();
        driver.navigate().to("https://mevabe1.shopbay.vn/admin");
        //Click tab don hang
        driver.findElement(By.xpath("/html/body/div/aside/div/section/ul/li[2]/a")).click();
        jse.executeScript("document.querySelector(\"body > div > aside > div > section > ul > li.treeview.menu-open > ul > li > a\").click();");
        //Lay page_count
        Thread.sleep(3000);
        String page_count1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/span")).getText();
        System.out.println(page_count1);
        //Click nut Tao don hang
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/a/button")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[1]/div[2]/div/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"search-product-modal\"]/div/div/div[2]/div/div[1]/input")).click();
        Thread.sleep(3000);

        List<WebElement> listRowProduct = driver.findElements(By.cssSelector(".search-product-result td input"));
        for (int i = 0; i < listRowProduct.size(); i++) {
            if (i < 3) {
                listRowProduct.get(i).click();
            }
        }
        driver.findElement(By.xpath("//*[@id=\"search-product-modal\"]/div/div/div[3]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Tim kiem Khach hàng và chọn khách hàng
        jse.executeScript("document.querySelector(\"#js-input-search\").click();");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"js-input-search\"]")).sendKeys("0977920221");
        driver.findElement(By.xpath("//*[@id=\"user-search-recommand\"]/ul/li[2]")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
        //So sanh page_count sau khi tao
        String page_count2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[3]/span")).getText();
        if (page_count2 == page_count1) {
            System.out.println("Tao don hang khong thanh cong");
        } else {
            System.out.println("Tao don hang thanh cong");
        }
        driver.quit();
    }

}
