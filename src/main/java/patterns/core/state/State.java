package patterns.core.state;

public interface State {
    void coin(Context context);

    void push(Context context);
}
