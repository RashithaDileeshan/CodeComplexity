package Analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class VariableMeasure {

    ArrayList<String> returnValues = new ArrayList<>();
    Field[] fieldList;
    Method[] methodList;
    Controller controller = new Controller();
    String[] primitiveDataTypes = controller.getPrimitiveDataTypes();
    String[] ignoreElements = controller.getIgnore();
    int Wvs, Wpdtv, Npdtv, Wcdtv, Ncdtv;

    public ArrayList<String> VariableComplexityInitializer(String[] str) throws FileNotFoundException, IOException {
        String[] words;
        String regex = "\\\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\\\b";
        for (int i = 0; i < str.length; i++) {
            String sentence = str[i];
            words = sentence.split(" ");

            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < primitiveDataTypes.length; k++) {
                    if (words[j].equals(primitiveDataTypes[k])) {
                        Wvs++;
                        Wpdtv++;
                        Npdtv++;
                    } else if ((words[j] == null ? primitiveDataTypes[k] != null : !words[j].equals(primitiveDataTypes[k])) && (!regex.equals(words[j]))) {
                        for (int ig = 0; ig < ignoreElements.length; ig++) {
                            if (words[j].equals(ignoreElements[ig])) {
                                break;
                            } else {
                                Wcdtv = Wcdtv + 2;
                                Ncdtv++;
                            }
                        }
                    }
                }
            }
        }
        returnValues.add(Integer.toString(Wvs));
        returnValues.add(Integer.toString(Wpdtv));
        returnValues.add(Integer.toString(Npdtv));
        returnValues.add(Integer.toString(Wcdtv));
        returnValues.add(Integer.toString(Ncdtv));

        return returnValues;

    }
}
