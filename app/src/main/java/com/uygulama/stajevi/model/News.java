/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uygulama.stajevi.model;

/**
 *
 * @author arnold
 */
public class News {
  private int NewsID;
  private String NewsTitle;
  private String NewsShortTitle;
  private String NewsDescription;
  private String NewsStartDate;
  private String NewsEndDate;
  private boolean NewsActive;
  private String NewsCreateUserId;
  private String TitleSourceUrl;
  private int TitleType;
  private int NewsType;

    /**
     * @return the NewsID
     */
    public int getNewsID() {
        return NewsID;
    }

    /**
     * @param NewsID the NewsID to set
     */
    public void setNewsID(int NewsID) {
        this.NewsID = NewsID;
    }

    /**
     * @return the NewsTitle
     */
    public String getNewsTitle() {
        return NewsTitle;
    }

    /**
     * @param NewsTitle the NewsTitle to set
     */
    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }

    /**
     * @return the NewsShortTitle
     */
    public String getNewsShortTitle() {
        return NewsShortTitle;
    }

    /**
     * @param NewsShortTitle the NewsShortTitle to set
     */
    public void setNewsShortTitle(String NewsShortTitle) {
        this.NewsShortTitle = NewsShortTitle;
    }

    /**
     * @return the NewsDescription
     */
    public String getNewsDescription() {
        return NewsDescription;
    }

    /**
     * @param NewsDescription the NewsDescription to set
     */
    public void setNewsDescription(String NewsDescription) {
        this.NewsDescription = NewsDescription;
    }

    /**
     * @return the NewsStartDate
     */
    public String getNewsStartDate() {
        return NewsStartDate;
    }

    /**
     * @param NewsStartDate the NewsStartDate to set
     */
    public void setNewsStartDate(String NewsStartDate) {
        this.NewsStartDate = NewsStartDate;
    }

    /**
     * @return the NewsEndDate
     */
    public String getNewsEndDate() {
        return NewsEndDate;
    }

    /**
     * @param NewsEndDate the NewsEndDate to set
     */
    public void setNewsEndDate(String NewsEndDate) {
        this.NewsEndDate = NewsEndDate;
    }

    /**
     * @return the NewsActive
     */
    public boolean isNewsActive() {
        return NewsActive;
    }

    /**
     * @param NewsActive the NewsActive to set
     */
    public void setNewsActive(boolean NewsActive) {
        this.NewsActive = NewsActive;
    }

    /**
     * @return the NewsCreateUserId
     */
    public String getNewsCreateUserId() {
        return NewsCreateUserId;
    }

    /**
     * @param NewsCreateUserId the NewsCreateUserId to set
     */
    public void setNewsCreateUserId(String NewsCreateUserId) {
        this.NewsCreateUserId = NewsCreateUserId;
    }

    /**
     * @return the TitleSourceUrl
     */
    public String getTitleSourceUrl() {
        return TitleSourceUrl;
    }

    /**
     * @param TitleSourceUrl the TitleSourceUrl to set
     */
    public void setTitleSourceUrl(String TitleSourceUrl) {
        this.TitleSourceUrl = TitleSourceUrl;
    }

    /**
     * @return the TitleType
     */
    public int getTitleType() {
        return TitleType;
    }

    /**
     * @param TitleType the TitleType to set
     */
    public void setTitleType(int TitleType) {
        this.TitleType = TitleType;
    }

    /**
     * @return the NewsType
     */
    public int getNewsType() {
        return NewsType;
    }

    /**
     * @param NewsType the NewsType to set
     */
    public void setNewsType(int NewsType) {
        this.NewsType = NewsType;
    }
}
