import javax.swing.JFrame;

public class GameProgram {

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gf.setSize(300,300);
		gf.setLocation(200, 100);
		gf.setVisible(true);
	}

}
