package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.stereotype.Service;

@Service
public class SimpleItemService implements ItemService {

    private ItemRepository itemRepository;
    private final ItemValidator itemValidator;

    public SimpleItemService(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return itemValidator.isItemValid(item) && itemRepository.createItem(item);
    }
}
