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

public class BurgerPriceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;
    Burger burger;

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
        Assert.assertEquals(1000f, burger.getPrice(), 10 ^ -6);
    }
}
