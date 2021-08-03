package com.api.apiback.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiback.model.Item;

public interface interItemRepository extends JpaRepository<Item, Long>{

}
