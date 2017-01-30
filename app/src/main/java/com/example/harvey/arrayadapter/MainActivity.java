package com.example.harvey.arrayadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView txv;
    Spinner sp;
    Spinner temp;
    String[] tempSet1={"冰","去冰","温"};
    String[] tempSet2={"冰","去冰"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView)findViewById(R.id.textView);
        sp=(Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);

        temp=(Spinner)findViewById(R.id.spinner2);
       // temp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String [] tempSet;
       // Toast.makeText(this,String.valueOf(position),Toast.LENGTH_SHORT);



     //   txv.setText(String.valueOf(position+" "+String.valueOf(view.getId())+" "+String.valueOf(R.id.spinner)));

       // show();

            if (position==1)
                tempSet=tempSet2;
            else
                tempSet=tempSet1;

            ArrayAdapter<String> tempAd=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,tempSet);
            tempAd.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            temp.setAdapter(tempAd);

             txv.setText(String.valueOf(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

  public void showOrder(View view){
      String msg;
      msg=sp.getSelectedItem().toString()+" "+temp.getSelectedItem().toString();
      txv.setText(msg);
  }




}
