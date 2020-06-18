package com.personal.web.spring.web.spring.dao;

import com.personal.web.spring.web.spring.models.Item;

public interface ItemDao {

    int insertItem(Item item);

    Item getItem(String id);
}
