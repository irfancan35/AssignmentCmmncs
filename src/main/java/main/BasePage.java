package main;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private String url = "https://techcrunch.com/";
    //techcrunch.com will be loaded in browser

    public BasePage(WebDriver driver){
        this.driver = driver;
        driver.get(url);
        driver.manage().window().maximize();
    }
}
