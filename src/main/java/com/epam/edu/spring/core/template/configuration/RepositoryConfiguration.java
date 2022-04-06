package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

    @Value("${item.repository.implementation}")
    private String itemRepositoryImplementation;

    @Value("${initial.sequence}")
    private String initialSequence;

    @Bean (name = "itemRepository")
    public ItemRepository itemRepository() {
        if (itemRepositoryImplementation.equals("linked")) {
            return linkedListItemRepository();
        }
        else{
            return arrayListItemRepository();
        }
    }

    @Bean (name = "arrayListItemRepository")
    public ArrayListItemRepository arrayListItemRepository() {
        ArrayListItemRepository arrayListItemRepository = new ArrayListItemRepository();
        arrayListItemRepository.setHolder();
        arrayListItemRepository.setInitialSequence(initialSequence != null ? Integer.parseInt(initialSequence) : 0);
        return arrayListItemRepository;
    }

    @Bean (name = "linkedListItemRepository")
    public LinkedListItemRepository linkedListItemRepository() {
        LinkedListItemRepository linkedListItemRepository = new LinkedListItemRepository();
        linkedListItemRepository.setInitialSequence(new Random().nextInt(100) + 1);
        linkedListItemRepository.setHolder();
        return linkedListItemRepository;
    }
}
