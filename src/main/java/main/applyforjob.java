package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class applyforjob {

	private WebDriver driver;

	public applyforjob(WebDriver driver) {
		this.driver = driver;
	}

	public void applyjob(String name, String email, Integer phone , String address, String coverletter, String path) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("http://localhost:5173/job/getall");

		 WebElement jobLink = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/ul/li[2]/a"));
	        jobLink.click();
		
	        
//
//	        // Click on the apply button
	        WebElement detail = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/div[1]/a"));
	        detail.click();
	        
	        WebElement applybtn = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/div/a"));
	        applybtn.click();

	        WebElement name1 = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/input[1]"));
			name1.sendKeys(name);
			
			WebElement email1 = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/input[2]"));
			email1.sendKeys(email);
			
			WebElement phone1 = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/input[3]"));
			phone1.sendKeys(String.valueOf(phone));
			
			WebElement address1 = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/input[4]"));
			address1.sendKeys(address);
			
			WebElement cover = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/textarea"));
			cover.sendKeys(coverletter);
			
			WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/div/input"));
	        fileInput.sendKeys(path);
	        
	        WebElement postapplication = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div/form/button"));
	        postapplication.click();

//	        
//	        
//	        WebElement applylink = driver.findElement(By.linkText("/application/662a64ece7bdb74040a2b271"));
//
//	        // Click on the link
//	        applylink.click();
	        

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