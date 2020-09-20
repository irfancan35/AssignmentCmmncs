package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class NewsDetailPage extends BasePage{
    private WebDriver driver;

    public NewsDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isBrowserAndNewsTitleEqual() {
        //Click 3rd article
        List<WebElement> images = driver.findElements(By.cssSelector(".post-block__footer .post-block__media"));
        images.get(2).click();
        //Get Browser Title and extract substring " | TechCrunch"
        String browserTitle = driver.getTitle();
        browserTitle = browserTitle.replace(" | TechCrunch","");
        //Find News Title
        String newsTitle = driver.findElement(By.cssSelector(".article__title")).getText();
        System.out.println(browserTitle);
        System.out.println(newsTitle);
        return browserTitle.equals(newsTitle);
    }

    public boolean areLinksInNewsContent() {
        //Click 6th article
        List<WebElement> images = driver.findElements(By.cssSelector(".post-block__footer .post-block__media"));
        images.get(5).click();
        //Find and print links
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@class='article-content']/p/*[@href]"));
        for (WebElement webElement : listOfLinks) {
            String href = webElement.getAttribute("href");
            System.out.println(href);
        }
        return true;
    }
}
