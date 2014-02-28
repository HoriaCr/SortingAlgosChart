package main;

import java.util.Arrays;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Sorting {

	static class MultipleDatasetDemo1 extends ApplicationFrame {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;



		public MultipleDatasetDemo1(final String title) {

	        super(title);
	        final XYSeriesCollection dataset1 = createDataset("Series 1");
	       
	        final JFreeChart chart = ChartFactory.createXYAreaChart(
	        		"Sorting algorithms", "N", 
	        		"Time (seconds)", 
	        		dataset1,
	        		PlotOrientation.VERTICAL, 
	        		true, 
	        		true, 
	        		false
	        );
	        
	        chart.setBackgroundPaint(Color.white);
	        
	        final XYPlot plot = chart.getXYPlot();
	        plot.setBackgroundPaint(Color.lightGray);
	    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
	        plot.setDomainGridlinePaint(Color.white);
	        plot.setRangeGridlinePaint(Color.white);
//	      
	        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesLinesVisible(0, true);
	        renderer.setSeriesShapesVisible(1, false);
	        plot.setRenderer(renderer);

	        
	        final JPanel content = new JPanel(new BorderLayout());

	        final ChartPanel chartPanel = new ChartPanel(chart);
	        content.add(chartPanel);
	       
	        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
	        setContentPane(content);

	    }
	    
	    public int[] getRandom(int n) {
	    	Random generator = new Random();
	    	int[] ret = new int[n];
	    	for(int j = 0;j < n;j++) {
	    		ret[j] = generator.nextInt(2000000000);//* (generator.nextBoolean() ? 1 : -1);
	    	}
	    	return ret;
	    }
	    	

	
	    private XYSeriesCollection createDataset(final String name) {
	        XYSeriesCollection ret = new XYSeriesCollection();
	    	
			Quicksort qsSort = new Quicksort();
			final XYSeries quicksortSeries = new XYSeries("Quicksort");
			
			Mergesort msSort = new Mergesort();
			final XYSeries mergesortSeries = new XYSeries("Mergesort");
			Heapsort hsSort = new Heapsort();
			final XYSeries heapsortSeries = new XYSeries("Heapsort");
			/*
			Bubblesort bsSort = new Bubblesort();
			final XYSeries bubblesortSeries = new XYSeries("Bubblesort");
			*/
			final int[] nvalues = {5,10,50,100,500,1000,5000,10000,50000,750000,100000,300000,500000,1000000,5000000,7500000,10000000,50000000};
			
			final XYSeries javasortSeries = new XYSeries("Javasort");
			
			RadixSort radixSort = new RadixSort();
			final XYSeries radixsortSeries = new XYSeries("Radixsort");
			
			int num = nvalues.length;
			for(int i = 0;i < num;i++) {
		
				long startTime, endTime;
				double timeElapsed;
				int[] values = getRandom(nvalues[i]);
				startTime = System.currentTimeMillis();
				qsSort.sort(values);
				endTime = System.currentTimeMillis();
				timeElapsed = (endTime - startTime)/1e3;
				quicksortSeries.add(nvalues[i],timeElapsed);
				
				values = getRandom(nvalues[i]);
				
				startTime = System.currentTimeMillis();
				msSort.sort(values);
				endTime = System.currentTimeMillis();
				timeElapsed = (endTime - startTime)/1e3;
				mergesortSeries.add(nvalues[i],timeElapsed);
				
				values = getRandom(nvalues[i]);
				
				startTime = System.currentTimeMillis();
				hsSort.sort(values);
				endTime = System.currentTimeMillis();
				timeElapsed = (endTime - startTime)/1e3;
				heapsortSeries.add(nvalues[i],timeElapsed);
				
				values = getRandom(nvalues[i]);
				startTime = System.currentTimeMillis();
				Arrays.sort(values);
				endTime = System.currentTimeMillis();
				timeElapsed = (endTime - startTime)/1e3;
				javasortSeries.add(nvalues[i],timeElapsed);
				
				values = getRandom(nvalues[i]);
				startTime = System.currentTimeMillis();
				radixSort.sort(values);
				endTime = System.currentTimeMillis();
				timeElapsed = (endTime - startTime)/1e3;
				radixsortSeries.add(nvalues[i],timeElapsed);
				
			}
			
		
			ret.addSeries(quicksortSeries);
			ret.addSeries(mergesortSeries);
			ret.addSeries(heapsortSeries);
			ret.addSeries(javasortSeries);
			ret.addSeries(radixsortSeries);
	        return ret;
	    }
	    
	  
	    
	    public static void main(final String[] args) {
			
	    	final MultipleDatasetDemo1 demo = new MultipleDatasetDemo1("Integer Sort");
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);

		}
	}
}
