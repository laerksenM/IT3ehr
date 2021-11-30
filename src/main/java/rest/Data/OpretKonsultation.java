package rest.Data;

//@XmlRootElement
public class OpretKonsultation {

    private String CPR;
    private String TimeStart;
    private String TimeEnd;
    private String Notat;
    private String KlinikID;

    public OpretKonsultation() {}

    public OpretKonsultation(String CPR, String TimeStart, String TimeEnd, String Notat, String KlinikID) {
        this.CPR = CPR;
        this.TimeStart = TimeStart;
        this.TimeEnd = TimeEnd;
        this.Notat = Notat;
        this.KlinikID = KlinikID;
    }


    public String getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(String TimeEnd) {
        this.TimeEnd = TimeEnd;
    }

    public String getNotat() {
        return Notat;
    }

    public void setNotat(String Notat) {
        this.Notat = Notat;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String TimeStart) {
        this.TimeStart = TimeStart;
    }

    public String getKlinikID() {
        return KlinikID;
    }

    public void setKlinikID(String KlinikID) {
        this.KlinikID = KlinikID;
    }

    public String toString() {
        return " CPR " + this.CPR + " TimeStart " + this.TimeStart + " TimeEnd " + this.TimeEnd + " Notat " + this.Notat + " KlinikID " + this.KlinikID;
    }
}
