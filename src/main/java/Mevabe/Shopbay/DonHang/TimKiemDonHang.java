/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mevabe.Shopbay.DonHang;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Dell
 */
public class TimKiemDonHang {

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

        //Tim kiem theo ma don hang
        driver.findElement(By.xpath("/html/body/div/aside/div/section/ul/li[2]/a")).click();
        jse.executeScript("document.querySelector(\"body > div > aside > div > section > ul > li.treeview.menu-open > ul > li > a\").click();");
        jse.executeScript("document.querySelector(\"body > div.wrapper.ng-scope > div > div > div.body > div > div.box-body > div.input-group > input\").click();");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/input")).sendKeys("22");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        
        List<WebElement> list = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr["+(i+1)+"]/td[1]/a")).getText());
                  
        }  
        //Tim kiem theo ngay tao
        driver.findElement(By.xpath("//*[@id=\"filter\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div/div[1]/select")).click();
        List<WebElement> select = driver.findElements(By.xpath("//*[@id=\"filter\"]/div/div/div[1]/select"));
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div/div[1]/select/option[2]")).click();
        
        String datetime = "11/10/2019";
        
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div/div[2]/div[3]/div[1]/div/input")).sendKeys("10/09/2019");
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div/div[2]/div[3]/div[2]/div/input")).sendKeys("10/11/2019");
        
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div/div[2]/div[4]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        
        Thread.sleep(1000);
        List<WebElement> list2 = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr"));
        System.out.println(list2.size());
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr["+(i+1)+"]/td[1]/a")).getText());
                  
        }  
        Thread.sleep(3000);
        
        //Loc theo tab
        //Lay danh sach tab hien tai(4 tab)
        List<WebElement> listtab = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/ul/li"));
        int sizeoftab = listtab.size() - 1;//Do co 1 thang li(search)cuoi cung bi an nen phai -1
        System.out.println("Tong cong co: "+ sizeoftab + " tab dang hien thi");
        for (int i = 0; i < sizeoftab; i++) {
            System.out.println("Click vao tab "+ listtab.get(i).getText());
            listtab.get(i).click();
            Thread.sleep(1000);
            
            int totalRecordOfTab = 0;
            
            //Kiem tra attribute cua button neu la false thi co the click, khong co thi khong the click -> het phan trang
            String nextbutton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/ul[4]/li[7]")).getAttribute("aria-disabled");
            if (nextbutton.equals("false")) {
                int page = 0;
                while (nextbutton.equals("false")) {
                    page += 1 ;
                    Thread.sleep(1000);
                    int sizeofrecord = driver.findElements(By.cssSelector("body > div > div > div > div.body > div > div.box-body > div.table-responsive > table > tbody > tr")).size();
                    System.out.println("Trang "+ page + " co: "+ sizeofrecord+ " don hang");
                    //Dem tong so ban ghi tren trang
                    totalRecordOfTab += sizeofrecord;
                    
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div > div > div > div.body > div > div.box-footer.clearfix > ul:nth-child(2) > li:nth-child(8) > a\").click();");
                    nextbutton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/ul[4]/li[7]")).getAttribute("aria-disabled");
              
                }
            } else {
                int sizeOfRecord = driver.findElements(By.cssSelector("body > div > div > div > div.body > div > div.box-body > div.table-responsive > table > tbody > tr")).size();
                totalRecordOfTab = sizeOfRecord;
            }
            System.out.println("Co tat ca "+ totalRecordOfTab + " don hang trong tab " + listtab.get(i).getText());
        }
        
        driver.quit();
    }
    }

  
