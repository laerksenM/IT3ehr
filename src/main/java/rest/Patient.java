package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {
    public String firstName;
    public String lastName;
    public String CPR;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCPR() {
        return CPR;
    }


    public void setFirstNameName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

}
