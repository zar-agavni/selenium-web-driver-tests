package com.demo.inputforms;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputFormSubmitTest extends TestCase {
    private WebDriver driver;

    @Override
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zarag\\Downloads\\chromedriver_96\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Override
    public void tearDown() throws Exception {
        //driver.quit();
    }
    public void testNameValidationValid(){
        driver.get("http://demo.seleniumeasy.com/input-form-demo.html");
        driver.findElement(By.name("first_name")).sendKeys("Ag");
        String validationState = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/small[1]")).getAttribute("data-bv-result");
        assertEquals("VALID",validationState);
    }
    public void testNameValidationInvalid(){
        driver.get("http://demo.seleniumeasy.com/input-form-demo.html");
        driver.findElement(By.name("first_name")).sendKeys("A");
        WebElement validationEl = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/small[1]"));
        String validationState = validationEl.getAttribute("data-bv-result");
        assertEquals("INVALID",validationState);
        String validationMessage = validationEl.getText();
        assertEquals("Please enter more than 2 characters", validationMessage);
    }
}
