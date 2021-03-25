package selenide.page.object;

public class POProvider {

    private RefAboutWikipediaPage refAboutWikipediaPage;
    private RefCommunityPortalPage refCommunityPortalPage;
    private RefHelpPage refHelpPage;
    private RefTalkPage refTalkPage;
    private SearchResultPage searchResultPage;
    private WikipediaPage wikipediaPage;

    public RefAboutWikipediaPage getRefAboutWikipediaPage() {
        return (refAboutWikipediaPage == null) ? refAboutWikipediaPage = new RefAboutWikipediaPage() : refAboutWikipediaPage;
    }

    public RefCommunityPortalPage getRefCommunityPortalPage() {
        return (refCommunityPortalPage == null) ? refCommunityPortalPage = new RefCommunityPortalPage() : refCommunityPortalPage;
    }

    public RefHelpPage getRefHelpPage() {
        return (refHelpPage == null) ? refHelpPage = new RefHelpPage() : refHelpPage;
    }

    public RefTalkPage getRefTalkPage() {
        return (refTalkPage == null) ? refTalkPage = new RefTalkPage() : refTalkPage;
    }

    public WikipediaPage getWikipediaPage() {
        return (wikipediaPage == null) ? wikipediaPage = new WikipediaPage() : wikipediaPage;
    }

    public SearchResultPage getSearchResultPage() {
        return (searchResultPage == null) ? searchResultPage = new SearchResultPage() : searchResultPage;
    }
}
