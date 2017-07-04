package com.ubs.opsit.interviews.base;

import com.ubs.opsit.interviews.TimeConverter;

import java.util.stream.Stream;

/**
 * Created by Pototsky Ivan on 7/3/17.
 */
public class BerlinClockConverter implements TimeConverter {
    private static final String TIME_SEPARATOR = ":";

    public String convertTime(String aTime) {
        StringBuilder builder = new StringBuilder();

        int[] array = Stream.of(aTime.split(TIME_SEPARATOR)).mapToInt(s -> Integer.parseInt(s)).toArray();
        yellowLamp(builder, array[2]);
        fistHoursRow(builder, array[0]);
        secondHoursRow(builder, array[0]);
        firstMinutesRow(builder, array[1]);
        secondMinutesRow(builder, array[1]);
        return builder.toString();
    }

    private void yellowLamp(StringBuilder builder, int seconds) {
        builder.append(seconds % 2 == 0 ? "Y" : "O").append(System.lineSeparator());
    }

    private void fistHoursRow(StringBuilder builder, int hours) {
        initDefaultRow(builder, hours / 5, "R", false);
    }

    private void secondHoursRow(StringBuilder builder, int hours) {
        initDefaultRow(builder, hours % 5, "R", false);
    }

    private void firstMinutesRow(StringBuilder builder, int minutes) {
        int numberOfLamps = minutes / 5;
        for (int i = 0; i < 11; i++) {
            builder.append(i < numberOfLamps ? (i % 3 == 2 ? "R" : "Y")
                    : "O");
        }
        builder.append(System.lineSeparator());
    }

    private void secondMinutesRow(StringBuilder builder, int minutes) {
        initDefaultRow(builder, minutes % 5, "Y", true);
    }

    private void initDefaultRow(StringBuilder builder, int switchedOnLamps, String on, boolean lastRow) {
        for (int i = 0; i < 4; i++) {
            builder.append(i < switchedOnLamps ? on : "O");
        }
        if (!lastRow) builder.append(System.lineSeparator());
    }
}
