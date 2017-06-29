package kr.co.asnet.migam.web.REST;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensConf;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.agent.ProConfService;
import kr.co.asnet.migam.service.agent.ProMetaService;
import kr.co.asnet.migam.service.agent.ProcessGroupService;
import kr.co.asnet.migam.service.agent.SensBasicService;
import kr.co.asnet.migam.service.agent.SensConfService;
import kr.co.asnet.migam.service.agent.SensMetaService;

/**
 * 상담원 그룹 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/sens")
public class SensREST {
	private final Logger logger = LoggerFactory.getLogger(SensREST.class);

	@Autowired
	private SensBasicService sensBasicService;
	
	@Autowired
	private SensMetaService sensMetaService;
	
	@Autowired
	private AlarmLimitService alarmLimitService;
	
	@Autowired
	private ProMetaService proMetaService;
	
	@Autowired
	private SensConfService sensConfService;
	
	@Autowired
	private ProConfService proConfService;
	
	/**
	 * 상담원 그룹 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
	 * @param groupId
	 * @return
	 */
	/*
	@RequestMapping(value = "/isDuplicatedGroupIdd", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedGroupId(@RequestParam(value = "groupId") String groupId) {
		boolean result = false;
		if( agentGroupService.isDuplicatedGroupId(groupId) ) result = false;
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	*/

	/**
	 * 새로운 상담원 그룹 정보를 DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param agentGroup
	 * @param model
	 * @return
	 *  성공하면, agent정보를 JSON형태로 반환합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/createSensBasic", method = RequestMethod.POST)
	public ResponseEntity<SensBasic> createSensBasic(SensBasic sensBasic, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug(agentGroup.toString());
		String groupId = sensBasicService.insertSensBasic(sensBasic);
		
		String type = "";
		if(sensBasic.getType().equals("0")) { 
			type = "Basic";
		}else {
			type = "Calculator";
		}
		
		hislog.setDetail("[등록] Indicator(타입) : ["+sensBasic.getName()+"("+type+")]");
		hislog.setMenu("서비스 설정 > 감성기초 Meta 데이터 관리[등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(groupId != null) {
			return new ResponseEntity<SensBasic>(sensBasic, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensBasic>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/createSensMeta", method = RequestMethod.POST)
	public ResponseEntity<SensMeta> createSensMeta(SensMeta sensMeta, Model model,HisLog hislog, String username, String userid, HttpServletRequest req) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug(agentGroup.toString());
		
		String[] array;
		array = sensMeta.getBasic_idx().split(",");
		String[] array_min = req.getParameterValues("b_min");
		String[] array_max = req.getParameterValues("b_max");
		String array_min2="";
		String array_max2="";
		
		System.out.println("array_min:::" + array_min.length);
		System.out.println("array_max:::" + array_max.length);
		
		for(int i = 0; i < array_min.length; i++) {
			if(array_min[i].length() != 0) {
				array_min2 += array_min[i] + ",";
			}
		}
		
		for(int i = 0; i < array_max.length; i++) {
			if(array_max[i].length() != 0) {
				array_max2 += array_max[i] + ",";
			}
		}
		
		String[] min_split = array_min2.split(",");
		String[] max_split = array_max2.split(",");
		
		
		String groupId = sensBasicService.insertSensMeta(sensMeta);
		
		for(int i = 0; i < array.length; i++) {
			sensMeta.setBasic_idx(array[i]);
			sensMeta.setB_min(min_split[i]);
			sensMeta.setB_max(max_split[i]);
			sensBasicService.insertSensMap(sensMeta);
		}
		
		hislog.setDetail("[등록] Service Indicator : ["+sensMeta.getName()+"]");
		hislog.setMenu("서비스 설정 > 감성지표 기초정보 [등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(groupId != null) {
			return new ResponseEntity<SensMeta>(sensMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensMeta>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/createProMeta", method = RequestMethod.POST)
	public ResponseEntity<ProMeta> createProMeta(ProMeta proMeta, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug(agentGroup.toString());
		
		String[] array;
		array = proMeta.getService_idx().split(",");
		
		//String groupId = proMetaService.insertProMeta(proMeta);
		String groupId = "";
		ProMeta proMeta2 = proMetaService.getProIdx(groupId);
		
		System.out.println("proMeta2:::::::" + proMeta2.getProfile_meta_idx());
		
		String pro_idx = proMeta2.getProfile_meta_idx();
		
		for(int i = 0; i < array.length; i++) {
			proMeta.setProfile_meta_idx(pro_idx);
			proMeta.setService_idx(array[i]);
			groupId = proMetaService.insertProMeta(proMeta);
		}
		
		hislog.setDetail("[등록] Service Indicator : ["+proMeta.getName()+"]");
		hislog.setMenu("서비스 설정 > 프로파일 Meta 데이터 관리 [등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(groupId != null) {
			return new ResponseEntity<ProMeta>(proMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProMeta>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/createSensConf", method = RequestMethod.POST)
	public int createSensConf(SensConf sensConf, Model model,HisLog hislog, String username, String userid, HttpServletRequest req, SearchDTO searchDTO) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug(agentGroup.toString());
		
		String[] array_min = req.getParameterValues("min");
		String[] array;
		array = sensConf.getBasic_idx().split(",");
		
		//array_min = sensConf.getMin().split(",");
		String[] array_max = req.getParameterValues("max");
		//array_max = sensConf.getMax().split(",");
		
		String groupId = "";
		
		String min = "";
		String max = "";
		int dupminmax = 0;
		
		for(int j=1; j < Integer.parseInt(sensConf.getEmotion_level()); j++) {
			min= "";
			for(int i = 0; i < array.length; i++) {
				min += " OR basic_idx = '"+array[i]+"' AND emotion_level ='"+j+"'  AND  MIN='"+array_min[i]+"'  AND MAX ='"+array_max[i]+"'";
				
			}
			
			
		sensConf.setMin(min);
		searchDTO.setSearchId(sensConf.getName());

		dupminmax = sensConfService.countDupMinMax(sensConf);
		
			if( array.length == dupminmax){
				return 888;
			}
		}
			
		for(int i = 0; i < array.length; i++) {
			sensConf.setBasic_idx(array[i]);
			sensConf.setMin(array_min[i]);
			sensConf.setMax(array_max[i]);
			
			groupId = sensConfService.insertSensConf(sensConf);
		
		}
		
		hislog.setDetail("[등록] 프로파일 명 : ["+sensConf.getName()+"]");
		hislog.setMenu("서비스 설정 > 감성지표 설정 [등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(groupId != null) {
			return 200;
		} else {
			return 0;
		}
	}
	
	@RequestMapping(value = "/createProConf", method = RequestMethod.POST)
	public int createProConf(ProConf proConf, Model model,HisLog hislog, String username, String userid, HttpServletRequest req, SearchDTO searchDTO) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug(agentGroup.toString());
		
		String[] array_min = req.getParameterValues("s_min");
		String[] array;
		array = proConf.getService_idx().split(",");
		
		String[] array_max = req.getParameterValues("s_max");
		proConf.setS_script(proConf.getS_script().replaceAll(",", " "));
		proConf.setP_description(proConf.getP_description().replaceAll(",", " "));
		proConf.setS_description(proConf.getS_description().replaceAll(",", " "));
		String groupId = "";
		
		groupId = proConfService.insertProConf(proConf); 
		
		
		String min = "";
		String max = "";
		int dupminmax = 0;
		PageDTO2 pageDTO = null;

			
		proConf.setS_min(min);
		searchDTO.setSearchId(proConf.getName());

		
		
		List<ProConf> proconfList = proConfService.getProConfName(pageDTO, searchDTO, "order by d.profile_idx desc");
		
		
		for(int j=0; j < proconfList.size(); j++) {
			
			min= "";
		for(int i = 0; i < array.length; i++) {
		
			min += " OR  profile_idx ="+proconfList.get(j).getP_profile_idx()+ " AND svc_meta_idx = "+array[i]+" AND MIN = "+array_min[i]+"  AND MAX = "+array_max[i]+"";
			
		}
			
		proConf.setS_min(min);
		searchDTO.setSearchId(proConf.getName());
		
			dupminmax = proConfService.countDupMinMax(proConf);
		
			if( array.length == dupminmax){
				return 888;
			}
		
		}
		
		for(int i = 0; i < array.length; i++) {
			proConf.setService_idx(array[i]);
			proConf.setS_min(array_min[i]);
			proConf.setS_max(array_max[i]);
			
			groupId = proConfService.insertProConf_S(proConf); 
		}
		

		
		hislog.setDetail("[등록] Service Indicator : ["+proConf.getName()+"]");
		hislog.setMenu("서비스 설정 > 프로파일 설정 [등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(groupId != null) {
			return 200;
		} else {
			return 0;
		}
	}
	
	
	
	/*
	 * 주어진 인덱스에 해당하는 상담원 그룹 정보를 가져오기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 *  성공하면 AgentGroup객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectSensBasic/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<SensBasic> selectSensBasic(@PathVariable("groupId") String groupId, Model model) {
		SensBasic sensBasic = sensBasicService.getSensBasic(groupId); 
		if(sensBasic!=null) {
			return new ResponseEntity<SensBasic>(sensBasic, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensBasic>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/selectSensMeta/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<SensMeta> selectSensMeta(@PathVariable("groupId") String groupId, Model model) {
		SensMeta sensMeta = sensMetaService.getSensMeta(groupId); 
		if(sensMeta!=null) {
			return new ResponseEntity<SensMeta>(sensMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensMeta>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/selectSensMeta2/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<SensMeta> selectSensMeta2(@PathVariable("groupId") String groupId, Model model) {
		SensMeta sensMeta = sensMetaService.getSensMeta2(groupId); 
		if(sensMeta!=null) {
			return new ResponseEntity<SensMeta>(sensMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensMeta>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/selectProMeta/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<ProMeta> selectProMeta(@PathVariable("groupId") String groupId, Model model) {
		ProMeta proMeta = proMetaService.getProMeta(groupId);
		if(proMeta!=null) {
			return new ResponseEntity<ProMeta>(proMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProMeta>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/selectProMeta2/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<ProMeta> selectProMeta2(@PathVariable("groupId") String groupId, Model model) {
		ProMeta proMeta = proMetaService.getProMeta2(groupId);
		if(proMeta!=null) {
			return new ResponseEntity<ProMeta>(proMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProMeta>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	@RequestMapping(value = "/selectSensConf/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<SensConf> selectSensConf(@PathVariable("groupId") String groupId, Model model,PageDTO2 pageDTO,SearchDTO searchDTO,String orderby, SensConf s) {
		String[] array;
		array = groupId.split(",");
		s.setName(array[0]);
		s.setEmotion_level(array[1]);

		
		List<SensConf> sensConf = sensConfService.getSensChkList(pageDTO, searchDTO, "order by name desc"); 
		if(sensConf!=null) {
			return new ResponseEntity<SensConf>((SensConf) sensConf, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensConf>(HttpStatus.NO_CONTENT);
		}
	}
	
	/*
	 * 주어진 상담원 그룹 정보에 따라 해당 상담원 그룹 정보를 업데이트하기 위한 엔드포인트입니다.
	 * @param agentGroup
	 * @param model
	 * @return
	 *  성공하면 상담원 그룹 정보를 반환하고, 실패하면 NULL을 반환합니다. 
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/updateSensBasic", method = RequestMethod.POST)
	public ResponseEntity<SensBasic> updateSensBasic(SensBasic sensBasic, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug("Agent Group Update : " + agentGroup.toString());
		
		String type = "";
		if(sensBasic.getType().equals("0")) {
			type = "Basic";
		}else {
			type = "Calculator";
		}
		
		int updateCount = sensBasicService.updateSensBasic(sensBasic);
		
		hislog.setDetail("[수정] Indicator(타입) : ["+sensBasic.getName()+"("+type+")]");
		hislog.setMenu("서비스 설정 > 감성기초 Meta 데이터 관리[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(updateCount > 0) {
			return new ResponseEntity<SensBasic>(sensBasic, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensBasic>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/updateSensMeta", method = RequestMethod.POST)
	public int updateSensMeta(SensMeta sensMeta, Model model,HisLog hislog, String username, String userid, HttpServletRequest req) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug("Agent Group Update : " + agentGroup.toString());
		
		String[] array;
		array = sensMeta.getBasic_idx().split(",");
		String[] array_min = req.getParameterValues("b_min");
		String[] array_max = req.getParameterValues("b_max");
		String array_min2="";
		String array_max2="";
		
		System.out.println("array_min:::" + array_min.length);
		System.out.println("array_max:::" + array_max.length);
		
		for(int i = 0; i < array_min.length; i++) {
			if(array_min[i].length() != 0) {
				array_min2 += array_min[i] + ",";
			}
		}
		
		for(int i = 0; i < array_max.length; i++) {
			if(array_max[i].length() != 0) {
				array_max2 += array_max[i] + ",";
			}
		}
		
		String[] min_split = array_min2.split(",");
		String[] max_split = array_max2.split(",");
		
		SearchDTO searchDTO = new SearchDTO();
		
		searchDTO.setSearchId(sensMeta.getSvc_meta_idx());
		
		int prometacnt_sc = sensMetaService.countSensMetaList_sc(searchDTO);
		
		if(prometacnt_sc > 0) {
			return 888;
		}
		
		
		int updateCount = sensMetaService.updateSensMeta(sensMeta);
		Boolean isDeleted = sensMetaService.deleteSensMeta(sensMeta.getSvc_meta_idx());
		
		for(int i = 0; i < array.length; i++) {
			sensMeta.setBasic_idx(array[i]);
			sensMeta.setB_min(min_split[i]);
			sensMeta.setB_max(max_split[i]);
			sensBasicService.insertSensMap_update(sensMeta);
		}
		
		hislog.setDetail("[수정] Service Indicator : ["+sensMeta.getName()+"]");
		hislog.setMenu("서비스 설정 > 감성지표 기초정보 목록[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(isDeleted) {
			return 200;
		} else {
			return 0;
		}
	}
	
	
	/*@RequestMapping(value = "/updateSensMeta", method = RequestMethod.POST)
	public ResponseEntity<SensMeta> updateSensMeta(SensMeta sensMeta, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug("Agent Group Update : " + agentGroup.toString());
		
		String[] array;
		array = sensMeta.getBasic_idx().split(",");
		
		
		
		
		int updateCount = sensMetaService.updateSensMeta(sensMeta);
		Boolean isDeleted = sensMetaService.deleteSensMeta(sensMeta.getSvc_meta_idx());
		
		for(int i = 0; i < array.length; i++) {
			sensMeta.setBasic_idx(array[i]);
			sensBasicService.insertSensMap_update(sensMeta);
		}
		
		hislog.setDetail("[수정] Service Indicator : ["+sensMeta.getName()+"]");
		hislog.setMenu("서비스 설정 > 감성지표 기초정보 목록[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(updateCount > 0) {
			return new ResponseEntity<SensMeta>(sensMeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<SensMeta>(HttpStatus.NO_CONTENT);
		}
	}*/
	
	@RequestMapping(value = "/updateSensConf", method = RequestMethod.POST)
	public int updateSensConf(SensConf sensConf, Model model,HisLog hislog, String username, String userid, HttpServletRequest req, SearchDTO searchDTO) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		
		String[] basic_idx = req.getParameterValues("basic_idx");
		
		String[] array_min = req.getParameterValues("min");
		
		String[] array_max = req.getParameterValues("max");
		
		//int updateCount = proMetaService.updateProMeta(proMeta);
		String updateCount = "";
		Boolean isDeleted = sensConfService.deleteSensConf(sensConf);
		
		String min = "";
		String max = "";
		int dupminmax = 0;
		boolean mj = false;
		
		for(int j=1; j < Integer.parseInt(sensConf.getEmotion_level()); j++) {
			min= "";
			for(int i = 0; i < basic_idx.length; i++) {
				min += " OR basic_idx = '"+basic_idx[i]+"' AND emotion_level ='"+j+"'  AND  MIN='"+array_min[i]+"'  AND MAX ='"+array_max[i]+"'";
				
			}
			
			
		sensConf.setMin(min);
		searchDTO.setSearchId(sensConf.getName());

		dupminmax = sensConfService.countDupMinMax(sensConf);
		
			if( basic_idx.length == dupminmax){
				return 888;
			}
		}
		
		
		for(int i = 0; i < basic_idx.length; i++) {
			sensConf.setBasic_idx(basic_idx[i]);
			sensConf.setMin(array_min[i]);
			sensConf.setMax(array_max[i]);
			
			updateCount = sensConfService.insertSensConf(sensConf);
		}
		
		hislog.setDetail("[수정] Service Indicator : ["+sensConf.getName()+"]");
		hislog.setMenu("서비스 설정 > 감성지표 설정 [수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(updateCount != null) {
			return 200;
		} else {
			return 0;
		}
	}
	
	@RequestMapping(value = "/updateProConf", method = RequestMethod.POST)
	public int updateProConf(ProConf proConf, Model model,HisLog hislog, String username, String userid, HttpServletRequest req, SearchDTO searchDTO) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		String[] array;
		array = proConf.getService_idx().split(",");

		
		String[] service_idx = req.getParameterValues("service_idx");
		
		String mjprofile_idx = proConf.getP_profile_idx();
		
		String[] array_min = req.getParameterValues("s_min");
		
		String[] array_min2;
		array_min2 = proConf.getS_min().split(",");

		
		String[] array_max = req.getParameterValues("s_max");
		proConf.setP_profile_idx(proConf.getS_profile_idx());
		//int updateCount = proMetaService.updateProMeta(proMeta);
		String updateCount = "";
		//proConf.setS_script(proConf.getS_script().replaceAll(",", " "));
		proConf.setP_description(proConf.getP_description().replaceAll(",", " "));
		proConf.setS_description(proConf.getS_description().replaceAll(",", " "));
		
		Boolean isDeleted = proConfService.deleteProConf(proConf);
		proConfService.deleteProConf_script(proConf);


		updateCount = proConfService.insertProConf(proConf);
		
		
		String min = "";
		String max = "";
		int dupminmax = 0;
		PageDTO2 pageDTO = null;
	
			
		proConf.setS_min(min);
		searchDTO.setSearchId(proConf.getName());

		
		
		List<ProConf> proconfList = proConfService.getProConfName(pageDTO, searchDTO, "order by d.profile_idx desc");
		proConf.setName(proConf.getName()+","+proConf.getP_profile_idx());

		
		for(int j=0; j < proconfList.size(); j++) {
			
			min= "";
		for(int i = 0; i < array.length; i++) {
		
			min += " OR  profile_idx ="+proconfList.get(j).getP_profile_idx()+ " AND svc_meta_idx = "+array[i]+" AND MIN = "+array_min[i]+"  AND MAX = "+array_max[i]+"";
			
		}
			
		proConf.setS_min(min);
		
		
			dupminmax = proConfService.countDupMinMax(proConf);
		
			if( array.length == dupminmax){
				return 888;
			}
		
		}
		
		
		for(int i = 0; i < service_idx.length; i++) {
			proConf.setService_idx(service_idx[i]);
			proConf.setS_min(array_min[i]);
			proConf.setS_max(array_max[i]);
			
			/*int dupminmax = proConfService.countDupMinMax(proConf);
			System.out.println("updatesensconf:::" + dupminmax);
			if(dupminmax > 0) {
				return 888;
			}
			*/
	
			proConf.setName(proConf.getName()+","+mjprofile_idx);
			
			updateCount = proConfService.insertProConf_S(proConf);
		}
		
		hislog.setDetail("[수정] 프로파일 : ["+proConf.getP_profile_idx()+"]");
		hislog.setMenu("서비스 설정 > 프로파일 설정 [수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(updateCount != null) {
			return 200;
		} else {
			return 0;
		}
	}
	
	@RequestMapping(value = "/updateProMeta", method = RequestMethod.POST)
	public int updateProMeta(ProMeta proMeta, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug("Agent Group Update : " + agentGroup.toString());
	
		String[] array;
		array = proMeta.getService_idx().split(",");
		
		SearchDTO searchDTO = new SearchDTO();
		
		searchDTO.setSearchId(proMeta.getProfile_meta_idx());
		System.out.println("proMeta.getProfile_meta_idx():::::" + proMeta.getProfile_meta_idx());
		
		int prometacnt_sc = proMetaService.countProMetaList_sc(searchDTO);
		
		if(prometacnt_sc > 0) {
			return 888;
		}
		
		//int updateCount = proMetaService.updateProMeta(proMeta);
		String updateCount = "";
		Boolean isDeleted = proMetaService.deleteProMeta(proMeta.getName());
		
		for(int i = 0; i < array.length; i++) {
			proMeta.setService_idx(array[i]);
			updateCount = proMetaService.insertProMeta(proMeta);
		}
		
		hislog.setDetail("[수정] 프로파일 명 : ["+proMeta.getName()+"]");
		hislog.setMenu("서비스 설정 > 프로파일 Meta 데이터 관리 [수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(isDeleted) {
			return 200;
		} else {
			return 0;
		}
	}
	
	/**
	 * 주어진 상담원 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param agentIndex
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/deleteSensBasic/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteSensBasic(@PathVariable("index") String agentIndex, Model model, HisLog hislog) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		hislog.setDetail("[삭제] Indicator(type) : ["+array[1]+"("+array[2]+")]");
		hislog.setMenu("시스템 설정 > 상담원 목록[삭제]");
		hislog.setUser_id(array[4]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[3]);
		alarmLimitService.insertHis(hislog); 
		
		Boolean isDeleted = sensBasicService.deleteSensBasic(array[0]);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/deleteSensMeta/{index}", method = RequestMethod.GET)
	public int deleteSensMeta(@PathVariable("index") String agentIndex, Model model, HisLog hislog) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		System.out.println("name:::" + array[1]);
		
		hislog.setDetail("[삭제] Service Indicator : ["+array[1]+"]");
		hislog.setMenu("시스템 설정 > 감성지표 기초정보 설정[삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
		
		
		SearchDTO searchDTO = new SearchDTO();
		
		searchDTO.setSearchId(array[0]);
		searchDTO.setSearchQuery(array[1]);
		
		int prometacnt_sc = sensMetaService.countSensMetaList_sc(searchDTO);
		
		if(prometacnt_sc > 0) {
			return 888;
		}
		
		int svindicnt = sensMetaService.countSvIndiList(searchDTO);
		
		if(svindicnt > 0) {
			return 999;
		}
		
		Boolean isDeleted = sensMetaService.deleteSensMeta(array[0]);
		sensMetaService.deleteSensMeta2(array[0]);
		
		if(isDeleted) {
			return 200;
		} else {
			return 0;
		}
	}
	
/*	@RequestMapping(value = "/deleteSensMeta/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteSensMeta(@PathVariable("index") String agentIndex, Model model, HisLog hislog) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		hislog.setDetail("[삭제] Service Indicator : ["+array[1]+"]");
		hislog.setMenu("시스템 설정 > 감성지표 기초정보 설정[삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
		
		
		Boolean isDeleted = sensMetaService.deleteSensMeta(array[0]);
		sensMetaService.deleteSensMeta2(array[0]);
		
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}*/
	
	
	@RequestMapping(value = "/deleteSensConf/{index}", method = RequestMethod.GET)
	public int deleteSensConf(@PathVariable("index") String agentIndex, Model model, HisLog hislog,SensConf sensConf) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		hislog.setDetail("[삭제] Service Indicator : ["+array[0]+"]");
		hislog.setMenu("시스템 설정 > 감성지표 설정 [삭제]");
		hislog.setUser_id(array[2]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[1]);
		alarmLimitService.insertHis(hislog); 
		
		SearchDTO searchDTO = new SearchDTO();
		
		
		
		sensConf.setName(array[0]);
		sensConf.setEmotion_level(array[1]);
		searchDTO.setSearchId(array[0]);
		searchDTO.setSearchQuery(array[1]);
		//Boolean isDeleted = sensConfService.deleteSensConf(array[0],array[1]);
		
		int levelcnt = sensConfService.countLevel(searchDTO);
		
		if(levelcnt > 0) {
			return 999;
		}
		
		Boolean isDeleted = sensConfService.deleteSensConf(sensConf);

		if(isDeleted) {
			return 200;
		} else {
			return 0;
		}
	}
	
	@RequestMapping(value = "/deleteProConf", method = RequestMethod.POST)
	public ResponseEntity<Boolean> deleteProConf(String groupId, Model model, HisLog hislog,ProConf proConf) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = groupId.split(",");
		System.out.println("groupId::::"+groupId);
		
		/*
		hislog.setDetail("[삭제] 프로파일 명 : ["+array[1]+"]");
		hislog.setMenu("시스템 설정 > 프로파일 설정 [삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); */
		
		
		proConf.setName(array[1]);
		proConf.setS_script(array[2]);
		proConf.setP_profile_idx(array[0]);
		//Boolean isDeleted = sensConfService.deleteSensConf(array[0],array[1]);
		Boolean isDeleted = proConfService.deleteProConf(proConf);
		proConfService.deleteProConf_script(proConf);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/deleteProMeta/{index}", method = RequestMethod.GET)
	public int deleteProMeta(@PathVariable("index") String agentIndex, Model model, HisLog hislog) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		hislog.setDetail("[삭제] 프로파일 명 : ["+array[1]+"]");
		hislog.setMenu("시스템 설정 > 프로파일  Meta 데이터 목록 [삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
		SearchDTO searchDTO = new SearchDTO();
		
		searchDTO.setSearchId(array[0]);
		int prometacnt = proMetaService.countProMetaList_pro(searchDTO);
		
		if(prometacnt > 0) {
			return 999;
		}
		
		
		int prometacnt_sc = proMetaService.countProMetaList_sc(searchDTO);
		
		if(prometacnt_sc > 0) {
			return 888;
		}
		
		System.out.println("prometacnt:::" + prometacnt);
		
		System.out.println("prometacnt_sc:::" + prometacnt_sc);
		
		
		Boolean isDeleted = proMetaService.deleteProMeta(array[1]);
		
		if(isDeleted) {
			return 200;
		} else {
			return 0;
		}
	}
	
	/*
	@RequestMapping(value = "/deleteProMeta/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteProMeta(@PathVariable("index") String agentIndex, Model model, HisLog hislog) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		hislog.setDetail("[삭제] 프로파일 명 : ["+array[1]+"]");
		hislog.setMenu("시스템 설정 > 프로파일  Meta 데이터 목록 [삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
		SearchDTO searchDTO = new SearchDTO();
		
		searchDTO.setSearchId(array[0]);
		int prometacnt = proMetaService.countProMetaList_pro(searchDTO);
		
		if(prometacnt == 0) {
			return new ResponseEntity<Boolean>(HttpStatus.IM_USED);
		}
		
		int prometacnt_sc = proMetaService.countProMetaList_sc(searchDTO);
		System.out.println("prometacnt:::" + prometacnt);
		
		System.out.println("prometacnt_sc:::" + prometacnt_sc);
		
		
		Boolean isDeleted = proMetaService.deleteProMeta(array[1]);
		
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
	*/
	
	/**
	 * 상담원 그룹 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
	 * @param groupId
	 * @return
	 */
	 
	@RequestMapping(value = "/isDuplicatedGroupIdd", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedGroupId(@RequestParam(value = "groupId") String groupId) {
		boolean result = false;
		if( sensBasicService.isDuplicatedGroupId(groupId) ) result = false;
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/isDuplicatedName", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedName(@RequestParam(value = "groupId") String groupId) {
		boolean result = false;
		if( sensBasicService.isDuplicatedName(groupId) ) result = false;
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/isDuplicatedProName", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedProName(@RequestParam(value = "groupId") String groupId) {
		boolean result = false;
		if( proMetaService.isDuplicatedName(groupId) ) result = false;  
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
}
