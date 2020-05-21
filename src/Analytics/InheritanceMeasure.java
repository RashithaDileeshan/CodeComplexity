
package Analytics;

import Model.InheritanceModel;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InheritanceMeasure {
    
    ArrayList<String> lst = new ArrayList<>();
    String[] words;

    public ArrayList InheritanceAnalyzer(String[] str) {
        ArrayList<InheritanceModel> returnValues = new ArrayList<>();
        int inheritanceCount = 0;
        int inheritanceCount1 = 0;

        for (int i = 0; i < str.length; i++) {
            lst.add(str[i]);
        }
        for (String line : lst) {
            InheritanceModel inheritanceModel = new InheritanceModel();
            words = line.split(" ");
            StringTokenizer token = new StringTokenizer(line);
            
            while (token.hasMoreTokens()) {
                String previostoken = null;
                if (token.nextToken().equals("implements")) {
                    previostoken = token.nextToken();
                    inheritanceCount++;
                }
            }
            inheritanceModel.setLine(line);
            inheritanceModel.setci(inheritanceCount);
            returnValues.add(inheritanceModel);

            inheritanceCount1 = inheritanceCount;
            inheritanceCount = 0;
        }
        return returnValues;
    } 
}
