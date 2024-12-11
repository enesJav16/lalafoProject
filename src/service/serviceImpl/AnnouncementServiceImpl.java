package service.serviceImpl;

import dao.AnnouncementDao;
import dao.daoImpl.AnnouncementDaoImpl;
import generateId.GenerateId;
import models.Annoucement;
import models.User;
import service.AnnouncementService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

    public static Annoucement newAnnoucement(User user) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Annoucement announcement = new Annoucement();
        announcement.setId(GenerateId.announcementId());
        System.out.println("Enter title: ");
        announcement.setName(scanner.nextLine());
        System.out.println("Enter description: ");
        announcement.setDescription(scanner.nextLine());
        while (true) {
            try {
                System.out.println("Enter price: ");
                announcement.setPrice(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid price: ");
            }

        }
        announcement.setOwner(user);
        return announcement;
    }
    public static Annoucement updateAnnoucement(User user) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Annoucement announcement = new Annoucement();
        System.out.println("Enter title: ");
        announcement.setName(scanner.nextLine());
        System.out.println("Enter description: ");
        announcement.setDescription(scanner.nextLine());
        while (true) {
            try {
                System.out.println("Enter price: ");
                announcement.setPrice(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid price: ");
            }
        }
        announcement.setOwner(user);
        return announcement;
    }
}