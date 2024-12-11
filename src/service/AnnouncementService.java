package service;

import models.Annoucement;

import java.util.List;

public interface AnnouncementService {
    String addAnnocement(Annoucement announcement);

    List<Annoucement> getAllAnnouncement();

    Annoucement getAnnouncementById(Long id);

    void updateAnnouncement(Long id, Annoucement announcement);

    void deleteAnnouncement(Long id);
}
