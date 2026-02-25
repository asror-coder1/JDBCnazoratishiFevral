package asror_uz;

import asror_uz.Space.Space;
import asror_uz.Space.SpaceDatabase;
import asror_uz.Workspace_role.*;
import asror_uz.Workspace_user.*;
import asror_uz.ClickAPPs.*;
import asror_uz.View.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1.Workspace_role
                    2.Workspace_user
                    3.Click_apps
                    4.View
                    5.Space
                    """);


            int work = scannerInt.nextInt();

            System.out.println("""
                    1.CREATE
                    2.READ
                    3.UPDATE
                    4.DELETE
                    """);


            int action = scannerInt.nextInt();

            switch (work) {

                // ================= WORKSPACE ROLE =================
                case 1 -> {
                    Workspace_roleDatabase db = new Workspace_roleDatabase();

                    switch (action) {
                        case 1 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();

                            System.out.println("Enter workspace_id:");
                            Long workspace_id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter name:");
                            String name = scannerString.nextLine();


                            System.out.println("Enter extends_role:");
                            String extends_role = scannerString.nextLine();

                            Workspace_role role =
                                    new Workspace_role(id, workspace_id, name, extends_role);
                            db.create(role);
                        }
                        case 2 -> db.read();
                        case 3 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("New name:");
                            String name = scannerString.nextLine();
                            db.update(id, name);
                        }
                        case 4 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            db.delete(id);
                        }
                    }
                }

                // ================= WORKSPACE USER =================
                case 2 -> {
                    Workspace_userDatabase db = new Workspace_userDatabase();

                    switch (action) {
                        case 1 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();

                            System.out.println("Enter workspace_id:");
                            Long workspace_id = scannerInt.nextLong();

                            System.out.println("Enter user_id:");
                            Long user_id = scannerInt.nextLong();

                            System.out.println("Enter workspace_role_id:");
                            Long role_id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter date_invited:");
                            String date = scannerString.nextLine();

                            System.out.println("Enter date_joined:");
                            String date_joined = scannerString.nextLine();

                            Workspace_user user =
                                    new Workspace_user(id, workspace_id, user_id,
                                            role_id, date, date_joined);

                            db.createUser(user);
                        }
                        case 2 -> db.readUser();
                        case 3 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("New date_invited:");
                            String date = scannerString.nextLine();

                            db.updateUser(id, date);
                        }
                        case 4 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            db.deleteUser(id);
                        }
                    }
                }

                // ================= CLICK APPS =================
                case 3 -> {
                    ClickAppDatabase db = new ClickAppDatabase();

                    switch (action) {
                        case 1 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter name:");
                            String name = scannerString.nextLine();

                            System.out.println("Enter icon_id:");
                            Long icon_id = scannerInt.nextLong();

                            ClickAPPs app = new ClickAPPs(id, name, icon_id);
                            db.createApps(app);
                        }
                        case 2 -> db.readApps();
                        case 3 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("New name:");
                            String name = scannerString.nextLine();

                            db.updateApps(id, name);
                        }
                        case 4 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            db.deleteApps(id);
                        }
                    }
                }

                // ================= VIEW =================
                case 4 -> {
                    ViewDatabase db = new ViewDatabase();

                    switch (action) {
                        case 1 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter name:");
                            String name = scannerString.nextLine();

                            System.out.println("Enter icon_id:");
                            Long icon_id = scannerInt.nextLong();

                            View view = new View(id, name, icon_id);
                            db.createView(view);
                        }
                        case 2 -> db.readView();
                        case 3 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("New name:");
                            String name = scannerString.nextLine();

                            db.updateView(id, name);
                        }
                        case 4 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            db.deleteView(id);
                        }
                    }
                }
                case 5 -> {
                    SpaceDatabase db = new SpaceDatabase();

                    System.out.println("""
                            1.CREATE
                            2.READ
                            3.UPDATE
                            4.DELETE
                            """);

                    int spaces = scannerInt.nextInt();

                    switch (spaces) {

                        case 1 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter name:");
                            String name = scannerString.nextLine();

                            System.out.println("Enter color:");
                            String color = scannerString.nextLine();

                            System.out.println("Enter workspace_id:");
                            Long workspace_id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter initial_letter:");
                            String initial = scannerString.nextLine();

                            System.out.println("Enter icon_id:");
                            Long icon_id = scannerInt.nextLong();

                            System.out.println("Enter avatar_id:");
                            Long avatar_id = scannerInt.nextLong();

                            System.out.println("Enter owner_id:");
                            Long owner_id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("Enter access_type:");
                            String access = scannerString.nextLine();

                            Space space = new Space(
                                    id, name, color, workspace_id,
                                    initial, icon_id, avatar_id,
                                    owner_id, access);

                            db.createSpace(space);
                        }

                        case 2 -> db.read();

                        case 3 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            scannerString.nextLine();

                            System.out.println("New name:");
                            String name = scannerString.nextLine();

                            db.update(id, name);
                        }

                        case 4 -> {
                            System.out.println("Enter id:");
                            Long id = scannerInt.nextLong();
                            db.delete(id);
                        }
                    }
                }
            }
        }
    }
}