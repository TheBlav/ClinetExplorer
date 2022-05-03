package Data;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
   private int ID;
   private String firstName;
   private String lastName;
   private String country;
   private  double value;

    public Client(int ID, String firstName, String lastName, String country, double value) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ID + "; " + firstName + ", " + lastName + ", " + country + ", " + value + "zł";
    }
}
