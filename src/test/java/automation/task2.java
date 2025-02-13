package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.task.LoginWeb;;;

public class task2 {
    WebDriver driver;

    @BeforeClass
    public void setUpWeb() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kolabora.app/login");
        driver.manage().window().maximize();

    }

    @Test
    public void Login() throws InterruptedException {
        LoginWeb loginWeb = new LoginWeb(driver);
        loginWeb.login("rikodwijaya3@gmail.com", "rikopanda");
        Thread.sleep(2000);
        driver.quit();
    }
}
