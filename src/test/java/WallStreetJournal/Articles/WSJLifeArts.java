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

public class WSJLifeArts extends base {

	@Test
	public static void laa() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");

		initialization();

		try {
			driver.get(prop.getProperty("WSJ_LIFEARTS"));

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			Thread.sleep(5000);

			String ArtsLink = driver.findElement(By.xpath("//main[@id='main']/div[1]/div[1]/div[1]/div[2]/div/h2/a"))
					.getAttribute("href");
			//System.out.println(ArtsLink);
			//Log.info("Test Executed By: "+machineName );
			//Log.info("Test Executed Date: " + currentDateTime);
			Log.info("Life & Arts Header Link: " + ArtsLink);
			//Log.info(ArtsLink);

			List<WebElement> ArtsLinkTitles = driver
					.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));

			int lifeArts = ArtsLinkTitles.size();
			System.out.println("Count of Articles Links is: " + lifeArts);
			 Log.info("Total LIFE & ARTS NEWS articles link Count: "+lifeArts+" + 1");
			// Enhanced for loop
			for (WebElement option : ArtsLinkTitles) {
				String LifeArtsLinks = option.getAttribute("href");
				//System.out.println("Href value of link: " + LifeArtsLinks);
				Log.info("Life & Arts Links: " + LifeArtsLinks);
				//Log.info(LifeArtsLinks);

			}
		} catch (Exception e3) {
			Log.error("No Life Arts Related News present for this present date");
		}
		
		try {
			List<WebElement> ArtsTitles = driver
					.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
			int WSLA = ArtsTitles.size();
			Log.info("Downloaded Successfully " + WSLA +" + 1 - LIFE & ARTS NEWS URL's");
			Log.info(" ");
			}
			catch(Exception e22) {
				
			}
		
		driver.quit();

	}

}
