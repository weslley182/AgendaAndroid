package br.com.wesley.agenda;

import br.com.wesley.agenda.dao.AlunoDAO;
import br.com.wesley.agenda.helper.FormularioHelper;
import br.com.wesley.agenda.modelo.Aluno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.ListView;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;
    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        if(aluno != null){
            helper.preencherFormulario(aluno);
        }

        listaAlunos = (ListView) findViewById(R.id.lista_alunos);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_formulario_ok:
                Aluno aluno = helper.pegarAluno();
                AlunoDAO dao = new AlunoDAO(this);

                if(aluno.getId() == null){
                    dao.insere(aluno);
                }else{
                    dao.alterar(aluno);
                }

                dao.close();
                Toast.makeText(this, "Aluno " + aluno.getNome() + " Salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return true;
    }
}
