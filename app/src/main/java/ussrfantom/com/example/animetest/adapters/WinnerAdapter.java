package ussrfantom.com.example.animetest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import ussrfantom.com.example.animetest.R;
import ussrfantom.com.example.animetest.pojo.Table;

public class WinnerAdapter extends  RecyclerView.Adapter<WinnerAdapter.WinnerViewHolder>{

    private List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public WinnerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.table_item, viewGroup,false);
        return new WinnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  WinnerViewHolder holder, int position) {
        int a = position + 1;
        Table table = tables.get(position);
        holder.textViewLevelNumber.setText(table.getLevel());
        holder.textViewName.setText(table.getName());
        holder.textViewDescription.setText(table.getDescription());
        holder.textViewWinner.setText(String.valueOf(a));
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    class WinnerViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewLevelNumber;
        private TextView textViewDescription;
        private TextView textViewWinner;





        public WinnerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLevelNumber = itemView.findViewById(R.id.textViewLevelNumber);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewWinner = itemView.findViewById(R.id.textViewWinner);
        }
    }
}
