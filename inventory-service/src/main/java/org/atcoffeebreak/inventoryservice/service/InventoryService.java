package org.atcoffeebreak.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.atcoffeebreak.inventoryservice.dto.InventoryResponse;
import org.atcoffeebreak.inventoryservice.halpers.InventoryMapper;
import org.atcoffeebreak.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(InventoryMapper::mapToInventoryResponse)
                .toList();
    }
}
