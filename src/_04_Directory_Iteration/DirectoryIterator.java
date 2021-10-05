package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
//		JFileChooser jfc = new JFileChooser();
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int returnVal = jfc.showOpenDialog(null);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File directory = jfc.getSelectedFile();
//			File[] files = directory.listFiles();
//			if(files != null) {
//				for(File f : files) {
//				  System.out.println(f.getAbsolutePath());
//				}
//			}
//		}
//		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
		
		JFileChooser jfc2 = new JFileChooser();
		jfc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal2 = jfc2.showOpenDialog(null);
		
//		File[] jProjects;
		
		if(returnVal2 == JFileChooser.APPROVE_OPTION){
			File src = jfc2.getSelectedFile();
			File[] directories = src.listFiles();
			if(directories != null){
				for(File d : directories){
					System.out.println("found a directory --> " + d.getAbsolutePath());
					File[] jProjects = d.listFiles();
					for(File jP : jProjects){
						String ext = jP.getAbsolutePath().substring(jP.getAbsolutePath().length() - 5);
						//System.out.println("\t " + ext);
						if(ext.contains(".java")){
							System.out.println("\n java project");
							try{
								FileWriter fw = new FileWriter(jP.getAbsolutePath(), true);
								
								//****FINISH WRITING CODE TO WRITE STUFF IN THE FILES****
								
							}catch(IOException e){
								e.printStackTrace();
							}
							
						}
						
					}
				}
			}else{
				System.out.println("no files found");
			}
			
		}
		
		
	}
}
