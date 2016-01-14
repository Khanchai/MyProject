package unittest;

import java.awt.Button;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JFrame;

import test.InitialDataOnFileForTest;
import th.co.ais.ssb.dto.LogInfoDto;
import th.co.ais.ssb.dto.response.bos.DoQueryCDRResponse;
import th.co.ais.ssb.dto.response.bos.DoQueryResponse;
import th.co.ais.ssb.util.DateUtil;
import th.co.ais.ssb.util.EqxStringUtils;
import th.co.ais.ssb.util.SymetricCrypto;
import th.co.ais.ssb.util.currentpackage.CurrentPackageBosUtils;
import th.co.ais.ssb.ws.BOSWs;
import th.co.ais.ssb.ws.EAIWs;
import th.co.ais.ssb.wsclient.eai.GetAccountBalanceResponseMsg;

public class TestMyProject extends JFrame {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36";
	private static final String CONTENT_TYPE_XML = "text/xml; charset=utf-8";
	private static final String CONTENT_TYPE_JSON= "application/json;charset=utf-8";
	private static final String HEADER_CONTENT_TYPE = "Content-Type";
	private static final String HEADER_MSISDN = "x-ssb-msisdn";
	private static final String HEADER_LANGUAGE = "x-ssb-language";
	private static final String HEADER_AUDIT_LOG = "x-ssb-audit-id";
	private static final String HEADER_USER_AGENT = "User-Agent";
	
	private static final String URL_LOGIN = "http://$HOST/mobile/$MOBILENO/login";
	private static final String URL_GET_PROFILE = "http://$HOST/mobile/$MOBILENO/profile/summary.json";
	private static final String URL_TOPUP = "http://$HOST/mobile/$MOBILENO/payments/ipay/pay";
	private static final String URL_CQS_C = "http://$HOST/mobile/$MOBILENO/usages/unbilled/chargesummary?period=current";
	private static final String URL_CQS_P = "http://$HOST/mobile/$MOBILENO/usages/unbilled/chargesummary?period=previous";
	
	private static final String URL_CDR_NON_BOS = "http://$HOST/mobile/$MOBILENO/usages/unbilled/chargedetail/filter";
	
	private static final String URL_CQS_CDR = "http://$HOST/mobile/$MOBILENO/usages/unbilled/chargedetail/filter";
	
	private static final String URL_LUCKY = "http://$HOST/mobile/$MOBILENO/getLuckyPromotion";
	
	private static final String URL_MY_PKG_INFO = "http://$HOST/mobile/$MOBILENO/mypackageinfo";
	
	private static final String URL_ISWOP_PRE = "http://$HOST/mobile/$MOBILENO/iswop";
	private static final String URL_ISWOP_CDR_PRE = "http://$HOST/mobile/$MOBILENO/usages/prepaid/group/SWOP/chargedetail/filter";
	
	private static final String URL_CDR_VOICE = "http://$HOST/mobile/$MOBILENO/usages/billed/group/VOICE/chargedetail/filter";
	
	private static final String POST_URL = "http://10.252.163.170:35065/mobile/0935850250/login";
	private static final String HOST = "http://10.252.163.170:35065";

	public static void main(String[] args) throws Exception  {
		
		// SWOP
//		String mobileNo = "0933304059";
		//String mobileNo = "0935850241";
		//String encryptKey = "HelloWorld";
		//String lang = "EN";
//		String host = "10.252.163.171:8082";
		String host = "10.252.163.170:35075";
		
		String parameterBody = "";
		String targetURL = "";
		String auditLogId = "34957";
		
		try {
			
//			targetURL = URL_LOGIN.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//			parameterBody = getSecret(mobileNo, encryptKey, auditLogId);
//			sendPOST(targetURL, mobileNo, encryptKey, lang, auditLogId ,parameterBody);
			
			// LOGIN FLOW
			Integer rtnCodeLogin = getLogin(URL_LOGIN, mobileNo, encryptKey, lang, auditLogId, host);
//			if (200 == rtnCodeLogin){
//				// mypackageinfo
//				System.out.println("=====|> MY_PACKAGE_INFO");
//				targetURL = URL_CQS_C.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//				sendGET(targetURL, mobileNo, lang, auditLogId);
//			} else {
//				System.out.println("Login FAIL !!! ECODE : " + rtnCodeLogin);
//			}
			
			//parameterBody =	"{\"eventSeq\":\"70\",\"usageCode\":\"G^INT2\",\"periodStartCode\":\"2015-11-28T00:00:00\",\"periodEndCode\":\"2015-12-11T10:38:56\",\"segType\":\"0\",\"vpnCallType\":\"0\",\"distanceType\":\"0\",\"networkType\":\"0\",\"isInternet\":true}";
			//targetURL = URL_ISWOP_CDR_PRE.replace("$MOBILENO", mobileNo).replace("$HOST", host);
			//sendGET(targetURL, mobileNo, lang, auditLogId);
			
//			parameterBody =	"{startDate: \"07/12/2015\", endDate: \"05/01/2016\", isViewAll: true, groupCode: \"SWOP\"}";
//			targetURL = URL_ISWOP_CDR_PRE.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//			sendPOST(targetURL, mobileNo,null, lang, auditLogId, parameterBody);
			
			// cdr irb nonbos
//			parameterBody =	"{\"eventSeq\":\"150116000|150116000\",\"usageCode\":\"64^1|64^2\",\"isInternet\":true}\r\n\r\n";
//			parameterBody =	"{\"eventSeq\":\"30\",\"usageCode\":\"T^AMTS3\",\"periodStartCode\":\"2015-11-30T10:23:27\",\"periodEndCode\":\"2015-12-01T17:16:55\",\"segType\":\"0\",\"vpnCallType\":\"0\",\"distanceType\":\"0\",\"networkType\":\"0\"}";
//			targetURL = URL_CDR_NON_BOS.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//			sendPOST(targetURL, mobileNo, null, lang, auditLogId ,parameterBody);
			
//			parameterBody =	"{\"eventSeq\":\"70\",\"usageCode\":\"G^INT2\",\"periodStartCode\":\"2015-11-28T00:00:00\",\"periodEndCode\":\"2015-12-11T10:38:56\",\"segType\":\"0\",\"vpnCallType\":\"0\",\"distanceType\":\"0\",\"networkType\":\"0\",\"isInternet\":true}";
//			targetURL = URL_CQS_CDR.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//			sendPOST(targetURL, mobileNo, null, lang, auditLogId ,parameterBody);
			
			// LuckyPromotion
//			parameterBody =	"{\"customerActionType\":\"2\",\"classifyCodeSelect\":\"Normal\"}";
//			targetURL = URL_LUCKY.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//			sendPOST(targetURL, mobileNo, null, lang, auditLogId ,parameterBody);
			
			// mypackageinfo
//			targetURL = URL_MY_PKG_INFO.replace("$MOBILENO", mobileNo).replace("$HOST", host);
//			sendPOST(targetURL, mobileNo, null, lang, auditLogId ,parameterBody);
			
//			sendGET(targetURL, mobileNo, lang, auditLogId);
			
			parameterBody =	"{isViewAll: true, invoiceNumber: \"W-IN-12-5901-1000001\", groupCode: \"VOICE\"}";
			targetURL = URL_CDR_VOICE.replace("$MOBILENO", mobileNo).replace("$HOST", host);
			sendPOST(targetURL, mobileNo,null, lang, auditLogId, parameterBody);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static Integer sendPOST(String urlStr, String mobileNo, String encryptKey, String language, String auditId, String parameterBody) throws IOException {
		Integer responseCode = null;
		try {
			URL obj = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty(HEADER_USER_AGENT, USER_AGENT);
			con.setRequestProperty(HEADER_AUDIT_LOG, auditId);
			con.setRequestProperty(HEADER_CONTENT_TYPE, CONTENT_TYPE_XML);
			con.setRequestProperty(HEADER_MSISDN, getMsisdn(mobileNo));
			con.setRequestProperty(HEADER_LANGUAGE, language);
			con.setConnectTimeout(60);

//			if (encryptKey != null && !encryptKey.isEmpty()) {
				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
				os.write(parameterBody.getBytes());
				os.flush();
				os.close();
//			}
			
			responseCode = con.getResponseCode();
			System.out.println("POST Response Code :> " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
			} else {
				System.out.println("POST request not worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseCode;
	}

	private static void sendGET(String urlStr, String mobileNo, String language, String auditId) throws IOException {
		
		try {
			   URL obj = new URL(urlStr);
		        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		        con.setRequestMethod("GET");
				con.setRequestProperty(HEADER_USER_AGENT, USER_AGENT);
				con.setRequestProperty(HEADER_AUDIT_LOG, auditId);
				con.setRequestProperty(HEADER_CONTENT_TYPE, CONTENT_TYPE_XML);
				con.setRequestProperty(HEADER_MSISDN, getMsisdn(mobileNo));
				con.setRequestProperty(HEADER_LANGUAGE, language);
				con.setConnectTimeout(60);
				
		        int responseCode = con.getResponseCode();
		        String responseMessage = con.getResponseMessage();
		        System.out.println("GET Response Code :> " + responseCode);
		        System.out.println("GET Response Message :> " + responseMessage);
		        if (responseCode == HttpURLConnection.HTTP_OK) { 
		            BufferedReader in = new BufferedReader(new InputStreamReader(
		                    con.getInputStream()));
		            String inputLine;
		            StringBuffer response = new StringBuffer();
		 
		            while ((inputLine = in.readLine()) != null) {
		                response.append(inputLine);
		            }
		            in.close();
		 
		            // print result
		            System.out.println(response.toString());
		        } else {
		            System.out.println("GET request not worked");
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	private static String getSecret(String mobileNo, String encryptKey, String auditId) {
		String strEncrypt = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:hh.ss", Locale.US);
			String curDate = sdf.format(new Date(System.currentTimeMillis()));
			String clientIP = "10.239.12.22";
			String businessType = "POSTPAID3G";

			String strData = "{\"timestamp\":\""
					+ curDate
					+ "\",\"auditLog\":{\"auditLogId\":"+auditId+",\"loginIp\":\""
					+ clientIP
					+ "\",\"sessionId\":\"rzDFJ4GVyJy0KCkK3D2GBnjv7FqWrfLHPKvGHhTqYK4Qh6LN9q0n!-2114134105!1425540213012\",\"loginChannel\":\"eService\",\"browser\":\"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36\",\"logoutChannel\":\"eService\",\"loginDate\":\"2015-03-05 14:25:27.164\",\"businessType\":\""
					+ businessType
					+ "\",\"logoutDate\":\"2015-03-05 14:25:27.164\",\"loginSuccessFlag\":\"F\",\"mobileNo\":\""
					+ mobileNo
					+ "\"},\"lastLoginDate\":\"2015-03-05 14:22:13.0\",\"sessionId\":\"rzDFJ4GVyJy0KCkK3D2GBnjv7FqWrfLHPKvGHhTqYK4Qh6LN9q0n!-2114134105!1425540213012\",\"businessType\":\"POSTPAID3G\",\"language\":\"TH\",\"mobileNumber\":\""
					+ mobileNo + "\",\"redirectUrl\":\"logindataRecieve.do\"}";
			String strLoginSecret = SymetricCrypto.encrypt(encryptKey, strData);

			strEncrypt = "{\"secret\":\"" + strLoginSecret + "\"}";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return strEncrypt;
	}

	private static String getMsisdn(String strMobile) {
		String rtnMsisdn = null;
		if ((strMobile != null) && (strMobile.length() > 0)) {
			rtnMsisdn = "66" + strMobile.substring(1, strMobile.length());
		}
		return rtnMsisdn;
	}
	
	private static Integer getLogin(String urlStr, String mobileNo, String encryptKey, String language, String auditId, String host) throws IOException {
		Integer rtnCode = null;
		try {
			String targetURL = urlStr.replace("$MOBILENO", mobileNo).replace("$HOST", host);
			String parameterBody = getSecret(mobileNo, encryptKey, auditId);
			rtnCode = sendPOST(targetURL, mobileNo, encryptKey, language, auditId ,parameterBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnCode;
	}
	
	public static void Initi(){
		String filePath = "D://initial_khun.txt";
		String content;
		try {
			content = InitialDataOnFileForTest.prepareContent(filePath);
			InitialDataOnFileForTest.setInitialData(null, content);
			System.out.println("================== INITIAL FILE SUCCESS =====================");

			System.out.println("================== START FUNCTION =====================");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
