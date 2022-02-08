package com.demo;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTestCase extends TestCase {
    protected WebDriver driver;

    @Override
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zarag\\Downloads\\chromedriver_96\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
    }
}
