package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import java.util.LinkedList;
import java.util.List;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final List<Item> linkedList = new LinkedList<>();

    @Override
    public Item getById(long id) {
        return holder.stream().filter(item -> item.getId() == (id + initialSequence)).findAny().orElse(null);
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(item.getId() + initialSequence);
        return holder.add(item);
    }

    public void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    public void setHolder() {
        this.holder = linkedList;
    }
}
