package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demopage {
	WebDriver driver;
	WebDriverWait wait;

	By login = By.xpath("//*[@id=\"login2\"]");
	By usernamefield = By.id("loginusername");
	By passwordfield = By.id("loginpassword");
	By loginfield = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
	By loginmodal = By.id("logInModal");

	public Demopage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void loginbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	}

	public void loginpath(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernamefield)).sendKeys(user);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfield)).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(loginfield)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loginmodal));
	}
}