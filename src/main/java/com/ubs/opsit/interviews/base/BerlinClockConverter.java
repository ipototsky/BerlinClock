package com.ubs.opsit.interviews.base;

import com.ubs.opsit.interviews.TimeConverter;

/**
 * Created by Pototsky Ivan on 7/3/17.
 */
public class BerlinClockConverter implements TimeConverter {
    private static final String TIME_SEPARATOR = ":";

    public String convertTime(String aTime) {
        StringBuilder builder = new StringBuilder();

        String[] array = aTime.split(TIME_SEPARATOR);
        yellowLamp(builder, array[2]);
        Integer hours = Integer.parseInt(array[0]);
        Integer minutes = Integer.parseInt(array[1]);
        fistHoursRow(builder, hours);
        secondHoursRow(builder, hours);
        firstMinutesRow(builder, minutes);
        secondMinutesRow(builder, minutes);
        return builder.toString();
    }

    private void yellowLamp(StringBuilder builder, String aSeconds) {
        Integer seconds = Integer.parseInt(aSeconds);
        builder.append(seconds % 2 == 0 ? "Y" : "O").append(System.lineSeparator());
    }

    private void fistHoursRow(StringBuilder builder, Integer hours) {
        int numberOfLamps = hours / 5;
        for (int i = 0; i < 4; i++) {
            builder.append(i < numberOfLamps ? "R" : "O");
        }
        builder.append(System.lineSeparator());
    }

    private void secondHoursRow(StringBuilder builder, Integer hours) {
        int numberOfLamps = hours % 5;
        for (int i = 0; i < 4; i++) {
            builder.append(i < numberOfLamps ? "R" : "O");
        }
        builder.append(System.lineSeparator());
    }

    private void firstMinutesRow(StringBuilder builder, Integer minutes) {
        int numberOfLamps = minutes / 5;
        for (int i = 0; i < 11; i++) {
            builder.append(i < numberOfLamps ? i % 3 == 2 ? "R" : "Y"
                    : "O");
        }
        builder.append(System.lineSeparator());
    }

    private void secondMinutesRow(StringBuilder builder, Integer minutes) {
        int numberOfLamps = minutes % 5;
        for (int i = 0; i < 4; i++) {
            builder.append(i < numberOfLamps ? "Y" : "O");
        }
    }
}
