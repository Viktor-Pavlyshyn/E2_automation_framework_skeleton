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

    public BaseActions getBaseActions() {
        return get(BaseActions.class);
    }

    public SearchAppleResultActions getSearchAppleResultActions() {
        return get(SearchAppleResultActions.class);
    }

    public RefTalkActions getRefTalkActions() {
        return get(RefTalkActions.class);
    }
}