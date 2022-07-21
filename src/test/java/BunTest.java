import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;
    String name = "Кунжут";
    float price = 205;

    @Before
    public void setUp() throws Exception {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(price, bun.getPrice(), 10 ^ -6);
    }
}