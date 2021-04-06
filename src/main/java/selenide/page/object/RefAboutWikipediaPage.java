package selenide.page.object;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class RefAboutWikipediaPage {
    private final SelenideElement wikipediaAbout = $x("//h1[@class=\"firstHeading\"]");
    private final Waiter waiter = new Waiter();

    @Step("Get text from Wikipedia About")
    public String getTextWikipediaAbout() {
        log.info("Get text from Wikipedia About");
        waiter.wait(wikipediaAbout, this::isDisplayed, 60, 2);
        return wikipediaAbout.getText();
    }

    private boolean isDisplayed(SelenideElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
