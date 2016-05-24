package com.musichub.dao;

import com.musichub.dao.*;
import com.musichub.model.CardDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CardDetailServiceImpl implements CardDetailService{

    @Autowired
    private CardDetailDao cardDetailDao;

    public void addCardDetail (CardDetail cardDetail) {
    	cardDetailDao.addCardDetail(cardDetail);
    }

 
}
