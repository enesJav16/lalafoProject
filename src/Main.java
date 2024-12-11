import dao.AnnouncementDao;
import dao.daoImpl.AnnouncementDaoImpl;
import enums.Role;
import models.Annoucement;
import models.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnouncementDao announcement = new AnnouncementDaoImpl();
        System.out.println("ADD ANNOUNCEMENT\n");
        System.out.println(announcement.addAnnocement((new Annoucement(1L, "ANNOUNCEMENT-1", " ANNOUNCEMENT", 10000, new User(1L, "User-1", "Ucres@gmail.com", "1234", Role.USER)))));

        System.out.println("GET ALL ANNOUNCEMENT\n");
        System.out.println(announcement.getAllAnnouncement());

        System.out.println("GET ANNOUNCEMENT BY ID\n");
        System.out.println(announcement.getAnnouncementById(1L));

        System.out.println("UPDATE ANNOUNCEMENT\n");
        announcement.updateAnnouncement(1L, new Annoucement(2L, "A", "S", 12000, new User(2L, "SD", "sd@gmail.com", "1234", Role.VENDOR)));

        System.out.println("DELETE ANNOUNCEMENT");
        announcement.deleteAnnouncement(3L);

        System.out.println(announcement.getAllAnnouncement());

    }
}