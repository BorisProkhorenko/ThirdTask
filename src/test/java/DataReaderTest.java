import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final static String TEST_FILE_PATH = "./src/test/resources/input.txt";
    private final static String INVALID_FILE_PATH = "./src/test/resources/invalid.txt";
    private final static String[] TEST_DATA = {"2 4 -1, 5 4 3, 7 -8 54, 7 7 7","5345 fbf p.eg","pgokngjl;kjgn"};
    private DataReader reader = new DataReader();

    @Test
    public void testReadDataWithValidFile() throws DataException {
        //given
        List<String> expected = new ArrayList<>(Arrays.asList(TEST_DATA));


        //when
        List<String> actual = reader.readData(TEST_FILE_PATH);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)
    public void testReadDataWithInvalidPath() throws DataException {

        //when
        List<String> actual = reader.readData(INVALID_FILE_PATH);

    }

}
