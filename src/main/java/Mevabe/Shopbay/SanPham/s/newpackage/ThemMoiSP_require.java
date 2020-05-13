/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.SanPham.s.newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


/**
 *
 * @author Dell
 */
public class ThemMoiSP_require {

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
        driver.findElement(By.cssSelector("body > div > div > div > div.header > a > button")).click();
        
        //Khong nhap gi va click nut Luu
        driver.findElement(By.cssSelector("#btn-save-3")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div")).getText();
        Assert.assertEquals(msg, "Chưa nhập tiêu đề cho sản phẩm.");
        
        //Khong nhap gi va click nut Luu&Dong
        driver.quit();
    }
}
