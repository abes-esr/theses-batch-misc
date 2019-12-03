package fr.abes.theses.dao;

import fr.abes.theses.model.entities.ZonePrioritaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IZonePrioritaireDao extends JpaRepository<ZonePrioritaire, Integer> {
    @Query("select z from ZonePrioritaire z where z.labelZone = :labelZone")
    ZonePrioritaire findZoneByLabel(String labelZone);
}
