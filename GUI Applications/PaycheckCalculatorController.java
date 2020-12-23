// Author: @shazebs
// Date:   12/23/20
// Time:   12:30 AM

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;


public class PaycheckCalculatorController {

    // formatters for currency and percentages
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private BigDecimal taxPercentage = new BigDecimal(0.9);     // -10% default


    @FXML private TextField hoursTextField;
    @FXML private TextField wageTextField;
    @FXML private TextField totalTextField;


    // calculate and displays total
    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            BigDecimal hours = new BigDecimal(hoursTextField.getText());
            BigDecimal wage = new BigDecimal(wageTextField.getText());
            BigDecimal total = hours.multiply(wage);
            BigDecimal totalAfterTaxes = total.multiply(taxPercentage);

            totalTextField.setText(currency.format(totalAfterTaxes));
        }
        catch (NumberFormatException e) {
            hoursTextField.setText("Enter Hours");
            wageTextField.setText("");
            hoursTextField.selectAll();
            hoursTextField.requestFocus();

        }
    }

    // called by FXMLLoader to initialize the controller
    public void initialize() {
        // 0-4 rounds down, 5-9 rounds up
        currency.setRoundingMode(RoundingMode.HALF_UP);
    }

}

