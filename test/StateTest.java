import junit.framework.Assert;
import org.junit.Test;

public class StateTest {
    @Test
    public void testIsFinalWhenStateIsSetAsFinal() {
        State q1 = new State("q1");
        q1.setAsFinal();
        Assert.assertTrue(q1.isFinal());
    }

}