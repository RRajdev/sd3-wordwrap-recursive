import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordwrapTest {

    private Wordwrap wordWrap;

    @BeforeEach
    public void Init(){
        wordWrap = new Wordwrap();
    }

    @Test
    public void doesNotWrapLineWithFewerCharsThanLineLength(){
        String line = "aaa aaa";
        String wrappedLine = wordWrap.wrap(line, 10);
        assertEquals(wrappedLine, line);
    }

    @Test
    public void wrapsLineWithMoreCharsThanLineLength(){
        String line = "aaa bbb";
        String expectedOutput = "aaa" + System.lineSeparator() + "bbb";
        String wrappedLine = wordWrap.wrap(line, 3);
        assertEquals(expectedOutput, wrappedLine);
    }

    @Test
    public void wrapsTextWithoutBreakingTheWord(){
        String line = "aaaa abcd";
        String expectedOutput = "aaaa" + System.lineSeparator() + "abcd";
        String wrappedLine = wordWrap.wrap(line, 6);
        assertEquals(expectedOutput, wrappedLine);
    }

    @Test
    public void wrapsTextWithoutBreakingTheWordWhereLineHasMoreThanOneWord(){
        String line = " aaa xxx yyy zzz";
        String expectedOutput = "aaa xxx" + System.lineSeparator() + "yyy zzz";
        String wrappedLine = wordWrap.wrap(line, 7);
        assertEquals(expectedOutput, wrappedLine);
    }

    @Test
    public void wrapsTextWithoutBreakingTheWordAgain(){
        String line = " aaa xxx yyy zzz";
        String expectedOutput = "aaa" + System.lineSeparator() + "xxx" + System.lineSeparator() + "yyy" + System.lineSeparator() + "zzz";
        String wrappedLine = wordWrap.wrap(line, 6);
        assertEquals(expectedOutput, wrappedLine);
    }
}