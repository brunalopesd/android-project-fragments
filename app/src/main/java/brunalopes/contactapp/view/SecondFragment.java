package brunalopes.contactapp.view;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import brunalopes.contactapp.model.Contato;
import brunalopes.contactapp.R;

public class SecondFragment extends Fragment {

    Contato contato;

    public SecondFragment(Contato contato) {
        super(R.layout.second_activity);
        this.contato = contato;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText edtTelefone = getActivity().findViewById(R.id.edtTelefone);
        EditText edtEndereco = getActivity().findViewById(R.id.edtEndereco);
        edtTelefone.setText(contato.getTelefone());
        edtEndereco.setText(contato.getEndereco());
    }


    @Override
    public void onPause() {
        super.onPause();
        dadosContato();
    }

    @Override
    public void onResume() {
        super.onResume();
        dadosContato();
    }

    @Override
    public void onStop() {
        super.onStop();
        dadosContato();
    }

     public void dadosContato() {
            EditText edtTelefone = getActivity().findViewById(R.id.edtTelefone);
            contato.setTelefone(edtTelefone.getText().toString());
            EditText edtEndereco = getActivity().findViewById(R.id.edtEndereco);
            contato.setEndereco(edtEndereco.getText().toString());
     }
}
