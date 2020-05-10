/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dakshika
 */
public class InheritanceModel {

    String line;
    int ci;

    public InheritanceModel() {
    }

    public InheritanceModel(String line, int ci) {
        this.line = line;
        this.ci = ci;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getci() {
        return ci;
    }

    public void setci(int ci) {
        this.ci = ci;
    }
}
