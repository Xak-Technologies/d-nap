package com.xakt.dnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.ShopRoom;

@Repository
public interface ShopRoomRepository extends JpaRepository<ShopRoom, Long> {

}
