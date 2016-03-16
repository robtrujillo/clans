package Calculator.Main;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridLayout.Spec;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FirstAndroidCalculator extends Activity {

    static final int GRID_ROW_COUNT = 4;
    static final int GRID_COL_COUNT = 5;
    static final String OPERATORS = "+-/*";
    static final String OPERANDS = "0123456789";

    //OUR MAINLAYOUT
    private LinearLayout mainLayout;
    private GridLayout mainGridLayout;

    //TextViews for our OPERAND AND OPERATOR
    private TextView operandTextView, operatorTextView;

    //REKT FOR TEST ONLY
    TextView infoTextView;

    //THIS WILL KEEP TRACK IF THE OPERATOR/OPERAND IS LOCKED
    private boolean lockOperand, operandAdded, operatorAdded, operandOverrideable;

    //BUTTONS
    //OPERANDS
    private Button oneButton, twoButton, threeButton,
            fourButton, fiveButton, sixButton, sevenButton,
            eightButton, nineButton, zeroButton;
    //OPERATORS
    private Button plusButton, minusButton, multButton, divideButton;
    //COMMANDS
    private Button clearButton, enterButton;
    //POSITIVE NEGATIVE BUTTON AND THE DECIMAL BUTTON
    private Button posNegButton, decimalButton;

    //THIS WILL BE THE STRING FOR US TO USE TO CALCULATE
    private String calculationString;

    private DisplayMetrics displayMetrics;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //INITS OUR CALCULATION STRING
        calculationString = new String();

        //INITS OUR BOOLEAN
        lockOperand = true;
        operandAdded = operatorAdded = operandOverrideable = false;

        
        initTextField();       
        initButtons();

        //THIS IS OUR VIEW        
        setContentView(R.layout.main);       
    }

    //*************************************************
    //PRIVATE HELPER METHODS
    //*************************************************
    //INIT THE TEXTVIEW
    private void initTextField() {
        operandTextView = (TextView) this.findViewById(R.id.operand_string);
        operandTextView.setText("0");

        operatorTextView = (TextView) this.findViewById(R.id.operator_string);
    }


    //INITS ALL BUTTONS
    private void initButtons() {
        oneButton = getButtonByID(R.id.one);
        twoButton = getButtonByID(R.id.two);
        threeButton = getButtonByID(R.id.three);
        fourButton = getButtonByID(R.id.four);
        fiveButton = getButtonByID(R.id.five);
        sixButton = getButtonByID(R.id.six);
        sevenButton = getButtonByID(R.id.seven);
        eightButton = getButtonByID(R.id.eight);
        nineButton = getButtonByID(R.id.nine);
        zeroButton = getButtonByID(R.id.zero);
        enterButton = getButtonByID(R.id.enter);
        clearButton = getButtonByID(R.id.clear);
        plusButton = getButtonByID(R.id.plus);
        minusButton = getButtonByID(R.id.minus);
        multButton = getButtonByID(R.id.mul);
        divideButton = getButtonByID(R.id.div);
        decimalButton = getButtonByID(R.id.dec);
        clearButton = getButtonByID(R.id.clear);
        enterButton = getButtonByID(R.id.enter);
        posNegButton = getButtonByID(R.id.posNeg);

        
    }


    private void showMessage(String textToShow, int duration) {
        Toast.makeText(this, textToShow, duration).show();
    }

    private Button getButtonByID(int id) {
        Button button = (Button) findViewById(id);
        initButtonEvent(button);
        return button;
    }

    private void initButtonEvent(Button button) {
        //will know its either a digit or operator
        String buttonText = button.getText().toString();
        if (OPERATORS.indexOf(buttonText) != -1) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!operandAdded) { //THIS IS TO MAKE SURE THAT WE ONLY ADD THE SAME OPERAND ONCE
                        calculationString = calculationString.concat(operandTextView.getText().toString() + " ");
                        operandAdded = true;
                    }
                    lockOperand = true;
                    operatorAdded = false;
                    operatorTextView.setText(((Button) v).getText().toString());
                }
            });
        } else if (OPERANDS.indexOf(buttonText) != -1) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!operatorAdded) { //THIS IS TO MAKE SURE THAT WE ONLY ADD THE SAME OPERATOR ONCE
                        calculationString = calculationString.concat(operatorTextView.getText().toString() + " ");
                        operatorAdded = true;
                    }
                    operandAdded = false; //WE MAKE THE OPERAND ADDED FALSE 
                    if (lockOperand || operandOverrideable) {
                        lockOperand = operandOverrideable = false;
                        operandTextView.setText(((Button) v).getText());
                    } else {
                        operandTextView.setText(operandTextView.getText().toString().concat(((Button) v).getText().toString()));
                    }
                }
            });
        } else if (buttonText.equals("Enter")) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //ADDS THE LAST OPERAND TO CAL STRING
                    if (!operandAdded) { //THIS IS TO MAKE SURE THAT WE ONLY ADD THE SAME OPERAND ONCE
                        calculationString = calculationString.concat(operandTextView.getText().toString());
                    }

                    if (calculationString.charAt(0) == ' ') {
                        operandTextView.setText("" + Calculator.calculate(calculationString.substring(1)));
                    } else {
                        operandTextView.setText("" + Calculator.calculate(calculationString));
                    }
                    operatorTextView.setText("");
                    operatorAdded = false;
                    operandOverrideable = true;

                    showMessage("CALCULATED", Toast.LENGTH_LONG);

                    //REKT FOR TEST ONLY
                    //infoTextView.setText("Calculate String: " + calculationString);
                    calculationString = "";
                }
            });
        } else if (buttonText.equals("Clear")) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    calculationString = new String();
                    operandTextView.setText("0");
                    operatorTextView.setText("");
                    lockOperand = true;
                    operandAdded = operatorAdded = false;
                }
            });
        } else if (buttonText.equals(".")) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!operatorAdded) { //THIS IS TO MAKE SURE THAT WE ONLY ADD THE SAME OPERATOR ONCE
                        calculationString = calculationString.concat(operatorTextView.getText().toString() + " ");
                        operatorAdded = true;
                    }
                    operandAdded = false; //WE MAKE THE OPERAND ADDED FALSE 
                    if (lockOperand || operandOverrideable) {
                        lockOperand = operandOverrideable = false;
                        operandTextView.setText("0" + ((Button) v).getText());
                    } else if (!operandTextView.getText().toString().contains(".")) {
                        operandTextView.setText(operandTextView.getText().toString().concat(((Button) v).getText().toString()));
                    }
                }
            });
        } else if (buttonText.equals("+/-")) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (operandTextView.getText().toString().charAt(0) == '-') {
                        operandTextView.setText(operandTextView.getText().toString().substring(1));
                    } else {
                        operandTextView.setText("-" + operandTextView.getText().toString());
                    }
                }
            });
        }
    }
}
