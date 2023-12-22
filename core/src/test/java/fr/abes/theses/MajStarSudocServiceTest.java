package fr.abes.theses;


import fr.abes.cbs.exception.ZoneException;
import fr.abes.cbs.notices.Biblio;
import fr.abes.cbs.utilitaire.Constants;
import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.entities.ZonePrioritaire;
import fr.abes.theses.service.impl.MajStarSudocService;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MajStarSudocServiceTest {
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private DaoProvider dao;

    @InjectMocks
    private MajStarSudocService service;

    @BeforeEach
    void init() {
        service = new MajStarSudocService();
        MockitoAnnotations.initMocks(this);
        when(dao.getZonePrioritaire().findZoneByLabel("008")).thenReturn(new ZonePrioritaire(1, "008"));
        when(dao.getZonePrioritaire().findZoneByLabel("610")).thenReturn(new ZonePrioritaire(2, "610"));
        when(dao.getZonePrioritaire().findZoneByLabel("200")).thenReturn(null);
        when(dao.getZonePrioritaire().findZoneByLabel("702")).thenReturn(null);
    }

    @Test
    void fusionTheseTest() throws ZoneException {
        Biblio noticeStar = new Biblio( Constants.STR_1F + "008 $aOax3\r" +
                "200 1#$aTitre notice Star$eComplément titre notice Star$fMention de responsabilité notice Star\r" +
                "610 0#$aTraits spécifiques humains\r" +
                "610 0#$aImagerie génétique\r" +
                "702 #1$3456789123$4888\r" + Constants.STR_1E);

        Biblio noticeSudoc = new Biblio(  Constants.STR_1F + "008 $aAax3\r" +
                "200 ##$aTitre notice Sudoc$eComplément titre notice Sudoc$fMention de responsabilité notice Sudoc\r" +
                "610 0#$aAsymétries cérébrales\r" +
                "702 #1$3123456789$4111\r" +
                "702 #1$3987654321$4999\r" + Constants.STR_1E);

        assertThat(service.fusionThese(noticeStar, noticeSudoc)).isEqualTo(Constants.STR_1F + "008 $aOax3\r" +
                "200 ##$aTitre notice Sudoc$eComplément titre notice Sudoc$fMention de responsabilité notice Sudoc\r" +
                "610 0#$aTraits spécifiques humains\r" +
                "610 0#$aImagerie génétique\r"+ Constants.STR_1E);
    }

}
