package com.usermanagement.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractUiTest {

    protected WebDriver driver = new ChromeDriver();

    protected void openPage(String url) {
        System.setProperty("webdriver.chrome.driver",
                "/usr/local/bin/chromedriver");
        driver.get(url);
    }
}

