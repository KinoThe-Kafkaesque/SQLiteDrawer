package two.one.sqlitedrawer.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import two.one.sqlitedrawer.MainActivity;
import two.one.sqlitedrawer.classes.Machine;
import two.one.sqlitedrawer.classes.Marque;
import two.one.sqlitedrawer.databinding.FragmentHomeBinding;
import two.one.sqlitedrawer.databinding.FragmentSlideshowBinding;
import two.one.sqlitedrawer.service.MachineService;
import two.one.sqlitedrawer.service.MarqueService;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private Button add;
    private EditText code;
    private EditText libelle;
    private MarqueService marqueService = MainActivity.marqueService;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        add = binding.addm;
        code = binding.code;
        libelle = binding.libelle;
        List<String> spinnerArray = new ArrayList<String>();
        //for each item in ms.find all filter by marque
        for (Marque s : marqueService.findAll()) {
            spinnerArray.add(s.getLibelle());
        }



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marqueService.create(new Marque(code.getText().toString(), libelle.getText().toString()));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}