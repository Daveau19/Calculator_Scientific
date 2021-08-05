package com.example.calculatrice_scientific;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView previousvalu;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousvalu = findViewById(R.id.previous_calcul);
        display = findViewById(R.id.display_value);
        display.setShowSoftInputOnFocus(false);
    }
     private void updateText(String strToAdd){
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());

    }

    public void exposant(View view){
        updateText(getResources().getString(R.string.exposant));
    }
    public void division(View view){
        updateText(getResources().getString(R.string.divise));
    }
    public void sept(View view){updateText(getResources().getString(R.string.sept));
    }

    public void huit(View view){
        updateText(getResources().getString(R.string.huit));
    }
    public void neuf(View view){
        updateText(getResources().getString(R.string.neuf));
    }
    public void multiplication(View view){
        updateText(getResources().getString(R.string.multiple));
    }
    public void quatre(View view){
        updateText(getResources().getString(R.string.quatre));
    }
    public void cinq(View view){
        updateText(getResources().getString(R.string.cinq));
    }
    public void six(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void soustraction(View view){ updateText(getResources().getString(R.string.sustraction));
    }
    public void un(View view){ updateText(getResources().getString(R.string.un));
    }
    public void deux(View view){
        updateText(getResources().getString(R.string.deux));
    }
    public void trois(View view){
        updateText(getResources().getString(R.string.trois));
    }
    public void addition(View view){
        updateText(getResources().getString(R.string.addition));
    }
    public void zero(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void plusminus(View view){ updateText(getResources().getString(R.string.plusMinus)); }
    public void cosinus(View view){
        updateText("cos(");
    }
    public void sinus(View view){ updateText("sin(");
    }
    public void point(View view){
        updateText(getResources().getString(R.string.point));
    }

    public void paropen(View view){
        updateText(getResources().getString(R.string.paranthG));
    }

    public void parclose(View view){
        updateText(getResources().getString(R.string.paranthD));
    }

    public void backspace(View view){
      int cursorPos = display.getSelectionStart();
      int textLen = display.getText().length();

      if (cursorPos != 0 && textLen != 0){
          SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
          selection.replace(cursorPos-1, cursorPos, "");
          display.setText(selection);
          display.setSelection(cursorPos-1);
      }
    }
    public void  clearbtn(View view){
         display.setText("");
         previousvalu.setText("");
    }

    public void egale(View view){
        String userExp = display.getText().toString();

        previousvalu.setText(userExp);

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("x", "*");

        Expression exp =  new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void tanusnusbtn(View view){
        updateText("tan(");
    }
    public void sinusmoinsbtn(View view){
        updateText("arcsin(");
    }
    public void cosinusmoinsbtn(View view){
        updateText("arccos(");
    }
    public void tanusmoinsbtn(View view){
        updateText("arctan(");
    }
    public void logabtn(View view){
        updateText("log(");
    }
    public void lngobtn(View view){
        updateText("ln(");
    }
    public void racinebtn(View view){
        updateText("sqrt(");
    }
    public void pibtn(View view){
        updateText("pi(");
    }
    public void value_abbtn(View view){
        updateText("abs(");
    }
    public void primebtn(View view){
        updateText("ispr(");
    }
    public void exposantxbtn(View view){
        updateText("^(");
    }
    public void exposant2btn(View view){
        updateText("^(2)");
    }
    public void pourcenbtn(View view){

    }

}