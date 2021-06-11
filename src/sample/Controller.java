package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Controller {

    @FXML
    public TextField monthFiled;

    @FXML
    public TextField monthResponse;

    @FXML
    private Text wrongTextMonth;

    @FXML
    private TextField textFiled;

    @FXML
    private Text wrongText;

    @FXML
    private TextField d1Filed;

    @FXML
    private TextField d2Filed;

    public void onEnter(ActionEvent e) {
        int number;
        try {
            number = Integer.parseInt(textFiled.getText());
        }catch (Exception e1) {
            wrongText.setText("Неправильний числовий фонрмат");
            return;
        }
        if(number < 100 || number > 999) {
            wrongText.setText("Число не входить в діапазон 100-999");
            return;
        }
        wrongText.setText("");
        d1Filed.setText(String.valueOf(number / 100));
        d2Filed.setText(String.valueOf(number % 10));
    }

    public void onEnterMonth(ActionEvent actionEvent) {
        int number;
        try {
            number = Integer.parseInt(monthFiled.getText());
        }catch (Exception e1) {
            wrongTextMonth.setText("Неправильний числовий фонрмат");
            return;
        }
        try {
            TimeOfTheYearEnum en = TimeOfTheYearEnum.getByMonthID(number);
            monthResponse.setText(en.getName());
            wrongTextMonth.setText("");
        }catch (Exception e) {
            wrongTextMonth.setText("Неправильний номер місяця");
            return;
        }
    }
}
