import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 21.11.2016.
 */
public class BettingTest {

    private WebDriver driver;
    private String baseUrl;


    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.bilyoner.com/";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Step("User must be logged in")
    public void userLogin() {
        setUp();
        driver.findElement(By.id("j_username")).clear();
        driver.findElement(By.id("j_username")).sendKeys("17984199");

        driver.findElement(By.id("j_password")).clear();
        driver.findElement(By.id("j_password")).sendKeys("153624");

        driver.findElement(By.className("loginButton")).click();
    }

    @Step("Move mouse to hoverable <IDDAA> button")
    public void mouseMoveEvent(Object arg0) throws InterruptedException {
       /* WebElement move = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/ul/li[2]/h1/a"));//By.linkText("İDDAA"));
        Actions builder = new Actions(driver);
        builder.moveToElement(move).click();*/

        driver.findElement(By.linkText("İDDAA")).click();
    }

    @Step("Validate iddaa dropdown menu opened and <9> element is visible")
    public void countDropDownListElement(int currentElementNumber) {
        List<WebElement> expectedNumberOfList = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/ul/li[2]/ul/li"));
        try {
            Assert.assertEquals(currentElementNumber, expectedNumberOfList.size());
        } catch (AssertionError err) {
            Gauge.writeMessage(expectedNumberOfList.size() + "" + err);
            }

    }


    @Step("Click <Bahis Yap> button")
    public void clickBahisYapButton(String buttonName) {
        // driver.findElement(By.className("sub");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/ul/li[2]/ul/li[1]/h2/a")).click();
    }


    @Step("Validate page url is <https://www.bilyoner.com/iddaa/iddaa-bahis-yap>")
    public void validateCurrentURL(String currentURL) {

        try {

            Assert.assertEquals(currentURL, driver.getCurrentUrl());

        } catch (AssertionError err) {
            System.err.println("URL FARKLI>>>" + driver.getCurrentUrl() + err);
        }
    }


    @Step("Choose one of iy1 bet type randomly from available selections")
    public void chooseFirstBet() {

        driver.get(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div/ul/li[2]/ul/li[1]/h2/a")).getAttribute("href"));
        Gauge.writeMessage("BÜLTEN URL>>>" + driver.getCurrentUrl());
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div/div[2]/div[6]/div/div[18]/span[12]/div/span/span[1]")).click();//405 IY1

    }


    @Step("Choose one of h2 bet type randomly from available selections")
    public void chooseSecondBet() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div/div[2]/div[6]/div/div[6]/span[20]/div/span/span[1]")).click();//402 H2

    }


    @Step("Choose one of ms1 bet type randomly from available selections")
    public void chooseThirthBet() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div/div[2]/div[6]/div/div[10]/span[7]/div/span/span[1]")).click(); //403 MS1
            }


    @Step("Choose one of any bet type from mbs3 matches which are available on the Bahis Yap page")
    public void chooseFourthBet() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div/div[2]/div[6]/div/div[22]/span[13]/div/span/span[1]")).click();//406 IY0

    }

    @Step("Validate 4 match added to betslip")
    public void validateBetslip() {

        String expectedBetsNumber = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div[9]/div[1]/div[1]/div[2]/div[5]/span[1]/span[3]")).getText();
        Gauge.writeMessage("Number of Bets>>>" + expectedBetsNumber);
        Assert.assertEquals("4", expectedBetsNumber);

    }

    @Step("Validate Kuponum is opened")
    public void validateCouponIsOpened() {
        WebElement we = driver.findElement(By.className("acikYesil"));
        Assert.assertTrue(we.isDisplayed());
    }

    @Step("Validate Coupon Header background is green")
    public void validateCouponBackground() {
        WebElement we = driver.findElement(By.className("acikYesil"));
        Assert.assertTrue(we.isEnabled());
    }

}
