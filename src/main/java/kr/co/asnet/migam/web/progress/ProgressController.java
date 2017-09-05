package kr.co.asnet.migam.web.progress;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.asnet.migam.domain.agent.ProgressLink;
import kr.co.asnet.migam.service.agent.ProgressLinkService;

/**
 * 시스템::시스템 설정 컨트롤러
 * 
 * @author kwonsy
 * 
 */
@Controller
@RequestMapping("/progress")
public class ProgressController {
	private final Logger logger = LoggerFactory.getLogger(ProgressController.class);
	@Inject
	private ProgressLinkService progressLinkService;
	// 프로퍼티 객체 주입
	@Resource(name = "appProp")
	private Properties appProp;



	@RequestMapping(value = "/progress_link", method = { RequestMethod.GET, RequestMethod.POST })
	public String progress_link(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model, ProgressLink progressLink) {

		 
		List<ProgressLink> progresslinkList = progressLinkService.getprogressbar(progressLink);

		model.addAttribute("agent_id", progressLink.getAgent_id());

		model.addAttribute("indicator_name", progressLink.getIndicator_name());
		model.addAttribute("custom_num", progressLink.getCustom_num());
		model.addAttribute("ProgressList", progresslinkList);

		return "/link/progress_link"; // 메인페이지가 완성되지 않아 임시 주석처리합니다.
	}

	

	@RequestMapping(value = "/req_progress", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<ProgressLink> reqInfo(Model model, ProgressLink progressLink) {
		return progressLinkService.getprogressbar(progressLink);
	}
	

	

	@RequestMapping(value = "/pop_linegraph", method = { RequestMethod.GET, RequestMethod.POST })
	public String pop_linegraph(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model, ProgressLink progressLink) {
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HH:mm:ss");		
		String time = formatter.format(new java.util.Date());
		
		model.addAttribute("time", time);
		model.addAttribute("agent_id", progressLink.getAgent_id());
		model.addAttribute("custom_num", progressLink.getCustom_num());
		return "/link/pop_linegraph"; // 메인페이지가 완성되지 않아 임시 주석처리합니다.
	}



}
