package me.avikjain.calculist.demos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import me.avikjain.calculist.Addition;
import me.avikjain.calculist.Constant;
import me.avikjain.calculist.Function;
import me.avikjain.calculist.Multiplication;
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
		f = new Power(x, new Constant(3));
		frame = new JFrame("Grapher");
		JPanel graphPanel = new JPanel(){
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
					}catch(Exception e){
						
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
			
			public int transformY(double y){
				return (int)(getHeight()-getHeight()*(y-ymin)/(ymax-ymin));
			}
			
			public int transformX(double x){
				return (int)(getWidth()*(x-xmin)/(xmax-xmin));
			}
		};
		frame.setContentPane(graphPanel);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new FunctionGrapher();
	}
}
