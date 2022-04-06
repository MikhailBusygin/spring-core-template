package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.epam.edu.sprig.core.template")
@Import({InitializerConfiguration.class, RepositoryConfiguration.class})
public class MainConfiguration {

    @Autowired
    ItemRepository itemRepository;

    @Bean
    public SimpleItemService simpleItemService() {
        SimpleItemService simpleItemService = new SimpleItemService(itemValidator());
        simpleItemService.setItemRepository(itemRepository);
        return simpleItemService;
    }

    @Bean
    public ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }
}
