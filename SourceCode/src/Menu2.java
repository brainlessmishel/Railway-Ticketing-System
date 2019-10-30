

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javafx.stage.FileChooser;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.*;
import java.util.Scanner;

public class Menu2 implements ActionListener{
	
	
																		//WINDOW FRAME
	private JFrame frame;
	private JFrame frame2;
	private JFrame frame3;
	private JFrame frame4;
	private JFrame frame5;
	private JFrame frame6;
	private JFrame frame7;
	
																		//SET MENUBAR.....
	private JMenuBar menubar;
	private JMenu file;
	private JMenu help;
	
																		//file item
	private JMenuItem save;
	private JMenuItem exit;
	
	
																		//Button frame
	private JButton reservation;
	private JButton counter;
	private JButton traininfo;
	private JButton fare;
	private JButton cancel;
	private JButton term;
	private JButton home;
	private JButton submit;
	private JButton clear;
	private JButton previous;
	
																	//RESERVATION'S INTERFACE
																		//LABELS
	
	private JLabel strain;
	private JLabel destination;
	private JLabel stpoint;
	private JLabel sclass;
	private JLabel fareL;
	private JLabel name;
	private JLabel phn;
	private JLabel age;
	
																//RESERVATION'S JTEXTFIELDS
	private JTextField fareT;
	private JTextField nseat;
	private JTextField nameT;
	private JTextField phnT;
	private JTextField ageT;
	
																	//RESERVATION'S JCOMBOBOX
	private JComboBox strainC;
	private JComboBox destinationC;
	private JComboBox stpointC;
	private JComboBox sclassC;
	
																		//COUNTER CHECK INTERFACE
																			//LEBELS
	private JLabel tseat;
	private JLabel sold;
	private JLabel aseat;
	
																			//TEXTFIELDS
	private JTextField tseatT;
	private JTextField soldT;
	private JTextField aseatT; 
																	//TRAIN INFORMATION INTERFACE												
																	//Cancel reservation interface
	
	private JButton delete;
	
	private JTextField srchT;
	private JButton srch;
	
																//term and policy interface
	private String area;
	private String line;
	
	private Person2[] persons;
	
	
	Counter_Check2 dhu = new Counter_Check2("DHUMKETU EXPRESS", "50", "0", "50");
	Counter_Check2 nil = new Counter_Check2 ("NILSAGOR EXPRESS", "50", "0", "50");
	Counter_Check2 par = new Counter_Check2 ("PARABAT EXPRESS", "50", "0", "50");
	Counter_Check2 sil = new Counter_Check2 ("SILKCITY EXPRESS", "50", "0", "50");
	Counter_Check2 shu = new Counter_Check2 ("SHUBARNA EXPRESS", "50", "0", "50");
	Counter_Check2 sun = new Counter_Check2 ("SHUNDARBAN EXPRESS", "50", "0", "50");
	
	//Menu Interface
	public Menu2(){
		frame = new JFrame();
		
		reservation = new JButton("RESERVATION");
		 counter= new JButton("COUNTER CHECK");
		 traininfo = new JButton("TRAIN INFORMATION");
		 fare = new JButton("FARE");
		 cancel = new JButton("CANCEL RESERVATION");
		 term = new JButton("TERM & POLICY");
		 
		 																	//menu's menu Bar
			menubar = new JMenuBar();
			file = new JMenu("File");
			
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 					 
				 }
			 });
			
			help = new JMenu("Help");
			
		 reservation.addActionListener(this);
		 counter.addActionListener(this);
		 traininfo.addActionListener(this);
		 fare.addActionListener(this);
		 cancel.addActionListener(this);
		 term.addActionListener(this);
		 
		 
		 GridLayout g = new GridLayout(3,2);
		 frame.setLayout(g);
		 
		 frame.add(reservation);
		 frame.add(counter);
		 frame.add(traininfo);
		 frame.add(fare);
		 frame.add(cancel);
		 frame.add(term);
		 
		 	
			frame.setJMenuBar(menubar);
			
			menubar.add(file);
			menubar.add(help);
			
			file.add(exit);
			
		
		 
		 frame.setVisible(true);
		 	
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500, 260);
			frame.setLocation(200, 100);
			frame.setTitle("বাংলাদেশ রেলওয়ে");
	}

	public void writeToFile(){ // write the person records from array to file
		try {
			File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Railway.txt");
			FileWriter fw = new FileWriter(f);
			
			for(int i = 0; i < persons.length; i++){
				if(persons[i] != null){
					fw.write("Name :" +persons[i].getName());
					fw.write("\n");
					fw.write("Phone Number :"+persons[i].getPhn()); 
					fw.write("\n");
					fw.write("Age :"+persons[i].getAge());
					fw.write("\n");
					fw.write("Train Name :"+persons[i].getStrain());
					fw.write("\n");
					fw.write("Destination :"+persons[i].getDestination());
					fw.write("\n");
					fw.write("Starting Point :"+persons[i].getStpoint());
					fw.write("\n");
					fw.write("Seat Class :"+persons[i].getSclass());
					fw.write("\n");
					fw.write("Fare :"+persons[i].getFare());
					fw.write("\n");
				}
			}
			
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readFromFile(){ // read the persons records from file and store in an array
		try {
			File f = new File("E:\\Study\\Course\\CSE215L\\Project\\src\\Railway.txt");
			Scanner s = new Scanner(f);
			persons = new Person2 [50]; 
			int i = 0;
			
			while(s.hasNextLine()){
				String a = s.nextLine();
				String b = s.nextLine();
				String c = s.nextLine();
				String d = s.nextLine();
				String e = s.nextLine();
				String g = s.nextLine();
				String h = s.nextLine();
				String j = s.nextLine();
				Person2 temp = new Person2 (a,b,c,d,e,g,h,j);
				persons[i] = temp;
				i++;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
									
	public void addPerson(Person2 p){ // adds the student object into array
		// find an available index first
		int index = 0;
		persons = new Person2[50];
		
		for(int i = 0; i < persons.length; i++){
			if(persons[i] == null){ // location available
				index = i;
				break;
			}
		}
		
		if(index < persons.length){
			persons[index] = p;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
																				//Reservation frame code
		if(e.getSource() == reservation){
			
			frame2 = new JFrame();
			
			menubar = new JMenuBar();
			
			file = new JMenu("File");
			
			save = new JMenuItem("Save");
			save.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame2.setVisible(false);
					frame2.setVisible(true);
					 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 					 
				 }
			 });
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame2.setVisible(false);
					 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 					 
				 }
			 });
			
			help = new JMenu("Help");
			
			
			
			 strain = new JLabel("SELECT TRAIN");
			 destination = new JLabel("DESTINATION");
			 stpoint = new JLabel("START TRAVELING ");
			 sclass = new JLabel("Class");
			 fareL = new JLabel("FARE");
			 name= new JLabel("NAME");
			 phn = new JLabel("CONTRACT NUMBER");
			 age = new JLabel("AGE");
			 
			 String [] option1 = new String[]{"NONE","DHUMKETU EXPRESS","NILSAGOR EXPRESS","PARABAT EXPRESS","SILKCITY EXPRESS","SHUBARNA EXPRESS","SHUNDARBAN EXPRESS"};
			 strainC = new JComboBox(option1);
			 String[] option2 = new String[]{"NONE","RAJSHAHI","DHAKA","KHULNA","NILPHAMARY","CHITTAGONG","SYLHET"};
			 destinationC = new JComboBox(option2);
			 String[] option3 = new String[]{"NONE","RAJSHAHI","DHAKA","KHULNA","NILPHAMARY","CHITTAGONG","SYLHET"};
			 stpointC = new JComboBox(option3);
			 String[] option4 = new String[]{"NONE","FIRST","SECOND","THIRD","AC"};
			 sclassC = new JComboBox(option4);
			 
			 fareT= new JTextField();
			 nseat = new JTextField();
			 nameT = new JTextField();
			 phnT = new JTextField();
			 ageT = new JTextField();
			 																				//home button code
			 home= new JButton("Home");
			 home.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame2.setVisible(false);
					 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 
					 frame.setVisible(true);
					 
				 }
			 });
			 
			 																				//submit button code
			 submit = new JButton("SUBMIT");
			
			 submit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					 String y1 = nameT.getText();
					 String y2 = phnT.getText();
					 String y3 = ageT.getText();
					 String y4 = fareT.getText();
							
					 String x1 = strainC.getSelectedItem().toString();
					 String x2 = destinationC.getSelectedItem().toString();
					 String x3 = stpointC.getSelectedItem().toString();
					 String x4 = sclassC.getSelectedItem().toString();
					
					 Person2 p = new Person2(y1,y2,y3,y4,x1,x2,x3,x4);
						System.out.println(p);
						
						
						
						addPerson(p);
						
						writeToFile();
						
						
						
						
						if(strainC.getSelectedItem().toString().equals("DHUMKETU EXPRESS")){
							
				try {
				File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
				FileWriter fw = new FileWriter(f);
				
				
				
				fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +(dhu.getSold()+1)+ "\nAvailable Ticket :" +(dhu.getAvailable()-1));
				fw.write("\n");
				fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +nil.getSold()+ "\nAvailable Ticket :" +nil.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +par.getSold()+ "\nAvailable Ticket :" +par.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +sil.getSold()+ "\nAvailable Ticket :" +sil.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +shu.getSold()+ "\nAvailable Ticket :" +shu.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +sun.getSold()+ "\nAvailable Ticket :" +sun.getAvailable());
				fw.write("\n");
				fw.close();
				
				
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
						}
						
						else if(strainC.getSelectedItem().toString().equals("NILSHAGOR EXPRESS")){
							
							try {
							File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
							FileWriter fw = new FileWriter(f);
							
							
							
							fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +(dhu.getSold())+ "\nAvailable Ticket :" +(dhu.getAvailable()));
							fw.write("\n");
							fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +(nil.getSold()+1) + "\nAvailable Ticket :" +(nil.getAvailable()-1));
							fw.write("\n");
							fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +par.getSold()+ "\nAvailable Ticket :" +par.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +sil.getSold()+ "\nAvailable Ticket :" +sil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +shu.getSold()+ "\nAvailable Ticket :" +shu.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +sun.getSold()+ "\nAvailable Ticket :" +sun.getAvailable());
							fw.write("\n");
							fw.close();
							
							
							
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
									}
						
						else if(strainC.getSelectedItem().toString().equals("PARABAT EXPRESS")){
							
							try {
							File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
							FileWriter fw = new FileWriter(f);
							
							
							
							fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +dhu.getSold()+ "\nAvailable Ticket :" +(dhu.getAvailable()));
							fw.write("\n");
							fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +nil.getSold()+ "\nAvailable Ticket :" +nil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +(par.getSold()+1)+ "\nAvailable Ticket :" +(par.getAvailable()-1));
							fw.write("\n");
							fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +sil.getSold()+ "\nAvailable Ticket :" +sil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +shu.getSold()+ "\nAvailable Ticket :" +shu.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +sun.getSold()+ "\nAvailable Ticket :" +sun.getAvailable());
							fw.write("\n");
							fw.close();
							
							
							
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
									}
						
						else if(strainC.getSelectedItem().toString().equals("SILKCITY EXPRESS")){
							
							try {
							File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
							FileWriter fw = new FileWriter(f);
							
							
							
							fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +(dhu.getSold())+ "\nAvailable Ticket :" +(dhu.getAvailable()));
							fw.write("\n");
							fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +nil.getSold()+ "\nAvailable Ticket :" +nil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +par.getSold()+ "\nAvailable Ticket :" +par.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +(sil.getSold()+1)+ "\nAvailable Ticket :" +(sil.getAvailable()-1));
							fw.write("\n");
							fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +shu.getSold()+ "\nAvailable Ticket :" +shu.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +sun.getSold()+ "\nAvailable Ticket :" +sun.getAvailable());
							fw.write("\n");
							fw.close();
							
							
							
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
									}
						
						else if(strainC.getSelectedItem().toString().equals("SHUBARNA EXPRESS")){
							
							try {
							File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
							FileWriter fw = new FileWriter(f);
							
							
							
							fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +(dhu.getSold())+ "\nAvailable Ticket :" +(dhu.getAvailable()));
							fw.write("\n");
							fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +nil.getSold()+ "\nAvailable Ticket :" +nil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +par.getSold()+ "\nAvailable Ticket :" +par.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +sil.getSold()+ "\nAvailable Ticket :" +sil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +(shu.getSold()+1)+ "\nAvailable Ticket :" +(shu.getAvailable()-1));
							fw.write("\n");
							fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +sun.getSold()+ "\nAvailable Ticket :" +sun.getAvailable());
							fw.write("\n");
							fw.close();
							
							
							
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
									}
						
						else if(strainC.getSelectedItem().toString().equals("SUNDARBAN EXPRESS")){
							
							try {
							File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
							FileWriter fw = new FileWriter(f);
							
							
							
							fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +(dhu.getSold())+ "\nAvailable Ticket :" +(dhu.getAvailable()));
							fw.write("\n");
							fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +nil.getSold()+ "\nAvailable Ticket :" +nil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +par.getSold()+ "\nAvailable Ticket :" +par.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +sil.getSold()+ "\nAvailable Ticket :" +sil.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +shu.getSold()+ "\nAvailable Ticket :" +shu.getAvailable());
							fw.write("\n");
							fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +(sun.getSold()+1)+ "\nAvailable Ticket :" +(sun.getAvailable()-1));
							fw.write("\n");
							fw.close();
							
							
							
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
									}
					 
				 }
			 });
			 
			 																			// clear button code
			 clear = new JButton("CLEAR");
			 clear.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					 fareT.setText("");
					 nameT.setText("");
					 nseat.setText("");
					 phnT.setText("");
					 ageT.setText("");
					 
						strainC.setSelectedIndex(0);
						destinationC.setSelectedIndex(0);
						stpointC.setSelectedIndex(0);
						sclassC.setSelectedIndex(0);
					 
				 }
			 });
			 
			 																			//previous button code
			 previous = new JButton("<");
			 previous.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					 
					 
					 frame.setVisible(true);
					 
					 
					frame2.setVisible(false);
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
					 
					 
				 }
			 });
			 
			 
			 
			 GridLayout g = new GridLayout(5,2);
			 frame2.setLayout(g);
			 
			 frame2.add(strain);
			 frame2.add(strainC);
			 
			 frame2.add(name);
			 frame2.add(nameT);
			 
			 frame2.add(destination);
			 frame2.add(destinationC);
			 
			 frame2.add(phn);
			 frame2.add(phnT);
			 
			 frame2.add(stpoint);
			 frame2.add(stpointC);
			 
			 frame2.add(fareL);
			 frame2.add(fareT);
			 
			 frame2.add(sclass);
			 frame2.add(sclassC);
			 
			 
			 frame2.add(age);
			 frame2.add(ageT);
			 
			 frame2.add(home);
			 frame2.add(submit);
			 frame2.add(clear);
			 frame2.add(previous);
			 
			 frame2.setJMenuBar(menubar);
			 
			 	menubar.add(file);
				menubar.add(help);
				
				file.add(save);
				file.add(exit);
			 
			 
			 
			 frame.setVisible(false);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	frame2.setVisible(true);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setSize(500, 260);
				frame2.setLocation(200, 200);
				frame2.setTitle("RESERVATION");							
					}
		//int e = (Integer.valueOf(c)).intValue(); 
																					//Counter check interface 
		if(e.getSource() == counter){
			frame3 = new JFrame();
			strain = new JLabel("Select Train");
			tseat = new JLabel("Total Seat");
			sold = new JLabel("Sold Out");
			aseat = new JLabel("Available Seat");
			
			
			
			String [] option1 = new String[]{"NONE","DHUMKETU EXPRESS","NILSAGOR EXPRESS","PARABAT EXPRESS",
												"SILKCITY EXPRESS","SHUBARNA EXPRESS","SHUNDARBAN EXPRESS"};
			strainC= new JComboBox(option1);
			tseatT = new JTextField();
			soldT =new  JTextField();
			aseatT = new JTextField();
			
			try {
				File f = new File("E:\\Study\\Course\\CSE215L\\ProjectModify\\src\\Counter.txt");
				FileWriter fw = new FileWriter(f);
				
		
				fw.write("Train name :" +dhu.getStrain()+ "\nTotal Seat :" +dhu.getTseat()+ "\nSold Ticket :" +dhu.getSold()+ "\nAvailable Ticket :" +dhu.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +nil.getStrain()+ "\nTotal Seat :" +nil.getTseat()+ "\nSold Ticket :" +nil.getSold()+ "\nAvailable Ticket :" +nil.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +par.getStrain()+ "\nTotal Seat :" +par.getTseat()+ "\nSold Ticket :" +par.getSold()+ "\nAvailable Ticket :" +par.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +sil.getStrain()+ "\nTotal Seat :" +sil.getTseat()+ "\nSold Ticket :" +sil.getSold()+ "\nAvailable Ticket :" +sil.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +shu.getStrain()+ "\nTotal Seat :" +shu.getTseat()+ "\nSold Ticket :" +shu.getSold()+ "\nAvailable Ticket :" +shu.getAvailable());
				fw.write("\n");
				fw.write("Train name :" +sun.getStrain()+ "\nTotal Seat :" +sun.getTseat()+ "\nSold Ticket :" +sun.getSold()+ "\nAvailable Ticket :" +sun.getAvailable());
				fw.write("\n");
				fw.close();
				
				
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		
			if(strainC.getSelectedItem().toString().equals("DHUMKETU EXPRESS")){
				tseatT = new JTextField();
				soldT =new  JTextField();
				aseatT = new JTextField();
			}
				
																			//counter check Home button code
			home= new JButton("Home");
			 
			 home.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame3.setVisible(false);
					 frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 
					 frame.setVisible(true);
					 
				 }
			 });
			 
			 
			 																	//counter check submit button code
			 submit= new JButton("SUBMIT");
			 submit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					 String y1 = tseatT.getText();
					 String y2 = soldT.getText();
					 String y3 = aseatT.getText();
					
							
					 String x1 = strainC.getSelectedItem().toString();
					
					
					 Counter_Check2 c = new Counter_Check2(y1,y2,y3,x1);
						System.out.println(c);
					 
				 }
			 });
			 
			 																	//counter check clear button code
			 clear =new JButton("CLEAR");
			 clear.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
						strainC.setSelectedIndex(0);
				 }
			 });
			 
			 																	//counter check previous button code
			 previous = new JButton("<");
			 previous.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					 
					 
					 frame3.setVisible(false);
					 frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 
					frame2.setVisible(true);
					
					 
					 
				 }
			 });
			 
			 
			 menubar = new JMenuBar();
				
				file = new JMenu("File");
				
				save = new JMenuItem("Save");
				save.addActionListener(this);
				
				exit = new JMenuItem("Exit");
				exit.addActionListener(new ActionListener ()
				 {
					 public void actionPerformed(ActionEvent e) {
						frame3.setVisible(false);
						 frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 					 
					 }
				 });
				
				help = new JMenu("Help");
			 
			
			
			GridLayout g = new GridLayout(3,2);
			 frame3.setLayout(g);
			 
			 frame3.add(strain);
			 frame3.add(strainC);
			 
			 frame3.add(tseat);
			 frame3.add(tseatT);
			 
			 frame3.add(sold);
			 frame3.add(soldT);
			 
			 frame3.add(aseat);
			 frame3.add(aseatT);
			 
			 frame3.add(home);
			 frame3.add(submit);
			 frame3.add(clear);
			 frame3.add(previous);
			 
			 frame3.setJMenuBar(menubar);
			 menubar.add(file);
			 menubar.add(help);
			 
			 file.add(save);
			 file.add(exit);
			 
			 
			 frame.setVisible(false);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setVisible(true);
				frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame3.setSize(500, 260);
				frame3.setLocation(200, 200);
				frame3.setTitle("COUNTER CHECK");
		}	
		
		
		
																				//Train info interface code
		
		if(e.getSource() == traininfo){
			frame4= new JFrame();
			
			menubar = new JMenuBar();
			file = new JMenu("File");
			
			save = new JMenuItem("Save");
			save.addActionListener(this);
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame4.setVisible(false);
					 frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 					 
				 }
			 });
			
			help = new JMenu("Help");
		
				GridLayout g =new GridLayout(1,1);
				frame4.setLayout(g);
				
				
				frame4.setJMenuBar(menubar);
				menubar.add(file);
				menubar.add(help);
				file.add(save);
				file.add(exit);
			
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame4.setVisible(true);
				frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame4.setSize(500, 260);
				frame4.setLocation(200, 200);
				frame4.setTitle("TRAIN INFORMATION");
		}	
		
		
																					//Fare interface code
		if(e.getSource() == fare){
			frame5= new JFrame();
			
			menubar = new JMenuBar();
			file = new JMenu("File");
			
			save = new JMenuItem("Save");
			save.addActionListener(this);
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame5.setVisible(false);
					 frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 					 
				 }
			 });
																						// not done yet
			help = new JMenu("Help");
			
			GridLayout g= new GridLayout(1,1);
			frame5.setLayout(g);
			
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame5.setVisible(true);
				frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame5.setSize(500, 260);
				frame5.setLocation(200, 200);
				frame5.setTitle("FARE");
				
				frame5.setJMenuBar(menubar);
				menubar.add(file);
				menubar.add(help);
				file.add(save);
				file.add(exit);
			
			
		}	
		
																				// Cancel reservation code
		if(e.getSource() == cancel){
			frame6= new JFrame();
			name = new JLabel("Name");
			age = new JLabel("Age");
			phn = new JLabel("Phone No");
			
			nameT= new JTextField();
			ageT= new JTextField();
			phnT= new JTextField();
			
			
			srchT = new JTextField();
			
																						//not done yet
			srch = new JButton("Search By Phone No");
			srch.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
						
				 }
			 });
			home= new JButton("Home");
			 
			 home.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame6.setVisible(false);
					 frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 
					 frame.setVisible(true);
					 
				 }
			 });
			 																				// not done yet 
			 delete = new JButton("Cancel Reservation");
			 
			 delete.setForeground(Color.red);
			 delete.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame6.setVisible(false);
					 frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 
					 frame.setVisible(true);
					 
				 }
			 });
			 
			
			
			menubar = new JMenuBar();
			file = new JMenu("File");
			
			save = new JMenuItem("Save");
			save.addActionListener(this);
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(new ActionListener ()
			 {
				 public void actionPerformed(ActionEvent e) {
					frame6.setVisible(false);
					 frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 					 
				 }
			 });
			
			help = new JMenu("Help");
			
			
			
			GridLayout g= new GridLayout(5,1);
			frame6.setLayout(g);
			frame6.add(name);
			frame6.add(nameT);
			
			frame6.add(age);
			frame6.add(ageT);
			
			frame6.add(phn);
			frame6.add(phnT);
			
			
			frame6.add(srchT);
			frame6.add(srch);
			
			frame6.add(home);
			frame6.add(delete);
			
			
			frame6.setJMenuBar(menubar);
			menubar.add(file);
			menubar.add(help);
			
			file.add(save);
			file.add(exit);
			
			
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame6.setVisible(true);
				frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame6.setSize(500, 260);
				frame6.setLocation(200, 200);
				frame6.setTitle("CANCEL RESERVATION");
			
		}	
		
																		// Term and policy interface code
		if(e.getSource() == term){
			frame7= new JFrame();
			
			
		try {
	            // FileReader reads text files in the default encoding.
	            FileReader f = new FileReader("C:/Users/mishel/Documents/Railway Ticketing System/src/railwayTS/mawn.txt");

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader =  new BufferedReader(f);
	            	line=null;
	            while((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	            }   
	            bufferedReader.close();}
	           
			 catch(IOException ex) {
		            System.out.println(ex.getMessage());
		            }
		
		            
	                   
	           
		            TextArea text = new TextArea(line);
		          text.setText(line);
		            
			
		
			frame7.add(text);
			
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame7.setVisible(true);
				frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame7.setSize(500, 260);
				frame7.setLocation(200, 200);
				frame7.setTitle("TERM & POLICY");
		
		}
		
		
	}
	
	
	
	}
	

	


		
		
	

	

