package ba.etf.unsa.si.KlaseHibernate;

public class AdministratorHibernate implements java.io.Serializable {
	
	private long id;
	private String username;
	private String lozinka;
	
	public AdministratorHibernate() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String _username)
	{
		username = _username;	
	}
	
	public String getLozinka()
	{
		return lozinka;
	}
	
	public void setLozinka(String _lozinka)
	{
		lozinka = _lozinka;
	}

	
		
}
