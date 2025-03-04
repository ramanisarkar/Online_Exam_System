package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import VO.DepartmentProfessorVo;
import VO.ProfessorVo;
import VO.SemProfessorVo;

public class SemProfessorDao {

	public void insert(SemProfessorVo semprofessorvo) {
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(semprofessorvo);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<SemProfessorVo> searchCollegeProfessorsemester(SemProfessorVo semprofessorvo) {
		List<SemProfessorVo> professorList = new ArrayList<SemProfessorVo>();
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from SemProfessorVo AS p where p.professorid =:id");
			q.setParameter("id", semprofessorvo.getProfessorid());
			professorList = q.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<SemProfessorVo>) professorList;
	}

	public ArrayList<SemProfessorVo> searchSemesterProfessor(SemProfessorVo semProfessorVo) {
		List<SemProfessorVo> professorList = new ArrayList<SemProfessorVo>();
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from SemProfessorVo AS d where d.semid =:department");
			q.setParameter("department", semProfessorVo.getSemid());
			professorList = q.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<SemProfessorVo>) professorList;
	}

	public ArrayList<SemProfessorVo> searchCollegeDepartmentProfessorsemester(SemProfessorVo semProfessorVo) {
		List<SemProfessorVo> professorList = new ArrayList<SemProfessorVo>();
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery("from SemProfessorVo AS d where d.departmentprofessorid =:department");
			q.setParameter("department", semProfessorVo.getDepartmentprofessorid());
			professorList = q.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<SemProfessorVo>) professorList;
	}
}
