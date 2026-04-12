package fixture_writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fixture {
    private List<String> teams;
    private Map<String, Integer> homeCount = new HashMap<>();
    private Map<String, Integer> awayCount = new HashMap<>();

    public Fixture(List<String> teams) {
        this.teams = new ArrayList<>(teams);
        Collections.shuffle(this.teams);
        if (this.teams.size() % 2 != 0) {
            this.teams.add("Bay");
        }
        for (String t : this.teams) {
            homeCount.put(t, 0);
            awayCount.put(t, 0);
        }
    }

    public void generate() {
        int n = teams.size();
        int roundCount = n - 1;
        int matchesPerRound = n / 2;

        List<String> rotating = new ArrayList<>(teams.subList(1, n));

        System.out.println("Takımlar");
        for (String t : teams) {
            System.out.println("- " + t);
        }
        System.out.println();

        // İlk devre
        for (int round = 0; round < roundCount; round++) {
            System.out.println("Round " + (round + 1));

            List<String> roundTeams = new ArrayList<>();
            roundTeams.add(teams.get(0));
            roundTeams.addAll(rotating);

            for (int match = 0; match < matchesPerRound; match++) {
                String home = roundTeams.get(match);
                String away = roundTeams.get(n - 1 - match);
                printMatch(home, away);
            }
            System.out.println();
            rotate(rotating);
        }

        rotating = new ArrayList<>(teams.subList(1, n));

        // İkinci devre
        for (int round = 0; round < roundCount; round++) {
            System.out.println("Round " + (roundCount + round + 1));

            List<String> roundTeams = new ArrayList<>();
            roundTeams.add(teams.get(0));
            roundTeams.addAll(rotating);

            for (int match = 0; match < matchesPerRound; match++) {
                String home = roundTeams.get(n - 1 - match);
                String away = roundTeams.get(match);
                printMatch(home, away);
            }
            System.out.println();
            rotate(rotating);
        }

        printStats();
    }

    private void printMatch(String home, String away) {
        System.out.println(home + " vs " + away);
        homeCount.put(home, homeCount.get(home) + 1);
        awayCount.put(away, awayCount.get(away) + 1);
    }

    private void printStats() {
        System.out.println("-- Ev/Deplasman Dağılımı --");
        System.out.format("%-15s | %-4s | %-4s%n", "Takım", "Ev", "Dep");
        System.out.println("-".repeat(28));
        for (String t : teams) {
            System.out.format("%-15s | %-4d | %-4d%n",
                    t, homeCount.get(t), awayCount.get(t));
        }
    }

    private void rotate(List<String> list) {
        String last = list.remove(list.size() - 1);
        list.add(0, last);
    }

}