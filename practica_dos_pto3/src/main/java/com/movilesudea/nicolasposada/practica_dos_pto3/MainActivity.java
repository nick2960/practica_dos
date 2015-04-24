package com.movilesudea.nicolasposada.practica_dos_pto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doOperation(View view){
        final EditText vetquices    =   (EditText)  findViewById(R.id.etquiz);
        final EditText vetexpo      =   (EditText)  findViewById(R.id.etexp);
        final EditText vetlab       =   (EditText)  findViewById(R.id.etlab);
        final EditText vetpro       =   (EditText)  findViewById(R.id.etpro);
        final TextView vtvresult    =   (TextView)  findViewById(R.id.tvResult);
        float q, e, l, p;
        if (vetquices.getText().toString().equals("")||vetexpo.getText().toString().equals("")||vetlab.getText().toString().equals("")||vetpro.getText().toString().equals("")){
            vtvresult.setText("Ingrese valores");
        }else{
            q=Float.valueOf(vetquices.getText().toString());
            e=Float.valueOf(vetexpo.getText().toString());
            l=Float.valueOf(vetlab.getText().toString());
            p=Float.valueOf(vetpro.getText().toString());
            if ((q>5)||(e>5)||(l>5)||(p>5)){
                vtvresult.setText("Notas unicamente entre [0,5]");
            }else {
                vtvresult.setText(String.valueOf((q*0.15)+(e*0.1)+(l*0.4)+(p*0.35)));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
