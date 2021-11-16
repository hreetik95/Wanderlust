package com.wander.validator;

public class PackageValidator {
	public static boolean validateContinents(String continent) {
		String places[]= {"Europe","Australia","Asia","South America"};
		for(String place:places) {
			if(continent.equalsIgnoreCase(place));
				return true;
		}
		return false;
	}
}
