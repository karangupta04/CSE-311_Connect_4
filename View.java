
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

import View.ButtonListener;

//import View.ButtonListener;

public class View extends JFrame {
	
	private JPanel cellPanel, buttonPanel;
	private JLabel status;
	private JButton[] columnButtons;
	private static int CELL_SIZE = 100; // adjust this for larger or smaller cells
	//private ButtonListener btnListener;
	
	public static final Color BACKGROUND_COLOR = new Color(128, 128, 128);
	public static final Color EMPTY_CELL_COLOR = Color.WHITE;
	public static final Color PLAYER1_COLOR = Color.BLUE;
	public static final Color PLAYER2_COLOR = Color.RED;
	public static final int BOUNDARY = 8;
	private int player;

	public View() {
		super("Connect 4");
		this.player = 0;
		setBackground(BACKGROUND_COLOR);
		btnListener = new ButtonListener();
		
		frameSetup();
		cellPanelSetup();
		buttonPanelSetup();
		statusSetup();
		pack();
		setVisible(true);
		
		
		
	}
	
	private void frameSetup() {
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void buttonPanelSetup() {
		buttonPanel = new JPanel(new GridLayout(1, 0));
		columnButtons = new JButton[columns];
		for (int i = 0; i < columns; i++) {
			columnButtons[i] = new JButton("" + i);
			columnButtons[i].setToolTipText("Move in column " + i);
			buttonPanel.add(columnButtons[i]);
			columnButtons[i].addActionListener(this.btnListener);
		}
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void statusSetup() {
		status = new JLabel("Player 1's turn...", JLabel.CENTER);
		add(status, BorderLayout.NORTH);
	}

	private void cellPanelSetup() {
		// The layout is based on the number of rows
		cellPanel = new JPanel(new GridLayout(rows, 0));
		cellPanel.setPreferredSize(new Dimension(CELL_SIZE * columns, CELL_SIZE * rows));

		// Each square in the grid is a Square object
		cells = new Cell[rows][columns];
		for (int row = 0; row < cells.length; row++) {
			for (int cell = 0; cell < cells[0].length; cell++) {
				cells[row][cell] = new Cell();
				cellPanel.add(cells[row][cell]);
			}
		}
		add(cellPanel, BorderLayout.CENTER);
	}

	


	public void paintComponent(Graphics g) {
		super.findComponentAt(g);
		if(player==0) {
			g.setColor(EMPTY_CELL_COLOR);
		}
		else if(player==1) {
			g.setColor(PLAYER1_COLOR);
		}
		else if(player==2) {
			g.setColor(PLAYER2_COLOR);
		}
		g.fillOval(BOUNDARY, BOUNDARY, this.getWidth() - 1 * BOUNDARY,
				this.getHeight() - 1 * BOUNDARY);
		
	}
	
	
	

}

