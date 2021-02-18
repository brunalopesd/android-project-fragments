package brunalopes.contactapp.view;

import android.widget.EditText;

import androidx.fragment.app.Fragment;

import brunalopes.contactapp.model.Contato;
import brunalopes.contactapp.R;

public class ThirdFragment extends Fragment {

    Contato contato;

    public ThirdFragment(Contato contato)  {
        super(R.layout.third_activity);
        this.contato = contato;
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText edtTrabalho = getActivity().findViewById(R.id.edtTrabalho);
        edtTrabalho.setText(contato.getTrabalho());
    }

    @Override
    public void onPause() {
        super.onPause();
        dadosContato();
    }

    public void dadosContato() {
        EditText edtTrabalho = getActivity().findViewById(R.id.edtTrabalho);
        contato.setTrabalho(edtTrabalho.getText().toString());
    }
}