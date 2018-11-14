package com.sxit.CoolMeet.Service;

import java.util.List;

import com.sxit.CoolMeet.DataBase.MeetingRoomDataBase;
import com.sxit.CoolMeet.Entity.MeetingRoom;

public class MeetingRoomService {
	/**
	 *通过会议室编号查询会议室
	 * @param roomnum
	 * @return
	 * @throws Exception
	 */
	public MeetingRoom findByMeetingRoomNum(int roomnum) throws Exception{
		MeetingRoom mr=null;
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			mr=mrdb.findByMeetingRoomNum(roomnum);
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
		return mr;
	}
	/**
	 * 通过会议室名称查询会议室
	 * @param roomname
	 * @return
	 * @throws Exception
	 */
	public MeetingRoom findByMeetingRoomName(String roomname) throws Exception{
		MeetingRoom mr=null;
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			mr=mrdb.findByMeetingRoomName(roomname);
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
		return mr;
	}
	/**
	 * 添加会议室方法
	 * 
	 * @param roomnum
	 * @param roomname
	 * @param capacity
	 * @param status
	 * @param description
	 * @throws Exception 
	 */
	public void addMeetingRoom(int roomnum,String roomname,int capacity,String status,String description) throws Exception{
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			mrdb.addMeetingRoom(roomnum, roomname, capacity, status, description);
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
	}
	/**
	 * 查找所有会议室对象
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<MeetingRoom> searchRoom() throws Exception{
		List<MeetingRoom> list =null;
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			list=mrdb.searchRoom();
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
		return list;
	}
	/**
	 * 
	 * 通过ID查询会议室详情
	 * @return
	 * @throws Exception 
	 */
	public MeetingRoom selectByRoonId(int roomid) throws Exception {
		MeetingRoom mr=null;
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			mr=mrdb.selectByRoonId(roomid);
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
		return mr;
	}
	/**
	 * 查询会议室是否被占用
	 * 
	 * @return
	 * @throws Exception 
	 */
	public int findRoomByTakeup(int roomid) throws Exception{
		int count=0;
		MeetingRoomDataBase mrd=new  MeetingRoomDataBase();
		try {
			count=mrd.findRoomByTakeup(roomid);
		} catch (Exception e) {
			throw e;
		}finally{
			mrd.closeConnection();
		}
		return count;
	}
	/**
	 * 保存修改会议室
	 * @param roomid
	 * @param roomnum
	 * @param roomname
	 * @param capacity
	 * @param status
	 * @param description
	 * @throws Exception 
	 */
	public void saveMeetingRoom(int roomid,int roomnum,String roomname,int capacity,String status,String description) throws Exception {
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			mrdb.saveMeetingRoom(roomid, roomnum, roomname, capacity, status, description);
		} catch (Exception e) {
			throw e;	
		}finally{
			mrdb.closeConnection();
		}
	}
	/**
	 * 删除会议室
	 * @param roomid
	 * @throws Exception 
	 */
	public void deleteMeetingRoom(int roomid) throws Exception {
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			mrdb.deleteMeetingRoom(roomid);
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
	}
	/**
	 * 通过状态查询会议室信息
	 * @return
	 * @throws Exception 
	 */
	public List<MeetingRoom> searchMeetingRoomsByStatus(String status) throws Exception {
		List<MeetingRoom> list =null;
		MeetingRoomDataBase mrdb=new MeetingRoomDataBase();
		try {
			list=mrdb.searchMeetingRoomsByStatus(status);
		} catch (Exception e) {
			throw e;
		}finally{
			mrdb.closeConnection();
		}
		return list;
	}
}
