package Interfaces;

import javax.swing.JButton;
import javax.swing.JTextArea;


public interface OperationsInterface {

	public double ProcessOperation(String numberToProcess, String operation,JTextArea userTextArea);
	public void ProcessSimpleAddition(String textArea);
	public void ProcessSimpleSubtraction(String textArea);
	public void ProcessSimpleMultiplication(String textArea);
	public void ProcessSimpleDivision(String textArea);
	public void processFinalResult(JTextArea userTextArea,JTextArea resultTextArea);
	public void processLastAction(String lastNumberPressed, boolean isFinalResult,JTextArea userTextArea,JTextArea resultTextArea);
	public void processOperatorButton(JButton operatorPressed, String operation, JTextArea textarea,JTextArea resultTextArea);
	public void processNumericalButton(JButton buttonPressed,JTextArea userTextArea);
	
}
