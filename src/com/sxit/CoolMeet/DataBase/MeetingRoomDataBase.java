package com.sxit.CoolMeet.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxit.CoolMeet.Entity.MeetingRoom;


public class MeetingRoomDataBase extends BaseDao{
	/**
	 * ͨ�������ұ�Ų�ѯ������
	 * 
	 * @param roomnum
	 * @return
	 * @throws Exception
	 */
	public MeetingRoom findByMeetingRoomNum(int roomnum) throws Exception {
		MeetingRoom mr=null;
		this.openConnection();
		String sql="select * from meetingroom where roomnum=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, roomnum);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			mr=new MeetingRoom();
			mr.setRoomnum(rs.getInt("roomnum"));
			mr.setRoomname(rs.getString("roomname"));
			mr.setRoomStatus(rs.getString("roomstatus"));
			mr.setCapacity(rs.getInt("capacity"));
			mr.setDescription(rs.getString("description"));
		}
		rs.close();
		pst.close();
		return mr;
	}
	/**
	 * ͨ�����������Ʋ�ѯ������
	 * 
	 * @param roomnum
	 * @return
	 * @throws Exception
	 */
	public MeetingRoom findByMeetingRoomName(String roomnum) throws Exception {
		MeetingRoom mr=null;
		this.openConnection();
		String sql="select * from meetingroom where roomname=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, roomnum);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			mr=new MeetingRoom();
			mr.setRoomnum(rs.getInt("roomnum"));
			mr.setRoomname(rs.getString("roomname"));
			mr.setRoomStatus(rs.getString("roomstatus"));
			mr.setCapacity(rs.getInt("capacity"));
			mr.setDescription(rs.getString("description"));
		}
		rs.close();
		pst.close();
		return mr;
	}
	/**
	 * ��ӻ�����
	 * @param roomnum
	 * @param roomname
	 * @param capacity
	 * @param status
	 * @param description
	 * @throws Exception
	 */
	public void addMeetingRoom(int roomnum,String roomname,int capacity,String status,String description) throws Exception{
		this.openConnection();
		String sql="insert into meetingroom(roomnum,roomname,capacity,roomstatus,description) values(?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, roomnum);
		pst.setString(2, roomname);
		pst.setInt(3, capacity);
		pst.setString(4, status);
		pst.setString(5, description);
		pst.execute();
		pst.close();
	}
	/**
	 * ��ѯ����Room����װ�뼯�Ϸ���
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<MeetingRoom> searchRoom() throws Exception{
		List<MeetingRoom> list=new ArrayList<>();
		MeetingRoom mr=null;
		this.openConnection();
		String sql="select * from meetingroom where roomstatus!=2";
		PreparedStatement pst =conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			mr=new MeetingRoom();
			mr.setRoomid(rs.getInt("roomid"));
			mr.setRoomnum(rs.getInt("roomnum"));
			mr.setRoomname(rs.getString("roomname"));
			mr.setCapacity(rs.getInt("capacity"));
			mr.setRoomStatus(rs.getString("roomstatus"));
			mr.setDescription(rs.getString("description"));
			list.add(mr);
		}
		rs.close();
		pst.close();
		return list;
	}
	/**
	 * ͨ��ID��ѯ����������
	 * @return
	 * @throws Exception 
	 */
	public MeetingRoom selectByRoonId(int roomid) throws Exception {
		MeetingRoom mr=null;
		this.openConnection();
		String sql="select * from meetingroom where roomid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, roomid);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			mr=new MeetingRoom();
			mr.setRoomid(rs.getInt("roomid"));
			mr.setRoomnum(rs.getInt("roomnum"));
			mr.setRoomname(rs.getString("roomname"));
			mr.setRoomStatus(rs.getString("roomstatus"));
			mr.setCapacity(rs.getInt("capacity"));
			mr.setDescription(rs.getString("description"));
		}
		rs.close();
		pst.close();
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
		this.openConnection();
		String sql="select count(*) from meeting where meetingstatus='0' and roomid=? and endtime>sysdate()";
		PreparedStatement pst =conn.prepareStatement(sql);
		pst.setInt(1, roomid);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			count=rs.getInt(1);
		}
		rs.close();
		pst.close();
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
		this.openConnection();
		String sql="update meetingroom set roomnum=?,roomname=?,capacity=?,roomstatus=?,description=? where roomid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, roomnum);
		pst.setString(2, roomname);
		pst.setInt(3, capacity);
		pst.setString(4, status);
		pst.setString(5, description);
		pst.setInt(6, roomid);
		pst.execute();
		pst.close();
	}
	/**
	 * ɾ��������
	 * @param roomid
	 * @throws Exception 
	 */
	public void deleteMeetingRoom(int roomid) throws Exception {
		this.openConnection();
		String sql="update meetingroom set roomStatus='2' where roomid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, roomid);
		pst.execute();
		pst.close();
	}
/**
 * ͨ��״̬��ѯ��������Ϣ
 * @param status
 * @return
 * @throws Exception
 */
	public List<MeetingRoom> searchMeetingRoomsByStatus(String status) throws Exception{
		List<MeetingRoom> list=new ArrayList<MeetingRoom>();
		this.openConnection();
		String sql="select * from meetingroom where roomstatus=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, status);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			MeetingRoom mr=new MeetingRoom();
			mr.setRoomid(rs.getInt("roomid"));
			mr.setRoomnum(rs.getInt("roomnum"));
			mr.setRoomname(rs.getString("roomname"));
			mr.setRoomStatus(rs.getString("roomstatus"));
			mr.setCapacity(rs.getInt("capacity"));
			mr.setDescription(rs.getString("description"));
			list.add(mr);
		}
		rs.close();
		pst.close();
		return list;
	}
}

