import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DFAMachineTest {

    private List<State> allStates = new ArrayList<>();
    private String transitionFunctionString;
    private State initialState;

    @Before
    public void init() {
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        q3.setAsFinal();
        allStates.add(q1);
        allStates.add(q2);
        allStates.add(q3);
        transitionFunctionString = "q1,1,q2\n" +
                                   "q1,0,q1\n" +
                                   "q2,0,q3\n" +
                                   "q2,1,q2\n" +
                                   "q3,0,q3\n" +
                                   "q3,1,q3\n";
        initialState = q1;
    }

    @Test
    public void runningAStringThroughMachineShouldDetectForRL() {
        DFAMachine dfaMachine = new DFAMachine(allStates, initialState, transitionFunctionString);
        Boolean result = dfaMachine.runString("100");
        Assert.assertTrue(result);
    }

}