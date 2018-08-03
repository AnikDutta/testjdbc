package com.rci.cat.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.rci.cat.model.OfferDto;
import com.rci.cat.service.RewardEvActionService;
import com.rci.cat.service.delegate.OfferServiceDelegate;

//import com.rci.eom.Campaign;
//import com.rci.eom.CustomerSet;
//import com.rci.eom.Event;
//import com.rci.eom.LandingPageURL;
//import com.rci.eom.MemberTierType;
//import com.rci.eom.Offer;
//import com.rci.eom.OfferMembershipTier;
//import com.rci.eom.Promotion;
//import com.rci.eom.RedemptionValue;
//import com.rci.eom.Reward;
//import com.rci.moor.cat.OfferConstants;
//import com.rci.moor.cat.dao.OfferDAO;
//import com.rci.moor.cat.delegates.AbstractDelegate;
//import com.rci.moor.cat.delegates.mock.MockOfferDelegate;
//import com.rci.moor.cat.dtos.OfferWebDTO;
//import com.rci.moor.cat.formbeans.AudienceList;
//import com.rci.moor.cat.formbeans.CampaignBean;
//import com.rci.moor.cat.formbeans.EventBean;
//import com.rci.moor.cat.formbeans.FixedPriceBean;
//import com.rci.moor.cat.formbeans.LandingPageUrlBean;
//import com.rci.moor.cat.formbeans.OfferFormBean;
//import com.rci.moor.cat.formbeans.PromotionBean;
//import com.rci.moor.cat.formbeans.RewardBean;
//import com.rci.moor.cat.formbeans.RewardInventoryRMBean;
//import com.rci.moor.cat.formbeans.RewardLinkedBean;
//import com.rci.moor.cat.formbeans.RewardPopulationBean;
//import com.rci.moor.cat.framework.DelegateName;
//import com.rci.moor.cat.framework.DelegatesManager;
//import com.rci.moor.cat.services.OfferSOARequestContract;
//import com.rci.moor.cat.util.CATUtil;
//import com.rci.services.common.contract.ErrorInfo;
//import com.rci.services.orch.offer.offerorchservice.OfferOrchRequest;
///*import com.rci.services.offer.contract.UserGroup;*/
///*import com.rci.services.orchestration.offer.contract.OfferOrchRequest;
// import com.rci.services.orchestration.offer.contract.OfferOrchResponse;
// import com.rci.services.orchestration.offer.contract.RewardOrchRequest;
// import com.rci.services.orchestration.offer.contract.RewardOrchResponse;*/
///*import com.rci.services.orch.offer.contract.OfferOrchRequest;
// import com.rci.services.orch.offer.contract.OfferOrchResponse;*/
//import com.rci.services.orch.offer.offerorchservice.OfferOrchResponse;

@Service("rewardEvActionService")
public class RewardEvActionServiceImpl implements RewardEvActionService {
	
	private static Logger log = Logger.getLogger(RewardEvActionServiceImpl.class);

	public OfferDto updateOfferReward(OfferDto offerWebRequest) {
		return null;
	}

	public OfferDto saveOffer(OfferDto offerDto, String action) {
		OfferServiceDelegate offerDelegate = //DelegatesManager.getDelegate(DelegateName.OfferDelegate);
											null;
		try {
			log.debug("Entered RewardEVAction createEVReward ");
			
			offerDelegate = new OfferServiceDelegate();
			offerDto = offerDelegate.saveOffer(offerDto);
			log.debug("Exit RewardEVAction createEVReward ");
		} catch (Exception e) {
			log.error("ERROR in RewardEVAction createEVReward ", e);
		}
		return offerDto;
	}
	
	

//	public OfferWebDTO updateOffer(OfferWebDTO offerWebRequest) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered RewardEVAction updateReward ");
//			OfferOrchRequest offerOrchRequest = null;
//			if (offerWebRequest.getUserGroup().containsKey(OfferConstants.MKT_USER))
//				offerOrchRequest = OfferSOARequestContract.getOfferOrchRequestForUpdateEVMKTData(offerWebRequest);
//			else if (offerWebRequest.getUserGroup().containsKey(OfferConstants.RM_USER))
//				offerOrchRequest = OfferSOARequestContract.getOfferOrchRequestForUpdateEVRMData(offerWebRequest);
//			else if(offerWebRequest.getUserGroup().containsKey(OfferConstants.DBM_USER))
//				offerOrchRequest = OfferSOARequestContract.getOfferOrchRequestForUpdateEVDBMData(offerWebRequest);
//			OfferOrchResponse offerOrchResponse = offrDelegate.updateEVReward(offerOrchRequest);
//			populateOfferDetails(offerOrchResponse, offerWebRequest, OfferConstants.UPDATE_OFFER);
//			log.debug("Exit RewardEVAction updateReward ");
//		} catch (Exception e) {
//			log.error("ERROR in RewardEVAction updateReward ", e);
//		}
//		return offerWebRequest;
//	}
//
//	protected void populateRewardDetails(OfferOrchResponse offerOrchResponse, OfferWebDTO offerWebRequest, String action) {
//		log.debug("Entered RewardEVAction populateRewardDetails Method");
//		OfferFormBean offerFormBean = offerWebRequest.getOfferFormBean();
//		if (offerOrchResponse == null) {
//			log.error("Create Reward Response is null.");
//			offerWebRequest.setErrCode("Create Reward Response is null.");
//			offerWebRequest.setError(true);
//			if(action.equalsIgnoreCase(OfferConstants.CREATE_OFFER_EVENT_REWARD) && offerFormBean.getPromotionBeans().get(0).getRewardBean().getRewardSubType().equals(OfferConstants.FIXED_AND_RENEWAL_AMT_OFF))
//			{
//				offerFormBean.getPromotionBeans().get(0).getRewardBean().setRewardSubType(OfferConstants.FIXED_PRICE);
//			}
//			// }else if (offerOrchResponse.hasErrors()) {
//		} else if (null != offerOrchResponse && null != offerOrchResponse.getErrorInfos()) {
//			ErrorInfo errorInfo = (ErrorInfo) offerOrchResponse.getErrorInfos().getErrorInfo().get(0);
//			log.error("ERRORS SIZE= " + offerOrchResponse.getErrorInfos().getErrorInfo().size());
//			log.error("ERROR CODE = " + errorInfo.getCode());
//			log.error("ERROR DESCRIPTION = " + errorInfo.getDescription());
//			offerWebRequest.setError(true);
//			if(action.equalsIgnoreCase(OfferConstants.CREATE_OFFER_EVENT_REWARD) && offerFormBean.getPromotionBeans().get(0).getRewardBean().getRewardSubType().equals(OfferConstants.FIXED_AND_RENEWAL_AMT_OFF))
//			{
//			    offerFormBean.getPromotionBeans().get(0).getRewardBean().setRewardSubType(OfferConstants.FIXED_PRICE);
//			}
//			offerWebRequest.setErrCode(errorInfo.getCode() + " : " + CATUtil.processErrorCodes(offerOrchResponse.getErrorInfos().getErrorInfo()));			
//			
//		} else {
//			Offer offerFromResp = null;
//			if (offerOrchResponse.getOffers() != null && offerOrchResponse.getOffers().size() > 0) {
//				offerWebRequest.setError(false);
//				offerWebRequest.setErrCode("SUCCESSFUL");
//				offerFromResp = offerOrchResponse.getOffers().get(0);
//
//				offerFormBean.setOfferCode(offerFromResp.getOfferCode());
//				offerFormBean.setOfferUUID(offerFromResp.getOfferUUID());
//				offerFormBean.setOfferCode(offerFromResp.getOfferCode());
//				offerFormBean.setOfferStatus(offerFromResp.getStatus().toString());
//
//				if (offerFromResp.getOfferName() != null)
//					offerFormBean.setOfferName(offerFromResp.getOfferName());
//			
//				if(offerFromResp.getTierPreviewInd()!= null){
//					offerFormBean.setPlatinumPreview(offerFromResp.getTierPreviewInd());
//				} else {
//					offerFormBean.setPlatinumPreview(false);
//				}
//				List<OfferMembershipTier> offerMemTierList = offerFromResp.getOfferMembershipTierList();
//				String tierType = "";
//				Long standardDelay = 0L;
//				List<String> tierTypeList = new ArrayList<String>();
//				List<String> tierCodeList = new ArrayList<String>();
//				List<String> tierNameList = new ArrayList<String>();
//				List<String> tierConfigTypes = new ArrayList<String>();
//				List<String> earlyAccessList = new ArrayList<String>();
//				Long maxStandardDelay = 0L;
//				
//				try {
//					tierConfigTypes = (new OfferDAO()).getTierConfigTypes();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//				if(offerMemTierList != null){
//					if(offerMemTierList.size() == tierConfigTypes.size()){
//						tierTypeList.add("All");
//					}
//					for(OfferMembershipTier membrTier : offerMemTierList){
//						standardDelay = membrTier.getDelayPeriod();
//						if(standardDelay == 0){
//						//	maxStandardDelay = standardDelay;
//							if("A".equals(membrTier.getTierCode())){
//								if(!earlyAccessList.contains("Standard")){
//									earlyAccessList.add("Standard");
//								}
//							}else if("W".equals(membrTier.getTierCode()) || "P".equals(membrTier.getTierCode())){
//								if(!earlyAccessList.contains("Platinum")){
//									earlyAccessList.add("Platinum");
//								}
//							}else if(membrTier.getTierCode().equalsIgnoreCase("All")){
//								earlyAccessList.add("All");
//							
//							} else{ 
//								earlyAccessList.add(membrTier.getTierCode());
//							}
//						}else{
//							maxStandardDelay = standardDelay;
//						}
//						tierCodeList.add(membrTier.getTierCode().toUpperCase());
//						tierNameList.add(membrTier.getTierName());
//						
//						if("ALL".equalsIgnoreCase(membrTier.getTierCode())){
//							tierTypeList.add("All");
//						}else if("A".equals(membrTier.getTierCode())){
//							if(!tierTypeList.contains("Standard")){
//								tierTypeList.add("Standard");
//							}
//						}else if("W".equals(membrTier.getTierCode()) || "P".equals(membrTier.getTierCode())){
//							if(!tierTypeList.contains("Platinum")){
//								tierTypeList.add("Platinum");
//							}
//						}else{
//							tierTypeList.add(membrTier.getTierCode());
//						}
//					}
//				/*	if(tierNameList.contains(OfferConstants.ALL_MEM_TIER) || (tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && tierNameList.contains(OfferConstants.WEEKS_STANDARD) && tierNameList.contains(OfferConstants.POINTS_PLATINUM) && tierNameList.contains(OfferConstants.POINTS_STANDARD))||
//							(tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && tierNameList.contains(OfferConstants.WEEKS_STANDARD) ) || (tierNameList.contains(OfferConstants.POINTS_PLATINUM) && tierNameList.contains(OfferConstants.POINTS_STANDARD))){
//						//ALL
//						tierType = OfferConstants.ALL;
//					} else if(!tierNameList.contains(OfferConstants.WEEKS_STANDARD) && !tierNameList.contains(OfferConstants.POINTS_STANDARD) && ((tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && tierNameList.contains(OfferConstants.POINTS_PLATINUM)) || tierNameList.contains(OfferConstants.WEEKS_PLATINUM) || tierNameList.contains(OfferConstants.POINTS_PLATINUM) ) ){
//						//Platinum
//						tierType = OfferConstants.PLATINUM;
//					} else if(!tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && !tierNameList.contains(OfferConstants.POINTS_PLATINUM) &&((tierNameList.contains(OfferConstants.WEEKS_STANDARD) && tierNameList.contains(OfferConstants.POINTS_STANDARD)) || tierNameList.contains(OfferConstants.WEEKS_STANDARD) || tierNameList.contains(OfferConstants.POINTS_STANDARD) ) ){
//						//Standard
//						tierType = OfferConstants.STANDARD;
//					} */
//					
//					/*if(	( tierCodeList.contains(String.valueOf(MemberTierType.WEEKS_STANDARD.getCharValue())) && tierCodeList.contains(String.valueOf(MemberTierType.WEEKS_PLATINUM.getCharValue())) ) 
//							|| (tierCodeList.contains(String.valueOf(MemberTierType.POINTS_PLATINUM.getCharValue())) && tierCodeList.contains(String.valueOf(MemberTierType.POINTS_STANDARD.getCharValue())) )
//							|| (tierCodeList.contains(OfferConstants.ALL)) ){
//						tierType = OfferConstants.ALL;
//					} else if (tierCodeList.contains(String.valueOf(MemberTierType.POINTS_STANDARD.getCharValue())) || tierCodeList.contains(tierCodeList.contains(String.valueOf(MemberTierType.WEEKS_STANDARD.getCharValue())))){
//						tierType = OfferConstants.STANDARD;
//					} else if (tierCodeList.contains(String.valueOf(MemberTierType.POINTS_PLATINUM.getCharValue())) || tierCodeList.contains(tierCodeList.contains(String.valueOf(MemberTierType.WEEKS_PLATINUM.getCharValue())))){
//						tierType = OfferConstants.PLATINUM;
//					}*/
//				/*for(OfferMembershipTier offerMemTier : offerMemTierList){
//					if(offerMemTierList != null && offerMemTierList.size() == 4){
//						tierType = "ALL";
//						standardDelay = offerMemTier.getDelayPeriod();
//					} else {
//						if(offerMemTier.getTierName().contains("Platinum")){
//							tierType = "Platinum";
//							standardDelay = offerMemTier.getDelayPeriod();
//						}else {
//							tierType = "Standard";
//							standardDelay = offerMemTier.getDelayPeriod();
//						}
//					}
//				}*/
//				}
//				
//				
//				earlyAccessList.remove("All");
//				if(maxStandardDelay > 0){
//					offerFormBean.setStandardDelay(maxStandardDelay+"");
//					offerFormBean.setPlatinumPreviewList(earlyAccessList);
//				}else{
//					offerFormBean.setStandardDelay(standardDelay+"");
//				}
//				
//			//	offerFormBean.setTierType(tierType);
//				offerFormBean.setTierTypeList(tierTypeList);
//				PromotionBean promotionBean = offerFormBean.getPromotionBeans().get(0);
//				// if(offerFromResp.getPromotionList()!=null &&
//				// offerFromResp.getPromotionList().size()>0)
//				// {
//				// Promotion
//				// promotionFromResp=offerFromResp.getPromotionList().get(0);
//				if (offerFromResp.getPromotionList() != null && offerFromResp.getPromotionList().size() > 0) {
//					Promotion promotionFromResp = offerFromResp.getPromotionList().get(0);
//					
//					if(promotionFromResp.getAudFileInclInd() != null && promotionFromResp.getAudFileInclInd().equalsIgnoreCase("N")){							
//						offerFormBean.setNoAudienceFile(true);
//					} else if(promotionFromResp.getAudFileInclInd() != null && promotionFromResp.getAudFileInclInd().equalsIgnoreCase("E")) {
//						offerFormBean.setExclusionAudienceFile(true);
//					}else{
//						offerFormBean.setInclusionAudienceFile(true);
//					}
//					// Add Dummy DBM Data
//					// createDBMOfferData(promotionFromResp);
//					promotionBean.setPromotionId(promotionFromResp.getPromotionID());
//					promotionBean.setPromotionStatus(promotionFromResp.getPromotionStatus().toString());
//					EventBean eventBean = promotionBean.getEventBean();
//					Event eventFromResp = null;
//					if (promotionFromResp.getEvent() != null) {
//						eventFromResp = promotionFromResp.getEvent();
//						eventBean.setEventId(eventFromResp.getEventID());
//						// eventBean.setEventType(String.valueOf(eventFromResp.getEventTypeID()));
//						eventBean.setEventName(eventFromResp.getEventName());
//						eventBean.setEventType(eventFromResp.getEventName());
//						eventBean.setEventDescription(eventFromResp.getEventName());
//					}
//					RewardBean rewardBean = promotionBean.getRewardBean();
//					List<RewardBean> rewardBeanList = new ArrayList<RewardBean>();
//					// if(promotionFromResp.getRewardList()!=null)
//					if (promotionFromResp.getRewardList() != null) {
//						List<Reward> rewardList = promotionFromResp.getRewardList();
//						for (int i = 0; i < rewardList.size(); i++) {
//							RewardBean rewardBean1 = new RewardBean();
//							Reward reward = rewardList.get(i);
//							rewardBean1.setRewardId(reward.getRewardID());
//							rewardBean.setRewardId(reward.getRewardID());
//							if (reward.getXmlId() != null && reward.getXmlId() > 0) {
//								offerFormBean.setOfferXMLID("" + reward.getXmlId());
//							}
//
//							List<LandingPageURL> landingPageURLList = reward.getRewardLandingPageURLList();
//							if (landingPageURLList != null && landingPageURLList.size() > 0) {
//								List<LandingPageUrlBean> landingPageUrlBeanList = new ArrayList<LandingPageUrlBean>();
//								LandingPageUrlBean landingPageUrlBean = null;
//								for (LandingPageURL landingPageURL : landingPageURLList) {
//									landingPageUrlBean = new LandingPageUrlBean();
//									landingPageUrlBean.setOfferLandingPageKey(landingPageURL.getRewardLandingPageKey());
//									landingPageUrlBean.setOfferLandingPageDimensionNames(landingPageURL.getRewardLandingPageDimensionNames());
//									landingPageUrlBean.setOfferLandingPageXMLIDS(landingPageURL.getRewardLandingPageXMLIDS());
//									landingPageUrlBeanList.add(landingPageUrlBean);
//								}
//								rewardBean1.setLandingPageUrlBeanList(landingPageUrlBeanList);
//							}
//
//							if (rewardBean.getRewardSubType().equalsIgnoreCase(OfferConstants.FIXED_PRICE) || rewardBean.getRewardSubType().equalsIgnoreCase(OfferConstants.FIXED_AND_RENEWAL_AMT_OFF)) {
//								if (reward.getRewardInventoryElements() != null && reward.getRewardInventoryElements().getFixedPrice() != null) {
//									RewardInventoryRMBean rewardInventoryRMBean = rewardBean.getRewardInventoryBean().getRewardInventoryRMBean();
//									// List<RedemptionValue>
//									// redemptionValueList=reward.getRewardInventoryElements().getFixedPrice().getRedemptionFPList();
//									List<RedemptionValue> redemptionValueList = reward.getRewardInventoryElements().getFixedPrice().getRedemptionFPList();
//									List<FixedPriceBean> fixedPriceBeanList = new ArrayList<FixedPriceBean>();
//									for (RedemptionValue redemptionValue : redemptionValueList) {
//										FixedPriceBean fixedPriceBean = new FixedPriceBean();
//										fixedPriceBean.setCurrencyCode(redemptionValue.getCurrencyCode());
//										fixedPriceBean.setRedemptionValue(redemptionValue.getRedemptionValue());
//										fixedPriceBean.setValFromSOA(true);
//										fixedPriceBeanList.add(fixedPriceBean);
//									}
//									rewardInventoryRMBean.setFixedPriceBeanList(fixedPriceBeanList);
//								}
//							}
//							else if (rewardBean.getRewardType().equalsIgnoreCase(OfferConstants.REWARD_RENTAL) && rewardBean.getRewardSubType().equalsIgnoreCase(OfferConstants.PERCENT_OFF)) {
//								
//							
//								//if (reward.getRewardInventoryElements()!=null && reward.getRewardInventoryElements().getRewardInventoryType().toString().equalsIgnoreCase(OfferConstants.REWARD_INV_PERCENT_OFF)) {
//									List<RewardPopulationBean> rewardPopulationBeanList = null;
//									rewardBean.setRewardSubType(OfferConstants.PERCENT_OFF);
//									try {
//									    rewardPopulationBeanList = CATUtil.getRewardPopulationBeanListForRental(offerOrchResponse);
//										offerWebRequest.setRewardPopulationBean(rewardPopulationBeanList);
//									} catch (Exception e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//								//	}
//								}
//							}
//							else if (rewardBean.getRewardType().equalsIgnoreCase(OfferConstants.REWARD_SPECIAL_OFFER)) {
//								
//								rewardBean.setRewardType(OfferConstants.REWARD_SPECIAL_OFFER);
//								RewardLinkedBean rewardLinkedBean = new RewardLinkedBean();
//								if (rewardList.get(i).getChannelType() != null)
//									rewardLinkedBean.setRedemptionChannel(rewardList.get(i).getChannelType());
//								rewardLinkedBean.setBypassLinkUrl(rewardList.get(i).getRewardLinkElements().getBypassLinkUrl());
//								//rewardLinkedBean.setOfficeList(rewardList.get(j).getRewardLinkElements().getOfficeCodes());
//							
//								if (rewardList.get(i).getRewardLinkElements().getOfficeCodes() != null && rewardList.get(i).getRewardLinkElements().getOfficeCodes().get(0) != null && rewardList.get(i).getRewardLinkElements().getOfficeCodes().size() > 0) {
//									if (rewardList.get(i).getRewardLinkElements().getOfficeCodes().size() == 1 && "ALL".equalsIgnoreCase(rewardList.get(i).getRewardLinkElements().getOfficeCodes().get(0))) {
//										rewardLinkedBean.setAllOffice(true);
//									} else {
//										List<String> evsList = new ArrayList<String>();
//										List<String> dblList = new ArrayList<String>();
//										Map<String, List<String>> officeMap = new LinkedHashMap<String, List<String>>();
//
//										for (String officeCode : rewardList.get(i).getRewardLinkElements().getOfficeCodes()) {
//											if (officeCode != null && officeCode.trim().length() > 0) {
//												String[] arrOfficeCode = officeCode.split(",");
//												if (arrOfficeCode != null) {
//													for (String tempOfficeCode : arrOfficeCode) {
//														if (tempOfficeCode != null) {
//															String officeType = tempOfficeCode.substring(0, officeCode.indexOf("-"));
//															if ("EVS1".equals(officeType)) {
//																evsList.add(tempOfficeCode.substring(officeCode.indexOf("-") + 1).trim());
//															}
//															if ("DBL".equals(officeType)) {
//																dblList.add(officeCode.substring(tempOfficeCode.indexOf("-") + 1).trim());
//															}
//														}
//													}
//												}
//											}
//										}
//										officeMap.put("EVS1", evsList);
//										officeMap.put("DBL", dblList);
//										rewardLinkedBean.setOfficeDetailsMap(officeMap);													
//
//									}
//								}
//								rewardLinkedBean.setMembershipTypeList(rewardList.get(i).getMemberTypeList());											
//								
//								if(rewardList.get(i).getRewardStartDate() != null){
//									rewardLinkedBean.setRewardStartDate(CATUtil.ConvertCalenderToString(rewardList.get(i).getRewardStartDate()));
//								}
//								if(rewardList.get(i).getRewardEndDate() != null){
//									rewardLinkedBean.setRewardEndDate(CATUtil.ConvertCalenderToString(rewardList.get(i).getRewardEndDate()));
//								}
//								rewardBean.setRewardLinkedBean(rewardLinkedBean);
//							}
//							rewardBeanList.add(rewardBean1);
//						}
//					}
//					promotionBean.setRewardBeanList(rewardBeanList);
//					populateDBMDetails(promotionFromResp, promotionBean);
//				}// End of Promotion List loop
//
//			}
//		}
//		log.debug("Exit RewardEVAction populateRewardDetails Method");
//	}
}
