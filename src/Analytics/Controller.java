package Analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Controller {

    String[] strArr;
    String[] words;
    String[] arithmatic = {"+", "-", "*", "/", "%", "++", "--"};
    String[] relation = {"==", "!=", ">", "<", ">=", "<="};
    String[] logical = {"&&", "||", "!"};
    String[] bitwise = {"|", "^", "~", "<<", ">>", ">>>", "<<<"};
    String[] miscellaneous = {",", "->", ".", "::"};
    String[] assignment = {"+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^="};

    String[] manipulators = {"endl", "\n"};
    String[] text = {"System.out.println();"};
    String[] keywords = {"abstract", "assert", "catch", "class", "final", "finally", "instanceof", "interface", "native", "new", "null",
        "package ", "private", "protected", "public", "return", "static", "strictfp", "super", "synchronized", "this", "throw", "throws", "transient",
        "try", "void", "volatile", "extends", "implements", "else", "break"};
    String[] controlStucts = {"if", "else if", "else", "for", "switch", "case", "while", "do"};

    String[] primitiveDataTypes = {"byte", "char", "short", "int", "long", "float", "double", "boolean", "void"};
    String[] compositeDataTypes = {"String", "ArrayList"};
    String[] AccessLevels = {"public", "private", "protected", "abtract"};
    String[] Ignore = {"change", "this", "choose", "Project", "Properties.", "To", "template", "templates", "package",
        "Interfaces", "import", "java.awt.Color;", "java.io.BufferedReader;", "java.io.File;", "java.io.FileNotFoundException;",
        "Exception", "java.io.FileReader;", "java.util.ArrayList;", "Code\">//GEN-BEGIN:initComponents", "initComponents",
        "javax.swing.JCheckBox();", "javax.swing.JCheckBox();", "setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);"};
    String[][] options = {logical, arithmatic, relation, bitwise, miscellaneous, assignment, keywords, manipulators, text};
    ArrayList<String> operators = new ArrayList<>();
    String[] otherKeyWords = {"printf", "println", "cout", "cin", "if", "for", "while", "do-while", "switch", "case", "System", "out"};
    ArrayList<String> lst = new ArrayList<>();
    Map<String, Integer> primitiveMap = new HashMap<>();
    Map<String, Integer> compositeMap = new HashMap<>();
    String regex = "\\\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b";

    public Controller() {
        primitiveMap.put("void", 0);
        primitiveMap.put("byte", 1);
        primitiveMap.put("char", 1);
        primitiveMap.put("short", 1);
        primitiveMap.put("int", 1);
        primitiveMap.put("long", 1);
        primitiveMap.put("float", 1);
        primitiveMap.put("double", 1);
        primitiveMap.put("boolean", 1);
        compositeMap.put("String", 2);
        compositeMap.put("ArrayList", 2);
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String[] getCompositeDataTypes() {
        return compositeDataTypes;
    }

    public void setCompositeDataTypes(String[] compositeDataTypes) {
        this.compositeDataTypes = compositeDataTypes;
    }

    public Map<String, Integer> getPrimitiveMap() {
        return primitiveMap;
    }

    public void setPrimitiveMap(Map<String, Integer> primitiveMap) {
        this.primitiveMap = primitiveMap;
    }

    public Map<String, Integer> getCompositeMap() {
        return compositeMap;
    }

    public void setCompositeMap(Map<String, Integer> compositeMap) {
        this.compositeMap = compositeMap;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }

    public String[] getControlStucts() {
        return controlStucts;
    }

    public void setControlStucts(String[] controlStucts) {
        this.controlStucts = controlStucts;
    }

    public String[] getIgnore() {
        return Ignore;
    }

    public void setIgnore(String[] Ignore) {
        this.Ignore = Ignore;
    }

    public String[] getAccessLevels() {
        return AccessLevels;
    }

    public void setAccessLevels(String[] AccessLevels) {
        this.AccessLevels = AccessLevels;
    }

    public String[] getPrimitiveDataTypes() {
        return primitiveDataTypes;
    }

    public void setPrimitiveDataTypes(String[] primitiveDataTypes) {
        this.primitiveDataTypes = primitiveDataTypes;
    }

    public String[] getOtherKeyWords() {
        return otherKeyWords;
    }

    public void setOtherKeyWords(String[] otherKeyWords) {
        this.otherKeyWords = otherKeyWords;
    }

    public String[] getStrArr() {
        return strArr;
    }

    public void setStrArr(String[] strArr) {
        this.strArr = strArr;
    }

    public String[] getArithmatic() {
        return arithmatic;
    }

    public void setArithmatic(String[] arithmatic) {
        this.arithmatic = arithmatic;
    }

    public String[] getLogical() {
        return logical;
    }

    public void setLogical(String[] logical) {
        this.logical = logical;
    }

    public String[] getRelation() {
        return relation;
    }

    public void setRelation(String[] relation) {
        this.relation = relation;
    }

    public String[] getBitwise() {
        return bitwise;
    }

    public void setBitwise(String[] bitwise) {
        this.bitwise = bitwise;
    }

    public String[] getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(String[] miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public String[] getAssignment() {
        return assignment;
    }

    public void setAssignment(String[] assignment) {
        this.assignment = assignment;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getManipulators() {
        return manipulators;
    }

    public void setManipulators(String[] manipulators) {
        this.manipulators = manipulators;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public String[][] getOptions() {
        return options;
    }

    public void setOptions(String[][] options) {
        this.options = options;
    }

    public int CodeAnalyzer(String[] str) {
        int complexity = 0;
        for (int i = 0; i < options.length; i++) {
            String[] array = options[i];
            for (int j = 0; j < strArr.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (array[k].equals(strArr[j]) || strArr[j].contains(array[k])) {
                        ++complexity;
                    }
                }
            }
        }
        return complexity;
    }

    public int KeyWordAnalyzer(String[] str) {
        int KeyWordCount = 0;
        ArrayList<String> keywordLst = new ArrayList<>();
        String array[] = keywords;
        for (int i = 0; i < str.length; i++) {
            keywordLst.add(str[i]);
        }
        for (String line : keywordLst) {
            StringTokenizer keywordtoken = new StringTokenizer(line);

            while (keywordtoken.hasMoreTokens()) {
                String word = keywordtoken.nextToken();
                for (int j = 0; j < array.length; j++) {
                    if (word.equals(array[j])) {
                    }
                }
            }
        }
        return KeyWordCount;
    }

    public void addOperatorsToArray() {
        for (int i = 0; i < this.arithmatic.length; i++) {
            operators.add(arithmatic[i]);
        }
        for (int i = 0; i < this.relation.length; i++) {
            operators.add(relation[i]);
        }
        for (int i = 0; i < this.logical.length; i++) {
            operators.add(logical[i]);
        }
        for (int i = 0; i < this.bitwise.length; i++) {
            operators.add(bitwise[i]);
        }
        for (int i = 0; i < this.miscellaneous.length; i++) {
            operators.add(miscellaneous[i]);
        }
        for (int i = 0; i < this.assignment.length; i++) {
            operators.add(assignment[i]);
        }

    }
}
