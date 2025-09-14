package com.sh.haagendazo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.haagendazo.model.Approval;
import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.User;
import com.sh.haagendazo.service.ApprovalService;

@Controller
public class ApprovalController {
	
	@Autowired
	private ApprovalService service;
	
	@GetMapping("/approval")
	public String adminApprovalList(Paging paging, Model model) {
		System.out.println("/approval: " + paging);
		List<Approval> approvalList = service.allAprovalsList(paging);
		
		model.addAttribute("approvalList", approvalList);
		model.addAttribute("paging", new Paging(paging.getPage(), service.total(paging)));
		return "/approval/approval";
	}
	
	@GetMapping("/approval/my")
	public String researcherApprovalList(@AuthenticationPrincipal User user, Paging paging, Model model) {
		System.out.println("/approval/my: " + paging);
		paging.setUserId(user.getUserId());
		
		List<Approval> approvalList = service.allAprovalsList(paging);
		model.addAttribute("approvalList", approvalList);
		model.addAttribute("paging", new Paging(paging.getPage(), service.total(paging)));
		return "/approval/approval";
	}
	
	@PostMapping("/chemical/approval")
	private String requestApproval(@AuthenticationPrincipal User user, Approval vo) {
		service.requestApproval(user, vo);
		return "redirect:/chemical/request";
	}
	
	@PostMapping("/approval/process/addition")
	private String processAddition(@RequestParam(name="approvalIdList", required = false) List<Integer> approvalIdList
									, @RequestParam(name="targetIdList", required = false) List<Integer> targetIdList
									,@RequestParam(name="reqbyIdList", required = false) List<Integer> reqbyIdList
									, @AuthenticationPrincipal User user, Approval vo) {
		System.out.println("addtion: "+vo);
		service.approvedChemicalAddition(approvalIdList, targetIdList, reqbyIdList, user, vo);
		return "redirect:/approval";
	}
	
	@PostMapping("/approval/process/usage")
	private String processUsage(@RequestParam(name="approvalIdList", required = false) List<Integer> approvalIdList
								, @RequestParam(name="usedQtyList", required = false) List<Integer> usedQtyList
								, @RequestParam(name="chemicalIdList", required = false) List<Integer> chemicalIdList
								, @RequestParam(name="targetIdList", required = false) List<Integer> targetIdList
								,@RequestParam(name="reqbyIdList", required = false) List<Integer> reqbyIdList
								, @AuthenticationPrincipal User user, Approval vo) {
		service.approvedChemicalUsage(approvalIdList, chemicalIdList, targetIdList, usedQtyList, reqbyIdList, user, vo);
		System.out.println("usage"+vo);
		return "redirect:/approval";
	}
	
	@PostMapping("/approval/process/document")
	private String processDocument(@RequestParam(name="approvalIdList", required = false) List<Integer> approvalIdList
								,@RequestParam(name="reqbyIdList", required = false) List<Integer> reqbyIdList
								,@AuthenticationPrincipal User user, Approval vo) {
		List<Approval> approvalList = new ArrayList<>();
		for(int i = 0; i < approvalIdList.size(); i++) {
			Approval approval1 = new Approval(); 
			approval1.setApprovalId(approvalIdList.get(i));
			approval1.setRequestedBy(reqbyIdList.get(i));
			approval1.setApprovedBy(user.getUserId());
			approval1.setStatus(vo.getStatus());
			approval1.setComment(vo.getComment());
			approvalList.add(approval1);
			
			vo.setApprovalId(approval1.getApprovalId());
			vo.setRequestedBy(approval1.getRequestedBy());
			service.approvalMessage(vo);
		}
		System.out.println("docu"+approvalList);
		System.out.println("docu"+reqbyIdList);
		System.out.println("docu"+user);
		System.out.println("docu"+vo);
		service.processApproval(approvalList); // 사용 요청
		return "redirect:/approval";
	}

}
