package smart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmartBuy {
	
	public WebDriver driver;
	public int numberOfTry  =  1 ;
	SoftAssert softassertprocess = new SoftAssert();
	@BeforeTest()
	
	public void this_is_before_test() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://smartbuy-me.com/");
	    driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
	
	}
	
	@Test()
	
	public void Test_Adding_item_SAMSUNG_50_inch(){
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		for(int i =0 ; i <numberOfTry;i++) {
		driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]/button")).click();
	    driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
	//	System.out.println("hi");
	}
	
		

}
	


	@Test()

     public void we_need_to_check_the_correct_price() {
	
	String the_single_item_price = driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div/div/span[3]")).getText();
		System.out.println(the_single_item_price);
		
		String []the_Update_single_item_price  = the_single_item_price.split("JOD");
		
		String The_Final_Single_item_price = the_Update_single_item_price[0].trim();
		
		System.out.println("=================================");
		
		System.out.println(The_Final_Single_item_price);
		
		System.out.println("=================================");
		
		
		
		String Updated =The_Final_Single_item_price.replace(",", ".");
		
		
      Double final_price =Double.parseDouble(Updated);
      
      
      
      System.out.println(final_price);
      System.out.println(final_price*numberOfTry);
      String AcctualWebsite= driver.getTitle();
      softassertprocess.assertEquals(AcctualWebsite, "Ahmed");
      softassertprocess.assertEquals(final_price*numberOfTry, 4.347);
      
      
      softassertprocess.assertAll();
      
	}	
	}









