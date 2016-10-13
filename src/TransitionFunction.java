import java.util.HashMap;
import java.util.List;

public class TransitionFunction {

    HashMap<String, HashMap<String, String>> transitionTable = new HashMap<>();

    public void populateTransitionTable(String transitions) {
        String[] transitionList = transitions.split("\n");
        for (String transition : transitionList) {
            mapTransitionIntoTable(transition);
        }
    }

    private void mapTransitionIntoTable(String transition) {
        String[] elements = transition.split(",");
        if(transitionTable.containsKey(elements[0])) {
            transitionTable.get(elements[0]).put(elements[1], elements[2]);
        }
        else {
            HashMap<String, String> alphaStatePair = new HashMap<>();
            alphaStatePair.put(elements[1], elements[2]);
            transitionTable.put(elements[0], alphaStatePair);
        }
    }

    public State getNextState(State currentState, String inputChar, List<State> allStates) {
        String state = currentState.toString();
        HashMap<String, String> alphaStatePair = transitionTable.get(state);
        String newStates = alphaStatePair.get(inputChar);
        return getState(allStates, newStates);
    }

    private State getState(List<State> allStates, String stateToGet) {
        State resultantState = null;
        for (State state : allStates) {
            if(state.toString().equals(stateToGet)) {
                resultantState = state;
            }
        }
        return resultantState;
    }
}
