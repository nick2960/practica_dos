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
    TextView vtvresult;
    String  result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vtvresult = (TextView) findViewById(R.id.tvResult);
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
        float a, b;
        if ((vope1.getText().toString().equals(""))||(vope2.getText().toString().equals(""))){
            result = "Ingrese valores";
            vtvresult.setText(result);
        }else {
            a = Float.valueOf(vope1.getText().toString());
            b = Float.valueOf(vope2.getText().toString());
            switch (bo){
                case 1:
                    result= String.valueOf(a + b);
                    vtvresult.setText(result);
                    break;
                case 2:
                    result = String.valueOf(a - b);
                    vtvresult.setText(result);
                    break;
                case 3:
                    result = String.valueOf(a * b);
                    vtvresult.setText(result);
                    break;
                case 4:
                    if (b==0){
                        result ="Math Error...";
                        vtvresult.setText(result);
                    }else {
                        result = String.valueOf(a / b);
                        vtvresult.setText(result);
                    }
                    break;
            }
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle saveState){
        super.onSaveInstanceState(saveState);
        saveState.putString("d", result);
        saveState.putInt("op",bo);
    }

    @Override
    protected void onRestoreInstanceState(Bundle loadState){
        super.onRestoreInstanceState(loadState);
        result = loadState.getString("d");
        vtvresult.setText(result);
        bo = loadState.getInt("op");
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
