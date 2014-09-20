package org.mobile.java;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MobileView extends JFrame implements ActionListener{
	
	private JFrame mainFrame;
	private JPanel labelPanel;
	
	private JButton sendButton;	
	private JLabel mobitelLabel,dialogLabel,hutchLabel,headerLabel; 
	private JTextField mobitelTextFeild,dialogTextFeild,hutchTextFeild;
	private ArrayList dataList;	
	private int mobitelText;
	private int dialogText;
	private int hutchText;

	public MobileView() {		
			
		prepareGUI();	
		
	}

	private void prepareGUI(){		
		
		mainFrame = new JFrame("Mobile Users");		
		mainFrame.setLayout(new GridLayout(2,1));	
		headerLabel = new JLabel("Mobile Usage of 2014",JLabel.CENTER);
		headerLabel.setSize(50,150);
		headerLabel.setBackground(Color.lightGray);		
		
		labelPanel=new JPanel();
		labelPanel.setLayout(new FlowLayout());
		labelPanel.setBackground(Color.ORANGE);
		labelPanel.setSize(200,350);			
		
		mobitelLabel = new JLabel("Mobitel:");//mobitelLabel.setBounds(100, 50, 50, 50);mobitelLabel.setBackground(Color.BLUE);
		dialogLabel = new JLabel("Dialog:");
		hutchLabel = new JLabel("Hutch:");
		
		mobitelLabel.setSize(150, 50);
		dialogLabel.setSize(150, 50);
		hutchLabel.setSize(150, 50);
		
		mobitelTextFeild = new JTextField(15);
		dialogTextFeild = new JTextField(15);
		hutchTextFeild = new JTextField(15);
		
		sendButton = new JButton("send");
		sendButton.setSize(100,50);
		
		sendButton.setActionCommand("show");
		sendButton.addActionListener(this);
		
		labelPanel.add(mobitelLabel);labelPanel.add(mobitelTextFeild);
		labelPanel.add(dialogLabel);labelPanel.add(dialogTextFeild);
		labelPanel.add(hutchLabel);labelPanel.add(hutchTextFeild);	
		labelPanel.add(sendButton);	
		
		mainFrame.add(headerLabel);
		mainFrame.add(labelPanel);		
		mainFrame.setSize(250,300);
		mainFrame.setLocation(500, 200);
		mainFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if("show".equals(e.getActionCommand())){				
			
			sendButton.setEnabled(true);
			int a=Integer.parseInt((mobitelTextFeild.getText()));
			int b=Integer.parseInt(dialogTextFeild.getText());
			int c=Integer.parseInt(hutchTextFeild.getText());
			
			setTextFeildValue(a,b,c);			
			this.dataList=getTextFeildValue();
			
			Graph graph=new Graph(this.dataList);			
			graph.getDataList();			
			graph.setVisible(true);	
			mobitelTextFeild.setText("");
			dialogTextFeild.setText("");
			hutchTextFeild.setText("");
			
		}
	}

	
	public void setTextFeildValue(int a,int b,int c){
		
		this.mobitelText=a;		
		this.dialogText=b;
		this.hutchText=c;		
	
	}
	
	public ArrayList<Integer> getTextFeildValue(){
		
		ArrayList<Integer> textFeildvalueList=new ArrayList<>();
		textFeildvalueList.add(this.mobitelText);
		textFeildvalueList.add(this.dialogText);
		textFeildvalueList.add(this.hutchText);			
		return textFeildvalueList;
	}
	
	public static void main(String[] args) {		
		
		MobileView mv=new MobileView();		
		mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
