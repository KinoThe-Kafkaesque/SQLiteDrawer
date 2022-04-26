package two.one.sqlitedrawer.ui.home;

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

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import two.one.sqlitedrawer.MainActivity;
import two.one.sqlitedrawer.classes.Machine;
import two.one.sqlitedrawer.classes.Marque;
import two.one.sqlitedrawer.databinding.FragmentHomeBinding;
import two.one.sqlitedrawer.service.MachineService;
import two.one.sqlitedrawer.service.MarqueService;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Button add;
    private MachineService ms = MainActivity.machineService;
    private EditText reference;
    private Spinner marque;
    private MarqueService marqueService = MainActivity.marqueService;
    private String mark;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        add = binding.addm;
        reference = binding.Tref;
        List<String> spinnerArray = new ArrayList<String>();
        //for each item in ms.find all filter by marque
        for (Marque s : marqueService.findAll()) {
            spinnerArray.add(s.getLibelle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                binding.getRoot().getContext(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marque = binding.marques;
        marque.setAdapter(adapter);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ms.create(new Machine(reference.getText().toString(), marque.getSelectedItem().toString()));
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