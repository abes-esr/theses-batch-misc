CREATE TABLE document_envoi_sudoc
(
    id     NUMBER GENERATED ALWAYS AS IDENTITY,
    iddoc  NUMBER NOT NULL,
    niveau VARCHAR2(20) NOT NULL,
    CONSTRAINT document_envoi_sudoc_pk PRIMARY KEY (id)
);

create or replace TRIGGER trg_keep_latest_document_envoi_sudoc
FOR INSERT ON document_envoi_sudoc
COMPOUND TRIGGER

AFTER STATEMENT IS
BEGIN
DELETE FROM document_envoi_sudoc d
WHERE EXISTS (
    SELECT 1 FROM document_envoi_sudoc d2
    WHERE d.iddoc = d2.iddoc
      AND d.niveau = d2.niveau
      AND d.id < d2.id
);
END AFTER STATEMENT;

END trg_keep_latest_document_envoi_sudoc;