package com.personal.web.spring.web.spring.service;

import com.personal.web.spring.web.spring.dao.ItemDao;
import com.personal.web.spring.web.spring.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    ItemDao itemDao;

    @Autowired
    ItemService(@Qualifier("mySql") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public int addItem(Item item) {
        return this.itemDao.insertItem(item);
    }

    public Item viewItem(String id) {
        return itemDao.getItem(id);
    }

}
