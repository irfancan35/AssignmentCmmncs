package test;

import main.HomePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertEquals;

public class HomePageTest extends BaseTest{
    private final static int NUMBER_OF_EXPECTED_ARTICLES = 20;
    private final static int NUMBER_OF_EXPECTED_AUTHORS = 20;
    private final static int NUMBER_OF_EXPECTED_IMAGES = 20;
    private static HomePage homePage;
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void authorNameShouldNotBeEmpty() {
        boolean isEmpty = homePage.isAuthorNameEmpty();
        assertEquals(true, isEmpty);
    }

    @Test
    public void imageFieldShouldNotBeEmpty() {
        boolean isEmpty = homePage.isImageFieldEmpty();
        assertEquals(true, isEmpty);
    }

    @Test
    public void numberOfImagesAndArticlesShouldBeEqual() {
        boolean isEqual = homePage.isImageAndArticleNumberEqual();
        assertEquals(true, isEqual);
    }
    @Test
    public void numberOfAuthorsAndArticlesShouldBeEqual() {
        boolean isEqual = homePage.isAuthorAndArticleNumberEqual();
        assertEquals(true, isEqual);
    }

    @Test
    public void numberOfLatestNewsShouldBe20() {
        int numberOfArticles = homePage.getArticleSize();
        assertEquals(NUMBER_OF_EXPECTED_ARTICLES, numberOfArticles);
    }

    @Test
    public void numberOfAuthorsShouldBe20() {
        int numberOfAuthors = homePage.getAuthorSize();
        assertEquals(NUMBER_OF_EXPECTED_AUTHORS, numberOfAuthors);
    }

    @Test
    public void numberOfImagesShouldBe20() {
        int numberOfImages = homePage.getImageSize();
        assertEquals(NUMBER_OF_EXPECTED_IMAGES, numberOfImages);
    }
}
