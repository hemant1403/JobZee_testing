package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {

	private WebDriver driver;

	public login(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String role, String email, String password, boolean logout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("http://localhost:5173/login");
		WebElement roleSelect = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[1]/div/select"));
		Select select = new Select(roleSelect);
		select.selectByVisibleText(role);
	

		WebElement loginEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[2]/div/input"));
		loginEmail.sendKeys(email);

		WebElement loginPassword = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[3]/div/input"));
		loginPassword.sendKeys(password);

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/button"));
		loginButton.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			WebElement errorMessageElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
			String reactErrorMsg = errorMessageElement.getText();
			System.out.println("Error: " + reactErrorMsg);
		} catch (Exception err) {
			System.out.println("Login successful");
//			if (logout == true) {
//
//				WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/ul/button"));
//				logoutButton.click();
//			}
		}
	}
}