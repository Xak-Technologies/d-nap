package com.xakt.dnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xakt.dnap.entity.HostelRoom;

@Repository
public interface HostelRoomRepository extends JpaRepository <HostelRoom, Long> {

}
