package service;

import java.util.List;

import entity.Room;


public interface RoomDAO {

public List<Room> queryAllRoom();
	
	public Room queryRoomByRno(String rno);
	
	public boolean addRoom(Room r);
	
	public boolean updateRoom(Room d);
	
	public boolean deleteRoom(String rno);
	
	public List<Room> search_Doctor(String search);
	
}
