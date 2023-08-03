package csci318.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    // Build a one-to-one relationship between library and address.
    // other relationships: @ManyToOne, @OneToMany
    // CascadeType.PERSIST: save() or persist() operations cascade to related entities.
    // Reference of CascadeType:
    // https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    @JsonIgnore
    // Hide the address field in a library.
    // This prevents an infinite nesting references of library and address.
    private Address address;

    public Library() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}