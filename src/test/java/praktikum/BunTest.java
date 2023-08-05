package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 950f);
        Assert.assertEquals("Проверка метода getName()", "Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("Краторная булка N-200i", 1059f);
        Assert.assertEquals("Проверка метода getPrice()", 1059f, bun.getPrice(), 0.001);
    }
}