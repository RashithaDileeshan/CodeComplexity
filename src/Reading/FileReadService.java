
package Reading;

import Coupling.CustomFile;



public interface FileReadService {
    
    	public void openFile(FileRead file, CustomFile fileobj);
	public void readFile(FileRead file, CustomFile fileobj);
	public void closeFile(FileRead file);
}
