package moduleproducer;

public class Module {
	
	String moduleId, moduleName, credict, medium , moduleFee;
	
	public Module() {

	}

	public Module(String moduleId, String moduleName, String credict, String medium,  String moduleFee) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.credict = credict;
		this.medium = medium;
		this.moduleFee = moduleFee;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getCredict() {
		return credict;
	}

	public void setCredict(String credict) {
		this.credict = credict;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getModuleFee() {
		return moduleFee;
	}

	public void setModuleFee(String moduleFee) {
		this.moduleFee = moduleFee;
	}

}
