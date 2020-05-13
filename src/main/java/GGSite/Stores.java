/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GGSite;

import java.util.ArrayList;
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
public class Stores {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://sites.google.com/site/foryacoupon/stores");

        // Get list deal
        List<WebElement> btn = new ArrayList<>();
        int indexCat = 3;

        btn = driver.findElements(By.cssSelector("#sites-canvas-main-content > table > tbody > tr > td > div > div > div > div:nth-child(1) > div > div > a"));
        for (int i = 0; i < btn.size(); i++) {
            String textCat = btn.get(i).getText();
            indexCat = i + 3;

            btn.get(i).click();
            List<WebElement> cat = new ArrayList<>();
            cat = driver.findElements(By.cssSelector("#sites-canvas-main-content > table > tbody > tr > td > div > div > div > div:nth-child(" + indexCat + ") > div > a"));
            System.out.println("Nhóm " + textCat + " có: " + cat.size() + " stores");
            for (int j = 0; j < cat.size(); j++) {
                ((JavascriptExecutor) driver).executeScript("window.open()");
                ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab.get(1));
                driver.get("https://sites.google.com/site/foryacoupon/stores#" + textCat);

                String linkTextCat = driver.findElements(By.cssSelector("#sites-canvas-main-content > table > tbody > tr > td > div > div > div > div:nth-child(" + indexCat + ") > div > a")).get(j).getAttribute("href");

                driver.findElements(By.cssSelector("#sites-canvas-main-content > table > tbody > tr > td > div > div > div > div:nth-child(" + indexCat + ") > div > a")).get(j).click();

                List<WebElement> btnGetDeal = new ArrayList<>();
                btnGetDeal = driver.findElements(By.tagName("iframe"));
                for (int z = 0; z < btnGetDeal.size(); z++) {
                    driver.switchTo().frame(z);
                    try {
                        String btnGetDealText = driver.findElement(By.cssSelector(".btn-coupon")).getText();

                        if (btnGetDealText.equals("Get Deal")) {
                            driver.findElement(By.cssSelector(".btn-coupon")).click();
                            ArrayList<String> tabz = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tabz.get(2));
                            String currentURL1;
                            currentURL1 = driver.getCurrentUrl();
                            System.out.println(currentURL1);
                            driver.close();

                            ArrayList<String> tabz2 = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tabz2.get(1));
                            String text = driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.top > span")).getText();
                            System.out.println(text);

//                            driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.middle > a")).click();
//                            ArrayList<String> tabz3 = new ArrayList<String>(driver.getWindowHandles());
//                            driver.switchTo().window(tabz3.get(3));
//                            String currentURL;
//                            currentURL = driver.getCurrentUrl();
//                            if (currentURL.equalsIgnoreCase(currentURL1)) {
//                                System.out.println("Link wweb dung roi nhe");
//                            } else {
//                                System.out.println("Link web failed");
//                            }

                            driver.get(linkTextCat);
                        } else {
                            driver.findElement(By.cssSelector(".btn-coupon")).click();
                            ArrayList<String> tabz = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tabz.get(1));
                            driver.close();

                            ArrayList<String> tabz2 = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tabz2.get(1));
                            String text = driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.middle > div > div > span")).getText();
                            System.out.println(text);

                            driver.get(linkTextCat);
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(1));
                driver.close();

                ArrayList<String> tab3 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab3.get(0));
            }
        }
        driver.quit();
//        
    }
}
