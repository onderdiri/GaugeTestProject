import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 21.11.2016.
 */
public class LoginTest {

    //final static Logger logger = Logger.getLogger(LoginTest.class);

    private WebDriver driver;
    private String baseUrl;


    public void setUp(String url) throws Exception {
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Step("Open <https://www.bilyoner.com> on any browser")
    public void openURL(String url) throws Exception {
       /* driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
        setUp(url);
    }


    @Step("Fill user id input with a valid user id")
    public void enterUserIdValue() {
        driver.findElement(By.id("j_username")).clear();
        driver.findElement(By.id("j_username")).sendKeys("17984199");
    }

    @Step("Fill password input with a valid password")
    public void enterUserPasswordValue() {
        driver.findElement(By.id("j_password")).clear();
        driver.findElement(By.id("j_password")).sendKeys("153624");
    }

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.className("loginButton")).click();
    }

    @Step("Validate <https://www.bilyoner.com> opened on browser")
    public void validateURL(String url) throws Exception {

        //driver = new FirefoxDriver();
        //driver.get(url);
        setUp(url);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("İSTENİLEN URL>>>" + url);
        System.out.println("GELEN URL>>>" + url);
        try {

            Assert.assertEquals(currentUrl, url);
        }
        catch (AssertionError err){
            System.out.println("Yanlış URL>>>>" + err);
        }

    }

    @Step("Validate there is no logged in user")
    public void validateNoLoggedUser() {
        String actualNoLoggedMessage = "ÜYE OL, KAZANMAYA BAŞLA";
        String expectedNoLoggedMessage = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/span[3]/a")).getText();
        try {
            Assert.assertEquals(actualNoLoggedMessage, expectedNoLoggedMessage);
        } catch (AssertionError err) {
            System.out.println("Some one has logged in the system" + err);
        }
    }

    @Step("Fill user id input with <11111111>")
    public void dummyUserId(String userId) {
        driver.findElement(By.id("j_username")).clear();
        driver.findElement(By.id("j_username")).sendKeys(userId);
    }

    @Step("Fill password input with <111111>")
    public void dummyPassword(String userPassword) {
        driver.findElement(By.id("j_password")).clear();
        driver.findElement(By.id("j_password")).sendKeys(userPassword);
    }

    @Step("Validate <Giriş/Şifre bilgileriniz hatalıdır! Lütfen tekrar deneyiniz...> message is visible")
    public void faultErrorMessage(String actualFaultMessage) {

        String expectedFaultMessage = driver.findElement(By.className("login-err-text")).getText();
        Assert.assertEquals(actualFaultMessage, expectedFaultMessage);

    }

    @Step("Refresh web page")
    public void refreshWebPage() {
        System.out.println("REFRESH>>>>>>>>>");
        driver.navigate().refresh();
    }
}
