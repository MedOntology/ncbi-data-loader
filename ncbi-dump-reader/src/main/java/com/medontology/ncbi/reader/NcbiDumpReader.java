package com.medontology.ncbi.reader;

import com.medontology.ncbi.common.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NcbiDumpReader {

    /**
     * Reads and prints lines from an NCBI dump file.
     *
     * @param filePath the path to the file
     */
    public static List<Object[]> readNcbiDumpFile(String filePath) {
        List<Object[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] components = line.split("\\|");
                lines.add(Utils.cleanData(components));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
        return lines;
    }
}
