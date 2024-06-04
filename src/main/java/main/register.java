package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class register {

    private WebDriver driver;

    public register(WebDriver driver) {
        this.driver = driver;
    }

    public void Register(String role,String Name, String email, String phoneNumber, String password, boolean logout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://localhost:5173/login");

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/a"));
        registerButton.click();
        
        WebElement roleSelect = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[1]/div/select"));
		Select select = new Select(roleSelect);
		select.selectByVisibleText(role);

        WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[2]/div/input"));
        username.sendKeys(Name);

        WebElement email1 = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[3]/div/input"));
        email1.sendKeys(email);

        WebElement phonenum = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[4]/div/input"));
        phonenum.sendKeys(phoneNumber);

        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[5]/div/input"));
        passwordElement.sendKeys(password);

        WebElement registerButtonElement = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/button"));
        registerButtonElement.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("errorMessage")));
            String reactErrorMsg = errorMessageElement.getText();
            System.out.println("Error: " + reactErrorMsg);
        } catch (Exception err) {
            System.out.println("Registration successful");
            if (logout == true) {

				WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/ul/button"));
				logoutButton.click();
	}
        }
    }
}