package Model;

public class Member {
    String name;
    String ID;
    String PW;
    Member(String ID, String PW, String name) {
        this.name = name;
        this.ID = ID;
        this.PW = PW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }
}
