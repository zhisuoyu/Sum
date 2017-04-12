package com.zsy.sum;

import com.zsy.sum.BaseHttpEntity;

/**
 * Created by mzs on 2017/4/10.
 */

public class BaseRcEntity extends BaseHttpEntity {

    String siteId;
    String txnCode;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

}
