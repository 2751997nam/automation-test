package Tester;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class helloword {

    public static void main(String[] args) throws InterruptedException {
        
        System.setProperty("webdriver.chrome.driver","D:\\New folder\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver
        driver.get("https://chiaki.vn/");
        driver.manage().window().maximize();
        
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
           
        //tim kiem theo id duy nhat
     driver.findElement(By.id("keyword")).sendKeys("collagen");
        
     driver.findElement(By.id("searchButton")).click();
        
        
        driver.close();
        
        
    }
}
