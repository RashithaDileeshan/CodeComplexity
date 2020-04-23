/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analytics;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class InheritanceMeasure {
    
     String [] words;
     ArrayList<String> lst = new ArrayList<>();
    
     public int InheritanceAnalyzer(String [] str)
    {
        int inheritanceCount = 0;
        
        for(int i=0; i<str.length; i++)
        {
            lst.add(str[i]);
        }
        
        for(String line : lst)
        {
            words = line.split(" ");
            
            StringTokenizer token = new StringTokenizer(line);
            
            while(token.hasMoreTokens())
            {
                String previostoken = null;
                
                if(token.nextToken().equals("extends"))
                {
                    previostoken = token.nextToken();
                    inheritanceCount++;
                }
            }
        }
        
        return inheritanceCount;
        
        
    }
    
}
