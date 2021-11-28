package rest;

public class Konsultationer {

    public Konsultationer(String cpr, String timeStart, String timeEnd, String notat) {
        this.cpr = cpr;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.notat = notat;
    }

    private String cpr;
    private String timeStart;
    private String timeEnd;
    private String notat;

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getNotat() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }

    public String getCPR() {
        return cpr;
    }

    public void setCPR(String cpr) {
        this.cpr = cpr;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
}

