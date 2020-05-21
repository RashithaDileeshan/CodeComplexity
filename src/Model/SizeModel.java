package Model;

public class SizeModel {

    String line;
    int Wkw;
    int Nkw;
    int Wid;
    int Nid;
    int Wop;
    int Nop;
    int Wnv;
    int Nnv;
    int Wsl;
    int Nsl;
    int Cs;

    public SizeModel() {
    }

    public SizeModel(String line, int Wkw, int Nkw, int Wid, int Nid, int Wop, int Nop, int Wnv, int Nnv, int Wsl, int Nsl, int Cs) {
        this.line = line;
        this.Wkw = Wkw;
        this.Nkw = Nkw;
        this.Wid = Wid;
        this.Nid = Nid;
        this.Wop = Wop;
        this.Nop = Nop;
        this.Wnv = Wnv;
        this.Nnv = Nnv;
        this.Wsl = Wsl;
        this.Nsl = Nsl;
        this.Cs = Cs;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getWkw() {
        return Wkw;
    }

    public void setWkw(int Wkw) {
        this.Wkw = Wkw;
    }

    public int getNkw() {
        return Nkw;
    }

    public void setNkw(int Nkw) {
        this.Nkw = Nkw;
    }

    public int getWid() {
        return Wid;
    }

    public void setWid(int Wid) {
        this.Wid = Wid;
    }

    public int getNid() {
        return Nid;
    }

    public void setNid(int Nid) {
        this.Nid = Nid;
    }

    public int getWop() {
        return Wop;
    }

    public void setWop(int Wop) {
        this.Wop = Wop;
    }

    public int getNop() {
        return Nop;
    }

    public void setNop(int Nop) {
        this.Nop = Nop;
    }

    public int getWnv() {
        return Wnv;
    }

    public void setWnv(int Wnv) {
        this.Wnv = Wnv;
    }

    public int getNnv() {
        return Nnv;
    }

    public void setNnv(int Nnv) {
        this.Nnv = Nnv;
    }

    public int getWsl() {
        return Wsl;
    }

    public void setWsl(int Wsl) {
        this.Wsl = Wsl;
    }

    public int getNsl() {
        return Nsl;
    }

    public void setNsl(int Nsl) {
        this.Nsl = Nsl;
    }

    public int getCs() {
        return Cs;
    }

    public void setCs(int Cs) {
        this.Cs = Cs;
    }

}
