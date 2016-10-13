import java.util.List;

public class DFAMachine {

    private final List<State> allStates;
    private final State initialState;
    private final String transitionFunctionString;

    public DFAMachine(List<State> allStates, State initialState, String transitionFunctionString) {
        this.allStates = allStates;
        this.initialState = initialState;
        this.transitionFunctionString = transitionFunctionString;
    }

    public Boolean runString(String string) {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.populateTransitionTable(transitionFunctionString);
        String[] alphabets = string.split("");
        State currentState = initialState;
        for (String alphabet : alphabets) {
            if(!alphabet.equals("")) {
                currentState = transitionFunction.getNextState(currentState, alphabet, allStates);
            }
        }
        return currentState.isFinal();
    }


}
