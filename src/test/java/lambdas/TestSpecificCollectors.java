package lambdas;

import junit.framework.TestCase;
import lambdas.music.Artist;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class TestSpecificCollectors {
    private List<Artist> artists = new ArrayList<>();

    @Before
    public void before() {
        Artist artist1 = new Artist("dali", Arrays.asList("xiaohei", "erhei"), "liwupu");
        Artist artist2 = new Artist("jiakechong", Arrays.asList("john", "lienong"), "zhongguo");
        artists.add(artist1);
        artists.add(artist2);
    }

    @Test
    public void testForEach() {
        StringBuilder stringBuilder = new StringBuilder("[");
        artists.stream().map(Artist::getName).forEach(name -> {
                    if (stringBuilder.length() > 1) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(name);
                }
        );
        stringBuilder.append("]");
        TestCase.assertEquals("[dali,jiakechong]", stringBuilder.toString());
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void testReduce() {
        StringBuilder reduced = artists.stream().map(Artist::getName).reduce(new StringBuilder("["), (builder, name) -> {
            if (builder.length() > 1) {
                builder.append(",");
            }
            builder.append(name);
            return builder;
        }, StringBuilder::append);
        reduced.append("]");
        TestCase.assertEquals("[dali,jiakechong]", reduced.toString());
        System.out.println(reduced.toString());
    }

    @Test
    public void testReduceStringCombiner() {
        String joinString = artists.stream().map(Artist::getName).reduce(new StringJoiner(",", "[", "]"), StringJoiner::add, StringJoiner::merge).toString();
        TestCase.assertEquals("[dali,jiakechong]", joinString);
    }
}
