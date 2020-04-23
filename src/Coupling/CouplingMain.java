package Coupling;

import Coupling.CouplingService;
import Coupling.CouplingServiceImp;
import Coupling.FileReadService;
import Coupling.FileReadServiceImp;
import Coupling.CustomFile;
import Coupling.FileRead;
import java.util.ArrayList;



public class CouplingMain {

    
    ArrayList<String> returenValues = new ArrayList<>();
	private ArrayList<CustomFile> fileList = new ArrayList<>();
	private String fileType = "java";
	public static String WEBCONTENTDIR = "git/CodeComplexityCalculator/CCC/WebContent/";

	public ArrayList<CustomFile> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<CustomFile> lst) {
		this.fileList = lst;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void Start() {


		CouplingService couplingService = new CouplingServiceImp();

		for (CustomFile file : this.fileList) {

			if (!(file.getFileName().contains("java") || file.getFileName().contains("cpp"))) {
				System.out.println("Wrong file type");
			} else {

try {
					if (file.getFileName().contains("java")) {
						fileType = "java";
					} else {
						fileType = "cpp";
					}
					file.setFileType(fileType);
					FileRead fileRead = new FileRead(file.getFileName());
					FileReadService fileReadService = new FileReadServiceImp();

					fileReadService.openFile(fileRead, file);
					fileReadService.readFile(fileRead, file);
					fileReadService.closeFile(fileRead);

					couplingService.process1(file);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
                
                                
                     returenValues.add(Integer.toString(file.getCoupling().getWr()));
                     returenValues.add(Integer.toString(file.getCoupling().getNr()));
                     returenValues.add(Integer.toString(file.getCoupling().getWmcms()));
                     returenValues.add(Integer.toString(file.getCoupling().getNmcms()));
                     returenValues.add(Integer.toString(file.getCoupling().getWmcmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getNmcmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getWmcrms()));
                     returenValues.add(Integer.toString(file.getCoupling().getNmcrms()));
                     returenValues.add(Integer.toString(file.getCoupling().getWmcrmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getNmcrmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getWrmcrms()));
                     returenValues.add(Integer.toString(file.getCoupling().getNrmcrms()));
                     returenValues.add(Integer.toString(file.getCoupling().getWrmcrmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getNrmcrmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getWrmcms()));
                     returenValues.add(Integer.toString(file.getCoupling().getNrmcms()));
                     returenValues.add(Integer.toString(file.getCoupling().getWrmcmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getNrmcmd()));
                     returenValues.add(Integer.toString(file.getCoupling().getWmrgvs()));
                     returenValues.add(Integer.toString(file.getCoupling().getNmrgvs()));
                     returenValues.add(Integer.toString(file.getCoupling().getWmrgvd()));
                     returenValues.add(Integer.toString(file.getCoupling().getNmrgvd()));
                     returenValues.add(Integer.toString(file.getCoupling().getWrmrgvs()));
                     returenValues.add(Integer.toString(file.getCoupling().getNrmrgvs()));
                     returenValues.add(Integer.toString(file.getCoupling().getWrmrgvd()));
                     returenValues.add(Integer.toString(file.getCoupling().getNrmrgvd()));
                     
                     
			}
		}
		if (this.fileList.size() > 1) {
			couplingService.process2(this.fileList);
		}
	}
        
        public ArrayList<String> getCouplingResults()
        {
            return returenValues;
        }

}
