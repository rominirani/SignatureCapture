package com.mindstorm.signaturecapture.entity;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable(detachable = "true")
public class SignatureRecord {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key signatureID;
	@Persistent
	private String receiverName;
	@Persistent
	Text signature;
	@Persistent
	Date lastUpdate;

	public Key getSignatureID() {
		return signatureID;
	}

	public void setSignatureID(Key signatureID) {
		this.signatureID = signatureID;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Text getSignature() {
		return signature;
	}

	public void setSignature(Text signature) {
		this.signature = signature;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
