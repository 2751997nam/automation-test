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
public class XoaSpDH {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String currentHandle = driver.getWindowHandle();

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

        //Khai bao bien de test
        int numberOrder = 1;
        int numberOrderForTest = 6;
        int indexOrder = 0;

        while (numberOrder < numberOrderForTest) {
            List<WebElement> orderlist = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr"));

            //Lap don hang
            for (int i = indexOrder; i < orderlist.size(); i++) {
                // Trong các đơn lại có nhiều thẻ tr nên cần lặp để lấy được label label-success kia
                List<WebElement> elements = orderlist.get(i).findElements(By.cssSelector("td"));
                // Lấy thành phần thứ 6 chính là cái span trạng thái
                String status = elements.get(6).getText();
                String masp = elements.get(0).getText();

                // Trạng thái là Đang xử lý 
                if (status.equals("Đang xử lý")) {
                    // Click vào đơn hàng Đang xử lý
                    orderlist.get(i).click();
                    Thread.sleep(1000);
                    //lay danh sach san pham cua don hang
                    List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[3]/table/tbody/tr"));

                    System.out.println("Đơn hàng " + masp + " có: " + products.size() + " sản phẩm");
                    Thread.sleep(3000);
                    //Click vào icon xoa san pham dau tien
                    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[3]/table/tbody/tr[1]/td[8]/a")).click();
                    driver.findElement(By.id("btn-save-1"));
                    
                    Thread.sleep(3000);
                    indexOrder = i;
                    break;
                } else if (status.equals("Chờ xuất hàng")) {
                    orderlist.get(i).click();
                    driver.switchTo().window(currentHandle);
                    Thread.sleep(1000);
                    //lay danh sach san pham cua don hang
                    List<WebElement> products = driver.findElements(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[3]/table/tbody/tr"));

                    System.out.println("Đơn hàng " + masp + " có: " + products.size() + " sản phẩm");
                    Thread.sleep(1000);
                    //Click icon xoa sp dau tien
                    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[3]/table/tbody/tr[1]/td[8]/a")).click();
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
