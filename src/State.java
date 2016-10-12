public class State {
    private String state;
    private Boolean isInitial = false;
    private Boolean isFinal = false;

    public State(String state) {
        this.state = state;
    }

    public void setAsInitial() {
        isInitial = true;
    }

    public void setAsFinal() {
        isFinal = true;
    }

    public Boolean isInitial() {
        return isInitial;
    }

    public Boolean isFinal() {
        return isFinal;
    }

    @Override
    public String toString() {
        return state;
    }
}
