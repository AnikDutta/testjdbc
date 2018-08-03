package com.rci.cat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_EMPTY)
public class UserInfoModel implements Serializable
{
	
	private static final long serialVersionUID = 6588604606762249181L;
	String userID;
	Map<String,String> userGroupMap;
	String userRegion;
	String userRegionStr;
	Map<String,String> regions;
	String [] userRoles;
	List<String> userCapabilities;
	
	//These are set in LoginViewHelper based on the authorization for the user
	boolean allowCreateBtn;
	boolean allowPushBtn;
	boolean allowSubmitBtn;
	boolean allowApproveBtn;
	boolean allowRejectBtn;
	boolean allowUpdateBtn;
	boolean allowViewBtn;
	boolean allowSaveBtn;
	boolean allowUpdateLiveOfferBtn;
	boolean allowInactiveBtn;
	boolean allowPreviewBtn;
	boolean allowSearchBtn;
	boolean allowCopyBtn;
	boolean allowUploadResortList;
	boolean allowUploadTranslation;
	String errorCode;
	
	//These are set in the CATUtil based on the Offer/Promotion/Reward status.
	boolean allowPushBtnByStatus = false;
	boolean allowSubmitBtnByStatus = false;
	boolean allowApproveBtnByStatus = false;
	boolean allowRejectBtnByStatus = false;
	boolean allowActivateBtnByStatus = false;
	boolean allowDBMRejectOptionByStatus = false;
	boolean allowUpdateLiveBtnByStatus = false;
	
	//MOOR-India addition: A user can belong to multiple groups
	Map<String,UserRoleBean> userGrpRoleMap;
	
	
	
	public UserInfoModel() {
		super();
	}
	public UserInfoModel(String userID, Map<String, String> userGroupMap, String userRegion, String userRegionStr,
			Map<String, String> regions, String[] userRoles, List<String> userCapabilities, boolean allowCreateBtn,
			boolean allowPushBtn, boolean allowSubmitBtn, boolean allowApproveBtn, boolean allowRejectBtn,
			boolean allowUpdateBtn, boolean allowViewBtn, boolean allowSaveBtn, boolean allowUpdateLiveOfferBtn,
			boolean allowInactiveBtn, boolean allowPreviewBtn, boolean allowSearchBtn, boolean allowCopyBtn,
			boolean allowUploadResortList, boolean allowUploadTranslation, String errorCode,
			boolean allowPushBtnByStatus, boolean allowSubmitBtnByStatus, boolean allowApproveBtnByStatus,
			boolean allowRejectBtnByStatus, boolean allowActivateBtnByStatus, boolean allowDBMRejectOptionByStatus,
			boolean allowUpdateLiveBtnByStatus, Map<String, UserRoleBean> userGrpRoleMap) {
		super();
		this.userID = userID;
		this.userGroupMap = userGroupMap;
		this.userRegion = userRegion;
		this.userRegionStr = userRegionStr;
		this.regions = regions;
		this.userRoles = userRoles;
		this.userCapabilities = userCapabilities;
		this.allowCreateBtn = allowCreateBtn;
		this.allowPushBtn = allowPushBtn;
		this.allowSubmitBtn = allowSubmitBtn;
		this.allowApproveBtn = allowApproveBtn;
		this.allowRejectBtn = allowRejectBtn;
		this.allowUpdateBtn = allowUpdateBtn;
		this.allowViewBtn = allowViewBtn;
		this.allowSaveBtn = allowSaveBtn;
		this.allowUpdateLiveOfferBtn = allowUpdateLiveOfferBtn;
		this.allowInactiveBtn = allowInactiveBtn;
		this.allowPreviewBtn = allowPreviewBtn;
		this.allowSearchBtn = allowSearchBtn;
		this.allowCopyBtn = allowCopyBtn;
		this.allowUploadResortList = allowUploadResortList;
		this.allowUploadTranslation = allowUploadTranslation;
		this.errorCode = errorCode;
		this.allowPushBtnByStatus = allowPushBtnByStatus;
		this.allowSubmitBtnByStatus = allowSubmitBtnByStatus;
		this.allowApproveBtnByStatus = allowApproveBtnByStatus;
		this.allowRejectBtnByStatus = allowRejectBtnByStatus;
		this.allowActivateBtnByStatus = allowActivateBtnByStatus;
		this.allowDBMRejectOptionByStatus = allowDBMRejectOptionByStatus;
		this.allowUpdateLiveBtnByStatus = allowUpdateLiveBtnByStatus;
		this.userGrpRoleMap = userGrpRoleMap;
	}
	public Map<String, UserRoleBean> getUserGrpRoleMap() {
		return userGrpRoleMap;
	}
	public void setUserGrpRoleMap(Map<String, UserRoleBean> userGrpRoleMap) {
		this.userGrpRoleMap = userGrpRoleMap;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Map<String,String> getUserGroupMap() {
		return userGroupMap;
	}
	public void setUserGroupMap(Map<String,String> groupMap) {
		this.userGroupMap = groupMap;
	}
	
	public Map<String,String> getRegions() {
		return regions;
	}
	public void setRegions(Map<String,String> regions) {
		this.regions = regions;
	}
	
	public String getUserRegion() {
		return userRegion;
	}
	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}
	public String getUserRegionStr() {
		return userRegionStr;
	}
	public void setUserRegionStr(String userRegionStr) {
		this.userRegionStr = userRegionStr;
	}
	public String[] getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(String[] userRoles) {
		this.userRoles = userRoles;
	}

	public boolean isAllowCreateBtn() {
		return allowCreateBtn;
	}
	public void setAllowCreateBtn(boolean allowCreateBtn) {
		this.allowCreateBtn = allowCreateBtn;
	}
	public boolean isAllowPushBtn() {
		return allowPushBtn;
	}
	public void setAllowPushBtn(boolean allowPushBtn) {
		this.allowPushBtn = allowPushBtn;
	}
	public boolean isAllowSubmitBtn() {
		return allowSubmitBtn;
	}
	public void setAllowSubmitBtn(boolean allowSubmitBtn) {
		this.allowSubmitBtn = allowSubmitBtn;
	}
	public boolean isAllowApproveBtn() {
		return allowApproveBtn;
	}
	public void setAllowApproveBtn(boolean allowApproveBtn) {
		this.allowApproveBtn = allowApproveBtn;
	}
	public boolean isAllowRejectBtn() {
		return allowRejectBtn;
	}
	public void setAllowRejectBtn(boolean allowRejectBtn) {
		this.allowRejectBtn = allowRejectBtn;
	}
	public boolean isAllowUpdateBtn() {
		return allowUpdateBtn;
	}
	public void setAllowUpdateBtn(boolean allowUpdateBtn) {
		this.allowUpdateBtn = allowUpdateBtn;
	}
	public boolean isAllowViewBtn() {
		return allowViewBtn;
	}
	public void setAllowViewBtn(boolean allowViewBtn) {
		this.allowViewBtn = allowViewBtn;
	}
	public boolean isAllowSaveBtn() {
		return allowSaveBtn;
	}
	public void setAllowSaveBtn(boolean allowSaveBtn) {
		this.allowSaveBtn = allowSaveBtn;
	}
	public boolean isAllowUpdateLiveOfferBtn() {
		return allowUpdateLiveOfferBtn;
	}
	public void setAllowUpdateLiveOfferBtn(boolean allowUpdateLiveOfferBtn) {
		this.allowUpdateLiveOfferBtn = allowUpdateLiveOfferBtn;
	}
	public boolean isAllowInactiveBtn() {
		return allowInactiveBtn;
	}
	public void setAllowInactiveBtn(boolean allowInactiveBtn) {
		this.allowInactiveBtn = allowInactiveBtn;
	}
	public boolean isAllowPreviewBtn() {
		return allowPreviewBtn;
	}
	public void setAllowPreviewBtn(boolean allowPreviewBtn) {
		this.allowPreviewBtn = allowPreviewBtn;
	}
	public boolean isAllowSearchBtn() {
		return allowSearchBtn;
	}
	public void setAllowSearchBtn(boolean allowSearchBtn) {
		this.allowSearchBtn = allowSearchBtn;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public List<String> getUserCapabilities() {
		return userCapabilities;
	}
	public void setUserCapabilities(List<String> userCapabilities) {
		this.userCapabilities = userCapabilities;
	}
	
	public boolean isAllowCopyBtn() {
		return allowCopyBtn;
	}
	public void setAllowCopyBtn(boolean allowCopyBtn) {
		this.allowCopyBtn = allowCopyBtn;
	}
	public boolean isAllowUploadResortList() {
		return allowUploadResortList;
	}
	public void setAllowUploadResortList(boolean allowUploadResortList) {
		this.allowUploadResortList = allowUploadResortList;
	}
	public boolean isAllowUploadTranslation() {
		return allowUploadTranslation;
	}
	public void setAllowUploadTranslation(boolean allowUploadTranslation) {
		this.allowUploadTranslation = allowUploadTranslation;
	}
	
	public boolean isAllowPushBtnByStatus() {
		return allowPushBtnByStatus;
	}
	public void setAllowPushBtnByStatus(boolean allowPushBtnByStatus) {
		this.allowPushBtnByStatus = allowPushBtnByStatus;
	}
	public boolean isAllowSubmitBtnByStatus() {
		return allowSubmitBtnByStatus;
	}
	public void setAllowSubmitBtnByStatus(boolean allowSubmitBtnByStatus) {
		this.allowSubmitBtnByStatus = allowSubmitBtnByStatus;
	}
	public boolean isAllowApproveBtnByStatus() {
		return allowApproveBtnByStatus;
	}
	public void setAllowApproveBtnByStatus(boolean allowApproveBtnByStatus) {
		this.allowApproveBtnByStatus = allowApproveBtnByStatus;
	}
	public boolean isAllowRejectBtnByStatus() {
		return allowRejectBtnByStatus;
	}
	public void setAllowRejectBtnByStatus(boolean allowRejectBtnByStatus) {
		this.allowRejectBtnByStatus = allowRejectBtnByStatus;
	}
	public boolean isAllowActivateBtnByStatus() {
		return allowActivateBtnByStatus;
	}
	public void setAllowActivateBtnByStatus(boolean allowActivateBtnByStatus) {
		this.allowActivateBtnByStatus = allowActivateBtnByStatus;
	}
	public boolean isAllowDBMRejectOptionByStatus() {
		return allowDBMRejectOptionByStatus;
	}
	public void setAllowDBMRejectOptionByStatus(boolean allowDBMRejectOptionByStatus) {
		this.allowDBMRejectOptionByStatus = allowDBMRejectOptionByStatus;
	}
	public boolean isAllowUpdateLiveBtnByStatus() {
		return allowUpdateLiveBtnByStatus;
	}
	public void setAllowUpdateLiveBtnByStatus(boolean allowUpdateLiveBtnByStatus) {
		this.allowUpdateLiveBtnByStatus = allowUpdateLiveBtnByStatus;
	}

}
