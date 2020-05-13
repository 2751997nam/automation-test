/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGioiGiay;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Dell
 */
public class DMNam {

    public static void test() {
        System.setProperty("webdriver.chrome.driver", Config.getDriver());
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.navigate().to(Config.site);
        driver.manage().window().maximize();
        //Truy cap vao danh muc Nam
        driver.findElement(By.xpath("//*[@id=\"navbar-nav\"]/li[1]/a")).click();

        WebElement text = driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/div/h1/small"));
        System.out.println(text.getText());

        driver.quit();

    }
}
