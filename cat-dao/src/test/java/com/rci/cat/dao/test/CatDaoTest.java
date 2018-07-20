package com.rci.cat.dao.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rci.cat.dao.CatDao;
import com.rci.cat.dao.entity.CatEntity;
import com.rci.cat.dao.mapper.CatMapper;
import com.rci.cat.dao.test.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestConfiguration.class })
public class CatDaoTest {

    @Autowired
    private CatDao CatDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String CatId = "1";

    private final static String DEFAULT_IATA = "defaultIata";
    private final static String UPDATED_IATA = "updatedIata";
    private final static String DEFAULT_ICAO = "defaultIcao";
    private final static String UPDATED_ICAO = "updatedIcao";
    private final static String DEFAULT_DESCRIPTION = "defaultDescription";
    private final static String UPDATED_DESCRIPTION = "updatedDescription";
    private final static String DEFAULT_TYPE = "defaultType";
    private final static String UPDATED_TYPE = "updatedType";
    private final static String DEFAULT_CATEGORY = "defaultCategory";
    private final static String UPDATED_CATEGORY = "updatedCategory";

    @Test
    public void testPostCat() {
	CatEntity CatEntity = defaultCatEntity();
	Object result = 101L;
	Mockito.when(jdbcTemplate.update(Mockito.any(PreparedStatementCreator.class), Mockito.any(KeyHolder.class))).thenAnswer(new Answer<Object>() {
	    public Object answer(InvocationOnMock invocation) {
		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put("generatedId", result);
		invocation.getArgumentAt(1, KeyHolder.class).getKeyList().add(keyMap);
		return result;
	    }
	}).thenReturn(1);
	Assert.assertEquals(result, CatDao.postCat(CatEntity, defaultHeaders()));
    }

    @Test
    public void testGetCat() {
	List<CatEntity> result = new ArrayList<CatEntity>();
	CatEntity CatEntity = defaultCatEntity();
	result.add(CatEntity);
	Mockito.doReturn(result).when(jdbcTemplate).query(Mockito.anyString(), Mockito.any(Object[].class), Mockito.any(CatMapper.class));
	Assert.assertEquals(result.get(0), CatDao.getCat(CatId, defaultHeaders()));
    }

    @Test
    public void testGetCats() {
	List<CatEntity> result = new ArrayList<CatEntity>();
	CatEntity CatEntity = defaultCatEntity();
	result.add(CatEntity);
	Mockito.doReturn(result).when(jdbcTemplate).query(Mockito.anyString(), Mockito.any(Object[].class), Mockito.any(CatMapper.class));
	Assert.assertEquals(result.size(), CatDao.getCats(defaultHeaders()).size());
    }

    @Test
    public void testPutCat() {
	CatEntity CatEntity = updatedCatEntity();
	Mockito.doReturn(1).when(jdbcTemplate).update(Mockito.any(PreparedStatementCreator.class));
	Assert.assertEquals(1, CatDao.putCat(CatEntity, defaultHeaders()));
    }

    @Test
    public void testDeleteCat() {
	Mockito.doReturn(1).when(jdbcTemplate).update(Mockito.anyString(), Mockito.same(CatId));
	Assert.assertEquals(1, CatDao.deleteCat(CatId, defaultHeaders()));
    }

    private CatEntity defaultCatEntity() {
	CatEntity CatEntity = new CatEntity();
	CatEntity.setIata(DEFAULT_IATA);
	CatEntity.setIcao(DEFAULT_ICAO);
	CatEntity.setDescription(DEFAULT_DESCRIPTION);
	CatEntity.setType(DEFAULT_TYPE);
	CatEntity.setCategory(DEFAULT_CATEGORY);
	return CatEntity;
    }

    private CatEntity updatedCatEntity() {
	CatEntity CatEntity = new CatEntity();
	CatEntity.setIata(UPDATED_IATA);
	CatEntity.setIcao(UPDATED_ICAO);
	CatEntity.setDescription(UPDATED_DESCRIPTION);
	CatEntity.setType(UPDATED_TYPE);
	CatEntity.setCategory(UPDATED_CATEGORY);
	return CatEntity;
    }

    private Map<String, Object> defaultHeaders() {
	Map<String, Object> headers = new HashMap<>();
	return headers;
    }

}