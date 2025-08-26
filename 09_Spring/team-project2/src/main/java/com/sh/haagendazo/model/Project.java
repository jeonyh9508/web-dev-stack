package com.sh.haagendazo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
	private int projectId;
	private String projectCode;
	private String projectName;
	private String projectType;
	private int userId; // 프로젝트 책임자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private String status;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// project_member
	private int memberId;
	private int memberUserId;
	private String memberRole;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date memberCreatedAt;

	// user (참여자)
	private int userUserId;
	private String email;
	private String password;
	private String name;
	private int deptId;
	private int gradeId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userCreatedAt;

	// project_document
	private int documentId;
	private int documentProjectId;
	private int documentUserId;
	private String fileName;
	private String filePath;
	private int version;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date uploadedAt;

	// approval
	private int approvalId;
	private int approvalProjectId;
	private int requestedBy;
	private String approvalType;
	private int targetId;
	private String approvalStatus;
	private String comment;
	private int approvedBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approvedAt;

	// project_chemical
	private int projectChemicalId;
	private int pcChemicalId;
	private int pcUserId;
	private int usedQty;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date usedAt;

	// chemical
	private int chemicalId;
	private String chemicalName;
	private String casNo;
	private String storageUnit;
	private int storageId;
	private int stockQty;
	private int thresholdQty;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cCreatedAt;
	private String storageName;
	private String storageLocation;

	private int scheduleId;
	private String title;
	private String scheDescription;
	private int scheUserId; // 작성자
	private int scheProjectId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date scheStartDatetime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date scheEndDatetime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date scheCreatedAt;
}
