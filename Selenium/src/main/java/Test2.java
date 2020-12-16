import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Feri\\Downloads\\chromedriver_win32\\chromedriver.exe");  //Teszteléshez kivánt böngésző driver utvonalának megoldása

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8081/web_war/");

        Thread.sleep(1000);

        driver.findElement(By.id("list")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("7af318c9-4430-4ec4-ba4a-afd6b63bd4a6")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("manufacturer")).clear();
        driver.findElement(By.id("manufacturer")).sendKeys("Opel");
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("3000000");

        WebElement Date= driver.findElement(By.id("manufacturingDate"));
        Date.clear();
        Thread.sleep(1000);
        Date.sendKeys("2012-11-02");


        Select branch = new Select(driver.findElement(By.id("branch")));
        branch.selectByValue("EGER");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        Thread.sleep(1000);

        String bt=driver.getTitle();
        if (bt.equalsIgnoreCase("Autóink")){
            System.out.println("A módosítás sikerült");

            Select filter = new Select(driver.findElement(By.id("branch")));
            filter.selectByValue("EGER");
            Thread.sleep(1000);
            driver.findElement(By.id("filter")).click();

            Thread.sleep(1000);
        }
        else  {
            System.out.println("A módosítás nem sikerült");
        }
        Thread.sleep(1000);

        driver.close();
    }
}
