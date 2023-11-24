package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsedTyles implements UsedTilesGiveInterface{
    private List<Tile> _usedTyles;
    private UsedTyles(){
        _usedTyles = new ArrayList<>();
    }

    private static class UsedTylesHolder {
        private static final UsedTyles INSTANCE = new UsedTyles();
    }

    public static UsedTyles getInstance() {
        return UsedTyles.UsedTylesHolder.INSTANCE;
    }

    public void give(Collection<Tile> tiles){
        for(Tile tile: tiles){
            _usedTyles.add(tile);
        }
    }

    public String state(){
        StringBuilder ans = new StringBuilder();
        ans.append("UsedTyles:\n");
        for (Tile ts: this._usedTyles) {
            ans.append(ts.toString()).append("\n");
        }
        return ans.toString();
    }

    public List<Tile> takeAll(){
        List<Tile> ans = _usedTyles;
        _usedTyles = new ArrayList<>();
        return ans;
    }
}
