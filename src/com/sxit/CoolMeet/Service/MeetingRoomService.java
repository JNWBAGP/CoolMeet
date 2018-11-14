package com.sxit.CoolMeet.Service;

import java.util.List;

import com.sxit.CoolMeet.DataBase.MeetingRoomDataBase;
import com.sxit.CoolMeet.Entity.MeetingRoom;

public class MeetingRoomService {
	/**
	 *ͨ�������ұ�Ų�ѯ������
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
	 * ͨ�����������Ʋ�ѯ������
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
	 * ��ӻ����ҷ���
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
	 * �������л����Ҷ���
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
	 * ͨ��ID��ѯ����������
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
	 * ��ѯ�������Ƿ�ռ��
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
	 * �����޸Ļ�����
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
	 * ɾ��������
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
	 * ͨ��״̬��ѯ��������Ϣ
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
