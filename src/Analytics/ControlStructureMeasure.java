package Analytics;

import Model.ControlStructureModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControlStructureMeasure {

    ArrayList<ControlStructureModel> returnValues = new ArrayList<>();
    Controller ctrl = new Controller();

    int Wtcs, NC, Ccspps;
    int Wtcs1, NC1, Ccspps1;
    int Ccs, Ccs1;
    int CcsppsCase;
    String[] controlStructs = ctrl.getControlStucts();

    public ControlStructureMeasure() {
    }

    public ArrayList ControlComplexityInitializer(String filepath) throws FileNotFoundException, IOException {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        String CurrentLine, line;

        while ((line = br.readLine()) != null) {
            ControlStructureModel csm = new ControlStructureModel();

            CurrentLine = line;
            findToken(CurrentLine, 1);

            this.Ccs = this.Wtcs * this.NC + this.Ccspps;

            csm.setLine(CurrentLine);
            csm.setWtcs(Integer.toString(Wtcs));
            csm.setNC(Integer.toString(NC));
            csm.setCcspps(Integer.toString(Ccspps));
            csm.setCcs(Integer.toString(Ccs));

            returnValues.add(csm);

            this.Wtcs1 = this.Wtcs1 + this.Wtcs;
            this.NC1 = this.NC1 + this.NC;
            this.Ccspps1 = this.Ccspps1 + this.Ccspps;

            this.Wtcs = 0;
            this.NC = 0;
            this.Ccspps = 0;
        }
        this.Ccs1 = this.Wtcs1 * this.NC1 + this.Ccspps1;
        return returnValues;
    }

    public void findToken(String CurrentLine, int i) {
        StringTokenizer token = new StringTokenizer(CurrentLine);

        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            for (String controlStruct : controlStructs) {
                if (word.equals(controlStruct)) {
                    if ((word.equals("if")) || (word.equals("else"))) {
                        Wtcs = Wtcs + 2;
                        NC++;
                    } else if ((word.equals("if")) && (word.equals("&&"))) {
                        Wtcs = Wtcs + 2;
                        NC = NC + 2;
                    } else if ((word.equals("for")) || (word.equals("while")) || (word.equals("do"))) {
                        Wtcs = Wtcs + 3;
                        NC++;
                    } else if (word.equals("switch")) {
                        Wtcs = Wtcs + 2;
                        NC++;
                    } else if (word.equals(("case"))) {
                        if (Ccspps == 0) {
                            Ccspps = this.CcsppsCase;
                        }
                        Wtcs = Wtcs + 1;
                        NC++;
                    }
                    if (Ccs != 0) {
                        Ccspps = this.Ccs;
                        this.CcsppsCase = Ccspps;
                    }
                }
            }
        }
    }
}
