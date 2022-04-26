package two.one.sqlitedrawer;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import two.one.sqlitedrawer.classes.Machine;
import two.one.sqlitedrawer.placeholder.PlaceholderContent.PlaceholderItem;
import two.one.sqlitedrawer.databinding.FragmentMachinesListBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Machine> mValues;

    public MyItemRecyclerViewAdapter(List<Machine> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new ViewHolder(FragmentMachinesListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.reference.setText( mValues.get(position).getReference());
        holder.marque.setText(mValues.get(position).getMarque());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView reference;
        public final TextView marque;

    public ViewHolder(FragmentMachinesListBinding binding) {
      super(binding.getRoot());
      reference = binding.reference;
      marque = binding.marque;
    }

        @Override
        public String toString() {
            return super.toString() + " '" + reference.getText() + "'";
        }
    }
}