package Tests;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JTextArea;

import org.junit.Test;
import ProcessOperations.Operations;

public class TestOperations {
	Operations operation;
	private static final double DELTA = 1e-15;
	
	@Test
	public void testSimpleAddition() {
		
		operation = new Operations();
		operation.ProcessSimpleAddition("50+5");
		assertEquals(55,operation.getCurrentResult(), DELTA);
	}

	@Test
	public void testSimpleSubtraction() {
		
		operation = new Operations();
		operation.ProcessSimpleSubtraction("50-5");
		assertEquals(45,operation.getCurrentResult(), DELTA);
	}
	
	@Test
	public void testSimpleMultiplication() {
		
		operation = new Operations();
		operation.ProcessSimpleMultiplication("50*5");
		assertEquals(250,operation.getCurrentResult(), DELTA);
	}
	
	@Test
	public void testSimpleDivision() {
		
		operation = new Operations();
		operation.ProcessSimpleDivision("100/4");
		assertEquals(25,operation.getCurrentResult(), DELTA);
	}
	
	@Test
	public void testFinalResult(){
		
		operation = new Operations();
		JTextArea userTextArea = new JTextArea();
		userTextArea.setText("789");
		JTextArea resultTextArea = new JTextArea();
		resultTextArea.setText("25+35-10*5+50-20*");
		operation.setCurrentResult(280);
		operation.processFinalResult(userTextArea,resultTextArea);
		
		assertEquals(220920.0, operation.getCurrentResult(), DELTA);
	}
	
	@Test
	public void processLastAction(){
		
		operation = new Operations();
		JTextArea userTextArea = new JTextArea();
		JTextArea resultTextArea = new JTextArea();
		
		/*Addition Case*/
		userTextArea.setText("25");
		resultTextArea.setText("5+80-55*5+78+");
		operation.setCurrentResult(150);
		operation.processLastAction("78", false, userTextArea, resultTextArea);
		assertEquals(228, operation.getCurrentResult(),DELTA);
		
		/*Subtraction Case*/
		resultTextArea.setText("5+80-55*5-78+");
		operation.setCurrentResult(150);
		operation.processLastAction("78", false, userTextArea, resultTextArea);
		assertEquals(72, operation.getCurrentResult(),DELTA);
		
		/*Multiplication Case*/
		resultTextArea.setText("5+80-55*5*78+");
		operation.setCurrentResult(150);
		operation.processLastAction("78", false, userTextArea, resultTextArea);
		assertEquals(11700, operation.getCurrentResult(),DELTA);
		
		/*Division Case*/
		resultTextArea.setText("5+80-55*5/78+");
		operation.setCurrentResult(150);
		operation.processLastAction("78", false, userTextArea, resultTextArea);
		DecimalFormat df = new DecimalFormat("#.0");
		assertEquals("1.9", df.format(operation.getCurrentResult()));
	}
	
	@Test
	public void testProcessOperatorButton(){
		
		operation = new Operations();
		JTextArea userTextArea = new JTextArea();
		userTextArea.setText("50");
		JTextArea resultTextArea = new JTextArea();
		JButton operatorPressed = null;
		
		/*Addition case*/
		operatorPressed = new JButton("+");
		operation.processOperatorButton(operatorPressed, "addition", userTextArea, resultTextArea);
		assertEquals("50+", resultTextArea.getText());
		assertEquals(50.0, operation.getCurrentResult(), DELTA);
		
		/*Subtraction case*/
		operation.setCurrentResult(0);
		resultTextArea.setText("");
		operatorPressed = new JButton("-");
		operation.processOperatorButton(operatorPressed, "subtraction", userTextArea, resultTextArea);
		assertEquals("50-", resultTextArea.getText());
		assertEquals(50.0, operation.getCurrentResult(), DELTA);
		
		/*Multiplication case*/
		operation.setCurrentResult(0);
		resultTextArea.setText("");
		operatorPressed = new JButton("*");
		operation.processOperatorButton(operatorPressed, "multiplication", userTextArea, resultTextArea);
		assertEquals("50*", resultTextArea.getText());
		assertEquals(50.0, operation.getCurrentResult(), DELTA);
		
		/*Division case*/
		operation.setCurrentResult(0);
		resultTextArea.setText("");
		operatorPressed = new JButton("/");
		operation.processOperatorButton(operatorPressed, "division", userTextArea, resultTextArea);
		assertEquals("50/", resultTextArea.getText());
		assertEquals(50.0, operation.getCurrentResult(), DELTA);
	}
	
	@Test
	public void testProcessNumericalButton(){
		
		operation = new Operations();
		JButton buttonPressed = null;
		buttonPressed = new JButton("7");
		JTextArea userTextArea = new JTextArea();
		JTextArea resultTextArea = new JTextArea();
		
		/*case when the user pressed a single button*/
		operation.processNumericalButton(buttonPressed, userTextArea);
		assertEquals("7", userTextArea.getText());
		
		/*case when the user pressed another number subsequently*/
		buttonPressed = new JButton("5");
		operation.processNumericalButton(buttonPressed, userTextArea);
		assertEquals("75", userTextArea.getText());
		
		/*case when the user pressed another number after they had pressed an operator(/+-*) */
		JButton operatorPressed = new JButton("+");
		operation.processOperatorButton(operatorPressed, "addition", userTextArea, resultTextArea);
		buttonPressed = new JButton("2");
		operation.processNumericalButton(buttonPressed, userTextArea);
		assertEquals("2", userTextArea.getText());
	}
	
}
