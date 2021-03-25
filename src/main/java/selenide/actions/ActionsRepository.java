package selenide.actions;

public class ActionsRepository extends Repository {

    public RefAboutWikipediaActions getRefAboutWikipediaActions() {
        return get(RefAboutWikipediaActions.class);
    }

    public RefCommunityPortalActions getRefCommunityPortalActions() {
        return get(RefCommunityPortalActions.class);
    }

    public RefHelpActions getRefHelpActions() {
        return get(RefHelpActions.class);
    }

    public WikipediaActions getWikipediaActions() {
        return get(WikipediaActions.class);
    }

    public SearchResultActions getSearchResultActions() {
        return get(SearchResultActions.class);
    }

    public RefTalkActions getRefTalkActions() {
        return get(RefTalkActions.class);
    }
}