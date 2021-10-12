package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */

	ArrayList<String> tasks = new ArrayList<>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add task");
	JButton button2 = new JButton("View task");
	JButton button3 = new JButton("Remove task");
	JButton button4 = new JButton("Save list");
	JButton button5 = new JButton("Load list");
	
	
	
	ToDoList(){	
	frame.add(panel);
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	panel.add(button4);
	panel.add(button5);
	
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	button5.addActionListener(this);
	
	frame.setVisible(true);
	frame.pack();
	}
	
	public static void main(String[] args) {
	ToDoList tdl = new ToDoList();
	
	
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == button1){
			String response = JOptionPane.showInputDialog("Enter a task");
			tasks.add(response);
		}
		if(arg0.getSource() == button2){
			String allTasks= "";
			for(int i = 0 ; i<tasks.size(); i++){
				allTasks += i+1 + ") " + tasks.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, allTasks);
		}
		if(arg0.getSource() == button3){
			String res = JOptionPane.showInputDialog("Which task do you want to remove?");
			//int num = Integer.parseInt(res);
			
			for(int i = 0; i < tasks.size(); i++){
				if(tasks.get(i).equals(res)){
					tasks.remove(i);
				}
			}
		}
		if(arg0.getSource() == button4){
			//copy all elements in arraylist and write them into file
			try{
			FileWriter fw = new FileWriter("tasks.txt");
			for(int i = 0; i<tasks.size(); i++){
				fw.write(tasks.get(i));
				fw.write("\n");
			}
			fw.close();
			
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
		if(arg0.getSource() == button5){
			//use jfilechooser to choose and intialize new arraylist member variable
			JFileChooser jfc = new JFileChooser();
			String fileName = "";
			int returnval = jfc.showOpenDialog(null);
			if(returnval == JFileChooser.APPROVE_OPTION){
				fileName = jfc.getSelectedFile().getAbsolutePath();
			}
			
			try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while(line != null){
				tasks.add(line);
				line = br.readLine();
			}
			
			br.close();
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			
	}
	}
}

//Copyright © 2021 Jetsapon Bansasine