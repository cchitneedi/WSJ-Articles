package WallStreetJournal.Articles;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import resources.base;
import utility.Log;

public class WSJBusinessFinance extends base{

	@Test
	public static void bfa() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");
		initialization();

		driver.get(prop.getProperty("WSJ_BUSINESSFINANCE"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(5000);

		String BF = driver.findElement(By.xpath("//main[@id='main']/div[1]/div[1]/div[1]/div[2]/div/h2/a"))
				.getAttribute("href");
		System.out.println(BF);
		//Log.info("Test Executed By: "+machineName );
		//Log.info("Test Executed Date: " + currentDateTime);
		//Log.info("Business & Finance Header Link: " + BF);
		Log.info(BF);

		List<WebElement> allBusinessArticleTitles = driver
				.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));

		int BFinance = allBusinessArticleTitles.size();
		System.out.println("Count of Articles Links is: " + BFinance);
		//Log.info("Total BUSINESS & FINANCE NEWS articles link Count: "+BFinance);
		// Enhanced for loop
		for (WebElement option : allBusinessArticleTitles) {
			String BusinessArticles = option.getAttribute("href");
			System.out.println("Href Bussiness & Finance Links: " + BusinessArticles);
			//Log.info("Business & Finance Links: " + BusinessArticles);
			Log.info(BusinessArticles);

		}
		driver.quit();
	}

}
