import ProcessOperations.GUICalculator;


public class CalculatorMain {
	public static void main( String [] args){
		
		GUICalculator guiCalc = new GUICalculator();
		guiCalc.setVisible(true);
		
		guiCalc.getUserTextArea().getCaret().setVisible(true);
		guiCalc.getUserTextArea().setCaretPosition(guiCalc.getUserTextArea().getCaretPosition() + 1);
		guiCalc.getUserTextArea().requestFocus();
		
		
		
		
	}
}
