package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final List<Item> arrayList = new ArrayList<>();

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
        this.holder = arrayList;
    }
}
