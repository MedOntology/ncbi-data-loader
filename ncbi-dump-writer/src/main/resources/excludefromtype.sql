DROP TABLE IF EXISTS `EXCLUDE_FROM_TYPE`;

CREATE TABLE `EXCLUDE_FROM_TYPE` (
    TAX_ID INTEGER NOT NULL,
    NAME_TXT VARCHAR(1000),
    PROPERTY VARCHAR(1000),
    VOUCHER_STRAIN VARCHAR(1000)
);