package com.fgm.cadastro;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ListaAlunos extends Activity {

    public final static String EXTRA_MESSAGE = "com.fgm.MESSAGE";

    //==== onCreate
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

        //chama a tela xml
		setContentView(R.layout.lista);
		//monta a tela com conteúdo

        //Lista de Alunos
		List<String> alunos = Arrays.asList("Anderson","Filipe","João");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1, alunos);

		final ListView listaAlunos = (ListView) findViewById(R.id.listaAlunos);
		listaAlunos.setAdapter(adapter);
		listaAlunos.setClickable(true);

		listaAlunos.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id)
			{				
				Toast.makeText(ListaAlunos.this, "Posicao selecionada da Lista: " + posicao, Toast.LENGTH_LONG).show();
			}
		});
		
        listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {
    		@Override
    		public boolean onItemLongClick(AdapterView<?> adapter, View view,
    				int posicao, long id) {
    			registerForContextMenu(listaAlunos);
        		//alunoSelecionado = (Aluno) adapter.getItemAtPosition(posicao);
    			return false;
    		}
	});
        //fim lista Alunos
	}

	//==== FIM ONCREATE

    //========= MENU onCreateOptionsMenu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuItem novo = menu.add(0,0,0,"Novo");
		novo.setIcon(R.drawable.ic_novo);
		
		MenuItem sincronizar = menu.add(0,1,0,"Sincronizar");
		sincronizar.setIcon(R.drawable.ic_planeta);
		
		MenuItem galeria = menu.add(0,2,0,"Galeria");
		galeria.setIcon(R.drawable.ic_foto);

		MenuItem mapa = menu.add(0,3,0,"Mapa");
		mapa.setIcon(R.drawable.ic_mapa);
		
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		if (item.getItemId()==0) {
			Toast.makeText(ListaAlunos.this, "vc clicou no Menu Novo", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(ListaAlunos.this, formularioAlunos.class);
            intent.putExtra(EXTRA_MESSAGE, "parametro");
			startActivity(intent);
            //vide que o processamento não para no toast, ele continua depois do startactivity
			Toast.makeText(ListaAlunos.this, "vc fechou o menu Novo na tela ListaAlunos", Toast.LENGTH_LONG).show();
			//return false;
		}
		else {
				Toast.makeText(ListaAlunos.this, "Vc Clicou Menu: " + item.getItemId(), Toast.LENGTH_LONG).show();
		}
	return false;	

    //===== FIM MENU OPTIONS



	//fim
}
}

