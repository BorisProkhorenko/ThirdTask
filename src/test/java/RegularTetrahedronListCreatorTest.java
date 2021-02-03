import com.epam.task.third.RegularTetrahedronListCreator;
import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.parsing.TetrahedronParser;
import com.epam.task.third.validation.InputLineValidator;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import com.epam.task.third.validation.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class RegularTetrahedronListCreatorTest {

    private static final List<String> TEST_DATA_LIST = Arrays.asList("0.0 0.0 0.0, 1.0 0.0 0.0, 0.5 0.866025 0.0," +
            "0.5 0.288675 0.816496", "2.24 4.5 -1.0, 5.5 4.1 3, 7 -8 54, 7 7 7");
    private final static String TEST_FILE_PATH = "./src/test/resources/input.txt";

    @Test
    public void testCreateList() throws DataException {
        //given
        DataReader mockReader = Mockito.mock(DataReader.class);
        when(mockReader.readData(anyString())).thenReturn(TEST_DATA_LIST);

        Validator<String> mockLineValidator = Mockito.mock(InputLineValidator.class);
        when(mockLineValidator.validate(anyString())).thenReturn(true);

        Tetrahedron mockTetrahedron = Mockito.mock(Tetrahedron.class);

        TetrahedronParser mockTetrahedronParser = Mockito.mock(TetrahedronParser.class);
        when(mockTetrahedronParser.parse(anyString())).thenReturn(mockTetrahedron);

        Validator<Tetrahedron> mockRegularityValidator = Mockito.mock(RegularTetrahedronValidator.class);
        when(mockRegularityValidator.validate(mockTetrahedron)).thenReturn(true);

        RegularTetrahedronListCreator creator = new RegularTetrahedronListCreator(mockReader,
                mockLineValidator, mockRegularityValidator, mockTetrahedronParser);
        //when
        List<Tetrahedron> tetrahedronList = creator.createList(TEST_FILE_PATH);

        //then
        Assert.assertNotNull(tetrahedronList);

    }
}
