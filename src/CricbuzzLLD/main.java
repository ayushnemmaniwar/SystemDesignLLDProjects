package CricbuzzLLD;
//User -> Matches -> Teams -> Players -> Game


import java.sql.Time;
import java.util.Date;
import java.util.List;

class Match {
    int matchId;
    Team teamA;
    Team teamB;
    Date date;
    Time time;
    String location;
}

class Team {
    int teamId;
    String teamName;
    List<Match> matchList;
    List<Player> playerList;
    String homeGround;
}

class Player {
    int playerId;
    String playerName;
    int runsScored;
    int wicketsTaken;
    String strength;

}

public class main {
}
