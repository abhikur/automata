import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {
    @Test
    public void testIsFinalWhenStateIsSetAsFinal() {
        State q1 = new State("q1");
        q1.setAsFinal();
        Assert.assertTrue(q1.isFinal());
        Assert.assertFalse(q1.isInitial());
    }

    @Test
    public void testIsFinalWhenStateIsSetAsInitial() {
        State q1 = new State("q1");
        q1.setAsInitial();
        Assert.assertFalse(q1.isFinal());
        Assert.assertTrue(q1.isInitial());
    }

}