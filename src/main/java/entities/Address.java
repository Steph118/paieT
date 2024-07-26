package entities;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * @author samiesoft
 */
@Embeddable
@Access(AccessType.FIELD)
public class Address {

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "zip")
    private String zip;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return house;
    }

    public void setCity(String city) {
        this.house = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + house + ", zip=" + zip + '}';
    }

}
