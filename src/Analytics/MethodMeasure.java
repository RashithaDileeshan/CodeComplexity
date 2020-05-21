package Analytics;

import Model.MethodModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodMeasure {

    int Cm, Wmrt, Wpdtp, Npdtp, Wcdtp, Ncdtp;
    ArrayList<MethodModel> returnValues = new ArrayList<>();
    Controller controller = new Controller();
    Map<String, Integer> primitiveMap = controller.getPrimitiveMap();
    Map<String, Integer> compositeMap = controller.getCompositeMap();
    String[] primitiveTypes = controller.getPrimitiveDataTypes();
    Stack<String> primitiveStack1 = new Stack<>();
    Stack<String> primitiveStack2 = new Stack<>();
    Stack<String> compositeStack1 = new Stack<>();
    Stack<String> compositeStack2 = new Stack<>();
    int count = 0;
    int index = 1;
    String primitiveTypeSingle;

    public ArrayList<MethodModel> MethodComplexityInitializer(String filepath) throws FileNotFoundException, IOException {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        String CurrentLine, line;

        while ((line = br.readLine()) != null) {
            if (line.toUpperCase().startsWith(" CLASS") || line.toUpperCase().startsWith("CLASS")) {
                if (line.endsWith("{") || line.endsWith("{ ")) {
                    continue;
                }
            }
            if (line.contains("<") && line.contains(">")) {
                line = line.trim().replaceAll("[<]", " abcdefg ");
                line = line.trim().replaceAll("[>]", " hijklmn ");
            }
            if (line.toUpperCase().startsWith("IMPORT")) {
                continue;
            }
            if (line.startsWith(" }")) {
                continue;
            }
            if (line.contains("int")) {
                if (line.contains("=")) {
                    continue;
                }
            }
            String[] splittedLine = line.split(" ");

            for (String primitiveElement : splittedLine) {

                if (primitiveElement.contains("(")) {
                    primitiveStack2.push("(");
                }
                if (!primitiveElement.isEmpty() && primitiveElement.contains(")")) {

                    primitiveStack2.pop();
                }
                if (primitiveElement.contains("{")) {

                    primitiveStack1.push("{");
                }
                if (!primitiveElement.isEmpty() && primitiveElement.contains("}")) {

                    primitiveStack1.pop();
                }
                if (primitiveStack1.isEmpty() && primitiveStack2.isEmpty() && primitiveMap.containsKey(primitiveElement)) {
                    Wmrt += primitiveMap.get(primitiveElement);
                }
            }
            for (String compositeElement : splittedLine) {

                if (compositeElement.contains("(")) {
                    compositeStack2.push("(");
                }
                if (!compositeElement.isEmpty() && compositeElement.contains(")")) {

                    compositeStack2.pop();
                }
                if (compositeElement.contains("{")) {

                    compositeStack1.push("{");
                }
                if (!compositeElement.isEmpty() && compositeElement.contains("}")) {

                    compositeStack1.pop();
                }
                if (compositeStack1.isEmpty() && compositeStack2.isEmpty() && compositeMap.containsKey(compositeElement)) {
                    Wmrt += compositeMap.get(compositeElement);
                }
            }

            if (line.contains("(") && line.contains(")") && line.contains("{")) {
                Matcher m = Pattern.compile("\\((.*?)\\)").matcher(line);
                while (m.find()) {
                    if (line.contains("()")) {
                        continue;
                    }
                    if (m.group().contains("byte") || m.group().contains("char") || m.group().contains("short") || m.group().contains("int") || m.group().contains("long") || m.group().contains("float") || m.group().contains("double") || m.group().contains("boolean")) {
                        String[] splittedVariables = m.group().split(",");
                        for (String variable : splittedVariables) {
                            Npdtp++;
                            Wpdtp++;
                        }
                    }
                }
            }
            if (line.contains("(") && line.contains(")") && line.contains("{")) {
                Matcher m = Pattern.compile("\\((.*?)\\)").matcher(line);
                while (m.find()) {
                    if (line.contains("()")) {
                        continue;
                    }
                    if (m.group().contains("String") || m.group().contains("ArrayList")) {
                        String[] splittedVariables = m.group().split(",");
                        for (String variable : splittedVariables) {
                            Ncdtp++;
                            Wcdtp++;
                        }
                    }
                }
            }

            Wmrt = Wmrt;
            Cm = Wmrt + (1 * Npdtp) + (2 * Ncdtp);
            CurrentLine = line;

            MethodModel methodModel = new MethodModel();

            if (CurrentLine.contains(" abcdefg ") && CurrentLine.contains(" hijklmn ")) {
                CurrentLine = CurrentLine.replace(" abcdefg ", "<");
                CurrentLine = CurrentLine.replace(" hijklmn ", ">");
                System.out.println(CurrentLine);
            }
            methodModel.setLine(CurrentLine);
            methodModel.setWmrt(Wmrt);
            methodModel.setWpdtp(Wpdtp);
            methodModel.setNpdtp(Npdtp);
            methodModel.setWcdtp(Wcdtp);
            methodModel.setNcdtp(Ncdtp);
            methodModel.setCm(Cm);

            returnValues.add(methodModel);

            this.Wmrt = 0;
            this.Wpdtp = 0;
            this.Npdtp = 0;
            this.Wcdtp = 0;
            this.Ncdtp = 0;

        }
        for (int i = 0; i < returnValues.size(); i++) {
            MethodModel methodModel2 = new MethodModel();
            methodModel2 = returnValues.get(i);
        }
        return returnValues;

    }
}
