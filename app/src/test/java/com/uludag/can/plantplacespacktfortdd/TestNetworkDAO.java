package com.uludag.can.plantplacespacktfortdd;

import com.uludag.can.plantplacespacktfortdd.dao.NetworkDAO;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class TestNetworkDAO {

    private NetworkDAO mNetworkDAO;

    @Before
    public void setUp() throws Exception {
        mNetworkDAO = new NetworkDAO();
    }

    @Test
    public void fetchShouldSucceedWhenGivenValidURI() throws IOException {

        String url = "http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=akfjdf;aasdad";
        String result = mNetworkDAO.fetch(url);
        System.out.println(result);

        assertEquals("{\"plants\":[]}-1", result);

    }
}
