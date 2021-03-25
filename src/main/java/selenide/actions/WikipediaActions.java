package selenide.actions;

public class WikipediaActions extends BaseActions {

    public void inputSearchValueAndClickSearchButton(String inputValue){
        poProvider.getWikipediaPage().inputSearchValueAndClickSearchButton(inputValue);
    }

    public void clickOnRefCommunityPortal(){
        poProvider.getWikipediaPage().clickOnRefCommunityPortal();
    }

    public void clickOnRefHelp(){
        poProvider.getWikipediaPage().clickOnRefHelp();
    }

    public void clickOnRefAboutWikipedia(){
        poProvider.getWikipediaPage().clickOnRefAboutWikipedia();
    }

    public void clickOnRefTalk(){
        poProvider.getWikipediaPage().clickOnRefTalk();
    }
}
