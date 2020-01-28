package fr.abes.theses.components;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Slf4j
@Component
@NoArgsConstructor
public class FichierResultat {

    @Getter
    @Setter
    private String filename;

    @Getter @Setter
    private Path path;

    public FichierResultat(final String filename){
        this.filename = filename;
    }
    public void generateFileName(Integer jobId) {
        this.filename = "fichierResultat" + jobId + ".csv";
    }
}
