package com.citrusbits.hassan.icleanreloaded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponseData {

    @SerializedName("ic_user_id")
    @Expose
    private Integer icUserId;
    @SerializedName("ic_name")
    @Expose
    private String icName;
    @SerializedName("ic_email")
    @Expose
    private String icEmail;
    @SerializedName("ic_phone")
    @Expose
    private String icPhone;
    @SerializedName("ic_zip")
    @Expose
    private String icZip;
    @SerializedName("ic_type")
    @Expose
    private String icType;
    @SerializedName("authorization")
    @Expose
    private String authorization;
    @SerializedName("ic_promocode")
    @Expose
    private String icPromocode;

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
     * The icName
     */
    public String getIcName() {
        return icName;
    }

    /**
     *
     * @param icName
     * The ic_name
     */
    public void setIcName(String icName) {
        this.icName = icName;
    }

    /**
     *
     * @return
     * The icEmail
     */
    public String getIcEmail() {
        return icEmail;
    }

    /**
     *
     * @param icEmail
     * The ic_email
     */
    public void setIcEmail(String icEmail) {
        this.icEmail = icEmail;
    }

    /**
     *
     * @return
     * The icPhone
     */
    public String getIcPhone() {
        return icPhone;
    }

    /**
     *
     * @param icPhone
     * The ic_phone
     */
    public void setIcPhone(String icPhone) {
        this.icPhone = icPhone;
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
     * The icType
     */
    public String getIcType() {
        return icType;
    }

    /**
     *
     * @param icType
     * The ic_type
     */
    public void setIcType(String icType) {
        this.icType = icType;
    }

    /**
     *
     * @return
     * The authorization
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     *
     * @param authorization
     * The authorization
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     *
     * @return
     * The icPromocode
     */
    public String getIcPromocode() {
        return icPromocode;
    }

    /**
     *
     * @param icPromocode
     * The ic_promocode
     */
    public void setIcPromocode(String icPromocode) {
        this.icPromocode = icPromocode;
    }

}

