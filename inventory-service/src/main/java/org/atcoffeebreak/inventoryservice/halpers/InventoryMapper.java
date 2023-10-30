package org.atcoffeebreak.inventoryservice.halpers;

import org.atcoffeebreak.inventoryservice.dto.InventoryResponse;
import org.atcoffeebreak.inventoryservice.model.Inventory;

public class InventoryMapper {

    public static InventoryResponse mapToInventoryResponse(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
