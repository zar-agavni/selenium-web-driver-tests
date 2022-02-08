package com.demo.inputforms;

import com.demo.ChromeTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownListTest extends ChromeTestCase {

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
