package brunalopes.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import brunalopes.contactapp.model.Contato;
import brunalopes.contactapp.view.FirstFragment;
import brunalopes.contactapp.view.SecondFragment;
import brunalopes.contactapp.view.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    int index = 0;

    Contato contato = new Contato();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSalvar = findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarContato(contato);
            }
        });

        Button btProximo = findViewById(R.id.btProximo);
        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProximoFragmento();
            }
        });

        Button btVoltar = findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VoltarFragmento();
            }
        });

        irParaFragmento(index);
    }

    public void ProximoFragmento() {
        index++;
        if (index > 2) {
            index = 2;
        }
        irParaFragmento(index);
    }

    public void VoltarFragmento() {
        index--;
        if (index < 0) {
            index = 0;
        }
        irParaFragmento(index);
    }

    private void irParaFragmento(int index) {
        Fragment fragment = null;
        switch(index){
            case 0:
                fragment = new FirstFragment(contato);
                Log.d("main activity", "Fragmento um");
                break;
            case 1:
                fragment = new SecondFragment(contato);
                Log.d("main activity", "Fragmento dois");
                break;
            case 2:
                fragment = new ThirdFragment(contato);
                Log.d("main activity", "Fragmento tres");
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();

    }

    public void salvarContato(Contato contato) {
        dadosDoContato(contato);
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION)
                .putExtra(ContactsContract.Intents.Insert.NAME, contato.getNome())
                .putExtra(ContactsContract.Intents.Insert.EMAIL, contato.getEmail())
                .putExtra(ContactsContract.Intents.Insert.PHONE, contato.getTelefone())
                .putExtra(ContactsContract.Intents.Insert.POSTAL, contato.getEndereco())
                .putExtra(ContactsContract.Intents.Insert.JOB_TITLE, contato.getTrabalho());
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        startActivity(intent);
    }

    private void dadosDoContato(Contato contato) {
        EditText edtNome = findViewById(R.id.edtNome);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtTelefone = findViewById(R.id.edtTelefone);
        EditText edtEndereco = findViewById(R.id.edtEndereco);
        EditText edtTrabalho = findViewById(R.id.edtTrabalho);

        contato.setNome(validaCampos(edtNome));
        contato.setEmail(validaCampos(edtEmail));
        contato.setTelefone(validaCampos(edtTelefone));
        contato.setEndereco(validaCampos(edtEndereco));
        contato.setTrabalho(validaCampos(edtTrabalho));
    }

    private String validaCampos(EditText editText) {
        if (editText == null){
            return "";
        }
        return editText.getText().toString();
    }

}

