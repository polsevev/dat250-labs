package no.hvl.dat250.jpa.assignment2;

import org.eclipse.persistence.internal.oxm.schema.model.List;

import javax.persistence.*;
import java.util.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String street;


    private int number;


    @ManyToMany
    private Set<Person> owners;

    public Address() {
        owners = new HashSet<>();
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        // TODO: implement method!
        return street;
    }
    public void addPerson(Person per){
        owners.add(per);
    }

    public int getNumber() {
        // TODO: implement method!
        return number;
    }

    public Collection<Person> getOwners() {
        // TODO: implement method!
        return owners;
    }
}
