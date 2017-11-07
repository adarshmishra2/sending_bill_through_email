package com.example.abhishekpc.bevrageorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chilli,coke,pizza,sandwich,icecream;
    EditText order1,order2,order3,order4,order5,mailid;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        chilli=(CheckBox) findViewById(R.id.checkbox1);
        coke=(CheckBox) findViewById(R.id.checkbox2);
        pizza=(CheckBox) findViewById(R.id.checkbox3);
        sandwich=(CheckBox) findViewById(R.id.checkbox4);
        icecream=(CheckBox) findViewById(R.id.checkbox5);
        buttonOrder=(Button) findViewById(R.id.order);

        buttonOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                int totalamount1=0,totalamount2=0,totalamount3=0,totalamount4=0,totalamount5=0;
                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");


                if (chilli.isChecked()) {
                    order1 = (EditText) findViewById(R.id.ord1);
                    String num1 = order1.getText().toString();
                    int no1 = Integer.parseInt(num1);
                    totalamount1 = no1 * 40;
                    result.append("\nChilli potato "+totalamount1+"Rs");
                }


                if (coke.isChecked()) {

                    order2 = (EditText) findViewById(R.id.ord2);
                    String num2 = order2.getText().toString();
                    int no2 = Integer.parseInt(num2);
                    totalamount2 = no2 * 25;
                    result.append("\nCoke "+totalamount2+"Rs");
                }

                if (pizza.isChecked()) {

                    order3 = (EditText) findViewById(R.id.ord3);
                    String num3 = order3.getText().toString();
                    int no3 = Integer.parseInt(num3);
                    totalamount3 = no3 * 300;
                    result.append("\nPizza "+totalamount3+"Rs");
                }

                if (sandwich.isChecked()) {

                    order4 = (EditText) findViewById(R.id.ord4);
                    String num4 = order4.getText().toString();
                    int no4 = Integer.parseInt(num4);
                    totalamount4 = no4 * 70;
                    result.append("\nSandwich "+totalamount4+"Rs");
                }

                if (icecream.isChecked()) {

                    order5 = (EditText) findViewById(R.id.ord5);
                    String num5 = order5.getText().toString();
                    int no5 = Integer.parseInt(num5);
                    totalamount5 = no5 * 35;
                    result.append("\nIceCream "+totalamount5+"Rs");
                }

                int total = totalamount1 + totalamount2 + totalamount3 + totalamount4 + totalamount5;
                result.append("\nTotal: " + total + "Rs");
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

                mailid = (EditText) findViewById(R.id.emailid);

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{mailid.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT, "Your Bill");
                i.putExtra(Intent.EXTRA_TEXT   , result.toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

}
