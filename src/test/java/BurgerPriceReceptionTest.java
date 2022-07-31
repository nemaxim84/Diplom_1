import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

public class BurgerPriceReceptionTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;
    private Burger burger;

    @Before
    public void setUp() throws Exception {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
    }

    @Test
    public void getPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        Assert.assertEquals(1000f, burger.getPrice(), IngredientTest.delta);
    }

    @Test
    public void getReceipt() {
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус");
        Mockito.when(bun.getName()).thenReturn("Булка");
        Assert.assertTrue(burger.getReceipt().contains("Соус"));
        Assert.assertTrue(burger.getReceipt().contains("Булка"));
        Assert.assertTrue(burger.getReceipt().contains(SAUCE.toString().toLowerCase()));
    }
}
