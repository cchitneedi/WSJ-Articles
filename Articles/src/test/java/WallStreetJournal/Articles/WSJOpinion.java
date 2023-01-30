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


public class WSJOpinion extends base {
	
	@Test
	public static void oa() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");
		initialization();

		driver.get(prop.getProperty("WSJ_OPINION"));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Thread.sleep(5000);

		String opinionHeader = driver.findElement(By.xpath("//main[@id='main']/div[1]/div[1]/div[1]/div[2]/div/h2/a"))
				.getAttribute("href");
		System.out.println(opinionHeader);
		//Log.info("Opinion Article Header Link: " + opinionHeader);
		Log.info(opinionHeader);

		List<WebElement> OpinionArticleLinks = driver
				.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));

		int OpinionLinks = OpinionArticleLinks.size();
		System.out.println("Count of Articles Links is: " + OpinionLinks);
		//Log.info("Total OPINION articles link Count: "+OpinionLinks);
		// Enhanced for loop
		for (WebElement option : OpinionArticleLinks) {
			String OpinionWSJLinks = option.getAttribute("href");
			System.out.println("Href value of link: " + OpinionWSJLinks);
			//Log.info("Opinion Article Links: " + OpinionWSJLinks);
			Log.info(OpinionWSJLinks);

		}
		driver.quit();
	}

}
