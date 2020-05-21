package Model;

public class MethodModel {

    String line;
    int Wmrt;
    int Wpdtp;
    int Npdtp;
    int Wcdtp;
    int Ncdtp;
    int Cm;

    public MethodModel() {
    }

    public MethodModel(String line, int Wmrt, int Wpdtp, int Npdtp, int Wcdtp, int Ncdtp, int Cm) {
        this.line = line;
        this.Wmrt = Wmrt;
        this.Wpdtp = Wpdtp;
        this.Npdtp = Npdtp;
        this.Wcdtp = Wcdtp;
        this.Ncdtp = Ncdtp;
        this.Cm = Cm;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getWmrt() {
        return Wmrt;
    }

    public void setWmrt(int Wmrt) {
        this.Wmrt = Wmrt;
    }

    public int getWpdtp() {
        return Wpdtp;
    }

    public void setWpdtp(int Wpdtp) {
        this.Wpdtp = Wpdtp;
    }

    public int getNpdtp() {
        return Npdtp;
    }

    public void setNpdtp(int Npdtp) {
        this.Npdtp = Npdtp;
    }

    public int getWcdtp() {
        return Wcdtp;
    }

    public void setWcdtp(int Wcdtp) {
        this.Wcdtp = Wcdtp;
    }

    public int getNcdtp() {
        return Ncdtp;
    }

    public void setNcdtp(int Ncdtp) {
        this.Ncdtp = Ncdtp;
    }

    public int getCm() {
        return Cm;
    }

    public void setCm(int Cm) {
        this.Cm = Cm;
    }
}
