package ejercicio1.sinPageObject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreateAccount {
    @Test
    public void createAccount(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://demo-store.seleniumacademy.com/");

        WebElement account = driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[2]/div/a"));
        account.click();

        driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[5]/div/ul/li[6]/a")).click();

        assertTrue(driver.getTitle().contains("Customer Login"));

        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/form/div/div[1]/div[2]/a")).click();

        WebElement firstname = driver.findElement(By.id("firstname"));
        firstname.sendKeys("ngwinkler-webdriver");

        driver.findElement(By.id("lastname")).sendKeys("ppss");

        driver.findElement(By.id("email_address")).sendKeys("ngwinkler-ppss@ppss.es");

        driver.findElement(By.id("password")).sendKeys("#Ppss23");

        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/form/div[2]/button")).click();

        String confirmation = driver.findElement(By.id("advice-required-entry-confirmation")).getText();

        assertEquals("This is a required field.", confirmation);

        driver.findElement(By.id("confirmation")).sendKeys("#Ppss23");

        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/form/div[2]/button")).click();

        assertTrue(driver.getTitle().contains("My Account"));
    }
}
