package Controller;

import Model.Mem_info;

public class Mem_info_con {
	public void insert_mem_info(String name, String id, String roll, String reg, String phn, String adress, String path){
		
		String status="Active";
		
		Mem_info Mem_info=new Mem_info();
		Mem_info.insert_mem_info_db(name, id, roll, reg, phn, adress, path,status);
		
	}
	

}
