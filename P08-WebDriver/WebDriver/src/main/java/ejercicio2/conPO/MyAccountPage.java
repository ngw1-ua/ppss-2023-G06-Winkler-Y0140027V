package ejercicio2.conPO;

import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;

    MyAccountPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getTitle(){
        return this.driver.getTitle();
    }
}
