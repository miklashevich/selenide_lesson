import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ScreenShooter.class}) // делаем скриншоты без использования Allure
public class LoginTest {

    @BeforeTest
    public void setupTest() {
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // конфигурация добавления Allure

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://aqa04onl05.testrail.io/";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = true;
        Configuration.headless = false;
        ScreenShooter.captureSuccessfulTests = true;
    }

    @Test
    public void userCanLogin() {


        open("/");

        $("#name").setValue("atrostyanko+0401@gmail.com");
        $(By.id("password")).setValue("QqtRK9elseEfAk6ilYcJ");
        $(byText("Log In")).submit();

 /*       $(byText("Log In")).click();
        $(byText("Log In")).doubleClick();
        $(byText("Log In")).contextClick();
        $(byText("Log In")).hover();
        $(byText("Log In")).pressEnter();
        $(byText("Log In")).pressEscape();
      $(byText("Log In")).pressTab();
*/
        $(".page_title")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("All Projects"));

      //  $$(".flex-project-row").shouldHave(CollectionCondition.size(225));

        open("/index.php?/admin/projects/overview");
        $$(".hoverSensitive").shouldHave(CollectionCondition.size(232))
                .find(Condition.text("A_Mik9"))
                .find(By.tagName("a")).click();

        System.out.println($("#name").getValue());

        $("[name='suite_mode']").selectRadio("3");
        $("#show_announcement").setSelected(false);
        $("#name").append(" UPDATE");

     /*   $("#name").getValue();
        $("#name").attr("value");
        $("#name").text();
        $("#name").innerText();
        $("#name").innerHtml();
        $("#name").getSelectedOption();
        $("#name").getSelectedText();
        $("#name").getSelectedValue();
        $("#name").isDisplayed();
        $("#name").isImage();
        $("#name").isEnabled();
        $("#name").exists();

*/
  // Состояния
        /*
        $("#name").shouldBe(Condition.visible);
        $("#name").shouldBe(Condition.hidden);
        $("#name").shouldBe(Condition.enabled);
        $("#name").shouldBe(Condition.appear);
        $("#name").shouldBe(empty);
        $("#name").shouldBe(focused);

        $("#name").shouldHave(name(""));
        $("#name").shouldHave(value(""));
        $("#name").shouldHave(type("checkbox"));
        $("#name").shouldHave(exactText("ertyu"));
        $("#name").shouldHave(textCaseSensitive("Wertyu fghj jhgf"));
        $("#name").

*/


        sleep(3000);




    }
}
