import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test

    public void testFirstPlayerWins() {
        Game game = new Game();
        Player Olya = new Player(1, "Olya", 90);
        Player Kolya = new Player(2, "Kolya", 100);

        game.register(Olya);
        game.register(Kolya);

        int actual = game.round("Kolya", "Olya");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testSecondPlayerWins() {
        Game game = new Game();
        Player Olya = new Player(1, "Olya", 90);
        Player Kolya = new Player(2, "Kolya", 100);

        game.register(Olya);
        game.register(Kolya);

        int actual = game.round("Olya", "Kolya");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testDrawWinsPlayer() {
        Game game = new Game();
        Player Olya = new Player(1, "Olya", 100);
        Player Kolya = new Player(2, "Kolya", 100);

        game.register(Olya);
        game.register(Kolya);

        int actual = game.round("Olya", "Kolya");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerFirstNotRegistered() {
        Game game = new Game();
        Player Olya = new Player(1, "Olya", 90);
        Player Kolya = new Player(2, "Kolya", 100);

        game.register(Olya);
        game.register(Kolya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sasha", "Kolya"));
    }

    @Test
    public void playerSecondNotRegistered() {
        Game game = new Game();
        Player Olya = new Player(1, "Olya", 90);
        Player Kolya = new Player(2, "Kolya", 100);

        game.register(Olya);
        game.register(Kolya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Olya", "Fedya"));
    }

    @Test
    public void playerBothNotRegistered() {
        Game game = new Game();
        Player Olya = new Player(1, "Olya", 90);
        Player Kolya = new Player(2, "Kolya", 100);

        game.register(Olya);
        game.register(Kolya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sasha", "Fedya"));
    }
}
