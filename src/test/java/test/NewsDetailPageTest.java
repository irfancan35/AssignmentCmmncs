package test;

import main.NewsDetailPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class NewsDetailPageTest extends BaseTest{
    private static NewsDetailPage newsDetailPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        newsDetailPage = new NewsDetailPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void browserAndNewsTitleShouldBeSame() {
        boolean isEqual = newsDetailPage.isBrowserAndNewsTitleEqual();
        assertEquals(true, isEqual);
    }

    @Test
    public void verifyLinksWithinNewsContent() {
        boolean result = newsDetailPage.areLinksInNewsContent();
        assertEquals(true, result);
    }
}
