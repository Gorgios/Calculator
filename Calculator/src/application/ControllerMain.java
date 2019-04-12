package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class ControllerMain {
	@FXML
	private Button close_button;
	@FXML
	private Button minus_label;
	@FXML
	private Label result_label;
	@FXML
	private Button add_Label ;
	@FXML
	private Button mul_Label ;
	@FXML
	private Button div_Label ;
	@FXML
	private Button sub_Label ;
	@FXML
	private Button equal_Label ;
	@FXML
	private Button Label0 ;
	@FXML
	private Button Label1 ;
	@FXML
	private Button Label2 ;
	@FXML
	private Button Label3 ;
	@FXML
	private Button Label4 ;
	@FXML
	private Button Label5 ;	
	@FXML
	private Button Label6 ;
	@FXML
	private Button Label7 ;
	@FXML
	private Button Label8 ;
	@FXML
	private Button Label9 ;
	@FXML
	private Button labelOpen;
	@FXML
	private Button labelClose;
	@FXML 
	private Button dotLabel;
	@FXML
	private Button powerLabel;
	@FXML
	private Button backspaceLabel;
	Stage stage;
	calculator Calc = new calculator("");
	@FXML 
	private void closeScene(ActionEvent event) {
		stage = (Stage)((Button)event.getSource()).getScene().getWindow();
		stage.close();
	}
	@FXML
	private void on_C(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult("");
	    result_label.setText(Calc.getResult());
	}
	@FXML
	private void on_plus(ActionEvent event) {
	    // Button was clicked, do something…
		Calc.setResult(Calc.getResult()+" + ");
	    result_label.setText(Calc.getResult());
	}
	@FXML
	private void on_sub(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+" - ");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_div(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+" / ");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_mul(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+" * ");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_sqrt(ActionEvent event) {
	    Calc.setResult(Calc.getResult()+" √ ");
	    result_label.setText(Calc.getResult());
	}
	@FXML
	private void on_backspace(ActionEvent event) {
		if (!Calc.getResult().isEmpty() ) {
			Calc.setResult(Calc.getResult().substring(0,Calc.getResult().length()-1));
	    	result_label.setText(Calc.getResult());
		}
	}
	@FXML
	private void on_dot(ActionEvent event) {
	    Calc.setResult(Calc.getResult()+".");
	    result_label.setText(Calc.getResult());
	}
	@FXML
	private void on_power(ActionEvent event) {
	    Calc.setResult(Calc.getResult()+" ² ");
	    result_label.setText(Calc.getResult());
	}
	@FXML
	private void on_0(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"0");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_1(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"1");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_2(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"2");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_3(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"3");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_4(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"4");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_5(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"5");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_6(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"6");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_7(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"7");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_8(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"8");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_9(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+"9");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_close(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+" ) ");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_open(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.getResult()+" ( ");
	    result_label.setText(Calc.getResult());
	    
	}
	@FXML
	private void on_minus(ActionEvent event) {
		Calc.setResult(Calc.getResult()+"-");
	    result_label.setText(Calc.getResult());
	}
	@FXML
	private void on_equal(ActionEvent event) {
	    // Button was clicked, do something…
	    Calc.setResult(Calc.calculate(Calc.rpnChange(Calc.getResult())));
	    result_label.setText(Calc.getResult());
	    
	}
	
}