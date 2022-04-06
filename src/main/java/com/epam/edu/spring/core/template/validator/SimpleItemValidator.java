package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Item;

public class SimpleItemValidator implements ItemValidator {

    @Override
    public boolean isItemValid(Item item) {
        return (item.getId() > 0) && (item.getName() != null) && (item.getName().length() > 0) && (item.getPrice() > 0);
    }
}
