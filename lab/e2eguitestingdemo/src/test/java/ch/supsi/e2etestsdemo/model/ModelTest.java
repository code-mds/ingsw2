package ch.supsi.e2etestsdemo.model;


import ch.supsi.guiframework.model.Observable;
import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

    @Test
    public void constructor0() {
        Model model = new Model();

        Assert.assertNotNull(model);
        Assert.assertTrue(model instanceof Observable);
    }

    @Test
    public void singleton0() {
        Model model = Model.instance();
        Assert.assertNotNull(model);
        Assert.assertTrue(model instanceof Model);
        Assert.assertTrue(model instanceof Observable);
        Assert.assertNotNull(Model.model);
        Assert.assertEquals(Model.model, model);
    }

    @Test
    public void singleton1() {
        Model model1 = Model.instance();
        Model model2 = Model.instance();

        Assert.assertEquals(model1, model2);
    }

}
