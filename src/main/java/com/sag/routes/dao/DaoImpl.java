package com.sag.routes.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sag.routes.model.Announcement;
import com.sag.routes.model.AttendanceUser;
import com.sag.routes.model.Books;
import com.sag.routes.model.CampusUser;
import com.sag.routes.model.Class;
import com.sag.routes.model.ClassTimeTable;
import com.sag.routes.model.Course;

import com.sag.routes.model.Discipline;
import com.sag.routes.model.DriverUser;
import com.sag.routes.model.Event;
import com.sag.routes.model.ExamClassMapping;
import com.sag.routes.model.ExamDetails;
import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.HolidayList;
import com.sag.routes.model.InstitutionalRole;
import com.sag.routes.model.Librarian;
import com.sag.routes.model.Login;
import com.sag.routes.model.MedicalDetails;
import com.sag.routes.model.Organization;
import com.sag.routes.model.ProductData;
import com.sag.routes.model.School;
import com.sag.routes.model.SchoolNews;
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.model.StudentEnroll;
import com.sag.routes.model.SystemRole;
import com.sag.routes.model.Term;
import com.sag.routes.model.UserAnnouncementMapping;
import com.sag.routes.model.Users;
import com.sag.routes.model.UserContext;
import com.sag.routes.model.UserEnrollment;
import com.sag.routes.model.VehicleDetail;






@Transactional
@Repository
public class DaoImpl implements Dao {
	
	
	@Autowired
	 private static SessionFactory sessionFactory;
	@Autowired
	private static Session session;
	 
	private static StandardServiceRegistry registry;
	  

	/*Entity Manager is used to access a database 
	* it is used to create and remove persistent entity instances
	*to find entities by their primary key identity etc. 
	*This interface is similar to the Session in Hibernate
	*/
	@PersistenceContext
	private EntityManager entityManager;
	 private static SessionFactory factory;
	// Route DAO Implementation
	
	
	

		@Override
		public Student getStudentById(int id) {
			// TODO Auto-generated method stub
			return entityManager.find(Student.class, id);
		}

		@Override
		public List<Student> getAllStudents() {
			// TODO Auto-generated method stub
			String hql = "FROM Student as stu ORDER BY stu.sdId";
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		@Transactional
		public void addStudent(Student student) {
			// TODO Auto-generated method stub
		
			
			//persist example - with transaction
			
			//entityManager.getTransaction().begin();
			/*Student stud=new Student();
			stud.setSdId(40);*/
			System.out.println("Saving Employee to Database");
			
			//entityManager.merge(student);
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			registry= registryBuilder.build();
			 // Create MetadataSources
	        MetadataSources sources = new MetadataSources(registry);
	        // Create Metadata
	        Metadata metadata = sources.getMetadataBuilder().build();
	     // Create SessionFactory
	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	     // Create SessionFactory
	        Session session = sessionFactory.openSession();  
	        Transaction t = session.beginTransaction(); 
	        student.setBookId(1);
	        student.setCategoryId(2);
	        student.setClassId(3);
	        student.setCmId(4);
	        student.setDocumentsSubmitted("yes");
	        student.setEventId(1);
	        student.setMotherTongueId(3);
	        student.setNationalityId(1);
	       student.setReligionId(3);
			student.setSdId(20);
			student.setStudentadminno(90);
			student.setUser_id(21);
			student.setVehicleId(3);
session.persist(student);
			entityManager.flush();
		}
			
		

		@Override
		public void updateStudent(Student student) {
			// TODO Auto-generated method stub
			Student stu = entityManager.find(Student.class, student.getSdId());
			stu.setSdId(student.getSdId());
			stu.setUser_id(student.getUser_id());
			stu.setReligionId(student.getReligionId());
			entityManager.flush();
		}
		@Override
		public boolean studentExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM Student as stu WHERE stu.sdId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		

		@Override
		public void deleteStudent(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Student.class, id));
		}

		@Override
		public Staff getstaffById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(Staff.class, id);
		}

		@Override
		public List<Staff> getAllstaffs() {
			// TODO Auto-generated method stub
			String hql = "FROM Staff as staf ORDER BY staf.id";
			return (List<Staff>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addStaff(Staff staff) {
			// TODO Auto-generated method stub
		//entityManager.persist(staff);
			session=sessionFactory.openSession();
			session.save(staff);
			entityManager.getTransaction().begin();
			
			/*entityManager.persist(staff);
			entityManager.getTransaction().commit();*/
			entityManager.close();
			
		}

		@Override
		public void updatestaff(Staff staff) {
			// TODO Auto-generated method stub
			Staff staf = entityManager.find(Staff.class, staff.getId());
			staf.setId(staf.getId());
			staf.setUser_id(staf.getUser_id());
			entityManager.flush();
		}
		@Override
		public boolean staffExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM Staff as staf WHERE staf.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		//StaffsDetails

		@Override
		public void deletestaff(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Staff.class, id));
		}

		
		//GuardianDetails
		@Override
		public GuardianUser getGuardianById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(GuardianUser.class, id);
		}

		@Override
		public List<GuardianUser> getAllGuardians() {
			// TODO Auto-generated method stub
			String hql = "FROM GuardianUser as guardian ORDER BY guardian.id";
			return (List<GuardianUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean guardianExists(int id, int userid)
		{
			// TODO Auto-generated method stub
			String hql = "FROM Guardian as guardian WHERE guardian.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addGuardian(GuardianUser guardian) {
			// TODO Auto-generated method stub
			entityManager.persist(guardian);
		}

		@Override
		public void updateGuardian(GuardianUser guardian) {
			// TODO Auto-generated method stub
			GuardianUser guardians = entityManager.find(GuardianUser.class, guardian.getgId());
			guardians.setgId(guardians.getgId());
			guardians.setUser_id(guardians.getUser_id());
			entityManager.flush();
		}

		@Override
		public void deleteGuardian(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(GuardianUser.class, id));
		}

		@Override
		public Librarian getLibrarianById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(Librarian.class, id);
		}
		

		@SuppressWarnings("unchecked")
		@Override
		public List<Librarian> getAllLibrarians() {
			// TODO Auto-generated method stub
			String hql = "FROM Librarian as librarian ORDER BY librarian.libId";
			return (List<Librarian>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean librarianExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM LibrarainUser as librarian WHERE librarian.libId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addLibrarian(Librarian librarian) {
			// TODO Auto-generated method stub
			entityManager.persist(librarian);
		}

		@Override
		public void updateLibrarian(Librarian librarian) {
			// TODO Auto-generated method stub
			Librarian librarians = entityManager.find(Librarian.class, librarian.getLibId());
			librarians.setLibId(librarians.getLibId());
			librarians.setUser_Id(librarians.getUser_Id());
			entityManager.flush();
		}

		@Override
		public void deleteLibrarian(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Librarian.class, id));
		}

		//Organization
		
		@Override
		public Organization getOrganizationById(Integer oId) {
			// TODO Auto-generated method stub
			return entityManager.find(Organization.class, oId);
		}

		@Override
		public List<Organization> getAllOrganization() {
			// TODO Auto-generated method stub
			String hql = "FROM Organization as organization ORDER BY organization.oId";
			return (List<Organization>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean organizationExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM Organization as organization WHERE organization.oId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addOrganization(Organization organization) {
			// TODO Auto-generated method stub
			entityManager.persist(organization);
		}

		@Override
		public void updateOrganization(Organization organization) {
			// TODO Auto-generated method stub
			Organization organizations = entityManager.find(Organization.class, organization.getoId());
			organizations.setoId(organizations.getoId());
			organizations.setOrganizationName(organizations.getOrganizationName());
			entityManager.flush();
		}

		@Override
		public void deleteOrganization(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Organization.class, id));
		}

		@Override
		public School getSchoolById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(School.class, id);
		}

		@Override
		public List<School> getAllSchool() {
			// TODO Auto-generated method stub
			String hql = "FROM School as school ORDER BY school.id";
			return (List<School>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addSchool(School school) {
			// TODO Auto-generated method stub
			entityManager.persist(school);
		}

		@Override
		public boolean schoolExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM School as school WHERE school.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void updateSchool(School school) {
			// TODO Auto-generated method stub
			School schools = entityManager.find(School.class, school.getId());
			schools.setId(schools.getId());
			schools.setCampus_ID(schools.getCampus_ID());
			entityManager.flush();
		}

		@Override
		public void deleteSchool(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(School.class, id));
			
		}

		@Override
		public CampusUser getCampusById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(CampusUser.class, id);
		}

		@Override
		public List<CampusUser> getAllCampuses() {
			// TODO Auto-generated method stub
			String hql = "FROM CampusUser as campus ORDER BY campus.cmId";
			return (List<CampusUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean CampusExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM CampusUser as campus WHERE campus.cmId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addCampus(CampusUser campus) {
			// TODO Auto-generated method stub
			entityManager.persist(campus);
		}

		@Override
		public void updateCampus(CampusUser campus) {
			// TODO Auto-generated method stub
			CampusUser campuses = entityManager.find(CampusUser.class, campus.getCmId());
			campuses.setCmId(campuses.getCmId());
			campuses.setCampus_name(campuses.getCampus_name());
			campuses.setCampusAddress(campus.getCampusAddress());
			campuses.setCampusLocation(campuses.getCampusLocation());
			campus.setOrganization_id(campus.getOrganization_id());
			campus.setOrganizationName(campus.getOrganizationName());
			entityManager.flush();
		}
		@Override
		public void deleteCampus(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(CampusUser.class, id));
			
		}

		@Override
		public Class getClassById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(com.sag.routes.model.Class.class, id);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<com.sag.routes.model.Class> getAllClasses() {
			// TODO Auto-generated method stub
			String hql = "FROM Class as clas ORDER BY clas.id";
			return (List<com.sag.routes.model.Class>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean ClassExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM Class as clas WHERE clas.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addClass(com.sag.routes.model.Class class1) {
			// TODO Auto-generated method stub
			entityManager.persist(class1);
		}

		@Override
		public void updateClass(com.sag.routes.model.Class class1) {
			// TODO Auto-generated method stub
			Class classes = entityManager.find(Class.class, class1.getId());
			classes.setId(classes.getId());
			classes.setClass_name(classes.getClass_name());
			entityManager.flush();
		}

		@Override
		public void deleteClass(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Class.class, id));
		}

		@Override
		public Course getCourseById(Integer courseCode) {
			// TODO Auto-generated method stub
			return entityManager.find(Course.class, courseCode);
		}

		@Override
		public List<Course> getAllCourses() {
			// TODO Auto-generated method stub
			String hql = "FROM Course as course ORDER BY course.courseCode";
			return (List<com.sag.routes.model.Course>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addCourse(Course course) {
			// TODO Auto-generated method stub
			entityManager.merge(course);
		}

		@Override
		public boolean CourseExists(int id, String id2) {
			// TODO Auto-generated method stub
			String hql = "FROM Course as coursetutorial WHERE coursetutorial.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void updateCourse(Course course) {
			// TODO Auto-generated method stub
			Course courses = entityManager.find(Course.class, course.getCourseCode());
			courses.setCourseCode(course.getCourseCode());
			courses.setDiscipline(course.getDiscipline());
			courses.setTerm(course.getTerm());
			entityManager.flush();
		}

		@Override
		public Course deleteCourse(Integer TermId) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Course.class, TermId));
			return null;
		}

		@Override
		public AttendanceUser CreateAttendance(int stuid, int classid) {
			// TODO Auto-generated method stub
			AttendanceUser attendance=entityManager.find(AttendanceUser.class, classid);
			attendance.setStud_id(stuid);
			attendance.setId(classid);
			return attendance;
		}

		@Override
		public UserContext createUserContext(int id, int id2) {
			// TODO Auto-generated method stub
	UserContext user=entityManager.find(UserContext.class,id );
	user.setContextId(id);
	user.setId(id2);
	user.setUserId(id);
	return user;
		}

		@Override
		public AttendanceUser getAttendance(int stud_id, int class_id) {
			// TODO Auto-generated method stub
			return entityManager.find(AttendanceUser.class, stud_id);
		}

		@Override
		public List<AttendanceUser> getAttendanceList(int stud_id) {
			// TODO Auto-generated method stub
			String hql = "FROM AttendanceUser as attend where attend.stud_id="+stud_id;
			return (List<AttendanceUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Student> getStudentListByCampusId(Integer cmId) {
			// TODO Auto-generated method stub
			//return entityManager.find(Student.class, cmId);
			String hql = "FROM Student as stu where stu.cmId="+cmId;
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Student> getStudentListByClassId(int  classId) {
			// TODO Auto-generated method stub
			String hql = "FROM Student as stu where stu.classId="+classId;
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public Student getStudentVehicleDetailsByStudentAdmNum(
				Integer stdadmissionno) {
			// TODO Auto-generated method stub
			return entityManager.find(Student.class, stdadmissionno);
		}

		@Override
		public Student getStdUserByStdAdmissionNumber(Integer Studentadminno) {
			// TODO Auto-generated method stub
			return entityManager.find(Student.class, Studentadminno);
		}

		@Override
		public List<Event> getStudentEventDetailsByStudentUserId(int studentUserId) {
			// TODO Auto-generated method stub
			String hql = "FROM Event as evn where evn.studentUserId="+studentUserId;
			return (List<Event>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Student> getStudentDetailByStdAdmNum(Integer stdadmissionno) {
			
			String hql = "FROM Student as stud where stud.stdadmissionno="+stdadmissionno;
			return (List<Student>) entityManager.createQuery(hql).getResultList();
			}

		@Override
		public VehicleDetail getStudentVehicleDetailsByStudentVehicleId(
				int vehicleId) {
			// TODO Auto-generated method stub
			return entityManager.find(VehicleDetail.class, vehicleId);
		}
		

		@Override
		public List< Staff> getStaffUserListByClassId(Integer classId) {
			String hql="FROM Staff as staff where staff.classId="+classId;
			return (List<Staff>) entityManager.createQuery(hql).getResultList();
		}

		

		@Override
		public List<Staff> getStaffUserListByCampusId(Integer campusId) {
			String hql="From Staff as staff where staff.campusId="+campusId;
			return (List<Staff>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Class> getAllClassesByCompusId(Integer campus_id) {
			// TODO Auto-generated method stub
			String hql="From Class as class where class.campus_id="+campus_id;
			return (List<Class>)entityManager.createQuery(hql).getResultList();
		}

		
		//getListOfStudentByCampusIdWhoHasTakenBooks
		@Override
		public List<Student> getListOfStudentByCampusIdWhoHasTakenBooks(Integer campus_id,Integer bookId) {
			// TODO Auto-generated method stub
			String hql="select stu.sdId,stu.user_id,stu.Studentadminno,stu.vehicleId,stu.eventId,stu.documentsSubmitted,stu.religionId,stu.motherTongueId,stu.categoryId,stu.nationalityId,stu.classId FROM Student as stu where stu.cmId = '"
					+ campus_id + "' and stu.bookId =  '" + bookId+ "'";
			return (List<Student>)entityManager.createQuery(hql).getResultList();
		}
	
		
		
		@Override
		public List<Books> getBookListByCampusId(Integer campusId) {
			String hql="From Books as book where book.campusId="+campusId;
			return (List<Books>)entityManager.createQuery(hql).getResultList();
	 }
	 
		@Override
		public List<Student> getStudentWhoHasReturnBook(Integer campus_id) {
			// TODO Auto-generated method stub
			String hql="From Books as book where book.campus_id="+campus_id;
			return (List<Student>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public DriverUser getdriverdetailsByID(Integer dId) {
			// TODO Auto-generated method stub
			return entityManager.find(DriverUser.class, dId);
		}

		@Override
		public List<DriverUser> getdriverdetailsByCampusID(Integer campusId) {
			String hql="From Driver as driver where driver.campusId="+campusId;
			return (List<DriverUser>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<VehicleDetail> getVehicleListByCampusId(Integer campusId) {
			String hql="From Vehicle as vehicle where vehicle.campusId="+campusId;
			return (List<VehicleDetail>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<VehicleDetail> getVehicleListByCampusIdDriverId(Integer campusId, Integer driverId) {
			// TODO Auto-generated method stub
			String hql="select veh.vdId,veh.Vehicle_no,veh.Vehicle_code,veh.No_Of_Seat,veh.Maximum_capacity,veh.insurance,veh.tax_remitted,veh.permit,veh.GpsNumber,veh.status,veh.Vehicle_type_id,veh.campusId FROM Vehcile as veh where veh.campusId = '"
					+ campusId + "' and veh.dId =  '" + driverId+ "'";
			return (List<VehicleDetail>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public ExamDetails getExamById(Integer EttId) {
			// TODO Auto-generated method stub
			return entityManager.find(ExamDetails.class, EttId);
		}

		@Override
		public List<ExamDetails> getExamDetails() {
			// TODO Auto-generated method stub
			String hql = "FROM ExamDetails as exam ORDER BY exam.EttId";
			return (List<ExamDetails>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<ExamClassMapping> getExamTimeTableByClassId(Integer classId) {
			// TODO Auto-generated method stub
			//String hql="select exms.ecmId,exms.examId,exms.classId,exms.sectionId,exms.termId,exms.createdAt,exms.updatedAt FROM ExamClassMapping as exms where exms.classId = '"
				//	+ classId+ "'";
			String hql="From ExamClassMapping as exams where exams.classId="+classId;
			return (List<ExamClassMapping>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<ClassTimeTable> getClassTimeTableByClassId(Integer classId) {
			// TODO Auto-generated method stub
			/*String hql="select classTime.TtId,classTime.classId,classTime.weekDayId,classTime.sectionId,classTime.subjectName,classTime.startTime,classTime.endTime FROM ClassTimeTable as classTime where classTime.classId = '"
					+ classId+ "'";*/
			String hql="From ClassTimeTable as classTime where classTime.classId="+classId;
			return (List<ClassTimeTable>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public SchoolNews getSchoolNewsListBySchoolId(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(SchoolNews.class, id);
		}

		@Override
		public School getSchoolListByCampusId(Integer id)
		{
			// TODO Auto-generated method stub
			return entityManager.find(School.class, id);
	
		}

		@Override
		public com.sag.routes.model.MedicalDetails getMedicalDetailsById(Integer mid)
		{
			// TODO Auto-generated method stub
			return entityManager.find(MedicalDetails.class, mid);
			
		}

		@Override
		public List<com.sag.routes.model.MedicalDetails> getMedicalDetails() {
			// TODO Auto-generated method stub
			String hql = "FROM Medical_Details as medical ORDER BY medical.mid";
			return (List<MedicalDetails>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean MedicalExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM MedicalDetails as medical WHERE medical.id ="+id;
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addMedical(com.sag.routes.model.MedicalDetails medical) 
		{
			// TODO Auto-generated method stub
			
			entityManager.persist(medical);
		}

		@Override
		public void updateMedical(com.sag.routes.model.MedicalDetails medical) {
			// TODO Auto-generated method stub
			com.sag.routes.model.MedicalDetails medicals = entityManager.find(com.sag.routes.model.MedicalDetails.class, medical.getMid());
			medicals.setMid(medical.getMid());
			medicals.setDoctorname(medical.getDoctorname());
			entityManager.flush();
		}

		@Override
		public void deleteMedicalDetails(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(com.sag.routes.model.MedicalDetails.class, id));
		}

		@Override
		public void addStudentDetails(Student student) 
		{
			// TODO Auto-generated method stub
System.out.println("Saving Employee to Database");
			
			//entityManager.merge(student);
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			registry= registryBuilder.build();
			 // Create MetadataSources
	        MetadataSources sources = new MetadataSources(registry);
	        // Create Metadata
	        Metadata metadata = sources.getMetadataBuilder().build();
	     // Create SessionFactory
	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	     // Create SessionFactory
	        Session session = sessionFactory.openSession();  
	        Transaction t = session.beginTransaction(); 
	        student.setBookId(1);
	        student.setCategoryId(2);
	        student.setClassId(3);
	        student.setCmId(4);
	        student.setDocumentsSubmitted("yes");
	        student.setEventId(1);
	        student.setMotherTongueId(3);
	        student.setNationalityId(1);
	       student.setReligionId(3);
			student.setSdId(20);
			student.setStudentadminno(90);
			student.setUser_id(21);
			student.setVehicleId(3);
			entityManager.flush();
			
		}

		@Override
		public List<HolidayList> getHolidayListByCampusId(Integer campusId) 
		{
			// TODO Auto-generated method stub
			String hql="From HolidayList as holiday where holiday.campusId="+campusId;
			return (List<HolidayList>)entityManager.createQuery(hql).getResultList();
			
		}

		@Override
		public HolidayList getHolidayListById(Integer hId) {
			// TODO Auto-generated method stub
			return entityManager.find(HolidayList.class, hId);
		}

		

		@Override
		public boolean routeExists(String source, String destination) 
		{
			System.out.println("source"+source);
			String hql = "FROM Route as rte WHERE rte.source = ? and rte.destination =?";
			int count = entityManager.createQuery(hql).setParameter(1, source).setParameter(2, destination).getResultList()
					.size();
			return count > 0;
		}

		@Override
		public Login getLoginDetailsById(Integer id) 
		{
			// TODO Auto-generated method stub
			return entityManager.find(Login.class, id);
		}

		@Override
		public List<Login> getLoginDetails() 
		{
			// TODO Auto-generated method stub
			String hql = "FROM Login as logins ORDER BY logins.id";
			return (List<Login>) entityManager.createQuery(hql).getResultList();
		}

		/*@Override
		public List<CourseAssessment> getCourseAssessmentDetails(Integer courseId,Integer AssessmentId) 
		{
			String hql="select courseAssmnt.courseId,courseAssmnt.assesmentId,courseAssmnt.title,courseAssmnt.points,courseAssmnt.intsructorNotes,courseAssmnt.type FROM courseassesment as courseAssmnt where courseAssmnt.courseId = '"
					+ courseId + "'and courseAssmnt.assessmentId ='" + AssessmentId+ "'";
			return (List<CourseAssessment>)entityManager.createQuery(hql).getResultList();
			
		}

		@Override
		public List<CourseMembership> getCourseMembersDetails(Integer courseId,Integer AssessmentId) 
		{
			String hql="select courseAssmnt.courseId,courseAssmnt.assesmentId,courseAssmnt.title,courseAssmnt.points,courseAssmnt.intsructorNotes,courseAssmnt.type FROM courseassesment as courseAssmnt where courseAssmnt.courseId = '"
					+ courseId + "'and courseAssmnt.assessmentId ='" + AssessmentId+ "'";
			return (List<CourseMembership>)entityManager.createQuery(hql).getResultList();
			
		}

		
		
		@Override
		public List<Coursetable> getAllCoursesList() {
			// TODO Auto-generated method stub
			String hql = "FROM Coursetable as course ORDER BY course.id";
			return (List<Coursetable>) entityManager.createQuery(hql).getResultList();
			
		}
		
		

		@Override
		public List<CourseGrades>  getCourseGradeDetails(Integer courseId) {
			// TODO Auto-generated method stub
			System.out.println(courseId);
			return entityManager.find(CourseGrades.class, courseId);
			
			
			String hql="From CourseGrades as coursegrade where coursegrade.courseId="+courseId;
			return (List<CourseGrades>)entityManager.createQuery(hql).getResultList();
			
		}

		@Override
		public List<Coursetable> getCourseDetailsById(Integer courseId) {
			// TODO Auto-generated method stub
			String hql="From CourseGrades as coursegrade where coursegrade.courseId="+courseId;
			return (List<Coursetable>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<CourseMembership> getCourseMembersDetails(Integer sdId) 
		{
			// TODO Auto-generated method stub
			String hql="From CourseMembership as coursemember where coursemember.sdId="+sdId;
			return (List<CourseMembership>)entityManager.createQuery(hql).getResultList();
		}
*/
		
		
		
		
		/*@Override
		public void addCourseDetail(Coursetable coursetab) {
			// TODO Auto-generated method stub
			entityManager.persist(coursetab);
		}

		@Override
		public boolean CoursedataExists(int courseId, String name) {
			// TODO Auto-generated method stub
			//String hql = "FROM Coursetable as coursetab WHERE coursetab.courseId ="+courseId;
			
			String hql = "FROM Coursetable as coursetab WHERE coursetab.courseId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, courseId).getResultList().size();
			return count > 0 ;
		}

		@Override
		public List<Coursetable> getCourseTermDetailsById(Integer termId) {
			// TODO Auto-generated method stub
*/			
			/*String hql="SELECT coursetable.courseId, coursetable.name, blackboardTerms.id" "FROM coursetable\n" + 
					"INNER JOIN blackboardTerms\n" + 
					"ON blackboardTerms.id=coursetable.termId;"*/
					
//String hql="select coursetable.courseId,coursetable.name,blackboardTerms.id FROM coursetable INNER JOIN blackboardTerms ON blackboardTerms.id"=+termId" and coursetable.termId"=+termId+"'";

			
		/*String hql=	"select coursetable.courseId,coursetable.name,blackboardTerms.id FROM coursetable INNER JOIN blackboardTerms ON blackboardTerms.id= '"
					+ termId + "'and coursetable.termId ='" + termId+ "'";
return (List<Coursetable>)entityManager.createQuery(hql).getResultList();
			
		}*/

		@Override
		public Discipline getDisciplineById(Integer ownerOrganization) {
			// TODO Auto-generated method stub
			return entityManager.find(Discipline.class, ownerOrganization);
		}

		@Override
		public List<Discipline> getAllDiscipline() {
			// TODO Auto-generated method stub
			String hql = "FROM Discipline as disciplines ORDER BY disciplines.ownerOrganization";
			return (List<Discipline>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void updateDiscipline(Discipline discipline)
		{
			// TODO Auto-generated method stub
			Discipline discipline1 = entityManager.find(com.sag.routes.model.Discipline.class, discipline.getOwnerOrganization());
			discipline1.setLanguage(discipline.getLanguage());
			discipline1.setDescription(discipline.getDescription());
			entityManager.flush();
			
		}

		@Override
		public void deleteDiscipline(Integer getOwnerOrganization) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(com.sag.routes.model.Discipline.class, getOwnerOrganization));
		}

		@Override
		public boolean DisciplineExists(int ownerOrganization, int ownerOrganization2) {
			// TODO Auto-generated method stub
			String hql = "FROM Discipline as discipline WHERE discipline.ownerOrganization = ?";
			int count = entityManager.createQuery(hql).setParameter(1, ownerOrganization).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addDiscipline(Discipline discipline) {
			// TODO Auto-generated method stub
			entityManager.persist(discipline);
		}

		@Override
		public Term FindByTermId(Integer termId) {
			// TODO Auto-generated method stub
			return entityManager.find(Term.class, termId);
		}

		@Override
		public List<Term> getAllTerms() {
			// TODO Auto-generated method stub
			String hql="FROM Term as terms ORDER BY terms.termId";
		    return (List<Term>) entityManager.createQuery(hql).getResultList();
		}

		
		@Override
		public void updateTerms(Term terms)
		{
		Term terms1 =entityManager.find(Term.class, terms.getTermId());
		terms1.setTermName(terms.getTermName());
		terms1.setStartDate(terms.getStartDate());
		terms1.setEndDate(terms.getEndDate());
		entityManager.flush();
			
		}

		@Override
		public void deleteTerms(Integer termId) 
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(com.sag.routes.model.Term.class, termId));
			
		}

		@Override
		public InstitutionalRole getInstitutionById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(InstitutionalRole.class, id);
		}

		@Override
		public List<InstitutionalRole> getAllInstitutionRoles() {
			// TODO Auto-generated method stub
			String hql = "FROM InstitutionalRole as institutionrole ORDER BY institutionrole.id";
			return (List<InstitutionalRole>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void updateInstitution(InstitutionalRole institutionrole)
		{
			// TODO Auto-generated method stub
			InstitutionalRole institutionalRole =entityManager.find(InstitutionalRole.class, institutionrole.getId());
			institutionalRole.setCode(institutionrole.getCode());
			institutionalRole.setEffectiveDate(institutionrole.getEffectiveDate());
			institutionalRole.setEndDate(institutionrole.getEndDate());
			entityManager.flush();
		}
		
		
		

		
		@Override
		public void deleteInstitutionalRole(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(InstitutionalRole.class, id));
		}

		@Override
		public SystemRole getSystemById(Integer systemrole) 
		{
			// TODO Auto-generated method stub
			return entityManager.find(SystemRole.class, systemrole);
			
		}

		@Override
		public List<SystemRole> getSystemRoles() 
		{
			// TODO Auto-generated method stub
			String hql="FROM Systemrole as systemroles ORDER BY systemroles.systemRoleId";
			return (List<SystemRole>) entityManager.createNativeQuery(hql).getResultList();
			
		}

		@Override
		public void updateSystemRole(SystemRole systemrole)
		{
			// TODO Auto-generated method stub
			SystemRole systemrolebkp=entityManager.find(SystemRole.class, systemrole.getSystemRole());
			systemrolebkp.setOrganization(systemrole.getOrganization());
			systemrolebkp.setLanguage(systemrole.getLanguage());
			systemrolebkp.setEffectiveDate(systemrole.getEffectiveDate());
			entityManager.flush();
			
			
		}

		@Override
		public void deleteSystemId(Integer SystemRoleId) 
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(SystemRole.class, SystemRoleId));
			
		}

		@Override
		public void deleteTerm(Integer termId) 
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Term.class, termId));
		}

		
		

		@Override
		public Users getUserById(Integer userid) {
			// TODO Auto-generated method stub
			return entityManager.find(Users.class, userid);
		}

		@Override
		public List<Users> getAllUsers() {
			// TODO Auto-generated method stub
			String hql="FROM Users as user ORDER BY user.userid";
			return (List<Users>) entityManager.createNativeQuery(hql).getResultList();
		}

		@Override
		public void updateUserDetail(Users user) 
		{
			// TODO Auto-generated method stub
			Users users=entityManager.find(Users.class, user.getId());
			users.setEnabled(user.getEnabled());
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			entityManager.flush();
			
		}

		@Override
		public UserEnrollment getUserEnrollById(Integer userid) 
		{
			// TODO Auto-generated method stub
			
			return entityManager.find(UserEnrollment.class, userid);
		}

		@Override
		public List<UserEnrollment> getAllUserEnrolls() {
			// TODO Auto-generated method stub
			String hql="FROM UserEnrollment as userenrollment ORDER BY userenrollment.userid";
			System.out.println(hql);
			return (List<UserEnrollment>) entityManager.createNativeQuery(hql).getResultList();
			
		}

		@Override
		public void updateuserEnrollments(UserEnrollment userenrollment) 
		{
			// TODO Auto-generated method stub
			UserEnrollment userenrollments=entityManager.find(UserEnrollment.class, userenrollment.getUserid());
		      userenrollments.setUsername(userenrollment.getUsername());
			userenrollments.setOrganizations(userenrollment.getOrganizations());
			userenrollments.setPreferredLanguage(userenrollment.getPreferredLanguage());
			entityManager.flush();
		}

		@Override
		public void updateCourse(Course course, Integer courseCode) 
		
		{
			// TODO Auto-generated method stub
			
			Course courses = entityManager.find(Course.class, courseCode);
			courses.setCourseCode(course.getCourseCode());
			courses.setDiscipline(course.getDiscipline());
			courses.setTerm(course.getTerm());
			entityManager.flush();
			
		}

		@Override
		public boolean InstitutionRoleExists(int id, String code) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void addInstitutionRole(InstitutionalRole institutionrole) 
		{
			// TODO Auto-generated method stub
			entityManager.merge(institutionrole);
		
			
		}

		@Override
		public void updateInstitution(InstitutionalRole institutionrole, Integer id) 
		{
			// TODO Auto-generated method stub
			InstitutionalRole institutionroles =entityManager.find(InstitutionalRole.class, id);
			institutionroles.setLanguage(institutionrole.getLanguage());
			institutionroles.setLms(institutionrole.getLms());
			institutionroles.setName(institutionrole.getName());
			entityManager.flush();
		}

		@Override
		public void updateSystemRole(SystemRole systemrole, Integer systemroleId) 
		{
			// TODO Auto-generated method stub
			SystemRole systemrolebkp=entityManager.find(SystemRole.class,systemroleId );
			systemrolebkp.setOrganization(systemrole.getOrganization());
			systemrolebkp.setLanguage(systemrole.getLanguage());
			systemrolebkp.setEffectiveDate(systemrole.getEffectiveDate());
			entityManager.flush();
			
		}

		@Override
		public boolean SystemRoleExists(String roleId, String roleName) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void addSystemRole(SystemRole systemrole) 
		{
			// TODO Auto-generated method stub
			entityManager.merge(systemrole);
		}

		@Override
		public void deleteEnrolledUsers(Integer userid) 
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(UserEnrollment.class, userid));
			
		}

		@Override
		public boolean UserEnrollmentExists(int userid, String username) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void CreateUserEnrollment(UserEnrollment userenroll)
		{
			// TODO Auto-generated method stub
			entityManager.merge(userenroll);
			
		}

		@Override
		public boolean UserExists(long userid, String username) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void CreateUsers(Users user) 
		{
			// TODO Auto-generated method stub
			entityManager.merge(user);
			
		}

		@Override
		public void updateUserDetail(Users user, Integer userid)
		{
			// TODO Auto-generated method stub
			Users users=entityManager.find(Users.class, userid);
			users.setEnabled(user.getEnabled());
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			entityManager.flush();
			
			
		}

		@Override
		public void deleteUser(Integer userid)
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Users.class, userid));
		}

		@Override
		public void updateTermdId(Term terms, Integer termId) 
		{
			// TODO Auto-generated method stub
			Term terms1 =entityManager.find(Term.class, termId);
			terms1.setTermName(terms.getTermName());
			terms1.setStartDate(terms.getStartDate());
			terms1.setEndDate(terms.getEndDate());
			entityManager.flush();
			
		}

		@Override
		public StudentEnroll getStudentEnrollById(Integer userid)
		{
			// TODO Auto-generated method stub
			return entityManager.find(StudentEnroll.class, userid);
		}

		@Override
		public List<StudentEnroll> getAllStudentEnrolls() 
		{
			// TODO Auto-generated method stub
			String hql="FROM UserEnrollment as userenrollment ORDER BY userenrollment.userid";
			System.out.println(hql);
			return (List<StudentEnroll>) entityManager.createNativeQuery(hql).getResultList();
		}

		@Override
		public Announcement getAllAnnouncements(Integer announcementId)
		{
			// TODO Auto-generated method stub
			return entityManager.find(Announcement.class, announcementId);
		}

		@Override
		public List<Announcement> getAllAnnouncements()
		{
			// TODO Auto-generated method stub
			String hql="FROM Announcement as announcements ORDER BY announcements.announcementId";
		return (List<Announcement>) entityManager.createNativeQuery(hql).getResultList();
		
		}

		@Override
		public boolean AnnouncementExists(int announcementId, String announcementname) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void createAnnouncement(Announcement announcement) 
		{
			// TODO Auto-generated method stub
			entityManager.merge(announcement);
		}

		@Override
		public void updateAnnouncement(Announcement announcement) 
		{
			// TODO Auto-generated method stub
			Announcement announce=entityManager.find(Announcement.class,announcement.getAnnouncementId());
			announcement.setAnnouncementname(announcement.getAnnouncementname());
			announce.setCreatedby(announcement.getCreatedby());
			announcement.setLastupdate(announcement.getLastupdate());
			entityManager.flush();
			
		}

		@Override
		public void updateAnnouncementById(Announcement announcement, Integer announcementId) 
		{
			// TODO Auto-generated method stub
			Announcement announce=entityManager.find(Announcement.class,announcementId);
			announcement.setAnnouncementname(announcement.getAnnouncementname());
			announce.setCreatedby(announcement.getCreatedby());
			announcement.setLastupdate(announcement.getLastupdate());
			entityManager.flush();
			
			
		}

		@Override
		public void deleteAnnouncemnetDetails(Integer announcementId) 
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Announcement.class, announcementId));
			
		}

		@Override
		public UserAnnouncementMapping getAllAnnouncementById(Integer announcementId) 
		{
			// TODO Auto-generated method stub
			return entityManager.find(UserAnnouncementMapping.class, announcementId);
		}

		@Override
		public List<UserAnnouncementMapping> getAllUserAnnouncements() 
		{
			// TODO Auto-generated method stub
			String hql="FROM UserAnnouncementMapping as announcements ORDER BY announcements.announcementId";
			return (List<UserAnnouncementMapping>) entityManager.createNativeQuery(hql).getResultList();
			
		}

		@Override
		public ArrayList<ProductData> getAllProductsById(int[] productId) 
		{
			// TODO Auto-generated method stub
			String hql="From ProductData as product where product.productId="+productId;
			return (ArrayList<ProductData>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public UserEnrollment getUserCourseId(Integer userid) 
		{
			// TODO Auto-generated method stub
			return entityManager.find(UserEnrollment.class, userid);
		}

		@Override
		public List<ProductData> getProductData() 
		{
			// TODO Auto-generated method stub
			String hql="FROM ProductData as product ORDER BY product.productId";
			return (List<ProductData>) entityManager.createNativeQuery(hql).getResultList();
		}

		@Override
		public List<UserEnrollment> getAllUserCoursePriviligies() 
		{
			// TODO Auto-generated method stub
			String hql="FROM UserEnrollment as userenrollment ORDER BY userenrollment.announcementId";
			return (List<UserEnrollment>) entityManager.createNativeQuery(hql).getResultList();
		}

		@Override
		public void UpdateuserCoursePriviligies(UserEnrollment userenrollment) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delteuserCoursePriviligies(Integer userid)
		{
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(UserEnrollment.class, userid));
			
			
		}

				}
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		

