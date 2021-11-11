package com.example.bananesexport.controller;

import com.example.bananesexport.exception.DeliveryDateException;
import com.example.bananesexport.exception.PurchaseException;
import com.example.bananesexport.model.Costumer;
import com.example.bananesexport.model.Purchase;
import com.example.bananesexport.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    public PurchaseService purchaseService;


    /**
     Consulter la liste des destinataires
     */
    @RequestMapping(value = "/costumers", method = RequestMethod.GET)
    public List<Costumer> getListCostumers() {
        return purchaseService.getListCostumers();
    }

    /**
     Consulter la liste des commandes d’un destinataire
     */
    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    public List<Purchase> getListCostumerPurchases(@PathVariable int id) {
        return purchaseService.getListCostumerPurchases(id);
    }

    /**
     Enregistrer un destinataire
     */
    @RequestMapping(value = "/costumer/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void  registerCostumer(@RequestBody Costumer costumer) {
        purchaseService.registerCostumer(costumer);
    }
    /**
     mettre à jour un destinataire
     */
    @RequestMapping(value = "/costumer/update", method = RequestMethod.PUT)
    public void  updateCostumer(@RequestBody Costumer costumer) {
        purchaseService.updateCostumer(costumer);
    }
    /**
     supprimer un destinataire
     */
    @RequestMapping(value = "/costumer/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void  deleteCostumer(@PathVariable int id) {
        purchaseService.deleteCostumer(id);
    }
    /**
     Enregistrer une commande
     */
    @RequestMapping(value = "/purchase/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void registerPurchase(Purchase purchase) throws PurchaseException, DeliveryDateException {
        purchaseService.registerPurchase(purchase);
    }
    /**
     mettre à jourune commande
     */
    @RequestMapping(value = "/purchase/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updatePurchase(Purchase purchase) throws PurchaseException, DeliveryDateException {
        purchaseService.updatePurchase(purchase);
    }
    /**
     supprimer une commande
     */
    @RequestMapping(value = "/purchase.delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deletePurchase(@PathVariable int id) throws PurchaseException, DeliveryDateException {
        purchaseService.deletePurchase(id);
    }

}
