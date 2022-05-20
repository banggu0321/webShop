package com.kosta.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosta.dto.DeptDTO;
import com.kosta.util.DBUtil;

//DAO(Data Access Object) : DB�� �����ϴ� Business Logic�ۼ��Ѵ�.
public class DeptDAO {
	
	//1. ��� ��ȸ
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments order by 1";
		
		try {
			st = conn.createStatement(); //��θ���� try/catch�ʿ�
			rs = st.executeQuery(sql); //sql��������
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return deptList;
	}
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		int deptid = rs.getInt(1);
		String deptname = rs.getString(2);
		int mid = rs.getInt(3);
		int loc = rs.getInt(4);
		DeptDTO dept = new DeptDTO(deptid, deptname, mid, loc);
		return dept;
	}
	//2. Ư���μ� ��ȸ(�μ��ڵ�� ��ȸ) 1��, �μ����̵� �����ϱ� int 
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where department_id = "
				+ deptid;
		try {
			st = conn.createStatement(); //��θ���� try/catch�ʿ�
			rs = st.executeQuery(sql); //sql�б�
			if(rs.next()) { //�Ǵ� ��ȸ
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dept;
	}
	//3. �����ڵ�� ��ȸ(���� ������ ����� ��� ��ȸ) locid���ͼ� int
	public List<DeptDTO> selectByLocation(int locid) {
		List<DeptDTO> deptList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where location_id = "
				+ locid
				+ " order by 1";
		
		try {
			st = conn.createStatement(); //��θ���� try/catch�ʿ�
			rs = st.executeQuery(sql); //sql�б�
			while(rs.next()) { //��������ȸ
				DeptDTO dept = makeDept(rs);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return deptList;
	}
	//4. �ű� �μ��Է�
	public int deptInsert(DeptDTO dept) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		int ret = 0; //�Ǽ�
		String sql = "insert into departments values("
				+ dept.getDepartment_id()
				+ ", '"
				+ dept.getDepartment_name()
				+ "', "
				+ dept.getManager_id()
				+ ", "
				+ dept.getLocation_id()
				+ ")";
		try {
			st = conn.createStatement(); //��θ���� try/catch�ʿ�
			ret = st.executeUpdate(sql); //-1(error), 1(insert 1��), 0(insert�Ǽ�����)
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ret;
	}
	//5. Ư���μ� ����
	public int deptUpdate(DeptDTO dept) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		int ret = 0; //�Ǽ�
		String sql = "update departments "
				+ "set DEPARTMENT_NAME='"	+ dept.getDepartment_name()
				+ "', MANAGER_ID="			+ dept.getManager_id()
				+ ", LOCATION_ID="			+ dept.getLocation_id()
				+ " where DEPARTMENT_ID = "	+ dept.getDepartment_id() ;
		try {
			st = conn.createStatement(); //��θ���� try/catch�ʿ�
			ret = st.executeUpdate(sql); //-1(error), 1(insert 1��), 0(insert�Ǽ�����)
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ret;
	}
	//6. Ư���μ� ����
	public int deptDelete(int deptid) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		int ret = 0; //�Ǽ�
		String sql = "delete from departments where department_id = " + deptid;
		try {
			st = conn.createStatement(); //��θ���� try/catch�ʿ�
			ret = st.executeUpdate(sql); //-1(error), 1(insert 1��), 0(insert�Ǽ�����)
		} catch (SQLException e) {
			e.printStackTrace(); //console�����޽���(�����۾�) ����ϰ� ��
		} 
		return ret;
	}
}
