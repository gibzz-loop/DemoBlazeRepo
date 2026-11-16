package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoAboutus {
	 WebDriver driver;
	  WebDriverWait wait;

	By aboutfield = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
	By startbutton = By.xpath("//*[@id='example-video']/button");
	By pausebutton = By.xpath("//*[@id='example-video']/div[4]/button[1]");
	By soundmute= By.xpath("//*[@id='example-video']/div[4]/div[1]/button");
	By soundunmute = By.xpath("//*[@id='example-video']/div[4]/div[1]/button");
	By picbutton = By.xpath("//*[@id='example-video']/div[4]/button[3]");
	By fullscreen = By.xpath("//*[@id='example-video']/div[4]/button[4]");
	By nonfullscreen = By.xpath("//*[@id='example-video']/div[4]/button[4]");
	By closevideo = By.xpath("//*[@id='videoModal']/div/div/div[3]/button");
	By logout = By.xpath("//*[@id=\"logout2\"]");

	public DemoAboutus(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

}
	public void aboutus() {
		wait.until(ExpectedConditions.elementToBeClickable(aboutfield)).click();
	}
	public void start() {
		wait.until(ExpectedConditions.elementToBeClickable(startbutton)).click();
	}
	public void pause() {
		wait.until(ExpectedConditions.elementToBeClickable(pausebutton)).click();
	}
	public void soundbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(soundmute)).click();
		wait.until(ExpectedConditions.elementToBeClickable(soundunmute)).click();
	}
	public void picture() {
		wait.until(ExpectedConditions.elementToBeClickable(picbutton)).click();
	}

	public void fullscreenbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(fullscreen)).click();
	}
	public void nonfullscreenbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(nonfullscreen)).click();
	}
	public boolean closebutton() {
		WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closevideo));
		boolean displayed = close.isDisplayed();
		close.click();
		return displayed;
	}
	public void logoutbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}
	}

