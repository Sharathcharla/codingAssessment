import java.util.ArrayList;

public class Assessment {
    public static void main(String[] args) {
        int n = 2;
        ArrayList < String > IPL_Teams_Scores = new ArrayList < > ();
        IPL_Teams_Scores.add("GT-20-WWLLW");
        IPL_Teams_Scores.add("LSG-18-WLLWW");
        IPL_Teams_Scores.add("RR-16-WLWLL");
        IPL_Teams_Scores.add("DC-14-WWLWL");
        IPL_Teams_Scores.add("RCB-14-LWWLL");
        IPL_Teams_Scores.add("KKR-12-LWWLW");
        IPL_Teams_Scores.add("PBKS-12-LWLWL");
        IPL_Teams_Scores.add("SRH-12-WLLLL");
        IPL_Teams_Scores.add("CSK-8-LLWLW");
        IPL_Teams_Scores.add("MI-6-LWLWW");

        ArrayList < String > filtered_teams = new ArrayList < > ();

        for (String team: IPL_Teams_Scores) {
            String[] values = team.split("-");
            String last_five_matches = values[2];
            char[] score_arr = last_five_matches.toCharArray();

            int consecutive_losses = 0;

            for (char score: score_arr) {
                if (score == 'L') {
                    consecutive_losses += 1;
                } else {
                    consecutive_losses = 0;
                }
                if (consecutive_losses == n) {
                    filtered_teams.add(team);
                    break;
                }

            }
        }
        System.out.println(filtered_teams);
        System.out.println("The number of teams those have 2 consecutive loses are " +filtered_teams.size());
        // Here the points are of teams who have consecutive losses
        int team_points;
        int total_points =0;
        for (String team: filtered_teams) {
            String[] values = team.split("-");
            team_points =Integer.parseInt(String.valueOf(values[1]));
            System.out.print(team_points+"  ");
            total_points = total_points +team_points;
        }
        System.out.println("Average points of team are: "+(total_points/filtered_teams.size()));


    }

}