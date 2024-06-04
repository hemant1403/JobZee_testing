/*
package main;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Assuming you have ChromeDriver installed and the path set
    	System.setProperty("webdriver.chome.driver", "C:/Users/HP/Downloads/chromedriver-win64/chromedriver-win64");

        driver = new ChromeDriver();
        driver.get("http://localhost:5173/login"); // Replace with your website URL
    }

    @Test
    public void testLoginWithValidCredentials() {
        WebElement roleInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[1]/div/select/option[1]"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[2]/div/input"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[3]/div/input"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/button"));

        roleInput.sendKeys("Employer");
        emailInput.sendKeys("hem@gmail.com");
        passwordInput.sendKeys("12345678");
        loginButton.click();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        // Assuming successful login redirects to another page, you can assert the URL or any element on that page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "hhttp://localhost:5173");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
    	 WebElement roleInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[1]/div/select/option[1]"));
         WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[2]/div/input"));
         WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/div[3]/div/input"));
         WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/section/div[1]/form/button"));

         roleInput.sendKeys("Employer");
         emailInput.sendKeys("cft@gmail.com");
         passwordInput.sendKeys("12345678");
         loginButton.click();

        // Assuming it shows an error message on invalid login attempt, you can assert the presence of that message
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


*/



package main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import login;
//import register.register;
//import postnewjob.postnewjob;
//import applyforjob.applyforjob;
//import applyforjob.viewapplication;

public class NewTest {

	private WebDriver driver;
	
	@BeforeTest
	 public void setup() {
		System.out.println("joii");
        System.setProperty("webdriver.edge.driver", "C:/Users/HP/Downloads/edgedriver_win64/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
		driver.get("http://localhost:5173/login");
    }

	
    @Test(dataProvider = "getData",priority = 1,enabled = false) 
    
    public void testRegister(String role, String Name, String email, String phoneNumber, String password)
 {
        register registerObj = new register(driver);
        registerObj.Register(role, Name, email, phoneNumber,password, true);
    }

    @Test(dataProvider = "getDataLogin",priority = 2,enabled = true)
    
    public void testLogin(String role, String email, String password) {
    	System.out.println("joii");
        login loginObj = new login(driver);
        loginObj.Login(role, email, password,true);
    }
    
    @Test(dataProvider = "getDataJobPost",priority = 3, enabled = false)
    
    public void jobpost(String jobtitle, String jobcategory, String country, String city,String location,String salaryType, Integer salary, Integer salary1,String jobdes) {
        postnewjob jobpostObj = new postnewjob(driver);
        jobpostObj.JobPost(jobtitle,jobcategory, country, city,location,salaryType,  salary, salary1,jobdes);
       // jobpostObj.JobPost("jobtitle","Mobile App Development", "india", "gurugram","gurugram","Ranged Salary",  123456, 123456,"heloo this is job");
        
  }
  @Test(priority = 3,enabled = true)
    
    public void viewmyapplication() {
    	System.out.println("in application view");
    	viewapplication applyObj = new viewapplication(driver);
        applyObj.viewapply();
    }
   
  @Test(dataProvider = "getDataApply", priority = 3,enabled = false)
  
  public void applyyjob(String name, String email, Integer phone , String address, String coverletter, String path) {
  	System.out.println("in apply");
  	applyforjob applyObj = new applyforjob(driver);
      applyObj.applyjob(name,email,phone,address,coverletter,path);
  }
    
    @DataProvider
	public Object[][]getDataLogin(){
		Object[][]obj=new Object[1][3];
		obj[0][0]="Job Seeker";
		obj[0][1]="xyz@gmail.com";
		obj[0][2]="12345678";
//		obj[1][0]="Employer";
//		obj[1][1]="sar@gmail.edu";
//		obj[1][2]="12345678";
//		obj[2][0]="Employer";
//		obj[2][1]="pra@gmail.com";
//		obj[2][2]="12345678";
//		obj[3][0]="Job Seeker";
//		obj[3][1]="p@gmail.com";
//		obj[3][2]="12345678";
//		obj[4][0]="Job Seeker";
//		obj[4][1]="qwr@gmail.com";
//		obj[4][2]="12345678";
//		obj[5][0]="Employer";
//		obj[5][1]="hem@gmail.com";
//		obj[5][2]="12345678";
		return obj;
	}
    
    @DataProvider(name = "getDataJobPost")
    public Object[][] getJobPostData() {
        return new Object[][]{
               // {"Job Title 1", "Mobile App Development", "Country 1", "City 1", "Location 1", "Fixed Salary", 50000, null, "Job Description 1"},
                {"Job Title 2", "Video Animation", "Country 2", "City 2", "Location 2", "Ranged Salary", 60000, 80000, "Job Description 2"},
                // Add more test data as needed
        };
    }
    
    @DataProvider(name = "getDataApply")
    public Object[][] getapply() {
        return new Object[][]{
                {"test", "test@gmail.com", 1234567890, "my address is address", "this is my coverletter", "C:/Users/HP/Downloads/cv3.jpg"},
                
        };
    }
   
    @DataProvider
	public Object[][]getData(){
		Object[][]obj=new Object[2][5];
		obj[0][0]="Employer";
		obj[0][1]="chetan";
		obj[0][2]="chetinadqk@gmail.com";
		obj[0][3]= "1234567890";
		obj[0][4]="12345678";
		
		obj[1][0]="Job Seeker";
		obj[1][1]="randomuser";
		obj[1][2]="ran123@gmail.com";
		obj[1][3]="1234567890";
		obj[1][4]="12345678";

		

		return obj;
	}
//    
	@AfterTest
	public void tearDown() {
		// Close the browser
		System.out.println("joii");
		driver.quit();
	}
}
