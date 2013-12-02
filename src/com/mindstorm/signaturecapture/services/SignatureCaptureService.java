package com.mindstorm.signaturecapture.services;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.*;

import com.mindstorm.signaturecapture.dao.SignatureRecordDAO;
import com.mindstorm.signaturecapture.utils.AppException;

@SuppressWarnings("serial")
public class SignatureCaptureService extends HttpServlet {
	public static final Logger _logger = Logger.getLogger(SignatureCaptureService.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		_logger.info("GET not supported");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String receiverName = req.getParameter("receiverName");
		String signature = req.getParameter("signature");
		//Do some validation here, but we will leave this for now
			SignatureRecordDAO.INSTANCE.add(receiverName, signature);
			resp.sendRedirect("list.jsp");
	}
}
