package freeshipping2019_01;

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
public class Store1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://freeshipping2019.com/stores");
        driver.manage().window().maximize();

        List<WebElement> btn = new ArrayList<>();
        List<String> textCat = new ArrayList<>();
        
        int indexCat = 3;

        btn = driver.findElements(By.cssSelector("#storeAll > div.storeAll-top > div.select-alphabet > div.sorter-list > a"));
        // For để get toàn bộ text của danh mục
        // Do khi ấn vào danh mục sẽ bị mất danh mục category lúc đầu
        for (int t = 0; t < btn.size(); t++) {
            textCat.add(btn.get(t).getText());
        }
        
        for (int i = 0; i < textCat.size(); i++) {

            indexCat = i + 3;

            List<WebElement> cat = new ArrayList<>();

            cat = driver.findElements(By.cssSelector("#storeAll > div:nth-child("+ indexCat +") > div > a"));
            // Trường hợp danh mục không có thì nhảy sang vòng for tiếp theo
            if (cat.size() == 0) {
                continue;
            }
            System.out.println("Nhóm " + textCat.get(i).toString() + " có: " + cat.size() + " stores");
            
            for (int j = 0; j < cat.size(); j++) {
                ((JavascriptExecutor) driver).executeScript("window.open()");
                ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab.get(1));
                driver.get("https://freeshipping2019.com/stores#" + textCat.get(i).toString());
                
                String linkTextCat = driver.findElements(By.cssSelector("#storeAll > div:nth-child("+ indexCat +") > div > a")).get(j).getAttribute("href");
                driver.findElements(By.cssSelector("#storeAll > div:nth-child("+ indexCat +") > div > a")).get(j).click();

                List<WebElement> btnGetDeal = new ArrayList<>();

                btnGetDeal = driver.findElements(By.cssSelector(".deal-button"));

                for (int z = 0; z < btnGetDeal.size(); z++) {
                    btnGetDeal = driver.findElements(By.cssSelector(".deal-button"));
                    String btnGetDealText = btnGetDeal.get(z).getText();
                    try {
                        if (btnGetDealText.equals("GET DEAL")) {
                            btnGetDeal.get(z).click();
                            ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tab1.get(2));
                            String URL = driver.getCurrentUrl();
                            System.out.println(URL);
                            driver.close();

                            ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tab2.get(1));
                            String text = driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.top > span")).getText();
                            System.out.println(text);
                            driver.get(linkTextCat);

                        } else {
                            btnGetDeal.get(z).click();
                            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tabs.get(2));
                            String text2 = driver.findElement(By.cssSelector("body > div.vex.updated-modal.animation > div.vex-content > div.deal-modal > div.section.middle > div > div > span")).getText();
                            System.out.println(text2);
                            driver.close();

                            ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                            driver.switchTo().window(tab2.get(1));
                            String URL = driver.getCurrentUrl();
                            System.out.println(URL);
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
            
            System.out.println("Hết nhóm");
        }
        
        driver.quit();
    }
}