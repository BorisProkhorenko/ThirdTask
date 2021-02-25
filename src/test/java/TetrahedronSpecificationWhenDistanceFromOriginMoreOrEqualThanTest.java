import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan;
import org.junit.Assert;

public class TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThanTest extends TetrahedronSpecificationTest {
    private TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan specification =
            new TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan(0.1);


    //actual minimal distance from tetrahedron to origin which has been used in this test = 0.0, max = 1.0


    @Override
    public void testSpecifiedWhenTrue()  {
        //given
        specification = new TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan(0.0);
        Tetrahedron tetrahedron = getRegularTetrahedron();
        //when
        boolean actual = specification.specified(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Override
    public void testSpecifiedWhenFalse() {
        //given
        specification = new TetrahedronSpecificationWhenDistanceFromOriginMoreOrEqualThan(1.1);
        Tetrahedron tetrahedron = getRegularTetrahedron();
        //when
        boolean actual = specification.specified(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }
}
