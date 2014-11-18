package com.tromto.analyzevalue;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class MyFragment6 extends Fragment {
    EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    Button button1;
    BigDecimal a1,a2, a3, a4, a5, a6, a7;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        
      
    			Toast t = Toast.makeText(getActivity(), "6", Toast.LENGTH_LONG);
    			    t.show();
    		
        
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_6, container, false);

        t1 = (EditText)v.findViewById(R.id.editText1);
        t2 = (EditText)v.findViewById(R.id.editText2);
        t3 = (EditText)v.findViewById(R.id.editText3);
        t4 = (EditText)v.findViewById(R.id.editText4);
        t5 = (EditText)v.findViewById(R.id.editText5);
        t6 = (EditText)v.findViewById(R.id.editText6);
        t7 = (EditText)v.findViewById(R.id.editText7);


        t1.setText("0.05");
        t2.setText("140");
        t3.setText("1.5");
        t4.setText("60");
        t5.setText("0.11");
        t6.setText("0.06");
        t7.setText("0.12");



        Button button1 = (Button)v.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                a1 = new BigDecimal(t1.getText().toString());
                a2 = new BigDecimal(t2.getText().toString());
                a3 = new BigDecimal(t3.getText().toString());
                a4 = new BigDecimal(t4.getText().toString());
                a5 = new BigDecimal(t5.getText().toString());
                a6 = new BigDecimal(t6.getText().toString());
                a7 = new BigDecimal(t7.getText().toString());

                BigDecimal CAPM = a1.add(a3.multiply(a5.subtract(a1)));
                BigDecimal b = a2.add(a4);
                BigDecimal c = a7.multiply(a2.divide(b));
                BigDecimal d = a6.multiply(a4.divide(b));
                BigDecimal wacc = c.add(d);
                Toast t = Toast.makeText(getActivity(), "CAPM is: "+ CAPM, Toast.LENGTH_LONG);
                t.show();


            }
        });
        Button button2 = (Button)v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                a4 = new BigDecimal(t4.getText().toString());
                a5 = new BigDecimal(t5.getText().toString());
                a6 = new BigDecimal(t6.getText().toString());
                a7 = new BigDecimal(t7.getText().toString());

                BigDecimal b = a2.add(a4);
                BigDecimal c = a7.multiply(a2.divide(b));
                BigDecimal d = a6.multiply(a4.divide(b));
                BigDecimal wacc = c.add(d);
                Toast t = Toast.makeText(getActivity(), "WACC is: "+ wacc, Toast.LENGTH_LONG);
                t.show();


            }
        });

        return v;
    }

}
