import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass_Annotations {
    static WebDriver driver;
    static WebElement searchBox;
    static WebElement resultTextElement;
    String expectedWord;

    @Test
    public void test1() {
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        resultTextElement = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String resultText = resultTextElement.getText();
        expectedWord = "Nutella";
        Assert.assertTrue("no Nutella", resultText.contains(expectedWord));
        System.out.println(resultText);
    }

    @Test
    public void test2() {
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Java" + Keys.ENTER);
        resultTextElement = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String resultText = resultTextElement.getText();
        expectedWord = "Java";
        Assert.assertTrue("no Java", resultText.contains("Java"));
        System.out.println(resultText);
    }

    @Test
    public void test3() {
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.clear();
        searchBox.sendKeys("Ali" + Keys.ENTER);
        resultTextElement = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String resultText = resultTextElement.getText();
        expectedWord = "Ali";
        Assert.assertTrue("no Ali", resultText.contains("Ali"));
        System.out.println(resultText);
    }
    @BeforeClass
    public static void settings() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    }

    @AfterClass
    public static void closing() {
        driver.quit();
    }

}