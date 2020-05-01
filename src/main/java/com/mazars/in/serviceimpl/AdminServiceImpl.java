package com.mazars.in.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.common.Constants;
import com.mazars.in.common.GetPropertiesValues;
import com.mazars.in.dao.AdminDaoRepository;
import com.mazars.in.dao.BudgetMasterDao;
import com.mazars.in.dao.BudgetMasterMappingDao;
import com.mazars.in.dao.CategoryMasterDaoRepository;
import com.mazars.in.dao.CityCategoryMappingDaoRepository;
import com.mazars.in.dao.CityCategoryMasterdaoRepository;
import com.mazars.in.dao.CityMasterDaorepository;
import com.mazars.in.dao.CostCenterMasterDaoRepository;
import com.mazars.in.dao.DepartmentMasterDaoRepository;
import com.mazars.in.dao.EventCostCenterMappingDao;
import com.mazars.in.dao.EventMasterDaoRepository;
import com.mazars.in.dao.FunctionMasterDaoRepository;
import com.mazars.in.dao.LocationMasterDaoRepository;
import com.mazars.in.dao.LocationWiseCarpoolMappingDao;
import com.mazars.in.dao.LocationWiseCarpoolMasterDao;
import com.mazars.in.dao.LocationWiseFinanceDao;
import com.mazars.in.dao.LocationWiseFinanceMappingDao;
import com.mazars.in.dao.LocationWiseHrMappingDao;
import com.mazars.in.dao.LocationWiseHrMasterDao;
import com.mazars.in.dao.LocationWiseRailwayAgentMappingDao;
import com.mazars.in.dao.LocationWiseRailwayAgentMasterDao;
import com.mazars.in.dao.OnBehalfMasterDaoRepository;
import com.mazars.in.dao.OrganizationMasterDaoRepository;
import com.mazars.in.dao.RetainerDaoRepository;
import com.mazars.in.dao.RetainerMappingDaoRepository;
import com.mazars.in.dao.SubDepartmentMasterDaoRepository;
import com.mazars.in.dao.TravelCityEntitlementDaoRepository;
import com.mazars.in.dao.TravelEntitlementDaoRepository;
import com.mazars.in.dao.UserDaoRepository;
import com.mazars.in.dao.UserGroupMasterDaoRepository;
import com.mazars.in.dao.UserMappingDaoRepository;
import com.mazars.in.dao.VerticalMasterDaoRepository;
import com.mazars.in.model.intermediatemodel.BudgetMasterData;
import com.mazars.in.model.intermediatemodel.CarpoolMasterData;
import com.mazars.in.model.intermediatemodel.CategoryMasterData;
import com.mazars.in.model.intermediatemodel.CityCategoryData;
import com.mazars.in.model.intermediatemodel.CityCategoryMasterData;
import com.mazars.in.model.intermediatemodel.CostCenterMasterData;
import com.mazars.in.model.intermediatemodel.CostEventMasterData;
import com.mazars.in.model.intermediatemodel.DepartmentMasterData;
import com.mazars.in.model.intermediatemodel.EntitlementMasterData;
import com.mazars.in.model.intermediatemodel.EventMasterData;
import com.mazars.in.model.intermediatemodel.FinanceMasterData;
import com.mazars.in.model.intermediatemodel.FunctionMasterData;
import com.mazars.in.model.intermediatemodel.HrMasterData;
import com.mazars.in.model.intermediatemodel.LocationMasterData;
import com.mazars.in.model.intermediatemodel.OnBehalfMasterData;
import com.mazars.in.model.intermediatemodel.OrganizationMasterData;
import com.mazars.in.model.intermediatemodel.RailwayMasterData;
import com.mazars.in.model.intermediatemodel.RetainerMasterData;
import com.mazars.in.model.intermediatemodel.SubDepartmentMasterData;
import com.mazars.in.model.intermediatemodel.UserDetails;
import com.mazars.in.model.intermediatemodel.UserDetailsInfo;
import com.mazars.in.model.intermediatemodel.UserGroupMasterData;
import com.mazars.in.model.intermediatemodel.UserInfo;
import com.mazars.in.model.intermediatemodel.UserMasterData;
import com.mazars.in.model.intermediatemodel.VerticalMasterData;
import com.mazars.in.model.mastermodel.BudgetMaster;
import com.mazars.in.model.mastermodel.BudgetMasterMapping;
import com.mazars.in.model.mastermodel.CategoryMaster;
import com.mazars.in.model.mastermodel.CityCategoryMapping;
import com.mazars.in.model.mastermodel.CityCategoryMaster;
import com.mazars.in.model.mastermodel.CostCenterMaster;
import com.mazars.in.model.mastermodel.DepartmentMaster;
import com.mazars.in.model.mastermodel.EventCostCenterMapping;
import com.mazars.in.model.mastermodel.EventMaster;
import com.mazars.in.model.mastermodel.FunctionMaster;
import com.mazars.in.model.mastermodel.LocationMaster;
import com.mazars.in.model.mastermodel.LocationWiseCarpoolMapping;
import com.mazars.in.model.mastermodel.LocationWiseCarpoolMaster;
import com.mazars.in.model.mastermodel.LocationWiseFinanceMapping;
import com.mazars.in.model.mastermodel.LocationWiseFinanceMaster;
import com.mazars.in.model.mastermodel.LocationWiseHrMapping;
import com.mazars.in.model.mastermodel.LocationWiseHrMaster;
import com.mazars.in.model.mastermodel.LocationWiseRailwayAgentMapping;
import com.mazars.in.model.mastermodel.LocationWiseRailwayAgentMaster;
import com.mazars.in.model.mastermodel.OnBehalfMaster;
import com.mazars.in.model.mastermodel.OrganizationMaster;
import com.mazars.in.model.mastermodel.Retainer;
import com.mazars.in.model.mastermodel.RetainerMapping;
import com.mazars.in.model.mastermodel.SubDepartmentMaster;
import com.mazars.in.model.mastermodel.TravelCityEntitlement;
import com.mazars.in.model.mastermodel.TravelEntitlement;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.model.mastermodel.UserGroupMaster;
import com.mazars.in.model.mastermodel.UserMapping;
import com.mazars.in.model.mastermodel.VerticalMaster;
import com.mazars.in.model.mmt.hotelmodel.CityMaster;
import com.mazars.in.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

private static Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	
@Autowired(required=true)
AdminDaoRepository adminDaoRepository;

@Autowired
CityCategoryMappingDaoRepository cityCategoryRepo;

@Autowired
CityMasterDaorepository cityMasterRepo;

@Autowired
CityCategoryMasterdaoRepository cityCategoryMasterRepo;

@Autowired
UserDaoRepository userDaoRepo;

@Autowired
UserMappingDaoRepository userMappingDaoRepo;

@Autowired
RetainerDaoRepository retainerDaoRepo;

@Autowired
RetainerMappingDaoRepository reatinerMappingDaoRepo;

@Autowired
OrganizationMasterDaoRepository orgMasterDao;

@Autowired
VerticalMasterDaoRepository verticalMasterDao;

@Autowired
CategoryMasterDaoRepository categoryMasterDao;

@Autowired
UserGroupMasterDaoRepository userGroupMasterDao;

@Autowired
LocationMasterDaoRepository locationMasterDao;

@Autowired
CostCenterMasterDaoRepository costcenterMasterDao;

@Autowired
DepartmentMasterDaoRepository departmentMasterDao;


@Autowired
SubDepartmentMasterDaoRepository subdepDaoRepo;

@Autowired
FunctionMasterDaoRepository functionMasterDao;

@Autowired
EventMasterDaoRepository eventMasterDao;

@Autowired
OnBehalfMasterDaoRepository onbehalfMasterDao;

@Autowired
LocationWiseFinanceDao locationwiseFinanceMasterDao;

@Autowired
LocationWiseHrMasterDao locationwiseHrMasterDao;

@Autowired
LocationWiseFinanceMappingDao locationwiseFinanceMappingDao;

@Autowired
LocationWiseHrMappingDao locationwiseHrMappingDao;

@Autowired
BudgetMasterDao budgetMasterDao;

@Autowired
BudgetMasterMappingDao budgetMasterMappingDao;

@Autowired
EventCostCenterMappingDao eventcostcenterMappingDao;

@Autowired
LocationWiseRailwayAgentMasterDao locationwiseRailwayAgentMasterDao;

@Autowired
LocationWiseRailwayAgentMappingDao locationwiseRailwayMappingDao;

@Autowired
LocationWiseCarpoolMasterDao locationwiseCarpoolMasterDao;

@Autowired
LocationWiseCarpoolMappingDao locationwiseCarpoolMappingDao;

@Autowired
TravelEntitlementDaoRepository travelEntitlementDao;

@Autowired
TravelCityEntitlementDaoRepository travelCityEntitlementDao;

@Autowired
GetPropertiesValues getProperty;

@Override
public void save() {
	
   logger.info("Master data insertion process start");
    
	List<UserMasterData> userMaster=null;
	List<RetainerMasterData> retainerMaster=null;
	List<CityCategoryMasterData> citycategoryMaster=null;
	List<OrganizationMasterData> organizationMaster=null;
	List<VerticalMasterData> verticalMaster=null;
	List<CategoryMasterData> categoryMaster=null;
	List<UserGroupMasterData> usergroupMaster=null;
	List<LocationMasterData> locationMaster=null;
	List<CostCenterMasterData> costcenterMaster=null;
	List<DepartmentMasterData> depertmentMaster=null;
	List<SubDepartmentMasterData> subdepartmentMaster=null;
	List<FunctionMasterData> functionMaster=null;
	List<EventMasterData> eventMaster=null;
	List<OnBehalfMasterData> onbehalfMaster=null;
	List<FinanceMasterData> financeMaster=null;
	List<HrMasterData> hrMaster=null;
	List<BudgetMasterData> budgetMaster=null;
	List<CostEventMasterData> costeventMaster=null;
	List<RailwayMasterData> railwayMaster=null;
	List<CarpoolMasterData> carpoolMaster=null;
	List<CityCategoryData> cityCategory=null;
	List<EntitlementMasterData> entitlementMaster=null;
	String masterdataPath=getProperty.getMasterdata();
	String mappingdataPath=getProperty.getMappingdata();
	String archivePath=getProperty.getArchive();
	Date date = new Date();
	
	// Master data Insertion
	File allFiles = new File(masterdataPath);
	boolean exists = allFiles.exists();			   
	if(exists) {
		String[] files = allFiles.list();
		for (String file : files)
		{
			if(file.startsWith(Constants.City_Category_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input Output"+e3.getMessage());
				}
				cityCategory = new ArrayList<CityCategoryData>();
				for(CSVRecord record : parser){
					CityCategoryData umaster = new CityCategoryData();
					umaster.setCity_Category_Description(record.get(Constants.City_Category_Description));
					cityCategory.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input Output"+e2.getMessage());
				}
				
				List<CityCategoryMaster> orgMasterlist=new ArrayList<CityCategoryMaster>();;
				for(CityCategoryData orgm:cityCategory) {
					CityCategoryMaster orgMast=new CityCategoryMaster();
					
					int orgId=getcitycategoryId(orgm.getCity_Category_Description());
					orgMast.setCityCategoryId(orgId);
					orgMast.setCategoryTypeDesc(orgm.getCity_Category_Description());
					orgMast.setUpdatedBy(Constants.Created_Updated_By);
					orgMast.setCreatedDate(date);
					orgMast.setUpdatedDate(date);
					orgMast.setActive(true);
					orgMasterlist.add(orgMast);					
				}
				
				for(CityCategoryMaster orgmas:orgMasterlist) {
					cityCategoryMasterRepo.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}

				
			}
		else if(file.startsWith(Constants.OnBehalf_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				onbehalfMaster = new ArrayList<OnBehalfMasterData>();
				for(CSVRecord record : parser){
					OnBehalfMasterData umaster = new OnBehalfMasterData();
					umaster.setExecutive_Name(record.get(Constants.Executive_Name));
					umaster.setSecretary_Name(record.get(Constants.Secretary_Name));
					onbehalfMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<OnBehalfMaster> orgMasterlist=new ArrayList<OnBehalfMaster>();;
				for(OnBehalfMasterData orgm:onbehalfMaster) {
					OnBehalfMaster orgMast=new OnBehalfMaster();
					
					int orgId=getonbehalfId(orgm.getExecutive_Name());
					orgMast.setOnbehalfId(orgId);
					orgMast.setExcuteName(orgm.getExecutive_Name());
					orgMast.setSecretaryName(orgm.getSecretary_Name());
					orgMast.setUpdatedBy(Constants.Created_Updated_By);
					orgMast.setCreatedDate(date);
					orgMast.setUpdatedDate(date);
					orgMast.setActive(true);
					orgMasterlist.add(orgMast);					
				}
				
				for(OnBehalfMaster orgmas:orgMasterlist) {
					onbehalfMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}

				
			}
			else if(file.startsWith(Constants.Organization_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				organizationMaster = new ArrayList<OrganizationMasterData>();
				for(CSVRecord record : parser){
					OrganizationMasterData umaster = new OrganizationMasterData();
					umaster.setOrganization_Code(record.get(Constants.Organization_Code));
					umaster.setOrganization_Name(record.get(Constants.Organization_Name));
					umaster.setOrganization_Description(record.get(Constants.Organization_Description));							
					organizationMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<OrganizationMaster> orgMasterlist=new ArrayList<OrganizationMaster>();;
				for(OrganizationMasterData orgm:organizationMaster) {
					OrganizationMaster orgMast=new OrganizationMaster();
					
					int orgId=getorganizationId(orgm.getOrganization_Name());
					orgMast.setOrganizationmasterId(orgId);
					orgMast.setOrganizationCode(orgm.getOrganization_Code());
					orgMast.setOrganizationName(orgm.getOrganization_Name());
					orgMast.setOrganizationDescription(orgm.getOrganization_Description());
					orgMast.setCreatedBy(Constants.Created_Updated_By);
					orgMast.setUpdatedBy(Constants.Created_Updated_By);
					orgMast.setCreatedDate(date);
					orgMast.setUpdatedDate(date);
					orgMast.setActive(true);
					orgMasterlist.add(orgMast);					
				}
				
				for(OrganizationMaster orgmas:orgMasterlist) {
					orgMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}

				
			}
			else if(file.startsWith(Constants.Vertical_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				verticalMaster = new ArrayList<VerticalMasterData>();
				for(CSVRecord record : parser){
					VerticalMasterData umaster = new VerticalMasterData();
					umaster.setOrganization_Code(record.get(Constants.Vertical_Organization_Code));
					umaster.setVertical_Code(record.get(Constants.Vertical_Code));
					umaster.setVertical_name(record.get(Constants.Vertical_name));	
					umaster.setVertical_Description(record.get(Constants.Vertical_Description));
					verticalMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<VerticalMaster> verticalMasterlist=new ArrayList<VerticalMaster>();;
				for(VerticalMasterData vertm:verticalMaster) {
					VerticalMaster verMast=new VerticalMaster();
					
					int verId=getverticalId(vertm.getVertical_name());
					verMast.setVerticalmasterId(verId);
					verMast.setVerticalName(vertm.getVertical_name());
					verMast.setVerticalDescription(vertm.getVertical_Description());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					verticalMasterlist.add(verMast);					
				}
				
				for(VerticalMaster orgmas:verticalMasterlist) {
					verticalMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
			else if(file.startsWith(Constants.Category_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				categoryMaster = new ArrayList<CategoryMasterData>();
				for(CSVRecord record : parser){
					CategoryMasterData umaster = new CategoryMasterData();
					umaster.setOrganization_Code(record.get(Constants.Category_Organization_Code));
					umaster.setVertical_Code(record.get(Constants.Category_Vertical_Code));
					umaster.setCategory_name(record.get(Constants.Category_name));	
					umaster.setCategory_Description(record.get(Constants.Category_Description));
					categoryMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<CategoryMaster> categoryMasterlist=new ArrayList<CategoryMaster>();
				for(CategoryMasterData vertm:categoryMaster) {
					CategoryMaster verMast=new CategoryMaster();
					
					int cateId=getcategoryId(vertm.getCategory_name());
					verMast.setCategoryMasterId(cateId);
					verMast.setCategoryName(vertm.getCategory_name());
					verMast.setCategoryDescription(vertm.getCategory_Description());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					categoryMasterlist.add(verMast);					
				}
				
				for(CategoryMaster orgmas:categoryMasterlist) {
					categoryMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
			else if(file.startsWith(Constants.User_Group_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				usergroupMaster = new ArrayList<UserGroupMasterData>();
				for(CSVRecord record : parser){
					UserGroupMasterData umaster = new UserGroupMasterData();
					umaster.setOrganization_Code(record.get(Constants.User_Group_Organization_Code));
					umaster.setVertical_Code(record.get(Constants.User_Group_Vertical_Code));
					umaster.setCategory_name(record.get(Constants.User_Group_Category_name));	
					umaster.setUser_group(record.get(Constants.User_group_group));
					usergroupMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<UserGroupMaster> usergroupMasterlist=new ArrayList<UserGroupMaster>();
				for(UserGroupMasterData vertm:usergroupMaster) {
					UserGroupMaster verMast=new UserGroupMaster();
					
					int usergroupId=getusergroupId(vertm.getUser_group());
					verMast.setEmployeeGroupID(usergroupId);
					verMast.setGroupName(vertm.getUser_group());
					verMast.setGroupDescription(vertm.getUser_group());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					usergroupMasterlist.add(verMast);					
				}
				
				for(UserGroupMaster orgmas:usergroupMasterlist) {
					userGroupMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
			else if(file.startsWith(Constants.Location_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				locationMaster = new ArrayList<LocationMasterData>();
				for(CSVRecord record : parser){
					LocationMasterData umaster = new LocationMasterData();
					umaster.setOrganization_Code(record.get(Constants.Location_Organization));
					umaster.setLocation_Code(record.get(Constants.Location_Code));
					umaster.setLocation_Name(record.get(Constants.Location_Name));					
					locationMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<LocationMaster> locationMasterlist=new ArrayList<LocationMaster>();;
				for(LocationMasterData vertm:locationMaster) {
					LocationMaster verMast=new LocationMaster();
					
					int locationId=getlocationId(vertm.getLocation_Name());
					verMast.setLocationMasterID(locationId);
					verMast.setLocationcode(vertm.getLocation_Code());
					verMast.setLocation(vertm.getLocation_Name());
					verMast.setLocationDescription(vertm.getLocation_Name());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					locationMasterlist.add(verMast);					
				}
				
				for(LocationMaster orgmas:locationMasterlist) {
					locationMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
			else if(file.startsWith(Constants.CostCenter_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				costcenterMaster = new ArrayList<CostCenterMasterData>();
				for(CSVRecord record : parser){
					CostCenterMasterData umaster = new CostCenterMasterData();
					umaster.setOrganization_Code(record.get(Constants.Cost_Center_Organization));
					umaster.setCost_Center(record.get(Constants.Cost_Center));
					umaster.setCost_Center_Description(record.get(Constants.Cost_Center_Description));					
					costcenterMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<CostCenterMaster> costcenterMasterlist=new ArrayList<CostCenterMaster>();;
				for(CostCenterMasterData vertm:costcenterMaster) {
					CostCenterMaster verMast=new CostCenterMaster();
					
					int costcenterId=getcostcenterId(vertm.getCost_Center());
					verMast.setCostCenterMasterId(costcenterId);
					verMast.setCostCenter(vertm.getCost_Center());
					verMast.setCostCenterDescription(vertm.getCost_Center_Description());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					costcenterMasterlist.add(verMast);					
				}
				
				for(CostCenterMaster orgmas:costcenterMasterlist) {
					costcenterMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
			else if(file.startsWith(Constants.Department_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not Found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				depertmentMaster = new ArrayList<DepartmentMasterData>();
				for(CSVRecord record : parser){
					DepartmentMasterData umaster = new DepartmentMasterData();
					umaster.setOrganization_Code(record.get(Constants.Department_Organization));
					umaster.setDepartment_code(record.get(Constants.Department_code));
					umaster.setDepartment_Name(record.get(Constants.Department_Name));	
					umaster.setDepartment_Description(record.get(Constants.Department_Description));
					depertmentMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<DepartmentMaster> departmentMasterlist=new ArrayList<DepartmentMaster>();;
				for(DepartmentMasterData vertm:depertmentMaster) {
					DepartmentMaster verMast=new DepartmentMaster();
					
					int depId=getdepartmentId(vertm.getDepartment_code());
					verMast.setDepartmentMasterID(depId);
					verMast.setDepartmentCode(vertm.getDepartment_code());
					verMast.setDepartmentName(vertm.getDepartment_Name());
					verMast.setDepartmentDescription(vertm.getDepartment_Description());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					departmentMasterlist.add(verMast);					
				}
				
				for(DepartmentMaster orgmas:departmentMasterlist) {
					departmentMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}	
			else if(file.startsWith(Constants.Sub_Department_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				subdepartmentMaster = new ArrayList<SubDepartmentMasterData>();
				for(CSVRecord record : parser){
					SubDepartmentMasterData umaster = new SubDepartmentMasterData();
					umaster.setOrganization_Code(record.get(Constants.Sub_Department_Organization));
					umaster.setSub_Department_code(record.get(Constants.Sub_Department_code));
					umaster.setSub_Department_Name(record.get(Constants.Sub_Department_Name));	
					umaster.setSub_Department_Description(record.get(Constants.Sub_Department_Description));
					subdepartmentMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<SubDepartmentMaster> subdepartmentMasterlist=new ArrayList<SubDepartmentMaster>();;
				for(SubDepartmentMasterData vertm:subdepartmentMaster) {
					SubDepartmentMaster verMast=new SubDepartmentMaster();
					
					int subdepId=getsubdepartmentId(vertm.getSub_Department_code());
					verMast.setSubdepartmentMasterID(subdepId);
					verMast.setSubdepartmentCode(vertm.getSub_Department_code());
					verMast.setSubdepartmentName(vertm.getSub_Department_Name());
					verMast.setSubdepartmentDescription(vertm.getSub_Department_Description());
					verMast.setCreatedBy(Constants.Created_Updated_By);
					verMast.setUpdatedBy(Constants.Created_Updated_By);
					verMast.setCreatedDate(date);
					verMast.setUpdatedDate(date);
					verMast.setActive(true);
					subdepartmentMasterlist.add(verMast);					
				}
				
				for(SubDepartmentMaster orgmas:subdepartmentMasterlist) {
					subdepDaoRepo.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file.startsWith(Constants.Function_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				functionMaster = new ArrayList<FunctionMasterData>();
				for(CSVRecord record : parser){
					FunctionMasterData umaster = new FunctionMasterData();
					umaster.setFunction_Organization(record.get(Constants.Function_Organization));
					umaster.setAdmin_Function_Code(record.get(Constants.Admin_Function_Code));
					umaster.setAdmin_Function_Name(record.get(Constants.Admin_Function_Name));
					umaster.setAdmin_Function_Description(record.get(Constants.Admin_Function_Description));
					functionMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<FunctionMaster> orgMasterlist=new ArrayList<FunctionMaster>();;
				for(FunctionMasterData orgm:functionMaster) {
					FunctionMaster orgMast=new FunctionMaster();
					
					int orgId=getfunctionId(orgm.getAdmin_Function_Name());
					orgMast.setFunctionMasterId(orgId);	
					orgMast.setFunctionCode(orgm.getAdmin_Function_Code());
					orgMast.setFunctionName(orgm.getAdmin_Function_Name());
					orgMast.setFunctionDescription(orgm.getAdmin_Function_Description());					
					orgMast.setUpdatedBy(Constants.Created_Updated_By);
					orgMast.setCreatedDate(date);
					orgMast.setUpdatedDate(date);
					orgMast.setActive(true);
					orgMasterlist.add(orgMast);					
				}
				
				for(FunctionMaster orgmas:orgMasterlist) {
					functionMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file.startsWith(Constants.Event_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(masterdataPath+file), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}
				eventMaster = new ArrayList<EventMasterData>();
				for(CSVRecord record : parser){
					EventMasterData umaster = new EventMasterData();
					umaster.setEvent_Code(record.get(Constants.Event_Code));
					umaster.setEvent_Description(record.get(Constants.Event_Description));
					umaster.setOrganization(record.get(Constants.Event_Organization));
					eventMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<EventMaster> orgMasterlist=new ArrayList<EventMaster>();;
				for(EventMasterData orgm:eventMaster) {
					EventMaster orgMast=new EventMaster();
					
					int orgId=geteventId(Integer.parseInt(orgm.getEvent_Code()));
					orgMast.setEventId(orgId);					
					orgMast.setEventCode(Integer.parseInt(orgm.getEvent_Code()));
					orgMast.setEventDescription(orgm.getEvent_Description());					
					orgMast.setUpdatedBy(Constants.Created_Updated_By);
					orgMast.setCreatedDate(date);
					orgMast.setUpdatedDate(date);
					orgMast.setActive(true);
					orgMasterlist.add(orgMast);					
				}
				
				for(EventMaster orgmas:orgMasterlist) {
					eventMasterDao.save(orgmas);					
				}
				try {
					Files.move(Paths.get(masterdataPath+file), Paths.get(archivePath+file),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
			   
		}			
	}		
     
	// Mapping data insertion
	
	File allmappingFiles = new File(mappingdataPath);
	boolean exists1 = allmappingFiles.exists();			   
	if(exists1) {
		String[] files1 = allmappingFiles.list();
		for (String file1 : files1)
		{
			if(file1.startsWith(Constants.City_Category_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

				citycategoryMaster = new ArrayList<CityCategoryMasterData>();
				for(CSVRecord record : parser){
					CityCategoryMasterData umaster = new CityCategoryMasterData();
					umaster.setCityName(record.get(Constants.City_Name));
					umaster.setCityCategory(record.get(Constants.City_Category));						
					citycategoryMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<CityCategoryMapping> umappingList=new ArrayList<CityCategoryMapping>();
				for(CityCategoryMasterData um:citycategoryMaster) {
					CityCategoryMapping umapping=new CityCategoryMapping();
					
					
					int cityId=getcityId(um.getCityName());
					umapping.setCityID(cityId);
					int categoryId=getcitycategoryId(um.getCityCategory());
					umapping.setCityCategoryId(categoryId);
					int eventCostmappingId=getcitycatrgorymappingId(cityId,categoryId);
					umapping.setCityCategoryMappingId(eventCostmappingId);
					umapping.setUpdatedBy(Constants.Created_Updated_By);
					umapping.setCreatedDate(date);
					umapping.setUpdatedDate(date);
					umapping.setActive(true);					
					umappingList.add(umapping);
				}
				
				for(CityCategoryMapping u:umappingList) {
					cityCategoryRepo.save(u);
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file1.startsWith(Constants.Cost_Event_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

				costeventMaster = new ArrayList<CostEventMasterData>();
				for(CSVRecord record : parser){
					CostEventMasterData umaster = new CostEventMasterData();
					umaster.setEvnent_Cost_Center(record.get(Constants.Evnent_Cost_Center));
					umaster.setEvent_Mandatory(record.get(Constants.Event_Mandatory));						
					costeventMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<EventCostCenterMapping> umappingList=new ArrayList<EventCostCenterMapping>();
				for(CostEventMasterData um:costeventMaster) {
					EventCostCenterMapping umapping=new EventCostCenterMapping();
					int eventId=geteventId(Integer.parseInt(um.getEvent_Mandatory()));
					umapping.setEventId(eventId);
					int costcenterId=getcostcenterId(um.getEvnent_Cost_Center());
					umapping.setCostCenterId(costcenterId);
					int eventCostmappingId=geteventcostcenterMappingId(eventId,costcenterId);
					umapping.setEventCostCenterId(eventCostmappingId);
					umapping.setEventCompulsory(true);					
					umapping.setUpdatedBy(Constants.Created_Updated_By);
					umapping.setCreatedDate(date);
					umapping.setUpdatedDate(date);
					umapping.setActive(true);					
					umappingList.add(umapping);
				}
				
				for(EventCostCenterMapping u:umappingList) {
					eventcostcenterMappingDao.save(u);
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file1.startsWith(Constants.Budget_Master_Data)) {
				
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

				budgetMaster = new ArrayList<BudgetMasterData>();
				for(CSVRecord record : parser){
					BudgetMasterData umaster = new BudgetMasterData();
					umaster.setBudget_Financial_Year(record.get(Constants.Budget_Financial_Year));
					umaster.setBudget_Amount(record.get(Constants.Budget_Amount));	
					umaster.setBudget_Cost_Center(record.get(Constants.Budget_Cost_Center));
					umaster.setBudget_Allowed_To_See(record.get(Constants.Budget_Allowed_To_See));
					umaster.setBudget_User_Email_ID(record.get(Constants.Budget_User_Email_ID));
					budgetMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<BudgetMaster> userList=new ArrayList<BudgetMaster>();
				for(BudgetMasterData um:budgetMaster) {
					BudgetMaster user=new BudgetMaster();
					BudgetMasterMapping umapping=new BudgetMasterMapping();
					
					int userId=getbudgetId(um.getBudget_User_Email_ID());
					user.setBudgetId(userId);
					user.setFinancialyear(um.getBudget_Financial_Year());
					user.setBudget_amount(um.getBudget_Amount());
					user.setBudget_allowed_to_see(um.getBudget_Allowed_To_See());
					user.setUser_email_id(um.getBudget_User_Email_ID());
					user.setUpdatedBy(Constants.Created_Updated_By);
					user.setCreatedDate(date);
					user.setUpdatedDate(date);
					user.setActive(true);
					
					int usermappId=getbudgetMappingId(userId);
					umapping.setBudgetmappingId(usermappId);
					int orgId=getcostcenterId(um.getBudget_Cost_Center());
					umapping.setCostcenterId(orgId);
					user.setBudgetmastermapping(umapping);
					userList.add(user);
				}
				
				for(BudgetMaster u:userList) {
					budgetMasterDao.save(u);
					
					BudgetMasterMapping um=u.getBudgetmastermapping();
					int uId=getbudgetId(u.getUser_email_id());
					um.setBudgetId(uId);					
					budgetMasterMappingDao.save(um);				
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file1.startsWith(Constants.Finance_Master_Data)) {
				
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

			    financeMaster = new ArrayList<FinanceMasterData>();
				for(CSVRecord record : parser){
					FinanceMasterData umaster = new FinanceMasterData();
					umaster.setFinance_Organization(record.get(Constants.Finance_Organization));
					umaster.setFinance_Vertical(record.get(Constants.Finance_Vertical));	
					umaster.setFinance_Location(record.get(Constants.Finance_Location));
					umaster.setFinance_Function(record.get(Constants.Finance_Function));
					umaster.setFinance_Approver_User1(record.get(Constants.Finance_Approver_User1));
					//umaster.setFinance_Approver_User2(record.get(Constants.Finance_Approver_User2));
					financeMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<LocationWiseFinanceMaster> userList=new ArrayList<LocationWiseFinanceMaster>();
				for(FinanceMasterData um:financeMaster) {
					LocationWiseFinanceMaster user=new LocationWiseFinanceMaster();
					LocationWiseFinanceMapping umapping=new LocationWiseFinanceMapping();
					int userId=getfinanceId(um.getFinance_Approver_User1());
					user.setLocationwisefinancemasterId(userId);
					user.setApproverUser1(um.getFinance_Approver_User1());
					//user.setApproverUser2(um.getFinance_Approver_User2());
					user.setUpdatedBy(Constants.Created_Updated_By);
					user.setCreatedDate(date);
					user.setUpdatedDate(date);
					user.setActive(true);
					
					int usermappId=getfinancemappingId(userId);
					umapping.setLocationwisefinancemappingId(usermappId);
					int orgId=getorganizationId(um.getFinance_Organization());
					umapping.setOrganizationId(orgId);
					int verId=getverticalId(um.getFinance_Vertical());
					umapping.setVerticalId(verId);
					int locationId=getlocationId(um.getFinance_Location());
					umapping.setLocationId(locationId);
					int functionId=getfunctionId(um.getFinance_Function());
					umapping.setFunctionId(functionId);										
					user.setFinancemapping(umapping);
					userList.add(user);
				}
				
				for(LocationWiseFinanceMaster u:userList) {
					locationwiseFinanceMasterDao.save(u);
					
					LocationWiseFinanceMapping um=u.getFinancemapping();
					int uId=getfinanceId(u.getApproverUser1());
					um.setLocationwisefinanceId(uId);					
					locationwiseFinanceMappingDao.save(um);				
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file1.startsWith(Constants.Hr_Master_Data)) {
				
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

			    hrMaster = new ArrayList<HrMasterData>();
				for(CSVRecord record : parser){
					HrMasterData umaster = new HrMasterData();
					umaster.setHr_Organization(record.get(Constants.Hr_Organization));
					umaster.setHr_Vertical(record.get(Constants.Hr_Vertical));	
					umaster.setHr_Location(record.get(Constants.Hr_Location));
					umaster.setHr_Function(record.get(Constants.Hr_Function));
					umaster.setHr_Approver_User1(record.get(Constants.Hr_Approver_User1));
					umaster.setHr_Approver_User2(record.get(Constants.Hr_Approver_User2));
					hrMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<LocationWiseHrMaster> userList=new ArrayList<LocationWiseHrMaster>();
				for(HrMasterData um:hrMaster) {
					LocationWiseHrMaster user=new LocationWiseHrMaster();
					LocationWiseHrMapping umapping=new LocationWiseHrMapping();
					int userId=gethrId(um.getHr_Approver_User1(),um.getHr_Approver_User2());
					user.setLocationwisehrmasterId(userId);
					user.setApproverUser1(um.getHr_Approver_User1());
					user.setApproverUser2(um.getHr_Approver_User2());
					user.setUpdatedBy(Constants.Created_Updated_By);
					user.setCreatedDate(date);
					user.setUpdatedDate(date);
					user.setActive(true);
					
					int usermappId=gethrmappingId(userId);
					umapping.setLocationwisehrmappingId(usermappId);
					int orgId=getorganizationId(um.getHr_Organization());
					umapping.setOrganizationId(orgId);
					int verId=getverticalId(um.getHr_Vertical());
					umapping.setVerticalId(verId);
					int locationId=getlocationId(um.getHr_Location());
					umapping.setLocationId(locationId);
					int functionId=getfunctionId(um.getHr_Function());
					umapping.setFunctionId(functionId);										
					user.setHrmapping(umapping);
					userList.add(user);
				}
				
				for(LocationWiseHrMaster u:userList) {
					locationwiseHrMasterDao.save(u);
					
					LocationWiseHrMapping um=u.getHrmapping();
					int uId=gethrId(u.getApproverUser1(),u.getApproverUser2());
					um.setLocationwisehrmasterid(uId);					
					locationwiseHrMappingDao.save(um);				
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file1.startsWith(Constants.Railway_Agent_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

				railwayMaster = new ArrayList<RailwayMasterData>();
				for(CSVRecord record : parser){
					RailwayMasterData umaster = new RailwayMasterData();
					umaster.setRailway_Organization(record.get(Constants.Railway_Organization));
					umaster.setRailway_Vertical(record.get(Constants.Railway_Vertical));	
					umaster.setRailway_Location(record.get(Constants.Railway_Location));
					umaster.setRailway_Function(record.get(Constants.Railway_Function));
					umaster.setRailway_User1(record.get(Constants.Railway_User1));
					umaster.setRailway_User2(record.get(Constants.Railway_User2));
					railwayMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<LocationWiseRailwayAgentMaster> userList=new ArrayList<LocationWiseRailwayAgentMaster>();
				for(RailwayMasterData um:railwayMaster) {
					LocationWiseRailwayAgentMaster user=new LocationWiseRailwayAgentMaster();
					LocationWiseRailwayAgentMapping umapping=new LocationWiseRailwayAgentMapping();
					int userId=getrailwayagentId(um.getRailway_User1(),um.getRailway_User2());
					user.setLocationwiserailwaymasterId(userId);
					user.setUser1(um.getRailway_User1());
					user.setUser2(um.getRailway_User2());
					user.setUpdatedBy(Constants.Created_Updated_By);
					user.setCreatedDate(date);
					user.setUpdatedDate(date);
					user.setActive(true);
					
					int usermappId=getrailwaymappingId(userId);
					umapping.setLocationwiserailwaymappingId(usermappId);
					int orgId=getorganizationId(um.getRailway_Organization());
					umapping.setOrganizationId(orgId);
					int verId=getverticalId(um.getRailway_Vertical());
					umapping.setVerticalId(verId);
					int locationId=getlocationId(um.getRailway_Location());
					umapping.setLocationId(locationId);
					int functionId=getfunctionId(um.getRailway_Function());
					umapping.setFunctionId(functionId);										
					user.setRailwaymapping(umapping);
					userList.add(user);
				}
				
				for(LocationWiseRailwayAgentMaster u:userList) {
					locationwiseRailwayAgentMasterDao.save(u);
					
					LocationWiseRailwayAgentMapping um=u.getRailwaymapping();
					int uId=getrailwayagentId(u.getUser1(),u.getUser2());
					um.setLocationwiserailwaymasterid(uId);					
					locationwiseRailwayMappingDao.save(um);				
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}else if(file1.startsWith(Constants.Carpool_Master_Data)) {
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

				carpoolMaster = new ArrayList<CarpoolMasterData>();
				for(CSVRecord record : parser){
					CarpoolMasterData umaster = new CarpoolMasterData();
					umaster.setCarpool_Organization(record.get(Constants.Carpool_Organization));
					umaster.setCarpool_Vertical(record.get(Constants.Carpool_Vertical));	
					umaster.setCarpool_Location(record.get(Constants.Carpool_Location));
					umaster.setCarpool_Function(record.get(Constants.Carpool_Function));
					umaster.setCarpool_User1(record.get(Constants.Carpool_User1));
					umaster.setCarpool_User2(record.get(Constants.Carpool_User2));
					carpoolMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<LocationWiseCarpoolMaster> userList=new ArrayList<LocationWiseCarpoolMaster>();
				for(CarpoolMasterData um:carpoolMaster) {
					LocationWiseCarpoolMaster user=new LocationWiseCarpoolMaster();
					LocationWiseCarpoolMapping umapping=new LocationWiseCarpoolMapping();
					int userId=getcarpoolId(um.getCarpool_User1(),um.getCarpool_User2());
					user.setLocationwisecarpoolmasterId(userId);
					user.setUser1(um.getCarpool_User1());
					user.setUser2(um.getCarpool_User2());
					user.setUpdatedBy(Constants.Created_Updated_By);
					user.setCreatedDate(date);
					user.setUpdatedDate(date);
					user.setActive(true);
					
					int usermappId=getcarpoolmappingId(userId);
					umapping.setLocationwisecarpoolmappingId(usermappId);
					int orgId=getorganizationId(um.getCarpool_Organization());
					umapping.setOrganizationId(orgId);
					int verId=getverticalId(um.getCarpool_Vertical());
					umapping.setVerticalId(verId);
					int locationId=getlocationId(um.getCarpool_Location());
					umapping.setLocationId(locationId);
					int functionId=getfunctionId(um.getCarpool_Function());
					umapping.setFunctionId(functionId);										
					user.setCarpoolmapping(umapping);
					userList.add(user);
				}
				
				for(LocationWiseCarpoolMaster u:userList) {
					locationwiseCarpoolMasterDao.save(u);
					
					LocationWiseCarpoolMapping um=u.getCarpoolmapping();
					int uId=getcarpoolId(u.getUser1(),u.getUser2());
					um.setLocationwisecarpoolmasterid(uId);					
					locationwiseCarpoolMappingDao.save(um);				
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			}
				else if(file1.startsWith(Constants.Employee_User_Data)) {
				
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

			    userMaster = new ArrayList<UserMasterData>();
				for(CSVRecord record : parser){
					UserMasterData umaster = new UserMasterData();
					umaster.setUser_Organization(record.get(Constants.User_Organization));
					umaster.setUser_Vertical(record.get(Constants.User_Vertical));
					if(record.get(Constants.User_Category)!=null) {
						umaster.setUser_Category(record.get(Constants.User_Category));
					}

					umaster.setUser_Location(record.get(Constants.User_Location));
					umaster.setUser_CostCenter(record.get(Constants.User_Cost_center));
					umaster.setUser_Group(record.get(Constants.User_Group));
					if(record.get(Constants.Employee_Code)!=null && !record.get(Constants.Employee_Code).equals("")) {
						umaster.setEmployeeCode(Integer.parseInt(record.get(Constants.Employee_Code)));
					}
					umaster.setUserTitle(record.get(Constants.User_Title));
					umaster.setUserFirstName(record.get(Constants.User_First_name));
					umaster.setUserMiddleName(record.get(Constants.User_Middle_Name));
					umaster.setUserLastName(record.get(Constants.User_Last_Name));
					umaster.setUserEmailId(record.get(Constants.User_Email_id));
					umaster.setUserAddress(record.get(Constants.User_Address));
					umaster.setUserPin(record.get(Constants.User_Pin));
					umaster.setUserPhoneNumber(record.get(Constants.User_Phone_number));
					umaster.setUserDOB(record.get(Constants.User_DOB));
					umaster.setGender(record.get(Constants.Gender));
					umaster.setDepartment(record.get(Constants.Department));
					umaster.setSubdepartment(record.get(Constants.Sub_Department));
					umaster.setApprover1(record.get(Constants.Approver1));
					umaster.setApprover2(record.get(Constants.Approver2));
					umaster.setApprover3(record.get(Constants.Approver3));
					umaster.setApprovalRequired(record.get(Constants.Is_Approval_Required));
					umaster.setUserIsAllowedForTE(record.get(Constants.User_Is_Allowed_For_TE));
					umaster.setActive(record.get(Constants.Is_Active));					
					userMaster.add(umaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				
				List<User> userList=new ArrayList<User>();
				for(UserMasterData um:userMaster) {
					User user=new User();
					UserMapping umapping=new UserMapping();
					int userId=getUserId(um.getEmployeeCode());
					if(userId!=0) {
						user.setUserId(userId);
					}else {
						user.setUserId(userId);
					}
					user.setEmployeeCode(um.getEmployeeCode());
					user.setUserTitle(um.getUserTitle());
					user.setUserFirstName(um.getUserFirstName());
					user.setUserMiddleName(um.getUserMiddleName());
					user.setUserLastName(um.getUserLastName());
					user.setUserEmailId(um.getUserEmailId());
					user.setUserAddress(um.getUserAddress());
					user.setUserPin(um.getUserPin());
					user.setUserPhoneNumber(um.getUserPhoneNumber());
					if(um.getUserDOB()!=null && !um.getUserDOB().equals("")) {
						SimpleDateFormat format1 = new SimpleDateFormat(Constants.Date_Format);
						//String date1 = format1.format(e.getUserDOB());
						Date inActiveDate = null;
						try {

							inActiveDate = format1.parse(um.getUserDOB());

						} catch (ParseException e1) {
							logger.error("Parse error"+e1.getMessage());
						}
						user.setUserDOB(inActiveDate);
					}

					user.setGender(um.getGender());
					/*user.setDepartment(um.getDepartment());
					user.setSub_department(um.getSubdepartment());*/
					user.setApprover1(um.getApprover1());
					user.setApprover2(um.getApprover2());
					user.setApprover3(um.getApprover3());
					if(um.isApprovalRequired()!=null && !um.isApprovalRequired().equals("")) {
						if(um.isApprovalRequired().equalsIgnoreCase("true")) {
							user.setIsApprovalRequired(true);
						}else if(um.isApprovalRequired().equalsIgnoreCase("false")) {
							user.setIsApprovalRequired(false);
						}
					}

					if(um.isUserIsAllowedForTE()!=null && !um.isUserIsAllowedForTE().equals("")) {
						if(um.isUserIsAllowedForTE().equalsIgnoreCase("true")) {
							user.setUserIsAllowedForTE(true);
						}else if(um.isUserIsAllowedForTE().equalsIgnoreCase("false")) {
							user.setUserIsAllowedForTE(false);
						}
					}

					if(um.isActive()!=null && !um.isActive().equals("")) {
						if(um.isActive().equalsIgnoreCase("true")) {
							user.setIsActive(true);
						}else if(um.isActive().equalsIgnoreCase("false")) {
							user.setIsActive(false);
						}
					}
					user.setCreatedBy(Constants.Created_Updated_By);
					user.setUpdatedBy(Constants.Created_Updated_By);
					user.setCreatedDate(date);
					user.setUpdatedDate(date);
					
					int usermappId=getuserMappingId(userId);
					umapping.setUserMappingID(usermappId);
					int orgId=getorganizationId(um.getUser_Organization());
					umapping.setOrganizationID(orgId);
					int verId=getverticalId(um.getUser_Vertical());
					umapping.setVerticalID(verId);
					int catId=getcategoryId(um.getUser_Category());
					umapping.setCategoryID(catId);
					int usergroupid=getusergroupId(um.getUser_Group());
					umapping.setUserGoupId(usergroupid);
					int locationId=getlocationId(um.getUser_Location());
					umapping.setUserLocationID(locationId);
					int costcenId=getcostcenterId(um.getUser_CostCenter());
					umapping.setUserCostcenterID(costcenId);
					int depId=getdepartmentId(um.getDepartment());
					umapping.setDepartmentID(depId);
					int subdepId=getsubdepartmentId(um.getSubdepartment());
					umapping.setSub_departmentID(subdepId);					
					user.setUsermapping(umapping);
					userList.add(user);
					
					
				}
				
				for(User u:userList) {
					userDaoRepo.save(u);
					
					UserMapping um=u.getUsermapping();
					int uId=getUserId(u.getEmployeeCode());
					um.setUserId(uId);
					
					userMappingDaoRepo.save(um);					
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
			} 
			else if(file1.startsWith(Constants.Retainer_NonEmployee_User_Data)) {
				
				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

				//initialize the CSVParser object
				CSVParser parser = null;
				try {
					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
				} catch (FileNotFoundException e3) {
					logger.error("File Not found"+e3.getMessage());
				} catch (IOException e3) {
					logger.error("Input output"+e3.getMessage());
				}

			    retainerMaster = new ArrayList<RetainerMasterData>();
			    for(CSVRecord record : parser){
			    	RetainerMasterData rmaster = new RetainerMasterData();
			    	rmaster.setUser_Organization(record.get(Constants.Retainer_Organization));
			    	rmaster.setUser_Vertical(record.get(Constants.Retainer_Vertical));
					if(record.get(Constants.Retainer_Category)!=null) {
						rmaster.setUser_Category(record.get(Constants.Retainer_Category));
					}

					rmaster.setUser_Location(record.get(Constants.Retainer_Location));
					rmaster.setUser_CostCenter(record.get(Constants.Retainer_Cost_center));
					rmaster.setUser_Group(record.get(Constants.Retainer_Group));
					if(record.get(Constants.Retainer_Employee_Code)!=null && !record.get(Constants.Retainer_Employee_Code).equals("")) {
						rmaster.setUser_EmployeeCode(Integer.parseInt(record.get(Constants.Retainer_Employee_Code)));
					}
					rmaster.setUserTitle(record.get(Constants.Retainer_Title));
					rmaster.setUserFirstName(record.get(Constants.Retainer_First_name));
					rmaster.setUserMiddleName(record.get(Constants.Retainer_Middle_Name));
					rmaster.setUserLastName(record.get(Constants.Retainer_Last_Name));
					rmaster.setUserEmailId(record.get(Constants.Retainer_Email_id));
					rmaster.setUserAddress(record.get(Constants.Retainer_Address));
					rmaster.setUserPin(record.get(Constants.Retainer_Pin));
					rmaster.setUserPhoneNumber(record.get(Constants.Retainer_Phone_number));
					rmaster.setUserDOB(record.get(Constants.Retainer_DOB));
					rmaster.setGender(record.get(Constants.Retainer_Gender));
					rmaster.setActive(record.get(Constants.Retainer_Is_Active));					
					retainerMaster.add(rmaster);
				}
				try {
					parser.close();
				} catch (IOException e2) {
					logger.error("Input output"+e2.getMessage());
				}
				List<Retainer> retainerList=new ArrayList<Retainer>();
				for(RetainerMasterData e:retainerMaster) {
					Retainer retainer=new Retainer();
					RetainerMapping retmapping=new RetainerMapping();
					    int retId=getRetainerId(e.getUser_EmployeeCode());
					    retainer.setRetainerId(retId);
					    retainer.setRetaineremployeecode(e.getUser_EmployeeCode());
					    retainer.setUserTitle(e.getUserTitle());
						retainer.setUserFirstName(e.getUserFirstName());
						retainer.setUserMiddleName(e.getUserMiddleName());
						retainer.setUserLastName(e.getUserLastName());
						retainer.setUserEmailId(e.getUserEmailId());
						retainer.setUserAddress(e.getUserAddress());
						retainer.setUserPin(e.getUserPin());
						retainer.setUserPhoneNumber(e.getUserPhoneNumber());
					if(e.getUserDOB()!=null && !e.getUserDOB().equals("")) {
						SimpleDateFormat format1 = new SimpleDateFormat(Constants.Date_Format);
						//String date1 = format1.format(e.getUserDOB());
						Date inActiveDate = null;
						try {

							inActiveDate = format1.parse(e.getUserDOB());

						} catch (ParseException e1) {
							logger.error("Parse error"+e1.getMessage());
						}
						retainer.setUserDOB(inActiveDate);
					}

					retainer.setGender(e.getGender());
					

					if(e.isActive()!=null && !e.isActive().equals("")) {
						if(e.isActive().equalsIgnoreCase("true")) {
							retainer.setActive(true);
						}else if(e.isActive().equalsIgnoreCase("false")) {
							retainer.setActive(false);
						}
					}
					retainer.setCreatedBy(Constants.Created_Updated_By);
					retainer.setUpdatedBy(Constants.Created_Updated_By);
					retainer.setCreatedDate(date);
					retainer.setUpdatedDate(date);
					int retainermappId=getretainerMappingId(retId);
					retmapping.setRetainerMappingID(retainermappId);
					int orgId=getorganizationId(e.getUser_Organization());
					retmapping.setOrganizationID(orgId);
					int verId=getverticalId(e.getUser_Vertical());
					retmapping.setVerticalID(verId);
					int catId=getcategoryId(e.getUser_Category());
					retmapping.setCategoryID(catId);
					int usergroupid=getusergroupId(e.getUser_Group());
					retmapping.setUserGoupId(usergroupid);
					int locationId=getlocationId(e.getUser_Location());
					retmapping.setUserLocationID(locationId);
					int costcenId=getcostcenterId(e.getUser_CostCenter());
					retmapping.setUserCostcenterID(costcenId);
					retainer.setRetainermapping(retmapping);					
					retainerList.add(retainer);
				}
				
				for(Retainer u:retainerList) {
					retainerDaoRepo.save(u);
					
					RetainerMapping um=u.getRetainermapping();
					int rId=getRetainerId(u.getRetaineremployeecode());
					um.setRetainerId(rId);					
					reatinerMappingDaoRepo.save(um);					
				}
				try {
					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					logger.error("Input output"+e.getMessage());
				}
				 
               }else if(file1.startsWith(Constants.Entilement_Data)) {
   				
   				CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
   				//initialize the CSVParser object
   				CSVParser parser = null;
   				try {
   					parser = new CSVParser(new FileReader(mappingdataPath+file1), format);
   				} catch (FileNotFoundException e3) {
   					logger.error("File Not found"+e3.getMessage());
   				} catch (IOException e3) {
   					logger.error("Input output"+e3.getMessage());
   				}

   				entitlementMaster = new ArrayList<EntitlementMasterData>();
   			    for(CSVRecord record : parser){
   			    	EntitlementMasterData rmaster = new EntitlementMasterData();
   			    	rmaster.setOrganization(record.get(Constants.Entilement_Organization));
   			    	rmaster.setVertical(record.get(Constants.Entilement_Vertical));
					rmaster.setCategory(record.get(Constants.Entilement_Category));
   					rmaster.setEmployeegroup(record.get(Constants.Entilement_Employee_Group));
   					rmaster.setIsFlightAllowed(record.get(Constants.Entilement_Is_Flight_Allowed));
   					rmaster.setFlightClass(record.get(Constants.Entilement_Flight_Class));
					rmaster.setEntitledFlightAmount(record.get(Constants.Entilement_Entitled_Flight_Amount));
   					rmaster.setIsTrainAllowed(record.get(Constants.Entilement_Is_Train_Allowed));
   					rmaster.setTrainClass(record.get(Constants.Entilement_Train_Class));
   					rmaster.setEntitledTrainAmount(record.get(Constants.Entilement_Entitled_Train_Amount));
   					rmaster.setIsCarPoolAllowed(record.get(Constants.Entilement_Is_Car_Pool_Allowed));
   					rmaster.setLocalConvenyanceAmount(record.get(Constants.Entilement_Local_Convenyance_Amount));
   					rmaster.setSelfAccomodationAmount(record.get(Constants.Entilement_Self_Accomodation_Amount));
   					rmaster.setNightTripAmount(record.get(Constants.Entilement_Night_Trip_Amount));
   					rmaster.setTripSubmissionDueDate(record.get(Constants.Entilement_Trip_Submission_Due_Date));
   					rmaster.setAdvanceSettlementAmountPercentage(record.get(Constants.Entilement_Advance_Settlement_Amount_Percentage));
   					rmaster.setCitycategoryA_amount(record.get(Constants.Entilement_City_CategoryA));
   					rmaster.setCitycategoryB_amount(record.get(Constants.Entilement_City_CategoryB));	
   					rmaster.setCitycategoryC_amount(record.get(Constants.Entilement_City_CategoryC));
   					entitlementMaster.add(rmaster);
   				}
   				try {
   					parser.close();
   				} catch (IOException e2) {
   					logger.error("Input output"+e2.getMessage());
   				}
   				List<TravelEntitlement> travelentitlementList=new ArrayList<TravelEntitlement>();
   				
   				for(EntitlementMasterData e:entitlementMaster) {
   					TravelEntitlement entitlement=new TravelEntitlement();
   					List<TravelCityEntitlement> travelcityentitlementList=new ArrayList<TravelCityEntitlement>();
   					TravelCityEntitlement cityentitlementa=new TravelCityEntitlement();
   					TravelCityEntitlement cityentitlementb=new TravelCityEntitlement();
   					TravelCityEntitlement cityentitlementc=new TravelCityEntitlement();
   					
   					   int orgid=getorganizationId(e.getOrganization());
   					   int verid=getverticalId(e.getVertical());
   					   int catid=getcategoryId(e.getCategory());
   					   int grpid=getusergroupId(e.getEmployeegroup());
   					   int entitlementid=getentitlementid(orgid, verid, catid, grpid);
   					   entitlement.setEntitlementID(entitlementid);
   					   entitlement.setOrganizationID(orgid);
   					   entitlement.setVerticalID(verid);
   					   entitlement.setCategoryID(catid);
   					   entitlement.setUsergroupID(grpid);
   					   if(e.getIsFlightAllowed()!=null && !e.getIsFlightAllowed().equals("")) {
   						if(e.getIsFlightAllowed().equalsIgnoreCase("yes")) {
   							entitlement.setFlightAllowed(true);
   						}else if(e.getIsFlightAllowed().equalsIgnoreCase("no")) {
   							entitlement.setFlightAllowed(false);
   						}
   						}
   					   entitlement.setFlightClass(e.getFlightClass());
   					   if(e.getEntitledFlightAmount()!=null && !e.getEntitledFlightAmount().equals("")) {
   						entitlement.setEntitledFlightAmount(Double.parseDouble(e.getEntitledFlightAmount()));
   					   }
   					   if(e.getIsTrainAllowed()!=null && !e.getIsTrainAllowed().equals("")) {
   						if(e.getIsTrainAllowed().equalsIgnoreCase("yes")) {
   							entitlement.setTrainAllowed(true);
   						}else if(e.getIsTrainAllowed().equalsIgnoreCase("no")) {
   							entitlement.setTrainAllowed(false);
   						}
   						}
   					   entitlement.setTrainClass(e.getTrainClass());
   					   if(e.getEntitledTrainAmount()!=null && !e.getEntitledTrainAmount().equals("")) {
   						entitlement.setEntitledTrainAmount(Double.parseDouble(e.getEntitledTrainAmount()));
   					   }
   					 if(e.getIsCarPoolAllowed()!=null && !e.getIsCarPoolAllowed().equals("")) {
    						if(e.getIsCarPoolAllowed().equalsIgnoreCase("yes")) {
    							entitlement.setCarPoolAllowed(true);
    						}else if(e.getIsCarPoolAllowed().equalsIgnoreCase("no")) {
    							entitlement.setCarPoolAllowed(false);
    						}
    					}
   					 if(e.getLocalConvenyanceAmount()!=null && !e.getLocalConvenyanceAmount().equals("")) {
    						entitlement.setLocalConvenyanceAmount(Double.parseDouble(e.getLocalConvenyanceAmount()));
    					   }
   					 if(e.getSelfAccomodationAmount()!=null && !e.getSelfAccomodationAmount().equals("")) {
 						entitlement.setSelfAccomodationAmount(Double.parseDouble(e.getSelfAccomodationAmount()));
 					   }
   					if(e.getNightTripAmount()!=null && !e.getNightTripAmount().equals("")) {
 						entitlement.setNightTripAmount(Double.parseDouble(e.getNightTripAmount()));
 					   }
   					if(e.getTripSubmissionDueDate()!=null && !e.getTripSubmissionDueDate().equals("")) {
   					entitlement.setTripSubmissionDueDate(Integer.parseInt(e.getTripSubmissionDueDate()));
   					}
   					entitlement.setAdvanceSettlementAmountPercentage(e.getAdvanceSettlementAmountPercentage());
   					entitlement.setActive(true);
   					entitlement.setCreatedBy(Constants.Created_Updated_By);
   					entitlement.setUpdatedBy(Constants.Created_Updated_By);
   					entitlement.setCreatedDate(date);
   					entitlement.setUpdatedDate(date);
   					int cityCategoryAid=getcitycategoryId("A");
   					int cityCategoryBid=getcitycategoryId("B");
   					int cityCategoryCid=getcitycategoryId("C");
   					
   					int cityentida=getentitlementcityid(cityCategoryAid,entitlementid);
   					cityentitlementa.setTravelCityEntitlementId(cityentida);
   					if(entitlementid!=0) {
   					cityentitlementa.setEntitlementid(entitlementid);
   					}
   					cityentitlementa.setCityCategoryId(cityCategoryAid);
   					if(e.getCitycategoryA_amount()!=null && !e.getCitycategoryA_amount().equals("")) {
   						cityentitlementa.setAmount(Double.parseDouble(e.getCitycategoryA_amount()));
 					   }
   					cityentitlementa.setActive(true);
   					cityentitlementa.setCreatedBy(Constants.Created_Updated_By);
   					cityentitlementa.setUpdatedBy(Constants.Created_Updated_By);
   					cityentitlementa.setCreatedDate(date);
   					cityentitlementa.setUpdatedDate(date);
   					
   					int cityentidb=getentitlementcityid(cityCategoryBid,entitlementid);
   					cityentitlementb.setTravelCityEntitlementId(cityentidb);
   					if(entitlementid!=0) {
   						cityentitlementb.setEntitlementid(entitlementid);
   					}
   					
   					cityentitlementb.setCityCategoryId(cityCategoryBid);
   					if(e.getCitycategoryB_amount()!=null && !e.getCitycategoryB_amount().equals("")) {
   						cityentitlementb.setAmount(Double.parseDouble(e.getCitycategoryB_amount()));
 					   }
   					cityentitlementb.setActive(true);
   					cityentitlementb.setCreatedBy(Constants.Created_Updated_By);
   					cityentitlementb.setUpdatedBy(Constants.Created_Updated_By);
   					cityentitlementb.setCreatedDate(date);
   					cityentitlementb.setUpdatedDate(date);
   					
   					int cityentidc=getentitlementcityid(cityCategoryCid,entitlementid);
   					cityentitlementc.setTravelCityEntitlementId(cityentidc);
   					if(entitlementid!=0) {
   					cityentitlementc.setEntitlementid(entitlementid);
   					}
   					cityentitlementc.setCityCategoryId(cityCategoryCid);
   					if(e.getCitycategoryC_amount()!=null && !e.getCitycategoryC_amount().equals("")) {
   						cityentitlementc.setAmount(Double.parseDouble(e.getCitycategoryC_amount()));
 					   }
   					cityentitlementc.setActive(true);
   					cityentitlementc.setCreatedBy(Constants.Created_Updated_By);
   					cityentitlementc.setUpdatedBy(Constants.Created_Updated_By);
   					cityentitlementc.setCreatedDate(date);
   					cityentitlementc.setUpdatedDate(date);
   					
   					travelcityentitlementList.add(cityentitlementa);
   					travelcityentitlementList.add(cityentitlementb);
   					travelcityentitlementList.add(cityentitlementc);
   					entitlement.setCityentitlement(travelcityentitlementList);		
   					travelentitlementList.add(entitlement);
   				}
   				
   				for(TravelEntitlement u:travelentitlementList) {
   					travelEntitlementDao.save(u);
   					
   					/*RetainerMapping um=u.getRetainermapping();
   					int rId=getRetainerId(u.getRetaineremployeecode());
   					um.setRetainerId(rId);					
   					reatinermappingdaoRepo.save(um);*/					
   				}
   				try {
   					Files.move(Paths.get(mappingdataPath+file1), Paths.get(archivePath+file1),StandardCopyOption.REPLACE_EXISTING);
   				} catch (IOException e) {
   					logger.error("Input output"+e.getMessage());
   				}
   				 
                  }
		}
		
		}
      

	logger.info("Master data insertion process end");   

	
	//return organisationList;
	
}

/*@Override
public List<Organization> findAll() {
	return adminDaoRepository.findAll();
}*/

@Override
public List<User> getalluser(){
	List<User> user=userDaoRepo.findAll();
	for(User u:user) {
		UserMapping um=u.getUsermapping();
		
		um.setOrgamizationName(getorganizationName(um.getOrganizationID()));
		um.setVerticalName(getverticalName(um.getVerticalID()));
		um.setCategoryName(getcatgeroryName(um.getCategoryID()));
		um.setUserGroupName(getgroupName(um.getUserGoupId()));
		um.setLocationName(getlocationName(um.getUserLocationID()));
		um.setCostcenterName(getcostcenterName(um.getUserCostcenterID()));
		um.setDepartmentName(getdepartmentName(um.getDepartmentID()));
		um.setSubdepartmentName(getsubdepartmentName(um.getSub_departmentID()));
		
	}
	return user;
}

@Override
public List<UserDetails> getUserInfo(String searchparam){
	
	//List<User> user=userdaoRepo.findAll();
	
	List<User> user=userDaoRepo.findByempcodeemailid(searchparam.toLowerCase());
     
     List<UserDetails> userdetailsList=new ArrayList<UserDetails>();
	//List<UserInfo> uinfo=null;
	for(User u:user) {
		UserMapping um=u.getUsermapping();
		UserDetails userdetails=new UserDetails();
		UserInfo uinfo=new UserInfo();
		uinfo.setId(u.getUserId());
		uinfo.setValue(Integer.toString(u.getUserId()));
		uinfo.setFlag(false);
		userdetails.setUserId(uinfo);
		/*if(u.getUserLocationID()!=0) {
			UserInfo uinfo1=new UserInfo();
			uinfo1.setName(Integer.toString(u.getUserLocationID()));
			uinfo1.setFlag(false);
			userdetails.setUserLocationID(uinfo1);
		}
		if(u.getUserCostcenterID()!=0) {
			UserInfo uinfo2=new UserInfo();
			uinfo2.setName(Integer.toString(u.getUserCostcenterID()));
			uinfo2.setFlag(false);
			userdetails.setUserCostcenterID(uinfo2);
		}
		if(u.getUserGoupId()!=0) {
			UserInfo uinfo3=new UserInfo();
			uinfo3.setName(Integer.toString(u.getUserGoupId()));
			uinfo3.setFlag(false);
			userdetails.setUserGoupId(uinfo3);
		}
		*/
		if(u.getEmployeeCode()!=0) {
			UserInfo uinfo4=new UserInfo();
			uinfo4.setValue(Integer.toString(u.getEmployeeCode()));
			uinfo4.setFlag(false);
			userdetails.setEmployeecode(uinfo4);
		}
		UserInfo uinfo5=new UserInfo();
		uinfo5.setValue(u.getUserTitle());
		uinfo5.setFlag(true);
		userdetails.setUsertitle(uinfo5);
		
		UserInfo uinfo6=new UserInfo();
		uinfo6.setValue(u.getUserFirstName());
		uinfo6.setFlag(true);
		userdetails.setUserFirstName(uinfo6);
		
		UserInfo uinfo7=new UserInfo();
		uinfo7.setValue(u.getUserMiddleName());
		uinfo7.setFlag(true);
		userdetails.setUserMiddleName(uinfo7);
		
		UserInfo uinfo8=new UserInfo();
		uinfo8.setValue(u.getUserLastName());
		uinfo8.setFlag(true);
		userdetails.setUserLastName(uinfo8);
		
		UserInfo uinfo9=new UserInfo();
		uinfo9.setValue(u.getUserEmailId());
		uinfo9.setFlag(true);
		userdetails.setUserEmailId(uinfo9);
		
		UserInfo uinfo10=new UserInfo();
		uinfo10.setValue(u.getUserAddress());
		uinfo10.setFlag(true);
		userdetails.setUserAddress(uinfo10);
		
		UserInfo uinfo11=new UserInfo();
		uinfo11.setValue(u.getUserPin());
		uinfo11.setFlag(true);
		userdetails.setUserPin(uinfo11);
		
		UserInfo uinfo12=new UserInfo();
		uinfo12.setValue(u.getUserPhoneNumber());
		uinfo12.setFlag(true);
		userdetails.setUserPhoneNumber(uinfo12);
		
		UserInfo uinfo13=new UserInfo();
		uinfo13.setValue(Boolean.toString(u.isUserIsAllowedForTE()));
		uinfo13.setFlag(true);
		userdetails.setUserIsAllowedForTE(uinfo13);
		
		UserInfo uinfo14=new UserInfo();
		String strDate=null;
		if(u.getUserDOB()!=null && !u.getUserDOB().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat(Constants.Date_Format);  
			strDate = dateFormat.format(u.getUserDOB());  
				
		}
		uinfo14.setValue(strDate);
		uinfo14.setFlag(true);
		userdetails.setUserDOB(uinfo14);
		
		UserInfo uinfo15=new UserInfo();
		uinfo15.setValue(u.getGender());
		uinfo15.setFlag(true);
		userdetails.setGender(uinfo15);
		
		UserInfo uinfo16=new UserInfo();
		uinfo16.setValue(u.getApprover1());
		uinfo16.setFlag(true);
		userdetails.setApprover1(uinfo16);
		
		UserInfo uinfo17=new UserInfo();
		uinfo17.setValue(u.getApprover2());
		uinfo17.setFlag(true);
		userdetails.setApprover2(uinfo17);
		
		UserInfo uinfo18=new UserInfo();
		uinfo18.setValue(u.getApprover3());
		uinfo18.setFlag(true);
		userdetails.setApprover3(uinfo18);
		
		UserInfo uinfo19=new UserInfo();
		uinfo19.setValue(u.getCreatedBy());
		uinfo19.setFlag(true);
		userdetails.setCreatedBy(uinfo19);
		
		UserInfo uinfo20=new UserInfo();
		String strDate1=null;
		if(u.getCreatedDate()!=null && !u.getCreatedDate().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat(Constants.Date_Format);  
			strDate1 = dateFormat.format(u.getCreatedDate());  
				
		}
		uinfo20.setValue(strDate1);
		uinfo20.setFlag(true);
		userdetails.setCreatedDate(uinfo20);
		
		UserInfo uinfo21=new UserInfo();
		uinfo21.setValue(u.getUpdatedBy());
		uinfo21.setFlag(true);
		userdetails.setUpdatedBy(uinfo21);
		
		UserInfo uinfo22=new UserInfo();
		String strDate2=null;
		if(u.getUpdatedDate()!=null && !u.getUpdatedDate().equals("")) {
			DateFormat dateFormat = new SimpleDateFormat(Constants.Date_Format);  
			strDate2 = dateFormat.format(u.getUpdatedDate());  
				
		}
		uinfo22.setValue(strDate2);
		uinfo22.setFlag(true);
		userdetails.setUpdatedDate(uinfo22);
		
		UserInfo uinfo23=new UserInfo();
		uinfo23.setValue(Boolean.toString(u.isActive()));
		uinfo23.setFlag(true);
		userdetails.setIsActive(uinfo23);
		
		UserInfo uinfo230=new UserInfo();
		uinfo230.setValue(Boolean.toString(u.isApprovalRequired()));
		uinfo230.setFlag(true);
		userdetails.setIsapproverrequired(uinfo230);
		
		UserInfo uinfo24=new UserInfo();
		uinfo24.setId(um.getOrganizationID());
		uinfo24.setValue(getorganizationName(um.getOrganizationID()));
		uinfo24.setFlag(true);
		uinfo24.setData(getOrganizationList());
		userdetails.setOrganization(uinfo24);
		
		UserInfo uinfo25=new UserInfo();
		uinfo25.setId(um.getVerticalID());
		uinfo25.setValue(getverticalName(um.getVerticalID()));
		uinfo25.setFlag(true);
		uinfo25.setData(getverticalList());
		userdetails.setVertical(uinfo25);
		
		UserInfo uinfo26=new UserInfo();
		uinfo26.setId(um.getCategoryID());
		uinfo26.setValue(getcatgeroryName(um.getCategoryID()));
		uinfo26.setFlag(true);
		uinfo26.setData(getcategoryList());
		userdetails.setCategory(uinfo26);
		
		UserInfo uinfo27=new UserInfo();
		uinfo27.setId(um.getUserGoupId());
		uinfo27.setValue(getgroupName(um.getUserGoupId()));
		uinfo27.setFlag(true);
		uinfo27.setData(getusergroupList());
		userdetails.setUsergroup(uinfo27);
		
		UserInfo uinfo28=new UserInfo();
		uinfo28.setId(um.getUserCostcenterID());
		uinfo28.setValue(getcostcenterName(um.getUserCostcenterID()));
		uinfo28.setFlag(true);
		uinfo28.setData(getcostcenterList());
		userdetails.setCostcenter(uinfo28);
		
		UserInfo uinfo29=new UserInfo();
		uinfo29.setId(um.getUserLocationID());
		uinfo29.setValue(getlocationName(um.getUserLocationID()));
		uinfo29.setFlag(true);
		uinfo29.setData(getlocationList());
		userdetails.setLocation(uinfo29);
		
		UserInfo uinfo30=new UserInfo();
		uinfo30.setId(um.getDepartmentID());
		uinfo30.setValue(getdepartmentName(um.getDepartmentID()));
		uinfo30.setFlag(true);
		uinfo30.setData(getdepartmentList());
		userdetails.setDepartment(uinfo30);
		
		UserInfo uinfo31=new UserInfo();
		uinfo31.setId(um.getSub_departmentID());
		uinfo31.setValue(getsubdepartmentName(um.getSub_departmentID()));
		uinfo31.setFlag(true);
		uinfo31.setData(getsubdepartmentList());
		userdetails.setSubdepartment(uinfo31);
		
		UserInfo uinfo32=new UserInfo();
		uinfo32.setId(um.getUserMappingID());
		uinfo32.setValue(Integer.toString(um.getUserMappingID()));
		uinfo32.setFlag(true);
		userdetails.setUsermappingid(uinfo32);
		
		
		userdetailsList.add(userdetails);
	}
	
	return userdetailsList;
	
}

@Override
public List<UserDetails> updateUserInfo(List<UserDetails> userdetails){
	Date date=new Date();
	List<User> userlist=new ArrayList<User>();
	for(UserDetails ud:userdetails) {
		User user=new User();
		UserMapping um=new UserMapping();
		UserInfo uf=ud.getUserId();
		int userId=Integer.parseInt(uf.getValue());
		UserInfo uf1=ud.getEmployeecode();
		String employeecode=uf1.getValue();
		UserInfo uf2=ud.getUsertitle();
		String userTitle=uf2.getValue();
		UserInfo uf3=ud.getUserFirstName();
		String userfirstname=uf3.getValue();
		UserInfo uf4=ud.getUserMiddleName();
		String usermiddlename=uf4.getValue();
		UserInfo uf5=ud.getUserLastName();
		String userlastname=uf5.getValue();
		UserInfo uf6=ud.getUserEmailId();
		String useremailid=uf6.getValue();
		UserInfo uf7=ud.getUserAddress();
		String useraddress=uf7.getValue();
		UserInfo uf8=ud.getUserPin();
		String userpin=uf8.getValue();
		UserInfo uf9=ud.getUserPhoneNumber();
		String userphoneno=uf9.getValue();
		UserInfo uf10=ud.getUserIsAllowedForTE();
		String userisallowedforTe=uf10.getValue();
		UserInfo uf11=ud.getUserDOB();
		String userdob=uf11.getValue();
		UserInfo uf12=ud.getGender();
		String usergender=uf12.getValue();
		UserInfo uf13=ud.getApprover1();
		String userapprove1=uf13.getValue();
		UserInfo uf14=ud.getApprover2();
		String userapprove2=uf14.getValue();
		UserInfo uf15=ud.getApprover3();
		String userapprove3=uf15.getValue();
		UserInfo uf16=ud.getCreatedBy();
		String usercreatedby=uf16.getValue();
		UserInfo uf17=ud.getCreatedDate();
		String usercreateddate=uf17.getValue();
		UserInfo uf18=ud.getUpdatedBy();
		String userupdatedby=uf18.getValue();
		UserInfo uf19=ud.getUpdatedDate();
		String userupdateddate=uf19.getValue();
		UserInfo uf20=ud.getIsActive();
		String userisactive=uf20.getValue();
		UserInfo uf21=ud.getOrganization();
		String userorganization=uf21.getValue();
		UserInfo uf22=ud.getVertical();
		String uservertical=uf22.getValue();
		UserInfo uf23=ud.getCategory();
		String usercategory=uf23.getValue();
		UserInfo uf24=ud.getUsergroup();
		String usergroup=uf24.getValue();
		UserInfo uf25=ud.getDepartment();
		String userdepartment=uf25.getValue();
		UserInfo uf26=ud.getSubdepartment();
		String usersubdepartment=uf26.getValue();
		UserInfo uf27=ud.getCostcenter();
		String usercostcenter=uf27.getValue();
		UserInfo uf28=ud.getLocation();
		String userlocation=uf28.getValue();
		UserInfo uf29=ud.getUsermappingid();
		String usermappingid=uf29.getValue();
		UserInfo uf30=ud.getIsapproverrequired();
		String userisapproverequired=uf30.getValue();
		
		
		
		user.setUserId(userId);
		if(employeecode!=null && !employeecode.equals("")) {
			user.setEmployeeCode(Integer.parseInt(employeecode));	
		}		
		user.setUserTitle(userTitle);
		user.setUserFirstName(userfirstname);
		user.setUserMiddleName(usermiddlename);
		user.setUserLastName(userlastname);
		user.setUserEmailId(useremailid);
		user.setUserAddress(useraddress);
		user.setUserPin(userpin);
		user.setUserPhoneNumber(userphoneno);
		if(userdob!=null && !userdob.equals("")) {
			SimpleDateFormat format1 = new SimpleDateFormat(Constants.Date_Format);
			Date inActiveDate = null;
			try {

				inActiveDate = format1.parse(userdob);

			} catch (ParseException e1) {
				logger.error("Parse error"+e1.getMessage());
			}
			user.setUserDOB(inActiveDate);
		}

		user.setGender(usergender);
		/*user.setDepartment(um.getDepartment());
		user.setSub_department(um.getSubdepartment());*/
		user.setApprover1(userapprove1);
		user.setApprover2(userapprove2);
		user.setApprover3(userapprove3);
		if(userisapproverequired!=null && !userisapproverequired.equals("")) {
			if(userisapproverequired.equalsIgnoreCase("true") || userisapproverequired.equalsIgnoreCase("yes")) {
				user.setIsApprovalRequired(true);
			}else if(userisapproverequired.equalsIgnoreCase("false") || userisapproverequired.equalsIgnoreCase("no")) {
				user.setIsApprovalRequired(false);
			}
		}

		if(userisallowedforTe!=null && !userisallowedforTe.equals("")) {
			if(userisallowedforTe.equalsIgnoreCase("true") || userisallowedforTe.equalsIgnoreCase("yes")) {
				user.setUserIsAllowedForTE(true);
			}else if(userisallowedforTe.equalsIgnoreCase("false") || userisallowedforTe.equalsIgnoreCase("no")) {
				user.setUserIsAllowedForTE(false);
			}
		}

		if(userisactive!=null && !userisactive.equals("")) {
			if(userisactive.equalsIgnoreCase("true") || userisactive.equalsIgnoreCase("yes")) {
				user.setIsActive(true);
			}else if(userisactive.equalsIgnoreCase("false") || userisactive.equalsIgnoreCase("no")) {
				user.setIsActive(false);
			}
		}
		user.setCreatedBy(Constants.Created_Updated_By);
		user.setUpdatedBy(Constants.Created_Updated_By);
		if(userdob!=null && !userdob.equals("")) {
			SimpleDateFormat format2 = new SimpleDateFormat(Constants.Date_Format);
			Date inActiveDate1 = null;
			try {

				inActiveDate1 = format2.parse(userdob);

			} catch (ParseException e1) {
				logger.error("Parse error"+e1.getMessage());
			}
			user.setCreatedDate(inActiveDate1);
		}
		
		user.setUpdatedDate(date);
		
		um.setUserMappingID(Integer.parseInt(usermappingid));
		int orgId=getorganizationId(userorganization);
		um.setOrganizationID(orgId);
		int verId=getverticalId(uservertical);
		um.setVerticalID(verId);
		int catId=getcategoryId(usercategory);
		um.setCategoryID(catId);
		int usergroupid=getusergroupId(usergroup);
		um.setUserGoupId(usergroupid);
		int locationId=getlocationId(userlocation);
		um.setUserLocationID(locationId);
		int costcenId=getcostcenterId(usercostcenter);
		um.setUserCostcenterID(costcenId);
		int depId=getdepartmentId(userdepartment);
		um.setDepartmentID(depId);
		int subdepId=getsubdepartmentId(usersubdepartment);
		um.setSub_departmentID(subdepId);
		um.setUserId(userId);
		user.setUsermapping(um);
		userlist.add(user);
	}
	
	for(User u:userlist) {
		userDaoRepo.save(u);
		UserMapping umapp=u.getUsermapping();
		userMappingDaoRepo.save(umapp);
		
	}
	
	return userdetails;
	
}



public int getUserId(int empcode) {
	int userId=0;
	List<User> user=userDaoRepo.findByemployeeCode(empcode);
	for(User u:user) {
		userId=u.getUserId();
	}
	return userId;
	
}

public int getorganizationId(String orgname) {
	int orgId=0;
	List<OrganizationMaster> orgmaster=orgMasterDao.findByOrganizationName(orgname.toLowerCase());
	for(OrganizationMaster o:orgmaster) {
		orgId=o.getOrganizationmasterId();
	}
	return orgId;	
}

public String getorganizationName(int orgid) {
	String orgname="";
	Optional<OrganizationMaster> orgmaster=orgMasterDao.findById(orgid);
	OrganizationMaster org=orgmaster.get();
	orgname=org.getOrganizationName();
	return orgname;	
}

public int getverticalId(String verticalname) {
	int verticalId=0;
	List<VerticalMaster> vertmaster=verticalMasterDao.findByVerticalName(verticalname.toLowerCase());
	for(VerticalMaster v:vertmaster) {
		verticalId=v.getVerticalmasterId();
	}
	return verticalId;	
}

public String getverticalName(int verticalid) {
	String orgname="";
	Optional<VerticalMaster> orgmaster=verticalMasterDao.findById(verticalid);
	VerticalMaster org=orgmaster.get();
	orgname=org.getVerticalName();
	return orgname;	
}

public int getcategoryId(String categoryname) {
	int categoryId=0;
	List<CategoryMaster> catmaster=categoryMasterDao.findBycategoryName(categoryname.toLowerCase());
	for(CategoryMaster c:catmaster) {
		categoryId=c.getCategoryMasterId();
	}
	return categoryId;	
}

public String getcatgeroryName(int catid) {
	String orgname="";
	Optional<CategoryMaster> orgmaster=categoryMasterDao.findById(catid);
	CategoryMaster org=orgmaster.get();
	orgname=org.getCategoryName();
	return orgname;	
}

public int getcitycategoryId(String categoryname) {
	int categoryId=0;
	List<CityCategoryMaster> catmaster=cityCategoryMasterRepo.findByCategoryName(categoryname.toLowerCase());
	for(CityCategoryMaster c:catmaster) {
		categoryId=c.getCityCategoryId();
	}
	return categoryId;	
}

public int getusergroupId(String groupname) {
	int groupId=0;
	List<UserGroupMaster> umaster=userGroupMasterDao.findBygroupName(groupname.toLowerCase());
	for(UserGroupMaster u:umaster) {
		groupId=u.getEmployeeGroupID();
	}
	return groupId;	
}

public String getgroupName(int grpid) {
	String orgname="";
	Optional<UserGroupMaster> orgmaster=userGroupMasterDao.findById(grpid);
	UserGroupMaster org=orgmaster.get();
	orgname=org.getGroupName();
	return orgname;	
}
public int getcostcenterId(String costcenterdesc) {
	int costcenterId=0;
	List<CostCenterMaster> cmaster=costcenterMasterDao.findBycostCenterName(costcenterdesc.toLowerCase());
	for(CostCenterMaster c:cmaster) {
		costcenterId=c.getCostCenterMasterId();
	}
	return costcenterId;	
}

public String getcostcenterName(int costid) {
	String orgname="";
	Optional<CostCenterMaster> orgmaster=costcenterMasterDao.findById(costid);
	CostCenterMaster org=orgmaster.get();
	orgname=org.getCostCenter();
	return orgname;	
}
public int getlocationId(String locationname) {
	int locationId=0;
	List<LocationMaster> lmaster=locationMasterDao.findBylocationName(locationname.toLowerCase());
	for(LocationMaster l:lmaster) {
		locationId=l.getLocationMasterID();
	}
	return locationId;	
}

public String getlocationName(int locid) {
	String orgname="";
	Optional<LocationMaster> orgmaster=locationMasterDao.findById(locid);
	LocationMaster org=orgmaster.get();
	orgname=org.getLocation();
	return orgname;	
}

public int getdepartmentId(String departmentname) {
	int depId=0;
	List<DepartmentMaster> dmaster=departmentMasterDao.findBydepartmentName(departmentname.toLowerCase());
	for(DepartmentMaster d:dmaster) {
		depId=d.getDepartmentMasterID();
	}
	return depId;	
}

public String getdepartmentName(int depid) {
	String orgname="";
	Optional<DepartmentMaster> orgmaster=departmentMasterDao.findById(depid);
	DepartmentMaster org=orgmaster.get();
	orgname=org.getDepartmentCode();
	return orgname;	
}
public int getsubdepartmentId(String subdepartmentname) {
	int subdepId=0;
	List<SubDepartmentMaster> sdmaster=subdepDaoRepo.findBysubdepertmentName(subdepartmentname.toLowerCase());
	for(SubDepartmentMaster sd:sdmaster) {
		subdepId=sd.getSubdepartmentMasterID();
	}
	return subdepId;	
}
public String getsubdepartmentName(int subdepid) {
	String orgname="";
	Optional<SubDepartmentMaster> orgmaster=subdepDaoRepo.findById(subdepid);
	SubDepartmentMaster org=orgmaster.get();
	orgname=org.getSubdepartmentCode();
	return orgname;	
}
public int getuserMappingId(int userId) {
	int umId=0;
	List<UserMapping> sdmaster=userMappingDaoRepo.findByuserid(userId);
	for(UserMapping sd:sdmaster) {
		umId=sd.getUserMappingID();
	}
	return umId;	
}
public int getretainerMappingId(int retainerId) {
	int reId=0;
	List<RetainerMapping> sdmaster=reatinerMappingDaoRepo.findByretainerid(retainerId);
	for(RetainerMapping sd:sdmaster) {
		reId=sd.getRetainerMappingID();
	}
	return reId;	
}
public int getRetainerId(int empcode) {
	int retId=0;
	List<Retainer> user=retainerDaoRepo.findByretainerEmployeecode(empcode);
	for(Retainer u:user) {
		retId=u.getRetainerId();
	}
	return retId;
	
}
public int getfunctionId(String functionname) {
	int fnId=0;
	List<FunctionMaster> user=functionMasterDao.findByfunctionName(functionname.toLowerCase());
	for(FunctionMaster u:user) {
		fnId=u.getFunctionMasterId();
	}
	return fnId;
	
}
public int geteventId(int eventcode) {
	int evId=0;
	List<EventMaster> user=eventMasterDao.findByeventCode(eventcode);
	for(EventMaster u:user) {
		evId=u.getEventId();
	}
	return evId;
	
}
public int getonbehalfId(String executivename) {
	int onbehalfId=0;
	List<OnBehalfMaster> user=onbehalfMasterDao.findByexecutiveName(executivename.toLowerCase());
	for(OnBehalfMaster u:user) {
		onbehalfId=u.getOnbehalfId();
	}
	return onbehalfId;
}

public int getfinanceId(String app1) {
	int financeId=0;
	List<LocationWiseFinanceMaster> user=locationwiseFinanceMasterDao.findByApproverName(app1.toLowerCase());
	for(LocationWiseFinanceMaster u:user) {
		financeId=u.getLocationwisefinancemasterId();
	}
	return financeId;
}

public int gethrId(String app1,String appr2) {
	int hrId=0;
	List<LocationWiseHrMaster> user=locationwiseHrMasterDao.findByApproverName(app1.toLowerCase(), appr2.toLowerCase());
	for(LocationWiseHrMaster u:user) {
		hrId=u.getLocationwisehrmasterId();
	}
	return hrId;
}

public int getfinancemappingId(int financeid) {
	int hrId=0;
	List<LocationWiseFinanceMapping> user=locationwiseFinanceMappingDao.findByfinanceId(financeid);
	for(LocationWiseFinanceMapping u:user) {
		hrId=u.getLocationwisefinancemappingId();
	}
	return hrId;
}

public int gethrmappingId(int hrid) {
	int hrId=0;
	List<LocationWiseHrMapping> user=locationwiseHrMappingDao.findByhrId(hrid);
	for(LocationWiseHrMapping u:user) {
		hrId=u.getLocationwisehrmappingId();
	}
	return hrId;
}
public int getbudgetId(String emailid) {
	int hrId=0;
	List<BudgetMaster> user=budgetMasterDao.findByUseremailid(emailid.toLowerCase());
	for(BudgetMaster u:user) {
		hrId=u.getBudgetId();
	}
	return hrId;
}

public int getbudgetMappingId(int budgetid) {
	int hrId=0;
	List<BudgetMasterMapping> user=budgetMasterMappingDao.findBybudgetId(budgetid);
	for(BudgetMasterMapping u:user) {
		hrId=u.getBudgetmappingId();
	}
	return hrId;
}
public int geteventcostcenterMappingId(int eventid,int costcenterid) {
	int hrId=0;
	List<EventCostCenterMapping> user=eventcostcenterMappingDao.findByeventCostCenter(eventid,costcenterid);
	for(EventCostCenterMapping u:user) {
		hrId=u.getEventCostCenterId();
	}
	return hrId;
}

public int getrailwayagentId(String app1,String appr2) {
	int hrId=0;
	List<LocationWiseRailwayAgentMaster> user=locationwiseRailwayAgentMasterDao.findByuserName(app1.toLowerCase(), appr2.toLowerCase());
	for(LocationWiseRailwayAgentMaster u:user) {
		hrId=u.getLocationwiserailwaymasterId();
	}
	return hrId;
}

public int getrailwaymappingId(int railwaymasterid) {
	int hrId=0;
	List<LocationWiseRailwayAgentMapping> user=locationwiseRailwayMappingDao.findByrailwayagentId(railwaymasterid);
	for(LocationWiseRailwayAgentMapping u:user) {
		hrId=u.getLocationwiserailwaymappingId();
	}
	return hrId;
}

public int getcarpoolId(String app1,String appr2) {
	int hrId=0;
	List<LocationWiseCarpoolMaster> user=locationwiseCarpoolMasterDao.findByuserName(app1.toLowerCase(), appr2.toLowerCase());
	for(LocationWiseCarpoolMaster u:user) {
		hrId=u.getLocationwisecarpoolmasterId();
	}
	return hrId;
}

public int getcarpoolmappingId(int carpoolmasterid) {
	int hrId=0;
	List<LocationWiseCarpoolMapping> user=locationwiseCarpoolMappingDao.findBycarpooltId(carpoolmasterid);
	for(LocationWiseCarpoolMapping u:user) {
		hrId=u.getLocationwisecarpoolmappingId();
	}
	return hrId;
}
public int getcitycatrgorymappingId(int cityid,int categoryid) {
	int hrId=0;
	List<CityCategoryMapping> user=cityCategoryRepo.findBycitycategoryid(cityid, categoryid);
	for(CityCategoryMapping u:user) {
		hrId=u.getCityCategoryMappingId();
	}
	return hrId;
}

public int getcityId(String cityname) {
	int hrId=0;
	List<CityMaster> user=cityMasterRepo.findByCityName(cityname.toLowerCase());
	for(CityMaster u:user) {
		hrId=u.getId();
	}
	return hrId;
}

public int getentitlementid(int orgid,int verid,int catid,int grpid) {
	int hrId=0;
	List<TravelEntitlement> user=travelEntitlementDao.findByorgvertcatid(orgid, verid,catid,grpid);
	for(TravelEntitlement u:user) {
		hrId=u.getEntitlementID();
	}
	return hrId;
}

public int getentitlementcityid(int catid,int entid) {
	int hrId=0;
	List<TravelCityEntitlement> user=travelCityEntitlementDao.findBycategoryentitlementid(catid, entid);
	for(TravelCityEntitlement u:user) {
		hrId=u.getTravelCityEntitlementId();
	}
	return hrId;
}

public List<UserDetailsInfo> getOrganizationList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<OrganizationMaster> orglist=orgMasterDao.findAll();
	for(OrganizationMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getOrganizationmasterId());
		ud.setValue(o.getOrganizationCode());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getverticalList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<VerticalMaster> orglist=verticalMasterDao.findAll();
	for(VerticalMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getVerticalmasterId());
		ud.setValue(o.getVerticalName());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getcategoryList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<CategoryMaster> orglist=categoryMasterDao.findAll();
	for(CategoryMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getCategoryMasterId());
		ud.setValue(o.getCategoryName());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getusergroupList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<UserGroupMaster> orglist=userGroupMasterDao.findAll();
	for(UserGroupMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getEmployeeGroupID());
		ud.setValue(o.getGroupName());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getcostcenterList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<CostCenterMaster> orglist=costcenterMasterDao.findAll();
	for(CostCenterMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getCostCenterMasterId());
		ud.setValue(o.getCostCenter());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getlocationList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<LocationMaster> orglist=locationMasterDao.findAll();
	for(LocationMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getLocationMasterID());
		ud.setValue(o.getLocationcode());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getdepartmentList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<DepartmentMaster> orglist=departmentMasterDao.findAll();
	for(DepartmentMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getDepartmentMasterID());
		ud.setValue(o.getDepartmentCode());
		uInfo.add(ud);
	}
	
	return uInfo;
}

public List<UserDetailsInfo> getsubdepartmentList() {
	List<UserDetailsInfo> uInfo=new ArrayList<UserDetailsInfo>();
	List<SubDepartmentMaster> orglist=subdepDaoRepo.findAll();
	for(SubDepartmentMaster o:orglist) {
		UserDetailsInfo ud=new UserDetailsInfo();
		ud.setId(o.getSubdepartmentMasterID());
		ud.setValue(o.getSubdepartmentCode());
		uInfo.add(ud);
	}
	
	return uInfo;
}





}
