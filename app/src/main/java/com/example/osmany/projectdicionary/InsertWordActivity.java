package com.example.osmany.projectdicionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InsertWordActivity extends AppCompatActivity {

    Button addWord;
    EditText editWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);
        addWord = findViewById(R.id.btn_add_word);
        editWord = findViewById(R.id.edit_palabra);
    }

    public void addWord(View view) {
        if(!editWord.getText().toString().equals("")) {
            try {
                String palabra = editWord.getText().toString().toLowerCase().trim();

                OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("palabras.txt", Context.MODE_PRIVATE));
                int i =0;
                while(palabra.length()>i){
                    osw.write(palabra.charAt(i));
                    i++;
                }
                editWord.setText("");
                osw.append("\r\n");
                osw.close();
            } catch (IOException e) {
                Log.e("Error", "Error al crear el fichero");
            }
        }
    }
}
