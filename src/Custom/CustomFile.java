/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Custom;

import java.util.ArrayList;

/**
 *
 * @author Kishara
 */
public class CustomFile {
    
        private String fileName;
	private String filePath;
	private int lastIndex;
	private ArrayList<Line> lineSet;
	
	
	public CustomFile(String fileName) {
		this.fileName = fileName;
		this.lineSet = null;	
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public void setLineSet(ArrayList<Line> lineSet) {
		this.lineSet = new ArrayList<Line>(lineSet);
	}
	
	public ArrayList<Line> getLineSet(){
		return lineSet;
	}

	

}
