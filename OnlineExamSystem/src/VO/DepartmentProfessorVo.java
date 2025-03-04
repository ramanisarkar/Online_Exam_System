package VO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DepartmentProfessor")
public class DepartmentProfessorVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Roll")
	private String roll;

	@ManyToOne
	@JoinColumn(name = "Collegeid")
	private CollegeVo collegeid;
	
	@ManyToOne
	@JoinColumn(name = "Departmentid")
	private DepartmentVo departmentid;
	
	@ManyToOne
	@JoinColumn(name = "Professorid")
	private ProfessorVo professorid ;
	
	@OneToMany(mappedBy = "departmentprofessorid", cascade = CascadeType.REMOVE)
	private List<SemProfessorVo> semprofessor;
	
	@OneToMany(mappedBy = "departmentprofessorid", cascade = CascadeType.REMOVE)
	private List<SubjectProfessorVo> subjectprofessor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public CollegeVo getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(CollegeVo collegeid) {
		this.collegeid = collegeid;
	}

	public DepartmentVo getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(DepartmentVo departmentid) {
		this.departmentid = departmentid;
	}

	public ProfessorVo getProfessorid() {
		return professorid;
	}

	public void setProfessorid(ProfessorVo professorid) {
		this.professorid = professorid;
	}

	public List<SemProfessorVo> getSemprofessor() {
		return semprofessor;
	}

	public void setSemprofessor(List<SemProfessorVo> semprofessor) {
		this.semprofessor = semprofessor;
	}

	public List<SubjectProfessorVo> getSubjectprofessor() {
		return subjectprofessor;
	}

	public void setSubjectprofessor(List<SubjectProfessorVo> subjectprofessor) {
		this.subjectprofessor = subjectprofessor;
	}
	
	
}
