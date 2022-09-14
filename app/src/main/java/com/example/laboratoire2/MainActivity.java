package com.example.laboratoire2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_courriel;
    EditText et_password;
    EditText et_confirmpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_courriel = (EditText) findViewById(R.id.et_courriel);
        et_password = (EditText) findViewById(R.id.et_password);
        et_confirmpassword = (EditText) findViewById(R.id.et_confirmpassword);
        ImageView img = (ImageView) findViewById(R.id.iv_personne);
        img.setImageResource(R.drawable.image);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "Message",  "L'activité est passé par la methode onstart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "Message",  "L'activité est passé par la methode onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "Message",  "L'activité est passé par la methode onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "Message",  "L'activité est passé par la methode onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( "Message",  "L'activité est passé par la methode onDestroy()");
    }



    public void onClickChk_affichage(View view) {
        CheckBox chk_showpassword = (CheckBox) findViewById(R.id.chk_showpassword);
        CheckBox chk_confirmpassword = (CheckBox) findViewById(R.id.chk_confirmpassword);


        if (chk_showpassword.isChecked()) {
            et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (chk_confirmpassword.isChecked()) {
            et_confirmpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            et_confirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }


    }


    public void onClickChk_affichagebouton(View view) {
        CheckBox chk_messageacceptation = (CheckBox) findViewById(R.id.chk_messageacceptation);
        Button btn_sauvegarder = (Button) findViewById(R.id.btn_sauvegarder);
        Button btn_quitter = (Button) findViewById(R.id.btn_quitter);

        if (chk_messageacceptation.isChecked()) {
            btn_sauvegarder.setEnabled(true);
            btn_quitter.setEnabled(true);
        } else {
            btn_sauvegarder.setEnabled(false);
            btn_quitter.setEnabled(false);
        }

    }

    public void onClickbtn_sauvegarder(View view) {
        Context context = getApplicationContext();
        String texte = "Le profil est enregistré";
        int duree = Toast.LENGTH_LONG;

        Toast msg_toast  = Toast.makeText(context, texte, duree);
        msg_toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        msg_toast.show();
    }

    public void onClickbtn_quitter (View view){
        AlertDialog.Builder alerteDialogueBuiler = new AlertDialog.Builder(this);
        alerteDialogueBuiler.setMessage("Voulez-vous vraiment quitter l'application?");

        alerteDialogueBuiler.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alerteDialogueBuiler.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
            }
        });

        AlertDialog alerteDialogue = alerteDialogueBuiler.create();
        alerteDialogue.show();

    }

}