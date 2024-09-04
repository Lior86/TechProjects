package simpleForm;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FacebookTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Facebook login flow
		driver.get("https://www.facebook.com");
		WebElement email = driver.findElement(By.id("email"));
		email.clear(); 
		email.sendKeys("Lnaor86@gmail.com");
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("trader");
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		
		// Facebook signup flow
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/reg/");
		WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname'"));
		firstName.sendKeys("Lior");
		WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname'"));
		lastName.sendKeys("Naor");
		WebElement month = driver.findElement(By.xpath("//select[@id='month']//option[2]"));
		month.click();
		WebElement day = driver.findElement(By.xpath("//select[@id='day']//option[7]"));
		day.click();
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		year.sendKeys("2016");
		WebElement phone = driver.findElement(By.cssSelector("input[name='reg_email__'"));
		phone.sendKeys("6474442244");
		WebElement newPassword = driver.findElement(By.cssSelector("input[id='password_step_input'"));
		newPassword.sendKeys("password");
		WebElement gender = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
		gender.click();
		WebElement signup = driver.findElement(By.xpath("//button [@name='websubmit']"));
		signup.click();
		
		driver.quit();
		
		



		
	}
}

