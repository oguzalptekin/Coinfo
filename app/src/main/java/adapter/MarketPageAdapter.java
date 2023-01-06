package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oguz.coinfo.R;

import java.util.ArrayList;

import Models.MarketModel;

public class MarketPageAdapter extends RecyclerView.Adapter<MarketPageAdapter.MarketHolder>{

    private ArrayList<MarketModel> markets;

    public MarketPageAdapter(ArrayList<MarketModel> markets){
        this.markets = markets;
    }

    @NonNull
    @Override
    public MarketPageAdapter.MarketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.market_row_layout, parent, false);
        return new MarketHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketPageAdapter.MarketHolder holder, int position) {
        holder.bind(markets.get(position), position);
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }

    public class MarketHolder extends RecyclerView.ViewHolder {


        TextView rowNumberMarket, marketName, rowVolume, rowVolumePercent, change24hHome;

        public MarketHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(MarketModel markets, Integer position){

            rowNumberMarket = itemView.findViewById(R.id.rowNumberMarket);
            rowNumberMarket.setText(position);
            marketName = itemView.findViewById(R.id.marketName);
            marketName.setText(markets.name);
            rowVolume = itemView.findViewById(R.id.rowVolume);
            rowVolume.setText(markets.volume);
            rowVolumePercent = itemView.findViewById(R.id.rowVolumePercent);
            rowVolumePercent.setText(markets.change);
            change24hHome = itemView.findViewById(R.id.score);
            change24hHome.setText(markets.score);

        }
    }
}
