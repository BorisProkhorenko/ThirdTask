import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecificationWhenAreaEqualOrLessThan;
import org.junit.Assert;

public class TetrahedronSpecificationWhenAreaEqualOrLessThanTest extends TetrahedronSpecificationTest {

    private TetrahedronSpecificationWhenAreaEqualOrLessThan specification;

    //actual area of tetrahedron which has been used in this test = 1.7320

    @Override
    public void testSpecifiedWhenTrue() {
        //given
        specification = new TetrahedronSpecificationWhenAreaEqualOrLessThan(1.8);
        Tetrahedron tetrahedron = getRegularTetrahedron();
        //when
        boolean actual = specification.specified(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Override
    public void testSpecifiedWhenFalse() {
        //given
        specification = new TetrahedronSpecificationWhenAreaEqualOrLessThan(1);
        Tetrahedron tetrahedron = getRegularTetrahedron();
        //when
        boolean actual = specification.specified(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }
}
