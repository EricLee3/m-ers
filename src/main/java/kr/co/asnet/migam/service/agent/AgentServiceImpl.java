package kr.co.asnet.migam.service.agent;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.repository.agent.AgentDao;
import kr.co.asnet.migam.service.call.CallAuditService;
/**
 * 상담원 정보 구현 클래스
 */
@Service("agentService")
public class AgentServiceImpl implements AgentService {
	private final Logger logger = LoggerFactory.getLogger(AgentServiceImpl.class);
	@Inject
	private AgentDao agentDao;
	@Inject
	private CallAuditService callAuditService;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#insertAgent(kr.co.asnet.migam.domain.agent.Agent)
	 */
	@Override
	public int insertAgent(Agent agent) {
		return agentDao.insertAgent(agent);
	}
	
	@Override
	public int insertAgentChanged(Agent agent) {
		return agentDao.insertAgentChanged(agent);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgent(int)
	 */
	@Override
	public Agent getAgent(int index) {
		return agentDao.selectAgent(index);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgent(java.lang.String)
	 */
	@Override
	public Agent getAgent(String agentId) {
		return agentDao.selectAgent(agentId);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getAgentList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getAgentList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getAgentList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getAgentList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getAgentList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getAgentList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentList100(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> getLatestAgentList(SearchDTO searchDTO, String orderby) {
		return agentDao.selectLatestAgentList(searchDTO, orderby);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#countAgentList(kr.co.asnet.migam.domain.agent.Agent, kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countAgentList(SearchDTO searchDTO) {
		return agentDao.selectCount(searchDTO);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#updateAgent(kr.co.asnet.migam.domain.agent.Agent)
	 */
	@Override
	public int updateAgent(Agent agent) {
		return agentDao.updateAgent(agent);
	}
	
	/*
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#updateAgentById(kr.co.asnet.migam.domain.agent.Agent)
	 * Agent 객체의 agentId를 사용하여 타 field update, dynamic SQL 사용
	 */
	@Override
	public int updateAgentById(Agent agent) {
		return agentDao.updateAgentById(agent);
	}
	
	@Override
	public int updateAgentByIp(Agent agent) {
		return agentDao.updateAgentByIp(agent);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#deleteAgent(int)
	 */
	@Override
	public Boolean deleteAgent(String index) {
		return agentDao.deleteAgent(index) > 0 ? true : false;	
	}
	
	
	@Override
	public Boolean deleteAgentById(String agentId)  {
		return agentDao.deleteAgentById(agentId) > 0 ? true : false;
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#login(kr.co.asnet.migam.domain.agent.Agent)
	 */
	@Override
	public List<Agent> getAgentListWithCount(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentListWithCount(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#login(kr.co.asnet.migam.domain.agent.Agent)
	 */
	@Override
	public List<Agent> getAgentListWithCountFromDaily(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentListWithCountFromDaily(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<Agent> getAgentListWithAngry(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentDao.selectAgentListWithAngry(pageDTO, searchDTO, orderby);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#getAngryCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public Agent getAgentWithCount(SearchDTO searchDTO) {
		return agentDao.selectAgentWithCount(searchDTO);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#isDuplicatedAgentId(java.lang.String)
	 */
	@Override
	public boolean isDuplicatedAgentId(String agentId) {
		return agentDao.selectAgentById(agentId) != null ? true : false;
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#uploadAgentListWithExcel(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public int uploadAgentListWithExcel(MultipartFile uploadfile) {
		int countAgent=0;
		try {
		if (uploadfile != null) {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(uploadfile.getBytes());
			Workbook workbook;
			String fileName = uploadfile.getOriginalFilename();
			if (fileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(byteArrayInputStream);
			} else {
				workbook = new XSSFWorkbook(byteArrayInputStream);
			}
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				if( row.getRowNum()== 0 ) continue;
				Agent agent = new Agent();
				agent.setAgentNumber( this.getCellValue(row, 0, "") );
				agent.setAgentId( this.getCellValue(row, 1, "") );
				agent.setAgentName( this.getCellValue(row, 2, "") );
				agent.setAgentIp( this.getCellValue(row, 3, "") );
				agent.setIsAudit( this.getCellValue(row, 4, 0) );
				agent.setIsAuditBatch( this.getCellValue(row, 5, 0) );
				agent.setGroupId( this.getCellValue(row, 6, "") );
				agent.setCallStatus( this.getCellValue(row, 7, 0) );
				agent.setStressCount( this.getCellValue(row, 8, 0) );
				agent.setAngryCount( this.getCellValue(row, 9, 0) );
				agent.setGroupName( this.getCellValue(row,10, "") );
				countAgent++;
				try {
					if( this.insertAgent(agent) > 0 ) {
					//모니터링 대상여부 확인
						if(agent.getIsAudit() == 1){
							callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0);
						}
					}
					
				} catch(Exception e) {
					logger.debug("엑셀 업로드를 통한 상담원 등록 중 오류 발생 : %d번째 상담원 정보에서 오류 발생 ", countAgent);
				}
			}
		}
		} catch(Exception e) {
			logger.debug("엑셀 업로드를 통한 상담원 등록 중 오류 발생 : 라인을 특정할 수 없으므로, 파일 오류 등으로 추정됨 ");
		}
		return countAgent;
	}
	/************** 아래 4개의 메소드는 액셀 처리를 위한 내부(private) 함수입니다. ***********/
	private int getCellValue(Row row, int columnIndex, int defaultValue) {
		try {
			return (int)row.getCell(columnIndex).getNumericCellValue();
		} catch(Exception e) {
			return defaultValue;
		}
	}
	
	private float getCellValue(Row row, int columnIndex, float defaultValue) {
		try {
			return (float)row.getCell(columnIndex).getNumericCellValue();
		} catch(Exception e) {
			return defaultValue;
		}
	}
	
	private Date getCellValue(Row row, int columnIndex, Date defaultValue) {
		try {
			return (Date)row.getCell(columnIndex).getDateCellValue();
		} catch(Exception e) {
			return defaultValue;
		}
	}
	
	private String getCellValue(Row row, int columnIndex, String defaultValue) {
		try {
			return (String)row.getCell(columnIndex).getStringCellValue();
		} catch(Exception e) {
			return defaultValue;
		}
	}
	
	

}
