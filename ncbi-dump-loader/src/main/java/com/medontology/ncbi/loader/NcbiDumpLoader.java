package com.medontology.ncbi.loader;

import com.medontology.ncbi.reader.NcbiDumpReader;
import com.medontology.ncbi.writer.NcbiDumpWriter;
import com.medontology.ncbi.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class NcbiDumpLoader implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${ncbi.file.path.nodes}")
    private String nodesPath;

    @Value("${ncbi.file.path.names}")
    private String namesPath;

    @Value("${ncbi.file.path.full.name.lineage}")
    private String fullNameLineagePath;

    @Value("${ncbi.file.path.tax.id.lineage}")
    private String taxIdLineagePath;

    @Value("${ncbi.file.path.ranked.lineage}")
    private String rankedLineagePath;

    @Value("${ncbi.file.path.deleted.nodes}")
    private String deletedNodesPath;

    @Value("${ncbi.file.path.merged}")
    private String mergedPath;

    @Value("${ncbi.file.process.nodes}")
    private boolean processNodes;

    @Value("${ncbi.file.process.names}")
    private Boolean processNames;

    @Value("${ncbi.file.process.full.name.lineage}")
    private boolean processFullNameLineage;

    @Value("${ncbi.file.process.tax.id.lineage}")
    private boolean processTaxIdLineage;

    @Value("${ncbi.file.process.ranked.lineage}")
    private boolean processRankedLineage;

    @Value("${ncbi.file.process.deleted.nodes}")
    private boolean processDeletedNodes;

    @Value("${ncbi.file.process.merged}")
    private boolean processMerged;

    public static void main(String[] args) {
        SpringApplication.run(NcbiDumpLoader.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {

        processFile(processNodes, Constants.FRIENDLY_NAME_NODES, nodesPath, Constants.TABLE_NAME_NODES, Constants.NODES_COLUMN_HEADERS);
        processFile(processNames, Constants.FRIENDLY_NAME_NAMES, namesPath, Constants.TABLE_NAME_NAMES, Constants.NAMES_COLUMN_HEADERS);
        processFile(processFullNameLineage, Constants.FRIENDLY_NAME_FULL_NAME_LINEAGE, fullNameLineagePath, Constants.TABLE_NAME_FULL_NAME_LINEAGE, Constants.FULL_NAME_LINEAGE_COLUMN_HEADERS);
        processFile(processTaxIdLineage, Constants.FRIENDLY_NAME_TAX_ID_LINEAGE, taxIdLineagePath, Constants.TABLE_NAME_TAXI_ID_LINEAGE, Constants.TAX_ID_LINEAGE_COLUMN_HEADERS);
        processFile(processRankedLineage, Constants.FRIENDLY_NAME_RANKED_LINEAGE, rankedLineagePath, Constants.TABLE_NAME_RANKED_LINEAGE, Constants.RANKED_LINEAGE_COLUMN_HEADERS);
        processFile(processDeletedNodes, Constants.FRIENDLY_NAME_DELETED_NODES, deletedNodesPath, Constants.TABLE_NAME_DELETED_NODES, Constants.DELETED_NODES_COLUMN_HEADERS);
        processFile(processMerged, Constants.FRIENDLY_NAME_MERGED_NODES, mergedPath, Constants.TABLE_NAME_MERGED, Constants.MERGED_COLUMN_HEADERS);
    }

    public void processFile(boolean processFile, String filename, String filePath, String tableName, String[] columnHeaders) {
        if( processFile ) {
            try {
                System.out.println("Processing " + filename + " file: " + filePath);
                List<Object[]> data = NcbiDumpReader.readNcbiDumpFile(filePath);
                System.out.println("Processing " + data.size() + " items from " + filename);
                NcbiDumpWriter writer = new NcbiDumpWriter(jdbcTemplate);
                writer.populateTable(tableName, columnHeaders, data);
                System.out.println("Done processing " + filename);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Skipping processing of " + filePath);
        }
    }

}
