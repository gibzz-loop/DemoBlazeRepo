package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoCart {
	WebDriver driver;
	WebDriverWait wait;
	By cartfield=By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
	By carticon=By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]");
	By placeorderfield=By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
	By name=By.id("name");
	By country=By.id("country");
	By city=By.id("city");
	By creditcard=By.id("card");
	By month=By.id("month");
	By year=By.id("year");
	By purchase=By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
	By thankyoudisplay=By.xpath("//*[contains(text(),'Thank you for your purchase')]");
	By clickok=By.xpath("//button[normalize-space()='OK']");
	By close=By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
	
	
			public DemoCart(WebDriver driver) {
		this.driver=driver;	
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	public boolean cartbutton() {
		WebElement cb=wait.until(ExpectedConditions.visibilityOfElementLocated(cartfield));
		boolean displayed=cb.isDisplayed();
        return displayed;
		
	}
	public void cartclick() {
		wait.until(ExpectedConditions.elementToBeClickable(cartfield)).click();
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}
	public void cart() {
		driver.findElement(carticon).click();
	}
	public void placorder() {
		wait.until(ExpectedConditions.elementToBeClickable(placeorderfield)).click();
	}
	public void fillform(String n, String c, String ci, String cc, String m, String y) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(n);
		driver.findElement(country).sendKeys(c);
		driver.findElement(city).sendKeys(ci);
		driver.findElement(creditcard).sendKeys(cc);
		driver.findElement(month).sendKeys(m);
		driver.findElement(year).sendKeys(y);
	
	}

	public void purchaseclick() {
		wait.until(ExpectedConditions.elementToBeClickable(purchase)).click();
	}
	public boolean thankyoudisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(thankyoudisplay)).isDisplayed();
	}
	public void okbutton() {
			wait.until(ExpectedConditions.elementToBeClickable(clickok)).click();
			
		} 
	public void closebutton() {
		wait.until(ExpectedConditions.elementToBeClickable(close)).click();
	}
	public void opennewtab() {
		String parent = driver.getWindowHandle();

		((JavascriptExecutor) driver).executeScript("window.open('https://www.demoblaze.com/index.html','_blank');");
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String h : driver.getWindowHandles()) {
			if (!h.equals(parent)) {
				driver.switchTo().window(h);
				break;
			}
		}
		System.out.println("new tab url = " + driver.getCurrentUrl());
	}  
	}


