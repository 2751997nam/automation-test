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
public class SuaDiaChiGiaoHang {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        

        driver.get("https://shopbay.vn/login");
        driver.manage().window().maximize();

        //Login
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input")).sendKeys("mayvimaru@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("1234560");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/div/button")).click();
        driver.navigate().to("https://mevabe1.shopbay.vn/admin");
        //Chon tab Don hang
        driver.findElement(By.xpath("/html/body/div/aside/div/section/ul/li[2]/a")).click();
        jse.executeScript("document.querySelector(\"body > div > aside > div > section > ul > li.treeview.menu-open > ul > li > a\").click();");
        //Chon tab Don hang Can xu ly
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/ul/li[2]")).click();
        Thread.sleep(3000);
        //Bien dem de test
        int numberOrder = 1;
        int numberOrderForTest = 3;
        int indexOrder = 0; // Đơn hàng số

        while (numberOrder < numberOrderForTest) {
            List<WebElement> orderlist = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr"));
            // Lặp các đơn hàng này
            for (int i = indexOrder; i < orderlist.size(); i++) {
                // Trong các đơn lại có nhiều thẻ tr nên cần lặp để lấy được label label-success kia
                List<WebElement> elements = orderlist.get(i).findElements(By.cssSelector("td"));
                // Lấy thành phần thứ 6 chính là cái span trạng thái
                String status = elements.get(6).getText();

                // Trạng thái là Đang xử lý 
                if (status.equals("Đang xử lý")) {
                    // Click vào đơn hàng Đang xử lý
                    orderlist.get(i).click();
                    Thread.sleep(3000);
                    
                    //Click vào nút sửa địa chỉ giao hàng
                    driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/div/div/a")).click();
                    
                    // Chờ hiển thị form sửa quận huyện thành phố hiển thị
                    Thread.sleep(3000);
                    // Click vào select thành phố
                    driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[2]/div[2]/div")).click();
 
                    //drop select
                    List<WebElement> tinh = driver.findElements(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div:nth-child(2) > div.p-0.col-md-7 > div > div > ul > li"));
                    System.out.println("co " + tinh.size() + " tinh");
                    //Lấy tp HCM
                    for (int j = 0; j < tinh.size(); j++) {
                        if(j == 2){
                        tinh.get(j).click();
                        break;
                        }
                    }
                    
                    
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[3]/div[2]/div")).click();

                    List<WebElement> quan = driver.findElements(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div:nth-child(3) > div.p-0.col-md-7.ng-scope > div > div > ul > li"));
                    System.out.println("co " + quan.size() + " quan");
                    for (int k = 0; k < quan.size(); k++) {
                        if (k == 1) {
                            quan.get(k).click();
                            break;
                        }
                    }
                    
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//*[@id=\"create-customer-modal\"]/div/div/div[2]/div/div[4]/div[2]/div")).click();
                    
                    List<WebElement> xa = driver.findElements(By.cssSelector("#create-customer-modal > div > div > div.modal-body > div > div:nth-child(4) > div.p-0.col-md-7.ng-scope > div > div > ul > li"));
                    System.out.println("co " + xa.size() + " xa");
                    for (int l = 0; l < xa.size(); l++) {
                        if (l == 1) {
                            xa.get(l).click();
                            break;
                        }
                    }
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("#create-customer-modal > div > div > div.modal-footer > button.btn.btn-primary.ng-binding")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.id("btn-save-1")).click();
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click();");

                    Thread.sleep(3000);
                    indexOrder = i;
                    break;

                }
            } // Het vong for
            indexOrder += 1;
            numberOrder += 1;
        } // Het vong while
        driver.quit();
    }
}
