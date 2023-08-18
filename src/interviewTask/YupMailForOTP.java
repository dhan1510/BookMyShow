package interviewTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YupMailForOTP {

    static 	WebDriver driver;
    
	public static String copyOTP()  throws InterruptedException
	{
		 driver = new ChromeDriver();
		driver.get("https://yopmail.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//input[@class='ycptinput']")).sendKeys("seleniumauto@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().frame("ifmail");
		
		Thread.sleep(500);
		String OTP = driver.findElement(By.xpath("(//table/tbody/tr)[11]")).getText();
		driver.close();
		return OTP;

	}

}
