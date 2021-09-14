package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	String filename ="";
	String decryptedMessage = "";
	String wholePath ="";
	int k = 0;
	
	if(returnVal == JFileChooser.APPROVE_OPTION){
		filename = jfc.getSelectedFile().getName();
		wholePath =  jfc.getSelectedFile().getAbsolutePath();
	}
	
	if(filename.equals("EncryptedMessage.txt")){
	String key = JOptionPane.showInputDialog("Enter the key");
	k = Integer.parseInt(key);
	}
	
	try{
		BufferedReader br = new BufferedReader(new FileReader(wholePath));
		String line =  br.readLine();
		
		String file = "";
		while(line != null){
			file += line;
			line = br.readLine();
		}
		
		for(int i =0; i<file.length(); i++){
			char c = file.charAt(i);
			
			c -= k;
			decryptedMessage += (char)c;
		}
		
		JOptionPane.showMessageDialog(null, decryptedMessage);
		br.close();
		
	}
	catch(IOException e){
		e.printStackTrace();
	}
	
	
}
}
