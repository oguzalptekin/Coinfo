package adapter;

import android.content.Context;
import android.media.MediaCodec;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oguz.coinfo.R;

import java.util.ArrayList;
import Models.CoinModel;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.RowHolder> {

    ArrayList<CoinModel> coinlist;

    public HomePageAdapter(ArrayList<CoinModel> coinlist){
        this.coinlist = coinlist;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.homepage_row_layout, parent, false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

        CoinModel coinModel = coinlist.get(position);

        holder.rowNumberHome.setText(position);
        System.out.println("yani burası mı");
        holder.rowNameCoinHome.setText(coinModel.name);
        holder.rowCapCoinHome.setText(coinModel.marketCap);
        holder.rowCoinPriceHome.setText(coinModel.price);
        holder.change24hHome.setText(coinModel.change24h);
        if(coinModel.priceWay.equals("-1")){
            holder.change24hHome.setTextColor(Integer.parseInt("#FE0100")); //red
        }
        else if(coinModel.priceWay.equals("0")){
            holder.change24hHome.setTextColor(Integer.parseInt("#FF000000")); //black
        }
        else if(coinModel.priceWay.equals("1")){
            holder.change24hHome.setTextColor(Integer.parseInt("#5EBA7D")); //green
        }
    }

    @Override
    public int getItemCount() {
        return coinlist.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        TextView rowNumberHome, rowNameCoinHome, rowCapCoinHome, rowCoinPriceHome, change24hHome;


        public RowHolder(@NonNull View itemView) {
            super(itemView);

            rowNumberHome = itemView.findViewById(R.id.rowNumberHome);
            rowNameCoinHome = itemView.findViewById(R.id.rowNameCoinHome);
            rowCapCoinHome = itemView.findViewById(R.id.rowCapCoinHome);
            rowCoinPriceHome = itemView.findViewById(R.id.rowCoinPriceHome);
            change24hHome = itemView.findViewById(R.id.change24hHome);
        }
    }
}
