package ejercicio3.conPOyPFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductComparisonPage {
    public WebDriver driver;
    public String handleID;
    public String handleIdFrom;

    public ProductComparisonPage(WebDriver driver){
        this.driver = driver;
    }

    public void setMyHandleID(String handle){
        this.handleID = handle;
    }

    public void setMyHandleIDFrom(String handle){
        this.handleIdFrom = handle;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public ShoesPage close(){
        driver.findElement(By.cssSelector(".buttons-set > .button")).click();
        driver.switchTo().window(handleIdFrom);
        return PageFactory.initElements(driver, ShoesPage.class);
    }
}
