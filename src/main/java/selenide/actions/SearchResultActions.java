package selenide.actions;

public class SearchResultActions extends BaseActions {

    public int getSizeOfContents(){
        return poProvider.getSearchResultPage().getSizeOfContents();
    }
}
