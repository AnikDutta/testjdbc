//package com.rci.cat.service.impl;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.log4j.Logger;
//
//import com.rci.eom.Campaign;
//import com.rci.eom.CustomerSet;
//import com.rci.eom.Promotion;
//import com.rci.eom.Reward;
//import com.rci.moor.cat.OfferConstants;
//import com.rci.moor.cat.delegates.AbstractDelegate;
//import com.rci.moor.cat.dtos.OfferWebDTO;
//import com.rci.moor.cat.formbeans.AudienceList;
//import com.rci.moor.cat.formbeans.CampaignBean;
//import com.rci.moor.cat.formbeans.OfferFormBean;
//import com.rci.moor.cat.formbeans.PromotionBean;
//import com.rci.moor.cat.formbeans.RewardBean;
//import com.rci.moor.cat.framework.DelegateName;
//import com.rci.moor.cat.framework.DelegatesManager;
//import com.rci.moor.cat.services.OfferSOARequestContract;
//import com.rci.moor.cat.util.CATUtil;
//import com.rci.services.common.contract.ErrorInfo;
//import com.rci.services.orch.offer.offerorchservice.RewardOrchRequest;
//import com.rci.services.orch.offer.offerorchservice.RewardOrchResponse;
//
//public class RewardActionService extends OfferActionService {
//
//	private static final RewardActionService instance = new RewardActionService();
//
//	public static RewardActionService getInstance() {
//		return instance;
//	}
//
//	static Logger log = Logger.getLogger(RewardActionService.class);
//
//	public RewardActionService() {
//	}
//
//	public OfferWebDTO changeRewardStatus(OfferWebDTO offerWebRequest, String action) {
//		AbstractDelegate offrDelegate = DelegatesManager.getDelegate(DelegateName.OfferDelegate);
//		try {
//			log.debug("Entered RewardAction changeRewardStatus");
//
//			RewardOrchResponse rewardOrchResponse = null;
//
//			if (offerWebRequest != null && action.equals(OfferConstants.SUBMIT)) {
//				if (!offerWebRequest.getRewardType().contains("EXCHANGE")) {
//					RewardOrchRequest rewardOrchRequest = OfferSOARequestContract.getRewardOrchRequestForStatusChange(offerWebRequest, action);
//					rewardOrchResponse = offrDelegate.submitReward(rewardOrchRequest);
//
//				} else {
//
//					if (offerWebRequest.getOfferFormBean() != null && offerWebRequest.getOfferFormBean().getPromotionBeans() != null && offerWebRequest.getOfferFormBean().getPromotionBeans().size() > 0 && offerWebRequest.getOfferFormBean().getPromotionBeans().get(0) != null && offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean() != null) {
//
//						List<Long> rewardIdList = offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean().getRewardIdList();
//						if (rewardIdList != null && rewardIdList.size() > 0) {
//							for (Long rewardId : rewardIdList) {
//
//								RewardOrchRequest rewardOrchRequest = OfferSOARequestContract.getRewardOrchRequestForStatusChangeForExchange(offerWebRequest, rewardId, action);
//								rewardOrchResponse = offrDelegate.submitReward(rewardOrchRequest);
//							}
//						}
//					}
//
//				}
//			} else if (action.equals(OfferConstants.REJECT)) {
//				if (!offerWebRequest.getRewardType().toLowerCase().contains("exchange")) {
//					RewardOrchRequest rewardOrchRequest = OfferSOARequestContract.getRewardOrchRequestForStatusChange(offerWebRequest, action);
//					rewardOrchResponse = offrDelegate.rejectOffer(rewardOrchRequest);
//				} else {
//					if (offerWebRequest.getOfferFormBean() != null && offerWebRequest.getOfferFormBean().getPromotionBeans() != null && offerWebRequest.getOfferFormBean().getPromotionBeans().size() > 0 && offerWebRequest.getOfferFormBean().getPromotionBeans().get(0) != null && offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean() != null) {
//
//						List<Long> rewardIdList = offerWebRequest.getOfferFormBean().getPromotionBeans().get(0).getRewardBean().getRewardIdList();
//						if (rewardIdList != null && rewardIdList.size() > 0) {
//							for (Long rewardId : rewardIdList) {
//
//								RewardOrchRequest rewardOrchRequest = OfferSOARequestContract.getRewardOrchRequestForStatusChangeForExchange(offerWebRequest, rewardId, action);
//								rewardOrchResponse = offrDelegate.rejectOffer(rewardOrchRequest);
//							}
//						}
//					}
//				}
//			}
//			populateRewardDetails(rewardOrchResponse, offerWebRequest);
//			log.debug("Exit OfferAction " + action);
//		} catch (Exception e) {
//			log.error("ERROR in OfferAction  " + action, e);
//		}
//		return offerWebRequest;
//	}
//
//	protected void populateDBMDetails(Promotion promotionFromResp, PromotionBean promotionBean) {
//		// Get the DBM Data.
//		if (promotionFromResp.getCampaign() != null && promotionFromResp.getCampaign().size() > 0) {
//
//			List<CampaignBean> campaignBeans = new ArrayList<CampaignBean>();
//
//			Set<Campaign> campaignSet = promotionFromResp.getCampaign();
//			for (Campaign campaign : campaignSet) {
//				// Create the Campaign
//				CampaignBean campaignBean = new CampaignBean();
//				campaignBean.setCampaignType(campaign.getCampaignName());
//
//				List<CustomerSet> customerSets = campaign.getCustomerSet();
//
//				// Create the Audience List
//				List<AudienceList> customers = new ArrayList<AudienceList>();
//
//				for (CustomerSet cs : customerSets) {
//					AudienceList customer = new AudienceList();
//					customer.setReferenceNumber(cs.getReferenceNumber().longValue());
//					customer.setMemberIdCount(cs.getMemberCount());
//					// Add Customer to Audience List
//					customers.add(customer);
//				}
//
//				// Assign the Audience List to Campaign
//				campaignBean.setCustomers(customers);
//
//				// Add the Campaign to the List
//				campaignBeans.add(campaignBean);
//			}
//			promotionBean.setCampaignBeans(campaignBeans);
//
//		}
//	}
//
//	protected void populateRewardDetails(RewardOrchResponse rewardOrchResponse, OfferWebDTO offerWebRequest) {
//		log.debug("Entered RewardAction populateRewardDetails Method");
//		OfferFormBean offerFormBean = offerWebRequest.getOfferFormBean();
//		if (rewardOrchResponse == null) {
//			log.error("rewardOrchResponse is null.");
//			offerWebRequest.setErrCode("Reward Response is null.");
//			offerWebRequest.setError(true);
//			// }else if (rewardOrchResponse.hasErrors()) {
//		} else if (null != rewardOrchResponse && null != rewardOrchResponse.getErrorInfos()) {
//			ErrorInfo errorInfo = (ErrorInfo) rewardOrchResponse.getErrorInfos().getErrorInfo().get(0);
//			log.error("ERRORS SIZE= " + rewardOrchResponse.getErrorInfos().getErrorInfo().size());
//			log.error("ERROR CODE = " + errorInfo.getCode());
//			log.error("ERROR DESCRIPTION = " + errorInfo.getDescription());
//			offerWebRequest.setError(true);
//			offerWebRequest.setErrCode(errorInfo.getCode() + " : " + CATUtil.processErrorCodes(rewardOrchResponse.getErrorInfos().getErrorInfo()));
//		} else {
//			List<Reward> rewardListFromRes = rewardOrchResponse.getRewardList();
//			// if(rewardListFromRes!=null && rewardListFromRes.size() >0)
//
//			if (rewardListFromRes != null) {
//
//				for (int i = 0; i < rewardListFromRes.size(); i++) {
//					Reward reward = rewardListFromRes.get(i);
//					PromotionBean promotionBean = offerFormBean.getPromotionBeans().get(0);
//					RewardBean rewardBean = promotionBean.getRewardBean();
//
//					if (reward.getRewardMKTGStatus() != null)
//						rewardBean.setRewardMKTStatus(reward.getRewardMKTGStatus().toString());
//					if (reward.getRewardRMStatus() != null)
//						rewardBean.setRewardRMStatus(reward.getRewardRMStatus().toString());
//
//				}
//
//			}
//		}
//	}
//
//	protected void createDBMOfferData(Promotion promotion) {
//		List<Campaign> campaignList = new ArrayList<Campaign>();
//
//		Campaign emailCampaign = new Campaign();
//		List<CustomerSet> emailCustomerArray = new ArrayList<CustomerSet>();
//		emailCampaign.setCampaignName("Email");
//
//		CustomerSet customerSet1 = new CustomerSet();
//		customerSet1.setReferenceNumber(12345L);
//		customerSet1.setMemberCount(1000L);
//		emailCustomerArray.add(customerSet1);
//
//		CustomerSet customerSet2 = new CustomerSet();
//		customerSet2.setReferenceNumber(16789L);
//		customerSet2.setMemberCount(3000L);
//		emailCustomerArray.add(customerSet2);
//
//		CustomerSet customerSet3 = new CustomerSet();
//		customerSet3.setReferenceNumber(754568L);
//		customerSet3.setMemberCount(113000L);
//		emailCustomerArray.add(customerSet3);
//
//		emailCampaign.setCustomerSet(emailCustomerArray);
//		campaignList.add(emailCampaign);
//
//		Campaign directCampaign = new Campaign();
//		List<CustomerSet> directCustomerArray = new ArrayList<CustomerSet>();
//		directCampaign.setCampaignName("Direct Mail");
//
//		CustomerSet customerSet4 = new CustomerSet();
//		customerSet4.setReferenceNumber(22222L);
//		customerSet4.setMemberCount(10008778L);
//		directCustomerArray.add(customerSet4);
//
//		CustomerSet customerSet5 = new CustomerSet();
//		customerSet5.setReferenceNumber(3333L);
//		customerSet5.setMemberCount(1367888L);
//		directCustomerArray.add(customerSet5);
//
//		CustomerSet customerSet6 = new CustomerSet();
//		customerSet6.setReferenceNumber(66666L);
//		customerSet6.setMemberCount(15562678L);
//		directCustomerArray.add(customerSet6);
//
//		directCampaign.setCustomerSet(directCustomerArray);
//		campaignList.add(directCampaign);
//
//		Set<Campaign> campaignSet = new HashSet<Campaign>(campaignList);
//
//		promotion.setCampaign(campaignSet);
//	}
//
//}
