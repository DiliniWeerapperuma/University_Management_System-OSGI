package lecturerproducer;

public interface LecturerProducer {
	
	public void RegisterLecturer();

	public void UpdateLecturer(Lecturer lecture);

	public void DeleteLecturer(String lecturerId);

	public void DisplayLecturerList();
	
	public Lecturer getLecturerById(String lecturerId);

}
