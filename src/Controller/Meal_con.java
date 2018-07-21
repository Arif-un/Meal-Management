package Controller;

import Model.Meal;

public class Meal_con {

	public static void meal_add(String datemysql, String id_meal, int brk, int lunch, int dinr) {
		
		String naame=Meal.giv_id_get_nam(id_meal);
		
		Meal.add_meal(datemysql,naame, id_meal, brk, lunch, dinr);
		
	}
      
	

}
