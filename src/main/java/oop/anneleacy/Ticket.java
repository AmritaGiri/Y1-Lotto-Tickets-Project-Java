package oop.anneleacy;

import java.util.ArrayList;
import java.util.Collections;

public class Ticket {
    private String name;
    private String address;
    private long phone;
    private ArrayList<Integer> numsChosen;

    public Ticket(String name, String address, long phone, int num0, int num1, int num2, int num3) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        numsChosen = new ArrayList<>();
        numsChosen.add(num0);
        numsChosen.add(num1);
        numsChosen.add(num2);
        numsChosen.add(num3);

        Collections.sort(numsChosen);
    }

    public Ticket(String name, String address, long phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        numsChosen = new ArrayList<>();
    }

    public Ticket(String name, String address, long phone, ArrayList<Integer> numsChosen) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.numsChosen = numsChosen;
    }

    public Ticket(String name, String address, ArrayList<Integer> numsChosen) {
        this.name = name;
        this.address = address;
        this.numsChosen = numsChosen;
        this.phone = 0; // Initialize phone to a default value
    }

    public Ticket(long phone, ArrayList<Integer> numsChosen) {
        this.phone = phone;
        this.numsChosen = numsChosen;
        this.name = ""; // Initialize name to a default value
        this.address = ""; // Initialize address to a default value
    }

    public Ticket(long phone) {
        this.phone = phone;
        this.name = ""; // Initialize name to a default value
        this.address = ""; // Initialize address to a default value
        numsChosen = new ArrayList<>();
    }

    public Ticket(ArrayList<Integer> numsChosen) {
        this.numsChosen = numsChosen;
        this.name = ""; // Initialize name to a default value
        this.address = ""; // Initialize address to a default value
        this.phone = 0; // Initialize phone to a default value
    }

    public Ticket() {
        this.name = ""; // Initialize name to a default value
        this.address = ""; // Initialize address to a default value
        this.phone = 0; // Initialize phone to a default value
        numsChosen = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public ArrayList<Integer> getNumsChosen() {
        return numsChosen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setNumsChosen(ArrayList<Integer> numsChosen) {
        this.numsChosen = numsChosen;
    }

    public int howManyMatches(ArrayList<Integer> actualNumbers) {
        int count = 0;

        for (int i = 0; i < numsChosen.size(); i++) {
            for (int j = 0; j < actualNumbers.size(); j++) {
                if (actualNumbers.get(j).equals(numsChosen.get(i))) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s, Address: %-10s, Phone: %-10s, Ticket Numbers: %-15s", name, address, phone,
                numsChosen);
    }
}
