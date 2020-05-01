package com.mazars.in.common;

import java.awt.Color;
import java.awt.Insets;

public class Constants {
	

	
	public static final String logFileExtn = "log";
	public static final String contentTypeStatic = "static";
	public static final String contentTypeDocument = "document";
	public static final String contentTypeDynamic = "dynamic";
	public static final String url_PROD = "http://104.211.206.233:9000/";
	public static final String url_QA = "http://104.211.216.29:9000/";
	public static final String path_content = "bca/api/getContent/";
	public static final String path_spt_content = "bca/api/getSpotLightContent/";
	public static final String path_leader_content = "bca/leaders/";
	public static final String path_document = "bca/download/";
	public static final String success_Message="success";
	public static final int success_Code=200;
	
	
	public static final String mmt_source_search = "source=";
	public static final String mmt_destination_search = "&destination=";
	public static final String mmt_dateofdeparture_search = "&dateofdeparture=";
	public static final String mmt_dateofarrival_search = "&dateofarrival=";
	public static final String mmt_adults_search = "&adults=";
	public static final String mmt_counter_search = "&counter=";
	public static final String user_Does_Not_Exist_In_System="User does not exist in system";
	public static final String user_Not_Allowed_To_Access="User exist but not allowed for TE application";
	public static final String token_Or_EmailId_Not_Matched="token or emailId not matched";
	public static final String session_Expired="session expired! please try again";
	public static final String valid_Session="valid session";
	public static final int session_Time_Out_Time=2000;
	public static final String loginId_Or_Token_DoesNot_Matched="login id or token does not matched";
	public static final int loginId_Or_Token_DoesNot_Matched_code=202;
	
	public static int session_Expired_Code=201;
	
	public static final String trip_Created_Successfully="trip created successfully";
	public static final int trip_Successfully_Code=200;
	
	
	public static final String trip_Fetched_Successfully="trip fetched successfully";
	public static final String trip_Updated_Successfully="trip updated successfully";
	
	public static final String trip_Deleted_Successfully="trip deleted successfully";
	
	public static final String trip_List_Data="trip details";
	
	public static final String trip_List_Data_Not_Present="the given trip is not present in system,please check the email id used during trip creation";
	
	public static final int data_Not_Present_Code=204; 
	
	public static final String user_Successfully_Deleted="user successfully deleted";
	
	public static final int user_Successfully_Deleted_Code=200;
	// Define Constant for User Table data 
		public static final String User_Organization = "User_Organization";
		public static final String User_Vertical = "User_Vertical";
		public static final String User_Category = "User_Category";
		public static final String User_Location = "User_Location";
		public static final String User_Cost_center = "User_Cost_center";
		public static final String User_Group = "User_Group";
		public static final String Employee_Code = "Employee_Code";
		public static final String User_Title = "User_Title";
		public static final String User_First_name = "User_First_name";
		public static final String User_Middle_Name = "User_Middle_Name";
		public static final String User_Last_Name = "User_Last_Name";
		public static final String User_Email_id = "User Email_id";
		public static final String User_Address = "User_Address";
		public static final String User_Pin = "User_Pin";
		public static final String User_Phone_number = "User_Phone_number";	
		public static final String User_DOB = "User DOB";
		public static final String Gender = "Gender";
		public static final String Department = "Department";
		public static final String Sub_Department = "Sub Department";
		public static final String Approver1 = "Approver 1";
		public static final String Approver2 = "Approver 2";
		public static final String Approver3 = "Approver 3";
		public static final String Is_Approval_Required = "Is_Approval_Required";	
		public static final String User_Is_Allowed_For_TE = "User_Is_Allowed_For_TE";
		public static final String Is_Active = "Is_Active";
		public static final String Employee_User_Data = "Employee_User_data";
		public static final String Created_Updated_By = "AUTO";
		/*public static final String User_Master_CSV_Path = "E:\\Nirmal Bhowmik\\Data\\";
		public static final String User_Master_CSV_Archive_Path = "E:\\Nirmal Bhowmik\\Archive\\";*/
		
		// Retainer Master data column
		
		public static final String Retainer_Organization = "Retainer_Organization";
		public static final String Retainer_Vertical = "Retainer_Vertical";
		public static final String Retainer_Category = "Retainer_Category";
		public static final String Retainer_Location = "Retainer_Location";
		public static final String Retainer_Cost_center = "Retainer_Cost_center";
		public static final String Retainer_Group = "Retainer_Group";
		public static final String Retainer_Employee_Code = "Retainer_Employee_Code";
		public static final String Retainer_Title = "Retainer_Title";
		public static final String Retainer_First_name = "Retainer_First_name";
		public static final String Retainer_Middle_Name = "Retainer_Middle_Name";
		public static final String Retainer_Last_Name = "Retainer_Last_Name";
		public static final String Retainer_Email_id = "User Email_id";
		public static final String Retainer_Address = "Retainer_Address";
		public static final String Retainer_Pin = "Retainer_Pin";
		public static final String Retainer_Phone_number = "Retainer_Phone_number";
		public static final String Retainer_DOB = "User DOB";
		public static final String Retainer_Gender = "Gender";
		public static final String Retainer_Is_Active = "Is_Active";
		public static final String Retainer_NonEmployee_User_Data = "Retainer_NonEmployee_User_data";
		
		// City Category Mapping
		public static final String City_Name = "City_Name";
		public static final String City_Category = "City_Category";
		public static final String City_Category_Data = "City_Category_Mapping";
		
		// City Category Master
		public static final String City_Category_Description = "City_Category";
		public static final String City_Category_Master_Data = "City_Category_Master";
		
		// Entitlement 
		public static final String Entilement_Organization = "Organization";
		public static final String Entilement_Vertical = "Vertical";
		public static final String Entilement_Category = "Category";
		public static final String Entilement_Employee_Group = "Employee Group";
		public static final String Entilement_Is_Flight_Allowed = "Is_Flight_Allowed";
		public static final String Entilement_Flight_Class = "Flight Class";
		public static final String Entilement_Entitled_Flight_Amount = "Entitled_Flight_Amount";
		public static final String Entilement_Is_Train_Allowed = "Is_Train_Allowed";
		public static final String Entilement_Train_Class = "Train Class";
		public static final String Entilement_Entitled_Train_Amount = "Entitled_Train_Amount";
		public static final String Entilement_Is_Car_Pool_Allowed = "Is_Car_Pool_Allowed";
		public static final String Entilement_Local_Convenyance_Amount = "Local_Convenyance_Amount";
		public static final String Entilement_Self_Accomodation_Amount = "Self_Accomodation_Amount";
		public static final String Entilement_Night_Trip_Amount = "Night_Trip_Amount";
		public static final String Entilement_Trip_Submission_Due_Date = "Trip_Submission_Due_Date";
		public static final String Entilement_Advance_Settlement_Amount_Percentage = "Advance_Settlement_Amount_Percentage";
		public static final String Entilement_City_CategoryA = "City Category A - Amount";
		public static final String Entilement_City_CategoryB = "City Category B - Amount";
		public static final String Entilement_City_CategoryC = "City Category C - Amount";
		public static final String Entilement_Data = "Entitlement";
		
		// Organization Master	
		public static final String Organization_Code = "Organization_Code";
		public static final String Organization_Name = "Organization_name";
		public static final String Organization_Description = "Organization_Description";
		public static final String Organization_Master_Data = "Organization Master";
		
		// Vertical Master	
		public static final String Vertical_Organization_Code = "Organization_Code";
		public static final String Vertical_Code = "Vertical Code";
		public static final String Vertical_name = "Vertical_name";
		public static final String Vertical_Description = "Vertical_Description";
		public static final String Vertical_Master_Data = "Vertical Master";
		
		// Category Master	
		public static final String Category_Organization_Code = "Organization_Code";
		public static final String Category_Vertical_Code = "Vertical Code";
		public static final String Category_name = "Category_name";
		public static final String Category_Description = "Category_Description";
		public static final String Category_Master_Data = "Category Master";
		
		// User Group Master	
		public static final String User_Group_Organization_Code = "Organization_Code";
		public static final String User_Group_Vertical_Code = "Vertical_code";
		public static final String User_Group_Category_name = "Category";
		public static final String User_group_group = "User_group";
		public static final String User_Group_Master_Data = "User Group Master";
		
		// Location Master	
		public static final String Location_Organization = "Organization";
		public static final String  Location_Code = "Location Code";
		public static final String Location_Name = "Location Name";
		public static final String Location_Master_Data = "Location Master";
		
		// Cost Center Master	
		public static final String Cost_Center_Organization = "Organization";
		public static final String Cost_Center = "Cost Center";
		public static final String Cost_Center_Description = "Cost Center Description";
		public static final String CostCenter_Master_Data = "Cost_Center_Master";
		
		// Department Master	
		public static final String Department_Organization = "Organization_Code";
		public static final String Department_code = "Department_code";
		public static final String Department_Name = "Department_Name";
		public static final String Department_Description = "Department_Description";
		public static final String Department_Master_Data = "Department_Master";
		
		// Sub Department Master	
		public static final String Sub_Department_Organization = "Organization_Code";
		public static final String Sub_Department_code = "SBU_code";
		public static final String Sub_Department_Name = "SBU_Name";
		public static final String Sub_Department_Description = "SBU_Description";
		public static final String Sub_Department_Master_Data = "SBU_Master";
		
		// Function Master	
		public static final String Function_Organization = "Organization_Code";
		public static final String Admin_Function_Code = "Admin_Function_Code";
		public static final String Admin_Function_Name = "Admin_Function_Name";
		public static final String Admin_Function_Description = "Admin_Function_Description";
		public static final String Function_Master_Data = "Admin_Function_Master";	
		
		// Finance Master	
		public static final String Finance_Organization = "Organization";
		public static final String Finance_Vertical = "Vertical";
		public static final String Finance_Location = "Location";
		public static final String Finance_Function = "Admin_Function";
		public static final String Finance_Approver_User1 = "Users";
		public static final String Finance_Approver_User2 = "Approver User 2";
		public static final String Finance_Master_Data = "Locationwise_Finance";	
		
		// Hr Master	
		public static final String Hr_Organization = "Organization";
		public static final String Hr_Vertical = "Vertical";
		public static final String Hr_Location = "Location";
		public static final String Hr_Function = "Admin_Function";
		public static final String Hr_Approver_User1 = "Approver User 1";
		public static final String Hr_Approver_User2 = "Approver User 2";
		public static final String Hr_Master_Data = "Locationwise_HR";
		
		// Railway Agent Master	
		public static final String Railway_Organization = "Organization";
		public static final String Railway_Vertical = "Vertical";
		public static final String Railway_Location = "Location";
		public static final String Railway_Function = "Admin_Function";
		public static final String Railway_User1 = "User 1";
		public static final String Railway_User2 = "User 2";
		public static final String Railway_Agent_Master_Data = "Locationwise_Railway_Agent";
		
		// Railway Agent Master	
		public static final String Carpool_Organization = "Organization";
		public static final String Carpool_Vertical = "Vertical";
		public static final String Carpool_Location = "Location";
		public static final String Carpool_Function = "Admin_Function";
		public static final String Carpool_User1 = "User 1";
		public static final String Carpool_User2 = "User 2";
		public static final String Carpool_Master_Data = "Locationwise_Carpool";
		
		// Event Master	
		public static final String Event_Code = "Event Code";
		public static final String Event_Description = "Event_Description";
		public static final String Event_Organization = "Organization";
		public static final String Event_Master_Data = "Event_Master";
		
		// OnBehalf Master	
		public static final String Executive_Name  = "Executive Name";
		public static final String Secretary_Name = "Secretary Name";
		public static final String OnBehalf_Master_Data = "OnBehalf_Master";
		
		// Budget Master	
		public static final String Budget_Financial_Year = "Financial Year";
		public static final String Budget_Amount = "Budget Amount";
		public static final String Budget_Cost_Center = "Cost Center";
		public static final String Budget_Allowed_To_See = "Budget Allowed To See";
		public static final String Budget_User_Email_ID = "User Email ID";
		public static final String Budget_Master_Data = "Budget";
		
		// Cost event Master	
		public static final String Evnent_Cost_Center  = "Cost Center";
		public static final String Event_Mandatory = "Event Mandatory";
		public static final String Cost_Event_Master_Data = "Cost_Event_Mapping";
		
		//Date format 
		public static final String Date_Format="yyyy-MM-dd hh:mm:ss";
		
}
