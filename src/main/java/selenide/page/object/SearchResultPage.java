package selenide.page.object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

@Log4j2
@Getter
public class SearchResultPage {

    private final List<SelenideElement> contents = $$x("//input[@type=\"submit\"]");

    @Step("Get size of Contents")
    public int getSizeOfContents(){
        log.info("Get size of Contents");
        return contents.size();
    }
}
