import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class otomasyon {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.a101.com.tr/");

        WebElement allow_permission = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        allow_permission.click();
        WaitForSec(3);

        WebElement giyim_aksesuar = driver.findElement(By.xpath("//a[@title='GİYİM & AKSESUAR']"));
        String link_giyim_aksesuar =   giyim_aksesuar.getAttribute("href");
        driver.get(link_giyim_aksesuar);
        WaitForSec(3);

        WebElement kadin_icgiyim = driver.findElement(By.xpath("//a[@title='Kadın İç Giyim']"));
        String link_kadin_icgiyim =   kadin_icgiyim.getAttribute("href");
        driver.get(link_kadin_icgiyim);
        WaitForSec(3);

        WebElement diz_alti_corap = driver.findElement(By.xpath("//a[@title='Dizaltı Çorap']"));
        String link_diz_alti_corap =   diz_alti_corap.getAttribute("href");
        driver.get(link_diz_alti_corap);
        WaitForSec(3);

        WebElement black_filter = driver.findElement(By.id("attributes_integration_colourSİYAH"));
        black_filter.click();
        WaitForSec(3);

        WebElement product = driver.findElement(By.xpath("//ul[@class='product-list-general']//a[@class='name-price']"));
        String link_product =   product.getAttribute("href");
        driver.get(link_product);
        WaitForSec(4);

        WebElement add_to_basket= driver.findElement(By.className("add-to-basket"));
        add_to_basket.click();
        WaitForSec(5);

        WebElement show_basket= driver.findElement(By.xpath("//a[@title='Sepeti Görüntüle']"));
        String link_show_basket=   show_basket.getAttribute("href");
        driver.get(link_show_basket);
        WaitForSec(3);

        WebElement confirm_basket = driver.findElement(By.className("js-checkout-button"));
        String link_confirm_basket =   confirm_basket.getAttribute("href");
        driver.get(link_confirm_basket);
        WaitForSec(3);

        WebElement continue_shopping = driver.findElement(By.xpath("//a[@title='ÜYE OLMADAN DEVAM ET']"));
        continue_shopping.click();
        WaitForSec(3);

        WebElement e_mail= driver.findElement(By.xpath("//input[@name='user_email']"));
        e_mail.sendKeys("testoromasyon3215@hotmail.com");
        WaitForSec(3);

        WebElement continue_order = driver.findElement(By.xpath("//form[@class='js-proceed-to-checkout-form form--white guest-form']//button"));
        continue_order.click();
        WaitForSec(3);

        WebElement add_new_address = driver.findElement(By.xpath("//li[@class='half']//a[@class='new-address js-new-address']"));
        add_new_address.click();
        WaitForSec(3);

        WebElement title =  driver.findElement(By.name("title"));
        title.sendKeys("İş Adresim");

        WebElement first_name= driver.findElement(By.name("first_name"));
        first_name.sendKeys("Şehnaz");

        WebElement last_name= driver.findElement(By.name("last_name"));
        last_name.sendKeys("Kaya");

        WebElement phone_number= driver.findElement(By.name("phone_number"));
        phone_number.sendKeys("0 (555) 321-1111");

        Select city=  new Select(driver.findElement(By.name("city")));
        city.selectByVisibleText("AYDIN");
        WaitForSec(3);

        WebDriverWait XWait = new WebDriverWait(driver, 60);
        XWait.until(ExpectedConditions.elementToBeClickable(By.name("township"))).click();
        List<WebElement> townshipList = driver.findElements(By.xpath("//select[@name='township']//option"));
        WebElement township = findElementByText(townshipList,"DİDİM");
        township.click();
        WaitForSec(5);

        XWait.until(ExpectedConditions.elementToBeClickable(By.name("district"))).click();
        List<WebElement> districtList = driver.findElements(By.xpath("//select[@name='district']//option"));
        WebElement district = findElementByText(districtList,"BALAT MAH");
        district.click();
        WebElement address= driver.findElement(By.className("js-address-textarea"));

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        address.sendKeys("when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,"+ randomString);
        WaitForSec(3);

        XWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']")));
        WebElement save_address = driver.findElement(By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']"));
        save_address.click();
        WaitForSec(3);

        XWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='js-shipping-list']//div[@class='check']")));
        WebElement choose_shipping =  driver.findElement(By.xpath("//ul[@class='js-shipping-list']//div[@class='check']"));
        choose_shipping.click();

        WebElement save_and_continue = driver.findElement(By.className("js-proceed-button"));
        save_and_continue.click();
        WaitForSec(3);

    }








    public static WebElement findElementByText(List<WebElement> webElements, String text) {
        return webElements
                .stream()
                .filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + text));
    }


    public static  void WaitForSec(int sec)
    {
        try
        {
            TimeUnit.SECONDS.sleep(sec);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
