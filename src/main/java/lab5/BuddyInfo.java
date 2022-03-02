package lab5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    private String name;
    private String phoneNumber;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public BuddyInfo() {
        this.name = "";
        this.phoneNumber = "";
    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "BuddyInfo[name=%s, phoneNumber='%s']",
                this.name, this.phoneNumber
        );
    }
}
