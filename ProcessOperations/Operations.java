package ProcessOperations;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JTextArea;

import Interfaces.OperationsInterface;

public class Operations implements OperationsInterface {
	
	private double result, secondToLastResult;
	private boolean operatorIsPressed, userHasPressedANumber;
	
	/*This method calculates the result of an operation which can be addition, subtraction, multiplication division*/
	@Override
	public double ProcessOperation(String numberToProcess, String operation, JTextArea userTextArea) {
		
		double currentResult = this.getCurrentResult();
		
		if (operation.equals("addition")) {
			
			currentResult += Double.parseDouble(numberToProcess);
		}
		
		if (operation.equals("subtraction")) {
			
			currentResult -= Double.parseDouble(numberToProcess);
		}
	
		if (operation.equals("multiplication")) {
			
			currentResult = currentResult * Double.parseDouble(numberToProcess);
		}
		
		if (operation.equals("division")) {
			
			currentResult = currentResult / Double.parseDouble(numberToProcess);
		}
		
		result = currentResult;
		
		System.out.println(result);
		
		userTextArea.setText(String.valueOf(result));
		
		return currentResult;
	}
				/*This method calculates the result of a simple addition of two numbers i.e 5+5 */
	@Override
	public void ProcessSimpleAddition(String textArea) {
		
		double currentResult = this.getCurrentResult();

		String [] total = textArea.split("\\+"); 

		if (textArea.contains("+")){
			
			if(total.length > 1) {
	
				currentResult = Double.parseDouble(total[0]) + Double.parseDouble(total[1]);	
	
			}
			
			else {
				
				if (!total[0].isEmpty()){
					
					currentResult += Double.parseDouble(total[0]);
				}
			}
		}
		
		result = currentResult;
		System.out.println(result);
		
	}
					/*This method calculates the result of a simple subtraction of two numbers i.e 15-5 */
	@Override
	public void ProcessSimpleSubtraction(String textArea) {
		
		double currentResult = this.getCurrentResult();

		String [] total = textArea.split("\\-"); 
		
		if (textArea.contains("-")){

			if(total.length > 1) {
	
				currentResult = Double.parseDouble(total[0]) - Double.parseDouble(total[1]);	
	
			}
			
			else {
	
				currentResult = Double.parseDouble(total[0]);
			}
		}
		
		result = currentResult;
		System.out.println(result);
		
	}
					/*This method calculates the result of a simple multiplication of two numbers i.e 5*5 */
	@Override
	public void ProcessSimpleMultiplication(String textArea) {
		
		double currentResult = this.getCurrentResult();

		String [] total = textArea.split("\\*"); 
		
		if (textArea.contains("*")){
			
		
			if(total.length > 1) {

				currentResult = Double.parseDouble(total[0]) * Double.parseDouble(total[1]);	
			}

			else {

				currentResult = Double.parseDouble(total[0]);
			}	
		}
		
		result = currentResult;
		System.out.println(result);
		
	}
							/*This method calculates the result of a simple division of two numbers i.e 5/5 */
	@Override
	public void ProcessSimpleDivision(String textArea) {
		
		double currentResult = this.getCurrentResult();

		String [] total = textArea.split("\\/"); 
		
		if (textArea.contains("/")){
			
		
			if(total.length > 1) {
	
				currentResult = Double.parseDouble(total[0]) / Double.parseDouble(total[1]);	
			}
	
			else {
	
				currentResult = Double.parseDouble(total[0]);
			}
		}
		
		result = currentResult;
		System.out.println(result);
		
	}
				/*This method calculates the final result when user presses equal button or Enter in keyboard */
	@Override
	public void processFinalResult(JTextArea userTextArea,JTextArea resultTextArea) {
		
		String textAreaToProcess = resultTextArea.getText()+""+userTextArea.getText();
		
		String [] numbers = textAreaToProcess.split("[-+*/]");
		
		if (numbers.length > 1){
			secondToLastResult = Double.parseDouble(numbers[numbers.length-1]);
		}
		
		if ((numbers.length == 1 || numbers.length ==2) && resultTextArea.getText().contains("+")) {
			ProcessSimpleAddition(textAreaToProcess);
		}

		else if ((numbers.length == 1 || numbers.length ==2) && resultTextArea.getText().contains("-")){
			ProcessSimpleSubtraction(textAreaToProcess);
		}

		else if ((numbers.length == 1 || numbers.length ==2)  && resultTextArea.getText().contains("*")){
			ProcessSimpleMultiplication(textAreaToProcess);
		}

		else if ((numbers.length == 1 || numbers.length ==2) && resultTextArea.getText().contains("/")){
			ProcessSimpleDivision(textAreaToProcess);
		}

		else {

			String lastNumberPressed = userTextArea.getText();

			processLastAction(lastNumberPressed, true, userTextArea, resultTextArea);
		}
		
		DecimalFormat df = new DecimalFormat("#.0");
		userTextArea.setText(String.valueOf(df.format(result)));
		resultTextArea.setText("");
		userHasPressedANumber = false;
		userTextArea.requestFocus();
		
	}
			/*This method finds what was the last operation in a sequence of operations in order to calculate the result so far */
	@Override
	public void processLastAction(String lastNumberPressed,
			boolean isFinalResult,JTextArea userTextArea,JTextArea resultTextArea) {
		
		String lastAction = "";
		
		if (isFinalResult){
			
			if (resultTextArea.getText().length() > 0) {
				
				lastAction =  resultTextArea.getText().
					substring(resultTextArea.getText().length()-1,resultTextArea.getText().length());	
			}
			
			else {
				
				lastAction =  userTextArea.getText().
						substring(userTextArea.getText().length()-lastNumberPressed.length(),userTextArea.getText().length());
				
				if (!lastAction.startsWith("-")){
					lastAction = "+";
					lastNumberPressed = String.valueOf(secondToLastResult);
				}
				
				else {
					
					lastAction = "-";
					lastNumberPressed = String.valueOf(secondToLastResult);
				}
			}
		}
			
		else {
			
			lastAction =  resultTextArea.getText().substring(resultTextArea.getText().length()
					-2-lastNumberPressed.length(),resultTextArea.getText().length());
		}
		
		if (lastAction.startsWith("+")){
			ProcessOperation(lastNumberPressed, "addition",userTextArea);
		}

		else if (lastAction.startsWith("-")){
			ProcessOperation(lastNumberPressed, "subtraction",userTextArea);
		}

		else if (lastAction.startsWith("*")){
			ProcessOperation(lastNumberPressed, "multiplication",userTextArea);
		}

		else if (lastAction.startsWith("/")){
			ProcessOperation(lastNumberPressed, "division",userTextArea);
		}
		
	}
			/*This method processes the click of an operator /*-+ */
	@Override
	public void processOperatorButton(JButton operatorPressed, String operation, JTextArea userTextArea,JTextArea resultTextArea) {
		
		operatorIsPressed = true;
		String updatedArea = "";

		updatedArea = userTextArea.getText()+ operatorPressed.getText();

		if (result == Double.parseDouble(userTextArea.getText()) && !userHasPressedANumber) {

			if(resultTextArea.getText().length() > 0) {
				
				String resultTextWithoutlastOperator = resultTextArea.getText().substring(0,resultTextArea.getText().length() - 1);
				updatedArea = operatorPressed.getText();
				resultTextArea.setText(resultTextWithoutlastOperator + updatedArea);
			}
			else {
				
				updatedArea = userTextArea.getText()+ operatorPressed.getText();
				resultTextArea.append(updatedArea);
			}
		}

		else {
			
			resultTextArea.append(updatedArea);
			/*Process a simple addition*/
			String [] numbers = resultTextArea.getText().split("[-+*/]");
			String [] operators = resultTextArea.getText().replace(".","").replaceFirst("^[0-9]+", "").split("[0-9]+");

			if ((numbers.length == 1 || numbers.length == 2) && operators.length == 1) {
				
				if (operation.equals("addition")) {
						ProcessSimpleAddition(resultTextArea.getText());
				}
				if (operation.equals("subtraction")) {
						ProcessSimpleSubtraction(resultTextArea.getText());
				}
		
				if (operation.equals("multiplication")) {
						ProcessSimpleMultiplication(resultTextArea.getText());
				}
				if (operation.equals("division")) {
						ProcessSimpleDivision(resultTextArea.getText());
				}
			}

			else {

				String lastNumberPressed = userTextArea.getText();

				processLastAction(lastNumberPressed, false, userTextArea, resultTextArea);
			}
			
			userHasPressedANumber = false;
		}
	
		userTextArea.requestFocus();
		
	}
					/*This method processes the click of a numerical button and appends the user text area */
	@Override
	public void processNumericalButton(JButton buttonPressed,JTextArea userTextArea) {
		
		if (userTextArea.getText().equals("0"))  {

			userTextArea.setText(null);

		}
		
		if(!operatorIsPressed || userHasPressedANumber){
			userTextArea.append(buttonPressed.getText());
		}
		else {
			userTextArea.setText(buttonPressed.getText());
			userHasPressedANumber = true;
		}
		userTextArea.requestFocus();
		
	}
	/*Getters and setters */
	public double getCurrentResult() {

		return result;
	}
	
	public void setCurrentResult(double result) {
		this.result = result;
	}
}
