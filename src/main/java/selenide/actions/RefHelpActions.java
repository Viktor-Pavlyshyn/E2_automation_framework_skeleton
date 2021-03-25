package selenide.actions;

public class RefHelpActions extends BaseActions {

    public String getTextHelpContents(){
        return poProvider.getRefHelpPage()
                .getTextHelpContents();
    }
}
