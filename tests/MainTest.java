
import io.steven_beard.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
     void Should_Return_LargestWord_FirstSentence_AverageWordLength() throws IOException {
        // Given
        String expected = "The largest word is " + "Antidisestablishmentarianism" + "." + "\n" +
                "The first sentence using the largest word is \"" + "I think for"+"\n"+ "my really long word I will use Antidisestablishmentarianism" + ".\"" + "\n" +
                "The average word length is " + "3.8636363636363638" + " letters.";

        // When
         String actual = Main.getLargestWordAndWordCount("./testFile.txt");
        // Then
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Should_Get_IOException_When_Argument_Is_Not_A_File(){
        String filePath = "WRONG";

        Throwable exception = assertThrows(IOException.class,
                ()-> Main.getLargestWordAndWordCount(filePath));
    }
}
