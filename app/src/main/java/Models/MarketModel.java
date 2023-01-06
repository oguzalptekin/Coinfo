package Models;

public class MarketModel {

    public String name;
    public String way;
    public String volume;
    public String change;
    public String score;

    public MarketModel(String name, String way, String volume, String change, String score){
        this.name = name;
        this.way = way;
        this.volume = volume;
        this.change = change;
        this.score = score;
    }
}
