package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class viewapplication {

	private WebDriver driver;

	public viewapplication(WebDriver driver) {
		this.driver = driver;
	}

	public void viewapply() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:5173/applications/me");
		//to delete
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div[1]/div[3]/button"));
        applyButton.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			WebElement errorMessageElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
			String reactErrorMsg = errorMessageElement.getText();
			System.out.println("Error: " + reactErrorMsg);
		} catch (Exception err) {
			System.out.println("Applied successful");
			
		}
	}
}