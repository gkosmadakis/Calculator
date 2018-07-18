package ProcessOperations;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GUICalculator extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea userTextArea, resultTextArea;
	private JButton CButton, CEButton,backspaceButton,sevenButton,eightButton,nineButton,fourButton,fiveButton,sixButton,
	oneButton,twoButton,threeButton,mulButton,divdButton,plusButton,minusButton,zeroButton,equalButton,commaButton;
	Operations operation;

	public GUICalculator(){
							/*The constructor to initialize the frame with the text areas and the buttons */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,280);
		setTitle("Calculator");

		resultTextArea = new JTextArea(1,1);
		resultTextArea.setText("");
		resultTextArea.setEditable(false);

		userTextArea = new JTextArea(1,1);
		userTextArea.setText("0");

		add(resultTextArea, BorderLayout.NORTH);
		add(userTextArea, BorderLayout.CENTER);

		Guilayout();
		operation = new Operations();
	
		userTextAreaKeyListener();
	}

	public void Guilayout(){
							/*This method initializes the buttons and adds listeners for them*/
		JPanel panel = new JPanel(new GridLayout(5,4));
		
		AbstractAction buttonPressed = buttonListener();
		
		CEButton = new JButton("CE");
		panel.add(CEButton);
		CEButton.addActionListener(this);
		
		CButton = new JButton("C");
		panel.add(CButton);
		CButton.addActionListener(this);
		
		backspaceButton = new JButton("X");
		panel.add(backspaceButton);
		backspaceButton.addActionListener(this);
		
		divdButton = new JButton("/");
		panel.add(divdButton);
		divdButton.addActionListener(this);
		
		sevenButton = new JButton("7");
		sevenButton.addActionListener(buttonPressed);
		sevenButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7,0), "test");
		sevenButton.getActionMap().put("test", buttonPressed);
		panel.add(sevenButton);
		
		eightButton = new JButton("8");
		eightButton.addActionListener(buttonPressed);
		eightButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8,0), "test");
		eightButton.getActionMap().put("test", buttonPressed);
		panel.add(eightButton);
		
		nineButton = new JButton("9");
		nineButton.addActionListener(buttonPressed);
		nineButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_9,0), "test");
		nineButton.getActionMap().put("test", buttonPressed);
		panel.add(nineButton);
		
		mulButton = new JButton("*");
		panel.add(mulButton);
		mulButton.addActionListener(this);
		
		fourButton = new JButton("4");
		fourButton.addActionListener(buttonPressed);
		fourButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_4,0), "test");
		fourButton.getActionMap().put("test", buttonPressed);
		panel.add(fourButton);
		
		fiveButton = new JButton("5");
		fiveButton.addActionListener(buttonPressed);
		fiveButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5,0), "test");
		fiveButton.getActionMap().put("test", buttonPressed);
		panel.add(fiveButton);
		
		sixButton = new JButton("6");
		sixButton.addActionListener(buttonPressed);
		sixButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6,0), "test");
		sixButton.getActionMap().put("test", buttonPressed);
		panel.add(sixButton);
		
		minusButton = new JButton("-");
		panel.add(minusButton);
		minusButton.addActionListener(this);
		
		oneButton = new JButton("1");
		oneButton.addActionListener(buttonPressed);
		oneButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1,0), "test");
		oneButton.getActionMap().put("test", buttonPressed);
		panel.add(oneButton);
		
		twoButton = new JButton("2");
		panel.add(twoButton);
		twoButton.addActionListener(buttonPressed);
		twoButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2,0), "test");
		twoButton.getActionMap().put("test", buttonPressed);
		
		threeButton = new JButton("3");
		threeButton.addActionListener(buttonPressed);
		threeButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3,0), "test");
		threeButton.getActionMap().put("test", buttonPressed);
		panel.add(threeButton);
		
		plusButton = new JButton("+");
		panel.add(plusButton);
		plusButton.addActionListener(this);
		
		zeroButton = new JButton("0");
		zeroButton.addActionListener(buttonPressed);
		zeroButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0,0), "test");
		zeroButton.getActionMap().put("test", buttonPressed);
		panel.add(zeroButton);
		
		commaButton = new JButton(".");
		panel.add(commaButton);
		commaButton.addActionListener(this);
		
		equalButton = new JButton("=");
		panel.add(equalButton);
		equalButton.addActionListener(this);
		
		add(panel, BorderLayout.SOUTH);
		
		panel.setPreferredSize(new Dimension(80,205));
	}

	public void actionPerformed(ActionEvent e){
									/*This method listens to action for all the buttons apart from the number ones */
		if (e.getSource()==CEButton){

			userTextArea.setText("0");
			
			if (resultTextArea.getText().length() == 0) {
			
				userTextArea.setText("0");
				operation.setCurrentResult(0);
				
			}
			
			userTextArea.requestFocus();
		}
		
		if (e.getSource()==CButton){

			userTextArea.setText("0");
			
			resultTextArea.setText("");
			operation.setCurrentResult(0);
			
			userTextArea.requestFocus();
		}
		
		if (e.getSource()==backspaceButton){

			if (userTextArea.getText().length() >0) {
				
				userTextArea.setText(userTextArea.getText().substring(0, userTextArea.getText().length() -1 ));
			}
			
			userTextArea.requestFocus();
		}
		
		if (e.getSource()==commaButton){

			userTextArea.append(commaButton.getText());
			userTextArea.requestFocus();
		}

		if (e.getSource() == plusButton){
			
			operation.processOperatorButton(plusButton, "addition",userTextArea, resultTextArea);
		}				  

		if (e.getSource() == minusButton){

			operation.processOperatorButton(minusButton, "subtraction",userTextArea,resultTextArea);
		}

		if (e.getSource() == mulButton) {

			operation.processOperatorButton(mulButton, "multiplication",userTextArea,resultTextArea);
		}

		if (e.getSource() == divdButton) {

			operation.processOperatorButton(divdButton, "division",userTextArea,resultTextArea);
		}

		if (e.getSource() == equalButton){

			operation.processFinalResult(userTextArea, resultTextArea);
		}

	}
	
	private AbstractAction buttonListener() {
		AbstractAction buttonPressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
						/*This is the action listener for the number buttons */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == oneButton){

					operation.processNumericalButton(oneButton,userTextArea);

				}

				if (e.getSource() == twoButton){
					
					operation.processNumericalButton(twoButton, userTextArea);

				}

				if (e.getSource() == threeButton){

					operation.processNumericalButton(threeButton, userTextArea);

				}
				
				if (e.getSource() == fourButton){
					
					operation.processNumericalButton(fourButton, userTextArea);

				}
				
				if (e.getSource() == fiveButton){

					operation.processNumericalButton(fiveButton,userTextArea);

				}
				
				if (e.getSource() == sixButton){

					operation.processNumericalButton(sixButton, userTextArea);

				}
				
				if (e.getSource() == sevenButton){

					operation.processNumericalButton(sevenButton, userTextArea);

				}
				
				if (e.getSource() == eightButton){

					operation.processNumericalButton(eightButton, userTextArea);

				}
				
				if (e.getSource() == nineButton){

					operation.processNumericalButton(nineButton, userTextArea);

				}
				
				if (e.getSource() == zeroButton){

					operation.processNumericalButton(zeroButton, userTextArea);

				}
			}
		};
		
		return buttonPressed;
	}
	/*This is a key listener for the area where the user types. Listens to keyboard keys*/
	private void userTextAreaKeyListener() {
		userTextArea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
				||e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_6
				||e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_9
				||e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_MINUS
				||e.getKeyCode() == KeyEvent.VK_MULTIPLY || e.getKeyCode() == KeyEvent.VK_DIVIDE) {
	
					if (userTextArea.getText().equals("0"))  {
	
						userTextArea.setText(null);
	
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ADD) {
	
					operation.processOperatorButton(plusButton, "addition",userTextArea,resultTextArea);
	
				}
	
				if (e.getKeyCode() == KeyEvent.VK_MINUS) {
	
					operation.processOperatorButton(minusButton, "subtraction",userTextArea,resultTextArea);
				}
	
				if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
	
					operation.processOperatorButton(mulButton, "multiplication",userTextArea,resultTextArea);
				}
	
				if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
	
					operation.processOperatorButton(divdButton, "division",userTextArea,resultTextArea);
				}
	
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	
					operation.processFinalResult(userTextArea, resultTextArea);;
					userTextArea.getDocument().putProperty("filterNewlines", Boolean.TRUE);
				}
	
			}
			/*This is executed when the user releases a key from the keyboard*/
			public void keyReleased(KeyEvent e) {
	
				if (e.getKeyCode() == KeyEvent.VK_ADD) {
	
					userTextArea.setText(userTextArea.getText().replace(plusButton.getText(), ""));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_MINUS) {
	
					userTextArea.setText(userTextArea.getText().replace(minusButton.getText(), ""));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
	
					userTextArea.setText(userTextArea.getText().replace(mulButton.getText(), ""));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
	
					userTextArea.setText(userTextArea.getText().replace(divdButton.getText(), ""));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
						||e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_6
						||e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_9
						||e.getKeyCode() == KeyEvent.VK_0) {
	
					userTextArea.setText(userTextArea.getText().substring(0,userTextArea.getText().length()-1));
				}
			}
		});
	}

	/*Getters */
	public JTextArea getUserTextArea(){

		return userTextArea;
	}
	

}	
