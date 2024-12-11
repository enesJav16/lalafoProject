package dao;

import dao.daoImpl.AnnouncementDaoImpl;
import models.Annoucement;

import java.util.List;

public interface AnnouncementDao {
    String addAnnocement( Annoucement announcement);

    List<Annoucement> getAllAnnouncement();

    Annoucement getAnnouncementById(Long id);

    void updateAnnouncement(Long id,Annoucement announcement);

    void deleteAnnouncement(Long id);
}