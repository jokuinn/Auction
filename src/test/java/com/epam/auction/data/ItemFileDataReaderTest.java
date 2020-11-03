package com.epam.auction.data;

import com.epam.auction.auction.data.DataException;
import com.epam.auction.auction.data.ItemFileDataReader;
import com.epam.auction.auction.model.Item;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ItemFileDataReaderTest {
    public static final String TEST_JSON_ITEMS = "src/test/resources/items.json";
    public static final int FIRST_ITEM_ID = 1;
    public static final int SECOND_ITEM_ID = 2;
    public static final String VASE = "Vase";
    public static final String CANDLE = "Candle";
    public static final BigDecimal FIRST_PRICE = new BigDecimal(450);
    public static final BigDecimal SECOND_PRICE = new BigDecimal(455);

    @Test
    public void testReadDataShouldReturnListOfItems() throws DataException {
        Item vase = new Item(FIRST_ITEM_ID, VASE, FIRST_PRICE);
        Item candle = new Item(SECOND_ITEM_ID, CANDLE, SECOND_PRICE);
        List<Item> expectedItems = Arrays.asList(vase, candle);
        ItemFileDataReader itemDataReader = new ItemFileDataReader();
        List<Item> items = itemDataReader.read(TEST_JSON_ITEMS);
        Assert.assertEquals(items, expectedItems);
    }
}
