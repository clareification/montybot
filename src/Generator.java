import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class Generator{
	
	
	public static String generateResponse(String[] transcript, String target, int length, boolean cutFront){
		Random rand = new Random();
		int index = rand.nextInt(length);
		target = target.toLowerCase();
		cutFront = !cutFront;
		
		if(target.length()>2){
			for(int count = 0; count<length; count++){
				String test = transcript[index].toLowerCase();
				if(test.contains(target)){
					String reply = transcript[(index + 1)%length];
					if (reply.length() < 2){
						reply = transcript[rand.nextInt(length)];
					}
					return reply;
				}
				index++;
				index = index%length;
			}
			String newTarget;
			if(cutFront){
			newTarget = target.substring(1, target.length()-1);
			}
			else{ 
				 newTarget = target.substring(0, target.length()-2);}
			generateResponse(transcript, newTarget, length, cutFront);
		}
		String response = transcript[rand.nextInt(length)];
		return response;
		
	}
	
	public static void main(String[] args) throws IOException{
	String[] script = Reading.getMonty();
	
	Scanner s = new Scanner(System.in);
	System.out.println("Halt! Who art thou?");
	while(true){
		String reply = s.nextLine();
		String response = generateResponse(script, reply, script.length, true);
		System.out.println(response);
	}
	
	
	}
	
}