package packOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class IaMemory {
	//variables
	private Map<String, String> IaBook;
	private VoiceManager manager;
	private Voice voice;
	private FileMemory file;
	
	//constructor
    public IaMemory(){
    	//System.setProperty("mbrola.base", "C:\\mbrola");
    	this.manager = VoiceManager.getInstance();
    	this.voice=manager.getVoice("kevin16");
        this.IaBook=new HashMap<String, String>();
        this.IaBook.put("Nombre ", "Aaaaaaaranea");
        this.file=new FileMemory("src", "memory");
        this.file.createFile();
        //this.file.reader();
    }
    
    //funciones
    public String getWord(String wordKey){
        return this.IaBook.get(wordKey);
    }
    public void learn(String value) {
    	try {
			String key=aprende(value);
			String KeyValue=di(value);
			//System.out.println(key+": "+KeyValue);
			this.file.writeFile(key, KeyValue);
			this.IaBook.put(key, KeyValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public static String aprende(String value) {
    	ArrayList<String> textList= searchWord(value);
    	String text="";
    	for(int i=0;i<textList.size();i++) {
    		if(textList.get(i).equals("aprende")) {
    			String badText="";
    			for(int x=i+1;x<textList.size();x++) {
    				badText=textList.get(x);
    				if(badText.equals("di")) {
    					break;
    				}
    				text+=badText+" ";
    			}
    		}
    	}
    	return text;
    }
    public static String di(String value) {
    	ArrayList<String> textList= searchWord(value);
    	String text="";
    	for(int i=0;i<textList.size();i++) {
    		if(textList.get(i).equals("di")) {
    			for(int x=i+1;x<textList.size();x++) {
    				text+=textList.get(x)+" ";
    			}
    		}
    	}
    	return text;
    }
    
    public static ArrayList<String> searchWord(String text) {
    	Character let=0;
    	String word="";
    	text+=" ";
    	ArrayList<String> textList= new ArrayList<String>();
    	
    	for(int i=0;i<text.length();i++) {
    		let=text.charAt(i);
    		if(let.isWhitespace(let)) {
    			textList.add(word);
    			word="";
    		}else {
    			word+=let;
    		}
    	}
    	return textList;
    }
    
    public void say(String word) {
    	try {
    		String text=this.IaBook.get(word + " ");
        	boolean res=true;
        	voice.allocate();
        	if(text.equals(null)) {
        		res=false;
        	}
        	if(res) {
        		voice.speak(text);
        		System.out.println(text);
        	}
        	//voice.deallocate();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void stopSpeak() {
    	this.voice.deallocate();
    }
}
