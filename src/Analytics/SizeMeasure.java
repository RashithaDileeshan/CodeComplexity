/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Kishara
 */
public class SizeMeasure {
    
    Controller controller = new Controller();
   
    
    int Cs,Wkw,Nkw,Wid,Nid,Wop,Nop,Wnv,Nnv,Wsl,Nsl;
    boolean flag = false;
    ArrayList<String> var = new ArrayList<>();
    ArrayList<String> returnValues = new ArrayList<>();
    String [] keywordArray = controller.getKeywords();
    String [] OperatorArray = controller.getLogical();
    
    
    public ArrayList<String> SizeComplexityInitializer(String filepath) throws IOException, Exception
    {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        
        String CurrentLine,line;
		while((line = br.readLine())!= null)
                {
                    
                    CurrentLine=line;
//                    
                    findToken(CurrentLine,1);
//                    
                }
                
                returnValues.add(Integer.toString(Wkw));
                returnValues.add(Integer.toString(Nkw));
                returnValues.add(Integer.toString(Wid));
                returnValues.add(Integer.toString(Nid));
                returnValues.add(Integer.toString(Wop));
                returnValues.add(Integer.toString(Nop));
                returnValues.add(Integer.toString(Wnv));
                returnValues.add(Integer.toString(Nnv));
                returnValues.add(Integer.toString(Wsl));
                returnValues.add(Integer.toString(Nsl));
                
                return returnValues;
    }
    
    public void findToken(String Currtinline, int val)
    {
        
            String [] crrline = Currtinline.split(" ");
            StringTokenizer token = new StringTokenizer(Currtinline);
            
            while(token.hasMoreTokens())
            {
                String word = token.nextToken();
                for(int j = 0; j < keywordArray.length; j++)
                {
                    if(word.equals(keywordArray[j]))
                    {
                        Wkw++;
                        Nkw++;
                    }
                }
                if(word.equals("class"))
                {
                    Wid++;
                    Nid++;
                }

                
                for (String OperatorArray1 : OperatorArray) 
                {
                    if (word.equals(OperatorArray1)) {
                        Wop++;
                        Nop++;
                    }
                }
                
                if(word.equals("[0-9]*"))
                {
                    Wnv++;
                    Nnv++;
                }
                
                if(word.equals("String"))
                {
                    Wsl++;
                    Nsl++;
                }

            }
        
    }
}
