package com.demo.inputforms;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownListTest extends TestCase {
    private WebDriver driver;

    @Override
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zarag\\Downloads\\chromedriver_96\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
    }
    public void testSelectList(){
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.findElement(By.cssSelector("#select-demo > option:nth-child(7)")).click();
        String result = driver.findElement(By.className("selected-value")).getText();
        assertEquals("Day selected :- Friday", result);
    }
    public void testSelectListWithSelect(){
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Select weekDays = new Select(driver.findElement(By.id("select-demo")));
        weekDays.selectByValue("Sunday");
        String result = driver.findElement(By.className("selected-value")).getText();
        assertEquals("Day selected :- Sunday", result);
    }
}
