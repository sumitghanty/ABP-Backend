package com.mazars.in.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mazars.in.model.transactionmodel.MasterResponseModel;

@Component
public class GenericPostAndGet {

	private static final Logger logger = LogManager.getLogger(GenericPostAndGet.class);
	@Value("${usernameMMT}")
	String usernameMMT;
	
	@Value("${passwordMMT}")
    String passwordMMT;
	
	String auth=usernameMMT+":"+passwordMMT;
	//String auth = "testapi@test.com" + ":" +"test@123";
	
		private final String USER_AGENT = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Mobile Safari/537.36";
		
		private MasterResponseModel resultSet = null;
		//samit date 21th nov
		int responseCode=0;

		synchronized public MasterResponseModel genericGetMethod(String url,String urlParameters) throws Exception{
	       
			logger.info("Inside GenericPostAndGet genericGetMethod method entry-->");
			StringBuffer response = new StringBuffer();
			
			
			try {
//"source="+filterModel.getQueryData().getSource()+"&destination="+filterModel.getQueryData().getDestination()+"&format="+"json"+"&dateofdeparture="+filterModel.getQueryData().getDateOfDeparture()+"&dateofarrival="+filterModel.getQueryData().getDateOfArrival()+"&adults="+filterModel.getQueryData().getAdults()+"&counter="+"100"
				URL obj = new URL(url+urlParameters);
				//URL obj = new URL(url+urlParameters);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				String USER_AGENT="";
				con.setRequestProperty("User-Agent", USER_AGENT);
				con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
				con.setRequestProperty("Content-type", "application/JSON");
				con.setRequestProperty("Accept",  "application/JSON");
				con.setConnectTimeout(120);
			


				String auth = "testapi@test.com" + ":" +"test@123";
				byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));

				String authHeaderValue = "Basic " + new String(encodedAuth);
				con.setRequestProperty("Authorization", authHeaderValue);

				con.setDoOutput(true);

				responseCode = con.getResponseCode();
			
				if (responseCode == 200) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					String inputLine;
					//StringBuffer response = new StringBuffer();


					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);

					}
					in.close();
				
				
				}else {


					BufferedReader in1 = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					String inputLine1;

					while ((inputLine1 = in1.readLine()) != null) {
						response.append(inputLine1);
					}
					in1.close();
					// print result+
					System.out.println(response.toString());
					
					
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

			
			resultSet = new MasterResponseModel();
			resultSet.setResponseCode(responseCode);
			resultSet.setResponseMessage(response.toString());
			logger.info("Inside GenericPostAndGet genericGetMethod method exit-->");
			return resultSet;
		}

		synchronized public String genericPostMethodWithResponse(String url,String urlParameters) throws Exception{
			logger.info("Inside GenericPostAndGet genericPostMethodWithResponse method entry-->");
			//Gson gson = new Gson();
			//String urlParameters = gson.toJson(list);
			//System.out.println("urlParameters:" + urlParameters);
			//String url = backendBaseUrl+"/saveTripNoInDb";
			int responseCode = 0;
			StringBuffer response = new StringBuffer();


			try {
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				String en = "UTF‌​-8";
				con.setRequestMethod("POST");
				con.setRequestProperty("User-Agent", USER_AGENT);
				con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
				con.setRequestProperty("Content-type", "application/json");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
				responseCode = con.getResponseCode();
				System.out.println("responseCode" + responseCode);
				if (responseCode == 200) {
					System.out.println("\nSending 'POST' request to URL : " + url);
					System.out.println("Post parameters : " + urlParameters);
					System.out.println("Response Code : " + responseCode);

					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					// print result
					System.out.println("Sumit Success =="+response.toString());

				} else {

					BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					String inputLine;				

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					// print result
					System.out.println(response.toString());
				}
			} catch (Exception e) {
				System.out.println("error:" + e.toString());
			}
			logger.info("Inside GenericPostAndGet genericPostMethodWithResponse method exit-->");
			return response.toString();








		}
		
		/*--------------------------------------Added by mithun---------------------------------------------------------------------*/
		
		synchronized public String genericGetMethod1(String url) throws Exception{
			logger.info("Inside GenericPostAndGet genericGetMethod1 method entry-->");
			int responseCode = 0;
			
			StringBuffer response = new StringBuffer();
			
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);
			/*--------------------------try-catch added by Mithun----------------------------------------*/
			
			responseCode = con.getResponseCode();
			
			
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			
		} catch (Exception e){
				System.out.println("Mithun getTripForNonSalesList error:");
				System.out.println("Mithun getTripForNonSalesList error: "+e.toString());
				e.printStackTrace();
			}
			/*---------------------------End Mithun------------------------------------------------------*/
		logger.info("Inside GenericPostAndGet genericGetMethod1 method exit-->");
			return response.toString();
			
		}
		
	
}
