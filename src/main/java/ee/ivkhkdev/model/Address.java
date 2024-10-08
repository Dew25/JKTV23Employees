package ee.ivkhkdev.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Address implements Serializable {
    private UUID id;
    private String city;
    private String street;
    private String house;
    private String appartment;

    public Address() {
        this.id = UUID.randomUUID();
    }

    public Address(String city, String street, String house, String appartment) {
        this.id = UUID.randomUUID();
        this.city = city;
        this.street = street;
        this.house = house;
        this.appartment = appartment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house) && Objects.equals(appartment, address.appartment);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(house);
        result = 31 * result + Objects.hashCode(appartment);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", appartment='" + appartment + '\'' +
                '}';
    }
}
