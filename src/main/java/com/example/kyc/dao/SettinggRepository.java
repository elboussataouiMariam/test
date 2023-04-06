package com.example.kyc.dao;

import com.example.kyc.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettinggRepository  extends JpaRepository<Setting,Long> {
}
