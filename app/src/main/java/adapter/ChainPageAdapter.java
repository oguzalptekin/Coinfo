package adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oguz.coinfo.R;

import java.util.ArrayList;

import Models.ChainModel;

public class ChainPageAdapter extends RecyclerView.Adapter<ChainPageAdapter.ChainHolder> {

    private ArrayList<ChainModel> chains; //will be fixed

    public ChainPageAdapter(ArrayList<ChainModel> chains){ //will be fixed
        this.chains = chains;
    }

    @NonNull
    @Override
    public ChainPageAdapter.ChainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chain_row_layout, parent, false);
        return new ChainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChainPageAdapter.ChainHolder holder, int position) {
        holder.bind(chains.get(position), position);
    }

    @Override
    public int getItemCount() {
        return chains.size();
    }

    public class ChainHolder extends RecyclerView.ViewHolder {

        TextView rowNumberChain, nameChain, shortNameChain, rowTVL, rowTVL24h;


        public ChainHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(ChainModel chains, Integer position){ //will be fixed

            rowNumberChain = itemView.findViewById(R.id.rowNumberChain);
            rowNumberChain.setText(position);
            nameChain = itemView.findViewById(R.id.nameChain);
            nameChain.setText(chains.name);
            shortNameChain = itemView.findViewById(R.id.shortNameChain);
            shortNameChain.setText(chains.shortName);
            rowTVL = itemView.findViewById(R.id.rowTVL);
            rowTVL.setText(chains.marketCap);
            rowTVL24h = itemView.findViewById(R.id.rowTVL24h);
            rowNumberChain.setText(chains.change24h);
        }
    }
}
