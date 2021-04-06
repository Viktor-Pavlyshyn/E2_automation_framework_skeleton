package selenide.page.object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class RefHelpPage {
    private final SelenideElement helpContents = $x("//h1[@class=\"firstHeading\"]");

    @Step("Get text from Help Contents")
    public String getTextHelpContents(){
        log.info("Get text from Help Contents");
        return helpContents.getText();
    }
}
