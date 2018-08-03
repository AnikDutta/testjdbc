package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.rci.cat.dao.CatDaoConstants;
import com.rci.cat.dao.entity.CurrencyOffice;

public class CurrencyOfficeMapper implements ResultSetExtractor<Map<String,List<CurrencyOffice>>> {

	@Override
	public Map<String, List<CurrencyOffice>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, List<CurrencyOffice>> regionCurrOfficeMap = new HashMap<String, List<CurrencyOffice>>();
		
		while (rs.next()) {

			String prevRegion = rs.getString("REGION_ID");
			String prevCurrency = rs.getString("ISO_CURRENCY");
			String prevSource = rs.getString("SOURCE");
			String officeCode = rs.getString("OFFICE_CODE");

			List<String> offices = new ArrayList<String>();
			Map<String, List<String>> officeMap = new HashMap<String, List<String>>();
			List<CurrencyOffice> currOfficeMapping = new ArrayList<CurrencyOffice>();

			offices.add(officeCode);

			while (rs.next()) {

				String currRegion = rs.getString("REGION_ID");
				String currISOCurrency = rs.getString("ISO_CURRENCY");
				String currSource = rs.getString("SOURCE");
				officeCode = rs.getString("OFFICE_CODE");
				if (currRegion != null && !currRegion.equalsIgnoreCase(prevRegion)) {

					officeMap.put(prevSource, offices);
					CurrencyOffice currOffice = new CurrencyOffice();
					currOffice.setCurrencyCode(prevCurrency);
					currOffice.setOfficeCodes(officeMap);
					currOfficeMapping.add(currOffice);
					regionCurrOfficeMap.put(prevRegion, currOfficeMapping);
					prevRegion = currRegion;
					prevCurrency = currISOCurrency;
					prevSource = currSource;
					currOfficeMapping = new ArrayList<CurrencyOffice>();
					officeMap = new HashMap<String, List<String>>();
					offices = new ArrayList<String>();
					offices.add(officeCode);

				} else {
					if (currISOCurrency != null && currISOCurrency.equalsIgnoreCase(prevCurrency)) {
						if (currSource != null && currSource.equalsIgnoreCase(prevSource)) {
							// new office code for same region, currency and
							// source, add to the list
							offices.add(officeCode);
						} else {
							// Source changed, add it to the map
							officeMap.put(prevSource, offices);
							prevSource = currSource;
							offices = new ArrayList<String>();
							offices.add(officeCode);
						}
					} else {
						officeMap.put(prevSource, offices);
						CurrencyOffice currOffice = new CurrencyOffice();
						currOffice.setCurrencyCode(prevCurrency);
						currOffice.setOfficeCodes(officeMap);
						currOfficeMapping.add(currOffice);

						prevCurrency = currISOCurrency;
						prevSource = currSource;
						officeMap = new HashMap<String, List<String>>();
						offices = new ArrayList<String>();
						offices.add(officeCode);
					}
				}
			} 

			officeMap.put(prevSource, offices);
			CurrencyOffice currOffice = new CurrencyOffice();
			currOffice.setCurrencyCode(prevCurrency);
			currOffice.setOfficeCodes(officeMap);
			currOfficeMapping.add(currOffice);
			regionCurrOfficeMap.put(prevRegion, currOfficeMapping);

		}
		
		return regionCurrOfficeMap;
	}

}
