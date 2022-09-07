package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private Collection<Address> addresses;

    @OneToMany
    private Collection<CreditCard> creditCards;

    public Person() {
        creditCards = new ArrayList<>();
        addresses = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAddress(Address adr){
        addresses.add(adr);
    }

    public void addCreditCard(CreditCard card){
        creditCards.add(card);
    }

    public Collection<Address> getAddresses() {
        // TODO: implement method!
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        // TODO: implement method!
        return creditCards;
    }
}
