package es.anaya.spring.web.s04.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator 
		implements ConstraintValidator<IdConstraint, String> {

  @Override
  public void initialize(IdConstraint id) {
  }

  @Override
  public boolean isValid(String idField, ConstraintValidatorContext cxt) {
    return idField != null 
  		  && idField.matches("[0-9]{8}[a-zA-Z]{1}")
  		  && letterIsCorrect(idField);
  }

  private boolean letterIsCorrect(String idField) {
	String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
	int dni = Integer.parseInt(idField.substring(0,8));
	String letter = idField.substring(8);
		
	dni = dni % letters.length();
	String check = letters.substring(dni,dni+1);
		
	return letter.equalsIgnoreCase(check);
  }

}