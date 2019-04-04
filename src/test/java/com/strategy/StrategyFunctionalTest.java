package com.strategy;

import com.Shortener;
import org.junit.Assert;
import org.junit.Test;

public class StrategyFunctionalTest {

    private void testStorage(Shortener shortener) {
        String string1 = "one";
        String string2 = "two";
        String string3 = "one";
        Long id1 = shortener.getId(string1);
        Long id2 = shortener.getId(string2);
        Long id3 = shortener.getId(string3);

        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id2, id3);

        Assert.assertEquals(id1, id3);

        String value1 = shortener.getString(id1);
        String value2 = shortener.getString(id2);

        Assert.assertEquals(value1, string1);
        Assert.assertEquals(value2, string2);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }
}