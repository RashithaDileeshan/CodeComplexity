package Analytics;

import Model.SizeModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SizeMeasure {

    Controller controller = new Controller();
    int Cs, Wkw, Nkw, Wid, Nid, Wop, Nop, Wnv, Nnv, Wsl, Nsl;
    boolean flag = false;
    boolean numeric = true;
    ArrayList<String> var = new ArrayList<>();
    ArrayList<SizeModel> returnValues = new ArrayList<>();
    String[] keywordArray = controller.getKeywords();
    String[] ArithmeticOperatorArray = controller.getArithmatic();
    String[] RelationOperatorArray = controller.getRelation();
    String[] LogicalOperatorArray = controller.getLogical();
    String[] BitwiseOperatorArray = controller.getBitwise();
    String[] MiscellaneousOperatorArray = controller.getMiscellaneous();
    String[] AssignmentsOperatorArray = controller.getAssignment();

    public ArrayList SizeComplexityInitializer(String filepath) throws IOException, Exception {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        String CurrentLine, line;

        while ((line = br.readLine()) != null) {
            CurrentLine = line;
            findToken(CurrentLine, 1);
            SizeModel sizeModel = new SizeModel();

            sizeModel.setLine(CurrentLine);
            sizeModel.setWkw(Wkw);
            sizeModel.setNkw(Nkw);
            sizeModel.setWid(Wid);
            sizeModel.setNid(Nid);
            sizeModel.setWop(Wop);
            sizeModel.setNop(Nop);
            sizeModel.setWnv(Wnv);
            sizeModel.setNnv(Nnv);
            sizeModel.setWsl(Wsl);
            sizeModel.setNsl(Nsl);
            sizeModel.setCs(Cs);

            returnValues.add(sizeModel);

            this.Wkw = 0;
            this.Nkw = 0;
            this.Wid = 0;
            this.Nid = 0;
            this.Wop = 0;
            this.Nop = 0;
            this.Wnv = 0;
            this.Nnv = 0;
            this.Wsl = 0;
            this.Nsl = 0;
        }
        for (int i = 0; i < returnValues.size(); i++) {
            SizeModel sizeMode2 = new SizeModel();
            sizeMode2 = returnValues.get(i);
        }
        return returnValues;
    }

    public void findToken(String Currtinline, int val) {

        String[] crrline = Currtinline.split(" ");

        String patternForComment = "\\/\\*[\\s\\S]*?\\*\\/|([^:]|^)\\/\\/.*$";
        String numericalRegex = "(?:\\b|-)([0-9]{1,2}[0]?|900)\\b";
        Currtinline = Currtinline.trim().replaceAll("[(]", " abcdefg ");
        Currtinline = Currtinline.trim().replaceAll("[)]", " hijklm ");
        Currtinline = Currtinline.trim().replaceAll("[;]", " nopqrst ");
        Currtinline = Currtinline.trim().replaceAll("[{]", " uvwxyz ");
        Currtinline = Currtinline.trim().replaceAll("[.]", " . ");
        Currtinline = Currtinline.trim().replaceAll("[,]", " , ");
        Currtinline = Currtinline.trim().replaceAll("[']", " ' ");
        Currtinline = Currtinline.trim().replaceAll("[%]", " % ");
        Currtinline = Currtinline.trim().replaceAll("[:]", " : ");
        Currtinline = Currtinline.trim().replaceAll("^\\:{2}$", " :: ");
        Currtinline = Currtinline.trim().replaceAll("[++]", " ++ ");

        StringTokenizer token = new StringTokenizer(Currtinline);

        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            if (Currtinline.toUpperCase().startsWith("IMPORT") || Currtinline.matches("^\\/\\/[^\\n\\r]+(?:[\\n\\r]|\\*\\))$")) {
                continue;
            }
            for (int j = 0; j < keywordArray.length; j++) {
                if (word.equals(keywordArray[j])) {
                    Wkw++;
                    Nkw++;
                }
            }
            word = word.replace("abcdefg", "(");
            word = word.replace("hijklm", ")");
            word = word.replace("nopqrst", ";");
            word = word.replace("uvwxyz", "{");

            if (word.endsWith("(") || word.equals("class") || word.endsWith(" =") || word.endsWith("=") || word.endsWith(";")) {
                Wid++;
                Nid++;
            }
            //Arithmetic Operators
            for (String OperatorArray1 : ArithmeticOperatorArray) {
                if (word.equals(OperatorArray1)) {
                    Wop++;
                    Nop++;
                }
            }
            //Relation Operators
            for (String OperatorArray2 : RelationOperatorArray) {
                if (word.equals(OperatorArray2)) {
                    Wop++;
                    Nop++;
                }
            }
            //Logical Operators
            for (String OperatorArray3 : LogicalOperatorArray) {
                if (word.equals(OperatorArray3)) {
                    Wop++;
                    Nop++;
                }
            }
            //Bitwise Operators
            for (String OperatorArray4 : BitwiseOperatorArray) {
                if (word.equals(OperatorArray4)) {
                    Wop++;
                    Nop++;
                }
            }
            //Miscellaneous Operators
            for (String OperatorArray5 : MiscellaneousOperatorArray) {
                if (word.equals(OperatorArray5)) {
                    Wop++;
                    Nop++;
                }
            }
            //Assignments Operators
            for (String OperatorArray6 : AssignmentsOperatorArray) {
                if (word.equals(OperatorArray6)) {
                    Wop++;
                    Nop++;
                }
            }
            try {
                int num = Integer.parseInt(word);
                Wnv++;
                Nnv++;
            } catch (NumberFormatException e) {
                numeric = false;
            }
        }

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(Currtinline);
        while (m.find()) {
            if (m.groupCount() == 1) {
                Nsl++;
                Wsl++;
            } else {
                Nsl = Nsl;
                Wsl = Wsl;
            }
        }
        Cs = Nkw + Nid + Nop + Nnv + Nsl;
    }
}
