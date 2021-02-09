import com.epam.task.third.validation.InputLineValidator;
import com.epam.task.third.validation.Validator;
import org.junit.Assert;
import org.junit.Test;

public class InputLineValidatorTest {

    private static final String CORRECT_LINE = "2.2 4.5 -1.0, 5.0 4.5 3.5, 7.5 -8.5 54.53, 7.5 7.0 7.1";
    private static final String INCORRECT_LINE = "2.2 4.5 -1.0, 5.0 4.5 3.5h, 7.5 -8.5 54.53, 7.5 7.0 7.1";


    @Test
    public void testValidateWhenCorrectLineApplied() {
        //given
        Validator validator = new InputLineValidator(CORRECT_LINE);
        //when
        boolean actual = validator.validate();
        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void testValidateWhenIncorrectLineApplied() {

        //given
        Validator validator = new InputLineValidator(INCORRECT_LINE);
        //when
        boolean actual = validator.validate();
        //then
        Assert.assertFalse(actual);

    }
}
