package com.example.osmany.projectdicionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buscar,insertar,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertar=findViewById(R.id.btn_introducir);
        insertar.setOnClickListener(this);
        buscar=findViewById(R.id.btn_buscar);
        buscar.setOnClickListener(this);
        salir=findViewById(R.id.btn_salir);
        salir.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.nuevaMenu:
                Intent intent = new Intent(this,InsertWordActivity.class);
                startActivity(intent);
                break;
            case R.id.buscarMenu:
                Intent intent2 = new Intent(this,WordSearcherActivity.class);
                startActivity(intent2);
                break;
            case R.id.salirMenu:
                this.finish();
        }

        return true;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_introducir:
                Intent intent = new Intent(this,InsertWordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_buscar:
                Intent intent2 = new Intent(this,WordSearcherActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_salir:
                this.finish();

        }
    }
}
