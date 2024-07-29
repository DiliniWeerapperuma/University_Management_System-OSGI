package lecturerproducer;

public class Lecturer {
	
	String lecturerName, nic, qualification, mobileNo, module;
	

	public Lecturer() {

	}

	public Lecturer(String lecturerName, String nic, String qualification, String mobileNo, String module) {
		super();
		this.lecturerName = lecturerName;
		this.nic = nic;
		this.qualification = qualification;
		this.mobileNo = mobileNo;
		this.module = module;
		
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	

	
	
	

}
