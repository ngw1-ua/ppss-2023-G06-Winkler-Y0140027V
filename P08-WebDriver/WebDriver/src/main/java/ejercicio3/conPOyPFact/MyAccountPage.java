package ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    WebDriver driver;

    MyAccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTitle(){
        return this.driver.getTitle();
    }

    public ShoesPage getShoesPage(){
        Actions builder = new Actions(driver); builder.moveToElement(driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[3]/nav/ol/li[3]/a")));
        builder.perform();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Shoes"))));
        driver.findElement(By.linkText("Shoes")).click();
        return new ShoesPage(this.driver);
    }
}
