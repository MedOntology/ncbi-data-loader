package com.medontology.ncbi.common;

public class Constants {

    public static final String TABLE_NAME_NODES = "NODES";
    public static final String TABLE_NAME_NAMES = "NAMES";
    public static final String TABLE_NAME_FULL_NAME_LINEAGE = "FULL_NAME_LINEAGE";
    public static final String TABLE_NAME_TAXI_ID_LINEAGE = "TAX_ID_LINEAGE";
    public static final String TABLE_NAME_RANKED_LINEAGE = "RANKED_LINEAGE";
    public static final String TABLE_NAME_DELETED_NODES = "DELETED_NODES";
    public static final String TABLE_NAME_MERGED = "MERGED";
    public static final String TABLE_NAME_CITATIONS = "CITATIONS";
    public static final String TABLE_NAME_DIVISION = "DIVISION";
    public static final String TABLE_NAME_EXCLUDE_FROM_TYPE= "EXCLUDE_FROM_TYPE";
    public static final String TABLE_NAME_GENCODE= "GENCODE";
    public static final String TABLE_NAME_HOSTS= "HOSTS";
    public static final String TABLE_NAME_IMAGE= "IMAGE";
    public static final String TABLE_NAME_TYPE_OF_MATERIAL = "TYPE_OF_MATERIAL";
    public static final String TABLE_NAME_TYPE_OF_TYPE = "TYPE_OF_TYPE";


    public static final String FRIENDLY_NAME_NODES = "nodes";
    public static final String FRIENDLY_NAME_NAMES = "names";
    public static final String FRIENDLY_NAME_FULL_NAME_LINEAGE = "full name lineage";
    public static final String FRIENDLY_NAME_TAX_ID_LINEAGE = "tax id lineage";
    public static final String FRIENDLY_NAME_RANKED_LINEAGE = "ranked lineage";
    public static final String FRIENDLY_NAME_DELETED_NODES = "deleted nodes";
    public static final String FRIENDLY_NAME_MERGED_NODES = "merged nodes";
    public static final String FRIENDLY_NAME_CITATIONS = "citations";
    public static final String FRIENDLY_NAME_DIVISION = "divisions";
    public static final String FRIENDLY_NAME_EXCLUDE_FROM_TYPE = "exclude from type";
    public static final String FRIENDLY_NAME_GENCODE = "gencode";
    public static final String FRIENDLY_NAME_HOSTS = "hosts";
    public static final String FRIENDLY_NAME_IMAGE = "image";
    public static final String FRIENDLY_NAME_TYPE_OF_MATERIAL = "type of material";
    public static final String FRIENDLY_NAME_TYPE_OF_TYPE = "type of type";

    public static final String[] NODES_COLUMN_HEADERS = new String[] {
        "tax_id",
        "parent_tax_id",
        "rank",
        "embl_code",
        "division_id",
        "inherited_div_flag",
        "genetic_code_id",
        "inherited_gc_flag",
        "mitochondrial_genetic_code_id",
        "inherited_mgc_flag",
        "genbank_hidden_flag",
        "hidden_subtree_root_flag",
        "comments",
        "plastid_genetic_code_id",
        "inherited_pgc_flag",
        "specified_species",
        "hydrogenosome_genetic_code_id",
        "inherited_hgc_flag"
    };
    
    public static final String[] NAMES_COLUMN_HEADERS = new String[] {
        "tax_id",
        "name_txt",
        "unique_name",
        "name_class"
    };

    public static final String[] FULL_NAME_LINEAGE_COLUMN_HEADERS = new String[] {
        "tax_id",
        "tax_name",
        "lineage"
    };

    public static final String[] TAX_ID_LINEAGE_COLUMN_HEADERS = new String[] {
        "tax_id",
        "lineage"
    };

    public static final String[] RANKED_LINEAGE_COLUMN_HEADERS = new String[] {
        "tax_id",
        "tax_name",
        "species",
        "genus",
        "family",
        "order",
        "class",
        "phylum",
        "kingdom",
        "superkingdom"
    };

    public static final String[] DELETED_NODES_COLUMN_HEADERS = new String[] {
            "tax_id"
    };

    public static final String[] MERGED_COLUMN_HEADERS = new String[] {
            "old_tax_id",
            "new_tax_id"
    };

    public static final String[] CITATIONS_COLUMN_HEADERS = new String[] {
            "cit_id",
            "cit_key",
            "medline_id",
            "pubmed_id",
            "url",
            "text",
            "tax_id_list"
    };

    public static final String[] DIVISION_COLUMN_HEADERS = new String[] {
            "division_id",
            "division_cde",
            "division_name",
            "comments"
    };

    public static final String[] EXCLUDE_FROM_TYPE_COLUMN_HEADERS = new String[] {
        "tax_id",
        "name_txt",
        "property",
        "voucher_strain"
    };

    public static final String[] GENCODE_COLUMN_HEADERS = new String[] {
            "genetic_code_id",
            "abbreviation",
            "genetic_code_name",
            "cde",
            "starts"
    };

    public static final String[] HOSTS_COLUMN_HEADERS = new String[] {
            "tax_id",
            "potential_hosts"
    };

    public static final String[] IMAGE_COLUMN_HEADERS = new String[] {
            "image_id",
            "image_key",
            "image_url",
            "license",
            "attribution",
            "source",
            "properties",
            "tax_id_list"
    };

    public static final String[] TYPE_OF_MATERIAL_COLUMN_HEADERS = new String[] {
            "tax_id",
            "type_name",
            "type",
            "identifier"
    };

    public static final String[] TYPE_OF_TYPE_COLUMN_HEADERS = new String[] {
            "type_name",
            "synonyms",
            "nomenclature",
            "description"
    };
}
