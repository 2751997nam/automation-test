/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.DonHang;

import java.awt.Desktop;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dell
 */
public class ThemKhachHang {
      public static void main (String[] args) throws InterruptedException {
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
        //Tao don hang
        driver.findElement(By.xpath("/html/body/div/aside/div/section/ul/li[2]/a")).click();
        jse.executeScript("document.querySelector(\"body > div > aside > div > section > ul > li.treeview.menu-open > ul > li > a\").click();");
        //driver.findElement(By.xpath("/html/body/div/aside/div/section/ul/li[2]/ul/li/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/a/button")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[1]/div[2]/div/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jse.executeScript("document.querySelector(\"#search-product-modal > div > div > div.modal-body > div > div.input-group.search-group > input\")");
       Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"search-product-modal\"]/div/div/div[2]/div/div[1]/input")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"search-product-modal\"]/div/div/div[2]/div/div[1]/input")).sendKeys("Giày");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        //Lay 3 san pham dau tien sau khi tim kiem
        List<WebElement> listRowProduct = driver.findElements(By.cssSelector(".search-product-result td input"));
        for (int i = 0; i < listRowProduct.size(); i++) {
            if (i < 3) {
                listRowProduct.get(i).click();
            }
        }
        driver.findElement(By.xpath("//*[@id=\"search-product-modal\"]/div/div/div[3]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Tim kiem Khach hàng và chọn khách hàng
        jse.executeScript("document.querySelector(\"#js-input-search\").click();");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#user-search-recommand > ul > li")).click();
        driver.findElement(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div.ng-scope > div:nth-child(1) > div > input")).click();
        driver.findElement(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div.ng-scope > div:nth-child(1) > div > input")).sendKeys("Ngô Thị An");
        driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[1]/div[2]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[1]/div[2]/div/input")).sendKeys("0313783421");
        //driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[3]/div[2]/div/a/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[3]/div[2]")).click();
        //dropdown select
        List<WebElement> Province = driver.findElements(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div:nth-child(3) > div.p-0.col-md-7 > div > div > ul > li"));
        System.out.println(Province.size());
        for (int i = 0; i < Province.size(); i++) {
            if (i == 1) {
                Province.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[4]/div[2]")).click();
        List<WebElement> District = driver.findElements(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div:nth-child(4) > div.p-0.col-md-7 > div > div > ul > li"));
        System.out.println(District.size());
        for (int i = 0; i < District.size(); i++) {
            if (i == 2) {
                District.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[5]/div[2]")).click();
        
        List<WebElement> Village = driver.findElements(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div:nth-child(5) > div.p-0.col-md-7 > div > div > ul > li"));
        System.out.println(Village.size());
        for (int i = 0; i < Village.size(); i++) {
            if (i == 2) {
                Village.get(i).click();
                break;
            }
        }
        
        driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(1000);
        jse.executeScript("document.querySelector(\"#btnSave\").click();");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
        
        driver.quit();
    }
}
