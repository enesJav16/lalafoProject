package service.serviceImpl;

import dao.AnnouncementDao;
import dao.daoImpl.AnnouncementDaoImpl;
import models.Annoucement;
import service.AnnouncementService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    AnnouncementDao annoucement = new AnnouncementDaoImpl();

    @Override
    public String addAnnocement(Annoucement announcement) {
        return annoucement.addAnnocement(announcement);
    }

    @Override
    public List<Annoucement> getAllAnnouncement() {
        return annoucement.getAllAnnouncement();
    }

    @Override
    public Annoucement getAnnouncementById(Long id) {
        return annoucement.getAnnouncementById(id);
    }

    @Override
    public void updateAnnouncement(Long id, Annoucement announcement) {
        annoucement.updateAnnouncement(id, announcement);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        annoucement.deleteAnnouncement(id);
    }
}