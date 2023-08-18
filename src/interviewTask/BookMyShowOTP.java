package interviewTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShowOTP {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		 driver= new ChromeDriver();
		
		driver.get("https://in.bookmyshow.com/explore/home/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("(//li[@class='bwc__sc-ttnkwg-18 KUowN'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='bwc__sc-1nbn7v6-14 khhVFa']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='bwc__sc-dh558f-14 fPrBPf'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='bwc__sc-dh558f-24 inXwab']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='bwc__sc-dh558f-23 cukyJu']")).sendKeys("seleniumauto@yopmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='bwc__sc-dh558f-37 hmbiuL']")).click();
		Thread.sleep(1000);
		
		String otp = YupMailForOTP.copyOTP();
		System.out.println(otp);
		
		int number = Integer.parseInt(otp);
		int reverse = 0;  
		
		while(number != 0)
		{  
			int remainder = number % 10;  
			reverse = reverse * 10 + remainder;  
			number = number/10;
		}
		   	 
		int temp = reverse;  //123456
		
		for(int i =0;i<6;i++)
		{
			int digit = temp % 10;
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@class='bwc__sc-rwpctr-1 jLBVFy']")).sendKeys(String.valueOf(digit));
			temp = temp /10;
		}

		
	//	String Actual_Result= "Hi, Guest";
		Thread.sleep(1000);
		String verify_user=driver.findElement(By.xpath("//span[contains(@class,'bwc__sc-1nbn7v6-12 cQWvYS')]")).getText();
		Thread.sleep(1000);
		System.out.println(verify_user);
		
		driver.close();
	}

}
