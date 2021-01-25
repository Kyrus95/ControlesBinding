package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    final MyNumber myNum = new MyNumber();
    @FXML
    private Label lblStatus;
    @FXML
    private ProgressBar pb;
    @FXML
    ProgressIndicator pi;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myNum.setNumber(0);
        myNum.numberProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                lblStatus.setText(new Double(myNum.getNumber()).toString());
                    pb.progressProperty().bind(myNum.numberProperty());
                    pi.progressProperty().bind(myNum.numberProperty());
            }
        });
    }
    public void BTN1Click(ActionEvent event){
        myNum.setNumber(myNum.getNumber()+0.1);
    }
    public void BTN2Click(ActionEvent event){
        myNum.setNumber(myNum.getNumber()-0.1);
    }
}
