package page;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoHome {
	WebDriver driver;
	WebDriverWait wait;
	By homelink= By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
	By phonefield = By.xpath("//*[@id=\"itemc\"]");
	By linkfield = By.tagName("a");
	By productlink =By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
	By cartfield=By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
	
	 
	public DemoHome(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void homepage() {
		wait.until(ExpectedConditions.elementToBeClickable(homelink)).click();
	}
	public boolean phonetext() {
    WebElement ph= wait.until(ExpectedConditions.visibilityOfElementLocated(phonefield));
    boolean displayed=ph.isDisplayed();
    ph.click();
    return displayed;
	}
	public void alllinks() {
		List<WebElement> li = driver.findElements(linkfield);
		System.out.println("total no of links=" + li.size());
		for (WebElement ele : li) {
			String link = ele.getAttribute("href");
			String text = ele.getText();
			System.out.println(link + "---------" + text);
		}
	}
	public void product() {
		wait.until(ExpectedConditions.elementToBeClickable(productlink)).click();
	}
	}
		
			
				



