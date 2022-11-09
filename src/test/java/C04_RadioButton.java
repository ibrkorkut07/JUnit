import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class C04_RadioButton {

    //  https://www.facebook.com adresine gidin
    //  Cookies’i kabul edin
    //  “Create an Account” button’una basin
    //  “radio buttons” elementlerini locate edin
    //  Secili degilse cinsiyet butonundan size uygun olani secin

    static WebDriver driver;
    static WebElement femaleRadioButton;
    static WebElement maleRadioButton;
    static WebElement ortayaKarisikRadioButton;

    @Test
    public void test1() {
          maleRadioButton.click();
                 }


    @BeforeClass
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        WebElement cookiesButton = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        cookiesButton.click();
        WebElement creAccountButton = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        creAccountButton.click();
        femaleRadioButton = driver.findElement(By.xpath("//input[@value='1']"));
        maleRadioButton = driver.findElement(By.xpath("//input[@value='2']"));
        ortayaKarisikRadioButton = driver.findElement(By.xpath("//input[@value='-1']"));
    }

    @AfterClass
    public static void closing() {
        // driver.quit();
    }
}
