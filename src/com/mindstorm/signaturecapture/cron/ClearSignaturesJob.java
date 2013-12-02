package com.mindstorm.signaturecapture.cron;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindstorm.signaturecapture.dao.SignatureRecordDAO;


@SuppressWarnings("serial")
public class ClearSignaturesJob extends HttpServlet {
	public static final Logger _logger = Logger.getLogger(ClearSignaturesJob.class.getName());
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			_logger.info("Executing ClearSignaturesJob");
			SignatureRecordDAO.INSTANCE.deleteAll();
			_logger.info("Done executing ClearSignaturesJob");
		}
		catch (Exception ex) {
			_logger.warning("Exception in executing ClearSignaturesJob. Reason : " + ex.getMessage());
		}
	}
}
