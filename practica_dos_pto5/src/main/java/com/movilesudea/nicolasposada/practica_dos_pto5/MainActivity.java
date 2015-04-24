package com.movilesudea.nicolasposada.practica_dos_pto5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    String city,f="",g="",l="",t="";
    int tss=0,hf=0,hg=0,hl=0,ht=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner sciudad = (Spinner) findViewById(R.id.spin);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sciudad.setAdapter(adapter);
        sciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),"Has seleccionado "+parent.getSelectedItem(),Toast.LENGTH_LONG).show();
                city = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void doIt(View view){
        final EditText vetnombre = (EditText) findViewById(R.id.etName);
        final EditText vetcorreo = (EditText) findViewById(R.id.etCorreo);
        final EditText vettelefo = (EditText) findViewById(R.id.etTelefono);
        final TextView tvnombre  = (TextView) findViewById(R.id.tvNombre);
        final TextView tvcorreo  = (TextView) findViewById(R.id.tvCorreo);
        final TextView tvtelefo  = (TextView) findViewById(R.id.tvTelefono);
        final TextView tvsexo    = (TextView) findViewById(R.id.tvSexo);
        final TextView tvciudad  = (TextView) findViewById(R.id.tvCiu);
        final TextView tvwarn    = (TextView) findViewById(R.id.warn);
        final TextView tvhob     = (TextView) findViewById(R.id.tvHob);
        final TextView tvdate    = (TextView) findViewById(R.id.tvDat);

        final DatePicker dpborn  = (DatePicker) findViewById(R.id.dpBorn);

        boolean etn,etc,ett;
        etn = vetnombre.getText().toString().equals("");
        etc = vetcorreo.getText().toString().equals("");
        ett = vettelefo.getText().toString().equals("");

        if (etn||etc||ett||(tss==0))tvwarn.setText("DATOS INCOMPLETOS");
        else {
            tvnombre.setText(vetnombre.getText());
            tvcorreo.setText(vetcorreo.getText());
            tvtelefo.setText(vettelefo.getText());
            switch (tss){
                case 1:
                    tvsexo.setText("Masculino");
                    break;
                case 2:
                    tvsexo.setText("Femenino");
                    break;
                default:
                    break;
            }
            tvciudad.setText(city);
            if ((hf==0)&&(hg==0)&&(hl==0)&&(ht==0))tvhob.setText("No tiene hobbies");
            else {
                tvhob.setText(f+g+l+t);
            }
            tvdate.setText(dpborn.getDayOfMonth()+"/"+(dpborn.getMonth()+1)+"/"+dpborn.getYear());
            tvwarn.setText("");
        }

    }

    public void Wsex(View view){
        switch (view.getId()){
            case R.id.rbMas:
                tss=1;
                break;
            case R.id.rbFem:
                tss=2;
                break;
            default:
                break;
        }
    }

    public void cbHob(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbFut:
                if (checked){
                    hf=1;
                    f="fútbol";
                }
                else{
                    hf=0;
                    f="";
                }
                break;
            case R.id.cbGui:
                if (checked){
                    hg=1;
                    g=" guitarra";
                }
                else{
                    hg=0;
                    g="";
                }
                break;
            case R.id.cbLee:
                if (checked){
                    hl=1;
                    l=" leer";
                }
                else{
                    hl=0;
                    l="";
                }
                break;
            case R.id.cbTele:
                if (checked){
                    ht=1;
                    t=" televisión";
                }
                else{
                    ht=0;
                    t="";
                }
                break;
            default:
                break;
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
