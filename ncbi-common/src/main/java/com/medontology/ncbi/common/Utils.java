package com.medontology.ncbi.common;

public class Utils {

    public static String[] escapeColumnNames(String[] columnNames) {

        if(columnNames == null || columnNames.length == 0) {
            throw new IllegalArgumentException("Column names cannot be null or empty");
        } else {
            String[] escapedColumnNames = new String[columnNames.length];
            for(int i = 0; i < columnNames.length; i++) {
                escapedColumnNames[i] = "`" + columnNames[i] + "`";
            }
            return escapedColumnNames;
        }
    }

    public static String[] cleanData(String[] data) {
        String[] cleanedData = new String[data.length];
        for(int i = 0; i < data.length; i++) {
            if(data[i] != null && data[i].trim().length() == 0) {
                cleanedData[i] = null;
            } else {
                cleanedData[i] = data[i].trim();
            }
        }
        return cleanedData;
    }
}
