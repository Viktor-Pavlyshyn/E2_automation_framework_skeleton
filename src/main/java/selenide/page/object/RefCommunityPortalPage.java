package selenide.page.object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class RefCommunityPortalPage {
    private final SelenideElement wikipediaCommunityPortal = $x("//h1[@class=\"firstHeading\"]");

    @Step("Get text from Wikipedia Community Portal")
    public String getTextWikipediaCommunityPortal(){
        log.info("Get text from WikipediaCommunityPortal");
        return wikipediaCommunityPortal.getText();
    }
}
