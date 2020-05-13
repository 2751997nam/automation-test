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
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Dell
 */
public class ThemMoiSP_Successfull {

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
        //Dem page_count truoc khi tao
        Thread.sleep(3000);
        String page_count = driver.findElement(By.cssSelector("body > div > div > div > div.body > div.box-footer.clearfix > span")).getText();
        System.out.println(page_count);
        driver.findElement(By.cssSelector("body > div > div > div > div.header > a > button")).click();

        //Nhap cac gia tri vao form
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(1) > input")).sendKeys("Giày thể thao nam");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(2) > div > div:nth-child(1) > div > input")).sendKeys("250000");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(2) > div > div:nth-child(2) > div > input")).sendKeys("300000");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(3) > div > div > div > input")).sendKeys("5000");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-9 > div:nth-child(1) > form > div > div:nth-child(4) > textarea")).sendKeys("Giầy sportswear Nike NIKE AIR MAX SEQUENT 4 nam AO4485-001");
        driver.findElement(By.cssSelector("body")).sendKeys("Giày Thể Thao Nam Puma Osu NM Màu Black/Dark Shadow/Red là một trong những sản phẩm bán chạy nhất của Puma bởi thiết kế đơn giản, tiện dụng, kiểu dáng trẻ trung, năng động với 2 tông màu đen - đỏ chủ đạo kết hợp hài hòa, bắt mắt.");
        //Upload anh   
        driver.findElement(By.xpath("/html/body/label/input")).sendKeys("C:\\Users\\Dell\\Desktop\\pictureq1.png");
        //Cai dat bien the
        jse.executeScript("document.querySelector(\"#js-product-variants > div.box-header.with-border > div > a\").click();");

        //hover chuot vào bien the
        WebElement element = driver.findElement(By.cssSelector("#js-product-variants"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        //chon nhom bien the
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-bordered > tbody > tr.ng-scope > td:nth-child(1) > div > div")).click();
        List<WebElement> nhombienthe = driver.findElements(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-bordered > tbody > tr:nth-child(2) > td:nth-child(1) > div > div > div > ul > li"));
        System.out.println("Co tat ca " + nhombienthe.size() + " nhom bien the");
        for (int i = 0; i < nhombienthe.size(); i++) {
            if (i == 1) {
                nhombienthe.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        //chon bien the
        driver.findElement(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-bordered > tbody > tr.ng-scope > td:nth-child(2) > div > div")).click();
        List<WebElement> bienthe = driver.findElements(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-bordered > tbody > tr.ng-scope > td:nth-child(2) > div > div > div > ul > li"));
        System.out.println("Co tat ca: " + bienthe.size() + " bien the");
        Thread.sleep(3000);
        bienthe.get(2).click();
        driver.findElement(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-hover > tbody > tr.ng-scope > td:nth-child(5) > input")).clear();
        driver.findElement(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-hover > tbody > tr.ng-scope > td:nth-child(5) > input")).sendKeys("150000");
        driver.findElement(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-hover > tbody > tr.ng-scope > td:nth-child(6) > input")).clear();
        driver.findElement(By.cssSelector("#js-product-variants > div.box-body > div > table.table.table-hover > tbody > tr.ng-scope > td:nth-child(6) > input")).sendKeys("250000");

        //Chon danh muc
        jse.executeScript("document.querySelector(\"body > div > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-3 > div > form > div:nth-child(2) > div > div > ul > li\").click()");
        List<WebElement> danhmuc = driver.findElements(By.cssSelector("body > div.wrapper.ng-scope > div > div > div > div > div:nth-child(2) > div.product-container > div > div.col-md-3 > div > form > div:nth-child(2) > div > div > div > ul > li"));
        System.out.println("Co tat ca: " + danhmuc.size() + " danh muc");
        for (int i = 0; i < danhmuc.size(); i++) {
            if (i==2) {
                danhmuc.get(i).click();
            }
        }
        
        //click nut luu
        driver.findElement(By.cssSelector("#btn-save-1")).click();
        //Dem page_count sau khi tao san pham thanh cong
        Thread.sleep(3000);
        String page_count2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/span")).getText();
        if (page_count == page_count2) {
            System.out.println("Tao san pham that bai");
        } else {
            System.out.println("Tao san pham thanh cong");
        }
        driver.quit();
    }
}
