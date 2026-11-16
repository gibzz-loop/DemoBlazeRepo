package page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoNewtab {

    WebDriver driver;
    WebDriverWait wait;

    By categoryLaptops = By.xpath("//a[@id='itemc' and text()='Laptops']");
    By productLinks    = By.xpath("//*[@id='tbodyid']/div/div/div/h4/a");
    By addToCart       = By.xpath("//a[contains(text(),'Add to cart')]");
    By hometab = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    By nextfield=By.xpath("//*[@id=\"next2\"]");
    By monitorfield=By.xpath("//*[@id=\"itemc\"]");
    By previousfield=By.xpath("//*[@id=\"prev2\"]");

    public DemoNewtab(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addAllLaptops() {
        
        WebElement oldFirst = wait.until(
                ExpectedConditions.presenceOfElementLocated(productLinks));

      
        wait.until(ExpectedConditions.elementToBeClickable(categoryLaptops)).click();

       
        wait.until(ExpectedConditions.stalenessOf(oldFirst));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));

       
        List<String> urls = new ArrayList<>();
        for (WebElement e : driver.findElements(productLinks)) {
            String href = e.getAttribute("href");
            if (!urls.contains(href)) {
                urls.add(href);
            }
        }
        System.out.println("Laptops found = " + urls.size());

     
        for (String url : urls) {
            driver.get(url);
            WebElement add = wait.until(ExpectedConditions.presenceOfElementLocated(addToCart));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        }
    }
    public void home() {
    	wait.until(ExpectedConditions.elementToBeClickable(hometab)).click();
    }
    public void nexttab() {
    	wait.until(ExpectedConditions.elementToBeClickable(nextfield)).click();
    }
    public void monitortab() {
    	wait.until(ExpectedConditions.elementToBeClickable(monitorfield)).click();
    }
    public void previousbutton() {
    	wait.until(ExpectedConditions.elementToBeClickable(previousfield)).click();
    }
    
    }
