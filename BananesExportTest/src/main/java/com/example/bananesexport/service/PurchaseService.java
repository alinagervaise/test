package com.example.bananesexport.service;

import com.example.bananesexport.dao.CostumerDao;
import com.example.bananesexport.dao.PurchaseDao;
import com.example.bananesexport.exception.DeliveryDateException;
import com.example.bananesexport.exception.PurchaseException;
import com.example.bananesexport.model.Costumer;
import com.example.bananesexport.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    public CostumerDao costumerDao;

    @Autowired
    public PurchaseDao purchaseDao;

    @Override
    public List<Costumer> getListCostumers() {
        return costumerDao.findAll();
    }

    @Override
    public List<Purchase> getListCostumerPurchases(int id) {
        return purchaseDao.findAllPurchases(id);
    }

    @Override
    public void registerCostumer(Costumer costumer) {
        costumerDao.save(costumer);
    }

    @Override
    public void registerPurchase(Purchase purchase) throws PurchaseException, DeliveryDateException {
        if (LocalTime.now().plus(Duration.ofDays(7)).isAfter(
                LocalDateTime.ofInstant(purchase.getDeliveryDate().toInstant(),
                        ZoneId.systemDefault()).toLocalTime())){
            throw new DeliveryDateException("Delivery expired. Delivery should be within 7 days");
        }
        if ((purchase.getQuantity() < 0 && purchase.getQuantity() > 10000) && (purchase.getQuantity() % 25 != 0)) {
            throw new PurchaseException("Expect quantity greater than 0 and less than 10000 and multiple of 25." +
                    " Got quantity equals "+ purchase.getQuantity());
        }
        purchase.setPrice(purchase.getQuantity() *  2.50);
        purchaseDao.save(purchase);

    }

    @Override
    public void updateCostumer(Costumer costumer) {
        costumerDao.save(costumer);
    }

    @Override
    public void deleteCostumer(int id) {
        costumerDao.deleteById(id);
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        purchaseDao.save(purchase);
    }

    @Override
    public void deletePurchase(int id) {
        purchaseDao.deleteById(id);
    }
}
