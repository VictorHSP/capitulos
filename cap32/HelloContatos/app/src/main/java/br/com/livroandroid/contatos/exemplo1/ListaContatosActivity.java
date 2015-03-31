package br.com.livroandroid.contatos.exemplo1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.livroandroid.contatos.R;
import br.com.livroandroid.contatos.adapter.ContatoAdapter;
import br.com.livroandroid.contatos.agenda.Agenda;
import br.com.livroandroid.contatos.agenda.Contato;

/**
 * Utiliza a classe Agenda para buscar no content contatos.
 */
public class ListaContatosActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        final ListView listView = (ListView) findViewById(br.com.livroandroid.contatos.R.id.listView);
        listView.setOnItemClickListener(this);

        // Lista os contatos
        final Agenda a = new Agenda(this);
        final List<Contato> contatos = a.getContatos();
        final ContatoAdapter adapter = new ContatoAdapter(getBaseContext(), contatos);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Agenda a = new Agenda(this);
        Contato c = a.getContatoById(id);
        Toast.makeText(this, "Ex1: " + c.nome, Toast.LENGTH_SHORT).show();
        c.show(this);
    }
}
