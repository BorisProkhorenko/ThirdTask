import com.epam.task.third.entity.Tetrahedron;
import com.epam.task.third.repo.specifications.TetrahedronSpecificationWhenVolumeMoreThan;
import com.epam.task.third.validation.TetrahedronIsNotRegularException;
import org.junit.Assert;

public class TetrahedronSpecificationWhenVolumeMoreThanTest extends TetrahedronSpecificationTest {

    private TetrahedronSpecificationWhenVolumeMoreThan specification;

    //actual volume of tetrahedron which has been used in this test = 0.1178

    @Override
    public void testSpecifiedWhenTrue() {
        //given
        specification = new TetrahedronSpecificationWhenVolumeMoreThan(0.1);
        Tetrahedron tetrahedron = getRegularTetrahedron();
        //when
        boolean actual = specification.specified(tetrahedron);
        //then
        Assert.assertTrue(actual);
    }

    @Override
    public void testSpecifiedWhenFalse() {
        //given
        specification = new TetrahedronSpecificationWhenVolumeMoreThan(0.12);
        Tetrahedron tetrahedron = getRegularTetrahedron();
        //when
        boolean actual = specification.specified(tetrahedron);
        //then
        Assert.assertFalse(actual);
    }
}
