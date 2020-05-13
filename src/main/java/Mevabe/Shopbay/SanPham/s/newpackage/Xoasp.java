/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.SanPham.s.newpackage;

import java.util.List;
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
public class Xoasp {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //String currentHandle = driver.getWindowHandle();

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

        //check 2 san pham dau tien
        Thread.sleep(3000);
        List<WebElement> sanpham = driver.findElements(By.cssSelector("body > div > div > div > div.body > div.box.no-border > div.box-body > div.table-responsive > table > tbody > tr > td > input"));
        for (int i = 0; i < sanpham.size(); i++) {
            if (i < 2) {
                sanpham.get(i).click();
            }
        }
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div.body > div.box.no-border > div.box-body > div:nth-child(3) > div > div > ul > li.segments.dropdown")).click();
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div.body > div.box.no-border > div.box-body > div:nth-child(3) > div > div > ul > li.segments.dropdown.open > ul > li:nth-child(1)")).click();
        
        //click xac nhan
        driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
        Thread.sleep(3000);
        String xacnhan = driver.findElement(By.cssSelector("#swal2-content")).getText();
        Assert.assertEquals(xacnhan, "Xóa sản phẩm thành công!");
        driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
        System.out.println("Xóa thành công");
        
        driver.quit();
    }
}
