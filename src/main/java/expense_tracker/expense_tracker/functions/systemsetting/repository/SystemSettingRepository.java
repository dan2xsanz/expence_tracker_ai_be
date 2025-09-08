package expense_tracker.expense_tracker.functions.systemsetting.repository;

import expense_tracker.expense_tracker.model.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemSettingRepository extends JpaRepository<SystemSetting, Long> {

    @Query(value = "SELECT * FROM SystemSetting where userGuid = :userGuid LIMIT 1", nativeQuery = true)
    Optional<SystemSetting> findSystemSettingByGuid(@Param("userGuid") String userGuid);

}
