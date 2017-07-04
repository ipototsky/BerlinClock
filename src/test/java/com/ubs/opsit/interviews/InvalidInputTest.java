package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.impl.BerlinClockConverter;
import org.junit.Test;

/**
 * @author ivan.pototsky on 04.07.2017.
 */
public class InvalidInputTest {
    private TimeConverter berlinClock = new BerlinClockConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testInputIsNull() throws Exception {
        berlinClock.convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTimeInvalid() {
        berlinClock.convertTime("22:11:10:05");
    }
}
