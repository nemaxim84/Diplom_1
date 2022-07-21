import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Ingredient ingredient;

    Burger burger;
    Ingredient ingredient1 = new Ingredient(SAUCE, "Соус1", 200.0f);
    Ingredient ingredient2 = new Ingredient(SAUCE, "Соус2", 100.0f);
    Ingredient ingredient3 = new Ingredient(FILLING, "Начинка", 100.0f);
    Bun bun = new Bun("Булка", 200.0f);

    @Before
    public void setUp() throws Exception {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.setBuns(bun);
    }

    @Test
    public void addIngredient() {
        Assert.assertEquals(burger.ingredients.get(0), ingredient1);
        Assert.assertEquals(burger.ingredients.get(1), ingredient2);
        Assert.assertEquals(burger.ingredients.get(2), ingredient3);
    }

    @Test
    public void setBuns() {
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void moveIngredient() {
        burger.moveIngredient(0, 2);
        Assert.assertEquals(burger.ingredients.get(0), ingredient2);
        Assert.assertEquals(burger.ingredients.get(2), ingredient1);
    }

    @Test
    public void getReceipt() {
    }
}