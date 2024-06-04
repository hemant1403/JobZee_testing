package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class postnewjob {

	private WebDriver driver;

	public postnewjob(WebDriver driver) {
		this.driver = driver;
	}

	public void JobPost(String jobtitle, String jobcategory, String country, String city,String location,String salaryType, Integer salary, Integer salary1,String jobdes) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:5173/job/post");
		
	

		WebElement jobtitle1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[1]/input"));
		jobtitle1.sendKeys(jobtitle);
		
		WebElement jobcategory1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[1]/select"));
		Select select = new Select(jobcategory1);
		select.selectByVisibleText(jobcategory);
				
		WebElement country1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[2]/input[1]"));
		country1.sendKeys(country);
		
		WebElement city1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[2]/input[2]"));
		city1.sendKeys(city);
		
		WebElement location1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/input"));
		location1.sendKeys(location);
		
		 WebElement salaryDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[3]/select"));
	        Select select1 = new Select(salaryDropdown);
	    
	        select1.selectByVisibleText(salaryType);
	        
	   
	        WebElement salaryInputField;
	        if (salaryType.equals("Fixed Salary")) {
	            salaryInputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[3]/div/input"));
	            salaryInputField.sendKeys(String.valueOf(salary));
	        } else {
	            salaryInputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[3]/div/div/input[1]"));
	            salaryInputField.sendKeys(String.valueOf(salary));
	            salaryInputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[3]/div/div/input[2]"));
	            salaryInputField.sendKeys(String.valueOf(salary1));
	            
	        }
	        
	
	        
	        
	        WebElement jobdesc = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/textarea"));
			jobdesc.sendKeys(jobdes);
		
			WebElement postjobbutton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/button"));
	        postjobbutton.click();
	        
	        WebElement gotohome = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/ul/li[1]/a"));
	        gotohome.click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
			WebElement errorMessageElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
			String reactErrorMsg = errorMessageElement.getText();
			System.out.println("Error: " + reactErrorMsg);
		} catch (Exception err) {
			System.out.println("Job Posted successful");
			
		}
	}
}