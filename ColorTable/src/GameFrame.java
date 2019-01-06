import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener{
	private final int NUM_BUTTONS1 = 5;
	private final int NUM_BUTTONS2 = 8;
	private final int NUM_BUTTONS3 = 10;
	private final int NUM_LEVELS = 3;
	
	private JButton [] b;
	private JButton [] level;
	private int currentSize;
	private JPanel jp,levelsPanel;
	
	public GameFrame(){
		currentSize = NUM_BUTTONS1;
		setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(NUM_BUTTONS1, NUM_BUTTONS1));
			// setup buttons
		b = new JButton[NUM_BUTTONS3*NUM_BUTTONS3];
		for(int i=0;i<b.length;i++){
			b[i] = new JButton();
			switch((int) (Math.random()*4)){
			case 0:
				b[i].setBackground(Color.BLUE);
				break;
			case 1:
				b[i].setBackground(Color.RED);
				break;
			case 2:
				b[i].setBackground(Color.GREEN);
				break;
			case 3:
				b[i].setBackground(Color.YELLOW);
				break;
			}// switch
			b[i].addActionListener(this);
			
		}// for
		
		// add buttons to layout
		for(int i=0;i<NUM_BUTTONS1*NUM_BUTTONS1;i++)
			jp.add(b[i]);
		
		levelsPanel = new JPanel();
		levelsPanel.setLayout(new GridLayout(3,1,5,5));
		level = new JButton[NUM_LEVELS];
		for(int i=0;i<level.length;i++){
			level[i] = new JButton("Level "+ (i+1));
	//		level[i].setText(String.format("Level %d", i+1));
			level[i].addActionListener(this);
			levelsPanel.add(level[i]);
	
		}
		// add buttons layout and level buttons layout
		add(jp,BorderLayout.CENTER);
		add(levelsPanel,BorderLayout.WEST);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// change level
		if(e.getSource()==level[0] ||e.getSource()==level[1]||e.getSource()==level[2] ){
			// 1. remove all color buttons from jp
			for(int i=0;i<currentSize*currentSize;i++)
				jp.remove(b[i]);
			// or jp.removeAll();
			// 2. change currentSize
			if(e.getSource()==level[0])	currentSize = NUM_BUTTONS1;
			else if(e.getSource()==level[1]) currentSize = NUM_BUTTONS2;
			else currentSize = NUM_BUTTONS3;
			// 3. redefine Grid Layout to match the new currentSize
			jp.setLayout(new GridLayout(currentSize, currentSize));
			//4. add new amount of buttons to jp
			for(int i=0;i<currentSize*currentSize;i++){
				switch((int) (Math.random()*4)){
				case 0:
					b[i].setBackground(Color.BLUE);
					break;
				case 1:
					b[i].setBackground(Color.RED);
					break;
				case 2:
					b[i].setBackground(Color.GREEN);
					break;
				case 3:
					b[i].setBackground(Color.YELLOW);
					break;
				}// switch
				jp.add(b[i]);
			}// for
		}//if
		// update the window
		jp.validate();
		repaint();
	}
	
}
