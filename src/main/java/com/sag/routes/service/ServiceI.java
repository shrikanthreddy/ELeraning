package com.sag.routes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sag.routes.controller.MedicalDetailsController;
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
import com.sag.routes.model.Organization;
import com.sag.routes.model.ProductData;
import com.sag.routes.model.School;
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.model.StudentClassMapping;
import com.sag.routes.model.StudentEnroll;
import com.sag.routes.model.SystemRole;
import com.sag.routes.model.Term;
import com.sag.routes.model.UserAnnouncementMapping;
import com.sag.routes.model.UserEnrollment;
import com.sag.routes.model.Users;
import com.sag.routes.model.VehicleDetail;



// Service Interface

public interface ServiceI {

	
	
	//StudentDetails
		
		public Student getStudentById(int id);

		List<Student> getAllStudents();

		boolean addStudent(Student student);

		Student updateStudent(Student student);

		void deleteStudent(Integer id);

		
		
		//StaffDetails
		
		Staff getstaffById(Integer id);

		List<Staff> getAllstaffs();

		boolean addstaff(Staff staff);

		Staff updatestaff(Staff staff);

		void deletestaff(Integer id);
		
		
		//GuardianDetails

		GuardianUser getGuardianById(Integer id);

		List<GuardianUser> getAllGuardians();

		boolean addGuardian(GuardianUser guardian);

		void updateGuardian(GuardianUser guardian);

		void deleteGuardian(Integer id);

		Librarian getLibrarianById(Integer id);

		List<Librarian> getAllLibrarians();

		boolean addLibrarian(Librarian librarian);

		void updateLibrarian(Librarian librarian);

		void deleteLibrarian(Integer id);

		Organization getOrganizationById(Integer oId);

		List<Organization> getAllOrganization();

		boolean addOrganization(Organization organization);

		Organization updateOrganization(Organization organization);

		void deleteOrganization(Integer id);

		School getSchoolById(Integer id);

		List<School> getAllSchool();

		boolean addSchool(School school);

		School updateSchool(School school);

		void deleteSchool(Integer id);

		CampusUser getCampusById(Integer id);

		List<CampusUser> getAllCampuses();

		boolean addCampus(CampusUser campus);

		void updateCampus(CampusUser campus);

		void deleteCampus(Integer id);

		com.sag.routes.model.Class getClassById(Integer id);

		List<Class> getAllClasses();

		boolean addClass(Class class1);

		void updateClass(Class class1);

		void deleteClass(Integer id);

		Course getCourseById(Integer courseCode);

		List<Course> getAllCourses();

		boolean addCourse(Course course);

		void updateCourse(Course course);
		
		void updateCourse(Course course,Integer courseCode);


		Course deleteCourse(Integer id);

		void createattendanceList(int stuid,int classid);

		void createUserContext(int id, int id2);

		void getattendanceList(int stud_id, int class_id);

	    List<AttendanceUser> getattendanceList(int stud_id);

		List<Student> getStudentUserListByCampusId(Integer stud_id);

		List<Student> getStudentListByClassId(Integer classId);

		Student getStudentVehicleDetailsByStudentAdmNum(Integer stdadmissionno);

		Student getStdUserByStdAdmissionNumber(Integer stdadmissionno);

		List<Event > getStudentEventDetailsByStudentUserId(int studUserId);

		VehicleDetail getStudentVehicleDetailsByStudentVehicleId(int vehicleId);

		List<Student> getStudentDetailByStdAdmNum(Integer stdadmissionno);

		List<Staff >getStaffUserListByClassId(Integer classId);
		
		List<Staff> getStaffUserListByCampusId(Integer campusId);
		
		List<Class> getAllClassesByCompusId(Integer campus_id);
		
		List<Books>getBookListByCampusId(Integer campusId );
		
		List<Student>getListOfStudentByCampusIdWhoHasTakenBooks(Integer campus_id,Integer BookId);

		List <Student>getStudentWhoHasReturnBook(Integer campusId);
		DriverUser getdriverdetailsByID(Integer dId);
		
		List<DriverUser> getdriverdetailsByCampusID(Integer campusId);
		
		List<VehicleDetail> getVehicleListByCampusId(Integer campusId);
		
		List<VehicleDetail> getVehicleListByCampusIdDriverId(Integer campusId, Integer driverId);
		
		ExamDetails getExamById(Integer EttId);
		
		List<ExamDetails> getExamDetails();
		
		List<ExamClassMapping> getExamTimeTableByClassId(Integer classId);
		
		List<ClassTimeTable> getClassTimeTableByClassId(Integer classId);
		
		void getSchoolNewsListBySchoolId(Integer id);
		
		void getSchoolListByCampusId(Integer id);
		
		com.sag.routes.model.MedicalDetails getMedicalDetailsById(Integer mid);
		
		List<com.sag.routes.model.MedicalDetails> getMedicalDetails();
		
		boolean addMedicalDetails(com.sag.routes.model.MedicalDetails medical);
		
		void updateMedical(com.sag.routes.model.MedicalDetails medical);
		
		void deleteMedical(Integer id);
		
		Student save(Student student);
		
		List<HolidayList> getHolidayListByCampusId(Integer campusId);
		
        HolidayList getHolidayListById(Integer hId);
        
		Login getLoginById(Integer id);
		
		List<Login> getAllLogins();
		
		/*List<Coursetable> getCourseDetailsById(Integer courseId);
		
		List<CourseAssessment> getCourseAssessmentDetails(Integer courseId,Integer assessmentId);
		
		 List< Coursetable>  getAllCoursesList();
		 
		//List<CourseAssessment> getCourseGradeDetails(Integer courseId, Integer assessmentId);
		
		
		List<CourseGrades> getCourseGradeDetails(Integer courseId);
		
		List<CourseMembership> getCourseMembersDetails(Integer user_id);
		
		boolean addCourse(Coursetable coursetab);
		
		List<Coursetable> getCourseTermDetailsById(Integer termId);*/
		
		Discipline getDisciplineById(Integer ownerOrganization);
		
		List<Discipline> getAllDiscipline();
		
		boolean addDiscipline(Discipline discipline);
		
		Discipline updateDiscipline(Discipline discipline);
		
		void deleteDiscipline(Integer getOwnerOrganization);
		
		Term FindByTermId(Integer termId);
		
		List<Term> getAllTerms();
		
		void updateTerms(Term terms);
		
		void deleteTerms(Integer termId);
		
		InstitutionalRole getInstitutionById(Integer id);
		
		List<InstitutionalRole> getAllInstitutionRoles();
		
		void updateInstitution(InstitutionalRole institutionrole);
		
		
		void deleteInstitutionalRole(Integer id);
		
		SystemRole getSystemById(Integer systemrole);
		
		List<SystemRole> getSystemRoles();
		
		void updateSystemRole(SystemRole systemrole);
		
		void updateSystemRole(SystemRole systemrole,Integer systemroleId );
		
		void deleteSystemId(Integer id);

		 void deleteTerm(Integer termId);

		 Users getUserById(Integer userid);

		 List<Users> getAllUsers();

		 void updateUserDetail(Users user);
		 
		 void updateUserDetail(Users user,Integer userid);

		 UserEnrollment getUserEnrollById(Integer userid);

		 List<UserEnrollment> getAllUserEnrolls();

		 void updateuserEnrollments(UserEnrollment userenrollment);

	 boolean addInstitutionRole(InstitutionalRole institutionrole);

	 void updateInstitution(InstitutionalRole institutionrole, Integer id);

	public boolean CreateSystemRoles(SystemRole systemrole);

 void deleteEnrolledUsers(Integer userid);

 boolean CreateUserEnrollment(UserEnrollment userenroll);

boolean CreateUsers(Users user);

public void deleteUser(Integer userid);

 void updateTermdId(Term terms,Integer termId);

public StudentEnroll getStudentEnrollById(Integer userid);

public List<StudentEnroll> getAllStudentsEnrolls();

public Announcement getAnnouncementById(Integer announcementId);

 List<Announcement> getAllAnnouncements();

public boolean createAnnouncement(Announcement announcement);

 void updateAnnouncement(Announcement announcement);

public void updateAnnouncementById(Announcement announcement, Integer announcementId);

public void deleteAnnouncemnetDetails(Integer announcementId);

public UserAnnouncementMapping getStudentUserAnnouncementById(Integer userid);

public List<UserAnnouncementMapping> getAllUserAnnouncements();

 void updateUserAnnouncement(UserAnnouncementMapping userannounce);

public ArrayList<ProductData> getProductData(int[] ids);

 UserEnrollment getUserCourseId(Integer userid);

 Iterable<ProductData> getProductData();

 List<UserEnrollment> getAllUserCoursePriviligies();

 void UpdateuserCoursePriviligies(UserEnrollment userenrollment);

 void delteuserCoursePriviligies(Integer userid);

 Optional<UserEnrollment> findUserByEmail(String userEmail);

public void saveUser(UserEnrollment user);

 Optional<UserEnrollment> findUserByResetToken(String token);
		
		
}
