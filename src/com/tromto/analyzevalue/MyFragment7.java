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
import java.math.RoundingMode;

public class MyFragment7 extends Fragment {
    EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    Button button1;
    String s1;
    BigDecimal a1,a2, a3, a4, a5, p1, p2, p3, p4, p5, ga, gp, ro, gt, nfa, shares, reoi1, reoi2, reoi3,
            reoi4, reoi5, dis2, dis3, dis4, dis5, discountedreoi, terminal, total, equity, pershare;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        
      

        
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_7, container, false);

        t1 = (EditText)v.findViewById(R.id.editText1);
        t2 = (EditText)v.findViewById(R.id.editText2);
        t3 = (EditText)v.findViewById(R.id.editText3);
        t4 = (EditText)v.findViewById(R.id.editText4);
        t5 = (EditText)v.findViewById(R.id.editText5);
        t6 = (EditText)v.findViewById(R.id.editText6);
        t7 = (EditText)v.findViewById(R.id.editText7);
        t8 = (EditText)v.findViewById(R.id.editText8);
        t9 = (EditText)v.findViewById(R.id.editText9);
        t10 = (EditText)v.findViewById(R.id.editText10);
        t11 = (EditText)v.findViewById(R.id.editText11);
        t12 = (EditText)v.findViewById(R.id.editText12);
        t13 = (EditText)v.findViewById(R.id.editText13);
        t14 = (EditText)v.findViewById(R.id.editText14);

        t1.setText("1000");
        t2.setText("100");
        t3.setText("0");
        t4.setText("0");
        t5.setText("0");
        t6.setText("0");
        t7.setText("0");
        t8.setText("0");
        t9.setText("0");
        t10.setText("0");
        t11.setText("1.06");
        t12.setText("1.1");
        t13.setText("1.08");
        t14.setText("1.03");

        Button button1 = (Button)v.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //s1 = text1.getText().toString();
                a1 = new BigDecimal(t1.getText().toString());
                a2 = new BigDecimal(t3.getText().toString());
                a3 = new BigDecimal(t5.getText().toString());
                a4 = new BigDecimal(t7.getText().toString());
                a5 = new BigDecimal(t9.getText().toString());



                p1 = new BigDecimal(t2.getText().toString());
                p2 = new BigDecimal(t4.getText().toString());
                p3 = new BigDecimal(t6.getText().toString());
                p4 = new BigDecimal(t8.getText().toString());
                p5 = new BigDecimal(t10.getText().toString());

                ga = new BigDecimal(t11.getText().toString());
                gp = new BigDecimal(t12.getText().toString());
                ro = new BigDecimal(t13.getText().toString());
                gt = new BigDecimal(t14.getText().toString());


                if (a2.compareTo(BigDecimal.ZERO) == 0){
                    a2=a1.multiply(ga).setScale(2, RoundingMode.HALF_UP);
                    a3=a2.multiply(ga).setScale(2, RoundingMode.HALF_UP);
                    a4=a3.multiply(ga).setScale(2, RoundingMode.HALF_UP);
                    a5=a4.multiply(ga).setScale(2, RoundingMode.HALF_UP);
                    t3.setText(a2.toString());
                    t5.setText(a3.toString());
                    t7.setText(a4.toString());
                    t9.setText(a5.toString());
                }
                if (p2.compareTo(BigDecimal.ZERO) == 0){
                    p2=p1.multiply(gp).setScale(2, RoundingMode.HALF_UP);
                    p3=p2.multiply(gp).setScale(2, RoundingMode.HALF_UP);
                    p4=p3.multiply(gp).setScale(2, RoundingMode.HALF_UP);
                    p5=p4.multiply(gp).setScale(2, RoundingMode.HALF_UP);
                    t4.setText(p2.toString());
                    t6.setText(p3.toString());
                    t8.setText(p4.toString());
                    t10.setText(p5.toString());
                }
                //p1 - a1x(1-df)
                BigDecimal one = new BigDecimal("1");
                BigDecimal onemin = ro.subtract(one); //df-1
                reoi1 = p1.subtract((a1.multiply(onemin)));
                reoi2 = p2.subtract((a2.multiply(onemin)));
                reoi3 = p3.subtract((a3.multiply(onemin)));
                reoi4 = p4.subtract((a4.multiply(onemin)));
                reoi5 = p5.subtract((a5.multiply(onemin)));
                //BigDecimal rop2 = ro.pow(2);
                dis2 = reoi2.divide(ro, 2, RoundingMode.HALF_UP);
                dis3 = reoi3.divide(ro.pow(2), 2, RoundingMode.HALF_UP);
                dis4 = reoi4.divide(ro.pow(3), 2, RoundingMode.HALF_UP);
                dis5 = reoi5.divide(ro.pow(4), 2, RoundingMode.HALF_UP);

                discountedreoi = reoi1.add(dis2).add(dis3).add(dis4).add(dis5);

                terminal = ((reoi5.multiply(gt)).divide(ro.subtract(gt), 2, RoundingMode.HALF_UP)).divide(ro.pow(4), 2, RoundingMode.HALF_UP);
                total = a1.add(discountedreoi).add(terminal);

                //int is1 = Integer.parseInt(s1);
                Toast t = Toast.makeText(getActivity(),"The calculated value of your business is: " + total.toString(), Toast.LENGTH_LONG);
                t.show();

            }
        });
        return v;
    }

}
