package patterns.core.state;

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void coinRequest() {
        state.coin(this);
    }

    public void pushRequest() {
        state.push(this);
    }
}
