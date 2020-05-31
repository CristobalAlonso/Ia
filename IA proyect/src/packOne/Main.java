package packOne;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		IaMemory ia=new IaMemory();
		Scanner user=new Scanner(System.in);
		String response="";
		String text=null;
		boolean res=false;
		
		while(true){
			response=user.nextLine();
			if(response.equals("exit")) {
				break;
			}
			
			ia.learn(response);
			ia.say(response);
		}
		ia.stopSpeak();
	}
}
