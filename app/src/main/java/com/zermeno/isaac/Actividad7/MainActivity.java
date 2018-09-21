package com.zermeno.isaac.Actividad7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextTelefono;
    EditText editTextURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTelefono = (EditText)findViewById(R.id.inputNumero);
        editTextURL = (EditText)findViewById(R.id.inputURL);
    }

    public void botonTelefono (View view){
        String numero = editTextTelefono.getText().toString();
        if(TextUtils.isDigitsOnly(numero)&& numero.length()==10){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + numero));
            startActivity(intent);
        }
        else {
            editTextTelefono.setError("El telefono debe tener 10 digitos");
        }
    }

    public void botonURL(View view){
        String URL = editTextURL.getText().toString();
        if(URLUtil.isValidUrl(URL)){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(URL));
            startActivity(i);
        }
        else{
           editTextURL.setError("Debe ser una pagina valida");
        }
    }

    public void botonMapas (View view){
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}

