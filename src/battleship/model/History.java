package battleship.model;

import battleship.utils.CSV;

import java.util.List;
import java.util.stream.Collectors;

public class History {
    private String playerName;
    private Boolean isWin;
    private String ratio;

    public static History create(String playerName, boolean isWin, String ratio) {
        return new History(playerName, isWin, ratio);
    }

    public static List<History> getHistories() {
        return CSV.readLineByLine()
                .stream()
                .map(item -> History.create(item[0], Boolean.parseBoolean(item[1]), item[2]))
                .collect(Collectors.toList());
    }

    private History(String playerName, Boolean isWin, String ratio) {
        this.playerName = playerName;
        this.isWin = isWin;
        this.ratio = ratio;
    }

    public void save() {
        CSV.writeDataInNextLine(this);
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getWin() {
        return isWin;
    }

    public String getRatio() {
        return ratio;
    }
}
