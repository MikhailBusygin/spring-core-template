package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@ContextConfiguration (classes = {MainConfiguration.class})
public class ApplicationLogicTest {

    @Autowired
    SimpleItemService simpleItemService;

    @Autowired
    InitializerConfiguration.ColorFactory colorFactory;

    private Item defaultItem;
    private final Item validItem = new Item(15, "first", 2.0, Color.RED);
    private final Item noValidItem = new Item(-15, "second", 3.0, Color.YELLOW);

    private Object[] itemFields;
    private Color color;

    @Before
    public void createRepository() {
        defaultItem = new Item(24, "default", 4.0, Color.BLUE);
        simpleItemService.createItem(defaultItem);
        defaultItem = simpleItemService.getById(24);
        itemFields = new Object[] {
                defaultItem.getId(),
                defaultItem.getName(),
                defaultItem.getPrice(),
                defaultItem.getColor()};
        color = colorFactory.getColor();
    }

    @Test
    public void validItemCreated() {
        Assert.assertTrue(simpleItemService.createItem(validItem));
    }

    @Test
    public void noValidItemCreated() {
        Assert.assertFalse(simpleItemService.createItem(noValidItem));
    }

    @Test
    public void defaultItemGetById() {
        Assert.assertEquals(simpleItemService.getById(24), defaultItem);
    }

    @Test
    public void checkItemFields() {
        Item item = simpleItemService.getById(24);
        Assert.assertArrayEquals(itemFields, new Object[] {
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.getColor()});
    }

    @Test
    public void createColorViaColorFactory() {
        Assert.assertTrue(color.getDeclaringClass().equals(Color.class) &&
                Arrays.stream(Color.values()).anyMatch(color -> color.equals(this.color)));
    }

    @Test
    public void setItemFields() {
        Item item = simpleItemService.getById(24);
        item.setName("third");
        item.setPrice(5.0);
        item.setColor(Color.WHITE);
        Item changeItem = simpleItemService.getById(24);
        Assert.assertTrue(
                changeItem.getName().equals("third") &&
                changeItem.getPrice() == 5.0 &&
                changeItem.getColor().equals(Color.WHITE));
    }
}
