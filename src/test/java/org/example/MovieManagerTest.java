package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void shouldAddAndFindAll() {
        MovieManager manager = new MovieManager();
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель Белград");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastIfMoviesLessThanLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Бладшот");
        manager.add("Вперёд");

        String[] expected = {"Вперёд", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastIfMoviesEqualToLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        manager.add("Фильм 5");

        String[] expected = {"Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2", "Фильм 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastIfMoviesMoreThanLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        manager.add("Фильм 5");
        manager.add("Фильм 6");

        String[] expected = {"Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithCustomLimitLessThanMovies() {
        MovieManager manager = new MovieManager(3);
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");

        String[] expected = {"Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithCustomLimitMoreThanMovies() {
        MovieManager manager = new MovieManager(7);
        manager.add("Фильм 1");
        manager.add("Фильм 2");

        String[] expected = {"Фильм 2", "Фильм 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnEmptyIfNoMovies() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldNotInitWithNegativeLimit() {
        MovieManager manager = new MovieManager(-1);
        manager.add("Фильм 1");

        String[] expected = {"Фильм 1"};
        assertArrayEquals(expected, manager.findLast());
    }

}
