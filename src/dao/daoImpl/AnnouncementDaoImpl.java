package dao.daoImpl;

import dao.AnnouncementDao;
import database.Database;
import generateId.GenerateId;
import models.Annoucement;

import java.util.List;
import java.util.Scanner;

public class AnnouncementDaoImpl implements AnnouncementDao {

    /// ADD ANNOUNCEMENT
    @Override
    public String addAnnocement(Annoucement announcement) {
        Database.annoucements.add(announcement);
        return "success add announcement";
    }

    ///  GET ALL ANNOUNCEMENT
    @Override
    public List<Annoucement> getAllAnnouncement() {
        if (Database.annoucements.isEmpty()) {
            return null;
        }
        return Database.annoucements;
    }

    /// GET ANNOUNCEMENT BY ID
    @Override
    public Annoucement getAnnouncementById(Long id) {
        if (Database.annoucements == null || id == null) {
            return null;
        }
        for (Annoucement announcement : Database.annoucements) {
            if (announcement.getId().equals(id)) {
                return announcement;

            }
        }
        return null;
    }

    /// UPDATE ANNOUNCEMENT
    @Override
    public void updateAnnouncement(Long id, Annoucement announcement) {
        for (Annoucement announcement2 : Database.annoucements) {
            if (id.equals(announcement2.getId())) {
                announcement2.setName(announcement.getName());
                announcement2.setDescription(announcement.getDescription());
            }
        }
    }

    /// DELETE ANNOUNCEMENT
    @Override
    public void deleteAnnouncement(Long id) {
        Annoucement announcement = getAnnouncementById(id);
        if (announcement != null) {
            Database.annoucements.remove(getAnnouncementById(id));
            System.out.println("announcement with id " + id + " deleted successfully");
        } else {
            System.out.println("announcement with id " + id + " not found");
        }
    }
}