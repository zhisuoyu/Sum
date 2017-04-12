package com.zsy.sum;

/**
 * Created by mzs on 2017/4/10.
 */

public class ConsumeEntity extends BaseRcEntity {

    private String operatorId;
    private String amount;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ConsumeEntity{" +
                "code=" + code +
                ", msg=" + msg +
                "siteId='" + siteId + '\'' +
                ", txnCode='" + txnCode + '\'' +
                "operatorId='" + operatorId + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
