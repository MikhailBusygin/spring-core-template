package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class})
@TestPropertySource(properties = "item.repository.implementation=linked")
public class LinkedRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    LinkedListItemRepository linkedListItemRepository;

    private Item defaultItem;
    private final Item item = new Item(15, "first", 2.0, Color.RED);

    @Before
    public void createRepository() {
        defaultItem = new Item(24, "default", 4.0, Color.BLUE);
        itemRepository.createItem(defaultItem);
        defaultItem = itemRepository.getById(24);
    }

    @Test
    public void isArrayRepository() {
        Assert.assertEquals(itemRepository, linkedListItemRepository);
    }

    @Test
    public void defaultItemGetById() {
        Assert.assertEquals(itemRepository.getById(24), defaultItem);
    }

    @Test
    public void isItemCreated() {
        Assert.assertTrue(itemRepository.createItem(item));
    }
}
