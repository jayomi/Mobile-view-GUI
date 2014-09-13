package org.mobile.java;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MobileView extends JFrame implements ActionListener{
	
	private JButton sendButton;	
	private JLabel mobitelLabel,dialogLabel,hutchLabel,lbl4; 
	private JTextField mobitelTextFeild,dialogTextFeild,hutchTextFeild;
	private ArrayList dataList;
	ArrayList<Integer> values;
	private int mobitelText;
	private int dialogText;
	private int hutchText;

	public MobileView() {
		
		super("Mobile Users");		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		mobitelLabel = new JLabel("Mobitel");
		dialogLabel = new JLabel("Dialog");
		hutchLabel = new JLabel("Hutch");
		
		mobitelTextFeild = new JTextField(15);
		dialogTextFeild = new JTextField(15);
		hutchTextFeild = new JTextField(15);
		
		sendButton = new JButton("send");
		sendButton.setActionCommand("show");
		sendButton.addActionListener(this);
		
		con.add(mobitelLabel);con.add(mobitelTextFeild);
		con.add(dialogLabel);con.add(dialogTextFeild);
		con.add(hutchLabel);con.add(hutchTextFeild);			
		con.add(sendButton);	
		setSize(250,300);
		setVisible(true);
		
	}


	public void actionPerformed(ActionEvent e){
		if("show".equals(e.getActionCommand())){				
			
			sendButton.setEnabled(true);
			int a=Integer.parseInt((mobitelTextFeild.getText()));
			int b=Integer.parseInt(dialogTextFeild.getText());
			int c=Integer.parseInt(hutchTextFeild.getText());
			
			setText(a,b,c);			
			this.dataList=getText();
			
			Graph graph=new Graph(this.dataList);		
			//graph.ar=dataList;
			graph.getDataList();
			//graph.createDataSet();
			//graph.createPanel();
			graph.setVisible(true);	
			mobitelTextFeild.setText("");
			dialogTextFeild.setText("");
			hutchTextFeild.setText("");
			
		}
	}

	
	public void setText(int a,int b,int c){
		
		this.mobitelText=a;		
		this.dialogText=b;
		this.hutchText=c;		
	
	}
	
	public ArrayList<Integer> getText(){
		
		ArrayList<Integer> value=new ArrayList<>();
		value.add(this.mobitelText);
		value.add(this.dialogText);
		value.add(this.hutchText);			
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MobileView mv=new MobileView();		
		mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.exit(0);

	}

}
