package org.mobile.java;

import java.awt.Color;
import java.awt.FlowLayout;
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
	private JLabel mobitelLabel,dialogLabel,hutchLabel,lbl4; 
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
		mainFrame.setLayout(new FlowLayout());		
		
		mobitelLabel = new JLabel("Mobitel:");	
		dialogLabel = new JLabel("Dialog:");
		hutchLabel = new JLabel("Hutch:");
		
		mobitelLabel.setBounds(100, 50, 50, 50);
		mobitelLabel.setBackground(Color.BLUE);
		
		mobitelTextFeild = new JTextField(15);
		dialogTextFeild = new JTextField(15);
		hutchTextFeild = new JTextField(15);
		
		sendButton = new JButton("send");
		sendButton.setActionCommand("show");
		sendButton.addActionListener(this);
		
		mainFrame.add(mobitelLabel);mainFrame.add(mobitelTextFeild);
		mainFrame.add(dialogLabel);mainFrame.add(dialogTextFeild);
		mainFrame.add(hutchLabel);mainFrame.add(hutchTextFeild);	
		
		mainFrame.add(sendButton);	
		mainFrame.setSize(250,300);
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
