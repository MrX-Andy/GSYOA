package com.gsyoa.service.impl;

import java.util.List;

import com.gsyoa.dao.PositionDAO;
import com.gsyoa.entity.Position;
import com.gsyoa.service.PositionService;

public class PositionServiceImpl implements PositionService {
	private PositionDAO positionDAO;
	
	
	public PositionDAO getPositionDAO() {
		return positionDAO;
	}

	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}

	@Override
	public boolean savePosition(Position position) {
		// TODO Auto-generated method stub
		return positionDAO.savePosition(position);
	}

	@Override
	public boolean deletePosition(int id) {
		// TODO Auto-generated method stub
		return positionDAO.deletePosition(id);
	}

	@Override
	public Position SelectPositionById(int id) {
		// TODO Auto-generated method stub
		return positionDAO.SelectPositionById(id);
	}

	@Override
	public List<Position> SelectAllPosition() {
		// TODO Auto-generated method stub
		return positionDAO.SelectAllPosition();
	}

	@Override
	public boolean updatePosition(Position position) {
		// TODO Auto-generated method stub
		return positionDAO.updatePosition(position);
	}

}
