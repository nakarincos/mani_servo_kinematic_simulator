import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

class Main{
	
	public static void main(String args[]){
		double ini_x = 750;
		double ini_y = 1000;
		double converter = 3;// 1 cm = 4.67 pixel
		int rubberRadius = (int)(converter*(40/Math.PI));
		int rubberDiameter = (int)(rubberRadius*2);
		int rubberRefX = 750;
		int rubberRefY = (int)(ini_y-(100*converter)-(12.25*converter));
		int startAX = 750;
		int startAY = (int)(ini_y-(50*converter)-(12.25*converter));
		System.out.println(rubberDiameter);
		JFrame frame = new JFrame("Manipulator Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.pack();
		frame.setSize(1500, 1050);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground( Color.black );
		frame.add(new JComponent() { 
			public void paintComponent(Graphics g) { 
				Graphics2D g2 = (Graphics2D) g; 
				g2.setColor(Color.red); 
				g2.draw(new Line2D.Double(0, ini_y, 1500, ini_y)); // X-Axis
				g2.draw(new Line2D.Double(ini_x, 0, ini_x, 1500)); // Y-Axis
				//g2.draw(new Line2D.Double(0, ini_y-(50*converter), 800, ini_y-(50*converter)));
				g2.draw(new Line2D.Double(0, rubberRefY, 1500, rubberRefY));
				
				g2.drawOval((int)(rubberRefX-(125.5*converter/2)), (int)(rubberRefY-((125.5*converter/2))),(int)(125.5*converter), (int)(125.5*converter));
				
				g2.fillOval((int)(ini_x-(rubberRadius)), (int)(ini_y-(100*converter)-rubberDiameter),rubberDiameter,rubberDiameter);
				
			} 
		}); 
		
		A a = new A(startAX, startAY);
	}
}