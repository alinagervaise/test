package com.example.bananesexport.service;

import com.example.bananesexport.exception.DeliveryDateException;
import com.example.bananesexport.exception.PurchaseException;
import com.example.bananesexport.model.Costumer;
import com.example.bananesexport.model.Purchase;

import java.util.List;

public interface IPurchaseService {
    /**
    Consulter la liste des destinataires
     */
    public List<Costumer> getListCostumers();
    /**
    Consulter la liste des commandes d’un destinataire
     */
    public List<Purchase> getListCostumerPurchases(int id);
    /**
    Enregistrer/mettre à jour/supprimer un destinataire
     */
    public void registerCostumer(Costumer costumer);
    /**
      Enregistrer/mettre à jour/supprimer une commande
     */
    public void registerPurchase(Purchase purchase) throws PurchaseException, DeliveryDateException;

    void updateCostumer(Costumer costumer);

    void deleteCostumer(int id);

    void updatePurchase(Purchase purchase);

    void deletePurchase(int id);
}
