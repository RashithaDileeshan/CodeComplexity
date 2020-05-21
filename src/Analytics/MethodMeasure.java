package Analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MethodMeasure {

    ArrayList<String> returnValues = new ArrayList<>();
    Controller controller = new Controller();
    String[] AccessLvels = controller.getAccessLevels();
    String[] PrimitiveTypes = controller.getPrimitiveDataTypes();
    int Cm, Wmrt, Wpdtp, Npdtp, Wcdtp, Ncdtp;

    public ArrayList<String> MethodComplexityInitializer(String filepath) throws FileNotFoundException, IOException {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        String CurrentLine, line;

        while ((line = br.readLine()) != null) {
            CurrentLine = line;
            findToken(CurrentLine, 1);
        }
        returnValues.add(Integer.toString(Wmrt));
        returnValues.add(Integer.toString(Wpdtp));
        returnValues.add(Integer.toString(Npdtp));
        returnValues.add(Integer.toString(Wcdtp));
        returnValues.add(Integer.toString(Ncdtp));

        return returnValues;
    }

    public void findToken(String Currentline, int i) {
        StringTokenizer token = new StringTokenizer(Currentline);

        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            for (String AccessLvel : AccessLvels) {
                for (String Primitive : PrimitiveTypes) {
                    if (Primitive.equals("void")) {
                        Wmrt = Wmrt + 0;
                    } else if (word.equals(Primitive)) {
                        Wmrt++;
                        Npdtp++;
                    } else {
                        Wcdtp++;
                        Ncdtp++;
                    }
                }
            }
        }
    }
}
