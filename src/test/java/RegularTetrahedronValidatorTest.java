import com.epam.task.third.entity.Point;
import com.epam.task.third.validation.RegularTetrahedronValidator;
import com.epam.task.third.validation.Validator;
import org.junit.Assert;
import org.junit.Test;

public class RegularTetrahedronValidatorTest {



    @Test
    public void testValidateWhenRegularTetrahedronApplied() {
        //given
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0.5, 0.866025, 0);
        Point d = new Point(0.5, 0.288675, 0.816496);
        Validator validator = new RegularTetrahedronValidator(a, b, c, d);
        //when
        boolean isRegular = validator.validate();
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
        Validator validator = new RegularTetrahedronValidator(a, b, c, d);
        //when
        boolean isRegular = validator.validate();
        //then
        Assert.assertFalse(isRegular);
    }
}
