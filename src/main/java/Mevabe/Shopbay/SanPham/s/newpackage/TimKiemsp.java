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
public class TimKiemsp {

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

        //Tim kiem san pham
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div.body > div.box.no-border > div.box-body > div.input-group > input")).click();
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div.body > div.box.no-border > div.box-body > div.input-group > input")).sendKeys("Giày thể thao nam");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div.body > div.box.no-border > div.box-body > div.input-group > div:nth-child(3) > button")).click();

        Thread.sleep(1000);
        List<WebElement> ketqua = driver.findElements(By.cssSelector("body > div > div > div > div.body > div.box.no-border > div.box-body > div.table-responsive > table > tbody > tr"));
        int sanpham = ketqua.size() - 2;
        System.out.println("Tìm thấy " + sanpham + " san pham ");
        driver.findElement(By.cssSelector("body > div.wrapper.ng-scope > div > div > div.body > div.box.no-border > div.box-body > div.input-group > input")).clear();

        //Loc san pham
        driver.findElement(By.cssSelector("#filter")).click();
//        driver.findElement(By.cssSelector("#filter > div > div > div.form-group.d-block.overflow-auto > select")).click();
        List<WebElement> chonboloc = driver.findElements(By.cssSelector("#filter > div > div > div.form-group.d-block.overflow-auto > select > option"));
        for (int i = 1; i < chonboloc.size(); i++) {
            if (i > 1) {
                driver.findElement(By.cssSelector("#filter")).click();
            }
            System.out.println("Đang chọn tiêu chí " + chonboloc.get(i).getText().trim());
            chonboloc.get(i).click();
            Thread.sleep(1000);

            //Chon thuong hieu
            List<WebElement> chonthuonghieu = driver.findElements(By.cssSelector("#filter > div > div > div:nth-child(2) > div:nth-child(" + i + ") > select > option"));
            if (chonthuonghieu.size() > 0) {
                System.out.println("Co " + chonthuonghieu.size() + " tieu chi trong " + chonboloc.get(i).getText().trim());
                System.out.println("Chon " + chonthuonghieu.get(2).getText().trim());
                chonthuonghieu.get(2).click();

                driver.findElement(By.cssSelector("#filter > div > div > div:nth-child(2) > div.mt-3.d-block > button")).click();
                Thread.sleep(3000);

                System.out.println("Co " + (driver.findElements(By.cssSelector("body > div > div > div > div.body > div.box.no-border > div.box-body > div.mt-4 > span")).size() - 1) + " bo loc");
                System.out.println("Tìm thấy " + driver.findElements(By.cssSelector("body > div > div > div > div.body > div.box.no-border > div.box-body > div.table-responsive > table > tbody > tr")).size() + " san pham ");
            }
        }
        driver.quit();
    }
}
