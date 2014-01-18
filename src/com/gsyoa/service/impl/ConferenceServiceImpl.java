package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.ApplyDAO;
import com.gsyoa.dao.ConferenceDAO;
import com.gsyoa.entity.Apply;
import com.gsyoa.entity.Conference;
import com.gsyoa.service.ConferenceService;

public class ConferenceServiceImpl implements ConferenceService {
	private ConferenceDAO conferenceDAO;
	

	public ConferenceDAO getConferenceDAO() {
		return conferenceDAO;
	}

	public void setConferenceDAO(ConferenceDAO conferenceDAO) {
		this.conferenceDAO = conferenceDAO;
	}

	@Override
	public boolean saveConference(Conference conference) {
		// TODO Auto-generated method stub
		
		return this.conferenceDAO.saveConference(conference);
	}

	@Override
	public boolean deleteConference(int id) {
		// TODO Auto-generated method stub
		return this.conferenceDAO.deleteConference(id);
	}

	@Override
	public Conference SelectConferenceById(int id) {
		// TODO Auto-generated method stub
		return this.conferenceDAO.SelectConferenceById(id);
	}

	@Override
	public List<Conference> SelectAllConference() {
		// TODO Auto-generated method stub
		return this.conferenceDAO.SelectAllConference();
	}

	@Override
	public boolean updateConference(Conference conference) {
		// TODO Auto-generated method stub
		return this.conferenceDAO.updateConference(conference);
	}

}
