CREATE TABLE document_envoi_sudoc
(
    id     NUMBER GENERATED ALWAYS AS IDENTITY,
    iddoc  NUMBER NOT NULL,
    niveau VARCHAR2(20) NOT NULL,
    CONSTRAINT document_envoi_sudoc_pk PRIMARY KEY (id)
);

CREATE OR REPLACE TRIGGER trg_keep_latest
AFTER INSERT ON document_envoi_sudoc
FOR EACH ROW
BEGIN
DELETE FROM document_envoi_sudoc
WHERE IDDoc = :NEW.IDDoc
  AND Niveau = :NEW.Niveau
  AND ID <> :NEW.ID;
END;