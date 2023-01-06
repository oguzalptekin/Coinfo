package Models;

public class ChainModel {

    public String name;
    public String shortName;
    public String priceWay;
    public String marketCap;
    public String change24h;

    public ChainModel(String name, String shortName, String priceWay, String marketCap, String change24h){

        this.name = name;
        this.shortName = shortName;
        this.priceWay = priceWay;
        this.marketCap = marketCap;
        this.change24h = change24h;

    }
}
