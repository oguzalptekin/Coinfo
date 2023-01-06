/*package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oguz.coinfo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.RowHolder> {

    private ArrayList<CryptoModel> cryptoList;

    public SearchAdapter(ArrayList<CryptoModel> cryptoList){
        this.cryptoList = cryptoList;
    }
    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_layout, parent, false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.RowHolder holder, int position) {
        holder.bind(cryptoList.get(position), position);

    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }*/

/*

    public class RowHolder extends RecyclerView.ViewHolder {

        TextView rowNameCoinSearch, rowCapCoinSearch, rowCoinPriceSearch, change24hSearch;
        ImageView coinImageSearch, priceImageSearch;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(CryptoModel cryptoModel, Integer position){

            rowNameCoinSearch = itemView.findViewById(R.id.rowNameCoinSearch);
            rowNameCoinSearch.setText();
            rowCapCoinSearch = itemView.findViewById(R.id.rowCapCoinSearch);
            rowCapCoinSearch.setText();
            rowCoinPriceSearch = itemView.findViewById(R.id.rowCoinPriceSearch);
            rowCoinPriceSearch.setText();
            change24hSearch = itemView.findViewById(R.id.change24hSearch);
            change24hSearch.setText();
            coinImageSearch = itemView.findViewById(R.id.coinImageSearch);
            coinImageSearch.setImageResource();
            priceImageSearch = itemView.findViewById(R.id.priceImageSearch);
            priceImageSearch.setImageResource();
        }
    }
}*/
