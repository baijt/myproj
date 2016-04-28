package berbon.owner.pojo;

/**
 * 下游结算日志
 * @author baijt
 *
 */
public class SettleLog {
	
	/**
	 * 真正结算生成的订单号
	 */
	private String orderId;
	
	/**
	 * 结算后返回的订单号
	 */
	private String returnOrderId;
	
	/**
	 * 下游订单结算号
	 */
	private String settleOrderId;
	
	/**
	 * 下游机构号
	 */
	private String insCode;
	
	/**
	 * 下游商户号
	 */
	private String merCode;
	
	/**
	 * 下游商户名
	 */
	private String merName;
	
	/**
	 * 按照费率计算的手续费
	 */
	private long rateFee;
	
	/**
	 * 结算币种  1 人民币
	 */
	private int currency;
	
	/**
	 * 下游结算金额
	 */
	private long settleAmount;
	
	/**
	 * 下游的结算笔数
	 */
	private long settleNum;
	
	/**
	 * 结算银行卡号
	 */
	private String settlePan;
	
	/**
	 * 结算berbon账户
	 */
	private String settleAcc;
	
	/**
	 * 开户行
	 */
	private String bank;
	
	/**
	 * 业务系统提交时间
	 */
	private String ordTime;
	
	/**
	 * 结算时间
	 */
	private String revTime;
	
	/**
	 * 结算状态 0000=初始化状态 0001=结算钱到银行卡成功 0002=失败
	 */
	private String orderStat;

	/**
	 * 结算状态描述
	 */
	private String orderDesc;
	
	/**
	 * 审核人
	 */
	private String auditPerson;
	
	/**
	 * 审核时间
	 */
	private String auditTime;
	
	/**
	 * 0 表示未拆， 1 拆单
	 */
	private int dismantle;
	
	/**
	 * 0 表示未重新处理  1 表示重新处理订单
	 */
	private int rehandled;
	
	/**
	 * 1 表示结算到银行卡 2 表示结算到berbon账号
	 */
	private int settleWay;
	
	/**
	 * 标识是商户结算还是机构结算
	 * 1=商户结算，2=机构结算
	 */
	private int ownership;
	
	
	private int settleStyle;   //结算方式   0 T+0,1 T+1
	
	public String getSettleOrderId() {
		return settleOrderId;
	}

	public void setSettleOrderId(String settleOrderId) {
		this.settleOrderId = settleOrderId;
	}

	public String getReturnOrderId() {
		return returnOrderId;
	}

	public void setReturnOrderId(String returnOrderId) {
		this.returnOrderId = returnOrderId;
	}

	public String getInsCode() {
		return insCode;
	}

	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}

	public String getMerCode() {
		return merCode;
	}

	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public long getRateFee() {
		return rateFee;
	}

	public void setRateFee(long rateFee) {
		this.rateFee = rateFee;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public long getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(long settleAmount) {
		this.settleAmount = settleAmount;
	}

	public long getSettleNum() {
		return settleNum;
	}

	public void setSettleNum(long settleNum) {
		this.settleNum = settleNum;
	}

	public String getSettlePan() {
		return settlePan;
	}

	public void setSettlePan(String settlePan) {
		this.settlePan = settlePan;
	}

	public String getSettleAcc() {
		return settleAcc;
	}

	public void setSettleAcc(String settleAcc) {
		this.settleAcc = settleAcc;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getOrdTime() {
		return ordTime;
	}

	public void setOrdTime(String ordTime) {
		this.ordTime = ordTime;
	}

	public String getRevTime() {
		return revTime;
	}

	public void setRevTime(String revTime) {
		this.revTime = revTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStat() {
		return orderStat;
	}

	public void setOrderStat(String orderStat) {
		this.orderStat = orderStat;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getAuditPerson() {
		return auditPerson;
	}

	public void setAuditPerson(String auditPerson) {
		this.auditPerson = auditPerson;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}

	public int getDismantle() {
		return dismantle;
	}

	public void setDismantle(int dismantle) {
		this.dismantle = dismantle;
	}

	public int getRehandled() {
		return rehandled;
	}

	public void setRehandled(int rehandled) {
		this.rehandled = rehandled;
	}
	public int getSettleWay() {
		return settleWay;
	}

	public void setSettleWay(int settleWay) {
		this.settleWay = settleWay;
	}

	public int getOwnership() {
		return ownership;
	}

	public void setOwnership(int ownership) {
		this.ownership = ownership;
	}

	public int getSettleStyle() {
		return settleStyle;
	}

	public void setSettleStyle(int settleStyle) {
		this.settleStyle = settleStyle;
	}

	@Override
	public String toString() {
		return "SettleLog [orderId=" + orderId + ", returnOrderId=" + returnOrderId + ", settleOrderId=" + settleOrderId + ", insCode=" + insCode
				+ ", merCode=" + merCode + ", merName=" + merName + ", rateFee=" + rateFee + ", currency=" + currency + ", settleAmount=" + settleAmount
				+ ", settleNum=" + settleNum + ", settlePan=" + settlePan + ", settleAcc=" + settleAcc + ", bank=" + bank + ", ordTime=" + ordTime
				+ ", revTime=" + revTime + ", orderStat=" + orderStat + ", orderDesc=" + orderDesc + ", auditPerson=" + auditPerson + ", auditTime="
				+ auditTime + ", dismantle=" + dismantle + ", rehandled=" + rehandled + ", settleWay=" + settleWay + ", ownership=" + ownership
				+ ", settleStyle=" + settleStyle + "]";
	}

	
	

}
