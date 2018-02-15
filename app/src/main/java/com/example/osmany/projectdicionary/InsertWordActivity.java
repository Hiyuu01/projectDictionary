package com.example.osmany.projectdicionary;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InsertWordActivity extends AppCompatActivity {

    Button addWord;
    EditText editWord,editSinon1,editSinon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);
        addWord = findViewById(R.id.btn_add_word);
        editWord = findViewById(R.id.edit_palabra);
        editSinon1 = findViewById(R.id.edit_sinon_1);
        editSinon2 = findViewById(R.id.edit_sinon_2);


    }

    public void addWord(View view) {
        if(!editWord.getText().toString().equals("")) {
            boolean sdDisponible = false;
            boolean sdAccesoEscritura = false;


            String estado = Environment.getExternalStorageState();

            if (estado.equals(Environment.MEDIA_MOUNTED))
            {
                sdDisponible = true;
                sdAccesoEscritura = true;
            }
            else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
            {
                sdDisponible = true;
                sdAccesoEscritura = false;
            }
            else
            {
                sdDisponible = false;
                sdAccesoEscritura = false;
            }
            try {

                Palabra word = new Palabra(editWord.getText().toString().toLowerCase().trim());
                String sin1 = editSinon1.getText().toString();
                String sin2 = editSinon2.getText().toString();
                if((!sin1.equals(null)) || (!sin1.equals(""))){
                    word.setSinon1(sin1);
                }
                if((!sin2.equals(null)) || (!sin2.equals(""))){
                    word.setSinon02(sin2);
                }

                FileOutputStream fos = new FileOutputStream("palabras.dat",true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(word);
                oos.flush();
                oos.close();
                editWord.setText("");
                editSinon1.setText("");
                editSinon2.setText("");

                if(sdDisponible && sdAccesoEscritura){
                    try {
                        File rutaSd = getExternalFilesDir(null);
                        File f = new File(rutaSd.getAbsolutePath(), "palabras.txt");
                        FileOutputStream fosE = new FileOutputStream("palabras.txt", true);
                        ObjectOutputStream oosE = new ObjectOutputStream(fosE);
                        oosE.writeObject(word);
                        oosE.flush();
                        oosE.close();
                    }catch (IOException e){
                        Log.e("Error", "Error al crea el fichero externo");
                    }

                }


            } catch (IOException e) {
                Log.e("Error", "Error al crear el fichero");
            }
        }
    }
}
