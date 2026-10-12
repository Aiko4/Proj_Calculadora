package com.example.projcalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String operation = "";
    double firstNum = 0;
    boolean decimal = false;
    double savedNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnMMinus = findViewById(R.id.BtnMinus);
        Button btnMSum= findViewById(R.id.btnMSum);
        Button btnMc = findViewById(R.id.btnMc);
        Button btnMr = findViewById(R.id.btnMr);
        Button btnSeven = findViewById(R.id.btnSeven);
        Button btnEight = findViewById(R.id.btnEight);
        Button btnNine = findViewById(R.id.btnNine);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnFour = findViewById(R.id.btnFour);
        Button btnFive = findViewById(R.id.btnFive);
        Button btnSix = findViewById(R.id.btnSix);
        Button btnSum = findViewById(R.id.btnSum);
        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        Button btnThree = findViewById(R.id.btnThree);
        Button btnSurplus = findViewById(R.id.btnSurplus);
        Button btnZero = findViewById(R.id.btnZero);
        Button btnDZero = findViewById(R.id.btnDoubleZero);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnResult = findViewById(R.id.btnResult);
        Button btnDivide = findViewById(R.id.btnDivide);

        TextView screen = findViewById(R.id.screen);
        TextView operationScreen = findViewById(R.id.currentOperation);

        List<Button> numButtons = Arrays.asList(
                btnSeven,
                btnEight,
                btnNine,
                btnFour,
                btnFive,
                btnSix,
                btnOne,
                btnTwo,
                btnThree,
                btnZero,
                btnDZero
        );

        List<Button> numFunct = Arrays.asList(
                btnMMinus,
                btnMSum,
                btnMc,
                btnMr,
                btnDelete,
                btnSum,
                btnSurplus,
                btnDot,
                btnMulti,
                btnResult,
                btnDivide
        );

        for (Button b : numButtons) {
            b.setOnClickListener(v -> {
                String buttonType = b.getText().toString();

                switch (buttonType) {
                    case "0":
                        screen.append("0");
                        operationScreen.append("0");
                        break;
                    case "00":
                        screen.append("00");
                        operationScreen.append("00");
                        break;
                    case "1":
                        screen.append("1");
                        operationScreen.append("1");
                        break;
                    case "2":
                        screen.append("2");
                        operationScreen.append("2");
                        break;
                    case "3":
                        screen.append("3");
                        operationScreen.append("3");
                        break;
                    case "4":
                        screen.append("4");
                        operationScreen.append("4");
                        break;
                    case "5":
                        screen.append("5");
                        operationScreen.append("5");
                        break;
                    case "6":
                        screen.append("6");
                        operationScreen.append("6");
                        break;
                    case "7":
                        screen.append("7");
                        operationScreen.append("7");
                        break;
                    case "8":
                        screen.append("8");
                        operationScreen.append("8");
                        break;
                    case "9":
                        screen.append("9");
                        operationScreen.append("9");
                        break;
                }
            });
        }

        for (Button b : numFunct) {
            b.setOnClickListener(v -> {
                String btnType = b.getText().toString();
                boolean clicked = false;
                switch (btnType) {
                    case "M-":
                        savedNumber = savedNumber - Double.parseDouble(screen.getText().toString());
                        screen.setText("");
                        operationScreen.setText("");
                        break;
                    case "M+":
                        savedNumber = savedNumber + Double.parseDouble(screen.getText().toString());
                        screen.setText("");
                        operationScreen.setText("");
                    case "Mc":
                        savedNumber = 0;
                        break;
                    case "Mr":
                        if (savedNumber == 0.0) {
                            screen.setText("");
                            operationScreen.setText("");
                        } else {
                            screen.setText(String.valueOf(savedNumber));
                            break;
                        }
                        break;
                    case "DEL":
                        screen.setText("");
                        operationScreen.setText("");
                        break;
                    case "+":
                    case "-":
                    case "X":
                    case "÷":
                        operationScreen.append(" " + btnType + " ");
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operation = btnType;
                        screen.setText("");
                        break;
                    case ".":
                        screen.append(".");
                        operationScreen.append(",");
                        decimal = true;
                        break;
                    case "=":
                        double secondNum = Double.parseDouble(screen.getText().toString());
                        operationScreen.append(" = ");

                        if (decimal == true) {
                            double resultDec = 0;

                            if (operation.equals("+")) {
                                resultDec = firstNum + secondNum;
                            } else if (operation.equals("-")) {
                                resultDec = firstNum - secondNum;
                            } else if (operation.equals("X")) {
                                resultDec = firstNum * secondNum;
                            } else if (operation.equals("÷")) {
                                resultDec = firstNum / secondNum;
                            }
                            screen.setText(String.valueOf(resultDec));
                            operationScreen.append(String.valueOf(resultDec));
                        } else {
                             int resultInt  = 0;

                             if (operation.equals("+")) {
                                 resultInt = (int) firstNum + (int) secondNum;
                             } else if (operation.equals("-")) {
                                 resultInt = (int) firstNum - (int) secondNum;
                             } else if (operation.equals("X")) {
                                 resultInt = (int) firstNum * (int) secondNum;
                             } else if (operation.equals("÷")) {
                                 resultInt = (int) firstNum / (int) secondNum;
                             }
                             screen.setText(String.valueOf(resultInt));
                        }
                        break;
                }
            });
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           // v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}