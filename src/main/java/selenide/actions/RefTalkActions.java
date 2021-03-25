package selenide.actions;

public class RefTalkActions extends BaseActions {

    public String getTextTalkMain(){
        return poProvider.getRefTalkPage()
                .getTextTalkMain();
    }
}
