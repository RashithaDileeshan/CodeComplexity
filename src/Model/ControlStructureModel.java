package Model;

public class ControlStructureModel {

    String line;
    String wtcs;
    String NC;
    String Ccspps;
    String Ccs;

    public ControlStructureModel() {
    }

    public ControlStructureModel(String line, String wtcs, String NC, String ccspps, String ccs) {
        this.line = line;
        this.wtcs = wtcs;
        this.NC = NC;
        Ccspps = ccspps;
        Ccs = ccs;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getWtcs() {
        return wtcs;
    }

    public void setWtcs(String wtcs) {
        this.wtcs = wtcs;
    }

    public String getNC() {
        return NC;
    }

    public void setNC(String NC) {
        this.NC = NC;
    }

    public String getCcspps() {
        return Ccspps;
    }

    public void setCcspps(String ccspps) {
        Ccspps = ccspps;
    }

    public String getCcs() {
        return Ccs;
    }

    public void setCcs(String ccs) {
        Ccs = ccs;
    }

}
