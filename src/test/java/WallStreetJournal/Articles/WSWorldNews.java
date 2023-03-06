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

public class WSWorldNews extends base {

	@Test
	public static void wna() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");

		initialization();

		try {
			driver.get(prop.getProperty("WSJ_WORLDNEWS"));

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			Thread.sleep(5000);

			String WorldHeaderLink = driver
					.findElement(By.xpath("//main[@id='main']/div[1]/div[1]/div[1]/div[2]/div/h2/a"))
					.getAttribute("href");
			//System.out.println(WorldHeaderLink);
			Log.info("World News Header Link: " + WorldHeaderLink);
			//Log.info(WorldHeaderLink);

			List<WebElement> WorldNewsArticles = driver
					.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
			int CountWorldNews = WorldNewsArticles.size();
			System.out.println("Count of Articles Links is: " + CountWorldNews);
			Log.info("Total WORLD NEWS articles link Count: "+CountWorldNews+" + 1");
			// Enhanced for loop
			for (WebElement option : WorldNewsArticles) {
				String allWorldArticleLinks = option.getAttribute("href");
				//System.out.println("Href value of link: " + allWorldArticleLinks);
				Log.info("Total World News Links: " + allWorldArticleLinks);
				//Log.info(allWorldArticleLinks);

			}
		} catch (Exception e5) {
			Log.error("No World News Related News present for this present date");
		}
		
		try {
			List<WebElement> WorldArticles = driver
					.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
			int WSWNA = WorldArticles.size();
			Log.info("Downloaded Successfully " + WSWNA +" + 1 - WORLD NEWS URL's");
			Log.info(" ");
			}
			catch(Exception e22) {
				
			}
		
		driver.quit();
	}

}
