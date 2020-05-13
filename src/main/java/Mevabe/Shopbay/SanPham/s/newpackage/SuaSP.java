/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.SanPham.s.newpackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class SuaSP {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
      
        driver.get("https://shopbay.vn/login");
        driver.manage().window().maximize();

        //Login
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input")).sendKeys("mayvimaru@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("1234560");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/div/button")).click();
        driver.navigate().to("https://mevabe1.shopbay.vn/admin");

        //Click tab San pham
        driver.findElement(By.xpath("/html/body/div/aside/div/section/ul/li[3]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/aside/div/section/ul/li[3]/ul/li[1]/a")).click();
        //Click xem chi tiet san pham
        Thread.sleep(1000);
        List<WebElement> sanpham = driver.findElements(By.cssSelector("body > div > div > div > div.body > div.box.no-border > div.box-body > div.table-responsive > table > tbody > tr"));
        System.out.println("Co " + sanpham.size() + " san pham tren trang 1");
        for (int i = 0; i < sanpham.size() - 1; i++) {
            if (i == 1) {
                sanpham.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(1) > input")).click();
        driver.findElement(By.cssSelector("body > div > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(1) > input")).clear();
        driver.findElement(By.cssSelector("body > div > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(1) > input")).sendKeys("Nhập tiêu đề mới");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(3) > div > div > div > input")).clear();
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(3) > div > div > div > input")).sendKeys("10000");
        driver.findElement(By.cssSelector("#cke_1_contents > iframe")).click();
        driver.findElement(By.cssSelector("#cke_1_contents > iframe")).sendKeys("Nhập nội dung mới");
        
        driver.findElement(By.cssSelector("#btn-save-1")).click();
        
        driver.quit();
        
    }
}
