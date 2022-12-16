package simpleFX2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    int i =0;
    String str = "";
    
    @FXML
    private Button Ofra; //Ofra Button

    @FXML
    private Button Yardena; //Yardena Button

    @FXML
    private Label counter; //Label with the counter
    // on action will increase or decrease the counter
    @FXML
    void initialize() {
       Ofra.setOnAction(event -> {
           i++;
           counter.setText(str+i);
       });
       Yardena.setOnAction(event ->{
           i--;
           counter.setText(str+i);
       });

    }
}
