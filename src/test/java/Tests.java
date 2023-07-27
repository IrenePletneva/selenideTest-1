import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Tests extends CodeJunit {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void findSoftAssertionsSelenide (){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").$(byText("Soft assertions"))
                .shouldHave(attribute("href","https://github.com/selenide/selenide/wiki/SoftAssertions"));
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").setValue("SoftAssertion");
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertion"));
        $(".markdown-body").$(byText("Soft assertions")).click();
//        sleep(5000);
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:"))
                .sibling(0).shouldHave(text(codeJunit));
    }


}
