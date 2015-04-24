package com.movilesudea.nicolasposada.practica_dos_pto2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private int bo=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectOp(View view){
        switch (view.getId()){
            case (R.id.rbSum):
                bo=1;
                break;
            case (R.id.rbRes):
                bo=2;
                break;
            case (R.id.rbMul):
                bo=3;
                break;
            case (R.id.rbDiv):
                bo=4;
                break;
        }
    }

    public void doOperation(View view){

        final EditText vope1 = (EditText) findViewById(R.id.eOp1);
        final EditText vope2 = (EditText) findViewById(R.id.eOp2);
        final TextView vtvresult = (TextView) findViewById(R.id.tvResult);
        float a, b;
        if ((vope1.getText().toString().equals(""))||(vope2.getText().toString().equals(""))){
            vtvresult.setText("Ingrese valores");
        }else {
            a = Float.valueOf(vope1.getText().toString());
            b = Float.valueOf(vope2.getText().toString());
            switch (bo){
                case 1:
                    vtvresult.setText(String.valueOf(a + b));
                    break;
                case 2:
                    vtvresult.setText(String.valueOf(a - b));
                    break;
                case 3:
                    vtvresult.setText(String.valueOf(a * b));
                    break;
                case 4:
                    if (b==0){
                        vtvresult.setText("Math Error...");
                    }else {
                        vtvresult.setText(String.valueOf(a / b));
                    }
                    break;
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
