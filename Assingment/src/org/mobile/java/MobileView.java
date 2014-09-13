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
	
	JButton b1;	
	JLabel lbl1,lbl2,lbl3,lbl4; 
	JTextField t1,t2,t3;
	private static ArrayList list;

	public MobileView() {
		
		super("Mobile Users");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		lbl1 = new JLabel("Mobitel");
		lbl2 = new JLabel("Dialog");
		lbl3 = new JLabel("Hutch");
		
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		
		b1 = new JButton("send");
		b1.setActionCommand("show");
		b1.addActionListener(this);
		
		con.add(lbl1);con.add(t1);
		con.add(lbl2);con.add(t2);
		con.add(lbl3);con.add(t3);			
		con.add(b1);	
		setSize(250,300);
		setVisible(true);
		
	}


	public void actionPerformed(ActionEvent e){
		if("show".equals(e.getActionCommand())){	
			
			
			b1.setEnabled(true);
			list=getText();			
			Graph g=new Graph(list);		
			//g.ar=list;
			g.alist();
			//g.createDataSet();
			//g.createPanel();
			g.setVisible(true);	
			t1.setText("");
			t2.setText("");
			t3.setText("");
			
		}
	}

	public ArrayList<Integer> getText(){
		
		int Mobiteltext=Integer.parseInt((t1.getText()));
		System.out.println("*************"+Mobiteltext);
		int Dialogtext=Integer.parseInt(t2.getText());
		int Hutchtext=Integer.parseInt(t3.getText());		
		ArrayList<Integer> value=new ArrayList<Integer>();
		value.add(Mobiteltext);
		value.add(Dialogtext);
		value.add(Hutchtext);		
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MobileView mv=new MobileView();		
		mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.exit(0);

	}

}
