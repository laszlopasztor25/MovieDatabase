package com.mdb;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pasztor on 2015.11.15..
 */
public class MovieGateway {

    private static List<Movie> movies;
    private static List<Movie> watchlist;
    private static List<Celeb> celebs;

    static {
        movies = new ArrayList<>();;
        celebs = new ArrayList<>();;
        watchlist = new ArrayList<>();;
        movies.add(new Movie("Star Wars: Episode VII - The Force Awakens", "Harrison Ford, Mark Hamill, Carrie Fisher", R.drawable.star_wars, R.raw.themartian_vid, "A continuation of the saga created by George Lucas and set thirty years after A Jedi visszatér (1983).",
                new DateTime(2015, 12, 16, 0, 0)));
        movies.add(new Movie("Warcraft", "Travis Fimmel, Dominic Cooper, Paula Patton ", R.drawable.warcraft, R.raw.themartian_vid, "An epic fantasy/adventure based on the popular video game series.", new DateTime()));
        movies.add(new Movie("The Revenant", "Tom Hardy, Leonardo DiCaprio, Domhnall Gleeson ", R.drawable.revenant, R.raw.themartian_vid, "In the 1820s, a frontiersman, Hugh Glass, sets out on a path of vengeance against those who left him for dead after a bear mauling.",
                new DateTime().plusWeeks(4)));
        movies.add(new Movie("The Hunger Games: Mockingjay - Part 2", "Jennifer Lawrence, Josh Hutcherson, Liam Hemsworth", R.drawable.hunger_games, R.raw.themartian_vid, "As the war of Panem escalates to the destruction of other districts by the Capitol, Katniss Everdeen, the reluctant leader of the rebellion, must bring together an army against President Snow, while all she holds dear hangs in the balance.",
                new DateTime().plusDays(2)));
        movies.add(new Movie("The Martian", "Matt Damon, Jessica Chastain, Kristen Wiig, Jeff Daniels, Michael Peña", R.drawable.martian, R.raw.themartian_vid, "During a manned mission to Mars, Astronaut Mark Watney is presumed dead after a fierce storm and left behind by his crew. But Watney has survived and finds himself stranded and alone on the hostile planet.",
                new DateTime().plusDays(5)));
        movies.add(new Movie("The Dark Knight", "Christian Bale, Heath Ledger, Aaron Eckhart", R.drawable.tdk, R.raw.themartian_vid, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.",
                new DateTime().plusDays(10)));

        celebs.add(new Celeb("Jake Gyllenhaal", "Source Code, Zodiac", R.drawable.jake));
        celebs.add(new Celeb("Jennifer Lawrence", "Silver Linings Playbook, The Hunger Games", R.drawable.jennifer_lawrence));
        celebs.add(new Celeb("Tom Hardy", "Mad Max: Fury Road, Inception", R.drawable.tom_hardy));
        celebs.add(new Celeb("Chloë Grace Moretz", "Kick-Ass, Let Me In", R.drawable.chloe_moretz));
        celebs.add(new Celeb("Christoph Waltz", "Django Unchained, Inglourious Basterds", R.drawable.chris_waltz));
        celebs.add(new Celeb("Melissa Benoist", "Whiplash, The Longest Ride", R.drawable.melissa));
        celebs.add(new Celeb("Analeigh Tipton", "Warm Bodies, Crazy, Stupid, Love.", R.drawable.anelight_tipton));
        celebs.add(new Celeb("Leonardo DiCaprio", "The Departed, The Wolf of Wall Street", R.drawable.leonardo_dicaprio));

    }

    public static List<Movie> getmovies() { return movies; }

    /**
     * Visszaadja a watchlistban lévő filmek címét.
     *
     * @return titles
     */
    public static HashSet<String> getWatchlistTitles() {
        HashSet<String> titles = new HashSet<String>();
        for(Movie m : watchlist) {
            titles.add(m.getTitle());
        }
        return titles;
    }

    /**
     * Hozzáadja a paraméterül kapott filmek címét a watchlisthoz.
     *
     * @param titles
     */
    public static void  setWatchlistByTitles(Set<String> titles) {
        for (String t: titles) {
            for (Movie m : watchlist) {
                if(t.equals(m.getTitle()) && !watchlist.contains(m)) {
                    watchlist.add(m);
                    break;
                }
            }
        }

    }

    public static List<Movie> getWatchList() {
        return watchlist;
    }
    public static List<Celeb> getCelebs() {
        return celebs;
    }

}
