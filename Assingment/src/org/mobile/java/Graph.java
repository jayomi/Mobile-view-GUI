/*
 * Drawing XY line chart with XYDataset using JFreechart library
 * */

package org.mobile.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph extends JFrame{
	
	
	public ArrayList<Integer> ar;
	
	public Graph(ArrayList<Integer> arl){
		
		super("Mobile Usage");
		this.ar=arl;
		JPanel p=createPanel();		
		//p.setPreferredSize(new java.awt.Dimension(500,270));
		add(p,BorderLayout.CENTER);		
		
	}
	
	public ArrayList<Integer> alist(){
		
		return ar;
	}
	
	public JPanel createPanel(){//create line chart object
		
		String chartTitle = "Mobile Usages";
		String xAxisLabel="X";
		String yAxisLabel="Y";	
		//boolean legend,tooltips,urls;		
		//ArrayList<Integer> arr2=alist();		
		XYDataset dataset=createDataSet();
		//creating XY line chart
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL,true, true,false);
		
		//Setting custom renderer for the series lines
		XYPlot plot=chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();		
		plot.setRenderer(renderer);
		
		plot.setBackgroundPaint(Color.DARK_GRAY);
		
		return new ChartPanel(chart);
		
	}
	
	public XYDataset createDataSet(){//creates an XY datasets
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1=new XYSeries("2014");
		
		 ArrayList<Integer> arr = new ArrayList<Integer>();
		 ArrayList<Integer> list =alist();
		 arr.add(1);
		 arr.add(2);
		 arr.add(3);

		 
		 Object[] arr3=arr.toArray();
		 Object[] arr4=list.toArray();			
		 
		 for(int i=0;i<arr.size();i++){
		
			series1.add((Integer)arr3[i],(Integer)arr4[i]);
			
		 }
		 
		dataset.addSeries(series1);
		return dataset;
	}

}
