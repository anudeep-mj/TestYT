package challenges;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class HashsetremoveTest {

    @Test
    public void getRemovedTest() {
        HashSet<Long> updatedset = new HashSet<Long>();
        HashSet<Long> origSet = new HashSet<Long>();

        updatedset.add(1L);
        updatedset.add(2L);
        updatedset.add(3L);

        origSet.add(2L);
        origSet.add(3L);
        origSet.add(4L);

        Hashsetremove hashsetremove = new Hashsetremove();

        assertTrue(hashsetremove.getRemoved(updatedset, origSet));
    }
}
