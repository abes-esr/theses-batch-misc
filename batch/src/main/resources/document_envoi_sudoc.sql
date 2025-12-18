CREATE TABLE document_envoi_sudoc
(
    id     NUMBER GENERATED ALWAYS AS IDENTITY,
    iddoc  NUMBER NOT NULL,
    niveau VARCHAR2(20) NOT NULL,
    CONSTRAINT document_envoi_sudoc_pk PRIMARY KEY (id)
);