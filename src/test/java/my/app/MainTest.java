package my.app;

import com.google.common.io.CharStreams;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ratpack.test.ApplicationUnderTest;
import ratpack.test.MainClassApplicationUnderTest;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class MainTest {
    MainClassApplicationUnderTest aut = new MainClassApplicationUnderTest(Main.class);

    @After
    public void tearDown() {
        aut.close();
    }

    @Test
    public void helloHandler() {
        assertEquals("Hello World!", get("/"));
    }

    @Test
    public void fooHandler() {
        assertEquals("from the foo handler", get("/foo"));
    }

    @Test
    public void barHandler() {
        assertEquals("from the bar handler", get("/bar"));
    }

    private String get(String path) {
        URI uri = aut.getAddress().resolve(path);

        try(InputStream in = uri.toURL().openStream()) {
            try (Reader r = new InputStreamReader(in)) {
                return CharStreams.toString(r);
            }
        } catch (Exception ex) {
            fail(ex.toString());
            return ""; // unreachable
        }
    }
}
