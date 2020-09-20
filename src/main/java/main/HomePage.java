package main;

import org.openqa.selenium.*;
import java.util.List;

public class HomePage extends BasePage{
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public int getArticleSize() {
        try {
            List<WebElement> listOfArticles = driver.findElements(By.cssSelector(".post-block--unread"));
            return listOfArticles.size();
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such article");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return 0;
        //Number of articles is stored
    }

    public int getAuthorSize() {
        try {
            List<WebElement> listOfAuthors = driver.findElements(By.cssSelector(".post-block__header .river-byline__authors"));
            return listOfAuthors.size();
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such author");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return 0;
        //Number of authors is stored
    }

    public int getImageSize() {
        try {
            List<WebElement> listOfImages = driver.findElements(By.cssSelector(".post-block__footer .post-block__media"));
            return listOfImages.size();
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such image");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return 0;
        //Number of images is stored
    }

    public boolean isAuthorAndArticleNumberEqual() {
        int articleNumbers = getArticleSize();
        int authorNumbers = getAuthorSize();
        if (articleNumbers == authorNumbers) {
            System.out.println("Article and author numbers are equal");
            return true;
        } else {
            System.out.println("Article and author numbers are not equal");
            return false;
        }
        //Compares if author and article numbers are equal
    }

    public boolean isImageAndArticleNumberEqual() {
        int articleNumbers = getArticleSize();
        int imageNumbers = getImageSize();
        if (articleNumbers == imageNumbers) {
            System.out.println("Article and image numbers are equal");
            return true;
        } else {
            System.out.println("Article and image numbers are not equal");
            return false;
        }
        //Compares if image and article numbers are equal
    }

    public boolean isAuthorNameEmpty() {
        try {
            List<WebElement> listOfAuthors = driver.findElements(By.className("river-byline__authors"));
            for (WebElement webElement : listOfAuthors) {
                String authorName = webElement.getText();
                if (authorName.equals("")) {
                    return false;
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such author");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You are trying to reach non exist author element");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return true;
        //Checks if author name is empty
    }

    public boolean isImageFieldEmpty() {
        try {
            List<WebElement> listOfImages = driver.findElements(By.cssSelector(".post-block__footer .post-block__media"));

            for (WebElement webElement : listOfImages) {
                String imageMedia = webElement.getAttribute("href");
                if (imageMedia.equals("")) {
                    return false;
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Page is not loaded");
        } catch (NoSuchElementException e) {
            System.out.println("No such image");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You are trying to reach non exist image element");
        } catch (Exception e) {
            System.out.println("Exception is thrown");
        }
        return true;
    }
}
