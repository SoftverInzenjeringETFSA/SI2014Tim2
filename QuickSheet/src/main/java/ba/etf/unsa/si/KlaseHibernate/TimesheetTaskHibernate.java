package ba.etf.unsa.si.KlaseHibernate;

public class TimesheetTaskHibernate implements java.io.Serializable {

	private long id;
	private TimesheetHibernate timesheet;
	private TaskHibernate task;
	
	public TimesheetTaskHibernate() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TimesheetHibernate getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimesheetHibernate timesheet) {
		this.timesheet = timesheet;
	}
	public TaskHibernate getTask() {
		return task;
	}
	public void setTask(TaskHibernate task) {
		this.task = task;
	}
}
