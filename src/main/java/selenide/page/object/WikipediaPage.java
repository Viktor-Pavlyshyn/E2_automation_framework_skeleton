package selenide.page.object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Getter
public class WikipediaPage {

     private final SelenideElement refTalk = $x("//li[@id=\"ca-talk\"]/a");
     private final SelenideElement refAboutWikipedia = $x("//li[@id=\"n-aboutsite\"]/a");
     private final SelenideElement refHelp = $x("//li[@id=\"n-help\"]/a");
     private final SelenideElement refCommunityPortal = $x("//li[@id=\"n-portal\"]/a");
     private final SelenideElement inputSearch = $x("//input[@type=\"search\"]");
     private final SelenideElement searchButton = $x("//input[@type=\"submit\"]");

     @Step("Input search value- {inputValue}")
     public void inputSearchValue(String inputValue){
          log.info("Input search value");
          inputSearch.setValue(inputValue);
     }

     @Step("Click on search button")
     public void clickSearchButton(){
          log.info("Click on search button");
          searchButton.shouldBe(Condition.visible).click();
     }

     @Step("Click on RefCommunityPortal")
     public void clickOnRefCommunityPortal(){
          log.info("Click on RefCommunityPortal");
          refCommunityPortal.click();
     }

     @Step("Click on refHelp")
     public void clickOnRefHelp(){
          log.info("Click on RefHelp");
          refHelp.click();
     }

     @Step("Click on refAboutWikipedia")
     public void clickOnRefAboutWikipedia(){
          log.info("Click on refAboutWikipedia");
          refAboutWikipedia.shouldBe(Condition.appear).click();
     }

     @Step("Click on refTalk")
     public void clickOnRefTalk(){
          log.info("Click on refTalk");
          refTalk.shouldBe(Condition.visible).click();
     }
}