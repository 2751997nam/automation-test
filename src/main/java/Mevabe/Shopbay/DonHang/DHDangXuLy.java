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
public class DHDangXuLy {

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

        //Chon tung tab Don hang can xu ly
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/ul/li[2]")).click();
        Thread.sleep(3000);

        // Biến đếm để test
        int numberOrderForTest = 6;
        int numberOrder = 1;

        while (numberOrder < numberOrderForTest) {
            //System.out.println("Lượt test thứ " + numberOrder);
            List<WebElement> orderlist = driver.findElements(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr"));
            //System.out.println("Có tất cả : " + orderlist.size() + " đơn hàng trên trang 1");

            // Lặp các đơn hàng này
            for (int i = 0; i < orderlist.size(); i++) {
                // Trong các đơn lại có nhiều thẻ tr nên cần lặp để lấy được label label-success kia
                List<WebElement> elements = orderlist.get(i).findElements(By.cssSelector("td"));
                // System.out.println("Có " +elements.size() + " thành phần trong đơn hàng");
                // Lấy thành phần thứ 6 chính là cái span trạng thái
                String status = elements.get(6).getText();
                //System.out.println("Trạng thái đơn hàng: " + status);

                // Trạng thái là Đang xử lý thì
                if (status.equals("Đang xử lý")) {
                    // Click vào đơn hàng Đang xử lý
                    orderlist.get(i).click();
                    driver.switchTo().window(currentHandle);
                    // Click vào button Chờ xuất hàng
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div > div > div:nth-child(1) > div.body > div > div > div:nth-child(1) > div.col-md-8 > div > div:nth-child(1) > div > div > button.btn.btn-flat.btn-success.ml-3\").click();");

                    // Chờ hiển thị popup và click vào button Ok để chuyển trạng thái
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click();");

                    // Chờ hiển thị popup thành công
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click();");

                    // Click vào button hủy để quay về danh sách đơn hàng
                    jse.executeScript("document.querySelector(\"#btn-cancel\").click();");
                    // Chờ load danh sách đơn hàng
                    Thread.sleep(3000);

                }else if(status.equals("Chờ xuất hàng")){
                orderlist.get(i).click();
                driver.switchTo().window(currentHandle);
                    //click vao nut Giao hang
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div > div > div:nth-child(1) > div.body > div > div > div:nth-child(1) > div.col-md-8 > div > div:nth-child(1) > div > div > button.btn.btn-flat.btn-success.ml-3\").click();");
                    // Chờ hiển thị popup thành công
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click();");

                    // Click vào button hủy để quay về danh sách đơn hàng
                    jse.executeScript("document.querySelector(\"#btn-cancel\").click();");
                    // Chờ load danh sách đơn hàng
                    Thread.sleep(3000);
                } 
                else if (status.equals("Đang giao hàng")) {
                    orderlist.get(i).click();
                    driver.switchTo().window(currentHandle);
                    //click vao nut Thanh cong
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div > div > div:nth-child(1) > div.body > div > div > div:nth-child(1) > div.col-md-8 > div > div:nth-child(1) > div > div > button.btn.btn-flat.btn-success.ml-3\").click();");
                    // Chờ hiển thị popup thành công
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click();");

                    // Click vào button hủy để quay về danh sách đơn hàng
                    jse.executeScript("document.querySelector(\"#btn-cancel\").click();");
                    // Chờ load danh sách đơn hàng
                    Thread.sleep(3000);
                } else if (status.equals("Thành công")) {
                     //click vao nut Đã trả hàng
                    orderlist.get(i).click();
                    driver.switchTo().window(currentHandle);
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.wrapper.ng-scope > div > div:nth-child(1) > div.body > div > div > div:nth-child(1) > div.col-md-8 > div > div:nth-child(1) > div > div > button\").click();");
                    // Chờ hiển thị popup thành công
                    Thread.sleep(1000);
                    jse.executeScript("document.querySelector(\"body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click();");

                    // Click vào button hủy để quay về danh sách đơn hàng
                    jse.executeScript("document.querySelector(\"#btn-cancel\").click();");
                    // Chờ load danh sách đơn hàng
                    Thread.sleep(3000);

                } else {
                    orderlist.get(i).click();
                    driver.switchTo().window(currentHandle);
                    jse.executeScript("document.querySelector(\"#btn-cancel\").click();");
                }
            } // Het vong for

            numberOrder += 1;
        } // Het vong while
        driver.quit();
    }
}
