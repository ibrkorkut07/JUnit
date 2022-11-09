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

public class C06_Assertions2 {

    //  https://www.youtube.com adresine gidin
    //  Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //  titleTest => Sayfa başlığının "YouTube" oldugunu test edin
    //  imageTest => YouTube resminin görüntülendiğini test edin isDisplayed()
    //  SearchBox 'in erisilebilir oldugunu test edin (isEnabled()
    //  wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin

    static WebDriver driver;
    @Test
    public void titleTest() throws InterruptedException {
        Thread.sleep(5000);
        String expTitle = "YouTube";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle, actTitle);
    }

    @Test
    public void imageTest() {
        WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void SearchBox() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        String expTitle = "youtube";
        String actTitle = driver.getTitle();
        Assert.assertFalse(actTitle.equals(expTitle));
    }

    @BeforeClass
    public static void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[12]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[7]")).click();
        }

    @AfterClass
    public static void tearDown() {

    }
}
