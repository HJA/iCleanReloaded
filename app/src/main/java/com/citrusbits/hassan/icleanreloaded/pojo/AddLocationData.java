package com.citrusbits.hassan.icleanreloaded.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddLocationData {

    @SerializedName("ic_userLocation_id")
    @Expose
    private Integer icUserLocationId;
    @SerializedName("ic_user_id")
    @Expose
    private Integer icUserId;
    @SerializedName("ic_locationName")
    @Expose
    private String icLocationName;
    @SerializedName("ic_address1")
    @Expose
    private String icAddress1;
    @SerializedName("ic_address2")
    @Expose
    private String icAddress2;
    @SerializedName("ic_city")
    @Expose
    private String icCity;
    @SerializedName("ic_zip")
    @Expose
    private String icZip;
    @SerializedName("ic_state")
    @Expose
    private String icState;

    /**
     *
     * @return
     * The icUserLocationId
     */
    public Integer getIcUserLocationId() {
        return icUserLocationId;
    }

    /**
     *
     * @param icUserLocationId
     * The ic_userLocation_id
     */
    public void setIcUserLocationId(Integer icUserLocationId) {
        this.icUserLocationId = icUserLocationId;
    }

    /**
     *
     * @return
     * The icUserId
     */
    public Integer getIcUserId() {
        return icUserId;
    }

    /**
     *
     * @param icUserId
     * The ic_user_id
     */
    public void setIcUserId(Integer icUserId) {
        this.icUserId = icUserId;
    }

    /**
     *
     * @return
     * The icLocationName
     */
    public String getIcLocationName() {
        return icLocationName;
    }

    /**
     *
     * @param icLocationName
     * The ic_locationName
     */
    public void setIcLocationName(String icLocationName) {
        this.icLocationName = icLocationName;
    }

    /**
     *
     * @return
     * The icAddress1
     */
    public String getIcAddress1() {
        return icAddress1;
    }

    /**
     *
     * @param icAddress1
     * The ic_address1
     */
    public void setIcAddress1(String icAddress1) {
        this.icAddress1 = icAddress1;
    }

    /**
     *
     * @return
     * The icAddress2
     */
    public String getIcAddress2() {
        return icAddress2;
    }

    /**
     *
     * @param icAddress2
     * The ic_address2
     */
    public void setIcAddress2(String icAddress2) {
        this.icAddress2 = icAddress2;
    }

    /**
     *
     * @return
     * The icCity
     */
    public String getIcCity() {
        return icCity;
    }

    /**
     *
     * @param icCity
     * The ic_city
     */
    public void setIcCity(String icCity) {
        this.icCity = icCity;
    }

    /**
     *
     * @return
     * The icZip
     */
    public String getIcZip() {
        return icZip;
    }

    /**
     *
     * @param icZip
     * The ic_zip
     */
    public void setIcZip(String icZip) {
        this.icZip = icZip;
    }

    /**
     *
     * @return
     * The icState
     */
    public String getIcState() {
        return icState;
    }

    /**
     *
     * @param icState
     * The ic_state
     */
    public void setIcState(String icState) {
        this.icState = icState;
    }

}


