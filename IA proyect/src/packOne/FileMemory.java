package packOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

public class FileMemory {
	private File file;
	
	public FileMemory(String url, String txtName) {
		this.file= new File(url+"/"+txtName+".txt");
	}
	
	public void createFile() {
		if(this.file.exists()!=true) {
			try {
				this.file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("The file already exist");
		}
	}
	
	public void writeFile(String key,String text) {
		try {
			String allText=key+text;
			FileWriter writeFile= new FileWriter(this.file);
			System.out.println(key+" : "+text);
			writeFile.write(allText);
			writeFile.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*public void reader(){
		try {
			FileReader fileOpen= new FileReader(this.file);
			BufferedReader fileReader= new BufferedReader(fileOpen);
			int i=0;
			String textLine="";
			while((textLine=fileReader.readLine())!=null) {
				System.out.println(textLine);
				i++;
			}
			fileOpen.close();
			if(null !=fileOpen) {
				fileOpen.close();
			}
		}catch(Exception e) {
			System.out.println("cannot read the file");
		}
	}*/
}
