import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TransitionFunctionTest {
    @Test
    public void passingAStateItShouldReturnNextState() {
        String transitionString = "q1,1,q2";
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.populateTransitionTable(transitionString);
        State currentState = new State("q1");
        State finalState = new State("q2");
        finalState.setAsFinal();
        List<State> allStates = new ArrayList<>();
        allStates.add(currentState);
        allStates.add(finalState);
        State nextState = transitionFunction.getNextState(currentState, "1", allStates);
        Assert.assertEquals(nextState.toString(), "q2");
        Assert.assertTrue(nextState.isFinal());
    }

}