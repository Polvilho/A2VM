package com.tcc.infracoesurbanas;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tcc.model.Autuacao;

public class ListaAutuacoes extends ListActivity{
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayList<Autuacao> listaAutuacoes = new ArrayList<Autuacao>();
		
		if (getIntent().hasExtra("lista")) {
			
			listaAutuacoes = (ArrayList<Autuacao>) getIntent().getExtras()
					.getSerializable("lista");
		}
		
		setListAdapter(new ArrayAdapter<Autuacao>(this, R.layout.list_item,
				listaAutuacoes));
		
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();	
			}
		});
	}
	
}
