import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Feri\\Downloads\\chromedriver_win32\\chromedriver.exe");  //Teszteléshez kivánt böngésző driver utvonalának megoldása

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8081/web_war/");
        driver.manage().window().maximize();

        driver.findElement(By.id("add")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("manufacturer")).sendKeys("Opel");
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("3000000");
        Thread.sleep(1000);

        WebElement Date= driver.findElement(By.id("manufacturingDate"));
        Date.clear();
        Date.sendKeys("2012-11-02");

        Thread.sleep(1000);

        Select branch = new Select(driver.findElement(By.id("branch")));
        branch.selectByValue("BUDAPEST");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        Thread.sleep(1000);

        String bt=driver.getTitle();
        if (bt.equalsIgnoreCase("Adatok")){
            System.out.println("A hozzáadás sikerült");
            driver.findElement(By.id("list")).click();

            Select filter = new Select(driver.findElement(By.id("branch")));
            filter.selectByValue("BUDAPEST");
            Thread.sleep(1000);
            driver.findElement(By.id("filter")).click();

            Thread.sleep(1000);
        }
        else  {
            System.out.println("A hozzáadás nem sikerült");
        }
        Thread.sleep(1000);


        driver.close();

    }
}
