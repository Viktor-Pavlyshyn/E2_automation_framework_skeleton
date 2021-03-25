package selenide.actions;

public class RefAboutWikipediaActions extends BaseActions {

    public String getTextWikipediaAbout() {
        return poProvider.getRefAboutWikipediaPage()
                .getTextWikipediaAbout();
    }
}
