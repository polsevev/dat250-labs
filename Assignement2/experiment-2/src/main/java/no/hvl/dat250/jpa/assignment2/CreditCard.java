package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int number;

    private int balance;

    private int limit;

    @OneToOne
    private Pincode pincode;

    @ManyToOne
    private Bank bank;


    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public int getNumber() {
        // TODO: implement method!
        return number;
    }

    public int getBalance() {
        // TODO: implement method!
        return balance;
    }

    public int getLimit() {
        // TODO: implement method!
        return limit;
    }

    public Pincode getPincode() {
        // TODO: implement method!
        return pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return bank;
    }
}
