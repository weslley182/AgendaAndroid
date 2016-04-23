package br.com.wesley.agenda.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.wesley.agenda.FormularioActivity;
import br.com.wesley.agenda.R;
import br.com.wesley.agenda.modelo.Aluno;

/**
 * Created by Wesley on 22-Apr-16.
 */
public class FormularioHelper {
    private Aluno aluno;
    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoTelefone;
    private EditText campoSite;
    private RatingBar campoNota;


    public FormularioHelper(FormularioActivity activity) {
        this.aluno = new Aluno();
        this.campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.campoEndereco = (EditText) activity.findViewById(R.id.formulario_end);
        this.campoTelefone = (EditText) activity.findViewById(R.id.formulario_tel);
        this.campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        this.campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
    }

    public Aluno pegarAluno(){
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));
        return aluno;
    }

    public void preencherFormulario(Aluno aluno) {
        this.aluno = aluno;
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
    }
}
