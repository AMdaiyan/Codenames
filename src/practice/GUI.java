package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class GUI implements ActionListener, MenuListener{
	
	

	private JFrame window;
	private JFrame Redturn;
	private JFrame Blueturn;
	private JPanel board;
	private JPanel bar;
	private JPanel cc;
	private JButton Submit;
	private JButton Counterholder;
	private JButton Clueholder;
	private JButton endGame;
	private JMenuBar men;
	private JMenu File;
	private JMenuItem Exit;
	private JMenuItem NewGame;
	private JMenuItem NewGame3;
	private JMenuItem Easter;
	private TextField Count;
	private TextField Clue;
	private int GuessCount;
	private int EasterCounter = 0;
	private ArrayList<Agent> helper;
	private String age;
	private JButton endTurn;
	private int redCount;
	private int blueCount;
	private int AssassinCount;
	private int greenCount;
	private int turnKeeper = 0;
	private boolean gA=true;
	private boolean rA = true;
	private boolean bA = true;
	private boolean winCheck = true;
	
	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {
		window = new JFrame("CodeNames");
		window.setLayout(new GridLayout(3,1));
		Redturn = new JFrame ("Red turn");
		Redturn.setLayout(new GridLayout(6,1));
	
		Count = new TextField();
		Clue = new TextField();
		Count.setSize(200,200);
		Clue.setSize(200,200);
		
		
		JButton rc = new JButton("Count Input");
		JButton rclue = new JButton("Clue Input");
		Submit = new JButton("Submit");
		Submit.addActionListener(this);
		
		board = new JPanel(new GridLayout(5,5));
		
		bar = new JPanel(new FlowLayout());
		bar.setPreferredSize(new Dimension(8,8));
		cc = new JPanel(new GridLayout(2,2));
		
		endGame = new JButton();
		endGame.addActionListener(this);

		
		men = new JMenuBar();
		
		File = new JMenu("File");
		File.addMenuListener(this);
		men.add(File);
		
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		File.add(Exit);
		
		NewGame = new JMenuItem("2-team game");
		NewGame.addActionListener(this);
		File.add(NewGame);
		
		NewGame3 = new JMenuItem("3-team game");
		NewGame3.addActionListener(this);
		File.add(NewGame3);
		
		Easter = new JMenuItem("Try me");
		Easter.addActionListener(this);
		File.add(Easter);
		
		bar.add(men);
		window.add(bar);


		

		window.setSize(1500, 800);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);
	
	}
	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, 15));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	public void twoPlayer() {
		window = new JFrame("CodeNames");
		window.setLayout(new GridLayout(3,1));
		Redturn = new JFrame ("Red Turn");
		Redturn.setLayout(new GridLayout(5,1));
		Count = new TextField();
		Clue = new TextField();
		Count.setSize(200,200);
		Clue.setSize(200,200);
		
		gA = false;
		JButton rc = new JButton("Count Input");
		JButton rclue = new JButton("Clue Input");
		Submit = new JButton("Submit");
		Submit.addActionListener(this);
		
		board = new JPanel(new GridLayout(5,5));
		
		bar = new JPanel(new FlowLayout());
		bar.setPreferredSize(new Dimension(8,8));
		cc = new JPanel(new GridLayout(2,2));
		
		endGame = new JButton();
		endGame.addActionListener(this);
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(this);
		Clueholder = new JButton(Clue.getText());
		Counterholder = new JButton(Count.getText());
		
		men = new JMenuBar();
		
		File = new JMenu("File");
		File.addMenuListener(this);
		men.add(File);
		
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		File.add(Exit);
		
		NewGame = new JMenuItem("2-team game");
		NewGame.addActionListener(this);
		File.add(NewGame);
		
		NewGame3 = new JMenuItem("3-team game");
		NewGame3.addActionListener(this);
		File.add(NewGame3);
		
		Easter = new JMenuItem("Try me");
		Easter.addActionListener(this);
		File.add(Easter);
		
		bar.add(men);
		
		AgentSelector ag = new AgentSelector();
		ag.AgentRandomizer();
		ag.AgentSelector2();
		helper = ag.getAgents();
		for(int i = 0; i <25; i = i +1) {
		String j =	ag.getAgents().get(i).getcodeName();
		if(ag.getAgents().get(i).getAllignment() == 0) {
			 age = "Red Agent";
		}
		if(ag.getAgents().get(i).getAllignment() == 1) {
			 age = "Blue Agent";
		}
		if(ag.getAgents().get(i).getAllignment() == 2) {
			 age = "Assassin";
		}
		if(ag.getAgents().get(i).getAllignment() == 3) {
			 age = "Bystander";
		}
		if(ag.getAgents().get(i).getHidden() == false){
			JButton button = new JButton("Name:" + j + " Agent:" + age);
			setButtonProperties(button);
			board.add(button);
		}
		else {
			JButton button = new JButton(" Status:Revealed");
			setButtonProperties(button);
			board.add(button);
		}
		}
		
		cc.add(Clueholder);
		cc.add(Counterholder);
		window.add(bar);
		window.add(cc);
		window.add(board);
		
		Redturn.add(rclue);
		Redturn.add(Clue);
		Redturn.add(rc);
		Redturn.add(Count);
		Redturn.add(Submit);
		Redturn.setSize(800,800);
		Blueturn = Redturn;
		window.setSize(1500, 800);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);
		Redturn.setLocationRelativeTo(null);
		Redturn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Redturn.setVisible(true);
	}
	
	public void threePlayer() {
		window = new JFrame("CodeNames");
		window.setLayout(new GridLayout(3,1));
		Redturn = new JFrame ("Red Turn");
		Redturn.setLayout(new GridLayout(5,1));
		
		Count = new TextField();
		Clue = new TextField();
		Count.setSize(200,200);
		Clue.setSize(200,200);
		
		winCheck = false;
		JButton rc = new JButton("Count Input");
		JButton rclue = new JButton("Clue Input");
		Submit = new JButton("Submit");
		Submit.addActionListener(this);
		
		board = new JPanel(new GridLayout(5,5));
		
		bar = new JPanel(new FlowLayout());
		bar.setPreferredSize(new Dimension(8,8));
		cc = new JPanel(new GridLayout(2,2));
		
		endGame = new JButton();
		endGame.addActionListener(this);
		endTurn = new JButton("End Turn");
		endTurn.addActionListener(this);
		Clueholder = new JButton(Clue.getText());
		Counterholder = new JButton(Count.getText());
		
		men = new JMenuBar();
		
		File = new JMenu("File");
		File.addMenuListener(this);
		men.add(File);
		
		Exit = new JMenuItem("Exit");
		Exit.addActionListener(this);
		File.add(Exit);
		
		NewGame = new JMenuItem("2-team game");
		NewGame.addActionListener(this);
		File.add(NewGame);
		
		NewGame3 = new JMenuItem("3-team game");
		NewGame3.addActionListener(this);
		File.add(NewGame3);
		
		Easter = new JMenuItem("Try me");
		Easter.addActionListener(this);
		File.add(Easter);
		
		bar.add(men);
		
		AgentSelector ag = new AgentSelector();
		ag.AgentRandomizer();
		ag.AgentSelector3();
		helper = ag.getAgents();
		for(int i = 0; i <25; i = i +1) {
		String j =	ag.getAgents().get(i).getcodeName();
		if(ag.getAgents().get(i).getAllignment() == 0) {
			 age = "Red Agent";
		}
		if(ag.getAgents().get(i).getAllignment() == 1) {
			 age = "Blue Agent";
		}
		if(ag.getAgents().get(i).getAllignment() == 2) {
			 age = "Assassin";
		}
		if(ag.getAgents().get(i).getAllignment() == 3) {
			 age = "Bystander";
		}
		if(ag.getAgents().get(i).getAllignment() == 4) {
			 age = "Green Agent";
		}
		if(ag.getAgents().get(i).getHidden() == false){
			JButton button = new JButton("Name:" + j + " Agent:" + age);
			setButtonProperties(button);
			board.add(button);
		}
		else {
			JButton button = new JButton(" Status:Revealed");
			setButtonProperties(button);
			board.add(button);
		}
		}
		
		cc.add(Clueholder);
		cc.add(Counterholder);
		window.add(bar);
		window.add(cc);
		window.add(board);
		
		Redturn.add(rclue);
		Redturn.add(Clue);
		Redturn.add(rc);
		Redturn.add(Count);
		Redturn.add(Submit);
		Redturn.setSize(800,800);
		Blueturn = Redturn;
		window.setSize(1500, 800);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);
		Redturn.setLocationRelativeTo(null);
		Redturn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Redturn.setVisible(true);
	}
	
	public void turnSwitch() {
		if(turnKeeper == 0) {
		if(bA ==true) {
			turnKeeper = 1;
			Redturn.setTitle("Blue Turn");
		}
		else {
			turnKeeper =2;
			Redturn.setTitle("Green Turn");
		}
		}
		else if(turnKeeper == 1) {
			if(gA == true) {
				turnKeeper = 2;
				Redturn.setTitle("Green Turn");
			}
			else {
				turnKeeper= 0;
				Redturn.setTitle("Red Turn");
			}
		}
		else if(turnKeeper == 2) {
			if(rA == true) {
			turnKeeper = 0;
			Redturn.setTitle("Red Turn");
			}
			else {
				turnKeeper = 1;
				Redturn.setTitle("Blue Turn");
			}
		}
		board.removeAll();
		cc.removeAll();
		for(int i = 0; i <25; i = i +1) {
			
			if(helper.get(i).getAllignment() == 0) {
				 age = "Red Agent";
			}
			if(helper.get(i).getAllignment() == 1) {
				 age = "Blue Agent";
			}
			if(helper.get(i).getAllignment() == 2) {
				 age = "Assassin";
			}
			if(helper.get(i).getAllignment() == 3) {
				 age = "Bystander";
			}
			if(helper.get(i).getAllignment() == 4) {
				age = "Green Agent";
			}
			if(helper.get(i).getHidden() == false){
				JButton button = new JButton("Name:" + helper.get(i).getcodeName() +" Agent:" + age);
				setButtonProperties(button);
				button.addActionListener(new ButtonListener(i));
				board.add(button);
			}
			else {
				JButton button = new JButton(" Agent:" + age);
				setButtonProperties(button);
				board.add(button);
			}
			
			}
		Blueturn.setVisible(true);
		cc.add(Clueholder);
		cc.add(Counterholder);
		cc.add(endTurn);
		cc.revalidate();
		cc.repaint();
		board.revalidate();
		board.repaint();
	}
	public void winState() {
		if(winCheck == true) {
		if(GuessCount < 0) {
			endTurn.doClick();
		}
		if(AssassinCount == 1) {
			endGame.doClick();
		}
		if(redCount == 9) {
			endGame.doClick();
	}
	if(blueCount == 8) {
		endGame.doClick();
	}
		}
		else {
			if(GuessCount < 0) {
				endTurn.doClick();
			}
			if(AssassinCount == 2) {
				endGame.doClick();
			}
			if(redCount == 6) {
				if(rA == true) {
				endGame.doClick();
				}
		}
		if(blueCount == 5) {
			if(bA == true) {
			endGame.doClick();
			}
		}
		if(greenCount == 5) {
			if(gA== true) {
				
			
			endGame.doClick();
			}
		}
		}
	}
	public void ender() {
		window.dispose();
		Redturn.dispose();
		if(winCheck == true) {
		if(redCount == 9) {
			JFrame Winner = new JFrame("Winner");
			JLabel con = new JLabel("Congrats on winning codenames RedTeam");
			
			Winner.add(con);
			Winner.pack();
			Winner.setLocationRelativeTo(null);
			Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Winner.setVisible(true);
		}
		else if(blueCount == 8) {
			JFrame Winner = new JFrame("Winner");
			JLabel con = new JLabel("Congrats on winning codenames BlueTeam");
			
			Winner.add(con);
			Winner.pack();
			Winner.setLocationRelativeTo(null);
			Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Winner.setVisible(true);
		}
		else if(turnKeeper == 1) {
			JFrame Winner = new JFrame("Winner");
			JLabel con = new JLabel("Congrats on winning codenames BlueTeam");
			
			Winner.add(con);
			Winner.pack();
			Winner.setLocationRelativeTo(null);
			Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Winner.setVisible(true);
	}
		else {
		JFrame Winner = new JFrame("Winner");
		JLabel con = new JLabel("Congrats on winning codenames RedTeam");
		
		Winner.add(con);
		Winner.pack();
		Winner.setLocationRelativeTo(null);
		Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Winner.setVisible(true);
		}
		}
		else {
			if(redCount == 6) {
				if(rA==true) {
				JFrame Winner = new JFrame("Winner");
				JLabel con = new JLabel("Congrats on winning codenames RedTeam");
				
				Winner.add(con);
				Winner.pack();
				Winner.setLocationRelativeTo(null);
				Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Winner.setVisible(true);
				}
			}
			 if(blueCount == 5) {
				if(bA==true) {
				JFrame Winner = new JFrame("Winner");
				JLabel con = new JLabel("Congrats on winning codenames BlueTeam");
				
				Winner.add(con);
				Winner.pack();
				Winner.setLocationRelativeTo(null);
				Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Winner.setVisible(true);
				}
			}
			 if(greenCount == 5) {
				if(gA == true) {
				JFrame Winner = new JFrame("Winner");
				JLabel con = new JLabel("Congrats on winning codenames GreenTeam");
				
				Winner.add(con);
				Winner.pack();
				Winner.setLocationRelativeTo(null);
				Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Winner.setVisible(true);
				}
			}
			else {
				if(rA == false && bA == false) {
					JFrame Winner = new JFrame("Winner");
					JLabel con = new JLabel("Congrats on winning codenames GreenTeam");
					
					Winner.add(con);
					Winner.pack();
					Winner.setLocationRelativeTo(null);
					Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Winner.setVisible(true);
				}
				if(bA == false && gA == false) {
					JFrame Winner = new JFrame("Winner");
					JLabel con = new JLabel("Congrats on winning codenames RedTeam");
					
					Winner.add(con);
					Winner.pack();
					Winner.setLocationRelativeTo(null);
					Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Winner.setVisible(true);
				}
				if(gA == false && rA == false) {
					JFrame Winner = new JFrame("Winner");
					JLabel con = new JLabel("Congrats on winning codenames BlueTeam");
					
					Winner.add(con);
					Winner.pack();
					Winner.setLocationRelativeTo(null);
					Winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Winner.setVisible(true);
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Exit)) {
			System.exit(0);
		}
		if(e.getSource().equals(endGame)) {
			ender();
		}
		if(e.getSource().equals(NewGame)) {
			window.dispose();
			Redturn.dispose();
			twoPlayer();
		}
		if(e.getSource().equals(NewGame3)) {
			window.dispose();
			Redturn.dispose();
			threePlayer();
		}
		if(e.getSource().equals(endTurn)) {
		turnSwitch();
		}
		if(e.getSource().equals(Easter)) {
			EasterCounter = EasterCounter +1;
			if(EasterCounter == 5) {
				
				JFrame east = new JFrame("Secret");
				JButton easte = new JButton("You Found Me");
				east.add(easte);
				east.pack();
				east.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				east.setVisible(true);
			}
		}
		if(e.getSource().equals(Submit)) {
			boolean cluecheck = true;
			boolean guesscheck = false;
			Clueholder.setText("Clue:" + Clue.getText());
			for(int i = 0; i < helper.size(); i = i +1) {
				String j = helper.get(i).getcodeName();
				
				if(Clue.getText().equals(j)) {
					JFrame hel = new JFrame("Try Again");
					JLabel error = new JLabel("Cant use that clue. Try Again");
					cluecheck = false;
					hel.add(error);
					hel.pack();
					hel.setSize(200, 200);
					hel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					hel.setLocationRelativeTo(null);
					hel.setVisible(true);
				}
				
			}
			try {
				Integer j = new Integer( Count.getText()); 
				GuessCount = j;
				Counterholder.setText("Count:" + Count.getText());
				guesscheck = true;
			}
			catch(NumberFormatException h){
				JFrame wrong = new JFrame("Incorrect Count");
				JLabel counterror = new JLabel("Cant Use that count input. Try Again");
				
				wrong.add(counterror);
				wrong.pack();
				wrong.setSize(200,200);
				wrong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				wrong.setLocationRelativeTo(null);
				wrong.setVisible(true);
			}
			if(cluecheck == true && guesscheck == true) {
				board.removeAll();
				cc.removeAll();
				for(int i = 0; i <25; i = i +1) {
					
					if(helper.get(i).getAllignment() == 0) {
						 age = "Red Agent";
					}
					if(helper.get(i).getAllignment() == 1) {
						 age = "Blue Agent";
					}
					if(helper.get(i).getAllignment() == 2) {
						 age = "Assassin";
					}
					if(helper.get(i).getAllignment() == 3) {
						 age = "Bystander";
					}
					if(helper.get(i).getAllignment() == 4) {
						 age = "Green Agent";
					}
					if(helper.get(i).getHidden() == false){
						JButton button = new JButton("Name:" + helper.get(i).getcodeName());
						setButtonProperties(button);
						button.addActionListener(new ButtonListener(i));
						board.add(button);
					}
					else {
						JButton button = new JButton(" Agent:" + age);
						setButtonProperties(button);
						board.add(button);
					}
					Redturn.dispose();
					}
				cc.add(Clueholder);
				cc.add(Counterholder);
				cc.add(endTurn);
			}
			cc.revalidate();
			cc.repaint();
			board.revalidate();
			board.repaint();
			
		}
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Exit)) {
			System.exit(0);
		}
	}
	
	public class ButtonListener implements ActionListener {
		int use;
public ButtonListener(int i) {
	use = i;
}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			helper.get(use).reveal();
	

			GuessCount = GuessCount -1;
			boolean cluecheck = false;
			boolean guesscheck = false;
			for(int i = 0; i < helper.size(); i = i +1) {
				String j = helper.get(i).getcodeName();
				
				if(Clue.getText().equals(j)) {
					JFrame hel = new JFrame("Try Again");
					JLabel error = new JLabel("Cant use that clue. Try Again");
					
					hel.add(error);
					hel.pack();
					hel.setSize(200, 200);
					hel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					hel.setLocationRelativeTo(null);
					hel.setVisible(true);
				}
				else {
					cluecheck = true;
				}
			}
			try {
				Integer j = new Integer( Count.getText()); 
				 int p= Integer.parseInt(Count.getText());
				 p = p-1;
				 Count.setText("" +p);
				 Counterholder.setText("" + p);
				guesscheck = true;
			}
			catch(NumberFormatException h){
				JFrame wrong = new JFrame("Incorrect Count");
				JLabel counterror = new JLabel("Cant Use that count input. Try Again");
				
				wrong.add(counterror);
				wrong.pack();
				wrong.setSize(200,200);
				wrong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				wrong.setLocationRelativeTo(null);
				wrong.setVisible(true);
			}
			if(cluecheck == true && guesscheck == true) {
				board.removeAll();
				cc.removeAll();
				for(int i = 0; i <25; i = i +1) {
					
					if(helper.get(i).getAllignment() == 0) {
						 age = "Red Agent";
					}
					if(helper.get(i).getAllignment() == 1) {
						 age = "Blue Agent";
					}
					if(helper.get(i).getAllignment() == 2) {
						 age = "Assassin";
					}
					if(helper.get(i).getAllignment() == 3) {
						 age = "Bystander";
					}
					if(helper.get(i).getAllignment() == 4) {
						 age = "Green Agent";
					}
					if(helper.get(i).getHidden() == false){
						JButton button = new JButton("Name:" + helper.get(i).getcodeName());
						setButtonProperties(button);
						button.addActionListener(new ButtonListener(i));
						board.add(button);
					}
					else {
						JButton button = new JButton(" Agent:" + age);
						setButtonProperties(button);
						board.add(button);
					}
					}
				cc.add(Clueholder);
				cc.add(Counterholder);
				cc.add(endTurn);
			}
			cc.revalidate();
			cc.repaint();
			board.revalidate();
			board.repaint();
			if(helper.get(use).getAllignment() == 0) {
				redCount = redCount +1;
				if(turnKeeper != 0) {
					endTurn.doClick();
				}
			}
if(helper.get(use).getAllignment() == 1) {
				blueCount = blueCount +1;
				if(turnKeeper != 1) {
					endTurn.doClick();
				}
			}
if(helper.get(use).getAllignment() == 4) {
	greenCount = greenCount +1;
	if(turnKeeper != 2) {
		endTurn.doClick();
	}
}
if(helper.get(use).getAllignment() == 2) {
	if(turnKeeper == 0) {
		rA = false;
	}
	if(turnKeeper == 1) {
		bA = false;
	}
	if(turnKeeper == 2) {
		gA = false;
	}
	AssassinCount = AssassinCount +1;
	endTurn.doClick();
}
if(helper.get(use).getAllignment() == 3) {
	endTurn.doClick();
}
winState();
	}
}
}
