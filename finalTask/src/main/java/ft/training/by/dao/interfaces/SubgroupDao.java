package ft.training.by.dao.interfaces;

import ft.training.by.bean.Subgroup;
import ft.training.by.dao.exception.DAOException;

import java.util.Optional;

public interface SubgroupDao extends Dao<Integer, Subgroup> {
    Optional<Subgroup> findBySubgroupNumberAndGroupId(char subgroupNum, Integer id)
            throws DAOException;
}
