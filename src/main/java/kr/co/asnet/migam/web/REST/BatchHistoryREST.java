package kr.co.asnet.migam.web.REST;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.config.BatchHistory;
import kr.co.asnet.migam.service.config.BatchHistoryService;

/**
 * 자동 수행 작업 이력 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/batchHistory")
public class BatchHistoryREST {
	private final Logger logger = LoggerFactory.getLogger(BatchHistoryREST.class);

	@Autowired
	private BatchHistoryService batchHistoryService;
	
	private static Logger log = LoggerFactory.getLogger(BatchHistoryREST.class);
	
	
	/**
	 * 주어진 자동수행작업 정보 히스토리를 삭제하기 위한 엔드포인트입니다.
	 * @param batchHistoryIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteBatchHistory/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteBatchHistory(@PathVariable("index") int batchHistoryIndex, Model model) {
		
		Boolean isDeleted = batchHistoryService.deleteBatchHistory(batchHistoryIndex);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
}
