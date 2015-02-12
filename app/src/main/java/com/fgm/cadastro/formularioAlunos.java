package com.fgm.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class formularioAlunos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // recebe o intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(ListaAlunos.EXTRA_MESSAGE);

        //chama a tela xml
        setContentView(R.layout.formulario_alunos);

        Toast.makeText(formularioAlunos.this, "carreguei Formulario Alunos - "+message, Toast.LENGTH_LONG).show();
        Button meubotao = (Button) findViewById(R.id.meubotao);

        meubotao.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(formularioAlunos.this, "Voce Clicou no botao",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario_alunos, menu);
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
