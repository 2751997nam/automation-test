/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProductSuccess {

    public static void main(String[] args) {
        // 
        //System.setProperty("webdriver.gecko.driver", "E:\\Work\\Selenium\\libs\\geckodriver.exe");

        //WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://chiaki.vn/");
        driver.manage().window().maximize();
        // tat popup
        //WebDriverWait wait1 = new WebDriverWait(driver, 10);
        //WebElement anoun = wait1.until(ExpectedConditions.elementToBeClickable(By.className("ChiakiPopupClose")));
        //anoun.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement anoun2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("onesignal-popover-cancel-button")));
        anoun2.click();

        driver.findElement(By.id("keyword")).sendKeys("kem dưỡng da");
        //driver.findElement(By.id("keyword")).sendKeys();

        WebElement ul = driver.findElement(By.cssSelector("ul#search-suggestion"));
        List<WebElement> countriesList = ul.findElements(By.tagName("li"));
        for (int i = 1; i < countriesList.size(); i++) {
            System.out.println(countriesList.get(i).getText());
        }

        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofMinutes(30).getSeconds());
        waiter.until(ExpectedConditions.elementToBeClickable(By.className("search-in-category")));
        System.out.println("OK");
        driver.findElement(By.xpath("//*[@id=\"search-in-category-template\"]/a")).click();

        driver.findElement(By.cssSelector(".col-md-3:nth-child(4) .items-block-img")).click();

        driver.findElement(By.cssSelector("#js-mua-hang > span")).click();

        driver.findElement(By.id("username")).sendKeys("Test");
        driver.findElement(By.id("delivery_phone")).sendKeys("0977920221");
        driver.findElement(By.id("delivery_location_id")).click();
        Select province = new Select(driver.findElement(By.id("delivery_location_id")));
        province.selectByVisibleText("Hà Nội");
        //province.selectByIndex(1);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("delivery_district_id")).click();
        Select district = new Select(driver.findElement(By.id("delivery_district_id")));
        district.selectByVisibleText("Hoàng Mai");
        //district.selectByIndex(0);
        driver.findElement(By.id("delivery_address")).sendKeys("Số 6 Lê Văn Thiêm");
        driver.findElement(By.id("delivery_shipping_time")).click();
        Select Note = new Select(driver.findElement(By.id("delivery_shipping_time")));
        Note.selectByVisibleText("Đặt hàng hộ người thân");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("description")).sendKeys("Kỹ thuật test");

        driver.findElement(By.xpath("//*[@id=\"form\"]/div[4]/button")).click();

        WebElement element = driver.findElement(By.className("login-title"));
        String text = element.getText();
        if (text.contains("ĐẶT HÀNG THÀNH CÔNG")) {
            System.out.println("Test successfull");
        } else {
            System.out.println("Test Failed");
        }

        driver.close();
    }
}
