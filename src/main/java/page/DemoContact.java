package page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoContact {
	WebDriver driver;
	WebDriverWait wait;
	By contactfield=By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
	By emailfield = By.id("recipient-email");
	By contactname = By.id("recipient-name");
	By messagefield = By.id("message-text");
	By sendfield=By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
	
	
public DemoContact(WebDriver driver) {
	this.driver=driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
public void contacttab() {
	wait.until(ExpectedConditions.elementToBeClickable(contactfield)).click();
}
public void fill(String email,String cn,String message) throws IOException {
	wait.until(ExpectedConditions.visibilityOfElementLocated(emailfield)).sendKeys(email);
	driver.findElement(contactname).sendKeys(cn);
	driver.findElement(messagefield).sendKeys(message);
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("./screenshot/pagescreenshot.png"));
}

	
public String sendmessage() {
	wait.until(ExpectedConditions.elementToBeClickable(sendfield)).click();
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	String text = alert.getText();
	alert.accept();
	return text;
}
}



