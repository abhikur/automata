import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TransitionFunctionTest {

    private String transitionString;
    private State q1;
    private State q2;
    private State q3;
    List<State> allStates = new ArrayList<>();
    @Before
    public void setup() {
        transitionString = "q1,1,q2\nq2,0,q3";
        q1 = new State("q1");
        q2 = new State("q2");
        q3 = new State("q3");
        q3.setAsFinal();
        allStates.add(q1);
        allStates.add(q2);
        allStates.add(q3);
    }

    @Test
    public void passingAStateItShouldReturnNextState() {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.populateTransitionTable(transitionString);
        State nextState = transitionFunction.getNextState(q1, "1", allStates);
        Assert.assertEquals(nextState.toString(), "q2");
        Assert.assertFalse(nextState.isFinal());
    }

    @Test
    public void passingAStateItShouldReturnNextStateAndDetectAsFinal() {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.populateTransitionTable(transitionString);
        State nextState = transitionFunction.getNextState(q2, "0", allStates);
        Assert.assertEquals(nextState.toString(), "q3");
        Assert.assertTrue(nextState.isFinal());
    }

}