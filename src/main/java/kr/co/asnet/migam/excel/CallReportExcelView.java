package kr.co.asnet.migam.excel;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import kr.co.asnet.migam.domain.call.AgentCall;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.call.HourlyCall;
import kr.co.asnet.migam.domain.call.MonthlyCall;
import kr.co.asnet.migam.utils.Const;

/**
 * 콜별 리포트를 엑셀로 다운로드 하기위해 사용하는 View Class입니다.
 * http://deoki.tistory.com/32를 참고하였습니다.
 * 
 * @author byonghee
 *
 */
public class CallReportExcelView extends AbstractXlsxView {

	private final Logger logger = LoggerFactory.getLogger(CallReportExcelView.class);
	
 
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String excelName = "";
		int excelType = (Integer)model.get("excelType");
		try {
		switch(excelType) {
		case Const.EXCELDOWNLOAD_CALLREPORT :
			excelName = makeExcelCallReport(model, workbook);
			break;
		case Const.EXCELDOWNLOAD_CUSTOMERREPORT :
			excelName = makeExcelCustomerReport(model, workbook);
			break;
		case Const.EXCELDOWNLOAD_STATHOURLY :
			excelName = makeExcelStatHourly(model, workbook);
			break;
		case Const.EXCELDOWNLOAD_STATDAILY :
			excelName = makeExcelStatDaily(model, workbook);
			break;
		case Const.EXCELDOWNLOAD_STATMONTHLY :
			excelName = makeExcelStatMonthly(model, workbook);
			break;
		case Const.EXCELDOWNLOAD_STATAGENT :
			excelName = makeExcelStatAgent(model, workbook);
			break;
		case Const.EXCELDOWNLOAD_STATPERFORMANCE :
			excelName = makeExcelStatPerformance(model, workbook);
			break;
		}
		} catch(Exception e) {
			logger.debug("엑셀 다운로드 생성 중 오류 발생 " + e.toString());
			
		}
		response.setContentType("Application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; Filename="+excelName);
	}
	
	/**
	 * 콜별 리포트 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelCallReport(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("콜별_리포트_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<CallAnalysis> callAnalysisList = (List<CallAnalysis>)model.get("callAnalysisList");
		int colNum = 0;
		row = worksheet.createRow(0);
		row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("상담원");
		row.createCell(colNum++).setCellValue("고객번호");
		row.createCell(colNum++).setCellValue("상담일");
		row.createCell(colNum++).setCellValue("시작시간");
		
		row.createCell(colNum++).setCellValue("종료시간");
		row.createCell(colNum++).setCellValue("통화시간(초)");
		row.createCell(colNum++).setCellValue("분노 단계");
		row.createCell(colNum++).setCellValue("스트레스 단계");

		int i = 0;
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
		for(CallAnalysis callAnalysis : callAnalysisList){
			colNum = 0;
			row = worksheet.createRow(++i);
			row.createCell(colNum++).setCellValue( i);
			row.createCell(colNum++).setCellValue( callAnalysis.getAgentName() == null ? "" : callAnalysis.getAgentName() );
			row.createCell(colNum++).setCellValue( callAnalysis.getCustomerNumber() == null ? "" : callAnalysis.getCustomerNumber() );
			row.createCell(colNum++).setCellValue( callAnalysis.getStartTime() == null ? "" : simpleDateFormatDate.format(callAnalysis.getStartTime()) );
			row.createCell(colNum++).setCellValue( callAnalysis.getStartTime() == null ? "" : simpleDateFormatTime.format(callAnalysis.getStartTime()) );
			row.createCell(colNum++).setCellValue( callAnalysis.getEndTime() == null ? "" : simpleDateFormatTime.format(callAnalysis.getEndTime()) );
			row.createCell(colNum++).setCellValue( (Integer)callAnalysis.getCallDuration() == null ? 0 : callAnalysis.getCallDuration() );
			if( callAnalysis.getCustomerResult() == 1 &&  callAnalysis.getCustomerFailCode() == 0 ) {
				row.createCell(colNum++).setCellValue( "" + callAnalysis.getCustomerResultString() + " ");
			} else if ( (Integer)callAnalysis.getCustomerResultFlag() == null || (Integer)callAnalysis.getCustomerResultFlag() == null ){
				row.createCell(colNum++).setCellValue("");
			}
			if( callAnalysis.getAgentResult() == 1 &&  callAnalysis.getAgentFailCode() == 0 ) {
				row.createCell(colNum++).setCellValue( "" + callAnalysis.getAgentResultString() + " ");
			} else if ( (Integer)callAnalysis.getAgentResultFlag() == null || (Integer)callAnalysis.getAgentFailCode() == null ){
				row.createCell(colNum++).setCellValue("");
			}
		}
		return excelName;
	}
	
	/**
	 * 고객 리포트 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelCustomerReport(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("고객_리포트_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<CallAnalysis> callAnalysisList = (List<CallAnalysis>)model.get("callAnalysisList");
		int colNum = 0;
		row = worksheet.createRow(0);
		row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("고객번호");
		row.createCell(colNum++).setCellValue("상담원");
		row.createCell(colNum++).setCellValue("상담일");
		row.createCell(colNum++).setCellValue("시작시간");
		
		row.createCell(colNum++).setCellValue("통화시간(초)");
		row.createCell(colNum++).setCellValue("분노 단계");
		row.createCell(colNum++).setCellValue("스트레스 단계");
		int i = 0;
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
		for(CallAnalysis callAnalysis : callAnalysisList){
			colNum = 0;
			row = worksheet.createRow(++i);
			row.createCell(colNum++).setCellValue( i);
			row.createCell(colNum++).setCellValue( callAnalysis.getCustomerNumber() == null ? "" : callAnalysis.getCustomerNumber() );
			row.createCell(colNum++).setCellValue( callAnalysis.getAgentName() == null ? "" : callAnalysis.getAgentName() );
			row.createCell(colNum++).setCellValue( callAnalysis.getStartTime() == null ? "" : simpleDateFormatDate.format(callAnalysis.getStartTime()) );
			row.createCell(colNum++).setCellValue( callAnalysis.getStartTime() == null ? "" : simpleDateFormatTime.format(callAnalysis.getStartTime()) );
			row.createCell(colNum++).setCellValue( (Integer)callAnalysis.getCallDuration() == null ? 0 : callAnalysis.getCallDuration() );
			if( callAnalysis.getCustomerResultFlag() == 1 &&  callAnalysis.getCustomerFailCode() == 0 ) {
				row.createCell(colNum++).setCellValue( "Y (" + callAnalysis.getCustomerResult() + " )");
			} else if ( (Integer)callAnalysis.getCustomerResultFlag() == null || (Integer)callAnalysis.getCustomerResultFlag() == null ){
				row.createCell(colNum++).setCellValue("");
			}
			if( callAnalysis.getAgentResultFlag() == 1 &&  callAnalysis.getAgentFailCode() == 0 ) {
				row.createCell(colNum++).setCellValue( "Y (" + callAnalysis.getAgentResult() + " )");
			} else if ( (Integer)callAnalysis.getAgentResultFlag() == null || (Integer)callAnalysis.getAgentFailCode() == null ){
				row.createCell(colNum++).setCellValue("");
			}
			 
		}
		return excelName;
	}
	/**
	 *시간대별 통계 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelStatHourly(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("시간대별_통계_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<HourlyCall> hourlyCallList = (List<HourlyCall>)model.get("hourlyCallList"); 
		int colNum = 0;
		row = worksheet.createRow(0);
		//row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("시간");
		row.createCell(colNum++).setCellValue("전체 호");
		row.createCell(colNum++).setCellValue("성공 호");
		row.createCell(colNum++).setCellValue("실패 호");
		row.createCell(colNum++).setCellValue("분노 단계");
		row.createCell(colNum++).setCellValue("스트레스 단계");
	//	row.createCell(colNum++).setCellValue("고객불만 증가");
	//	row.createCell(colNum++).setCellValue("고객불만 감소");

		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (HourlyCall hourlyCall : hourlyCallList ) {
			totalCount += hourlyCall.getTotalCount();
			successCount += hourlyCall.getSuccessCount();
			failCount += hourlyCall.getFailCount();
			angerCount += hourlyCall.getAngryCount();
			stressCount += hourlyCall.getStressCount();
			//incrementCount += hourlyCall.getIncrementCount();
			//decrementCount += hourlyCall.getDecrementCount();
		}
		
		colNum = 0;
		row = worksheet.createRow(1);
		//row.createCell(colNum++).setCellValue("");
		row.createCell(colNum++).setCellValue("합계");
		row.createCell(colNum++).setCellValue( totalCount );
		row.createCell(colNum++).setCellValue( successCount );
		row.createCell(colNum++).setCellValue( failCount );
		row.createCell(colNum++).setCellValue( angerCount );
		row.createCell(colNum++).setCellValue( stressCount );
		//row.createCell(colNum++).setCellValue( incrementCount );
	//	row.createCell(colNum++).setCellValue( decrementCount );
		
		int i = 1;
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("MM-dd HH:00");
		for(HourlyCall hourlyCall : hourlyCallList){
			colNum = 0;
			row = worksheet.createRow(++i);
			//row.createCell(colNum++).setCellValue( i-1 );
			row.createCell(colNum++).setCellValue( hourlyCall.getStatTime() == null ? "" : simpleDateFormatDate.format(hourlyCall.getStatTime()) );
			row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getTotalCount() == null ? 0 : hourlyCall.getTotalCount() );
			row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getSuccessCount() == null ? 0 : hourlyCall.getSuccessCount() );
			row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getFailCount() == null ? 0 : hourlyCall.getFailCount() );
			row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getAngryCount() == null ? 0 : hourlyCall.getAngryCount() );
			row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getStressCount() == null ? 0 : hourlyCall.getStressCount() );
			//row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getIncrementCount() == null ? 0 : hourlyCall.getIncrementCount() );
			//row.createCell(colNum++).setCellValue( (Integer)hourlyCall.getDecrementCount() == null ? 0 : hourlyCall.getDecrementCount() );
		}
		return excelName;
	}
	
	/**
	 * 일별 통계 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelStatDaily(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("일별_통계_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<DailyCall> dailyCallList = (List<DailyCall>)model.get("dailyCallList"); 
		int colNum = 0;
		row = worksheet.createRow(0);
		//row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("상담일");
		row.createCell(colNum++).setCellValue("전체 호");
		row.createCell(colNum++).setCellValue("성공 호");
		row.createCell(colNum++).setCellValue("실패 호");
		row.createCell(colNum++).setCellValue("분노 단계");
		row.createCell(colNum++).setCellValue("스트레스 단계");
		//row.createCell(colNum++).setCellValue("고객불만 증가");
		//row.createCell(colNum++).setCellValue("고객불만 감소");

		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (DailyCall dailyCall : dailyCallList ) {
			totalCount += dailyCall.getTotalCount();
			successCount += dailyCall.getSuccessCount();
			failCount += dailyCall.getFailCount();
			angerCount += dailyCall.getAngryCount();
			stressCount += dailyCall.getStressCount();
			incrementCount += dailyCall.getIncrementCount();
			decrementCount += dailyCall.getDecrementCount();
		}
		
		colNum = 0;
		row = worksheet.createRow(1);
		//row.createCell(colNum++).setCellValue("");
		row.createCell(colNum++).setCellValue("합계");
		row.createCell(colNum++).setCellValue( totalCount );
		row.createCell(colNum++).setCellValue( successCount );
		row.createCell(colNum++).setCellValue( failCount );
		row.createCell(colNum++).setCellValue( angerCount );
		row.createCell(colNum++).setCellValue( stressCount );
		//row.createCell(colNum++).setCellValue( incrementCount );
		//row.createCell(colNum++).setCellValue( decrementCount );
		
		int i = 1;
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
		for(DailyCall dailyCall : dailyCallList){
			colNum = 0;
			row = worksheet.createRow(++i);
			//row.createCell(colNum++).setCellValue( i-1 );
			row.createCell(colNum++).setCellValue( dailyCall.getStatTime() == null ? "" : simpleDateFormatDate.format(dailyCall.getStatTime()) );
			row.createCell(colNum++).setCellValue( (Integer)dailyCall.getTotalCount() == null ? 0 : dailyCall.getTotalCount() );
			row.createCell(colNum++).setCellValue( (Integer)dailyCall.getSuccessCount() == null ? 0 : dailyCall.getSuccessCount() );
			row.createCell(colNum++).setCellValue( (Integer)dailyCall.getFailCount() == null ? 0 : dailyCall.getFailCount() );
			row.createCell(colNum++).setCellValue( (Integer)dailyCall.getAngryCount() == null ? 0 : dailyCall.getAngryCount() );
			row.createCell(colNum++).setCellValue( (Integer)dailyCall.getStressCount() == null ? 0 : dailyCall.getStressCount() );
			//row.createCell(colNum++).setCellValue( (Integer)dailyCall.getIncrementCount() == null ? 0 : dailyCall.getIncrementCount() );
			//row.createCell(colNum++).setCellValue( (Integer)dailyCall.getDecrementCount() == null ? 0 : dailyCall.getDecrementCount() );
		}
		return excelName;
	}
	
	/**
	 * 월별 통계 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelStatMonthly(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("월별_통계_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<MonthlyCall> monthlyCallList = (List<MonthlyCall>)model.get("monthlyCallList"); 
		int colNum = 0;
		row = worksheet.createRow(0);
		row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("월");
		row.createCell(colNum++).setCellValue("전체 호");
		row.createCell(colNum++).setCellValue("성공 호");
		row.createCell(colNum++).setCellValue("실패 호");
		row.createCell(colNum++).setCellValue("분노 단계");
		row.createCell(colNum++).setCellValue("스트레스 단계");
		//row.createCell(colNum++).setCellValue("고객불만 증가");
		//row.createCell(colNum++).setCellValue("고객불만 감소");

		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (MonthlyCall monthlyCall : monthlyCallList ) {
			totalCount += monthlyCall.getTotalCount();
			successCount += monthlyCall.getSuccessCount();
			failCount += monthlyCall.getFailCount();
			angerCount += monthlyCall.getAngryCount();
			stressCount += monthlyCall.getStressCount();
			incrementCount += monthlyCall.getIncrementCount();
			decrementCount += monthlyCall.getDecrementCount();
		}
		
		colNum = 0;
		row = worksheet.createRow(1);
		row.createCell(colNum++).setCellValue("");
		row.createCell(colNum++).setCellValue("합계");
		row.createCell(colNum++).setCellValue( totalCount );
		row.createCell(colNum++).setCellValue( successCount );
		row.createCell(colNum++).setCellValue( failCount );
		row.createCell(colNum++).setCellValue( angerCount );
		row.createCell(colNum++).setCellValue( stressCount );
		//row.createCell(colNum++).setCellValue( incrementCount );
		//row.createCell(colNum++).setCellValue( decrementCount );
		
		int i = 1;
		SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM");
		for(MonthlyCall monthlyCall : monthlyCallList){
			colNum = 0;
			row = worksheet.createRow(++i);
			row.createCell(colNum++).setCellValue( i-1 );
			row.createCell(colNum++).setCellValue( monthlyCall.getStatTime() == null ? "" : simpleDateFormatDate.format(monthlyCall.getStatTime()) );
			row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getTotalCount() == null ? 0 : monthlyCall.getTotalCount() );
			row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getSuccessCount() == null ? 0 : monthlyCall.getSuccessCount() );
			row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getFailCount() == null ? 0 : monthlyCall.getFailCount() );
			row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getAngryCount() == null ? 0 : monthlyCall.getAngryCount() );
			row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getStressCount() == null ? 0 : monthlyCall.getStressCount() );
		//	row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getIncrementCount() == null ? 0 : monthlyCall.getIncrementCount() );
			//row.createCell(colNum++).setCellValue( (Integer)monthlyCall.getDecrementCount() == null ? 0 : monthlyCall.getDecrementCount() );
		}
		return excelName;
	}
	
	/**
	 * 상담원별 통계 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelStatAgent(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("상담원별_통계_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<AgentCall> agentCallList = (List<AgentCall>)model.get("agentCallList"); 
		int colNum = 0;
		row = worksheet.createRow(0);
		//row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("상담원");
		row.createCell(colNum++).setCellValue("전체 호");
		row.createCell(colNum++).setCellValue("성공 호");
		row.createCell(colNum++).setCellValue("실패 호");
		row.createCell(colNum++).setCellValue("분노 단계");
		row.createCell(colNum++).setCellValue("스트레스 단계");
		//row.createCell(colNum++).setCellValue("고객불만 증가");
		//row.createCell(colNum++).setCellValue("고객불만 감소");

		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (AgentCall agentCall : agentCallList ) {
			totalCount += agentCall.getTotalCount();
			successCount += agentCall.getSuccessCount();
			failCount += agentCall.getFailCount();
			angerCount += agentCall.getAngryCount();
			stressCount += agentCall.getStressCount();
			incrementCount += agentCall.getIncrementCount();
			decrementCount += agentCall.getDecrementCount();
		}
		
		colNum = 0;
		row = worksheet.createRow(1);
		//row.createCell(colNum++).setCellValue("");
		row.createCell(colNum++).setCellValue("합계");
		row.createCell(colNum++).setCellValue( totalCount );
		row.createCell(colNum++).setCellValue( successCount );
		row.createCell(colNum++).setCellValue( failCount );
		row.createCell(colNum++).setCellValue( angerCount );
		row.createCell(colNum++).setCellValue( stressCount );
		//row.createCell(colNum++).setCellValue( incrementCount );
		//row.createCell(colNum++).setCellValue( decrementCount );
		
		int i = 1;
		for(AgentCall agentCall : agentCallList){
			colNum = 0;
			row = worksheet.createRow(++i);
			//row.createCell(colNum++).setCellValue( i-1 );
			row.createCell(colNum++).setCellValue( agentCall.getAgentName() == null ? "" : agentCall.getAgentName() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getTotalCount() == null ? 0 : agentCall.getTotalCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getSuccessCount() == null ? 0 : agentCall.getSuccessCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getFailCount() == null ? 0 : agentCall.getFailCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getAngryCount() == null ? 0 : agentCall.getAngryCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getStressCount() == null ? 0 : agentCall.getStressCount() );
			//row.createCell(colNum++).setCellValue( (Integer)agentCall.getIncrementCount() == null ? 0 : agentCall.getIncrementCount() );
			//row.createCell(colNum++).setCellValue( (Integer)agentCall.getDecrementCount() == null ? 0 : agentCall.getDecrementCount() );
		}
		return excelName;
	}
	/**
	 * 근무 성과별 통계 목록을 엑셀로 다운로드하기 위한 내부( Private ) 함수입니다. 
	 * @param model
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	private String makeExcelStatPerformance(Map<String, Object> model, Workbook workbook) throws Exception {
		String today =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		String excelName = URLEncoder.encode("근무성과별_통계_"+today+".xlsx","UTF-8");
		
		Sheet worksheet = null;
		Row row = null;
		worksheet = workbook.createSheet(excelName+ " WorkSheet");

		@SuppressWarnings("unchecked")
		List<AgentCall> agentCallList = (List<AgentCall>)model.get("agentCallList"); 
		int colNum = 0;
		row = worksheet.createRow(0);
		row.createCell(colNum++).setCellValue("일련번호");
		row.createCell(colNum++).setCellValue("상담원");
		row.createCell(colNum++).setCellValue("전체 호");
		row.createCell(colNum++).setCellValue("성공 호");
		row.createCell(colNum++).setCellValue("실패 호");
		row.createCell(colNum++).setCellValue("주의 단계");
		row.createCell(colNum++).setCellValue("흥미 단계");
		row.createCell(colNum++).setCellValue("고객불만 증가");
		row.createCell(colNum++).setCellValue("고객불만 감소");

		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (AgentCall agentCall : agentCallList ) {
			totalCount += agentCall.getTotalCount();
			successCount += agentCall.getSuccessCount();
			failCount += agentCall.getFailCount();
			angerCount += agentCall.getAngryCount();
			stressCount += agentCall.getStressCount();
			incrementCount += agentCall.getIncrementCount();
			decrementCount += agentCall.getDecrementCount();
		}
		
		colNum = 0;
		row = worksheet.createRow(1);
		row.createCell(colNum++).setCellValue("");
		row.createCell(colNum++).setCellValue("합계");
		row.createCell(colNum++).setCellValue( totalCount );
		row.createCell(colNum++).setCellValue( successCount );
		row.createCell(colNum++).setCellValue( failCount );
		row.createCell(colNum++).setCellValue( angerCount );
		row.createCell(colNum++).setCellValue( stressCount );
		row.createCell(colNum++).setCellValue( incrementCount );
		row.createCell(colNum++).setCellValue( decrementCount );
		
		int i = 1;
		for(AgentCall agentCall : agentCallList){
			colNum = 0;
			row = worksheet.createRow(++i);
			row.createCell(colNum++).setCellValue( i-1 );
			row.createCell(colNum++).setCellValue( agentCall.getAgentName() == null ? "" : agentCall.getAgentName() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getTotalCount() == null ? 0 : agentCall.getTotalCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getSuccessCount() == null ? 0 : agentCall.getSuccessCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getFailCount() == null ? 0 : agentCall.getFailCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getAngryCount() == null ? 0 : agentCall.getAngryCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getStressCount() == null ? 0 : agentCall.getStressCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getIncrementCount() == null ? 0 : agentCall.getIncrementCount() );
			row.createCell(colNum++).setCellValue( (Integer)agentCall.getDecrementCount() == null ? 0 : agentCall.getDecrementCount() );
		}
		return excelName;
	}
}
