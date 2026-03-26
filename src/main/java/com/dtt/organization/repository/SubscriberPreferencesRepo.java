package com.dtt.organization.repository;

import com.dtt.organization.model.SubscriberPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberPreferencesRepo extends JpaRepository<SubscriberPreferences,Integer> {

    @Query("SELECT s FROM SubscriberPreferences s WHERE s.suid = ?1")
   SubscriberPreferences getBySubUid(String uid);
}
