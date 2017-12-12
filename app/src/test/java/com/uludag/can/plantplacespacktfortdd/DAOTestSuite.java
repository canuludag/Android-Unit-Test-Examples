package com.uludag.can.plantplacespacktfortdd;

import com.uludag.can.dao.BDDTestPlantDAO;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BDDTestPlantDAO.class,
        TestNetworkDAO.class
})
public class DAOTestSuite {
}
