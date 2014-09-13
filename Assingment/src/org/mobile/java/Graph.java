/*
 * Drawing XY line chart with XYDataset using JFreechart library
 * */

package org.mobile.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	
	
	public ArrayList<Integer> textFeildvalueList;
	
	public Graph(ArrayList<Integer> dataList){
		
		super("Mobile Usage");
		this.textFeildvalueList=dataList;
		JPanel graphPanel=createPanel();				
		add(graphPanel,BorderLayout.CENTER);		
		
	}
	
	public ArrayList<Integer> getDataList(){
		
		return textFeildvalueList;
	}
	
	public JPanel createPanel(){//create line chart object
		
		String chartTitle = "Mobile Usages";
		String xAxisLabel="X";
		String yAxisLabel="Y";					
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
		XYSeries xyseries=new XYSeries("2014");
		
		 ArrayList<Integer> xAxisLabelList = new ArrayList<Integer>();
		 ArrayList<Integer> yAxisLabelList =getDataList();
		 xAxisLabelList.add(1);
		 xAxisLabelList.add(2);
		 xAxisLabelList.add(3);

		 
		 Object[] xAxisLabel=xAxisLabelList.toArray();
		 Object[] yAxisLabel=yAxisLabelList.toArray();			
		 
		 for(int i=0;i<xAxisLabelList.size();i++){
		
			 xyseries.add((Integer)xAxisLabel[i],(Integer)yAxisLabel[i]);
			
		 }
		 
		dataset.addSeries(xyseries);
		return dataset;
	}

}
