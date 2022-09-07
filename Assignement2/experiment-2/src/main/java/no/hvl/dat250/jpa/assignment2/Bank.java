package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToMany
    private Set<CreditCard> creditCards;


    public Bank() {
        creditCards = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addCreditcard(CreditCard card){
        this.creditCards.add(card);
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        // TODO: implement method!
        return name;
    }

    public Set<CreditCard> getOwnedCards() {
        return creditCards;
    }
}
