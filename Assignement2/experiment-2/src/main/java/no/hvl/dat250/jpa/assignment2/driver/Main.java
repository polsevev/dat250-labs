package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // TODO: Persist object world corresponding to the domain model of experiment 2.

        EntityTransaction tx = em.getTransaction();
        Person person = new Person();
        person.setName("Max Mustermann");
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        address.addPerson(person);

        ArrayList<Address> adresses = new ArrayList<>();
        adresses.add(address);
        person.addAddress(address);
        Bank bank = new Bank();
        bank.setName("Pengebank");

        Pincode pin = new Pincode();
        pin.setPincode("123");
        pin.setCount(1);


        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBank(bank);
        card1.setPincode(pin);
        card1.setLimit(-10000);
        card1.setBalance(-5000);


        CreditCard card2 = new CreditCard();
        card2.setBank(bank);
        card2.setPincode(pin);
        card2.setLimit(2000);
        card2.setBalance(1);
        card2.setNumber(123);

        person.addCreditCard(card1);
        person.addCreditCard(card2);
        bank.addCreditcard(card1);
        bank.addCreditcard(card2);

        tx.begin();
        em.persist(pin);
        em.persist(bank);
        em.persist(card1);
        em.persist(card2);
        em.persist(person);
        em.persist(address);
        tx.commit();


        em.close();
        factory.close();


    }
}
