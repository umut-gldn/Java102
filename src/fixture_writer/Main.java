package fixture_writer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> teams = List.of(
                "Galatasaray", "Bursaspor", "Fenerbahçe",
                "Beşiktaş", "Başakşehir", "Trabzonspor");

        Fixture fixture = new Fixture(teams);
        fixture.generate();
    }
}