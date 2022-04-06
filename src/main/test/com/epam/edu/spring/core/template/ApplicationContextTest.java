package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration (classes = {MainConfiguration.class})
public class ApplicationContextTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemValidator itemValidator;

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    @Autowired
    LinkedListItemRepository linkedListItemRepository;

    @Autowired
    InitializerConfiguration.ColorFactory colorFactory;

    @Test
    public void isApplicationContextLoaded() {
        Assert.assertTrue(context != null &&
                context.getBean("itemRepository").equals(itemRepository) &&
                context.getBean("simpleItemService").equals(itemService) &&
                context.getBean("itemValidator").equals(itemValidator) &&
                context.getBean("arrayListItemRepository").equals(arrayListItemRepository) &&
                context.getBean("linkedListItemRepository").equals(linkedListItemRepository) &&
                context.getBean(InitializerConfiguration.ColorFactory.class).equals(colorFactory));
    }
}
