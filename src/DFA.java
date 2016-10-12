import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFA {

    public static void main(String[] args) {
        HashMap<String, Object> tupple = new HashMap<>();
        List<State> states = new ArrayList<>();
        State initialState = new State("q1");
        initialState.setAsInitial();
        State intermediateState = new State("q2");
        State finalState = new State("q3");
        finalState.setAsFinal();
        states.add(initialState);
        states.add(intermediateState);
        states.add(finalState);
        tupple.put("states", states);
        tupple.put("alphabets", "100");
        tupple.put("initState", initialState);
        tupple.put("finalState", finalState);
        tupple.put("transitionFunction", "q1,1,q2\nq1,0,q1\nq2,0,q3\nq2,1,q2\nq3,0,q3\nq3,1,q3");
        String alphabets = (String) tupple.get("alphabets");
        List<State> allStates = (List<State>) tupple.get("states");
        String transitionTableString = (String) tupple.get("transitionFunction");
    }

}
