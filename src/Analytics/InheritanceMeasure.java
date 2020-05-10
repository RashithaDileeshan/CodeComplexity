
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
//                    System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>lllll" + str );

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
//            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>" + line + "  " + "count" + " " + inheritanceCount);

            inheritanceCount1 = inheritanceCount;
            inheritanceCount = 0;

        }

//        for (int i = 0; i < returnValues.size(); i++) {
//            InheritanceModel inheritanceMode2 = new InheritanceModel();
//            inheritanceMode2 = returnValues.get(i);
//
//            System.out.println(" =====***======== ==========***====== ");
//            System.out.println("getLineAnswer:-- " + inheritanceMode2.getLine());
//            System.out.println("getCiAnswer:-- " + inheritanceMode2.getci());
//        }

        return returnValues;

    }

    
}
