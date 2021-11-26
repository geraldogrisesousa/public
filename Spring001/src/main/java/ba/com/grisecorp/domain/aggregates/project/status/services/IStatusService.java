package ba.com.grisecorp.domain.aggregates.project.status.services;

import java.util.List;

import ba.com.grisecorp.domain.aggregates.project.status.Status;

public interface IStatusService {

	public void InsertStatus(Status status);
	
	public void UpdateStatus(Status status);
	
	public void DeleteStatus(int id_status);
	
	public Status DetailStatus(int id_status);
	
	public List<Status> GetAll();
}
