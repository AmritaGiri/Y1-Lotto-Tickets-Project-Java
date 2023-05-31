package oop.anneleacy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Ticket> tickets;
    private ArrayList<Integer> winningNumbers;
    private int jackpotAmount;
    private int match3Amount;
    private int maxRange;

    public Game(ArrayList<Ticket> tickets, ArrayList<Integer> winningNumbers, int jackpotAmount, int match3Amount,
            int maxRange) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.jackpotAmount = jackpotAmount;
        this.match3Amount = match3Amount;
        this.maxRange = maxRange;
    }

    public Game(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
        this.winningNumbers = new ArrayList<>();
        this.jackpotAmount = 0;
        this.match3Amount = 0;
        this.maxRange = 0;
    }

    public Game(int jackpotAmount, int match3Amount, int maxRange) {
        this.tickets = new ArrayList<>();
        this.winningNumbers = new ArrayList<>();
        this.jackpotAmount = jackpotAmount;
        this.match3Amount = match3Amount;
        this.maxRange = maxRange;
    }

    public void addTicket(Ticket t) {
        if (t != null) {
            tickets.add(t);
        }
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getJackpotAmount() {
        return jackpotAmount;
    }

    public int getMatch3Amount() {
        return match3Amount;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setWinningNumbers(ArrayList<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setJackpotAmount(int jackpotAmount) {
        this.jackpotAmount = jackpotAmount;
    }

    public void setMatch3Amount(int match3Amount) {
        this.match3Amount = match3Amount;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public void displayAllTickets() {
        for (Ticket ticket : tickets) {
            System.out.println("\n" + ticket);
        }
    }

    public void displayTicket(String name) {
        boolean checkValid = false;
        for (Ticket ticket : tickets) {
            if (name.equalsIgnoreCase(ticket.getName())) {
                System.out.println("\n" + name + "'s Ticket = " + ticket);
                checkValid = true;
            }
        }
        if (!checkValid) {
            System.out.println("\nInvalid name entered, try again");
        }
    }

    public void drawNumbers() {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int num = rand.nextInt(maxRange) + 1;
            while (winningNumbers.contains(num)) {
                num = rand.nextInt(maxRange) + 1;
            }
            winningNumbers.add(num);
        }
        Collections.sort(winningNumbers);
    }

    public void displayMatches(int x) {
        for (Ticket ticket : tickets) {
            if (ticket.howManyMatches(winningNumbers) == x) {
                System.out.println("\n" + ticket.getName() + " has got " + x + " matches!");
            }
        }
        if (x < 0 || x > winningNumbers.size()) {
            System.out.println("\nPlease enter a valid number and try again");
        }
    }

    public void displayPlayersWithAddress(String address) {
        boolean checkValid = false;
        System.out.println("\nFollowing is the list of people from " + address);
        for (Ticket ticket : tickets) {
            if (address.equalsIgnoreCase(ticket.getAddress())) {
                System.out.println(ticket.getName());
                checkValid = true;
            }
        }
        if (!checkValid) {
            System.out.println("\nInvalid address entered, try again");
        }
    }

    public int countWhoChoseNumber(int num) {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getNumsChosen().contains(num)) {
                count++;
            }
        }
        if (num < 0 || num > maxRange) {
            System.out.println("\nPlease enter a valid number and try again");
        }
        return count;
    }

    public void displayInvalidRangeTickets() {
        for (Ticket ticket : tickets) {
            for (int num : ticket.getNumsChosen()) {
                if (num < 1 || num > maxRange) {
                    System.out.println("\n" + ticket.getName());
                    break;
                }
            }
        }
    }

    public void displayNonUniqueTickets() {
        for (Ticket ticket : tickets) {
            ArrayList<Integer> numsChosen = ticket.getNumsChosen();
            for (int i = 0; i < numsChosen.size(); i++) {
                for (int j = i + 1; j < numsChosen.size(); j++) {
                    if (numsChosen.get(i).equals(numsChosen.get(j))) {
                        System.out.println("\n" + ticket.getName());
                        break;
                    }
                }
            }
        }
    }

    public void displayAllMatches() {
        System.out.printf("\n%-10s%4s\n", "Name", "Matches");
        for (Ticket ticket : tickets) {
            System.out.printf("%-10s%4d\n", ticket.getName(), ticket.howManyMatches(winningNumbers));
        }
    }

    public void displayWinners() {
        System.out.println("\nFollowing person(s) hit the Jackpot!");
        for (Ticket ticket : tickets) {
            if (ticket.howManyMatches(winningNumbers) == 4) {
                System.out.println(ticket.getName());
            }
        }

        System.out.println("\nFollowing person(s) won the Match3 Amount!");
        for (Ticket ticket : tickets) {
            if (ticket.howManyMatches(winningNumbers) == 3) {
                System.out.println(ticket.getName());
            }
        }
        System.out.println("\n*prize will be distributed equally if more than 1 person wins");
    }

    public void displayTicketsWithSameName() {
        System.out.println("\nFollowing is the list of tickets with the same name");
        for (int i = 0; i < tickets.size(); i++) {
            for (int j = i + 1; j < tickets.size(); j++) {
                if (tickets.get(i).getName().equalsIgnoreCase(tickets.get(j).getName())) {
                    System.out.println(tickets.get(i));
                    break;
                }
            }
        }
    }

    public void displayMatchesByName(String name) {
        boolean checkValid = false;
        for (Ticket ticket : tickets) {
            if (name.equalsIgnoreCase(ticket.getName())) {
                System.out.println("\n" + name + "'s Ticket = " + ticket.howManyMatches(winningNumbers) + " matches");
                checkValid = true;
                break;
            }
        }
        if (!checkValid) {
            System.out.println("\nInvalid name entered, try again");
        }
    }

    public void displayPlayersAsc() {
        ArrayList<String> sortedNames = new ArrayList<>();
        for (Ticket ticket : tickets) {
            sortedNames.add(ticket.getName());
        }
        Collections.sort(sortedNames);
        System.out.println("\n" + sortedNames);
    }

    public void displayPlayersDesc() {
        ArrayList<String> sortedNames = new ArrayList<>();
        for (Ticket ticket : tickets) {
            sortedNames.add(ticket.getName());
        }
        Collections.sort(sortedNames, Collections.reverseOrder());
        System.out.println("\n" + sortedNames);
    }

    @Override
    public String toString() {
        return "Game{" +
                "tickets=" + tickets +
                ", winningNumbers=" + winningNumbers +
                ", jackpotAmount=" + jackpotAmount +
                ", match3Amount=" + match3Amount +
                ", maxRange=" + maxRange +
                '}';
    }

    public void readData(String fileName) throws FileNotFoundException {
        Scanner ticketData = new Scanner(new File(fileName));

        while (ticketData.hasNext()) {
            String name = ticketData.next();
            String address = ticketData.next();
            long phone = ticketData.nextLong();
            int num0 = ticketData.nextInt();
            int num1 = ticketData.nextInt();
            int num2 = ticketData.nextInt();
            int num3 = ticketData.nextInt();

            Ticket ticket = new Ticket(name, address, phone, num0, num1, num2, num3);
            addTicket(ticket);
        }
    }
}
