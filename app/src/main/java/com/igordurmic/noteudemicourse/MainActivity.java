package com.igordurmic.noteudemicourse;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String debugtag = "jwp";

    public static final String Textfile="note.txt";

    public static final String FILEsaved = "Filesaved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSaveButtonListener();


        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean fileSaved = sharedPreferences.getBoolean(FILEsaved, false);

        if (fileSaved) {
            loadSavedFile();
        }
    }

    private void loadSavedFile(){
        try {
           FileInputStream fis = openFileInput(Textfile);

            BufferedReader bufferedReader= new BufferedReader( new InputStreamReader(new DataInputStream(fis)));

            EditText editText = (EditText) findViewById(R.id.editText1);

            String line;
            while ((line = bufferedReader.readLine()) !=null){
                editText.append(line);
                editText.append("\n");
            }

            fis.close();
        } catch (Exception e) {
            Log.d(debugtag,"unable to read file");
        }
    }

    private void addSaveButtonListener(){
        Button savebtn = (Button) findViewById(R.id.save);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) findViewById(R.id.editText1);

                String text = editText.getText().toString();

                try {
/*

                    FileOutputStream fos= openFileOutput(Textfile, Context.MODE_PRIVATE);

                    fos.write(text.getBytes());
                    fos.close();

                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(FILEsaved, true);
                    editor.commit();
*/
                    Toast.makeText(MainActivity.this, getString(R.string.toast_cant_save), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.d(debugtag,"unable to save file");
                }





            }
        });
    }
}
