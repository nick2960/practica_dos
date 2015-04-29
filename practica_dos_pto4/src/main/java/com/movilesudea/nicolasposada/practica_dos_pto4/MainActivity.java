package com.movilesudea.nicolasposada.practica_dos_pto4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private int tf=1;
    TextView vtvres;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vtvres = (TextView) findViewById(R.id.tvResult);
    }

    public void typeFigure(View view){
        switch (view.getId()){
            case R.id.rbCir:
                tf=1;
                break;
            case R.id.rbCua:
                tf=2;
                break;
            case R.id.rbTri:
                tf=3;
                break;
            case R.id.rbRec:
                tf=4;
                break;
            default:
                break;
        }
    }

    public void doOperation(View view){
        final EditText vetr = (EditText) findViewById(R.id.etR);
        final EditText vetl = (EditText) findViewById(R.id.etL);
        final EditText vetba = (EditText) findViewById(R.id.etBa);
        final EditText veth = (EditText) findViewById(R.id.etH);
        final EditText veta = (EditText) findViewById(R.id.etA);
        final EditText vetb = (EditText) findViewById(R.id.etB);
        float r, l, ba, h, a, la;
        boolean extr, extl, extba, exth, exta, extb;
        extr = vetr.getText().toString().equals("");
        extl = vetl.getText().toString().equals("");
        extba = vetba.getText().toString().equals("");
        exth = veth.getText().toString().equals("");
        exta = veta.getText().toString().equals("");
        extb = vetb.getText().toString().equals("");
        switch (tf){
            case 1:
                if (extr)vtvres.setText(result=("Ingrese valores"));
                else {
                    r=Float.valueOf(vetr.getText().toString());
                    result = String.valueOf(redondear(Math.PI*Math.pow(r,2),4));
                    vtvres.setText(result);
                }
                break;
            case 2:
                if (extl)vtvres.setText(result = ("Ingrese valores"));
                else {
                    l=Float.valueOf(vetl.getText().toString());
                    result = String.valueOf(redondear(Math.pow(l,2),4));
                    vtvres.setText(result);
                }
                break;
            case 3:
                if (extba||exth)vtvres.setText(result =("Ingrese valores"));
                else {
                    ba=Float.valueOf(vetba.getText().toString());
                    h=Float.valueOf(veth.getText().toString());
                    result = String.valueOf(redondear((ba*h)/2,4));
                    vtvres.setText(result);
                }
                break;
            case 4:
                if (exta||extb)vtvres.setText(result=("Ingrese valores"));
                else {
                    a=Float.valueOf(veta.getText().toString());
                    la=Float.valueOf(vetb.getText().toString());
                    result = String.valueOf(redondear(a*la,4));
                    vtvres.setText(result);
                }
                break;
            default:
                break;
        }
    }

    public double redondear( double numero, int decimales ) {
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }

    @Override
    protected void onSaveInstanceState(Bundle saveState){
        super.onSaveInstanceState(saveState);
        saveState.putInt("tf",tf);
        saveState.putString("ra", result);
    }

    @Override
    protected void onRestoreInstanceState(Bundle loadState){
        super.onRestoreInstanceState(loadState);
        tf = loadState.getInt("tf");
        result = loadState.getString("ra");
        vtvres.setText(result);
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
