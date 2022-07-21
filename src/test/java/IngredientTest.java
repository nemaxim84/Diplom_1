import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;

    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public float price;
    @Parameterized.Parameter(2)
    public IngredientType type;

    @Parameterized.Parameters
    public static Object[][] params() throws Exception {
        return new Object[][]{
                {"Соус", 200, SAUCE},
                {"Начинка", 300, FILLING},
        };
    }

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 10 ^ -6);
    }

    @Test
    public void getName() {
        Assert.assertEquals(ingredient.getName(), name);
    }

    @Test
    public void getType() {
        Assert.assertEquals(ingredient.getType(), type);
    }
}