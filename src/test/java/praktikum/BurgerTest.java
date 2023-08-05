package praktikum;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    Bun bun;
    Burger burger = new Burger();
    praktikum.Ingredient ingredient;
    @Mock
    private Bun mockBun;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void setBuns() {
        bun = new Bun("Булочка с кунжутом", 550f);
        burger.setBuns(bun);
        MatcherAssert.assertThat("Тест для метода setBuns()", burger.getReceipt(), CoreMatchers.containsString("Булочка с кунжутом"));
    }

    @Test
    public void addIngredient() {
        ingredient = new Ingredient(FILLING, "Хрустящие минеральные кольца", 000f);
        burger.addIngredient(ingredient);
        assertEquals("Тест для метода addIngredient()", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        ingredient = new Ingredient(SAUCE, "HOT", 999f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Тест для метода removeIngredient()", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        praktikum.Ingredient ingredientIndexZero = new Ingredient(SAUCE, "PAPERS", 567f);
        praktikum.Ingredient ingredientIndexOne = new Ingredient(FILLING, "Кристальные минералы", 999f);
        burger.addIngredient(ingredientIndexZero);
        burger.addIngredient(ingredientIndexOne);
        burger.moveIngredient(0, 1);
        assertEquals("Тест для метода moveIngredient()", ingredientIndexZero, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(999f);
        burger.setBuns(mockBun);
        assertEquals("Тест для метода getPrice()", 1998f, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("MOCK_VALUE");
        burger.setBuns(mockBun);
        ingredient = new Ingredient(SAUCE, "PAPERS", 567f);
        burger.addIngredient(ingredient);
        MatcherAssert.assertThat("Тест для метода getReceipt()", burger.getReceipt(), CoreMatchers.containsString("MOCK_VALUE"));
    }
}