package com.company;

import sun.applet.Main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class Test {

    private static void loggerConfiguration() {
        Logger root = Logger.getLogger("");
        Arrays.asList(root.getHandlers()).forEach(h -> root.removeHandler(h));

        Logger logger = Logger.getLogger("com.company");
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.setUseParentHandlers(false);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
    }

    public static void main(String[] args) {

        loggerConfiguration();

        TravelOffice travelOffice = new TravelOffice();
        MainHandler mainHandler = new MainHandler(travelOffice);

        Scanner scanner = new Scanner(System.in);
        top:
        while (true) {
            System.out.println("Wybierz co chcesz zrobić: ");
            System.out.println("1. Dodaj klienta");
            System.out.println("2. Dodaj wycieczke");
            System.out.println("3. Przypisz wycieczke do klienta");
            System.out.println("4. Usuń klienta");
            System.out.println("5. Usuń wycieczke");
            System.out.println("6. Pokaż klientów");
            System.out.println("7. Pokaż wycieczki");
            System.out.println("8. Wyjdź");
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next();
                continue;
            }
            switch (choice) {
                case 1:
                    mainHandler.addCustomer();
                    break;
                case 2:
                    mainHandler.addTrip();
                    break;
                case 3:
                    mainHandler.assign();
                    break;
                case 4:
                    mainHandler.removeCustomer();
                    break;
                case 5:
                    mainHandler.removeTrip();
                    break;
                case 6:
                    mainHandler.showCustomers();
                    break;
                case 7:
                    mainHandler.showTrips();
                    break;
                case 8:
                    break top;
                default:
                    System.out.println("Wybierz poprawny numer z menu");
                    break;
            }
        }
        scanner.close();
    }
}

