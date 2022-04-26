package two.one.sqlitedrawer;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import two.one.sqlitedrawer.databinding.FragmentMachinesListBinding;
import two.one.sqlitedrawer.placeholder.PlaceholderContent.PlaceholderItem;
import two.one.sqlitedrawer.databinding.FragmentMarqueBinding;
import two.one.sqlitedrawer.classes.Marque;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link two.one.sqlitedrawer.ui.slideshow.SlideshowViewModel}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter2 extends RecyclerView.Adapter<MyItemRecyclerViewAdapter2.ViewHolder> {

    private final List<Marque> mValues;

    public MyItemRecyclerViewAdapter2(List<Marque> items) {
        mValues = items;
    }

    @Override
    public MyItemRecyclerViewAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyItemRecyclerViewAdapter2.ViewHolder(FragmentMarqueBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final MyItemRecyclerViewAdapter2.ViewHolder holder, int position) { ;
        holder.code .setText(mValues.get(position).getCode());
        holder.libelle.setText(mValues.get(position).getLibelle());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView code;
        public final TextView libelle;


        public ViewHolder(FragmentMarqueBinding binding) {
            super(binding.getRoot());
            code = binding.code;
            libelle = binding.libelle;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + code.getText() + "'";
        }
    }
}
