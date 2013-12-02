package com.mindstorm.signaturecapture.dao;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Text;
import com.mindstorm.signaturecapture.entity.SignatureRecord;
import com.mindstorm.signaturecapture.utils.PMF;

public enum SignatureRecordDAO {
	INSTANCE;
	public List<SignatureRecord> getSignatureRecords() {
		List<SignatureRecord> SignatureRecords;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(SignatureRecord.class);
		try {
			SignatureRecords = (List<SignatureRecord>) query.execute();
			System.out.println("Number of SignatureRecords: " + SignatureRecords.size());
        } finally {
            pm.close();
        }

		return (SignatureRecords);
	}
	
	public Long add(String receiverName, 
			        String signature) {
		
		SignatureRecord _record = new SignatureRecord();
		_record.setReceiverName(receiverName);
		_record.setSignature(new Text(signature));
		_record.setLastUpdate(new Date());
		synchronized (this) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
	            pm.makePersistent(_record);
	        } finally {
	            pm.close();
	        }
		}
		
		return (_record.getSignatureID().getId());
	}
	
	public void deleteAll() {
		List<SignatureRecord> SignatureRecords;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(SignatureRecord.class);
		try {
			SignatureRecords = (List<SignatureRecord>) query.execute();
			pm.deletePersistentAll(SignatureRecords);
        } finally {
            pm.close();
        }
	}
}
