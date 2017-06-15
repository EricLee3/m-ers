/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.ResourceLog;
import kr.co.asnet.migam.repository.agent.ResourceDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("resourceLogService")
public class ResourceLogServiceImpl implements ResourceLogService { 
	
	@Inject
	private ResourceDao resourceLogDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#insertAgent(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertResourceLog(ResourceLog resourceLog) {
		return resourceLogDao.insertResourceLog(resourceLog);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatch(int)
	 */
	@Override
	public ResourceLog getResourceLog(int index) {
		return resourceLogDao.selectResourceLog(index);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ResourceLog> getResourceLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectResourceLogList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<ResourceLog> getResourceLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectResourceLogList15(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<ResourceLog> getCategoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectCategoryList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<ResourceLog> getLevelList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectLevelList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<ResourceLog> getResourceLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectResourceLogList5(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<ResourceLog> getResourceLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectResourceLogList25(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<ResourceLog> getResourceLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectResourceLogList50(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ResourceLog> getResourceLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return resourceLogDao.selectResourceLogList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countResourceLogList(SearchDTO searchDTO) {
		return resourceLogDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#deleteBatch(int)
	 */
	@Override
	public Boolean deleteResourceLog(int index) {
		return resourceLogDao.deleteResourceLog(index) > 0 ? true : false;
	}

}
