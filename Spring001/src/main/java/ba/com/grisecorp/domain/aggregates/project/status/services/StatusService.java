package ba.com.grisecorp.domain.aggregates.project.status.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ba.com.grisecorp.domain.core.Service.GenericService;
import ba.com.grisecorp.domain.aggregates.project.status.Status;
import ba.com.grisecorp.domain.aggregates.project.status.repository.IStatusRepository;

@Service
public class StatusService extends GenericService<Status> implements IStatusService {

	
	@Autowired
	private IStatusRepository _statusRepository;
	
	@Override
	public void InsertStatus(Status status)
	{
		_statusRepository.save(status);
	}

	@Override
	public void UpdateStatus(Status status) 
	{
		_statusRepository.save(status);
	}

	@Override
	public void DeleteStatus(int id_status)
	{
		_statusRepository.deleteById(id_status);
	}
	
	@Override
	public Status DetailStatus(int id_status) 
	{
		return _statusRepository.findById(id_status).get();
	}

	@Override
	public List<Status> GetAll() 
	{
		return getAll(_statusRepository.findAll());
	}

}
