import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import com.epam.task.third.validation.Validator;
import org.junit.Assert;
import org.junit.Test;

public class RegularTetrahedronValidatorTest {

    private static final Validator<Tetrahedron> VALIDATOR = new RegularTetrahedronValidator();

    @Test
    public void testValidateWhenRegularTetrahedronApplied() {
        //given
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Tetrahedron regularTetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean isRegular = VALIDATOR.validate(regularTetrahedron);
        //then
        Assert.assertTrue(isRegular);
    }

    @Test
    public void testValidateWhenIrregularTetrahedronApplied() {
        //given
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 1, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Tetrahedron regularTetrahedron = new Tetrahedron(a, b, c, d);
        //when
        boolean isRegular = VALIDATOR.validate(regularTetrahedron);
        //then
        Assert.assertFalse(isRegular);
    }
}
