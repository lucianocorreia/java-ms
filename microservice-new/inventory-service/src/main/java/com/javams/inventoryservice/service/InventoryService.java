package com.javams.inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javams.inventoryservice.dto.InventoryResponse;
import com.javams.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository
                .findBySkuCodeIn(skuCode)
                .stream()
                .map(inventoty -> InventoryResponse
                        .builder()
                        .skuCode(inventoty.getSkuCode())
                        .isInStock(inventoty.getQuantity() > 0)
                        .build())
                .toList();
    }

}
