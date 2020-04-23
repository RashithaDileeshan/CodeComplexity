
package Reading;

import Coupling.CustomFile;


import Coupling.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReadServiceImpl implements FileReadService{
    
        @Override
	public void openFile(FileRead file, CustomFile fileobj) {
		try{
                    System.out.println(fileobj.getFilePath()+file.getFileName());
			file.setScanner(new Scanner(new File(fileobj.getFilePath() /*+ file.getFileName()*/))); 
        }catch(Exception e){
            System.out.println("Couldn't find the file."+file.getFileName());
        }
	}

	@Override
	public void readFile(FileRead file, CustomFile fileobj) {
		int count=1;
		ArrayList<Line> lineSet = new ArrayList<Line>();
		while(file.getScanner().hasNext()){
			Line line = new Line(count, file.getScanner().nextLine());
			lineSet.add(line);
			count++;
        }
		fileobj.setLineSet(lineSet);
		fileobj.setLastIndex(lineSet.size());
	}

	@Override
	public void closeFile(FileRead file) {
		file.getScanner().close();
	}
    
}
