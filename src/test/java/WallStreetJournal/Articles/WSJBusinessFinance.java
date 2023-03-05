package WallStreetJournal.Articles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
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

		try {
		driver.get(prop.getProperty("WSJ_BUSINESSFINANCE"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(5000);

		String BF = driver.findElement(By.xpath("//main[@id='main']/div[1]/div[1]/div[1]/div[2]/div/h2/a"))
				.getAttribute("href");
		//System.out.println(BF);
		//Log.info("Test Executed By: "+machineName );
		//Log.info("Test Executed Date: " + currentDateTime);
		Log.info("Business & Finance Header Link: " + BF);
		//Log.info(BF);

		List<WebElement> allBusinessArticleTitles = driver
				.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
		int BFinance = allBusinessArticleTitles.size();
		System.out.println("Count of Articles Links is: " + BFinance);
		Log.info("Total BUSINESS & FINANCE NEWS articles link Count is: "+BFinance+" + 1");
		// Enhanced for loop
		for (WebElement option : allBusinessArticleTitles) {
			String BusinessArticles = option.getAttribute("href");
			//System.out.println("Href Bussiness & Finance Links: " + BusinessArticles);
			Log.info("Business & Finance Links: " + BusinessArticles);
			//Log.info(BusinessArticles);
			
		}
		
		}
		
		
		catch(Exception e2) {
			Log.error("No Business Finance Related News present for this present date");
		}
		try {
		List<WebElement> allBusinessArticleTitles = driver
				.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
		int BFin = allBusinessArticleTitles.size();
		Log.info("Downloaded Successfully " + BFin +" + 1 - Business & Finance URL's");
		Log.info(" ");
		}
		catch(Exception e22) {
			
		}
		FileInputStream fis = new FileInputStream("src\\main\\java\\library\\config");
        Properties prop = new Properties();
         
        prop.load(fis);
        String userfrm = prop.getProperty("WSJ_BUSINESSFINANCE");
        Log.info(" ");
		Log.info("Following are the downloaded URL's based on given InputFile");
		Log.info(" ");
        Log.info(userfrm);	
        Log.info(" ");
        String WSJATW = prop.getProperty("WSJ_USNEWS");
        Log.info(WSJATW);
        Log.info(" ");
        String LALALA = prop.getProperty("WSJ_LIFEARTS");
        Log.info(LALALA);
        Log.info(" ");
        String OPIOPI = prop.getProperty("WSJ_OPINION");
        Log.info(OPIOPI);
        Log.info(" ");
        String WNWNNW = prop.getProperty("WSJ_WORLDNEWS");
        Log.info(WNWNNW);
        Log.info(" ");
		
		driver.quit();
	}

}
