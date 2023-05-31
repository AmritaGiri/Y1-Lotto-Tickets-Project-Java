package oop.anneleacy;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner keyboard = new Scanner(System.in)) {
            final int EXIT_OPTION = 14;

            Game g1 = new Game(5000, 3000, 30);
            g1.readData("ticketData.txt");

            g1.drawNumbers(); // draw the winning numbers for this run of the game

            System.out.println("Winning numbers = " + g1.getWinningNumbers());

            g1.addTicket(new Ticket("Tom", "Dublin", 123456789, g1.getWinningNumbers())); // to make sure one person
                                                                                          // gets 4
                                                                                          // matches
            g1.addTicket(new Ticket("Jerry", "Dundalk", 123456789, g1.getWinningNumbers().get(0),
                    g1.getWinningNumbers().get(1), g1.getWinningNumbers().get(2), 7)); // to make sure one person gets 3
                                                                                       // matches

            int option;

            displayMenu();
            System.out.print("\nPlease enter option:");
            option = keyboard.nextInt();
            while (option != EXIT_OPTION) {
                switch (option) {
                    case 1:
                        g1.displayAllTickets();
                        break;
                    case 2:
                        g1.displayAllMatches();
                        break;
                    case 3:
                        g1.displayNonUniqueTickets();
                        break;
                    case 4:
                        g1.displayInvalidRangeTickets();
                        break;
                    case 5: {
                        System.out.println("Enter a valid name");
                        String name = keyboard.nextLine();

                        g1.displayTicket(name);
                        break;
                    }
                    case 6:
                        System.out.println("Enter x");
                        int x = keyboard.nextInt();

                        g1.displayMatches(x);
                        break;
                    case 7:
                        System.out.println("Enter address");
                        String address = keyboard.nextLine();

                        g1.displayPlayersWithAddress(address);
                        break;
                    case 8: {
                        System.out.println("Enter the number");
                        int num = keyboard.nextInt();

                        int count = g1.countWhoChoseNumber(num);
                        System.out.println("\n" + count + " people chose number " + num + " on their ticket");
                        break;
                    }
                    case 9: {
                        System.out.println("Enter a valid name");
                        String name = keyboard.nextLine();

                        g1.displayMatchesByName(name);
                        break;
                    }
                    case 10:
                        System.out.println(g1);
                        break;
                    case 11:
                        g1.displayWinners();
                        break;
                    case 12:
                        g1.displayTicketsWithSameName();
                        break;
                    case 13: {
                        System.out.println("Choose Format\n1. Ascending\n2. Descending");
                        int num = keyboard.nextInt();

                        if (num == 1) {
                            g1.displayPlayersAsc();
                        } else if (num == 2) {
                            g1.displayPlayersDesc();
                        } else {
                            System.out.println("Choose 1 or 2");
                        }
                        break;
                    }
                    default:
                        System.out.println("Please enter a valid option [1,14]");
                        break;
                }
                displayMenu();
                System.out.print("Please enter option:");
                option = keyboard.nextInt();
            }
        }
    }

    /**
     * displays the menu of options
     */
    public static void displayMenu() {
        System.out.println("\nPlay Lotto Game");
        System.out.println("1. DISPLAY ALL TICKETS");
        System.out.println("2. DISPLAY ALL MATCHES");
        System.out.println("3. DISPLAY PEOPLE WITH NON-UNIQUE NUMBERS IN TICKET");
        System.out.println("4. DISPLAY PEOPLE WITH INVALID RANGE TICKETS");
        System.out.println("5. DISPLAY TICKET WITH NAME");
        System.out.println("6. DISPLAY PEOPLE WITH 'x' MATCHES");
        System.out.println("7. DISPLAY PLAYERS BY ADDRESS");
        System.out.println("8. DISPLAY NUMBER OF PEOPLE WHO CHOSE A PARTICULAR NUMBER");
        System.out.println("9. DISPLAY MATCHES BY NAME");
        System.out.println("10. DISPLAY GAME");
        System.out.println("11. DISPLAY WINNERS");
        System.out.println("12. DISPLAY TICKETS WITH SAME NAME");
        System.out.println("13. DISPLAY PLAYERS IN SORTED FORMAT");
        System.out.println("14. Exit");
    }

}
