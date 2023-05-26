package ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage {
    WebDriver driver;
    WebElement email;
    WebElement pass;
    WebElement loginBtn;
    CustomerLoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.email = driver.findElement(By.id("email"));
        this.pass = driver.findElement(By.id("pass"));
        this.loginBtn = driver.findElement(By.id("send2"));
    }

    public MyAccountPage LoginOK(String email, String pass)
    {
        this.email.sendKeys(email);
        this.pass.sendKeys(pass);
        this.loginBtn.click();
        return new MyAccountPage(this.driver);
    }

    public String LoginFail(String email, String pass){
        this.email.sendKeys(email);
        this.pass.sendKeys(pass);
        this.loginBtn.click();
        String error = "";
        try
        {
            error = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/ul/li/ul/li/span")).getText();

            if(error.equals(""))
                error = driver.findElement(By.id("advice-required-entry-pass")).getText();
        }
        catch (Exception e){}
        return error;
    }

    public String getTitle(){
        return this.driver.getTitle();
    }
}
