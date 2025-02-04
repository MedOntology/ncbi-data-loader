package com.medontology.ncbi.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;
import com.medontology.ncbi.common.Utils;

public class NcbiDumpWriter {

    private JdbcTemplate jdbcTemplate;

    public NcbiDumpWriter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Imports data from a tab-delimited file to a database table.
     *
     * @param tableName   the database table name
     * @param columnNames an array of column names corresponding to the file's columns
     * @throws java.io.IOException if there's an error reading the file
     */
    public void populateTable(String tableName, String[] columnNames, List<Object[]> values) throws IOException {
            // Prepare SQL statement with placeholders for inserting rows
            StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
            sqlBuilder.append(tableName).append(" (");
            sqlBuilder.append(String.join(", ", Utils.escapeColumnNames(columnNames)));
            sqlBuilder.append(") VALUES (");
            sqlBuilder.append("?,".repeat(columnNames.length).replaceAll(",$", ""));
            sqlBuilder.append(")");

            String sql = sqlBuilder.toString();

            int i = 0;
            for(Object[] value: values) {
                if(value.length != columnNames.length) {
                    System.out.println("Skipping line " + i + " due to invalid number of columns. Expected: " + columnNames.length + ", Actual: " + value.length + " - probably due to unescaped pipe character");
                } else {
                    try {
                        i++;
                        jdbcTemplate.update(sql, value);
                        if (i % 100000 == 0) {
                            System.out.println(i);
                        }
                    } catch (Exception e) {
                        System.out.println("Line number: " + i);
                        e.printStackTrace();
                    }
                }
            }

            //jdbcTemplate.batchUpdate(sql, values);

            System.out.println("Data has been successfully imported into table: " + tableName);
    }
}
