import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions1 {

    //  https://www.bestbuy.com/ adresine gidip farkli test method’lari olusturarak asagidaki testleri yapin
    //  Sayfa URL’inin https://www.bestbuy.com/ a esit oldugunu test edin
    //  titleTest => Sayfa başlığının “Rest” içermediğini (contains) test edin
    //  logoTest => BestBuy logosunun görüntülendigini test edin
    //  Francais LinkTest => Fransizca Linkin görüntülendiğini test edin
    static WebDriver driver;

    @Test
    public void urlTest() {
        String expUrl = "https://www.bestbuy.com/";
        String actUrl = driver.getCurrentUrl();
        Assert.assertEquals(expUrl, actUrl);
    }

    @Test
    public void ExpWordTest() {
        String expWord = "Rest";
        String actTitle = driver.getTitle();
        Assert.assertFalse(actTitle.contains(expWord));
    }

    @Test
    public void logoTest() {
        WebElement bestbuyLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(bestbuyLogo.isDisplayed());
    }

    @Test
    public void FrenchOptionTest() {
        WebElement FrenchLogo = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
        Assert.assertTrue(FrenchLogo.isDisplayed());
    }

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}