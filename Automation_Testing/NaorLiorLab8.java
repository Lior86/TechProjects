import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaorLiorLab8 {

public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		//Registration flow
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Lior");
		driver.findElement(By.name("lastName")).sendKeys("Naor");
		driver.findElement(By.name("phone")).sendKeys("6478882424");
		driver.findElement(By.id("userName")).sendKeys("Lnaor86@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("12 Ellesmere st");
		driver.findElement(By.name("city")).sendKeys("Toronto");
		driver.findElement(By.name("state")).sendKeys("Utah");
		driver.findElement(By.name("postalCode")).sendKeys("l3t3r6");
		driver.findElement(By.xpath("//select[@name='country']")).sendKeys("CANADA");
		driver.findElement(By.id("email")).sendKeys("Lnaor86@gmail.com");
		driver.findElement(By.name("password")).sendKeys("LiorNaor");
		driver.findElement(By.name("confirmPassword")).sendKeys("LiorNaor");
		driver.findElement(By.cssSelector("input[name='submit'")).click();
		String message = driver.findElement(By.xpath("//font[contains(text(), 'Thank you for registering')]")).getText();
		System.out.println(message);
		
		// Flight booking flow
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[value='roundtrip'")).click();
		driver.findElement(By.xpath("//select[@name='passCount']//option[2]"));
		driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("London");
		driver.findElement(By.xpath("//select[@name='fromMonth']//option[6]"));
		driver.findElement(By.xpath("//select[@name='fromDay']//option[11]"));
		driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("Paris");
		driver.findElement(By.xpath("//select[@name='toMonth']//option[8]"));
		driver.findElement(By.xpath("//select[@name='toDay']//option[1]"));
		driver.findElement(By.cssSelector("input[value='First'")).click();
		driver.findElement(By.xpath("//select[@name='airline']")).sendKeys("Unified Airlines");
		driver.findElement(By.name("findFlights")).click();
		String message2 = driver.findElement(By.xpath("//font[contains(.,'No Seats Avaialble')]")).getText();
		
		if (message2 != null ) {
			System.out.println("no seats available message was displayed successfully");
			System.out.println(message2);

		} else {
			System.out.println("NO seats available message, not found");
		}


		


				
		
		
		
}

}
