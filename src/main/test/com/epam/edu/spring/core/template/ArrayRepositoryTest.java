package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class})
@TestPropertySource(properties = "item.repository.implementation=array")
public class ArrayRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    @Test
    public void isArrayRepository() {
        Assert.assertEquals(itemRepository, arrayListItemRepository);
    }
}
