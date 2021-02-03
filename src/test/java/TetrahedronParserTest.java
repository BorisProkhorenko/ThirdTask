import com.epam.task.third.data.DataException;
import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.parsing.TetrahedronParser;
import org.junit.Assert;
import org.junit.Test;

public class TetrahedronParserTest {

    private static final String CORRECT_LINE = " 2.24 4.5 -1.0, 5.5 4.1 3, 7 -8 54, 7 7 7";
    private static final String INCORRECT_LINE = "2 4 -1, 5 4 3g, 7 -8 54, 7 7 7";
    private static final TetrahedronParser parser = new TetrahedronParser();

    @Test
    public void testParseWhenCorrectDataApplied() throws DataException {

        //given
        Point a = new Point(2.24, 4.5, -1.0);
        Point b = new Point(5.5, 4.1, 3);
        Point c = new Point(7, -8, 54);
        Point d = new Point(7, 7, 7);
        Tetrahedron expected = new Tetrahedron(a, b, c, d);

        //when
        Tetrahedron actual = parser.parse(CORRECT_LINE);

        //then
        Assert.assertEquals(actual, expected);

    }

    @Test(expected = DataException.class)
    public void testParseWhenIncorrectDataApplied() throws DataException {

        //when
        Tetrahedron actual = parser.parse(INCORRECT_LINE);

    }
}
