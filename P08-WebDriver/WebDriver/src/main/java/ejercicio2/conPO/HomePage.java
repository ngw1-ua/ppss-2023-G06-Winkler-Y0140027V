package ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;
    public WebElement Account;
    public WebElement LoginBtn;

    HomePage(WebDriver driver){
        this.driver = driver;
        driver.get("http://demo-store.seleniumacademy.com/");
        this.Account = driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[2]/div/a"));
    }

    public void Account(){
        this.Account.click();
    }

    public CustomerLoginPage GetLoginPage()
    {
        this.Account();
        this.LoginBtn = driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[5]/div/ul/li[6]/a"));
        LoginBtn.click();
        return new CustomerLoginPage(this.driver);
    }

    public String getTitle(){
        return this.driver.getTitle();
    }

}
