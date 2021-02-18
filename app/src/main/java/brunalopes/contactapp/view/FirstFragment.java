package brunalopes.contactapp.view;

import android.widget.EditText;

import androidx.fragment.app.Fragment;

import brunalopes.contactapp.model.Contato;
import brunalopes.contactapp.R;

public class FirstFragment extends Fragment {

    Contato contato;

    public FirstFragment(Contato contato) {
        super(R.layout.first_activity);
        this.contato = contato;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText edtNome = getActivity().findViewById(R.id.edtNome);
        EditText edtEmail = getActivity().findViewById(R.id.edtEmail);
        edtNome.setText(contato.getNome());
        edtEmail.setText(contato.getEmail());
    }

    @Override
    public void onPause() {
        super.onPause();
        dadosContato();
    }

    public void dadosContato(){
        EditText edtNome = getActivity().findViewById(R.id.edtNome);
        EditText edtEmail = getActivity().findViewById(R.id.edtEmail);
        contato.setNome(edtNome.getText().toString());
        contato.setEmail(edtEmail.getText().toString());
    }

}



