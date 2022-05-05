package sn.ept.git.dic2.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditEleve extends AppCompatActivity {
    public static final int EDIT_OK = 0;
    public static final int EDIT_CANCEL = 1;
    private EditText prenomEditText;
    private EditText nomEditText;
    private Button saveButton;
    private Button cancelButton;
    private static final String TAG="DIC2_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"Démarrage de EditEleve");

        setContentView(R.layout.ajout_eleve);
        prenomEditText = findViewById(R.id.prenomInput);
        prenomEditText.setText("Moussa");
        //prenomEditText.setEnabled(false);

        nomEditText = findViewById(R.id.nomInput);
        nomEditText.setText("FALL");

        saveButton = findViewById(R.id.save_eleve);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prenom = ""+ prenomEditText.getText();
                String nom = ""+ nomEditText.getText();
                Log.i(TAG,"Enregistrement ok de "+ prenom+" "+ nom);
                Eleve e = new Eleve(prenom,nom);

                Intent intent = new Intent();
                intent.putExtra("eleve",e);
                setResult(EDIT_OK,intent);
                finish();
            }
        });

        cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(EDIT_CANCEL);

                finish();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"OnRestart");
    }
}