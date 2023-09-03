package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void values() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void valueOf() {
        Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}