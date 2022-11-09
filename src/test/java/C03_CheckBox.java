import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C03_CheckBox {

    static WebElement checkBox1;
    static WebElement checkBox2;
    static  WebDriver driver;
    //  https://the-internet.herokuapp.com/checkboxes sayfasına gidin
    //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //  c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //  d. Checkbox2 seçili değilse onay kutusunu tıklayın

    @Test
    public void test1() {
        checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        if (!checkBox1.isSelected()) {checkBox1.click();}
    }

    @Test
    public void test2() {
        checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!checkBox2.isSelected()) {checkBox2.click();}
    }

    @BeforeClass
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterClass
    public static void closing() {
        // driver.quit();
    }
}
