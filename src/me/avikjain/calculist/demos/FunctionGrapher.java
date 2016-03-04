package me.avikjain.calculist.demos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import me.avikjain.calculist.Constant;
import me.avikjain.calculist.Function;
import me.avikjain.calculist.Power;
import me.avikjain.calculist.Sin;
import me.avikjain.calculist.Variable;

public class FunctionGrapher {
	private Function f;
	private Variable x;
	
	private int xmin;
	private int xmax;
	private int ymin; 
	private int ymax;
	
	private JFrame frame;
	
	public FunctionGrapher(){
		xmin = -10;
		xmax = 10;
		ymin = -10;
		ymax = 10;
		
		
		x = new Variable("x");
		f = new Sin(new Power(x, new Constant(3)));
		frame = new JFrame("Grapher");
		JPanel graphPanel = new GraphPanel();
		JSlider zoomSlider = new JSlider(2, 50, 10);
		zoomSlider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				int zoom = zoomSlider.getValue();
				xmin = -zoom;
				xmax = zoom;
				ymin = -zoom;
				ymax = zoom;
				graphPanel.repaint();
			}
			
		});
		JPanel container = new JPanel();
		
		container.setLayout(new BorderLayout());
		container.add(graphPanel, BorderLayout.CENTER);
		container.add(zoomSlider, BorderLayout.NORTH);
		frame.setContentPane(container);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new FunctionGrapher();
	}
	
	// canvas on which the graph is drawn
	class GraphPanel extends JPanel{
		@Override
		public void paintComponent(Graphics g){
			setBackground(Color.WHITE);
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			
			// draw axes
			g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
			g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
			
			// compute points for graph
			ArrayList<Double> xs = new ArrayList<Double>();
			ArrayList<Double> ys = new ArrayList<Double>();
			
			for(double x0 = xmin; x0 <= xmax; x0+=0.02){
				try{
					x.setValue(x0);
					double y0 = f.evaluate();
					
					xs.add(x0);
					ys.add(y0);
				}catch(ArithmeticException e){
					
				}
				
			}
			
			// draw graph
			g.setColor(Color.BLUE);
			for(int i = 1; i < xs.size(); i++){
				double x0 = xs.get(i-1);
				double y0 = ys.get(i-1);
				double x1 = xs.get(i);
				double y1 = ys.get(i);
				g.drawLine(transformX(x0), transformY(y0), transformX(x1), transformY(y1));
			}
		}
		
		// convert cartesian y coordinate to y coordinate for display
		public int transformY(double y){
			return (int)(getHeight()-getHeight()*(y-ymin)/(ymax-ymin));
		}
		// convrt cartesian x coordinate to x coordinate for display
		public int transformX(double x){
			return (int)(getWidth()*(x-xmin)/(xmax-xmin));
		}
	}
}
