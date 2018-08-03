//package com.rci.cat.service.impl;
//
//import java.io.BufferedInputStream;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//import com.rci.eom.AutoRenewal;
//import com.rci.eom.BedRoom;
//import com.rci.eom.ChannelType;
//import com.rci.eom.LandingPageURL;
//import com.rci.eom.MOORStatus;
//import com.rci.eom.MemberTierType;
//import com.rci.eom.Offer;
//import com.rci.eom.OfferMembershipTier;
//import com.rci.eom.OfferTravelWindow;
//import com.rci.eom.Promotion;
//import com.rci.eom.RedemptionValue;
//import com.rci.eom.RenewXyearsGetYyears;
//import com.rci.eom.RenewalCurrency;
//import com.rci.eom.RenewalTermAmountOff;
//import com.rci.eom.RenewalTermPercentageOff;
//import com.rci.eom.Reward;
//import com.rci.eom.RewardExchangeFeeElements;
//import com.rci.eom.RewardInventoryElements;
//import com.rci.eom.RewardRenewalElements;
//import com.rci.eom.RewardType;
//import com.rci.eom.SearchType;
//import com.rci.eom.ServiceOffice;
//import com.rci.eom.TranslationContent;
//import com.rci.moor.cat.OfferConstants;
//import com.rci.moor.cat.dao.OfferDAO;
//import com.rci.moor.cat.delegates.AbstractDelegate;
//import com.rci.moor.cat.delegates.OfferDelegate;
//import com.rci.moor.cat.dtos.DashboardOfferWebDTO;
//import com.rci.moor.cat.dtos.OfferWebDTO;
//import com.rci.moor.cat.formbeans.ContextBean;
//import com.rci.moor.cat.formbeans.EventBean;
//import com.rci.moor.cat.formbeans.ExchangeChannelType;
//import com.rci.moor.cat.formbeans.ExchangeOfficeBean;
//import com.rci.moor.cat.formbeans.ExchangeOfficeDetailsBean;
//import com.rci.moor.cat.formbeans.FixedPriceBean;
//import com.rci.moor.cat.formbeans.IExchangeFeeDiscount;
//import com.rci.moor.cat.formbeans.LandingPageUrlBean;
//import com.rci.moor.cat.formbeans.MultipleFixedPriceBean;
//import com.rci.moor.cat.formbeans.OfferFormBean;
//import com.rci.moor.cat.formbeans.OfferTranslationBean;
//import com.rci.moor.cat.formbeans.PromotionBean;
//import com.rci.moor.cat.formbeans.RenewalAmountOffBean;
//import com.rci.moor.cat.formbeans.RenewalCurrencyBean;
//import com.rci.moor.cat.formbeans.RenewalFeeBean;
//import com.rci.moor.cat.formbeans.RenewalPercentOffBean;
//import com.rci.moor.cat.formbeans.RenewalSetBean;
//import com.rci.moor.cat.formbeans.RenewalTermBean;
//import com.rci.moor.cat.formbeans.RenewalXForYBean;
//import com.rci.moor.cat.formbeans.RewardBean;
//import com.rci.moor.cat.formbeans.RewardDetailsBean;
//import com.rci.moor.cat.formbeans.RewardInventoryBean;
//import com.rci.moor.cat.formbeans.RewardInventoryMKTBean;
//import com.rci.moor.cat.formbeans.RewardInventoryRMBean;
//import com.rci.moor.cat.formbeans.RewardLinkedBean;
//import com.rci.moor.cat.formbeans.RewardPopulationBean;
//import com.rci.moor.cat.formbeans.RewardRenewalBean;
//import com.rci.moor.cat.formbeans.SearchCriteriaBean;
//import com.rci.moor.cat.formbeans.TravelWindowBean;
//import com.rci.moor.cat.framework.DelegateName;
//import com.rci.moor.cat.framework.DelegatesManager;
//import com.rci.moor.cat.services.OfferSOARequestContract;
//import com.rci.moor.cat.util.CATUtil;
//import com.rci.services.common.contract.ErrorInfo;
//import com.rci.services.orch.offer.offerorchservice.OfferOrchRequest;
//import com.rci.services.orch.offer.offerorchservice.OfferOrchResponse;
//import com.rci.services.orch.offer.offerorchservice.RewardOrchRequest;
//import com.rci.services.search.contract.EndecaDimensionMetaData;
//
//@Service("catService")
//public class OfferActionService {
//
//	public OfferWebDTO run(OfferWebDTO offerWebDTO) throws Exception {
//		return null;
//	}
//
//	private static final OfferActionService instance = new OfferActionService();
//
//	protected OfferActionService() {
//	}
//
//	public static OfferActionService getInstance() {
//		return instance;
//	}
//
//	static Logger log = Logger.getLogger(OfferActionService.class);
//
//	public OfferWebDTO updateOffer(OfferWebDTO offerWebRequest) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered OfferAction updateOffer ");
//			OfferOrchRequest offerServiceRequest = OfferSOARequestContract.getOfferOrchRequestForUpdateOffer(offerWebRequest);
//			OfferOrchResponse offerServiceResponse = offrDelegate.updateOffer(offerServiceRequest);
//
//			populateOfferDetails(offerServiceResponse, offerWebRequest, OfferConstants.UPDATE_OFFER);
//			log.debug("Exit OfferAction updateOffer ");
//		} catch (Exception e) {
//			log.error("ERROR in OfferAction updateOffer ", e);
//		}
//		return offerWebRequest;
//	}
//
//	public OfferWebDTO saveOffer(OfferWebDTO offerWebRequest, String action) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered OfferAction saveOffer ");
//			OfferOrchRequest offerServiceRequest = OfferSOARequestContract.getOfferOrchRequestForCreateOffer(offerWebRequest);
//			OfferOrchResponse offerServiceResponse = offrDelegate.saveOffer(offerServiceRequest);
//			populateOfferDetails(offerServiceResponse, offerWebRequest, OfferConstants.SAVE);
//			log.debug("Exit OfferAction saveOffer ");
//		} catch (Exception e) {
//			log.error("ERROR in OfferAction saveOffer ", e);
//		}
//		return offerWebRequest;
//	}
//
//	public OfferWebDTO changeOfferStatus(OfferWebDTO offerWebRequest, String action) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered OfferAction changeOfferStatus");
//			OfferOrchRequest offerOrchRequest = OfferSOARequestContract.getOfferOrchRequestForStatusChange(offerWebRequest, action);
//			OfferOrchResponse offerServiceResponse = null;
//			if (action.equals(OfferConstants.PUSH))
//				offerServiceResponse = offrDelegate.pushOffer(offerOrchRequest);
//			else if (action.equals(OfferConstants.SUBMIT))
//				offerServiceResponse = offrDelegate.submitDBMOffer(offerOrchRequest);
//			else if (action.equals(OfferConstants.APPROVE))
//				offerServiceResponse = offrDelegate.approveOffer(offerOrchRequest);
//			else if (action.equals(OfferConstants.ACTIVATE))
//				offerServiceResponse = offrDelegate.activateOffer(offerOrchRequest);
//			else if (action.equals(OfferConstants.REJECT))
//				offerServiceResponse = offrDelegate.rejectDBMOffer(offerOrchRequest);
//			else if (action.equals(OfferConstants.INACTIVE))
//				offerServiceResponse = offrDelegate.inActivateOffer(offerOrchRequest);
//			else if (action.equals(OfferConstants.PULL_OFFER))
//				offerServiceResponse = offrDelegate.pullOffer(offerOrchRequest);
//
//			populateOfferDetails(offerServiceResponse, offerWebRequest, action);
//			log.debug("Exit OfferAction " + action);
//		} catch (Exception e) {
//			log.error("ERROR in OfferAction  " + action, e);
//		}
//		return offerWebRequest;
//	}
//
//	public OfferWebDTO viewOffer(OfferWebDTO offerWebRequest) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered OfferAction viewOffer");
//			OfferOrchRequest offerOrchRequest = OfferSOARequestContract.getOfferOrchRequestForView(offerWebRequest);
//			OfferOrchResponse offerServiceResponse = offrDelegate.searchOffer(offerOrchRequest);
//			populateOfferDetails(offerServiceResponse, offerWebRequest, OfferConstants.VIEW_OFFER);
//			log.debug("Exit OfferAction viewOffer ");
//		} catch (Exception e) {
//			log.error("ERROR in OfferAction viewOffer", e);
//		}
//		return offerWebRequest;
//	}
//
//	public OfferWebDTO copyOffer(OfferWebDTO offerWebRequest) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered OfferAction copyOffer");
//			OfferOrchRequest offerOrchRequest = OfferSOARequestContract.getOfferServiceRequestForCopy(offerWebRequest);
//			OfferOrchResponse offerServiceResponse = offrDelegate.copyOffer(offerOrchRequest);
//			if (offerWebRequest.getRewardType().toLowerCase().contains("exchange")) {
//				populateOfferDetails(offerServiceResponse, offerWebRequest, OfferConstants.VIEW_OFFER);
//			} else {
//				populateOfferDetails(offerServiceResponse, offerWebRequest, OfferConstants.COPY_OFFER);
//			}
//			log.debug("Exit OfferAction copyOffer ");
//		} catch (Exception e) {
//			log.error("ERROR in OfferAction copyOffer", e);
//		}
//		return offerWebRequest;
//	}
//
//	protected void populateOfferDetails(OfferOrchResponse offerServiceResponse, OfferWebDTO offerWebRequest, String action) {
//		log.debug("Entered OfferAction populateOfferDetails Method");
//		OfferFormBean offerFormBean = offerWebRequest.getOfferFormBean();
//		// WAR Change
//		// AutoRenewalList autoRenewalListObj = null;
//		List<AutoRenewal> arListObj = new ArrayList<AutoRenewal>();
//		AutoRenewal autoRenewalObj = null;
//		if (offerServiceResponse == null) {
//			log.error("OfferService Response is null.");
//			offerWebRequest.setErrCode("OfferService Response is null.");
//			offerWebRequest.setError(true);
//
//			// } else if (offerServiceResponse.hasErrors()) {
//		} else if (offerServiceResponse != null && offerServiceResponse.getErrorInfos() != null) {
//			// ErrorInfo errorInfo = (ErrorInfo)
//			// offerServiceResponse.getErrorInfos().get(0);
//			ErrorInfo errorInfo = (ErrorInfo) offerServiceResponse.getErrorInfos().getErrorInfo().get(0);
//			//Start WAR Project
//		
//			//End WAR Project
//			// log.error("ERRORS SIZE= " +
//			// offerServiceResponse.getErrorInfos().size());
//			log.error("ERRORS SIZE= " + offerServiceResponse.getErrorInfos().getErrorInfo().size());
//			log.error("ERROR CODE = " + errorInfo.getCode());
//			log.error("ERROR DESCRIPTION = " + errorInfo.getDescription());
//			offerWebRequest.setError(true);
//			offerWebRequest.setErrCode(errorInfo.getCode() + " : " + CATUtil.processErrorCodes(offerServiceResponse.getErrorInfos().getErrorInfo()));
//			if ("CAT_REWARD_013".equalsIgnoreCase(errorInfo.getCode())) {
//				processTermsRatesValidationError(offerServiceResponse, offerWebRequest);
//			}
//		} else {
//			if (offerServiceResponse.getOffers() != null && offerServiceResponse.getOffers().size() > 0) {
//               
//				offerWebRequest.setError(false);
//				offerWebRequest.setErrCode("SUCCESSFUL");
//				Offer offer = offerServiceResponse.getOffers().get(0);
//				arListObj=offerServiceResponse.getAutoRenewalList();
//				if(arListObj.size() == 0){
//					arListObj = offer.getAutoRenewalList();
//				}
//				offerFormBean.setOfferUUID(offer.getOfferUUID());
//				// no offerCode in SOA response for statusChange calls.
//				offerFormBean.setOfferCode("W" + offer.getOfferUUID());
////				offerWebRequest.setEnrolledForAutoRenewal(offer.isIsAutoRenewal());
//				if(offer.getOfferStartDate() != null){
//					offerFormBean.setOfferStartDate(CATUtil.calendarToString(offer.getOfferStartDate()));
//				}
//				if(offer.getOfferEndDate() != null){
//					offerFormBean.setOfferEndDate(CATUtil.calendarToString(offer.getOfferEndDate()));
//				}
//				if(offer.getGpOfferEndDate() != null){
//					offerFormBean.setOfferCCEndDate(CATUtil.calendarToString(offer.getGpOfferEndDate()));
//				}
//				if (offerWebRequest.isEnrolledForAutoRenewal()) {
//					offerWebRequest.setEnrolledForAutoRenewal(offerWebRequest.isEnrolledForAutoRenewal());
//				} else {
//					offerWebRequest.setEnrolledForAutoRenewal(offer.isAutoRenewal());
//				}
//				if(offer.getTierPreviewInd()!= null){
//					offerFormBean.setPlatinumPreview(offer.getTierPreviewInd());
//				} else {
//					offerFormBean.setPlatinumPreview(false);
//				}
//				
//				
//				List<OfferMembershipTier> offerMemTierList = offer.getOfferMembershipTierList();
//				String tierType = "";
//				List<String> tierTypeList = new ArrayList<String>();
//				Long standardDelay = 0L;
//				List<String> tierCodeList = new ArrayList<String>();
//				List<String> tierNameList = new ArrayList<String>();
//				List<String> tierConfigTypes = new ArrayList<String>();
//				List<String> earlyAccessList = new ArrayList<String>();
//				Long maxStandardDelay = 0L;
//				try {
//					tierConfigTypes = (new OfferDAO()).getTierConfigTypes();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				boolean tierConfigFlag = false;
//				
//				if(offerMemTierList != null){
//					
//					
//					if(offerMemTierList.size() == tierConfigTypes.size()){
//						tierTypeList.add("All");
//					}
//					for(OfferMembershipTier membrTier : offerMemTierList){
//						standardDelay = membrTier.getDelayPeriod();
//						if(standardDelay == null){
//							standardDelay = 0L;
//						}
//						if(standardDelay != null && standardDelay == 0){
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
//							} else{ 
//								earlyAccessList.add(membrTier.getTierCode());
//							}
//						}else{
//							maxStandardDelay = standardDelay;
//						}
//						
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
//					
//					
//					// This code is used only for renewal offer types
//					if(tierNameList.contains(OfferConstants.ALL_MEM_TIER) || (tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && tierNameList.contains(OfferConstants.WEEKS_STANDARD) && tierNameList.contains(OfferConstants.POINTS_PLATINUM) && tierNameList.contains(OfferConstants.POINTS_STANDARD))
//							|| (tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && tierNameList.contains(OfferConstants.WEEKS_STANDARD) ) || (tierNameList.contains(OfferConstants.POINTS_PLATINUM) && tierNameList.contains(OfferConstants.POINTS_STANDARD))
//							|| (tierCodeList.contains(OfferConstants.ALL)) ){
//						//ALL
//						tierType = OfferConstants.ALL;
//					} else if(!tierNameList.contains(OfferConstants.WEEKS_STANDARD) && !tierNameList.contains(OfferConstants.POINTS_STANDARD) && ((tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && tierNameList.contains(OfferConstants.POINTS_PLATINUM)) || tierNameList.contains(OfferConstants.WEEKS_PLATINUM) || tierNameList.contains(OfferConstants.POINTS_PLATINUM) ) ){
//						//Platinum
//						tierType = OfferConstants.PLATINUM;
//					} else if(!tierNameList.contains(OfferConstants.WEEKS_PLATINUM) && !tierNameList.contains(OfferConstants.POINTS_PLATINUM) &&((tierNameList.contains(OfferConstants.WEEKS_STANDARD) && tierNameList.contains(OfferConstants.POINTS_STANDARD)) || tierNameList.contains(OfferConstants.WEEKS_STANDARD) || tierNameList.contains(OfferConstants.POINTS_STANDARD) ) ){
//						//Standard
//						tierType = OfferConstants.STANDARD;
//					}
//					
//					
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
//			/*	for(OfferMembershipTier offerMemTier : offerMemTierList){
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
//					
//					
//				}
//				
//				earlyAccessList.remove("ALL");
//				if(maxStandardDelay > 0){
//					offerFormBean.setStandardDelay(maxStandardDelay+"");
//					offerFormBean.setPlatinumPreviewList(earlyAccessList);
//				}else{
//					offerFormBean.setStandardDelay(standardDelay+"");
//				}
//				offerFormBean.setTierType(tierType);
//				offerFormBean.setTierTypeList(tierTypeList);
//				// add for Auto Renewal Project
//
//				// if (offer.isAutoRenewal()) {
//				// if (offer.isIsAutoRenewal()) {
//				// //
//				// offerWebRequest.setEnrolledForAutoRenewal(offer.isAutoRenewal());
//				// offerWebRequest.setEnrolledForAutoRenewal(offer.isIsAutoRenewal());
//				// offerWebRequest.setRewardTypeAr(offer.getAutoRenewal().getRewardType());
//				// offerWebRequest.setOfficeCodeAr(offer.getAutoRenewal().getServiceOffice());
//				// offerWebRequest.setCurrencyTypeAr(offer.getAutoRenewal().getCurrencyCode());
//				// offerWebRequest.setDiscountAmountAr((offer.getAutoRenewal().getAmountOfValue()
//				// > 0 ?
//				// String.valueOf(offer.getAutoRenewal().getAmountOfValue()) :
//				// String.valueOf(offer.getAutoRenewal().getPercentOffValue())));
//				// } else if (!offerWebRequest.isEnrolledForAutoRenewal()) {
//				//
//				// offerWebRequest.setRewardTypeAr("");
//				// offerWebRequest.setOfficeCodeAr("");
//				// offerWebRequest.setCurrencyTypeAr("");
//				// offerWebRequest.setDiscountAmountAr("");
//				//
//				// }
//				// End Auto Renewal
//			/*	if (offer.getRegion() != null && offer.getRegion().getRegionName() != null) {
//					offerFormBean.setRegion(offer.getRegion().getRegionName());
//				}
//				if (null != offer.getDepositByDate()) {
//
//					offerFormBean.setDepositByDate(CATUtil.ConvertCalenderToString(offer.getDepositByDate()));
//				}*/
//				if (offer.getRegion() != null && offer.getRegion().getRegionName() != null) {
//					offerFormBean.setRegion(offer.getRegion().getRegionName());
//				}
//				if (offer.getStatus() != null)
//					offerFormBean.setOfferStatus(offer.getStatus().toString());
//				if (!(action.equalsIgnoreCase(OfferConstants.PUSH) || action.equalsIgnoreCase(OfferConstants.SUBMIT) 
//						|| action.equalsIgnoreCase(OfferConstants.APPROVE) || action.equalsIgnoreCase(OfferConstants.PULL_OFFER) 
//						|| action.equalsIgnoreCase(OfferConstants.ACTIVATE) || action.equalsIgnoreCase(OfferConstants.REJECT))) {
//					System.out.println("Coming under populate details-------------------");
//					if (action.equalsIgnoreCase(OfferConstants.UPDATE_OFFER) || action.equalsIgnoreCase(OfferConstants.VIEW_OFFER) || action.equalsIgnoreCase(OfferConstants.COPY_OFFER)) {
//						offerFormBean.setOfferName(offer.getOfferName());
//						// List<Long> offerLocalesFromResp =
//						// offer.getRegionLocales();
//						
//						List<Long> offerLocalesFromResp = offer.getOfferLocaleList(); 
//						List<Long> locales = new ArrayList<Long>();
//						if (offerLocalesFromResp != null && !offerLocalesFromResp.isEmpty()) {
//							for (Long offerLocales : offerLocalesFromResp) {
//								locales.add(offerLocales);
//							}
//							offerFormBean.setLocales(locales);
//						}
//						// if (offer.getIsTopPriority() != null &&
//						// offer.getIsTopPriority())
//						// offerFormBean.setTopPriority(offer.getIsTopPriority());
//						if (offer.getIsTopPriority() != null && offer.getIsTopPriority())
//							offerFormBean.setTopPriority(offer.getIsTopPriority());
//						else
//							offerFormBean.setTopPriority(false);
//						if (offer.getStatus() != null) {
//							offerFormBean.setOfferStatus(offer.getStatus().toString());
//						}
//					}
//					// List<Promotion> promotionListFromRes =
//					// offer.getPromotionList();
//					List<Promotion> promotionListFromRes = offer.getPromotionList();
//					if (promotionListFromRes != null && promotionListFromRes.size() > 0) {
//						System.out.println("Coming under Promotion List..................l");
//						Promotion promotion = promotionListFromRes.get(0);
//						PromotionBean promotionBean = new PromotionBean();
//						
//						if(promotion.getAudFileInclInd() != null && promotion.getAudFileInclInd().equalsIgnoreCase("N")){							
//							offerFormBean.setNoAudienceFile(true);
//						} else if(promotion.getAudFileInclInd() != null && promotion.getAudFileInclInd().equalsIgnoreCase("E")) {
//							offerFormBean.setExclusionAudienceFile(true);
//						}else{
//							offerFormBean.setInclusionAudienceFile(true);
//						}
//						
//						if (offerFormBean.getPromotionBeans() != null && offerFormBean.getPromotionBeans().size() > 0) {
//							promotionBean = offerFormBean.getPromotionBeans().get(0);
//						}
//						if (promotion.getPromotionID() != null) {
//							long promotionId = promotion.getPromotionID();
//							System.out.println("Promotion Id : " + promotionId);
//							promotionBean.setPromotionId(promotionId);
//							promotionBean.setPromotionCode(Long.toString(promotionId));
//
//							if (promotion.getPromotionStatus() == MOORStatus.PROMOTION_DBM_SUBMITTED) {
//								promotionBean.setPromotionDBMStatus("PROMOTION_DBM_SUBMITTED");
//							}
//							if (promotion.getPromotionStatus() == MOORStatus.MKT_INITIALIZED) {
//								promotionBean.setPromotionStatus("MKT_INITIALIZED");
//							}
//							// Context Id :
//							// "+promotion.getUserContextList().get(0).getUserContextId()
//							ContextBean contextBean = new ContextBean();
//							EventBean eventBean = new EventBean();
//
//							// System.out.println("Context : "+promotion.getUserContextList().get(0).getUserContextId());
//
//							try {
//								// contextBean.setContextId(promotion.getUserContextList().get(0).getUserContextId());
//								// contextBean.setContextName(promotion.getUserContextList().get(0).getUserContextCode());
//								contextBean.setContextId(promotion.getUserContextList().get(0).getUserContextId());
//								contextBean.setContextName(promotion.getUserContextList().get(0).getUserContextCode());
//							} catch (Exception e) {
//								contextBean.setContextId(Long.parseLong("0"));
//								contextBean.setContextName("none");
//								System.out.println("Context : Exception");
//							}
//							try {
//								System.out.println("event ID : " + promotion.getEvent().getEventID());
//								eventBean.setEventId(promotion.getEvent().getEventID());
//								eventBean.setEventName(promotion.getEvent().getEventName());
//								eventBean.setEventType(promotion.getEvent().getEventName());
//								eventBean.setEventDescription(promotion.getEvent().getEventName());
//							} catch (Exception e) {
//
//								System.out.println("Event : Exception");
//								eventBean.setEventId(Long.parseLong("0"));
//								eventBean.setEventName("null");
//								eventBean.setEventType("null");
//								eventBean.setEventDescription("null");
//							}
//
//							promotionBean.setContextBean(contextBean);
//							promotionBean.setEventBean(eventBean);
//
//							if (promotion.getPromotionStatus() != null)
//								promotionBean.setPromotionStatus(promotion.getPromotionStatus().toString());
//							/*if(promotion.getAudFileInclInd() != null && promotion.getAudFileInclInd() == true){
//								
//								offerFormBean.setInclusionAudienceFile(true);
//							} else {
//								offerFormBean.setNoAudienceFile(true);
//							}*/
//						}
//						if (action.equalsIgnoreCase(OfferConstants.UPDATE_OFFER) || action.equalsIgnoreCase(OfferConstants.VIEW_OFFER) || action.equalsIgnoreCase(OfferConstants.COPY_OFFER)) {
//							// Add Dummy DBM Data
//							// RewardAction.getInstance().createDBMOfferData(promotion);
//							RewardActionService.getInstance().populateDBMDetails(promotion, promotionBean);
//
//							if (promotion.getEvent() != null) {
//								EventBean eventBean = new EventBean();
//								System.out.println("event ID : " + promotion.getEvent().getEventID());
//								eventBean.setEventId(promotion.getEvent().getEventID());
//								eventBean.setEventName(promotion.getEvent().getEventName());
//								eventBean.setEventType(promotion.getEvent().getEventName());
//								eventBean.setEventDescription(promotion.getEvent().getEventName());
//								promotionBean.setEventBean(eventBean);
//							}
//							// List<Reward> rewardList =
//							// promotion.getRewardList();
//							List<Reward> rewardList = promotion.getRewardList();
//							
//							List<Long> rewardIdList = new ArrayList<Long>();
//
//							List<RewardBean> rewardBeanListFinal = new ArrayList<RewardBean>();
//							Set<String> channelTypes = new HashSet<String>();
//							
//							for(Reward reward : rewardList) {
//								channelTypes.add(reward.getChannelType());
//							}
//							
//							for (int j = 0; j < rewardList.size(); j++) {
//								if (rewardList.get(j) != null) {
//									RewardBean rewardBean = new RewardBean();
//									rewardBean.setRewardId(rewardList.get(j).getRewardID());
//									if (rewardList.get(j).getRewardMKTGStatus() != null)
//										rewardBean.setRewardMKTStatus(rewardList.get(j).getRewardMKTGStatus().toString());
//									if (rewardList.get(j).getRewardRMStatus() != null)
//										rewardBean.setRewardRMStatus(rewardList.get(j).getRewardRMStatus().toString());
//									rewardIdList.add(rewardList.get(j).getRewardID());
//									System.out.println("Rewards in Action : " + rewardList.get(j).getRewardID());
//									//String memberShipTypelist = rewardList.get(j).getMembershipType();
//									List<String> mTypeList = rewardList.get(j).getMemberTypeList();
//									String finalMembershipType = "";
//									for(String membershipType : mTypeList ){
//										
//										finalMembershipType += membershipType+"+";
//									}
//									if(finalMembershipType.contains("+")){
//										finalMembershipType = CATUtil.removeLastIdentifier(finalMembershipType);
//									}
//									/*List<String> mTypeList = new ArrayList<String>();
//									if (memberShipTypelist != null) {
//										String[] mTypeStr = StringUtils.split(memberShipTypelist, "+");
//										for (int i = 0; i < mTypeStr.length; i++) {
//											mTypeList.add(StringUtils.capitalize(mTypeStr[i].toLowerCase()));
//										}
//									}*/
//									Collections.sort(rewardIdList);
//									rewardBean.setRewardIdList(rewardIdList);
//									// List<LandingPageURL> landingPageURLList =
//									// rewardList.get(j).getRewardLandingPageURLList();
//
//									List<LandingPageURL> landingPageURLList = (null != rewardList.get(j).getRewardLandingPageURLList()) ? rewardList.get(j).getRewardLandingPageURLList() : null;
//									if (landingPageURLList != null && landingPageURLList.size() > 0) {
//										List<LandingPageUrlBean> landingPageUrlBeanList = new ArrayList<LandingPageUrlBean>();
//										LandingPageUrlBean landingPageUrlBean = null;
//										for (LandingPageURL landingPageURL : landingPageURLList) {
//											landingPageUrlBean = new LandingPageUrlBean();
//											landingPageUrlBean.setOfferLandingPageKey(landingPageURL.getRewardLandingPageKey());
//											landingPageUrlBean.setOfferLandingPageDimensionNames(landingPageURL.getRewardLandingPageDimensionNames());
//											landingPageUrlBean.setOfferLandingPageXMLIDS(landingPageURL.getRewardLandingPageXMLIDS());
//											landingPageUrlBeanList.add(landingPageUrlBean);
//										}
//										rewardBean.setLandingPageUrlBeanList(landingPageUrlBeanList);
//									}
//
//									// Code change for Ticket 1756097 - Landing
//									// Page URL not created using the resort
//									// search option - Start
//									// List<SearchType> searchCriteriaList =
//									// promotion.getReward().getSearchCriteriaList();
//									List<SearchType> searchCriteriaList = promotion.getReward().getSearchCriteriaList();
//									log.debug("searchCriteriaList is not null and Size is " + searchCriteriaList.size());
//									if (searchCriteriaList != null && searchCriteriaList.size() > 0) {
//										List<SearchCriteriaBean> searchCriteriaBeanList = new ArrayList<SearchCriteriaBean>();
//										for (SearchType SearchType : searchCriteriaList) {
//											SearchCriteriaBean searchCriteriaBean = new SearchCriteriaBean();
//											log.debug("Search Code : " + SearchType.getResortSearchCriteria().getResortID());
//											searchCriteriaBean.setSearchCode(SearchType.getResortSearchCriteria().getResortID());
//											searchCriteriaBean.setSearchType(OfferConstants.RESORT_SEARCH);
//											searchCriteriaBeanList.add(searchCriteriaBean);
//										}
//										rewardBean.setSearchCriteriaBeanList(searchCriteriaBeanList);
//									}
//									// Code change for Ticket 1756097 - Landing
//									// Page URL not created using the resort
//									// search option End
//
//									OfferTranslationBean transBean = null;
//									// if
//									// (rewardList.get(j).getRewardWebContentList()
//									// != null &&
//									// rewardList.get(j).getRewardWebContentList().getRewardTransContentList()
//									// != null &&
//									// rewardList.get(j).getRewardWebContentList().getRewardTransContentList().size()
//									// > 0) {
//									if (rewardList.get(j).getRewardWebContentList() != null) {
//										log.debug("offerTransContentList is not null");
//										List<OfferTranslationBean> transList = new ArrayList<OfferTranslationBean>();
//										if (rewardList.get(j).getRewardWebContentList().getRootName() != null && rewardList.get(j).getRewardWebContentList().getRootDescription() != null) {
//											transBean = new OfferTranslationBean();
//											transBean.setName(rewardList.get(j).getRewardWebContentList().getRootName());
//											transBean.setDesc(rewardList.get(j).getRewardWebContentList().getRootDescription());
//											transBean.setIsRootContent(true);
//											transBean.setIsPlatinumPreview(false);
//											transBean.setCountry("");
//											transList.add(0, transBean);
//										}
//
//										if(rewardList.get(j).getRewardWebContentList().getRewardTransContentList() != null 
//											&& rewardList.get(j).getRewardWebContentList().getRewardTransContentList().size() > 0) {
//											for (TranslationContent translationContent : rewardList.get(j).getRewardWebContentList().getRewardTransContentList()) {
//												transBean = new OfferTranslationBean();
//												transBean.setName(translationContent.getTranslationName());
//												transBean.setDesc(translationContent.getTranslationDescription());
//												transBean.setLocale(translationContent.getLocale());
//												transBean.setApplicationType(translationContent.getConsumerType());
//												transBean.setIsPlatinumPreview(translationContent.getIsPlatinumPreview());
//												transBean.setCountry(translationContent.getCountry());
//												transList.add(transBean);
//											}
//										}	
//										rewardBean.setTranslationList(transList);
//									}
//
//									if (rewardList.get(j).getRewardType() != null) {
//										if (rewardList.get(j).getRewardType().equals(RewardType.SPECIALOFFER)) {
//											rewardBean.setRewardType(OfferConstants.REWARD_SPECIAL_OFFER);
//											RewardLinkedBean rewardLinkedBean = new RewardLinkedBean();
//											if (rewardList.get(j).getChannelType() != null)
//												rewardLinkedBean.setRedemptionChannel(rewardList.get(j).getChannelType());
//											rewardLinkedBean.setBypassLinkUrl(rewardList.get(j).getRewardLinkElements().getBypassLinkUrl());
//											//rewardLinkedBean.setOfficeList(rewardList.get(j).getRewardLinkElements().getOfficeCodes());
//										
//											if (rewardList.get(j).getRewardLinkElements().getOfficeCodes() != null && rewardList.get(j).getRewardLinkElements().getOfficeCodes().get(0) != null && rewardList.get(j).getRewardLinkElements().getOfficeCodes().size() > 0) {
//												if (rewardList.get(j).getRewardLinkElements().getOfficeCodes().size() == 1 && "ALL".equalsIgnoreCase(rewardList.get(j).getRewardLinkElements().getOfficeCodes().get(0))) {
//													rewardLinkedBean.setAllOffice(true);
//												} else {
//													List<String> evsList = new ArrayList<String>();
//													List<String> dblList = new ArrayList<String>();
//													Map<String, List<String>> officeMap = new LinkedHashMap<String, List<String>>();
//
//													for (String officeCode : rewardList.get(j).getRewardLinkElements().getOfficeCodes()) {
//														if (officeCode != null && officeCode.trim().length() > 0) {
//															String[] arrOfficeCode = officeCode.split(",");
//															if (arrOfficeCode != null) {
//																for (String tempOfficeCode : arrOfficeCode) {
//																	if (tempOfficeCode != null) {
//																		String officeType = tempOfficeCode.substring(0, officeCode.indexOf("-"));
//																		if ("EVS1".equals(officeType)) {
//																			evsList.add(tempOfficeCode.substring(officeCode.indexOf("-") + 1).trim());
//																		}
//																		if ("DBL".equals(officeType)) {
//																			dblList.add(officeCode.substring(tempOfficeCode.indexOf("-") + 1).trim());
//																		}
//																	}
//																}
//															}
//														}
//													}
//													officeMap.put("EVS1", evsList);
//													officeMap.put("DBL", dblList);
//													rewardLinkedBean.setOfficeDetailsMap(officeMap);													
//
//												}
//											}
//											rewardLinkedBean.setMembershipTypeList(mTypeList);											
//											
//											if(rewardList.get(j).getRewardStartDate() != null){
//												rewardLinkedBean.setRewardStartDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardStartDate()));
//											}
//											if(rewardList.get(j).getRewardEndDate() != null){
//												rewardLinkedBean.setRewardEndDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardEndDate()));
//											}
//											rewardBean.setRewardLinkedBean(rewardLinkedBean);
//										}
//										else if (rewardList.get(j).getRewardType().equals(RewardType.RENTAL)) {
//											rewardBean.setRewardType(OfferConstants.REWARD_EV);
//											if (rewardList.get(j).getXmlId() != null && rewardList.get(j).getXmlId() > 0) {
//												offerFormBean.setOfferXMLID("" + rewardList.get(j).getXmlId());
//											}
//											RewardInventoryMKTBean rewardInventoryMKTBean = new RewardInventoryMKTBean();
//											
//											if(rewardList.size()>1){
//												rewardInventoryMKTBean.setRedemptionChannel("BOTH");
//											} else{
//											if (rewardList.get(j).getChannelType() != null)
//												rewardInventoryMKTBean.setRedemptionChannel(rewardList.get(j).getChannelType());
//											}
//											
//											// if
//											// (rewardList.get(j).getIsLandingPageURLAvailable()
//											// != null) {
//											// if
//											// (rewardList.get(j).getIsLandingPageURLAvailable())
//											if (rewardList.get(j).getIsLandingPageURLAvailable() != null) {
//												if (rewardList.get(j).getIsLandingPageURLAvailable())
//													rewardInventoryMKTBean.setLandingPageURL(true);
//												else
//													rewardInventoryMKTBean.setLandingPageURL(false);
//											}
//
//											rewardInventoryMKTBean.setMembershipTypeLst(mTypeList);
//											if (rewardList.get(j).getRedemOnce() == 1) {
//												rewardInventoryMKTBean.setRedeemOnce(true);
//											} else {
//												rewardInventoryMKTBean.setRedeemOnce(false);
//											}
//											
//											if(null!= rewardList.get(j)){
//												
//												rewardInventoryMKTBean.setExclAddnPltDisc(rewardList.get(j).isExclAddnPltDisc());
//											}
//											
//											RewardInventoryBean rewardInventoryBean = new RewardInventoryBean();
//											rewardInventoryBean.setRewardInventoryMKTBean(rewardInventoryMKTBean);
//
//											RewardInventoryRMBean rewardInventoryRMBean = new RewardInventoryRMBean();
//
//											if (rewardList.get(j).getRedemOnce() == 1) {
//												rewardInventoryRMBean.setRedeemOnce(true);
//											} else {
//												rewardInventoryRMBean.setRedeemOnce(false);
//											}
//											if (rewardList.get(j) != null && rewardList.get(j).getRewardStartDate() != null) {
//												// offerFormBean.setOfferStartDate(CATUtil.dateToStr(rewardList.get(j).getRewardStartDate().getTime()));
//												offerFormBean.setOfferStartDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardStartDate()));
//												rewardInventoryRMBean.setRedemptionStartDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardStartDate()));
//											}
//
//											if (rewardList.get(j) != null && rewardList.get(j).getRewardEndDate() != null) {
//												// offerFormBean.setOfferEndDate(CATUtil.dateToStr(rewardList.get(j).getRewardEndDate().getTime()));
//												offerFormBean.setOfferEndDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardEndDate()));
//												rewardInventoryRMBean.setRedemptionEndDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardEndDate()));
//											}
//											
//											if(null!= rewardList.get(j)){
//												rewardInventoryRMBean.setExclAddnPltDisc(rewardList.get(j).isExclAddnPltDisc());
//											}
//											
//											RewardInventoryElements rewardInventoryElements = rewardList.get(j).getRewardInventoryElements();
//											if (rewardInventoryElements != null) {
//												if (rewardInventoryElements.getRewardInventoryType() != null) {
//													if (rewardInventoryElements.getRewardInventoryType().toString().equalsIgnoreCase(OfferConstants.REWARD_INV_PERCENT_OFF)) {
//														List<RewardPopulationBean> rewardPopulationBeanList = null;
//														rewardBean.setRewardSubType(OfferConstants.PERCENT_OFF);
//														try {
//														    rewardPopulationBeanList = CATUtil.getRewardPopulationBeanListForRental(offerServiceResponse);
//															offerWebRequest.setRewardPopulationBean(rewardPopulationBeanList);
//														} catch (Exception e) {
//															// TODO Auto-generated catch block
//															e.printStackTrace();
//														}
//													
//														
//															
//															/*if (rewardPopulationBeanList != null) {
//																for (RewardPopulationBean rewardPopulationBean : rewardPopulationBeanList) {
//																if ("WEB".equalsIgnoreCase(rewardPopulationBean.getRedemptionChannel())) {
//																	rewardInventoryRMBean.setRedemPercentForWeb(rewardPopulationBean.getRedeemPercentOff());
//																}else if ("CC".equalsIgnoreCase(rewardPopulationBean.getRedemptionChannel())) {
//																	rewardInventoryRMBean.setRedemPercentForCC(rewardPopulationBean.getRedeemPercentOff());
//																}
//															}
//															
//															
//															
//															}*/
//														
//														if(channelTypes.size()>1) {
//															offerFormBean.setRedemptionChannel("BOTH");
//															rewardInventoryBean.getRewardInventoryMKTBean().setRedemptionChannel("BOTH");
//														} else {
//															rewardInventoryBean.getRewardInventoryMKTBean().setRedemptionChannel(channelTypes.iterator().next());
//														}
//														
//														
//														
//													} else if (rewardInventoryElements.getRewardInventoryType().toString().equalsIgnoreCase(OfferConstants.REWARD_INV_FIXED_PRICE)) {
//														
//														rewardBean.setRewardSubType(OfferConstants.FIXED_PRICE);
//														
//														if (rewardInventoryElements.getFixedPrice() != null && rewardInventoryElements.getFixedPrice().getRedemptionFPList() != null && !rewardInventoryElements.getFixedPrice().getRedemptionFPList().isEmpty()) {
//															// if
//															// (rewardInventoryElements.getFixedPrice().getRedemptionFPList()
//															// != null &&
//															// rewardInventoryElements.getFixedPrice().getRedemptionFPList().size()
//															// > 0) {
//																List<FixedPriceBean> fixedPriceBeanList = new ArrayList<FixedPriceBean>();
//																// for
//																// (RedemptionValue
//																// redemptionValue
//																// :
//																// rewardInventoryElements.getFixedPrice().getRedemptionFPList())
//																// {
//																for (RedemptionValue redemptionValue : rewardInventoryElements.getFixedPrice().getRedemptionFPList()) {
//																	FixedPriceBean fixedPriceBean = new FixedPriceBean();
//																	fixedPriceBean.setCurrencyCode(redemptionValue.getCurrencyCode());
//																	fixedPriceBean.setRedemptionValue(redemptionValue.getRedemptionValue());
//																	fixedPriceBean.setValFromSOA(true);
//																	fixedPriceBeanList.add(fixedPriceBean);
//																}
//																rewardInventoryRMBean.setFixedPriceBeanList(fixedPriceBeanList);
//														}
//													}else if (rewardInventoryElements.getRewardInventoryType().toString().equalsIgnoreCase(OfferConstants.FIXED_AND_RENEWAL_INV_AMT_OFF)) {
//														
//															rewardBean.setRewardSubType(OfferConstants.FIXED_AND_RENEWAL_AMT_OFF);
//															if (rewardInventoryElements.getAmountOff() != null && rewardInventoryElements.getAmountOff().getRedemptionAmtOffList() != null && !rewardInventoryElements.getAmountOff().getRedemptionAmtOffList().isEmpty()) {
//																// if
//																// (rewardInventoryElements.getFixedPrice().getRedemptionFPList()
//																// != null &&
//																// rewardInventoryElements.getFixedPrice().getRedemptionFPList().size()
//																// > 0) {
//																	List<FixedPriceBean> fixedPriceBeanList = new ArrayList<FixedPriceBean>();
//																	// for
//																	// (RedemptionValue
//																	// redemptionValue
//																	// :
//																	// rewardInventoryElements.getFixedPrice().getRedemptionFPList())
//																	// {
//																	for (RedemptionValue redemptionValue : rewardInventoryElements.getAmountOff().getRedemptionAmtOffList()) {
//																		FixedPriceBean fixedPriceBean = new FixedPriceBean();
//																		fixedPriceBean.setCurrencyCode(redemptionValue.getCurrencyCode());
//																		fixedPriceBean.setRedemptionValue(redemptionValue.getRedemptionValue());
//																		fixedPriceBean.setPriceRangeMinValue(redemptionValue.getPriceRangeFrom());
//																		fixedPriceBean.setPriceRangeMaxValue(redemptionValue.getPriceRangeTo());
//																		fixedPriceBean.setValFromSOA(true);
//																		fixedPriceBeanList.add(fixedPriceBean);
//																	}
//																	rewardInventoryRMBean.setFixedPriceBeanList(fixedPriceBeanList);
//															}
//														
//													} else if (rewardInventoryElements.getRewardInventoryType().toString().equalsIgnoreCase(OfferConstants.REWARD_INV_VARIABLE_FIXED_PRICE)) {
//														rewardBean.setRewardSubType(OfferConstants.VARIABLE_FIXED_PRICE);
//														if (rewardInventoryElements.getMultipleFixedPrice() != null && rewardInventoryElements.getMultipleFixedPrice().getBedRoom() != null && !rewardInventoryElements.getMultipleFixedPrice().getBedRoom().isEmpty()) {
//															// if
//															// (rewardInventoryElements.getMultipleFixedPrice().getBedRoom()
//															// != null &&
//															// rewardInventoryElements.getMultipleFixedPrice().getBedRoom().size()
//															// > 0) {
//																List<MultipleFixedPriceBean> multipleFixedPriceBeanList = new ArrayList<MultipleFixedPriceBean>();
//																// for (BedRoom
//																// bedRoom :
//																// rewardInventoryElements.getMultipleFixedPrice().getBedRoom())
//																// {
//																for (BedRoom bedRoom : rewardInventoryElements.getMultipleFixedPrice().getBedRoom()) {
//																	MultipleFixedPriceBean multipleFixedPriceBean = new MultipleFixedPriceBean();
//																	List<FixedPriceBean> fixedPriceBeanList = new ArrayList<FixedPriceBean>();
//																	// multipleFixedPriceBean.setBedRoomType(bedRoom.getBedRoomType());
//																	// if
//																	// (bedRoom.getRedemValue()
//																	// != null
//																	// &&
//																	// bedRoom.getRedemValue().size()
//																	// > 0)
//																	// ;
//																	multipleFixedPriceBean.setBedRoomType(bedRoom.getBedRoomType());
//																	if (bedRoom.getRedemValue() != null && bedRoom.getRedemValue().size() > 0)
//																		;
//																	{
//																		// for
//																		// (RedemptionValue
//																		// redemptionValue
//																		// :
//																		// bedRoom.getRedemValue())
//																		// {
//																		for (RedemptionValue redemptionValue : bedRoom.getRedemValue()) {
//																			FixedPriceBean fixedPriceBean = new FixedPriceBean();
//																			fixedPriceBean.setValFromSOA(true);
//																			fixedPriceBean.setRedemptionValue(redemptionValue.getRedemptionValue());
//																			fixedPriceBean.setCurrencyCode(redemptionValue.getCurrencyCode());
//																			fixedPriceBeanList.add(fixedPriceBean);
//																		}
//																	}
//																	multipleFixedPriceBean.setFixedPriceBean(fixedPriceBeanList);
//																	multipleFixedPriceBeanList.add(multipleFixedPriceBean);
//																}
//																rewardInventoryRMBean.setMultipleFixedPriceBeanList(multipleFixedPriceBeanList);
//														}
//													}
//												}
//												if (rewardInventoryElements.getCompNumber() != null && rewardInventoryElements.getCompNumber() != "")
//													rewardInventoryRMBean.setCompNumber(Integer.parseInt(rewardInventoryElements.getCompNumber()));
//												// if
//												// (rewardInventoryElements.getIsHoldAllowed()
//												// != null)
//												// rewardInventoryRMBean.setHoldAllowed(rewardInventoryElements.getIsHoldAllowed());
//												if (rewardInventoryElements.getIsHoldAllowed() != null)
//													rewardInventoryRMBean.setHoldAllowed(rewardInventoryElements.getIsHoldAllowed());
//
//												rewardInventoryBean.setRewardInventoryRMBean(rewardInventoryRMBean);
//											}
//											rewardBean.setRewardInventoryBean(rewardInventoryBean);
//
//										} else if (rewardList.get(j).getRewardType().equals(RewardType.RENEWAL)) {
//											rewardBean.setRewardType(OfferConstants.REWARD_RENEWAL);
//											RewardRenewalBean rewardRenewalBean = new RewardRenewalBean();
//											List<RenewalSetBean> renewalSetBeanList = new ArrayList<RenewalSetBean>();
//											RenewalSetBean renewalSetBean = null;
//											List<RenewalTermBean> renewalTermBeanList = new ArrayList<RenewalTermBean>();
//											rewardRenewalBean.setMembershipType(finalMembershipType);
//											if (rewardList.get(j).getChannelType() != null)
//												rewardRenewalBean.setRedemptionChannel(rewardList.get(j).getChannelType());
//											// if
//											// (rewardList.get(j).getRewardStartDate()
//											// != null) {
//											// rewardRenewalBean.setRewardStartDate(CATUtil.dateToStr(rewardList.get(j).getRewardStartDate().getTime()));
//											// offerFormBean.setOfferStartDate(CATUtil.dateToStr(rewardList.get(j).getRewardStartDate().getTime()));
//											// }
//											// if
//											// (rewardList.get(j).getRewardEndDate()
//											// != null) {
//											// rewardRenewalBean.setRewardEndDate(CATUtil.dateToStr(rewardList.get(j).getRewardEndDate().getTime()));
//											// offerFormBean.setOfferEndDate(CATUtil.dateToStr(rewardList.get(j).getRewardEndDate().getTime()));
//											// }
//											if (rewardList.get(j).getRewardStartDate() != null) {
//												rewardRenewalBean.setRewardStartDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardStartDate()));
//												offerFormBean.setOfferStartDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardStartDate()));
//											}
//											if (rewardList.get(j).getRewardEndDate() != null) {
//												rewardRenewalBean.setRewardEndDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardEndDate()));
//												offerFormBean.setOfferEndDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardEndDate()));
//											}
//
//											if (rewardList.get(j).getRedemOnce() == 1)
//												rewardRenewalBean.setRedeemOnce(true);
//											else
//												rewardRenewalBean.setRedeemOnce(false);
//											// if
//											// (rewardList.get(j).getIsLandingPageURLAvailable()
//											// != null)
//											// rewardRenewalBean.setLandingPageURL(rewardList.get(j).getIsLandingPageURLAvailable());
//											if (rewardList.get(j).getIsLandingPageURLAvailable() != null)
//												rewardRenewalBean.setLandingPageURL(rewardList.get(j).getIsLandingPageURLAvailable());
//											if (rewardList.get(j).getCountDownFlag() != null)
//												rewardRenewalBean.setDisplayCountDown(rewardList.get(j).getCountDownFlag().toString());
//											RewardRenewalElements rewardRenewalElements = rewardList.get(j).getRewardRenewalElements();
//											if (rewardRenewalElements != null) {
//												String rewardSubType = "";
//												if (rewardRenewalElements.getRewardRenewalType() != null)
//													rewardSubType = rewardRenewalElements.getRewardRenewalType().toString();
//
//												if (rewardSubType.equalsIgnoreCase(OfferConstants.REWARD_INV_PERCENT_OFF)) {
//													rewardBean.setRewardSubType(OfferConstants.RENEWAL_PERCENT_OFF);
//													renewalSetBean = new RenewalSetBean();
//													RenewalPercentOffBean renewalPercentOffBean = new RenewalPercentOffBean();
//													// List<ServiceOffice>
//													// serviceOfficeCodeList =
//													// rewardRenewalElements.getServiceOfficeList();
//													List<ServiceOffice> serviceOfficeCodeList = rewardRenewalElements.getServiceOfficeList();
//													List<String> officeCodesList = new ArrayList<String>();
//													if (serviceOfficeCodeList != null) {
//														for (ServiceOffice serviceOffice : serviceOfficeCodeList) {
//															officeCodesList.add(serviceOffice.getServicingOfficeCode());
//														}
//													}
//
//													// List<RenewalTermPercentageOff>
//													// renewalTermPercentageOffList
//													// =
//													// rewardRenewalElements.getRenewalTermPercentageOffList();
//													List<RenewalTermPercentageOff> renewalTermPercentageOffList = rewardRenewalElements.getRenewalTermPercentageOffList();
//													if (renewalTermPercentageOffList != null) {
//														for (RenewalTermPercentageOff renewalTermPercentageOff : renewalTermPercentageOffList) {
//															RenewalTermBean renewalTermBean = new RenewalTermBean();
//															renewalTermBean.setPercentOff(renewalTermPercentageOff.getRenewalPercentageOff().getPercentageOffID());
//															renewalTermBean.setTerm(new Integer(renewalTermPercentageOff.getRenewalTerm().getRenwalTerm().toString()));
//															// renewalTermBean.setTermValid(renewalTermPercentageOff.getRenewalTerm().isValid());
//															// Start WAR Project
//
//															renewalTermBean.setAutoRenewalFlag("N");
//															renewalTermBean.setRewardTypeAr("PERCENTAGE_OFF");
//															renewalTermBean.setDiscountAr("0");
//															offerWebRequest.setRewardTypeAr("PERCENTAGE_OFF");
//															if (offer.isAutoRenewal()  ) {
//																// WAR Change
//																//autoRenewalListObj = offer.getAutoRenewalList();
//																//List<AutoRenewal> arListObj = autoRenewalListObj != null ? (List<AutoRenewal>) autoRenewalListObj.getAutoRenewal() : null;
//																if (arListObj != null) {
//																	Iterator<AutoRenewal> itr = arListObj.iterator();
//																	while (itr.hasNext()) {
//																		autoRenewalObj = itr.next();
//																		renewalTermBean.setAutoRenewalFlag("Y");
//																		renewalTermBean.setRewardTypeAr(autoRenewalObj.getRewardType());
//																		if ("AMOUNT_OFF".equalsIgnoreCase(autoRenewalObj.getRewardType()))
//																			renewalTermBean.setDiscountAr(autoRenewalObj.getAmountOfValue() > 0 ? String.valueOf(autoRenewalObj.getAmountOfValue()) : "0");
//																		else
//																			renewalTermBean.setDiscountAr(autoRenewalObj.getPercentOffValue() > 0 ? String.valueOf(autoRenewalObj.getPercentOffValue()) : "0");
//																		// UseOnlyForViewpageTableHeaderDisplay
//																		offerWebRequest.setRewardTypeAr(autoRenewalObj.getRewardType());
//																	}// while
//
//																}// inner if
//															} // if
//
//															// End WAR Project
//
//															renewalTermBeanList.add(renewalTermBean);
//														}
//													}
//
//													renewalPercentOffBean.setRenewalTermBeanList(renewalTermBeanList);
//													renewalSetBean.setServicingOfficeCodes(officeCodesList);
//													renewalSetBean.setRenewalPercentOffBean(renewalPercentOffBean);
//													renewalSetBeanList.add(renewalSetBean);
//												} else if (rewardSubType.equalsIgnoreCase(OfferConstants.RENEWAL_INV_X_FOR_Y)) {
//													rewardBean.setRewardSubType(OfferConstants.RENEWAL_X_FOR_Y);
//													renewalSetBean = new RenewalSetBean();
//													RenewalXForYBean renewalXForYBean = new RenewalXForYBean();
//													RenewalTermBean renewalTermBean = new RenewalTermBean();
//													// List<ServiceOffice>
//													// serviceOfficeCodeList =
//													// rewardRenewalElements.getServiceOfficeList();
//													List<ServiceOffice> serviceOfficeCodeList = rewardRenewalElements.getServiceOfficeList();
//													List<String> officeCodesList = new ArrayList<String>();
//													if (serviceOfficeCodeList != null && serviceOfficeCodeList.size() > 0) {
//														for (ServiceOffice serviceOffice : serviceOfficeCodeList) {
//															officeCodesList.add(serviceOffice.getServicingOfficeCode());
//														}
//														RenewXyearsGetYyears renewXyearsGetYyears = rewardRenewalElements.getRenewXyearsGetYyears();
//														renewalTermBean.setTermX(new Integer(renewXyearsGetYyears.getXYears().getRenwalTerm().toString()));
//														renewalTermBean.setTermY(new Integer(renewXyearsGetYyears.getYYears().getRenwalTerm().toString()));
//													}
//
//													renewalTermBeanList.add(renewalTermBean);
//													renewalXForYBean.setRenewalTermBeanList(renewalTermBeanList);
//													renewalSetBean.setServicingOfficeCodes(officeCodesList);
//													renewalSetBean.setRenewalXForYBean(renewalXForYBean);
//													renewalSetBeanList.add(renewalSetBean);
//												} else if (rewardSubType.equalsIgnoreCase(OfferConstants.FIXED_AND_RENEWAL_INV_AMT_OFF)) {
//													rewardBean.setRewardSubType(OfferConstants.FIXED_AND_RENEWAL_AMT_OFF);
//													List<String> officeCodesList = null;
//													// List<ServiceOffice>
//													// serviceOfficeCodeList =
//													// rewardRenewalElements.getServiceOfficeList();
//													List<ServiceOffice> serviceOfficeCodeList = rewardRenewalElements.getServiceOfficeList();
//													if (serviceOfficeCodeList != null && serviceOfficeCodeList.size() > 0) {
//														for (ServiceOffice serviceOffice : serviceOfficeCodeList) {
//															officeCodesList = new ArrayList<String>();
//															renewalSetBean = new RenewalSetBean();
//															List<RenewalCurrencyBean> renewalCurrencyBeanList = new ArrayList<RenewalCurrencyBean>();
//															RenewalAmountOffBean renewalAmountOffBean = new RenewalAmountOffBean();
//															RenewalCurrencyBean renewalCurrencyBean = null;
//															officeCodesList.add(serviceOffice.getServicingOfficeCode());
//															renewalSetBean.setServicingOfficeCodes(officeCodesList);
//															// List<RenewalCurrency>
//															// renewalCurrencyList
//															// =
//															// serviceOffice.getRenwalCurrencies();
//															List<RenewalCurrency> renewalCurrencyList = serviceOffice.getRenwalCurrencies();
//															for (RenewalCurrency renewalCurrency : renewalCurrencyList) {
//																renewalCurrencyBean = new RenewalCurrencyBean();
//																renewalTermBeanList = new ArrayList<RenewalTermBean>();
//																renewalCurrencyBean.setCurrencyCode(renewalCurrency.getCurrencyCode());
//
//																// List<RenewalTermAmountOff>
//																// renewalTermAmountOffList
//																// =
//																// renewalCurrency.getRenewalTermAmountOff();
//																List<RenewalTermAmountOff> renewalTermAmountOffList = renewalCurrency.getRenewalTermAmountOff();
//
//																for (RenewalTermAmountOff renewalTermAmountOff : renewalTermAmountOffList) {
//																	RenewalTermBean renewalTermBean = new RenewalTermBean();
//																	renewalTermBean.setTerm(renewalTermAmountOff.getRenewalTerm().getRenwalTerm().intValue());
//																	renewalTermBean.setAmountOff(renewalTermAmountOff.getRenewalAmountOff());
//																	renewalTermBean.setValFromSOA(true);
//																	renewalTermBeanList.add(renewalTermBean);
//
//																	// Start WAR
//																	// Project
//
//																	renewalTermBean.setAutoRenewalFlag("N");
//																	renewalTermBean.setRewardTypeAr("AMOUNT_OFF");
//																	renewalTermBean.setDiscountAr("0");
//																	offerWebRequest.setRewardTypeAr("AMOUNT_OFF");
//																	if (offer.isAutoRenewal()) {
//																		// WAR
//																		// Change
//																		//autoRenewalListObj = offer.getAutoRenewalList();
//																		//List<AutoRenewal> arListObj = autoRenewalListObj != null ? (List<AutoRenewal>) autoRenewalListObj.getAutoRenewal() : null;
//																		if (arListObj != null) {
//																			Iterator<AutoRenewal> itr = arListObj.iterator();
//																			while (itr.hasNext()) {
//																				autoRenewalObj = itr.next();
//																				renewalTermBean.setAutoRenewalFlag("Y");
//																				renewalTermBean.setRewardTypeAr(autoRenewalObj.getRewardType());
//
//																				if ("AMOUNT_OFF".equalsIgnoreCase(autoRenewalObj.getRewardType())) {
//																					if (autoRenewalObj.getServiceOffice().equalsIgnoreCase(serviceOffice.getServicingOfficeCode()) && autoRenewalObj.getCurrencyCode().equals(renewalCurrency.getCurrencyCode())) {
//
//																						renewalTermBean.setDiscountAr(autoRenewalObj.getAmountOfValue() > 0 ? String.valueOf(autoRenewalObj.getAmountOfValue()) : "0");
//
//																					}
//																				} else if ("PERCENTAGE_OFF".equalsIgnoreCase(autoRenewalObj.getRewardType())) {
//																					if (autoRenewalObj.getServiceOffice().equalsIgnoreCase(serviceOffice.getServicingOfficeCode())) {
//																						// renewalTermBean.setAutoRenewalFlag("Y");
//																						// renewalTermBean.setRewardTypeAr(autoRenewalObj.getRewardType());
//																						renewalTermBean.setDiscountAr(autoRenewalObj.getPercentOffValue() > 0 ? String.valueOf(autoRenewalObj.getPercentOffValue()) : "0");
//
//																					}
//																				}
//
//																				// UseOnlyForViewpageTableHeaderDisplay
//																				offerWebRequest.setRewardTypeAr(autoRenewalObj.getRewardType());
//
//																			}// while
//
//																		}// inner
//																			// if
//																	} // if
//
//																	// End WAR
//																	// Project
//																}
//																renewalCurrencyBean.setRenewalTermBeanList(renewalTermBeanList);
//																renewalCurrencyBeanList.add(renewalCurrencyBean);
//															}
//															renewalAmountOffBean.setRenewalCurrencyBeanList(renewalCurrencyBeanList);
//															renewalSetBean.setRenewalAmountOffBean(renewalAmountOffBean);
//															renewalSetBeanList.add(renewalSetBean);
//														}
//													}
//												}
//											}
//											rewardRenewalBean.setRenewalSetBeanList(renewalSetBeanList);
//											rewardBean.setRewardRenewalBean(rewardRenewalBean);
//										} else if (rewardList.get(j).getRewardType().equals(RewardType.EXCHANGE)) {
//											try {
//												List<RewardPopulationBean> rewardPopulationBeanList = CATUtil.getRewardPopulationBeanList(offerServiceResponse);
//												offerWebRequest.setRewardPopulationBean(rewardPopulationBeanList);
//											} catch (Exception e) {
//												// TODO Auto-generated catch
//												// block
//												e.printStackTrace();
//											}
//											rewardBean.setRewardType(OfferConstants.REWARD_EXCHANGE);
//											RewardRenewalBean rewardRenewalBean = new RewardRenewalBean();
//
//											rewardRenewalBean.setMembershipType(finalMembershipType);
//											if (rewardList.get(j).getChannelType() != null)
//												rewardRenewalBean.setRedemptionChannel(rewardList.get(j).getChannelType());
//											if (rewardList.get(j).getRewardStartDate() != null) {
//												// rewardRenewalBean.setRewardStartDate(CATUtil.calendarToString(rewardList.get(j).getRewardStartDate()));
//												rewardRenewalBean.setRewardStartDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardStartDate()));
//												offerFormBean.setOfferStartDate(CATUtil.ConvertCalenderToString(offer.getOfferStartDate()));
//											}
//											offerFormBean.setOfferStartDate(CATUtil.ConvertCalenderToString(offer.getOfferStartDate()));
//											if (rewardList.get(j).getRewardEndDate() != null) {
//												rewardRenewalBean.setRewardEndDate(CATUtil.ConvertCalenderToString(rewardList.get(j).getRewardEndDate()));
//												offerFormBean.setOfferEndDate(CATUtil.ConvertCalenderToString(offer.getOfferEndDate()));
//											}
//											offerFormBean.setOfferEndDate(CATUtil.ConvertCalenderToString(offer.getOfferEndDate()));
//											if (offer.getGpOfferEndDate() != null)
//												offerFormBean.setOfferCCEndDate(CATUtil.ConvertCalenderToString(offer.getGpOfferEndDate()));
//
//											if (rewardList.get(j).getRedemOnce() == 1)
//												rewardRenewalBean.setRedeemOnce(true);
//											else
//												rewardRenewalBean.setRedeemOnce(false);
//											// if
//											// (rewardList.get(j).getIsLandingPageURLAvailable()
//											// != null)
//											// rewardRenewalBean.setLandingPageURL(rewardList.get(j).getIsLandingPageURLAvailable());
//											if (rewardList.get(j).getIsLandingPageURLAvailable() != null)
//												rewardRenewalBean.setLandingPageURL(rewardList.get(j).getIsLandingPageURLAvailable());
//											if (rewardList.get(j).getCountDownFlag() != null)
//												rewardRenewalBean.setDisplayCountDown(rewardList.get(j).getCountDownFlag().toString());
//
//											rewardRenewalBean.setMaxRedCount(String.valueOf(rewardList.get(j).getMaxReedemCount()));
//											rewardRenewalBean.setMembershipType(finalMembershipType);
//
//											RewardExchangeFeeElements rewardExchangeFeeElements = rewardList.get(j).getRewardExchangeFeeElements();
//
//											if (rewardExchangeFeeElements != null) {
//
//												if (rewardList.size() > 1) {
//													offerFormBean.setRedemptionChannel("BOTH");
//													rewardRenewalBean.setRedemptionChannel("BOTH");
//												} else {
//													offerFormBean.setRedemptionChannel(rewardList.get(j).getChannelType());
//													rewardRenewalBean.setRedemptionChannel(rewardList.get(j).getChannelType());
//												}
//												if (finalMembershipType != null) {
//													offerFormBean.setMembershipType(finalMembershipType);
//													rewardRenewalBean.setMembershipType(finalMembershipType);
//												}
//												String rewardSubType = "";
//
//												if (rewardExchangeFeeElements.getExchFeeAmountOff() != null) {
//													rewardSubType = "AMOUNT OFF";
//												} else {
//													rewardSubType = "PERCENT OFF";
//												}
//												rewardBean.setRewardSubType(rewardSubType);
//
//											}
//											// for (Offer offerdata :
//											// offerServiceResponse.getOffers())
//											// {
//											// if (offerdata.getPromotionList()
//											// != null &&
//											// offer.getPromotionList().size() >
//											// 0) {
//											// Promotion promotionFromResp =
//											// offer.getPromotionList().get(0);
//											// if
//											// (promotionFromResp.getRewardList()
//											// != null) {
//											// List<Reward> rewardBeanList =
//											// promotionFromResp.getRewardList();
//											for (Offer offerdata : offerServiceResponse.getOffers()) {
//												if (offerdata.getPromotionList() != null && offer.getPromotionList().size() > 0) {
//													Promotion promotionFromResp = offer.getPromotionList().get(0);
//													if(promotionFromResp.getEvent() != null){
//														Calendar eventEndDate = promotionFromResp.getEvent().getEventEndDate();
//														try{
//														offerFormBean.setDepositByDate(CATUtil.ConvertCalenderToString(eventEndDate));
//														}catch(Exception e){
//															e.printStackTrace();
//														}
//													}
//													if (promotionFromResp.getRewardList() != null) {
//														List<Reward> rewardBeanList = promotionFromResp.getRewardList();
//														List<RewardDetailsBean> rewardDetailsList = CATUtil.callpopulateRewardDetailsBean(rewardBeanList);
//														offerWebRequest.setRewardDetailsBeanList(rewardDetailsList);
//													}
//												}
//											}
//											rewardBean.setRewardRenewalBean(rewardRenewalBean);
//											List<TravelWindowBean> travelWindowBeanList = populateTravelwindowBeanOnView(offerServiceResponse);
//											offerWebRequest.setTravelWindowBeanList(travelWindowBeanList);
//										}
//									}
//									if(rewardBean.getRewardInventoryBean().getRewardInventoryMKTBean().isLandingPageURL() && !rewardBean.getLandingPageUrlBeanList().isEmpty())
//									{
//									promotionBean.setRewardBean(rewardBean);
//									} else if(null == promotionBean.getRewardBean())
//									{
//										promotionBean.setRewardBean(rewardBean);
//										
//									}
//									rewardBeanListFinal.add(rewardBean);
//								}
//
//							}
//							promotionBean.setRewardBeanList(rewardBeanListFinal);
//							if(null == promotionBean.getRewardBean().getTranslationList())
//							{
//							for(RewardBean rewardBean: rewardBeanListFinal)
//							{
//								if(null != rewardBean.getTranslationList() && !rewardBean.getTranslationList().isEmpty())
//								{
//								
//									promotionBean.getRewardBean().setTranslationList(rewardBean.getTranslationList());
//									break;
//								}
//							}
//							}
//							
//						}
//						List<PromotionBean> promotionBeanList = new ArrayList<PromotionBean>();
//						promotionBeanList.add(promotionBean);
//
//						offerFormBean.setPromotionBeans(promotionBeanList);
//					}
//				} else {
//					// List<Promotion> promotionListFromRes =
//					// offer.getPromotionList();
//					List<Promotion> promotionListFromRes = offer.getPromotionList();
//					if (promotionListFromRes != null && promotionListFromRes.size() > 0) {
//						Promotion promotion = promotionListFromRes.get(0);
//						PromotionBean promotionBean = offerFormBean.getPromotionBeans().get(0);
//						if (promotion.getPromotionStatus() != null)
//							promotionBean.setPromotionStatus(promotion.getPromotionStatus().toString());
//						// List<Reward> rewardList = promotion.getRewardList();
//						List<Reward> rewardList = promotion.getRewardList();
//						for (int k = 0; k < rewardList.size(); k++) {
//							if (rewardList.get(k) != null && rewardList.get(k).getRewardMKTGStatus() != null)
//								promotionBean.getRewardBean().setRewardMKTStatus(rewardList.get(k).getRewardMKTGStatus().toString());
//							if (rewardList.get(k) != null && rewardList.get(k).getRewardRMStatus() != null)
//								promotionBean.getRewardBean().setRewardRMStatus(rewardList.get(k).getRewardRMStatus().toString());
//							// if(rewardList.get(k)!=null &&
//							// rewardList.get(k).getRewardID()!=null)
//							// promotionBean.getRewardBean().setRewardId(rewardList.get(k).getRewardID());
//							if (rewardList.get(k) != null && rewardList.get(k).getRewardType() != null )
//							{
//								if (rewardList.get(k).getRewardType().equals(RewardType.SPECIALOFFER)) {
//									promotionBean.getRewardBean().setRewardType(OfferConstants.REWARD_SPECIAL_OFFER);
//									promotionBean.getRewardBean().setRewardId(rewardList.get(k).getRewardID());
//									
//									if (rewardList.get(k).getRewardLinkElements().getOfficeCodes() != null && rewardList.get(k).getRewardLinkElements().getOfficeCodes().get(0) != null && rewardList.get(k).getRewardLinkElements().getOfficeCodes().size() > 0) {
//										if (rewardList.get(k).getRewardLinkElements().getOfficeCodes().size() == 1 && "ALL".equalsIgnoreCase(rewardList.get(k).getRewardLinkElements().getOfficeCodes().get(0))) {
//											promotionBean.getRewardBean().getRewardLinkedBean().setAllOffice(true);
//										} else {
//											List<String> evsList = new ArrayList<String>();
//											List<String> dblList = new ArrayList<String>();
//											Map<String, List<String>> officeMap = new LinkedHashMap<String, List<String>>();
//
//											for (String officeCode : rewardList.get(k).getRewardLinkElements().getOfficeCodes()) {
//												if (officeCode != null && officeCode.trim().length() > 0) {
//													String[] arrOfficeCode = officeCode.split(",");
//													if (arrOfficeCode != null) {
//														for (String tempOfficeCode : arrOfficeCode) {
//															if (tempOfficeCode != null) {
//																String officeType = tempOfficeCode.substring(0, officeCode.indexOf("-"));
//																if ("EVS1".equals(officeType)) {
//																	evsList.add(tempOfficeCode.substring(officeCode.indexOf("-") + 1).trim());
//																}
//																if ("DBL".equals(officeType)) {
//																	dblList.add(officeCode.substring(tempOfficeCode.indexOf("-") + 1).trim());
//																}
//															}
//														}
//													}
//												}
//											}
//											officeMap.put("EVS1", evsList);
//											officeMap.put("DBL", dblList);
//											promotionBean.getRewardBean().getRewardLinkedBean().setOfficeDetailsMap(officeMap);													
//
//										}
//									}
//									
//								}else
//								{
//									// promotionBean.getRewardBean().setRewardType(rewardList.get(k).getRewardType().getRewardType());
//									promotionBean.getRewardBean().setRewardType(rewardList.get(k).getRewardType().toString());
//								}
//							}
//								
//						}
//					}
//				}
//			}
//			offerWebRequest.setOfferFormBean(offerFormBean);
//
//		}
//		log.debug("Exit OfferAction populateOfferDetails Method");
//	}
//
//	public void processTermsRatesValidationError(OfferOrchResponse offerServiceResponse, OfferWebDTO offerWebRequest) {
//		RewardRenewalBean rewardRenewalBeanFromSession = null;
//		if (offerWebRequest != null && offerWebRequest.getOfferFormBean() != null) {
//			if (offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean() != null && (OfferConstants.REWARD_RENEWAL).equalsIgnoreCase(offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean().getRewardType())) {
//				rewardRenewalBeanFromSession = offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean().getRewardRenewalBean();
//			}
//		}
//		if (offerServiceResponse.getOffers() != null && offerServiceResponse.getOffers().size() > 0) {
//			// if
//			// (offerServiceResponse.getOffers().get(0).getPromotionList().get(0).getRewardList()
//			// != null) {
//			// List<Reward> rewardList =
//			// offerServiceResponse.getOffers().get(0).getPromotionList().get(0).getRewardList();
//			if (offerServiceResponse.getOffers().get(0).getPromotionList().get(0).getRewardList() != null) {
//				List<Reward> rewardList = offerServiceResponse.getOffers().get(0).getPromotionList().get(0).getRewardList();
//				for (int i = 0; i < rewardList.size(); i++) {
//					if ((RewardType.RENEWAL).equals(rewardList.get(i).getRewardType())) {
//						if (rewardList.get(i).getRewardRenewalElements() != null) {
//							RewardRenewalElements rewardRenewalElements = rewardList.get(i).getRewardRenewalElements();
//							List<RenewalTermBean> renewalTermBeanList = new ArrayList<RenewalTermBean>();
//							List<RenewalSetBean> renewalSetBeanList = new ArrayList<RenewalSetBean>();
//							RenewalSetBean renewalSetBean = null;
//							if (rewardRenewalElements != null) {
//								String rewardSubType = rewardRenewalElements.getRewardRenewalType().toString();
//								if ((OfferConstants.REWARD_INV_PERCENT_OFF).equalsIgnoreCase(rewardSubType)) {
//									renewalSetBean = new RenewalSetBean();
//									RenewalPercentOffBean renewalPercentOffBean = new RenewalPercentOffBean();
//									// List<ServiceOffice> serviceOfficeCodeList
//									// =
//									// rewardRenewalElements.getServiceOfficeList();
//									List<ServiceOffice> serviceOfficeCodeList = rewardRenewalElements.getServiceOfficeList();
//									List<String> officeCodesList = new ArrayList<String>();
//									if (serviceOfficeCodeList != null) {
//										for (ServiceOffice serviceOffice : serviceOfficeCodeList) {
//											officeCodesList.add(serviceOffice.getServicingOfficeCode());
//										}
//									}
//
//									// List<RenewalTermPercentageOff>
//									// renewalTermPercentageOffList =
//									// rewardRenewalElements.getRenewalTermPercentageOffList();
//									List<RenewalTermPercentageOff> renewalTermPercentageOffList = rewardRenewalElements.getRenewalTermPercentageOffList();
//									if (renewalTermPercentageOffList != null) {
//										for (RenewalTermPercentageOff renewalTermPercentageOff : renewalTermPercentageOffList) {
//											RenewalTermBean renewalTermBean = new RenewalTermBean();
//											renewalTermBean.setPercentOff(renewalTermPercentageOff.getRenewalPercentageOff().getPercentageOffID());
//											renewalTermBean.setTerm(new Integer(renewalTermPercentageOff.getRenewalTerm().getRenwalTerm().toString()));
//											renewalTermBean.setTermValid(renewalTermPercentageOff.getRenewalTerm().isValid());
//											renewalTermBeanList.add(renewalTermBean);
//										}
//									}
//
//									renewalPercentOffBean.setRenewalTermBeanList(renewalTermBeanList);
//									renewalSetBean.setServicingOfficeCodes(officeCodesList);
//									renewalSetBean.setRenewalPercentOffBean(renewalPercentOffBean);
//									renewalSetBeanList.add(renewalSetBean);
//								} else if ((OfferConstants.RENEWAL_INV_X_FOR_Y).equalsIgnoreCase(rewardSubType)) {
//									// VALIDATION POPULATION IS PENDING -
//									// WAITING FOR SOA
//									renewalSetBean = new RenewalSetBean();
//									RenewalXForYBean renewalXForYBean = new RenewalXForYBean();
//									RenewalTermBean renewalTermBean = new RenewalTermBean();
//									// List<ServiceOffice> serviceOfficeCodeList
//									// =
//									// rewardRenewalElements.getServiceOfficeList();
//									List<ServiceOffice> serviceOfficeCodeList = rewardRenewalElements.getServiceOfficeList();
//									List<String> officeCodesList = new ArrayList<String>();
//									if (serviceOfficeCodeList != null && serviceOfficeCodeList.size() > 0) {
//										for (ServiceOffice serviceOffice : serviceOfficeCodeList) {
//											officeCodesList.add(serviceOffice.getServicingOfficeCode());
//										}
//										RenewXyearsGetYyears renewXyearsGetYyears = rewardRenewalElements.getRenewXyearsGetYyears();
//										renewalTermBean.setTermX(new Integer(renewXyearsGetYyears.getXYears().getRenwalTerm().toString()));
//										renewalTermBean.setTermY(new Integer(renewXyearsGetYyears.getYYears().getRenwalTerm().toString()));
//										renewalTermBean.setTermValid(renewXyearsGetYyears.getYYears().isValid());
//									}
//
//									renewalTermBeanList.add(renewalTermBean);
//									renewalXForYBean.setRenewalTermBeanList(renewalTermBeanList);
//									renewalSetBean.setServicingOfficeCodes(officeCodesList);
//									renewalSetBean.setRenewalXForYBean(renewalXForYBean);
//									renewalSetBeanList.add(renewalSetBean);
//								} else if ((OfferConstants.FIXED_AND_RENEWAL_INV_AMT_OFF).equalsIgnoreCase(rewardSubType)) {
//									List<String> officeCodesList = null;
//									// List<ServiceOffice> serviceOfficeCodeList
//									// =
//									// rewardRenewalElements.getServiceOfficeList();
//									List<ServiceOffice> serviceOfficeCodeList = rewardRenewalElements.getServiceOfficeList();
//									if (serviceOfficeCodeList != null && serviceOfficeCodeList.size() > 0) {
//										for (ServiceOffice serviceOffice : serviceOfficeCodeList) {
//											officeCodesList = new ArrayList<String>();
//											renewalSetBean = new RenewalSetBean();
//											List<RenewalCurrencyBean> renewalCurrencyBeanList = new ArrayList<RenewalCurrencyBean>();
//											RenewalAmountOffBean renewalAmountOffBean = new RenewalAmountOffBean();
//											RenewalCurrencyBean renewalCurrencyBean = null;
//											officeCodesList.add(serviceOffice.getServicingOfficeCode());
//											renewalSetBean.setServicingOfficeCodes(officeCodesList);
//											// List<RenewalCurrency>
//											// renewalCurrencyList =
//											// serviceOffice.getRenwalCurrencies();
//											List<RenewalCurrency> renewalCurrencyList = serviceOffice.getRenwalCurrencies();
//											for (RenewalCurrency renewalCurrency : renewalCurrencyList) {
//												renewalCurrencyBean = new RenewalCurrencyBean();
//												renewalTermBeanList = new ArrayList<RenewalTermBean>();
//												renewalCurrencyBean.setCurrencyCode(renewalCurrency.getCurrencyCode());
//
//												// List<RenewalTermAmountOff>
//												// renewalTermAmountOffList =
//												// renewalCurrency.getRenewalTermAmountOff();
//												List<RenewalTermAmountOff> renewalTermAmountOffList = renewalCurrency.getRenewalTermAmountOff();
//												for (RenewalTermAmountOff renewalTermAmountOff : renewalTermAmountOffList) {
//													RenewalTermBean renewalTermBean = new RenewalTermBean();
//													renewalTermBean.setTerm(renewalTermAmountOff.getRenewalTerm().getRenwalTerm().intValue());
//													renewalTermBean.setAmountOff(renewalTermAmountOff.getRenewalAmountOff());
//													renewalTermBean.setValFromSOA(true);
//													renewalTermBean.setTermValid(renewalTermAmountOff.getRenewalTerm().isValid());
//													renewalTermBeanList.add(renewalTermBean);
//												}
//												renewalCurrencyBean.setRenewalTermBeanList(renewalTermBeanList);
//												renewalCurrencyBeanList.add(renewalCurrencyBean);
//											}
//											renewalAmountOffBean.setRenewalCurrencyBeanList(renewalCurrencyBeanList);
//											renewalSetBean.setRenewalAmountOffBean(renewalAmountOffBean);
//											renewalSetBeanList.add(renewalSetBean);
//										}
//									}
//								}
//							}
//							rewardRenewalBeanFromSession.setRenewalSetBeanList(renewalSetBeanList);
//							offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean().setRewardRenewalBean(rewardRenewalBeanFromSession);
//						}
//					}
//				}
//			}
//		}
//	}
//
//	public EndecaDimensionMetaData getEndecaDimensionMetaData() {
//		EndecaDimensionMetaData endecaDimensionMetaData = null;
//		OfferDelegate offerDelegate = new OfferDelegate();
//		try {
//
//			RewardOrchRequest rewardOrchRequest = OfferSOARequestContract.getRewardOrchRequestForEndecaMetadata();
//			endecaDimensionMetaData = offerDelegate.getEndecaDimensionMetaData(rewardOrchRequest);
//		} catch (Exception e) {
//			log.error("Error in Getting  EndecaDimensionMetaData", e);
//		}
//		return endecaDimensionMetaData;
//	}
//
//	public OfferWebDTO createRewardRenewal(OfferWebDTO offerWebRequest, String action) throws Exception {
//		return null;
//	}
//
//	public OfferWebDTO updateRewardRenewal(OfferWebDTO offerWebRequest) {
//		return null;
//	}
//
//	public OfferWebDTO createEVReward(OfferWebDTO offerWebRequest) {
//		return null;
//	}
//
//	public RenewalFeeBean getRenewalRates(RenewalFeeBean renewalFeeBean) {
//		return null;
//	}
//
//	public Map translateContent(BufferedInputStream file) throws Exception {
//		return null;
//	}
//
//	public DashboardOfferWebDTO getOfferSearchResults(DashboardOfferWebDTO webReq) {
//		return null;
//	}
//
//	public DashboardOfferWebDTO getOfferbyStatus(DashboardOfferWebDTO webReq) {
//		return null;
//	}
//
//	public OfferWebDTO changeRewardStatus(OfferWebDTO offerWebRequest, String action) {
//		return null;
//	}
//
//	public OfferWebDTO createRewardExchange(OfferWebDTO offerWebRequest, String action) {
//		return null;
//	}
//
//	protected List<TravelWindowBean> populateTravelwindowBeanOnView(OfferOrchResponse serviceResponse) {
//		List<TravelWindowBean> travelList = new ArrayList<TravelWindowBean>();
//		Offer offer = serviceResponse.getOffers().get(0);
//		// List<OfferTravelWindow> offerTravelWindowList =
//		// offer.getOfferTravelWindowList();
//		List<OfferTravelWindow> offerTravelWindowList = offer.getOfferTravelWindowList();
//
//		for (OfferTravelWindow offerTravelWindow : offerTravelWindowList) {
//			TravelWindowBean travelWindowBean = new TravelWindowBean();
//			if (offerTravelWindow != null) {
//				if (offerTravelWindow.getTravelStartDate() != null) {
//					try {
//						// travelWindowBean.setTravelStartDate(CATUtil.dateToStr(offerTravelWindow.getTravelStartDate()));
//						travelWindowBean.setTravelStartDate(CATUtil.dateToStr(offerTravelWindow.getTravelStartDate()));
//					} catch (Exception e) {
//						travelWindowBean.setTravelStartDate("");
//					}
//				}
//				if (offerTravelWindow.getTravelEndDate() != null) {
//					try {
//						travelWindowBean.setTravelEndDate(CATUtil.dateToStr(offerTravelWindow.getTravelEndDate()));
//					} catch (Exception e) {
//						travelWindowBean.setTravelEndDate("");
//					}
//				}
//				try {
//					travelWindowBean.setAdvanceDays(String.valueOf(offerTravelWindow.getAdvanceByDays()));
//				} catch (Exception e) {
//					travelWindowBean.setAdvanceDays("0");
//				}
//				travelList.add(travelWindowBean);
//			}
//		}
//		return travelList;
//
//	}
//
//	protected OfferWebDTO populateCopyOfferExchangeRewardDetails(OfferOrchResponse offerServiceResponse, OfferWebDTO exchangeWebRequest) {
//		log.debug("Entered RewardRenewalAction populateCreateRewardDetails Method");
//
//		OfferFormBean offerFormBean = exchangeWebRequest.getOfferFormBean();
//		if (offerServiceResponse == null) {
//			log.error("CreateExchangeReward Response is null.");
//			exchangeWebRequest.setErrCode("OfferService Response is null.");
//			exchangeWebRequest.setError(true);
//			for (PromotionBean promoBean : exchangeWebRequest.getOfferFormBean().getPromotionBeans()) {
//				promoBean.getRewardBean().setErrorCode("RewardRenewalService Response is null.");
//				promoBean.getRewardBean().setIsError(true);
//			}
//			// } else if (offerServiceResponse.hasErrors()) {
//		} else if (offerServiceResponse != null && offerServiceResponse.getErrorInfos() != null) {
//			// log.error("ERRORS size= " +
//			// offerServiceResponse.getErrorInfos().size());
//			// ErrorInfo errorInfo = (ErrorInfo)
//			// offerServiceResponse.getErrorInfos().get(0);
//			log.error("ERRORS size= " + offerServiceResponse.getErrorInfos().getErrorInfo().size());
//			ErrorInfo errorInfo = (ErrorInfo) offerServiceResponse.getErrorInfos().getErrorInfo().get(0);
//			log.error("ERROR CODE = " + errorInfo.getCode());
//			exchangeWebRequest.setError(true);
//			// exchangeWebRequest.setErrCode(errorInfo.getCode() + " : " +
//			// CATUtil.processErrorCodes(offerServiceResponse.getErrorInfos()));
//			exchangeWebRequest.setErrCode(errorInfo.getCode() + " : " + CATUtil.processErrorCodes(offerServiceResponse.getErrorInfos().getErrorInfo()));
//			/*
//			 * if("CAT_REWARD_013".equalsIgnoreCase(errorInfo.getCode())){
//			 * processTermsRatesValidationError
//			 * (offerServiceResponse,renewalWebRequest); }
//			 */
//		} else {
//			if (offerServiceResponse.getOffers() != null && offerServiceResponse.getOffers().size() > 0) {
//				exchangeWebRequest.setError(false);
//				exchangeWebRequest.setErrCode("SUCCESSFUL");
//
//				for (Offer offer : offerServiceResponse.getOffers()) {
//					offerFormBean.setOfferUUID(offer.getOfferUUID());
//					offerFormBean.setOfferCode(offer.getOfferCode());
//					offerFormBean.setOfferStatus(offer.getStatus().toString());
//					if(offer.getTierPreviewInd()!= null){
//						offerFormBean.setPlatinumPreview(offer.getTierPreviewInd());
//					} else {
//						offerFormBean.setPlatinumPreview(false);
//					}
//				
//					
//					
//					List<OfferMembershipTier> offerMemTierList = offer.getOfferMembershipTierList();
//					String tierType = "";
//					Long standardDelay = 0L;
//					if(offerMemTierList != null){
//					for(OfferMembershipTier offerMemTier : offerMemTierList){
//						if(offerMemTierList != null && offerMemTierList.size() == 4){
//							tierType = "ALL";
//							standardDelay = offerMemTier.getDelayPeriod();
//						} else {
//							if(offerMemTier.getTierName().contains("Platinum")){
//								tierType = "Platinum";
//								standardDelay = offerMemTier.getDelayPeriod();
//							}else {
//								tierType = "Standard";
//								standardDelay = offerMemTier.getDelayPeriod();
//							}
//						}
//					}
//					}
//					offerFormBean.setStandardDelay(standardDelay+"");
//					offerFormBean.setTierType(tierType);
//					List<PromotionBean> promotionList = new ArrayList<PromotionBean>();
//					PromotionBean promotionBean = new PromotionBean();
//					// if (offer.getPromotionList() != null &&
//					// offer.getPromotionList().size() > 0) {
//					// Promotion promotionFromResp =
//					// offer.getPromotionList().get(0);
//					if (offer.getPromotionList() != null && offer.getPromotionList().size() > 0) {
//						Promotion promotionFromResp = offer.getPromotionList().get(0);
//						if(promotionFromResp.getAudFileInclInd() != null && promotionFromResp.getAudFileInclInd().equalsIgnoreCase("N")){							
//							offerFormBean.setNoAudienceFile(true);
//						} else if(promotionFromResp.getAudFileInclInd() != null && promotionFromResp.getAudFileInclInd().equalsIgnoreCase("E")) {
//							offerFormBean.setExclusionAudienceFile(true);
//						}else{
//							offerFormBean.setInclusionAudienceFile(true);
//						}
//						if(promotionFromResp.getEvent() != null){
//							Calendar eventEndDate = promotionFromResp.getEvent().getEventEndDate();
//							try{
//							offerFormBean.setDepositByDate(CATUtil.ConvertCalenderToString(eventEndDate));
//							}catch(Exception e){
//								e.printStackTrace();
//							}
//						}
//						
//						// Add Dummy DBM Data
//						// createDBMOfferData(promotionFromResp);
//
//						promotionBean.setPromotionId(promotionFromResp.getPromotionID());
//						promotionBean.setPromotionStatus(promotionFromResp.getPromotionStatus().toString());
//						/*
//						 * EventBean eventBean=promotionBean.getEventBean();
//						 * Event eventFromResp=null;
//						 * if(promotionFromResp.getEvent() != null) {
//						 * eventFromResp=promotionFromResp.getEvent();
//						 * eventBean.setEventId(eventFromResp.getEventID());
//						 * //eventBean
//						 * .setEventType(String.valueOf(eventFromResp.
//						 * getEventTypeID()));
//						 * eventBean.setEventName(eventFromResp.getEventName());
//						 * eventBean.setEventType(eventFromResp.getEventName());
//						 * eventBean
//						 * .setEventDescription(eventFromResp.getEventName()); }
//						 */
//						RewardBean rewardBean = new RewardBean();
//						// if (promotionFromResp.getRewardList() != null) {
//						// List<Reward> rewardBeanList =
//						// promotionFromResp.getRewardList();
//						if (promotionFromResp.getRewardList() != null) {
//							List<Reward> rewardBeanList = promotionFromResp.getRewardList();
//							Reward reward = null;
//							for (int i = 0; i < rewardBeanList.size(); i++) {
//								reward = rewardBeanList.get(i);
//								rewardBean.setRewardId(reward.getRewardID());
//							}
//							RewardRenewalBean rewardRenewalBean = new RewardRenewalBean();
//							if (rewardBeanList.size() > 1) {
//								offerFormBean.setRedemptionChannel("BOTH");
//								rewardRenewalBean.setRedemptionChannel("BOTH");
//							} else {
//								offerFormBean.setRedemptionChannel(reward.getChannelType());
//								rewardRenewalBean.setRedemptionChannel(reward.getChannelType());
//							}
//							// List<LandingPageURL> landingPgURLEOMList =
//							// reward.getRewardLandingPageURLList();
//							List<LandingPageURL> landingPgURLEOMList = reward.getRewardLandingPageURLList();
//							List<LandingPageUrlBean> landingPageURLBeanList = new ArrayList<LandingPageUrlBean>();
//							if (landingPgURLEOMList != null) {
//								for (LandingPageURL landingPageURLEOM : landingPgURLEOMList) {
//									LandingPageUrlBean landingPageUrlBean = new LandingPageUrlBean();
//									landingPageUrlBean.setOfferLandingPageKey(landingPageURLEOM.getRewardLandingPageKey());
//									landingPageUrlBean.setOfferLandingPageDimensionNames(landingPageURLEOM.getRewardLandingPageDimensionNames());
//									landingPageUrlBean.setOfferLandingPageXMLIDS(landingPageURLEOM.getRewardLandingPageXMLIDS());
//									landingPageURLBeanList.add(landingPageUrlBean);
//								}
//							}
//							rewardBean.setLandingPageUrlBeanList(landingPageURLBeanList);
//							String finalMembershipType = "";
//							List<String> mTypeList = reward.getMemberTypeList();
//							for(String membershipType : mTypeList ){
//								
//								finalMembershipType += membershipType+"+";
//							}
//							if(finalMembershipType.contains("+")){
//								finalMembershipType = CATUtil.removeLastIdentifier(finalMembershipType);
//							}
//							if (finalMembershipType!= null) {
//								offerFormBean.setMembershipType(finalMembershipType);
//								rewardRenewalBean.setMembershipType(finalMembershipType);
//							}
//
//							if (reward.getRewardStartDate() != null) {
//								rewardRenewalBean.setRewardStartDate(CATUtil.ConvertCalenderToString(reward.getRewardStartDate()));
//							}
//							if (reward.getRewardEndDate() != null) {
//								rewardRenewalBean.setRewardEndDate(CATUtil.ConvertCalenderToString(reward.getRewardEndDate()));
//							}
//							if (reward.getMaxReedemCount() == 0) {
//								rewardRenewalBean.setMaxRedCount("1");
//							} else {
//								rewardRenewalBean.setMaxRedCount(reward.getMaxReedemCount() + "");
//							}
//
//							if (null != reward.getRewardStatus()) {
//								rewardBean.setRewardStatus(reward.getRewardStatus().toString());
//							}
//							// if (null !=
//							// reward.getRewardType().getRewardType()) {
//							// rewardBean.setRewardType(reward.getRewardType().getRewardType());
//							// }
//							if (null != reward.getRewardType()) {
//								rewardBean.setRewardType(reward.getRewardType().toString());
//							}
//							rewardBean.setRewardRenewalBean(rewardRenewalBean);
//							promotionBean.setRewardBean(rewardBean);
//							List<RewardDetailsBean> rewardDetailsList = CATUtil.callpopulateRewardDetailsBean(rewardBeanList);
//							exchangeWebRequest.setRewardDetailsBeanList(rewardDetailsList);
//						}
//
//						promotionList.add(promotionBean);
//
//						offerFormBean.setPromotionBeans(promotionList);
//						exchangeWebRequest.setOfferFormBean(offerFormBean);
//						// populateDBMDetails(promotionFromResp,promotionBean);
//					}
//
//					/*
//					 * if(promotionBean.getRewardBean().getRewardRenewalBean()
//					 * != null &&
//					 * promotionBean.getRewardBean().getRewardRenewalBean
//					 * ().getRenewalSetBeanList() != null){ for(RenewalSetBean
//					 * renewalSetBean :
//					 * promotionBean.getRewardBean().getRewardRenewalBean
//					 * ().getRenewalSetBeanList()){ if(renewalSetBean !=null &&
//					 * renewalSetBean.getRenewalAmountOffBean()!=null){
//					 * for(RenewalCurrencyBean
//					 * renewalCurrencyBean:renewalSetBean
//					 * .getRenewalAmountOffBean().getRenewalCurrencyBeanList()){
//					 * for(RenewalTermBean
//					 * renewalTermBean:renewalCurrencyBean.getRenewalTermBeanList
//					 * ()){ renewalTermBean.setValFromSOA(true); } } } } }
//					 */
//				}
//			}
//			try {
//				List<RewardPopulationBean> rewardPopulationBeanList = CATUtil.getRewardPopulationBeanList(offerServiceResponse);
//				exchangeWebRequest.setRewardPopulationBean(rewardPopulationBeanList);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return exchangeWebRequest;
//	}
//
//}
