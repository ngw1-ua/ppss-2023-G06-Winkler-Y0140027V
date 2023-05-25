package ejercicio1.sinPageObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class TestLogin {
    WebDriver driver;
    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("http://demo-store.seleniumacademy.com/");
    }
    @Test
    public void loginOK(){
        assertTrue(driver.getTitle().contains("Madison Island"));

        WebElement account = driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[2]/div/a"));
        account.click();

        driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[5]/div/ul/li[6]/a")).click();

        assertTrue(driver.getTitle().contains("Customer Login"));

        driver.findElement(By.id("email")).sendKeys("ngwinkler-ppss@ppss.es");

        driver.findElement(By.id("send2")).click();

        String confirmation = driver.findElement(By.id("advice-required-entry-pass")).getText();

        assertEquals("This is a required field.", confirmation);

        driver.findElement(By.id("pass")).sendKeys("#Ppss23");

        driver.findElement(By.id("send2")).click();

        assertTrue(driver.getTitle().contains("My Account"));
    }

    public void loginFailed(){

    }
}
