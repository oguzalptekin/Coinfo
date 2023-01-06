package Models;

import kotlin.jvm.internal.SerializedIr;

public class CoinModel {

    public String name;
    public String marketCap;
    public String price;
    public String priceWay;
    public String change24h;

    public CoinModel(String name, String marketCap, String price, String priceWay, String change24h){
        this.name = name;
        this.marketCap = marketCap;
        this.price = price;
        this.priceWay = priceWay;
        this.change24h = change24h;
    }



}
