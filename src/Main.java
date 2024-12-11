import database.Database;
import models.Favorite;
import models.User;
import service.FavoriteService;
import service.serviceImpl.FavoriteServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FavoriteService favoriteService = new FavoriteServiceImpl();
        Database.favorites.add(new Favorite(1L, "Aibek"));


        boolean input   = true;
        while (input) {
           // System.out.println("New favorite ");
            System.out.println("ОБНОВИТЬ favorite");
            System.out.println("УДАЛИТЬ favorite");
            System.out.println("ПОЛУЧИТЬ ВСЕ favorite");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("");
            }

        }

    }
}