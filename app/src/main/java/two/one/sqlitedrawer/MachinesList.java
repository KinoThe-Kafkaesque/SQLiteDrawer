package two.one.sqlitedrawer;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import two.one.sqlitedrawer.placeholder.PlaceholderContent;
import two.one.sqlitedrawer.service.MachineService;

/**
 * A fragment representing a list of Items.
 */
public class MachinesList extends Fragment {
    private static MachineService machineService = MainActivity.machineService;

    // TODO: Customize parameters
    private static int id = 1;
    private static String refrence;
    private static String date;
    private static Double prix;
    private static String marque;




    // TODO: Customize parameter argument names
    private static final String ARG_REFRENCE  = "refrence";
    private static final String ARG_ID = "id";
    private static final String ARG_MARQUE = "marque";


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MachinesList newInstance(int columnCount) {
        MachinesList fragment = new MachinesList();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        args.putString(ARG_REFRENCE, refrence);
        args.putString(ARG_MARQUE, marque);

        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MachinesList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            id = getArguments().getInt(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_machines_list_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (id <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, id));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(MainActivity.machineService.findAll()));
        }
        return view;
    }
}