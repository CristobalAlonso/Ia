package packOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ReeaderTxt {
	private File file;
	private String list[];
	
	public ReeaderTxt(String url, String txtName, int quantity) {
		this.file= new File(url+"/"+txtName);
		this.list= new String[quantity];
	}
	
	public void create() {
		if(!this.file.exists()) {
			try {
				this.file.createNewFile();
				FileWriter openFile= new FileWriter(this.file.getAbsolutePath());
				PrintWriter writeFile= new PrintWriter(openFile);
				writeFile.println("Install_mods");
				writeFile.println("false");
				writeFile.println("Install_Texture packs");
				writeFile.println("false");
				writeFile.println("Install_Shaders");
				writeFile.println("false");
				writeFile.println("Install_more");
				writeFile.println("false");
				writeFile.println("Update_mods");
				writeFile.println("false");
				writeFile.println("Mute");
				writeFile.println("false");
				openFile.close();
			}catch(Exception e) {
				System.out.println("Error al crear el archivo");
			}
		}else {
			System.out.println("the file already exist");
		}
	}
	
	public void setName(String url, String txtName) {
		this.file= new File(url+txtName);
	}
	
	public void reader(){
		try {
			FileReader fileOpen= new FileReader(this.file);
			BufferedReader fileReader= new BufferedReader(fileOpen);
			int i=0;
			String textLine="";
			while((textLine=fileReader.readLine())!=null) {
				this.list[i]=textLine;
				i++;
			}
			if(null !=fileOpen) {
				fileOpen.close();
			}
		}catch(Exception e) {
			System.out.println("cannot read the file");
		}
	}
	
	public void write(boolean res1, boolean res2, boolean res3, boolean res4, boolean res5, boolean res6) {
		try {
			FileWriter openFile= new FileWriter(this.file.getAbsolutePath());
			PrintWriter writeFile= new PrintWriter(openFile);
			writeFile.println("Install_mods");
			writeFile.println(res1);
			writeFile.println("Install_Texture packs");
			writeFile.println(res2);
			writeFile.println("Install_Shaders");
			writeFile.println(res3);
			writeFile.println("Install_more");
			writeFile.println(res4);
			writeFile.println("Update_mods");
			writeFile.println(res5);
			writeFile.println("Mute");
			writeFile.println(res6);
			openFile.close();
		} catch (Exception e) {
			System.out.print("cannot write in the file");
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}
	
	public String getIndex(int i) {
		return this.list[i];
	}
	
	
}
