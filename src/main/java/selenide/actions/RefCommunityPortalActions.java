package selenide.actions;

public class RefCommunityPortalActions extends BaseActions {

    public String getTextWikipediaCommunityPortal(){
        return poProvider.getRefCommunityPortalPage()
                .getTextWikipediaCommunityPortal();
    }
}
