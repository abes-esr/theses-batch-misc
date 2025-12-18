package fr.abes.theses.dao;

import fr.abes.theses.model.entities.DocumentEnvoiSudoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface IDocumentEnvoiSudoc extends JpaRepository<DocumentEnvoiSudoc, Integer> {
    List<DocumentEnvoiSudoc> findAllByNiveau(String niveau);

    void deleteAllByIddocAndNiveau(Integer iddoc, String niveau);

    void deleteAllByIddocInAndNiveau(Collection<Integer> iddocs, String niveau);
}
